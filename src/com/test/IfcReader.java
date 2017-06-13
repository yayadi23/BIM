package com.test;
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

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;


public class IfcReader {

    private static IfcModel ifcModel;
    private static Collection<ClassInterface> ifcObjects;

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
            String aType,bType,relType;
            Map<String, Object> aMap = null;
            Map<String, Object> bMap = null;
            Map<String, Object> relMap = null;
            Map<Long,Map<String,Object>> bMapMap = null;

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
                aMap  = new HashMap<>();
                bMap = new HashMap<>();
                relMap = new HashMap<>();
                aMap.put("type", aType);
                bMap.put("type", bType);
                relMap.put("type", relType);
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
                aMap  = new HashMap<>();
                bMap = new HashMap<>();
                relMap = new HashMap<>();
                aMap.put("type", aType);
                bMap.put("type", bType);
                relMap.put("type", relType);
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
                aMap  = new HashMap<>();
                bMap = new HashMap<>();
                relMap = new HashMap<>();
                aMap.put("type", aType);
                bMap.put("type", bType);
                relMap.put("type", relType);
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
                aMap  = new HashMap<>();
                bMap = new HashMap<>();
                relMap = new HashMap<>();
                aMap.put("type", aType);
                bMap.put("type", bType);
                relMap.put("type", relType);
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
                aMap  = new HashMap<>();
                bMap = new HashMap<>();
                relMap = new HashMap<>();
                aMap.put("type", aType);
                bMap.put("type", bType);
                relMap.put("type", relType);
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
                aMap  = new HashMap<>();
                bMap = new HashMap<>();
                relMap = new HashMap<>();
                aMap.put("type", aType);
                bMap.put("type", bType);
                relMap.put("type", relType);
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
                aMap  = new HashMap<>();
                bMap = new HashMap<>();
                relMap = new HashMap<>();
                aMap.put("type", aType);
                bMap.put("type", bType);
                relMap.put("type", relType);
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
                aMap  = new HashMap<>();
                bMap = new HashMap<>();
                relMap = new HashMap<>();
                aMap.put("type", aType);
                bMap.put("type", bType);
                relMap.put("type", relType);
                flag = 1;
            } else if(ifcObject instanceof IfcRelContainedInSpatialStructure) {
//                string = new String("IfcRelContainedInSpatialStructure " + ifcObject.getStepLineNumber() + ":\n" + "   RelatingStructure:" + ((IfcRelContainedInSpatialStructure) ifcObject).getRelatingStructure().getClass().getSimpleName()
//                        + " " + ((IfcRelContainedInSpatialStructure) ifcObject).getRelatingStructure().getStepLineNumber() + "\n"
//                        + "   RelatedElements:" );
                aID = ((IfcRelContainedInSpatialStructure) ifcObject).getRelatingStructure().getStepLineNumber();
                aType = ((IfcRelContainedInSpatialStructure) ifcObject).getRelatingStructure().getClass().getSimpleName();
                relationship = RelTypes.IfcRelContainedInSpatialStructure;
                relType = "IfcRelConnectsWithEccentricity";
                aMap  = new HashMap<>();
                relMap = new HashMap<>();
                bMapMap = new HashMap<>();
                aMap.put("type", aType);
                relMap.put("type", relType);
                Iterator<IfcProduct> ifcProductIterator = ((IfcRelContainedInSpatialStructure) ifcObject).getRelatedElements().iterator();
                while(ifcProductIterator.hasNext()){
                    IfcProduct ifcProduct = ifcProductIterator.next();
//                    string = string + ifcProduct.getClass().getSimpleName() + " " + ifcProduct.getStepLineNumber() + " ";
                    bID =  ifcProduct.getStepLineNumber();
                    bType = ifcProduct.getClass().getSimpleName();
                    bMap = new HashMap<>();
                    bMap.put("type", bType);
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
                relationship = RelTypes.IfcRelCoversBldgElements;
                relType = "IfcRelCoversBldgElements";
                aMap = new HashMap<>();
                aMap.put("type", aType);
                relMap = new HashMap<>();
                relMap.put("type", relType);
                bMapMap = new HashMap<>();
                Iterator<IfcCovering> ifcCoveringIterator = ((IfcRelCoversBldgElements) ifcObject).getRelatedCoverings().iterator();
                while(ifcCoveringIterator.hasNext()){
                    IfcCovering ifcCovering = ifcCoveringIterator.next();
//                    string = string + ifcCovering.getClass().getSimpleName() + " " + ifcCovering.getStepLineNumber() + " ";
                    bID =  ifcCovering.getStepLineNumber();
                    bType = ifcCovering.getClass().getSimpleName();
                    bMap = new HashMap<>();
                    bMap.put("type", bType);
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
                relationship = RelTypes.IfcRelCoversSpaces;
                relType = "IfcRelCoversSpaces";
                aMap = new HashMap<>();
                aMap.put("type", aType);
                relMap = new HashMap<>();
                relMap.put("type", relType);
                bMapMap = new HashMap<>();
                Iterator<IfcCovering> ifcCoveringIterator = ((IfcRelCoversSpaces) ifcObject).getRelatedCoverings().iterator();
                while(ifcCoveringIterator.hasNext()){
                    IfcCovering ifcCovering = ifcCoveringIterator.next();
//                    string = string + ifcCovering.getClass().getSimpleName() + " " + ifcCovering.getStepLineNumber() + " ";
                    bID =  ifcCovering.getStepLineNumber();
                    bType = ifcCovering.getClass().getSimpleName();
                    bMap = new HashMap<>();
                    bMap.put("type", bType);
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
                aMap  = new HashMap<>();
                bMap = new HashMap<>();
                relMap = new HashMap<>();
                aMap.put("type", aType);
                bMap.put("type", bType);
                relMap.put("type", relType);
                flag = 1;
            } else if(ifcObject instanceof IfcRelFlowControlElements) {
//                string = new String("IfcRelFlowControlElements " + ifcObject.getStepLineNumber() + ":\n" + "   RelatingFlowElement :" + ((IfcRelFlowControlElements) ifcObject).getRelatingFlowElement().getClass().getSimpleName()
//                        + " " + ((IfcRelFlowControlElements) ifcObject).getRelatingFlowElement().getStepLineNumber() + "\n"
//                        + "   RelatedControlElements:" );
                aID = ((IfcRelFlowControlElements) ifcObject).getRelatingFlowElement().getStepLineNumber();
                aType = ((IfcRelFlowControlElements) ifcObject).getRelatingFlowElement().getClass().getSimpleName();
                relationship = RelTypes.IfcRelFlowControlElements;
                relType = "IfcRelFlowControlElements";
                aMap = new HashMap<>();
                aMap.put("type", aType);
                relMap = new HashMap<>();
                relMap.put("type", relType);
                bMapMap = new HashMap<>();
                Iterator<IfcDistributionControlElement> ifcDistributionControlElementIterator = ((IfcRelFlowControlElements) ifcObject).getRelatedControlElements().iterator();
                while(ifcDistributionControlElementIterator.hasNext()){
                    IfcDistributionControlElement ifcDistributionControlElement = ifcDistributionControlElementIterator.next();
//                    string = string + ifcDistributionControlElement.getClass().getSimpleName() + " " + ifcDistributionControlElement.getStepLineNumber() + " ";
                    bID =  ifcDistributionControlElement.getStepLineNumber();
                    bType = ifcDistributionControlElement.getClass().getSimpleName();
                    bMap = new HashMap<>();
                    bMap.put("type", bType);
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
                aMap  = new HashMap<>();
                bMap = new HashMap<>();
                relMap = new HashMap<>();
                aMap.put("type", aType);
                bMap.put("type", bType);
                relMap.put("type", relType);
                flag = 1;
            } else if(ifcObject instanceof IfcRelReferencedInSpatialStructure) {
//                string = new String("IfcRelReferencedInSpatialStructure " + ifcObject.getStepLineNumber() + ":\n" + "   RelatingStructure :" + ((IfcRelReferencedInSpatialStructure) ifcObject).getRelatingStructure().getClass().getSimpleName()
//                        + " " + ((IfcRelReferencedInSpatialStructure) ifcObject).getRelatingStructure().getStepLineNumber() + "\n"
//                        + "   RelatedElements:");
                aID = ((IfcRelReferencedInSpatialStructure) ifcObject).getRelatingStructure().getStepLineNumber();
                aType = ((IfcRelReferencedInSpatialStructure) ifcObject).getRelatingStructure().getClass().getSimpleName();
                relationship = RelTypes.IfcRelReferencedInSpatialStructure;
                relType = "IfcRelReferencedInSpatialStructure";
                aMap = new HashMap<>();
                aMap.put("type", aType);
                relMap = new HashMap<>();
                relMap.put("type", relType);
                bMapMap = new HashMap<>();
                Iterator<IfcProduct> ifcProductIterator = ((IfcRelReferencedInSpatialStructure) ifcObject).getRelatedElements().iterator();
                while (ifcProductIterator.hasNext()) {
                    IfcProduct ifcProduct = ifcProductIterator.next();
//                    string = string + ifcProduct.getClass().getSimpleName() + " " + ifcProduct.getStepLineNumber() + " ";
                    bID =  ifcProduct.getStepLineNumber();
                    bType = ifcProduct.getClass().getSimpleName();
                    bMap = new HashMap<>();
                    bMap.put("type", bType);
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
                aMap  = new HashMap<>();
                bMap = new HashMap<>();
                relMap = new HashMap<>();
                aMap.put("type", aType);
                bMap.put("type", bType);
                relMap.put("type", relType);
                flag = 1;
            } else if(ifcObject instanceof IfcRelServicesBuildings) {
//                string = new String("IfcRelServicesBuildings " + ifcObject.getStepLineNumber() + ":\n" + "   RelatingSystem :" + ((IfcRelServicesBuildings) ifcObject).getRelatingSystem().getClass().getSimpleName()
//                        + " " + ((IfcRelServicesBuildings) ifcObject).getRelatingSystem().getStepLineNumber() + "\n"
//                        + "   RelatedBuildings:");
                aID = ((IfcRelServicesBuildings) ifcObject).getRelatingSystem().getStepLineNumber();
                aType = ((IfcRelServicesBuildings) ifcObject).getRelatingSystem().getClass().getSimpleName();
                relationship = RelTypes.IfcRelServicesBuildings;
                relType = "IfcRelServicesBuildings";
                aMap  = new HashMap<>();
                aMap.put("type", aType);
                relMap = new HashMap<>();
                relMap.put("type", relType);
                bMapMap = new HashMap<>();
                Iterator<IfcSpatialStructureElement> ifcSpatialStructureElementIterator = ((IfcRelServicesBuildings) ifcObject).getRelatedBuildings().iterator();
                while (ifcSpatialStructureElementIterator.hasNext()) {
                    IfcSpatialStructureElement ifcSpatialStructureElement = ifcSpatialStructureElementIterator.next();
//                    string = string + ifcSpatialStructureElement.getClass().getSimpleName() + " " + ifcSpatialStructureElement.getStepLineNumber() + " ";
                    bID =  ifcSpatialStructureElement.getStepLineNumber();
                    bType = ifcSpatialStructureElement.getClass().getSimpleName();
                    bMap = new HashMap<>();
                    bMap.put("type", bType);
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
                aMap = new HashMap<>();
                aMap.put("type", aType);
                if(((IfcRelSpaceBoundary) ifcObject).getRelatedBuildingElement() != null){
//                    string = string + ((IfcRelSpaceBoundary) ifcObject).getRelatedBuildingElement().getClass().getSimpleName()
//                            + " " + ((IfcRelSpaceBoundary) ifcObject).getRelatedBuildingElement().getStepLineNumber() + "\n";
                    bID = ((IfcRelSpaceBoundary) ifcObject).getRelatedBuildingElement().getStepLineNumber();
                    bType = ((IfcRelSpaceBoundary) ifcObject).getRelatedBuildingElement().getClass().getSimpleName();
                    bMap = new HashMap<>();
                    relMap = new HashMap<>();
                    bMap.put("type", bMap);
                    relationship = RelTypes.IfcRelSpaceBoundary;
                    relType = "IfcRelSpaceBoundary";
                    relMap.put("type",relType);
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
                aMap  = new HashMap<>();
                bMap = new HashMap<>();
                relMap = new HashMap<>();
                aMap.put("type", aType);
                bMap.put("type", bType);
                relMap.put("type", relType);
                flag = 1;
            } else if(ifcObject instanceof IfcRelAggregates) {
//                string = new String("IfcRelAggregates " + ifcObject.getStepLineNumber() + ":\n" + "   RelatingObject :" + ((IfcRelAggregates) ifcObject).getRelatingObject().getClass().getSimpleName()
//                        + " " + ((IfcRelAggregates) ifcObject).getRelatingObject().getStepLineNumber() + "\n"
//                        + "   RelatedObjects:");
                aID = ((IfcRelAggregates) ifcObject).getRelatingObject().getStepLineNumber();
                aType = ((IfcRelAggregates) ifcObject).getRelatingObject().getClass().getSimpleName();
                relationship = RelTypes.IfcRelAggregates;
                relType = "IfcRelAggregates";
                aMap  = new HashMap<>();
                aMap.put("type", aType);
                relMap = new HashMap<>();
                relMap.put("type", relType);
                bMapMap = new HashMap<>();
                Iterator<IfcObjectDefinition> ifcObjectDefinitionIterator = ((IfcRelAggregates) ifcObject).getRelatedObjects().iterator();
                while (ifcObjectDefinitionIterator.hasNext()) {
                    IfcObjectDefinition ifcObjectDefinition = ifcObjectDefinitionIterator.next();
//                    string = string + ifcObjectDefinition.getClass().getSimpleName() + " " + ifcObjectDefinition.getStepLineNumber() + " ";
                    bID =  ifcObjectDefinition.getStepLineNumber();
                    bType = ifcObjectDefinition.getClass().getSimpleName();
                    bMap = new HashMap<>();
                    bMap.put("type", bType);
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
                relationship = RelTypes.IfcRelNests;
                relType = "IfcRelNests";
                aMap  = new HashMap<>();
                aMap.put("type", aType);
                relMap = new HashMap<>();
                relMap.put("type", relType);
                bMapMap = new HashMap<>();
                Iterator<IfcObjectDefinition> ifcObjectDefinitionIterator = ((IfcRelNests) ifcObject).getRelatedObjects().iterator();
                while (ifcObjectDefinitionIterator.hasNext()) {
                    IfcObjectDefinition ifcObjectDefinition = ifcObjectDefinitionIterator.next();
//                    string = string + ifcObjectDefinition.getClass().getSimpleName() + " " + ifcObjectDefinition.getStepLineNumber() + " ";
                    bID =  ifcObjectDefinition.getStepLineNumber();
                    bType = ifcObjectDefinition.getClass().getSimpleName();
                    bMap = new HashMap<>();
                    bMap.put("type", bType);
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

            long t1 = System.currentTimeMillis();

            if(aID != 0){
                if(!nodeList.contains(aID)){
                    inserter.createNode(aID,aMap);
                    nodeList.add(aID);
                    System.out.println("aID:" + aID);
                    nodeCount++;
                }
            }
            if(flag == 1){
                if(bID != 0){
                    if(!nodeList.contains(aID)){
                        inserter.createNode(bID, bMap);
                        nodeList.add(bID);
                        System.out.println("bID:" + bID);
                        nodeCount++;
                    }
                    inserter.createRelationship(aID,bID,relationship,relMap);
                    relationshipCount++;
                }
            } else if(flag == 2){
                if(bMapMap != null){
                    for(long bKey : bMapMap.keySet()){
                        if(!nodeList.contains(bKey)){
                            inserter.createNode(bKey,bMapMap.get(bKey));
                            nodeList.add(bKey);
                            System.out.println("bKey:" + bKey);
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
                System.out.println(classId + " " + className);
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
//                            refer.put(classId, );
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
                            System.out.println(i + " parameter is LIST");
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
                                    System.out.println("LIST<>:" + inlineObject.getClass().getName());
                                }
                            }
                        } else if(parameter instanceof SET){
                            System.out.println(i + " parameter is SET");
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
                                    System.out.println("SET<>:" + inlineObject.getClass().getName());
                                }
                            }

                        }
                    } else {
                        System.out.println(i + " parameter is null");
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
            for(Map.Entry<Integer, String> entry : nodes.entrySet()){
                string = entry.getKey() + "," + entry.getValue() + "," + totalCount.get(entry.getKey()) + "," + referCount.get(entry.getKey()) + "," + referredCount.get(entry.getKey()) + System.lineSeparator();
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

    public static void main(String[] args){
        IfcReader ifcReader = new IfcReader(args[0], args[1]);
        ifcReader.generateIfcModel();
        ifcReader.storeReferringToNeo4j();
//        ifcReader.storeProperties();
//        ifcReader.findTriples();
    }
}
