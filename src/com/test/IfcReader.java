package com.test;
import com.google.common.io.FileBackedOutputStream;
import ifc2x3javatoolbox.demo.IfcSpatialStructure;
import ifc2x3javatoolbox.ifc2x3tc1.*;
import ifc2x3javatoolbox.ifcmodel.IfcModel;
import jline.internal.Log;
import org.apache.commons.io.FileUtils;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.unsafe.batchinsert.BatchInserter;
import org.neo4j.unsafe.batchinsert.BatchInserters;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * 读取ifc文件数据，存入neo4j数据库
 * 读取ifc文件数据，存入elasticsearch
 * 查看propertyset冗余试验
 */

public class IfcReader {

    private static IfcModel ifcModel;
    private static Collection<ClassInterface> ifcObjects;
    private static Map<String, Label> stringLabelMap = new HashMap<>();

    private String ifcFilePath;
    private String dbPath;
    private GraphDatabaseService graphDB = null;

    private FileWriter fileWriter;
    private String path = "D:\\BIMserver1.3.4\\bimserver-clean\\ifc-files\\revitT0Properties.txt";
    int IfcProductCount;


    public IfcReader(String ifcFilePath, String dbPath){
        this.ifcFilePath = ifcFilePath;
        this.dbPath = dbPath;
    }

    public Label getLabel(String ifcTypeStr){
        Label label = stringLabelMap.get(ifcTypeStr);
        if( label == null){
            label = new Label() {
                @Override
                public String name() {
                    return ifcTypeStr;
                }
            };
            stringLabelMap.put(ifcTypeStr, label);
        }
        return label;
    }

    private static enum RelTypes implements RelationshipType {
        IfcRelConnectsElements,
        IfcRelConnectsPathElements,
        IfcRelConnectsWithRealizingElements,
        IfcRelConnectsPortToElement,
        IfcRelConnectsPorts,
        IfcRelConnectsStructuralActivity,
        IfcRelConnectsStructuralElement,
        IfcRelConnectsStructuralMember,
        IfcRelConnectsWithEccentricity,
        IfcRelContainedInSpatialStructure,
        IfcRelCoversBldgElements,
        IfcRelCoversSpaces,
        IfcRelFillsElement,
        IfcRelFlowControlElements,
        IfcRelProjectsElement,
        IfcRelReferencedInSpatialStructure,
        IfcRelSequence,
        IfcRelServicesBuildings,
        IfcRelSpaceBoundary,
        IfcRelVoidsElement,
        IfcRelAggregates,
        IfcRelNests,
        ReferringTo
    }

    private void clearDB(){
        try{
            FileUtils.deleteDirectory(new File(dbPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void generateIfcModel(){
        ifcModel = new IfcModel();
        File file = new File(ifcFilePath);
        try{
            ifcModel.readStepFile(file);
            ifcObjects = ifcModel.getIfcObjects();
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public void storeNodes(){

        clearDB();
        BatchInserter inserter = null;
        try{
            inserter = BatchInserters.inserter(new File(dbPath));
        } catch (IOException e) {
            e.printStackTrace();
        }



//        String ifcFilePath = "D:\\BIMserver1.3.4\\bimserver-clean\\ifc-files\\rac_basic_sample_project.ifc";
//        String txtFilePath = "D:\\BIMserver1.3.4\\bimserver-clean\\ifc-files\\rac_basic_sample_project.txt";

//        String ifcFilePath = "D:\\BIMserver1.3.4\\bimserver-clean\\ifc-files\\Northline_First.ifc";
//        String txtFilePath = "D:\\BIMserver1.3.4\\bimserver-clean\\ifc-files\\Northline_First.txt";

//        String ifcFilePath = "D:\\BIMserver1.3.4\\bimserver-clean\\ifc-files\\Northline_Second.ifc";
//        String txtFilePath = "D:\\BIMserver1.3.4\\bimserver-clean\\ifc-files\\Northline_Second.txt";

//        String ifcFilePath = "D:\\BIMserver1.3.4\\bimserver-clean\\ifc-files\\Northline_Third.ifc";
//        String txtFilePath = "D:\\BIMserver1.3.4\\bimserver-clean\\ifc-files\\Northline_Third.txt";

//        String ifcFilePath = "D:\\BIMserver1.3.4\\bimserver-clean\\ifc-files\\Schultz_Residence.ifc";
//        String txtFilePath = "D:\\BIMserver1.3.4\\bimserver-clean\\ifc-files\\Schultz_Residence.txt";

//        String ifcFilePath = "D:\\BIMserver1.3.4\\bimserver-clean\\ifc-files\\ChongqingSMI20150706.ifc";
//        String txtFilePath = "D:\\BIMserver1.3.4\\bimserver-clean\\ifc-files\\ChongqingSMI20150706.txt";



//        File file1 = new File(txtFilePath);
//        FileWriter fileWriter = null;
//        try {
//            if(file1.exists()){
//                file1.delete();
//            }
//            file1.createNewFile();
//            fileWriter = new FileWriter(file1);
//        } catch (Exception e){
//            e.printStackTrace();
//        }

//        String string = null;



//        String[] ifcRelTypes = {"IfcRelConnectsElements","IfcRelConnectsPathElements","IfcRelConnectsWithRealizingElements","IfcRelConnectsPortToElement",
//                "IfcRelConnectsPorts","IfcRelConnectsStructuralActivity","IfcRelConnectsStructuralElement","IfcRelConnectsStructuralMember","IfcRelConnectsWithEccentricity",
//                "IfcRelContainedInSpatialStructure","","","","","","","","","","","","","","","","","","","","","","",""};



        long time = 0;
        long nodeCount = 0;
        long relationshipCount = 0;
        List<Long> nodeList = new ArrayList<>();

        for(ClassInterface ifcObject : ifcObjects){
            long aID = 0, bID = 0, relID = 0;
            RelTypes relationship = null;
            String aType = null,bType = null, relType = null;
            Map<String, Object> aMap = null;
            Map<String, Object> bMap = null;
            Map<String, Object> relMap = null;
            Map<String, String> aTypeMap = null;
            Map<String, String> bTypeMap = null;
            Map<Long,Map<String,Object>> bMapMap = null;
            Map<Long,Map<String,String>> bMapTypeMap = null;

            relID = ifcObject.getStepLineNumber();
//            if(relID == 672){
//                System.out.println("haha");
//            }

            int flag = 0;

            if(ifcObject instanceof IfcRelConnectsElements){
//                string = new String("IfcRelConnectsElements " + ifcObject.getStepLineNumber() + ":\n"  +  "   RelatingElement:" + ((IfcRelConnectsElements) ifcObject).getRelatingElement().getClass().getSimpleName()
//                        + " " + ((IfcRelConnectsElements) ifcObject).getRelatingElement().getStepLineNumber()  + "\n"
//                        + "   RelatedElement:" + ((IfcRelConnectsElements) ifcObject).getRelatedElement().getClass().getSimpleName()
//                        + " " + ((IfcRelConnectsElements) ifcObject).getRelatedElement().getStepLineNumber() + "\n");
                aID = ((IfcRelConnectsElements) ifcObject).getRelatingElement().getStepLineNumber();
                bID = ((IfcRelConnectsElements) ifcObject).getRelatedElement().getStepLineNumber();
                relID = ifcObject.getStepLineNumber();
                relationship = RelTypes.IfcRelConnectsElements;
                aType = ((IfcRelConnectsElements) ifcObject).getRelatingElement().getClass().getSimpleName();
                bType = ((IfcRelConnectsElements) ifcObject).getRelatedElement().getClass().getSimpleName();
                relType = "IfcRelConnectsElements";
//                aMap  = new HashMap<>();
//                bMap = new HashMap<>();
//                relMap = new HashMap<>();
//                aMap.put("type", aType);
//                bMap.put("type", bType);
//                relMap.put("type", relType);
                aTypeMap  = new HashMap<>();
                bTypeMap = new HashMap<>();
                aTypeMap.put("type", aType);
                bTypeMap.put("type", bType);
                aMap = getMap(((IfcRelConnectsElements) ifcObject).getRelatingElement());
                bMap = getMap(((IfcRelConnectsElements) ifcObject).getRelatedElement());
                flag = 1;
            } else if(ifcObject instanceof IfcRelConnectsPathElements){
//                string = new String("IfcRelConnectsPathElements " + ifcObject.getStepLineNumber() + ":\n"  +  "   RelatingElement:" + ((IfcRelConnectsPathElements) ifcObject).getRelatingElement().getClass().getSimpleName()
//                        + " " + ((IfcRelConnectsPathElements) ifcObject).getRelatingElement().getStepLineNumber()  + "\n"
//                        + "   RelatedElement:" + ((IfcRelConnectsPathElements) ifcObject).getRelatedElement().getClass().getSimpleName()
//                        + " " + ((IfcRelConnectsPathElements) ifcObject).getRelatedElement().getStepLineNumber() + "\n");
                aID = ((IfcRelConnectsPathElements) ifcObject).getRelatingElement().getStepLineNumber();
                bID = ((IfcRelConnectsPathElements) ifcObject).getRelatedElement().getStepLineNumber();
                relID = ifcObject.getStepLineNumber();
                relationship = RelTypes.IfcRelConnectsPathElements;
                aType = ((IfcRelConnectsPathElements) ifcObject).getRelatingElement().getClass().getSimpleName();
                bType = ((IfcRelConnectsPathElements) ifcObject).getRelatedElement().getClass().getSimpleName();
                relType = "IfcRelConnectsPathElements";
//                aMap  = new HashMap<>();
//                bMap = new HashMap<>();
//                relMap = new HashMap<>();
//                aMap.put("type", aType);
//                bMap.put("type", bType);
//                relMap.put("type", relType);
                aTypeMap  = new HashMap<>();
                bTypeMap = new HashMap<>();
                aTypeMap.put("type", aType);
                bTypeMap.put("type", bType);
                aMap = getMap(((IfcRelConnectsPathElements) ifcObject).getRelatingElement());
                bMap = getMap(((IfcRelConnectsPathElements) ifcObject).getRelatedElement());
                flag = 1;
            } else if(ifcObject instanceof IfcRelConnectsWithRealizingElements) {
//                string = new String("IfcRelConnectsWithRealizingElements " + ifcObject.getStepLineNumber() + ":\n" + "   RelatingElement:" + ((IfcRelConnectsWithRealizingElements) ifcObject).getRelatingElement().getClass().getSimpleName()
//                        + " " + ((IfcRelConnectsWithRealizingElements) ifcObject).getRelatingElement().getStepLineNumber() + "\n"
//                        + "   RelatedElement:" + ((IfcRelConnectsWithRealizingElements) ifcObject).getRelatedElement().getClass().getSimpleName()
//                        + " " + ((IfcRelConnectsWithRealizingElements) ifcObject).getRelatedElement().getStepLineNumber() + "\n");
//                        + "   RealizingElement:" + ((IfcRelConnectsWithRealizingElements) ifcObject).getRealizingElements() //a set
                aID = ((IfcRelConnectsWithRealizingElements) ifcObject).getRelatingElement().getStepLineNumber();
                bID = ((IfcRelConnectsWithRealizingElements) ifcObject).getRelatedElement().getStepLineNumber();
                relID = ifcObject.getStepLineNumber();
                relationship = RelTypes.IfcRelConnectsWithRealizingElements;
                aType = ((IfcRelConnectsWithRealizingElements) ifcObject).getRelatingElement().getClass().getSimpleName();
                bType = ((IfcRelConnectsWithRealizingElements) ifcObject).getRelatedElement().getClass().getSimpleName();
                relType = "IfcRelConnectsWithRealizingElements";
//                aMap  = new HashMap<>();
//                bMap = new HashMap<>();
//                relMap = new HashMap<>();
//                aMap.put("type", aType);
//                bMap.put("type", bType);
//                relMap.put("type", relType);
                aTypeMap  = new HashMap<>();
                bTypeMap = new HashMap<>();
                aTypeMap.put("type", aType);
                bTypeMap.put("type", bType);
                aMap = getMap(((IfcRelConnectsWithRealizingElements) ifcObject).getRelatingElement());
                bMap = getMap(((IfcRelConnectsWithRealizingElements) ifcObject).getRelatedElement());
                flag = 1;
            } else if(ifcObject instanceof IfcRelConnectsPortToElement) {
//                string = new String("IfcRelConnectsPortToElement " + ifcObject.getStepLineNumber() + ":\n" + "   RelatingPort:" + ((IfcRelConnectsPortToElement) ifcObject).getRelatingPort().getClass().getSimpleName()
//                        + " " + ((IfcRelConnectsPortToElement) ifcObject).getRelatingPort().getStepLineNumber() + "\n"
//                        + "   RelatedElement:" + ((IfcRelConnectsPortToElement) ifcObject).getRelatedElement().getClass().getSimpleName()
//                        + " " + ((IfcRelConnectsPortToElement) ifcObject).getRelatedElement().getStepLineNumber() + "\n");
                aID = ((IfcRelConnectsPortToElement) ifcObject).getRelatingPort().getStepLineNumber();
                bID = ((IfcRelConnectsPortToElement) ifcObject).getRelatedElement().getStepLineNumber();
                relID = ifcObject.getStepLineNumber();
                relationship = RelTypes.IfcRelConnectsPortToElement;
                aType = ((IfcRelConnectsPortToElement) ifcObject).getRelatingPort().getClass().getSimpleName();
                bType = ((IfcRelConnectsPortToElement) ifcObject).getRelatedElement().getClass().getSimpleName();
                relType = "IfcRelConnectsPortToElement";
//                aMap  = new HashMap<>();
//                bMap = new HashMap<>();
//                relMap = new HashMap<>();
//                aMap.put("type", aType);
//                bMap.put("type", bType);
//                relMap.put("type", relType);
                aTypeMap  = new HashMap<>();
                bTypeMap = new HashMap<>();
                aTypeMap.put("type", aType);
                bTypeMap.put("type", bType);
                aMap = getMap(((IfcRelConnectsPortToElement) ifcObject).getRelatingPort());
                bMap = getMap(((IfcRelConnectsPortToElement) ifcObject).getRelatedElement());
                flag = 1;
            } else if(ifcObject instanceof IfcRelConnectsPorts) {
//                string = new String("IfcRelConnectsPorts " + ifcObject.getStepLineNumber() + ":\n" + "   RelatingPort:" + ((IfcRelConnectsPorts) ifcObject).getRelatingPort().getClass().getSimpleName()
//                        + " " + ((IfcRelConnectsPorts) ifcObject).getRelatingPort().getStepLineNumber() + "\n"
//                        + "   RelatedPort:" + ((IfcRelConnectsPorts) ifcObject).getRelatedPort().getClass().getSimpleName()
//                        + " " + ((IfcRelConnectsPorts) ifcObject).getRelatedPort().getStepLineNumber() + "\n");
                aID = ((IfcRelConnectsPorts) ifcObject).getRelatingPort().getStepLineNumber();
                bID = ((IfcRelConnectsPorts) ifcObject).getRelatedPort().getStepLineNumber();
                relID = ifcObject.getStepLineNumber();
                relationship = RelTypes.IfcRelConnectsPorts;
                aType = ((IfcRelConnectsPorts) ifcObject).getRelatingPort().getClass().getSimpleName();
                bType = ((IfcRelConnectsPorts) ifcObject).getRelatedPort().getClass().getSimpleName();
                relType = "IfcRelConnectsPorts";
//                aMap  = new HashMap<>();
//                bMap = new HashMap<>();
//                relMap = new HashMap<>();
//                aMap.put("type", aType);
//                bMap.put("type", bType);
//                relMap.put("type", relType);
                aTypeMap  = new HashMap<>();
                bTypeMap = new HashMap<>();
                aTypeMap.put("type", aType);
                bTypeMap.put("type", bType);
                aMap = getMap(((IfcRelConnectsPorts) ifcObject).getRelatingPort());
                bMap = getMap(((IfcRelConnectsPorts) ifcObject).getRelatedPort());
                flag = 1;
            } else if(ifcObject instanceof IfcRelConnectsStructuralActivity) {
//                string = new String("IfcRelConnectsStructuralActivity " + ifcObject.getStepLineNumber() + ":\n" + "   RelatingElement:" + ((IfcRelConnectsStructuralActivity) ifcObject).getRelatingElement().getClass().getSimpleName()
//                        + "\n" //û��StepLineNumber
//                        + "   RelatedStructuralActivity:" + ((IfcRelConnectsStructuralActivity) ifcObject).getRelatedStructuralActivity().getClass().getSimpleName()
//                        + " " + ((IfcRelConnectsStructuralActivity) ifcObject).getRelatedStructuralActivity().getStepLineNumber() + "\n");
//
                flag = 1;
            } else if(ifcObject instanceof IfcRelConnectsStructuralElement) {
//                string = new String("IfcRelConnectsStructuralElement " + ifcObject.getStepLineNumber() + ":\n" + "   RelatingElement:" + ((IfcRelConnectsStructuralElement) ifcObject).getRelatingElement().getClass().getSimpleName()
//                        + " " + ((IfcRelConnectsStructuralElement) ifcObject).getRelatingElement().getStepLineNumber() + "\n"
//                        + "   RelatedStructuralMember:" + ((IfcRelConnectsStructuralElement) ifcObject).getRelatedStructuralMember().getClass().getSimpleName()
//                        + " " + ((IfcRelConnectsStructuralElement) ifcObject).getRelatedStructuralMember().getStepLineNumber() + "\n");
                aID = ((IfcRelConnectsStructuralElement) ifcObject).getRelatingElement().getStepLineNumber();
                bID = ((IfcRelConnectsStructuralElement) ifcObject).getRelatedStructuralMember().getStepLineNumber();
                relID = ifcObject.getStepLineNumber();
                relationship = RelTypes.IfcRelConnectsStructuralElement;
                aType = ((IfcRelConnectsStructuralElement) ifcObject).getRelatingElement().getClass().getSimpleName();
                bType = ((IfcRelConnectsStructuralElement) ifcObject).getRelatedStructuralMember().getClass().getSimpleName();
                relType = "IfcRelConnectsStructuralElement";
//                aMap  = new HashMap<>();
//                bMap = new HashMap<>();
//                relMap = new HashMap<>();
//                aMap.put("type", aType);
//                bMap.put("type", bType);
//                relMap.put("type", relType);
                aTypeMap  = new HashMap<>();
                bTypeMap = new HashMap<>();
                aTypeMap.put("type", aType);
                bTypeMap.put("type", bType);
                aMap = getMap(((IfcRelConnectsStructuralElement) ifcObject).getRelatingElement());
                bMap = getMap(((IfcRelConnectsStructuralElement) ifcObject).getRelatedStructuralMember());
                flag = 1;
            } else if(ifcObject instanceof IfcRelConnectsStructuralMember) {
//                string = new String("IfcRelConnectsStructuralMember " + ifcObject.getStepLineNumber() + ":\n" + "   RelatingStructuralMember:" + ((IfcRelConnectsStructuralMember) ifcObject).getRelatingStructuralMember().getClass().getSimpleName()
//                        + " " + ((IfcRelConnectsStructuralMember) ifcObject).getRelatingStructuralMember().getStepLineNumber() + "\n"
//                        + "   RelatedStructuralConnection:" + ((IfcRelConnectsStructuralMember) ifcObject).getRelatedStructuralConnection().getClass().getSimpleName()
//                        + " " + ((IfcRelConnectsStructuralMember) ifcObject).getRelatedStructuralConnection().getStepLineNumber() + "\n");
                aID = ((IfcRelConnectsStructuralMember) ifcObject).getRelatingStructuralMember().getStepLineNumber();
                bID = ((IfcRelConnectsStructuralMember) ifcObject).getRelatedStructuralConnection().getStepLineNumber();
                relID = ifcObject.getStepLineNumber();
                relationship = RelTypes.IfcRelConnectsStructuralMember;
                aType = ((IfcRelConnectsStructuralMember) ifcObject).getRelatingStructuralMember().getClass().getSimpleName();
                bType = ((IfcRelConnectsStructuralMember) ifcObject).getRelatedStructuralConnection().getClass().getSimpleName();
                relType = "IfcRelConnectsStructuralMember";
//                aMap  = new HashMap<>();
//                bMap = new HashMap<>();
//                relMap = new HashMap<>();
//                aMap.put("type", aType);
//                bMap.put("type", bType);
//                relMap.put("type", relType);
                aTypeMap  = new HashMap<>();
                bTypeMap = new HashMap<>();
                aTypeMap.put("type", aType);
                bTypeMap.put("type", bType);
                aMap = getMap(((IfcRelConnectsStructuralMember) ifcObject).getRelatingStructuralMember());
                bMap = getMap(((IfcRelConnectsStructuralMember) ifcObject).getRelatedStructuralConnection());
                flag = 1;
            } else if(ifcObject instanceof IfcRelConnectsWithEccentricity) {
//                string = new String("IfcRelConnectsWithEccentricity " + ifcObject.getStepLineNumber() + ":\n" + "   RelatingStructuralMember:" + ((IfcRelConnectsWithEccentricity) ifcObject).getRelatingStructuralMember().getClass().getSimpleName()
//                        + " " + ((IfcRelConnectsWithEccentricity) ifcObject).getRelatingStructuralMember().getStepLineNumber() + "\n"
//                        + "   RelatedStructuralConnection:" + ((IfcRelConnectsWithEccentricity) ifcObject).getRelatedStructuralConnection().getClass().getSimpleName()
//                        + " " + ((IfcRelConnectsWithEccentricity) ifcObject).getRelatedStructuralConnection().getStepLineNumber() + "\n");
                aID = ((IfcRelConnectsWithEccentricity) ifcObject).getRelatingStructuralMember().getStepLineNumber();
                bID = ((IfcRelConnectsWithEccentricity) ifcObject).getRelatedStructuralConnection().getStepLineNumber();
                relID = ifcObject.getStepLineNumber();
                relationship = RelTypes.IfcRelConnectsWithEccentricity;
                aType = ((IfcRelConnectsWithEccentricity) ifcObject).getRelatingStructuralMember().getClass().getSimpleName();
                bType = ((IfcRelConnectsWithEccentricity) ifcObject).getRelatedStructuralConnection().getClass().getSimpleName();
                relType = "IfcRelConnectsWithEccentricity";
//                aMap  = new HashMap<>();
//                bMap = new HashMap<>();
//                relMap = new HashMap<>();
//                aMap.put("type", aType);
//                bMap.put("type", bType);
//                relMap.put("type", relType);
                aTypeMap  = new HashMap<>();
                bTypeMap = new HashMap<>();
                aTypeMap.put("type", aType);
                bTypeMap.put("type", bType);
                aMap = getMap(((IfcRelConnectsWithEccentricity) ifcObject).getRelatingStructuralMember());
                bMap = getMap(((IfcRelConnectsWithEccentricity) ifcObject).getRelatedStructuralConnection());
                flag = 1;
            } else if(ifcObject instanceof IfcRelContainedInSpatialStructure) {
//                string = new String("IfcRelContainedInSpatialStructure " + ifcObject.getStepLineNumber() + ":\n" + "   RelatingStructure:" + ((IfcRelContainedInSpatialStructure) ifcObject).getRelatingStructure().getClass().getSimpleName()
//                        + " " + ((IfcRelContainedInSpatialStructure) ifcObject).getRelatingStructure().getStepLineNumber() + "\n"
//                        + "   RelatedElements:" );
                aID = ((IfcRelContainedInSpatialStructure) ifcObject).getRelatingStructure().getStepLineNumber();
                aType = ((IfcRelContainedInSpatialStructure) ifcObject).getRelatingStructure().getClass().getSimpleName();
                relID = ifcObject.getStepLineNumber();
                relationship = RelTypes.IfcRelContainedInSpatialStructure;
                relType = "IfcRelConnectsWithEccentricity";
//                aMap  = new HashMap<>();
//                relMap = new HashMap<>();
                bMapMap = new HashMap<>();
                bMapTypeMap = new HashMap<>();
//                aMap.put("type", aType);
//                relMap.put("type", relType);
                aTypeMap  = new HashMap<>();
                aTypeMap.put("type", aType);
                aMap = getMap(((IfcRelContainedInSpatialStructure) ifcObject).getRelatingStructure());
                Iterator<IfcProduct> ifcProductIterator = ((IfcRelContainedInSpatialStructure) ifcObject).getRelatedElements().iterator();
                while(ifcProductIterator.hasNext()){
                    IfcProduct ifcProduct = ifcProductIterator.next();
//                    string = string + ifcProduct.getClass().getSimpleName() + " " + ifcProduct.getStepLineNumber() + " ";
                    bID =  ifcProduct.getStepLineNumber();
                    bType = ifcProduct.getClass().getSimpleName();
//                    bMap = new HashMap<>();
//                    bMap.put("type", bType);
                    bTypeMap = new HashMap<>();
                    bTypeMap.put("type", bType);
                    bMapTypeMap.put(bID,bTypeMap);
                    bMap  =getMap(ifcProduct);
                    bMapMap.put(bID,bMap);
                }
                flag = 2;
//                string = string + "\n";
            } else if(ifcObject instanceof IfcRelCoversBldgElements) {
//                string = new String("IfcRelCoversBldgElements " + ifcObject.getStepLineNumber() + ":\n" + "   RelatingBuildingElement:" + ((IfcRelCoversBldgElements) ifcObject).getRelatingBuildingElement().getClass().getSimpleName()
//                        + " " + ((IfcRelCoversBldgElements) ifcObject).getRelatingBuildingElement().getStepLineNumber() + "\n"
//                        + "   RelatedCoverings:" );
                aID = ((IfcRelCoversBldgElements) ifcObject).getRelatingBuildingElement().getStepLineNumber();
                aType = ((IfcRelCoversBldgElements) ifcObject).getRelatingBuildingElement().getClass().getSimpleName();
                relID = ifcObject.getStepLineNumber();
                relationship = RelTypes.IfcRelCoversBldgElements;
                relType = "IfcRelCoversBldgElements";
//                aMap = new HashMap<>();
//                aMap.put("type", aType);
//                relMap = new HashMap<>();
//                relMap.put("type", relType);
                aTypeMap  = new HashMap<>();
                aTypeMap.put("type", aType);
                aMap = getMap(((IfcRelCoversBldgElements) ifcObject).getRelatingBuildingElement());
                bMapMap = new HashMap<>();
                bMapTypeMap = new HashMap<>();
                Iterator<IfcCovering> ifcCoveringIterator = ((IfcRelCoversBldgElements) ifcObject).getRelatedCoverings().iterator();
                while(ifcCoveringIterator.hasNext()){
                    IfcCovering ifcCovering = ifcCoveringIterator.next();
//                    string = string + ifcCovering.getClass().getSimpleName() + " " + ifcCovering.getStepLineNumber() + " ";
                    bID =  ifcCovering.getStepLineNumber();
                    bType = ifcCovering.getClass().getSimpleName();
//                    bMap = new HashMap<>();
//                    bMap.put("type", bType);
                    bTypeMap = new HashMap<>();
                    bTypeMap.put("type", bType);
                    bMapTypeMap.put(bID,bTypeMap);
                    bMap = getMap(ifcCovering);
                    bMapMap.put(bID,bMap);
                }
                flag = 2;
//                string = string + "\n";
            } else if(ifcObject instanceof IfcRelCoversSpaces) {
//                string = new String("IfcRelCoversSpaces " + ifcObject.getStepLineNumber() + ":\n" + "   RelatedSpace:" + ((IfcRelCoversSpaces) ifcObject).getRelatedSpace().getClass().getSimpleName()
//                        + " " + ((IfcRelCoversSpaces) ifcObject).getRelatedSpace().getStepLineNumber() + "\n"
//                        + "   RelatedCoverings:" );
                aID = ((IfcRelCoversSpaces) ifcObject).getRelatedSpace().getStepLineNumber();
                aType = ((IfcRelCoversSpaces) ifcObject).getRelatedSpace().getClass().getSimpleName();
                relID = ifcObject.getStepLineNumber();
                relationship = RelTypes.IfcRelCoversSpaces;
                relType = "IfcRelCoversSpaces";
//                aMap = new HashMap<>();
//                aMap.put("type", aType);
//                relMap = new HashMap<>();
//                relMap.put("type", relType);
                aTypeMap  = new HashMap<>();
                aTypeMap.put("type", aType);
                aMap = getMap(((IfcRelCoversSpaces) ifcObject).getRelatedSpace());
                bMapMap = new HashMap<>();
                bMapTypeMap = new HashMap<>();
                Iterator<IfcCovering> ifcCoveringIterator = ((IfcRelCoversSpaces) ifcObject).getRelatedCoverings().iterator();
                while(ifcCoveringIterator.hasNext()){
                    IfcCovering ifcCovering = ifcCoveringIterator.next();
//                    string = string + ifcCovering.getClass().getSimpleName() + " " + ifcCovering.getStepLineNumber() + " ";
                    bID =  ifcCovering.getStepLineNumber();
                    bType = ifcCovering.getClass().getSimpleName();
//                    bMap = new HashMap<>();
//                    bMap.put("type", bType);
                    bTypeMap = new HashMap<>();
                    bTypeMap.put("type", bType);
                    bMapTypeMap.put(bID,bTypeMap);
                    bMap = getMap(ifcCovering);
                    bMapMap.put(bID,bMap);
                }
                flag = 2;
//                string = string + "\n";
            } else if(ifcObject instanceof IfcRelFillsElement) {
//                string = new String("IfcRelFillsElement " + ifcObject.getStepLineNumber() + ":\n" + "   RelatingOpeningElement:" + ((IfcRelFillsElement) ifcObject).getRelatingOpeningElement().getClass().getSimpleName()
//                        + " " + ((IfcRelFillsElement) ifcObject).getRelatingOpeningElement().getStepLineNumber() + "\n"
//                        + "   RelatedBuildingElement:" + ((IfcRelFillsElement) ifcObject).getRelatedBuildingElement().getClass().getSimpleName()
//                        + " " + ((IfcRelFillsElement) ifcObject).getRelatedBuildingElement().getStepLineNumber() + "\n");
                aID = ((IfcRelFillsElement) ifcObject).getRelatingOpeningElement().getStepLineNumber();
                bID = ((IfcRelFillsElement) ifcObject).getRelatedBuildingElement().getStepLineNumber();
                relID = ifcObject.getStepLineNumber();
                relationship = RelTypes.IfcRelFillsElement;
                aType = ((IfcRelFillsElement) ifcObject).getRelatingOpeningElement().getClass().getSimpleName();
                bType = ((IfcRelFillsElement) ifcObject).getRelatedBuildingElement().getClass().getSimpleName();
                relType = "IfcRelFillsElement";
//                aMap  = new HashMap<>();
//                bMap = new HashMap<>();
//                relMap = new HashMap<>();
//                aMap.put("type", aType);
//                bMap.put("type", bType);
//                relMap.put("type", relType);
                aTypeMap  = new HashMap<>();
                bTypeMap = new HashMap<>();
                aTypeMap.put("type", aType);
                bTypeMap.put("type", bType);
                aMap = getMap(((IfcRelFillsElement) ifcObject).getRelatingOpeningElement());
                bMap = getMap(((IfcRelFillsElement) ifcObject).getRelatedBuildingElement());
                flag = 1;
            } else if(ifcObject instanceof IfcRelFlowControlElements) {
//                string = new String("IfcRelFlowControlElements " + ifcObject.getStepLineNumber() + ":\n" + "   RelatingFlowElement :" + ((IfcRelFlowControlElements) ifcObject).getRelatingFlowElement().getClass().getSimpleName()
//                        + " " + ((IfcRelFlowControlElements) ifcObject).getRelatingFlowElement().getStepLineNumber() + "\n"
//                        + "   RelatedControlElements:" );
                aID = ((IfcRelFlowControlElements) ifcObject).getRelatingFlowElement().getStepLineNumber();
                aType = ((IfcRelFlowControlElements) ifcObject).getRelatingFlowElement().getClass().getSimpleName();
                relID = ifcObject.getStepLineNumber();
                relationship = RelTypes.IfcRelFlowControlElements;
                relType = "IfcRelFlowControlElements";
//                aMap = new HashMap<>();
//                aMap.put("type", aType);
//                relMap = new HashMap<>();
//                relMap.put("type", relType);
                aTypeMap  = new HashMap<>();
                aTypeMap.put("type", aType);
                aMap = getMap(((IfcRelFlowControlElements) ifcObject).getRelatingFlowElement());
                bMapMap = new HashMap<>();
                bMapTypeMap = new HashMap<>();
                Iterator<IfcDistributionControlElement> ifcDistributionControlElementIterator = ((IfcRelFlowControlElements) ifcObject).getRelatedControlElements().iterator();
                while(ifcDistributionControlElementIterator.hasNext()){
                    IfcDistributionControlElement ifcDistributionControlElement = ifcDistributionControlElementIterator.next();
//                    string = string + ifcDistributionControlElement.getClass().getSimpleName() + " " + ifcDistributionControlElement.getStepLineNumber() + " ";
                    bID =  ifcDistributionControlElement.getStepLineNumber();
                    bType = ifcDistributionControlElement.getClass().getSimpleName();
//                    bMap = new HashMap<>();
//                    bMap.put("type", bType);
                    bTypeMap = new HashMap<>();
                    bTypeMap.put("type", bType);
                    bMapTypeMap.put(bID,bTypeMap);
                    bMap = getMap(ifcDistributionControlElement);
                    bMapMap.put(bID,bMap);
                }
                flag = 2;
//                string = string + "\n";
            } else if(ifcObject instanceof IfcRelProjectsElement) {
//                string = new String("IfcRelProjectsElement " + ifcObject.getStepLineNumber() + ":\n" + "   RelatingElement  :" + ((IfcRelProjectsElement) ifcObject).getRelatingElement().getClass().getSimpleName()
//                        + " " + ((IfcRelProjectsElement) ifcObject).getRelatingElement().getStepLineNumber() + "\n"
//                        + "   RelatedFeatureElement:" + ((IfcRelProjectsElement) ifcObject).getRelatedFeatureElement().getClass().getSimpleName()
//                        + " " + ((IfcRelProjectsElement) ifcObject).getRelatedFeatureElement().getStepLineNumber() + "\n");
                aID = ((IfcRelProjectsElement) ifcObject).getRelatingElement().getStepLineNumber();
                bID = ((IfcRelProjectsElement) ifcObject).getRelatedFeatureElement().getStepLineNumber();
                relID = ifcObject.getStepLineNumber();
                relationship = RelTypes.IfcRelProjectsElement;
                aType = ((IfcRelProjectsElement) ifcObject).getRelatingElement().getClass().getSimpleName();
                bType = ((IfcRelProjectsElement) ifcObject).getRelatedFeatureElement().getClass().getSimpleName();
                relType = "IfcRelProjectsElement";
//                aMap  = new HashMap<>();
//                bMap = new HashMap<>();
//                relMap = new HashMap<>();
//                aMap.put("type", aType);
//                bMap.put("type", bType);
//                relMap.put("type", relType);
                aTypeMap  = new HashMap<>();
                bTypeMap = new HashMap<>();
                aTypeMap.put("type", aType);
                bTypeMap.put("type", bType);
                aMap = getMap(((IfcRelProjectsElement) ifcObject).getRelatingElement());
                bMap = getMap(((IfcRelProjectsElement) ifcObject).getRelatedFeatureElement());
                flag = 1;
            } else if(ifcObject instanceof IfcRelReferencedInSpatialStructure) {
//                string = new String("IfcRelReferencedInSpatialStructure " + ifcObject.getStepLineNumber() + ":\n" + "   RelatingStructure :" + ((IfcRelReferencedInSpatialStructure) ifcObject).getRelatingStructure().getClass().getSimpleName()
//                        + " " + ((IfcRelReferencedInSpatialStructure) ifcObject).getRelatingStructure().getStepLineNumber() + "\n"
//                        + "   RelatedElements:");
                aID = ((IfcRelReferencedInSpatialStructure) ifcObject).getRelatingStructure().getStepLineNumber();
                aType = ((IfcRelReferencedInSpatialStructure) ifcObject).getRelatingStructure().getClass().getSimpleName();
                relID = ifcObject.getStepLineNumber();
                relationship = RelTypes.IfcRelReferencedInSpatialStructure;
                relType = "IfcRelReferencedInSpatialStructure";
//                aMap = new HashMap<>();
//                aMap.put("type", aType);
//                relMap = new HashMap<>();
//                relMap.put("type", relType);
                aTypeMap  = new HashMap<>();
                aTypeMap.put("type", aType);
                aMap = getMap(((IfcRelReferencedInSpatialStructure) ifcObject).getRelatingStructure());
                bMapMap = new HashMap<>();
                bMapTypeMap = new HashMap<>();
                Iterator<IfcProduct> ifcProductIterator = ((IfcRelReferencedInSpatialStructure) ifcObject).getRelatedElements().iterator();
                while (ifcProductIterator.hasNext()) {
                    IfcProduct ifcProduct = ifcProductIterator.next();
//                    string = string + ifcProduct.getClass().getSimpleName() + " " + ifcProduct.getStepLineNumber() + " ";
                    bID =  ifcProduct.getStepLineNumber();
                    bType = ifcProduct.getClass().getSimpleName();
//                    bMap = new HashMap<>();
//                    bMap.put("type", bType);
                    bTypeMap = new HashMap<>();
                    bTypeMap.put("type", bType);
                    bMapTypeMap.put(bID,bTypeMap);
                    bMap = getMap(ifcProduct);
                    bMapMap.put(bID,bMap);
                }
                flag = 2;
//                string = string + "\n";
            } else if(ifcObject instanceof IfcRelSequence) {
//                string = new String("IfcRelSequence " + ifcObject.getStepLineNumber() + ":\n" + "   RelatingProcess :" + ((IfcRelSequence) ifcObject).getRelatingProcess().getClass().getSimpleName()
//                        + " " + ((IfcRelSequence) ifcObject).getRelatingProcess().getStepLineNumber() + "\n"
//                        + "   RelatedProcess:" + ((IfcRelSequence) ifcObject).getRelatedProcess().getClass().getSimpleName()
//                        + " " + ((IfcRelSequence) ifcObject).getRelatedProcess().getStepLineNumber() + "\n");
                aID = ((IfcRelSequence) ifcObject).getRelatingProcess().getStepLineNumber();
                bID = ((IfcRelSequence) ifcObject).getRelatedProcess().getStepLineNumber();
                relID = ifcObject.getStepLineNumber();
                relationship = RelTypes.IfcRelSequence;
                aType = ((IfcRelSequence) ifcObject).getRelatingProcess().getClass().getSimpleName();
                bType = ((IfcRelSequence) ifcObject).getRelatedProcess().getClass().getSimpleName();
                relType = "IfcRelSequence";
//                aMap  = new HashMap<>();
//                bMap = new HashMap<>();
//                relMap = new HashMap<>();
//                aMap.put("type", aType);
//                bMap.put("type", bType);
//                relMap.put("type", relType);
                aTypeMap  = new HashMap<>();
                bTypeMap = new HashMap<>();
                aTypeMap.put("type", aType);
                bTypeMap.put("type", bType);
                aMap = getMap(((IfcRelSequence) ifcObject).getRelatingProcess());
                bMap = getMap(((IfcRelSequence) ifcObject).getRelatedProcess());
                flag = 1;
            } else if(ifcObject instanceof IfcRelServicesBuildings) {
//                string = new String("IfcRelServicesBuildings " + ifcObject.getStepLineNumber() + ":\n" + "   RelatingSystem :" + ((IfcRelServicesBuildings) ifcObject).getRelatingSystem().getClass().getSimpleName()
//                        + " " + ((IfcRelServicesBuildings) ifcObject).getRelatingSystem().getStepLineNumber() + "\n"
//                        + "   RelatedBuildings:");
                aID = ((IfcRelServicesBuildings) ifcObject).getRelatingSystem().getStepLineNumber();
                aType = ((IfcRelServicesBuildings) ifcObject).getRelatingSystem().getClass().getSimpleName();
                relID = ifcObject.getStepLineNumber();
                relationship = RelTypes.IfcRelServicesBuildings;
                relType = "IfcRelServicesBuildings";
//                aMap  = new HashMap<>();
//                aMap.put("type", aType);
//                relMap = new HashMap<>();
//                relMap.put("type", relType);
                aTypeMap  = new HashMap<>();
                aTypeMap.put("type", aType);
                aMap = getMap(((IfcRelServicesBuildings) ifcObject).getRelatingSystem());
                bMapMap = new HashMap<>();
                bMapTypeMap = new HashMap<>();
                Iterator<IfcSpatialStructureElement> ifcSpatialStructureElementIterator = ((IfcRelServicesBuildings) ifcObject).getRelatedBuildings().iterator();
                while (ifcSpatialStructureElementIterator.hasNext()) {
                    IfcSpatialStructureElement ifcSpatialStructureElement = ifcSpatialStructureElementIterator.next();
//                    string = string + ifcSpatialStructureElement.getClass().getSimpleName() + " " + ifcSpatialStructureElement.getStepLineNumber() + " ";
                    bID =  ifcSpatialStructureElement.getStepLineNumber();
                    bType = ifcSpatialStructureElement.getClass().getSimpleName();
//                    bMap = new HashMap<>();
//                    bMap.put("type", bType);
                    bTypeMap = new HashMap<>();
                    bTypeMap.put("type", bType);
                    bMapTypeMap.put(bID,bTypeMap);
                    bMap = getMap(ifcSpatialStructureElement);
                    bMapMap.put(bID,bMap);
                }
                flag = 2;
//                string = string + "\n";
            } else if(ifcObject instanceof IfcRelSpaceBoundary) {
//                string = new String("IfcRelSpaceBoundary " + ifcObject.getStepLineNumber() + ":\n" + "   RelatingSpace :" + ((IfcRelSpaceBoundary) ifcObject).getRelatingSpace().getClass().getSimpleName()
//                        + " " + ((IfcRelSpaceBoundary) ifcObject).getRelatingSpace().getStepLineNumber() + "\n"
//                        + "   RelatedBuildingElement:" );
                aID = ((IfcRelSpaceBoundary) ifcObject).getRelatingSpace().getStepLineNumber();
                aType = ((IfcRelSpaceBoundary) ifcObject).getRelatingSpace().getClass().getSimpleName();
//                aMap = new HashMap<>();
//                aMap.put("type", aType);
                aTypeMap  = new HashMap<>();
                aTypeMap.put("type", aType);
                aMap = getMap(((IfcRelSpaceBoundary) ifcObject).getRelatingSpace());
                if(((IfcRelSpaceBoundary) ifcObject).getRelatedBuildingElement() != null){
//                    string = string + ((IfcRelSpaceBoundary) ifcObject).getRelatedBuildingElement().getClass().getSimpleName()
//                            + " " + ((IfcRelSpaceBoundary) ifcObject).getRelatedBuildingElement().getStepLineNumber() + "\n";
                    bID = ((IfcRelSpaceBoundary) ifcObject).getRelatedBuildingElement().getStepLineNumber();
                    bType = ((IfcRelSpaceBoundary) ifcObject).getRelatedBuildingElement().getClass().getSimpleName();
//                    bMap = new HashMap<>();
//                    relMap = new HashMap<>();
//                    bMap.put("type", bType);
                    bTypeMap = new HashMap<>();
                    bTypeMap.put("type", bType);
                    bMap = getMap(((IfcRelSpaceBoundary) ifcObject).getRelatedBuildingElement());
                    relID = ifcObject.getStepLineNumber();
                    relationship = RelTypes.IfcRelSpaceBoundary;
                    relType = "IfcRelSpaceBoundary";
//                    relMap.put("type",relType);
                } else {
//                    string = string + "null\n";
                }
                flag = 1;
//                        + ((IfcRelSpaceBoundary) ifcObject).getRelatedBuildingElement().getClass().getSimpleName()
//                        + " " + ((IfcRelSpaceBoundary) ifcObject).getRelatedBuildingElement().getStepLineNumber() + "\n");
            } else if(ifcObject instanceof IfcRelVoidsElement) {
//                string = new String("IfcRelVoidsElement " + ifcObject.getStepLineNumber() + ":\n" + "   RelatingBuildingElement :" + ((IfcRelVoidsElement) ifcObject).getRelatingBuildingElement().getClass().getSimpleName()
//                        + " " + ((IfcRelVoidsElement) ifcObject).getRelatingBuildingElement().getStepLineNumber() + "\n"
//                        + "   RelatedOpeningElement:" + ((IfcRelVoidsElement) ifcObject).getRelatedOpeningElement().getClass().getSimpleName()
//                        + " " + ((IfcRelVoidsElement) ifcObject).getRelatedOpeningElement().getStepLineNumber() + "\n");
                aID = ((IfcRelVoidsElement) ifcObject).getRelatingBuildingElement().getStepLineNumber();
                bID = ((IfcRelVoidsElement) ifcObject).getRelatedOpeningElement().getStepLineNumber();
                relID = ifcObject.getStepLineNumber();
                relationship = RelTypes.IfcRelVoidsElement;
                aType = ((IfcRelVoidsElement) ifcObject).getRelatingBuildingElement().getClass().getSimpleName();
                bType = ((IfcRelVoidsElement) ifcObject).getRelatedOpeningElement().getClass().getSimpleName();
                relType = "IfcRelVoidsElement";
//                aMap  = new HashMap<>();
//                bMap = new HashMap<>();
//                relMap = new HashMap<>();
//                aMap.put("type", aType);
//                bMap.put("type", bType);
//                relMap.put("type", relType);
                aTypeMap  = new HashMap<>();
                bTypeMap = new HashMap<>();
                aTypeMap.put("type", aType);
                bTypeMap.put("type", bType);
                aMap = getMap(((IfcRelVoidsElement) ifcObject).getRelatingBuildingElement());
                bMap = getMap(((IfcRelVoidsElement) ifcObject).getRelatedOpeningElement());
                flag = 1;
            } else if(ifcObject instanceof IfcRelAggregates) {
//                string = new String("IfcRelAggregates " + ifcObject.getStepLineNumber() + ":\n" + "   RelatingObject :" + ((IfcRelAggregates) ifcObject).getRelatingObject().getClass().getSimpleName()
//                        + " " + ((IfcRelAggregates) ifcObject).getRelatingObject().getStepLineNumber() + "\n"
//                        + "   RelatedObjects:");
                aID = ((IfcRelAggregates) ifcObject).getRelatingObject().getStepLineNumber();
                aType = ((IfcRelAggregates) ifcObject).getRelatingObject().getClass().getSimpleName();
                relID = ifcObject.getStepLineNumber();
                relationship = RelTypes.IfcRelAggregates;
                relType = "IfcRelAggregates";
//                aMap  = new HashMap<>();
//                aMap.put("type", aType);
                aTypeMap  = new HashMap<>();
                aTypeMap.put("type", aType);
                aMap = getMap(((IfcRelAggregates) ifcObject).getRelatingObject());
//                relMap = new HashMap<>();
//                relMap.put("type", relType);
                bMapMap = new HashMap<>();
                bMapTypeMap = new HashMap<>();
                Iterator<IfcObjectDefinition> ifcObjectDefinitionIterator = ((IfcRelAggregates) ifcObject).getRelatedObjects().iterator();
                while (ifcObjectDefinitionIterator.hasNext()) {
                    IfcObjectDefinition ifcObjectDefinition = ifcObjectDefinitionIterator.next();
//                    string = string + ifcObjectDefinition.getClass().getSimpleName() + " " + ifcObjectDefinition.getStepLineNumber() + " ";
                    bID =  ifcObjectDefinition.getStepLineNumber();
                    bType = ifcObjectDefinition.getClass().getSimpleName();
//                    bMap = new HashMap<>();
//                    bMap.put("type", bType);
                    bTypeMap = new HashMap<>();
                    bTypeMap.put("type", bType);
                    bMapTypeMap.put(bID,bTypeMap);
                    bMap = getMap(ifcObjectDefinition);
                    bMapMap.put(bID,bMap);
                }
                flag = 2;
//                string = string + "\n";
            } else if(ifcObject instanceof IfcRelNests) {
//                string = new String("IfcRelNests " + ifcObject.getStepLineNumber() + ":\n" + "   RelatingObject :" + ((IfcRelNests) ifcObject).getRelatingObject().getClass().getSimpleName()
//                        + " " + ((IfcRelNests) ifcObject).getRelatingObject().getStepLineNumber() + "\n"
//                        + "   RelatedObjects:");
                aID = ((IfcRelNests) ifcObject).getRelatingObject().getStepLineNumber();
                aType = ((IfcRelNests) ifcObject).getRelatingObject().getClass().getSimpleName();
                relID = ifcObject.getStepLineNumber();
                relationship = RelTypes.IfcRelNests;
                relType = "IfcRelNests";
//                aMap  = new HashMap<>();
                //加上写aMap的代码 getaMap();
                aTypeMap  = new HashMap<>();
                aTypeMap.put("type", aType);
                aMap = getMap(((IfcRelNests) ifcObject).getRelatingObject());
//                aMap.put("type", aType);
//                relMap = new HashMap<>();
//                relMap.put("type", relType);
                bMapMap = new HashMap<>();
                bMapTypeMap = new HashMap<>();
                Iterator<IfcObjectDefinition> ifcObjectDefinitionIterator = ((IfcRelNests) ifcObject).getRelatedObjects().iterator();
                while (ifcObjectDefinitionIterator.hasNext()) {
                    IfcObjectDefinition ifcObjectDefinition = ifcObjectDefinitionIterator.next();
//                    string = string + ifcObjectDefinition.getClass().getSimpleName() + " " + ifcObjectDefinition.getStepLineNumber() + " ";
                    bID =  ifcObjectDefinition.getStepLineNumber();
                    bType = ifcObjectDefinition.getClass().getSimpleName();
//                    bMap = new HashMap<>();
                    //加上写bMap的代码 getbMap();
//                    bMap.put("type", bType);
                    bTypeMap = new HashMap<>();
                    bTypeMap.put("type", bType);
                    bMapTypeMap.put(bID,bTypeMap);
                    bMap = getMap(ifcObjectDefinition);
                    bMapMap.put(bID,bMap);
                }
                flag = 2;
//                string = string + "\n";
            }
//            if(string != null){
//                try{
//                    fileWriter.write(string+"\n");
//                    string = null;
//                } catch (Exception e){
//                    e.printStackTrace();
//                }
//            }

//            System.out.println("relID:" + relID);
            long t1 = System.currentTimeMillis();
            relMap = getMap(ifcObject);
            if(aID != 0){
                if(!nodeList.contains(aID)){
//                    System.out.println("aID:" + aID);
                    inserter.createNode(aID, aMap, Label.label(aTypeMap.get("type")));
                    nodeList.add(aID);
                    nodeCount++;
                }
            }
            if(flag == 1){
                if(bID != 0){
                    if(!nodeList.contains(bID)){
//                        System.out.println("bID:" + bID);
                        inserter.createNode(bID, bMap, Label.label(bTypeMap.get("type")));
                        nodeList.add(bID);
                        nodeCount++;
                    }
                    inserter.createRelationship(aID,bID,relationship,relMap);
                    relationshipCount++;
                }
            } else if(flag == 2){
                if(bMapMap != null){
                    for(long bKey : bMapMap.keySet()){
                        if(!nodeList.contains(bKey)){
//                            System.out.println("bKey:" + bKey);
                            inserter.createNode(bKey, bMapMap.get(bKey), Label.label(bMapTypeMap.get(bKey).get("type")));
                            nodeList.add(bKey);
                            nodeCount++;
                        }
                        inserter.createRelationship(aID,bKey,relationship,relMap);
                        relationshipCount++;
                    }
                }
            }
            long t2 = System.currentTimeMillis();
            time += t2-t1;
        }
        inserter.shutdown();
        System.out.println("time:" + time);
        System.out.println("nodeCount:" + nodeCount);
        System.out.println("relationshipCount:" + relationshipCount);

//        try{
//            fileWriter.close();
//        } catch (Exception e){
//            e.printStackTrace();
//        }
    }

    public Map<String, Object> getMap(ClassInterface classInterface){
        Map<String, Object> map = new HashMap<>();
        String[] attributes = classInterface.getAttributes();
        ArrayList<CloneableObject> params = InternalAccess.getStepParameter((InternalAccessClass)classInterface);
        if(params.size() != attributes.length){
            System.out.println("params.size() != attributes.length");
        }
        CloneableObject value;
        for(int i = 0; i < attributes.length; i++){
            value = params.get(i);
            if ( value instanceof ClassInterface) {
                //存储id值
                int referredClassId = ((ClassInterface) value).getStepLineNumber();
                map.put(attributes[i],referredClassId);
            } else if (value instanceof LIST) {
                //需要处理集合
                map.put(attributes[i], resolveCollections(value));
            } else if (value instanceof SET) {
                //需要处理集合
                map.put(attributes[i], resolveCollections(value));
            } else if (value instanceof DOUBLE) {
                //输出Double
                map.put(attributes[i], ((DOUBLE) value).value);
            } else if (value instanceof INTEGER) {
                //输出int
                map.put(attributes[i], ((INTEGER) value).value);
            } else if (value instanceof STRING) {
                //输出
                map.put(attributes[i], value.toString());
            } else if (value instanceof BINARY) {
                map.put(attributes[i], value.toString());
            } else if (value instanceof ENUM) {
                map.put(attributes[i], ((ENUM) value).getStepParameter(true));
            } else if (value instanceof LOGICAL) {
                map.put(attributes[i], value.toString());
            } else if(value instanceof BOOLEAN){
                map.put(attributes[i], ((BOOLEAN) value).value);
            }else if(value == null) {
                map.put(attributes[i], "null");
            }
        }
        return map;
    }




    public void storeProperties() {
        try {
            System.out.println("ifcObjects count:" + ifcObjects.size());
            StringBuilder json = new StringBuilder();

            File file = new File(path);
            if (file.exists()) {
                System.out.println("Already exists! Deleting...");
                file.delete();
            }

            file.createNewFile();
            System.out.println("Created a new file!");
            fileWriter = new FileWriter(file);
//            ifcModel.getIfcObjectByEntityInstanceName(1);//这是根据id获取出对应的object


            StringBuilder json1;
            ArrayList<Integer> objectsHasProperties = new ArrayList<>();
            for(ClassInterface ifcObject : ifcObjects){
                int index = ifcObject.getClass().getName().lastIndexOf(".");
                String className = ifcObject.getClass().getName().substring(index + 1);
                System.out.println(className);
                InternalAccessClass object = (InternalAccessClass) ifcObject;

                if(object instanceof IfcRelDefinesByProperties){
                    json1 = new StringBuilder();
                    ArrayList<CloneableObject> parameters1 = InternalAccess.getStepParameter((IfcRelDefinesByProperties)object);//这里得出的是null，而不是一个List。是不是需要从nonInverseAttibutes哪里寻找突破口；No,是因为parse的时候把它置null了。注释掉就可以了。
                    Set<IfcObject> relatedObjects = (Set<IfcObject>)parameters1.get(4);

                    IfcPropertySetDefinition ifcPropertySetDefinition = (IfcPropertySetDefinition)parameters1.get(5);
                    if(ifcPropertySetDefinition instanceof IfcPropertySet){
                        ArrayList<CloneableObject> parameters2 =  InternalAccess.getStepParameter((IfcPropertySet)ifcPropertySetDefinition);
                        Set<IfcProperty> ifcProperties =  (Set<IfcProperty>)parameters2.get(4);
                        for(IfcProperty ifcProperty : ifcProperties) {
                            if(ifcProperty instanceof IfcPropertySingleValue){
                                ArrayList<CloneableObject> parameters3 = InternalAccess.getStepParameter((IfcPropertySingleValue) ifcProperty);
                                IfcIdentifier name = (IfcIdentifier)parameters3.get(0);
                                IfcValue nominalValue =  (IfcValue)parameters3.get(2);
                                json1.append("property:" + name.getDecodedValue() + " " + "value:" + nominalValue.toString() + "\n");
                            }else{
                                json.append("This subclass of IfcpRoperty isn't IfcPropertySingleValue! It's " + ifcProperty.getClass().getName() + "\n");
                            }
                        }
                        for(IfcObject relatedObject : relatedObjects){
                            if(relatedObject instanceof IfcProduct){
                                fileWriter.write("id:" + relatedObject.getStepLineNumber() + "\n" + "name:" + relatedObject.getClass().getName() + "\n" + "originalProperties:\n");
                                ArrayList<CloneableObject> parameters4 = InternalAccess.getStepParameter(relatedObject);
//                                for(CloneableObject parameter : parameters4){
//                                    fileWriter.write(parameter.toString() + " ");
//                                }
                                fileWriter.write("No printing for now!" + "\n" + "extraProperties：\n" + json1);
                                objectsHasProperties.add(relatedObject.getStepLineNumber());
                                fileWriter.write("\n");
                            }else {
                                fileWriter.write("Not IfcProduct! It's ");
                            }
                        }
                    } else {
                        fileWriter.write("This subclass of ifcPropertySetDefinition isn't ifcPropertySet, it's " + ifcPropertySetDefinition.getClass().getName() + "\n");
                    }
                } else{
                    fileWriter.write("Not IfcRelDefinesByProperties, it's " + object.getClass().getName() + "\n");
                }


//                System.out.println(ifcObject.getClass().getName());
//                InternalAccessClass object = (InternalAccessClass) ifcObject;
//                String[] attributeTypes = InternalAccess.getNonInverseAttributeTypes(object);
//                fileWriter.write("ifcObject.getClass().getName():" + ifcObject.getClass().getName() + "\n" + "NonInverseAttributeTypes:" + attributeTypes.toString() + "\n");
//                ArrayList<CloneableObject> attributes = InternalAccess.getStepParameter(object);
//                fileWriter.write("StepParameters' classNames:");
//                if(attributes != null) {
//                    for (CloneableObject attribute : attributes) {
//                        fileWriter.write(attribute.getClass().getName() + " ");
//                    }
//                }
//                fileWriter.write("\n");
//                Field[] fields = object.getClass().getDeclaredFields();
//                fileWriter.write("Fields:\n");
//                for (Field field : fields) {
//                    fileWriter.write(field.getName() + " " + field.getType().getName() + "\n");
//                }

            }
            fileWriter.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }


//            Field[] fields = object.getClass().getDeclaredFields();
//            json.append("\"originalProperties\":{");
//                for (Field field : fields) {
//                    json.append("\"" + field.getName() + "\":{\"type\":\"" + field.getType().getName() + "\",\"value\":\"");
//                    if (field.getType().getName().equals("IfcGloballyUniqueId")) {
//                        STRING s = (STRING)attributes.get(0);
//                        json.append(s.toString());
//                    } else if()
//
//                }
//                json.append("},");

    public void findTriples(){
       try{
           String path1 = "D:\\BIMserver1.3.4\\bimserver-clean\\ifc-files\\ChongqingSMI20150706_triples.txt";
           File file1 = new File(path1);
           if(file1.exists()){
               file1.delete();
           }
           file1.createNewFile();
           fileWriter = new FileWriter(file1);
           //然后是遍历所有的ifcobject，如果ifcobject的属性的值有两个是ifcproduct的子类（这其中包含多值），那么就输出三元组；
           for(ClassInterface ifcObject : ifcObjects ){
               IfcProductCount = 0;
               String name = ifcObject.getClass().getName();
               String name2 = name.substring(name.lastIndexOf(".") + 1);
               System.out.println(ifcObject.getStepLineNumber() + "\n");
//               if(ifcObject.getStepLineNumber() == 672) {
                   StringBuilder json = new StringBuilder();
                   ArrayList<CloneableObject> parameters = InternalAccess.getStepParameter((InternalAccessClass) ifcObject);
                   for (int j = 0; j < parameters.size(); j++) { //遍历所有的字段
                       CloneableObject parameter = parameters.get(j);
                       if (parameter instanceof IfcProduct) {//单值
                           IfcProductCount++;
                           String name3 = parameter.getClass().getName();
                           String name4 = name3.substring(name3.lastIndexOf(".") + 1);
                           json.append("   " + j + " " + name4 + "\n");
                       } else if (parameter instanceof LIST) {//多值
                           LIST list = (LIST) parameter;
                           if(list.size() != 0){
                               for(int k = 0; k < list.size(); k++){
                                   CloneableObject inlineObject = (CloneableObject) list.get(k);
                                   if (inlineObject instanceof IfcProduct) {
                                       IfcProductCount++;
                                       String name3 = inlineObject.getClass().getName();
                                       String name4 = name3.substring(name3.lastIndexOf(".") + 1);
                                       json.append("   " + j + " " + name4 + "\n");
                                   }//再次嵌套不考虑；如果LIST里面是多值的ifcProduct，也先打印出来；
                               }
                           }


//                       String[] strings = InternalAccess.getNonInverseAttributeTypes((InternalAccessClass) ifcObject);
//
//                       //然后是把list里面的类型拿出来,然后递归判断；
//                       String className = strings[j].substring(strings[j].indexOf("<") + 1, strings[j].lastIndexOf(">"));//可能是比如说IfcBoolean或者是IfcProperty.需要全部大写
//                       String className1 = className.toUpperCase();
//                       if(ifcObject.getStepLineNumber() == 78){
//                           CloneableObject inlineObject = (CloneableObject)ObjectFactory.createInstance(className1);
//                           if(inlineObject instanceof IfcProduct){
//                               IfcProductCount++;
//                               json.append(j + " " + inlineObject.getClass().getName());
//                           }//再次嵌套不考虑；如果LIST里面是多值的ifcProduct，也先打印出来；
//                       }
                       } else if (parameter instanceof SET) {
                           Iterator iterator = ((SET) parameter).iterator();
                           while (iterator.hasNext()) {
                               CloneableObject inlineObject = (CloneableObject) iterator.next();
                               if (inlineObject instanceof IfcProduct) {
                                   IfcProductCount++;
                                   String name3 = inlineObject.getClass().getName();
                                   String name4 = name3.substring(name3.lastIndexOf(".") + 1);
                                   json.append("   " + j + " " + name4 + "\n");
                               }
                           }
                       }
                   }
                   if (IfcProductCount >= 2) {
                       //打印id ，ifcObject：j,类型，
                       if(!name2.contains("IfcRel")){
                           fileWriter.write(ifcObject.getStepLineNumber() + " " + name2 + "\nIfcProductCount = " + IfcProductCount + " :\n" + json.toString());
                       }
                   } else {
//                       fileWriter.write(ifcObject.getStepLineNumber() + " " + name2 + "\nIfcProductCount = " + IfcProductCount + "\n");
                   }
//               }
           }
           fileWriter.close();
       } catch (IOException e){
           e.printStackTrace();
       }
    }

    public void storeReferringToNeo4j(){
        clearDB();
        Map<Integer, String> nodes = new HashMap<>();//所有的nodes
        Map<Integer, Map<Integer, Integer>> refer = new HashMap<>();//refer关系，值应该是个数组。
        Map<Integer, Integer> referCount = new HashMap<>();
        Map<Integer, Integer> referredCount = new HashMap<>();
        Map<Integer, Integer> totalCount = new HashMap<>();
        int index;
        String className;
        InternalAccessClass internalObject;
        Label label;
        CloneableObject parameter;
        int classId;
        int referredClassId;
        int total;
        Map<Integer, Integer> integerMap = null;
        Map<String, Object> nodeMap = new HashMap<>();
        Map<String, Object> relMap = new HashMap<>();
        relMap.put("attribute1","attribute1Value");
        BatchInserter inserter = null;
        try{
            inserter = BatchInserters.inserter(new File(dbPath));

            for(ClassInterface ifcObject : ifcObjects){//先把各个node以及其label都建立了。然后再扫描一遍建立referringto. 出度和入度都要统计一下。
                index = ifcObject.getClass().getName().lastIndexOf(".");
                className = ifcObject.getClass().getName().substring(index + 1);
                classId = ifcObject.getStepLineNumber();
                System.out.println(classId);
                nodes.put(classId, className);//将已建立的node存入map

                nodeMap.put("Id", classId);//建立node
                inserter.createNode(classId, nodeMap, Label.label(className));

                internalObject = (InternalAccessClass) ifcObject;
                ArrayList<CloneableObject> parameters = InternalAccess.getStepParameter(internalObject);

                total = parameters.size();
                if(!totalCount.containsKey(classId)){
                    totalCount.put(classId,total);
                }

                //做各种统计
                integerMap = new HashMap<>();
                for(int i = 0; i < total; i++){
                    parameter = parameters.get(i);
                    if(parameter != null){
                        if(parameter instanceof ClassInterface){
                            referredClassId = ((ClassInterface) parameter).getStepLineNumber();
                            integerMap.put(referredClassId,referredClassId);
                            if(!referCount.containsKey(classId)){
                                referCount.put(classId,1);
                            } else {
                                referCount.put(classId,referCount.get(classId)+1);
                            }
                            if(!referredCount.containsKey(referredClassId)){
                                referredCount.put(referredClassId,1);
                            } else {
                                referredCount.put(referredClassId,referredCount.get(referredClassId)+1);
                            }
                        } else if(parameter instanceof LIST){
//                            System.out.println(i + " parameter is LIST");
                            LIST<CloneableObject> listParameter =  (LIST<CloneableObject>)parameter;
                            for(CloneableObject inlineObject : listParameter){
                                if(inlineObject instanceof ClassInterface){
                                    referredClassId = ((ClassInterface) inlineObject).getStepLineNumber();
                                    integerMap.put(referredClassId,referredClassId);
                                    if(!referCount.containsKey(classId)){
                                        referCount.put(classId,1);
                                    } else {
                                        referCount.put(classId,referCount.get(classId)+1);
                                    }
                                    if(!referredCount.containsKey(referredClassId)){
                                        referredCount.put(referredClassId,1);
                                    } else {
                                        referredCount.put(referredClassId,referredCount.get(referredClassId)+1);
                                    }
                                }else if(inlineObject instanceof TypeInterface){
//                                    System.out.println("LIST<>:" + inlineObject.getClass().getName());
                                }
                            }
                        } else if(parameter instanceof SET){
//                            System.out.println(i + " parameter is SET");
                            SET<CloneableObject> setParameter = (SET<CloneableObject>)parameter;
                            for(CloneableObject inlineObject : setParameter ){
                                if(inlineObject instanceof ClassInterface){
                                    referredClassId = ((ClassInterface) inlineObject).getStepLineNumber();
                                    integerMap.put(referredClassId,referredClassId);
                                    if(!referCount.containsKey(classId)){
                                        referCount.put(classId,1);
                                    } else {
                                        referCount.put(classId,referCount.get(classId)+1);
                                    }
                                    if(!referredCount.containsKey(referredClassId)){
                                        referredCount.put(referredClassId,1);
                                    } else {
                                        referredCount.put(referredClassId,referredCount.get(referredClassId)+1);
                                    }
                                }else if(inlineObject instanceof TypeInterface){
//                                    System.out.println("SET<>:" + inlineObject.getClass().getName());
                                }
                            }

                        }
                    } else {
//                        System.out.println(i + " parameter is null");
                    }
                }
                refer.put(classId,integerMap);
            }

            //根据refer建立relationship
            for(Map.Entry<Integer, Map<Integer,Integer>> entry : refer.entrySet()){
                int key = entry.getKey();
                Map<Integer,Integer> values = entry.getValue();
                for(Integer value : values.keySet()){
                    inserter.createRelationship(key, value, RelationshipType.withName("ReferingTo"),relMap);
                }
            }

            //根据nodes（id,classname）、totalCount、referCount、referredCount输出csv
            File countfile = new File("D:\\MyRepository\\BIM\\count.csv");
            if(countfile.exists()){
                countfile.delete();
            }
            countfile.createNewFile();
            FileOutputStream fos = new FileOutputStream(countfile);
            String string;
            int refer1;
            int referred1;
            for(Map.Entry<Integer, String> entry : nodes.entrySet()){
                refer1 = 0;
                referred1 = 0;
                if(referCount.get(entry.getKey()) != null){
                    refer1 = referCount.get(entry.getKey());
                }
                if(referredCount.get(entry.getKey()) != null){
                    referred1 = referredCount.get(entry.getKey());
                }
                string = entry.getKey() + "," + entry.getValue() + "," + totalCount.get(entry.getKey()) + "," + refer1 + "," + referred1 + System.lineSeparator();
                fos.write(string.getBytes());
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(inserter!=null){
                inserter.shutdown();
            }
        }

    }


    public void storeIfcJson(){
        try{
            System.out.println("ifcObjects count:" + ifcObjects.size());
            StringBuilder json = new StringBuilder();
            HashMap<String,Writer> writerMap = new HashMap();
            Writer writer;
            for(ClassInterface ifcObject : ifcObjects){
                if(!writerMap.containsKey(ifcObject.getClass().getSimpleName())){
                    File f = new File("D:\\Experiment\\IfcJson\\" + ifcObject.getClass().getSimpleName() + ".json");
                    if(!f.exists()){
                        f.createNewFile();
                    }
                    writer =  new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f),"UTF-8"));
                    writerMap.put(ifcObject.getClass().getSimpleName(), writer);
                }
            }
            for(ClassInterface ifcObject : ifcObjects){
                if(ifcObject instanceof IfcRelDefinesByProperties){
                    String value = convertIfcToJson(ifcObject);
                    String valueRow = "{\"doc\":" + value + "}\n";
                    SET<IfcObject> objectsToProperty = getObjects(ifcObject);
                    String metaRow;
                    for(IfcObject objectToProperty : objectsToProperty){
                        metaRow = "{\"update\":{\"_id\":\"" + objectToProperty.getStepLineNumber() + "\"}}\n";
                        writer = writerMap.get(objectToProperty.getClass().getSimpleName());
                        writer.write(metaRow + valueRow);
                        writer.flush();
                    }

                } else {
                    writer = writerMap.get(ifcObject.getClass().getSimpleName());
                    writer.write("{\"index\":{\"_id\":\"" + ifcObject.getStepLineNumber() + "\"}}\n" + convertIfcToJson(ifcObject) + "\n");
                    writer.flush();
                }
            }
            Writer w;
            for(String str : writerMap.keySet()){
                w = writerMap.get(str);
                w.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public SET<IfcObject> getObjects(ClassInterface ifcObject){
        ArrayList<CloneableObject> parameters = InternalAccess.getStepParameter((InternalAccessClass) ifcObject);
        SET<IfcObject> ifcObjectSet = (SET<IfcObject>)parameters.get(4);
        return ifcObjectSet;
    }


    public String convertIfcToJson(ClassInterface ifcObject) {

        StringBuilder jsonSb = new StringBuilder();
        jsonSb.append("{");
        String[] attributes;
        InternalAccessClass internalAccessClass;
        ArrayList<CloneableObject> parameters;
        //接下来是把ifcObject的属性都拿过来进行输出，遇到IfcReldefinesByProperties就特殊处理。
        if (ifcObject instanceof IfcTypeObject) {
            attributes = ifcObject.getAttributes();
            internalAccessClass = (InternalAccessClass) ifcObject;
            parameters = InternalAccess.getStepParameter(internalAccessClass);
            for (int i = 0; i < attributes.length; i++) {
                if(!attributes[i].equals("HasPropertySets") ){
                    CloneableObject value = parameters.get(i);
                    jsonSb.append("\"" + attributes[i] + "\":");
                    appendValue(jsonSb, value);
                }else {
//                    if(ifcObject.getStepLineNumber() == 244 || ifcObject.getStepLineNumber() == 444){
//                        //既有IfcPropertySet，又有其他set的处理
//                    }
                    CloneableObject properties = parameters.get(i);
                    if(properties instanceof SET){
                        SET<IfcPropertySetDefinition> properties1 = (SET<IfcPropertySetDefinition>)properties;
                        jsonSb.append("\"HasProperties\":{");
                        int count = 0;
                        for(IfcPropertySetDefinition propertySet : properties1){//分两种情况，ifcpropertyset、ifcdorrliningproperties。应该只假设后者存在。
                            if(!(propertySet instanceof IfcPropertySet)){//doorlingproperties的情况
                                ArrayList<CloneableObject> propertySetParams =  InternalAccess.getStepParameter(propertySet);
                                String[] setAttributes = propertySet.getAttributes();
                                for(int j = 0; j < setAttributes.length; j++){
                                    jsonSb.append("\"" + setAttributes[j] + "\":");
                                    appendValue(jsonSb, propertySetParams.get(j));
                                    if(j != setAttributes.length-1){
                                        jsonSb.append(",");
                                    } else{
                                        jsonSb.append("}");
                                    }
                                }
                            } else{//IfcPropertySet的情况
                                ArrayList<CloneableObject> params4 =  InternalAccess.getStepParameter(propertySet);
                                String name = null;
                                if(params4.get(2) != null){
                                    name = ((STRING)params4.get(2)).toString();
                                } else{
                                    name = "Others";
                                }
                                jsonSb.append("\"" + name + "\":{");//set的name
                                SET<IfcProperty> set3 = (SET<IfcProperty>)params4.get(4);
                                int countt = 0;
                                String propertyName = null;
                                for (IfcProperty property : set3){
                                    countt++;
                                    ArrayList<CloneableObject> params5 = InternalAccess.getStepParameter(property);
                                    if(params5.get(0) instanceof STRING){
                                        STRING s = (STRING)params5.get(0);
                                        propertyName = s.toString();
                                    }
                                    jsonSb.append("\"" + propertyName + "\":{");
                                    String[] attributes5 = property.getAttributes();
                                    for(int k=1; k < attributes5.length;k++){
                                        jsonSb.append("\"" + attributes5[k] + "\":");
                                        appendValue(jsonSb,params5.get(k));
                                        if(k == attributes5.length -1){
                                            jsonSb.append("}");
                                        } else{
                                            jsonSb.append(",");
                                        }
                                    }
                                    if(countt == set3.size()){
                                        jsonSb.append("}");
                                    } else {
                                        jsonSb.append(",");
                                    }
                                }
                            }
                            count ++;
                            if(count != properties1.size()){
                                jsonSb.append(",");
                            } else{
                                jsonSb.append("}");
                            }
                        }
                    } else if(properties == null){
                        System.out.println("HasProperties == null");
                        jsonSb.append("\"HasProperties\":{}");
                    }
                }
                if (i == attributes.length - 1) {
                    jsonSb.append("}");
                } else {
                    jsonSb.append(",");
                }
            }
            //处理IfcTypeObject的属性
        } else if (ifcObject instanceof IfcRelDefinesByProperties) {
//            if(ifcObject.getStepLineNumber() == 339){
//                System.out.println("haha");
//            }
            //处理IfcRelDefinesByProperties的属性
            attributes = ifcObject.getAttributes();
            internalAccessClass = (InternalAccessClass) ifcObject;
            parameters = InternalAccess.getStepParameter(internalAccessClass);
            if (parameters.size() != attributes.length) {
                System.out.println("parameters.size() != attributes.length " + parameters.size() + " " + attributes.length);
            }
            String name;
            CloneableObject set = parameters.get(5);
            ArrayList<CloneableObject> params;
            int count2 = 0;
            if(set instanceof IfcPropertySet){
                IfcPropertySet setDefinition = (IfcPropertySet)set;
                params = InternalAccess.getStepParameter(setDefinition);
                if(params.get(2) != null){
                    name = ((STRING)params.get(2)).toString();
                } else {
                    name = "Others";
                }
                jsonSb.append("\"" + name + "\":{");//set的name
                SET<IfcProperty> set2 = (SET<IfcProperty>)params.get(4);
                for (IfcProperty property : set2){
//                    if(property.getStepLineNumber() == 333){
//                        System.out.println("haha");
//                    }
                    count2++;
                    ArrayList<CloneableObject> params3 = InternalAccess.getStepParameter(property);
                    String propertyName = null;
                    if(params3.get(0) instanceof STRING){
                        STRING s = (STRING)params3.get(0);
                        propertyName = s.toString();
                    }
                    jsonSb.append("\"" + propertyName + "\":{");
                    String[] attributes1 = property.getAttributes();//先打印property name,再在{}中打印其它字段
                    for(int k=1; k < attributes1.length;k++){
                        jsonSb.append("\"" + attributes1[k] + "\":");
                        appendValue(jsonSb,params3.get(k));
                        if(k == attributes1.length -1){
                            jsonSb.append("}");
                        } else{
                            jsonSb.append(",");
                        }
                    }
                    if(count2 == set2.size()){
                        jsonSb.append("}}");
                    } else {
                        jsonSb.append(",");
                    }
                }

            } else if(set instanceof IfcElementQuantity){
                IfcElementQuantity quantity = (IfcElementQuantity)set;
                params = InternalAccess.getStepParameter(quantity);
                SET<IfcPhysicalQuantity> set2 = (SET<IfcPhysicalQuantity>)params.get(5);
                if(params.get(2) != null){
                    name = ((STRING)params.get(2)).toString();
                } else {
                    name = "Others";
                }
                jsonSb.append("\"" + name + "\":{");//set的name
                for (IfcPhysicalQuantity quantityProperty : set2){
                    count2++;
                    ArrayList<CloneableObject> params3 = InternalAccess.getStepParameter(quantityProperty);
                    String propertyName = null;
                    if(params3.get(0) instanceof STRING){
                        STRING s = (STRING)params3.get(0);
                        propertyName = s.toString();
                    }
                    jsonSb.append("\"" + propertyName + "\":{");
                    String[] attributes1 = quantityProperty.getAttributes();//先打印property name,再在{}中打印其它字段
                    for(int k=1; k < attributes1.length;k++){
                        jsonSb.append("\"" + attributes1[k] + "\":");
                        appendValue(jsonSb,params3.get(k));
                        if(k == attributes1.length -1){
                            jsonSb.append("}");
                        } else{
                            jsonSb.append(",");
                        }
                    }
                    if(count2 == set2.size()){
                        jsonSb.append("}}");
                    } else {
                        jsonSb.append(",");
                    }
                }

            } else {
                System.out.println("not a IfcPropertySet or IfcElementQuantity");
            }

        } else {//处理其它类的属性
            attributes = ifcObject.getAttributes();
            internalAccessClass = (InternalAccessClass) ifcObject;
            parameters = InternalAccess.getStepParameter(internalAccessClass);
            if (parameters.size() != attributes.length) {
                System.out.println("parameters.size() != attributes.length " + parameters.size() + " " + attributes.length);
            }

            for (int i = 0; i < attributes.length; i++) {
//                    Class c = ifcObject.getClass();
//                    Method m = c.getMethod("get" + attributes[i] + "()", null);
//                    Object value = m.invoke(ifcObject, null);//获取到了attribute的值。
//                    jsonSb.append(attributes[i] + "\"");
                CloneableObject value = parameters.get(i);
                jsonSb.append("\"" + attributes[i] + "\":");
                appendValue(jsonSb,value);
                if (i == attributes.length - 1) {
                    jsonSb.append("}");
                } else {
                    jsonSb.append(",");
                }
            }
        }
        return jsonSb.toString();
    }


    public void appendValue(StringBuilder jsonSb, CloneableObject value){
        if (value instanceof ClassInterface) {
            //存储id值
            int referredClassId = ((ClassInterface) value).getStepLineNumber();
            jsonSb.append(referredClassId);
        } else if (value instanceof LIST) {
            //需要处理集合
            jsonSb.append(resolveCollections(value));
        } else if (value instanceof SET) {
            //需要处理集合
            jsonSb.append(resolveCollections(value));
        } else if (value instanceof DOUBLE) {
            //输出Double
            jsonSb.append(((DOUBLE) value).value);
        } else if (value instanceof INTEGER) {
            //输出int
            jsonSb.append(((INTEGER) value).value);
        } else if (value instanceof STRING) {
            //输出
            jsonSb.append("\"" + value + "\"");
        } else if (value instanceof BINARY) {
            jsonSb.append("\"" + value.toString() + "\"");
        } else if (value instanceof ENUM) {
            jsonSb.append("\"" + ((ENUM) value).getStepParameter(true) + "\"");
        } else if (value instanceof LOGICAL) {
            jsonSb.append(value.toString());
        } else if(value instanceof BOOLEAN){
            jsonSb.append(((BOOLEAN) value).value);
        }else if(value == null) {
            jsonSb.append("\"\"");
        }
    }


    public String resolveCollections(CloneableObject value){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int count = 0;
        if(value instanceof LIST){
            LIST<CloneableObject> valueList = (LIST<CloneableObject>)value;
            for(CloneableObject innerValue : valueList){
                count ++;
                if(innerValue instanceof ClassInterface){
                    sb.append(((ClassInterface) innerValue).getStepLineNumber());
                } else if(innerValue instanceof INTEGER){
                    sb.append(((INTEGER) innerValue).value);
                } else if(innerValue instanceof DOUBLE){
                    sb.append(((DOUBLE) innerValue).value);
                } else if(innerValue instanceof STRING){
                    sb.append("\"" + innerValue + "\"");
                } else if(innerValue instanceof ENUM){
                    sb.append("\"" + ((ENUM) innerValue).getStepParameter(true) + "\"");
                } else if (innerValue instanceof BINARY){
                    sb.append("\"" + innerValue.toString() + "\"");
                } else if(innerValue instanceof LOGICAL){
                    sb.append(innerValue.toString());
                } else if(value instanceof BOOLEAN){
                    sb.append(((BOOLEAN) value).value);
                }else if(value == null) {
                    sb.append("\"\"");
                }
                if(count < valueList.size()){
                    sb.append(",");
                } else{
                    sb.append("]");
                }
            }
            return sb.toString();
        } else if (value instanceof SET){
            SET<CloneableObject> valueSet = (SET<CloneableObject>)value;
            for(CloneableObject innerValue : valueSet){
                count ++;
                if(innerValue instanceof ClassInterface){
                    sb.append(((ClassInterface) innerValue).getStepLineNumber());
                } else if(innerValue instanceof INTEGER){
                    sb.append(((INTEGER) innerValue).value);
                } else if(innerValue instanceof DOUBLE){
                    sb.append(((DOUBLE) innerValue).value);
                } else if(innerValue instanceof STRING){
                    sb.append("\"" + innerValue + "\"");
                } else if(innerValue instanceof ENUM){
                    sb.append("\"" + ((ENUM) innerValue).getStepParameter(true) + "\"");
                } else if (innerValue instanceof BINARY){
                    sb.append("\"" + innerValue.toString() + "\"");
                } else if(innerValue instanceof LOGICAL){
                    sb.append(innerValue.toString());
                } else if(value instanceof BOOLEAN){
                    sb.append(((BOOLEAN) value).value);
                }else if(value == null) {
                    sb.append("\"\"");
                }
                if(count < valueSet.size()){
                    sb.append(",");
                } else{
                    sb.append("]");
                }
            }
            return sb.toString();
        } else {
            System.out.println("not LIST or SET");
        }
        return null;
    }

    public void storeTest(){
        clearDB();
        BatchInserter inserter = null;
        try{
            inserter = BatchInserters.inserter(new File(dbPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, Object> aMap = new HashMap<>();
        aMap.put("Name","标高");
        aMap.put("ObjectPlacement",111);
        aMap.put("Description","null");
        aMap.put("Elevation", 0.0);
        inserter.createNode(10, aMap, Label.label("IfcWall"));
        inserter.shutdown();
    }

    public Map<Integer, MyIfcPropertySetDefinition> propertySizeCalculate(){
        Map<Integer, MyIfcPropertySetDefinition> idsetMap = new HashMap<>();
        MyIfcPropertySetDefinition mySet;
        for(ClassInterface c : ifcObjects){
//            if(c instanceof IfcPropertySetDefinition){
//                size = getSize((IfcPropertySetDefinition)c);
//            }
            if(c instanceof IfcRelDefinesByProperties){//还有IfcRelOveridesProperties
                List<CloneableObject> params = InternalAccess.getStepParameter((InternalAccessClass)c);
                Set<IfcObject> objects = (Set<IfcObject>)params.get(4);//关联的objects
                IfcPropertySetDefinition set = (IfcPropertySetDefinition)params.get(5);
                if(!idsetMap.containsKey(set.getStepLineNumber())){
                    mySet = new MyIfcPropertySetDefinition();
                    mySet.id = set.getStepLineNumber();
                    mySet.type = set.getClass().getSimpleName();
                    idsetMap.put(set.getStepLineNumber(), mySet);
                    mySet.referMap = new HashMap<>();
                    mySet.size = getSize(set);
                }else{
                    mySet = idsetMap.get(set.getStepLineNumber());
                }
                for (IfcObject ifcObject : objects){
                    mySet.referMap.put(ifcObject.getStepLineNumber(),ifcObject.getClass().getName());
                }
                mySet.referCount += objects.size();
            }else if(c instanceof IfcTypeObject){
                //需要判断等于null的情况。
                List<CloneableObject> params = InternalAccess.getStepParameter((InternalAccessClass)c);
                Set<IfcPropertySetDefinition> sets = (Set<IfcPropertySetDefinition>)params.get(5);//关联的objects
                if(sets != null){
                    for(IfcPropertySetDefinition ifcPropertySetDefinition : sets){
                        if(!idsetMap.containsKey(ifcPropertySetDefinition.getStepLineNumber())){
                            mySet = new MyIfcPropertySetDefinition();
                            mySet.id = ifcPropertySetDefinition.getStepLineNumber();
                            mySet.type = ifcPropertySetDefinition.getClass().getSimpleName();
                            mySet.referMap = new HashMap<>();
                            mySet.size = getSize(ifcPropertySetDefinition);
                        }else {
                            mySet = idsetMap.get(ifcPropertySetDefinition.getStepLineNumber());
                        }
                        mySet.referCount += 1;
                        mySet.referMap.put(c.getStepLineNumber(),c.getClass().getName());
                    }
                }
            }
        }
        return idsetMap;
    }

    public class MyIfcPropertySetDefinition{
        int id;
        String type;
        int referCount = 0;
        long size;
        Map<Integer, String> referMap;
    }

    public long getSize(IfcPropertySetDefinition ifcPropertySetDefinition){
        try{
            List<CloneableObject> params = InternalAccess.getStepParameter((InternalAccessClass)ifcPropertySetDefinition);
            //分不同的情况来统计数据量的大小。数据不需要去除掉名字。
            //如果是IfcRelDefinesByProperties的引用，需要看RelatedObjects的个数n，ifcpropertySet的大小s（包括嵌套）。
            //如果是IfcTypeObject的引用，看hasproperties的ifcpropertySet的大小,并记录有多少个IfcTypeObject引用了。
            //需要区分不同的set的情况
            long size = 0;
            if(ifcPropertySetDefinition instanceof IfcDoorLiningProperties){
//                System.out.println("rel里面有IfcDoorLiningProperties" + String.valueOf(ifcPropertySetDefinition.getStepLineNumber()));
                size += ifcPropertySetDefinition.getStepLine().getBytes("utf-8").length;
            }else if(ifcPropertySetDefinition instanceof IfcDoorPanelProperties){
//                System.out.println("rel里面有IfcDoorPanelProperties" + String.valueOf(ifcPropertySetDefinition.getStepLineNumber()));
                size += ifcPropertySetDefinition.getStepLine().getBytes("utf-8").length;
            }else if(ifcPropertySetDefinition instanceof IfcElementQuantity){
//                System.out.println("rel里面有IfcElementQuantity" + String.valueOf(ifcPropertySetDefinition.getStepLineNumber()));
                size += ifcPropertySetDefinition.getStepLine().getBytes("utf-8").length;
            }else if(ifcPropertySetDefinition instanceof IfcEnergyProperties){
//                System.out.println("rel里面有IfcEnergyProperties" + String.valueOf(ifcPropertySetDefinition.getStepLineNumber()));
                size += ifcPropertySetDefinition.getStepLine().getBytes("utf-8").length;
            }else if(ifcPropertySetDefinition instanceof IfcElectricalBaseProperties){
//                System.out.println("rel里面有IfcElectricalBaseProperties" + String.valueOf(ifcPropertySetDefinition.getStepLineNumber()));
                size += ifcPropertySetDefinition.getStepLine().getBytes("utf-8").length;
            }else if(ifcPropertySetDefinition instanceof IfcFluidFlowProperties){
//                System.out.println("rel里面有IfcFluidFlowProperties" + String.valueOf(ifcPropertySetDefinition.getStepLineNumber()));
                size += ifcPropertySetDefinition.getStepLine().getBytes("utf-8").length;
            }else if(ifcPropertySetDefinition instanceof IfcPermeableCoveringProperties){
//                System.out.println("rel里面有IfcPermeableCoveringProperties" + String.valueOf(ifcPropertySetDefinition.getStepLineNumber()));
                size += ifcPropertySetDefinition.getStepLine().getBytes("utf-8").length;
            }else if(ifcPropertySetDefinition instanceof IfcPropertySet){
//            System.out.println("rel里面有IfcPropertySet" + String.valueOf(ifcPropertySetDefinition.getStepLineNumber()));
                size += ifcPropertySetDefinition.getStepLine().getBytes("utf-8").length;
                IfcPropertySet set = (IfcPropertySet)ifcPropertySetDefinition;
                List<CloneableObject> p = InternalAccess.getStepParameter((InternalAccessClass)set);
                Set<IfcProperty> properties = (Set<IfcProperty>)p.get(4);
                for(IfcProperty ifcProperty : properties){
                    size += ifcProperty.getStepLine().getBytes("utf-8").length;
                }
            }else if(ifcPropertySetDefinition instanceof IfcReinforcementDefinitionProperties){
//                System.out.println("rel里面有IfcReinforcementDefinitionProperties" + String.valueOf(ifcPropertySetDefinition.getStepLineNumber()));
                size += ifcPropertySetDefinition.getStepLine().getBytes("utf-8").length;
            }else if(ifcPropertySetDefinition instanceof IfcServiceLifeFactor){
//                System.out.println("rel里面有IfcServiceLifeFactor" + String.valueOf(ifcPropertySetDefinition.getStepLineNumber()));
                size += ifcPropertySetDefinition.getStepLine().getBytes("utf-8").length;
            }else if(ifcPropertySetDefinition instanceof IfcSoundProperties){
//                System.out.println("rel里面有IfcSoundProperties" + String.valueOf(ifcPropertySetDefinition.getStepLineNumber()));
                size += ifcPropertySetDefinition.getStepLine().getBytes("utf-8").length;
            }else if(ifcPropertySetDefinition instanceof IfcSoundValue){
//                System.out.println("rel里面有IfcSoundValue" + String.valueOf(ifcPropertySetDefinition.getStepLineNumber()));
            }else if(ifcPropertySetDefinition instanceof IfcSpaceThermalLoadProperties){
//                System.out.println("rel里面有IfcSpaceThermalLoadProperties" + String.valueOf(ifcPropertySetDefinition.getStepLineNumber()));
                size += ifcPropertySetDefinition.getStepLine().getBytes("utf-8").length;
            }else if(ifcPropertySetDefinition instanceof IfcWindowPanelProperties){
//                System.out.println("rel里面有IfcWindowPanelProperties" + String.valueOf(ifcPropertySetDefinition.getStepLineNumber()));
                size += ifcPropertySetDefinition.getStepLine().getBytes("utf-8").length;
            }else if(ifcPropertySetDefinition instanceof IfcWindowLiningProperties){
//                System.out.println("rel里面有IfcWindowLiningProperties" + String.valueOf(ifcPropertySetDefinition.getStepLineNumber()));
                size += ifcPropertySetDefinition.getStepLine().getBytes("utf-8").length;
            }
            return size;
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return 0;
    }


    public static void main(String[] args){
        IfcReader ifcReader = new IfcReader(args[0], args[1]);
        ifcReader.generateIfcModel();
//        ifcReader.storeReferringToNeo4j();
//        ifcReader.storeProperties();
//        ifcReader.findTriples();
//        ifcReader.storeNodes();
//        ifcReader.storeTest();
//        ifcReader.storeIfcJson();
        MyIfcPropertySetDefinition myset;
        Map<Integer,MyIfcPropertySetDefinition> sets = ifcReader.propertySizeCalculate();
        for(Map.Entry<Integer,MyIfcPropertySetDefinition> entry : sets.entrySet()){
//            System.out.println(entry.getKey());
            myset = entry.getValue();
            if(myset.referCount > 1){
                System.out.println(myset.id + " " + myset.type + " " + myset.referCount + " " + myset.size);
            }

        }
    }
}
