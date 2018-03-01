/* Generated By: IFC Tools Project EXPRESS TO JAVA COMPILER: Do not edit this file!! */
package ifc2x3javatoolbox.ifc2x3tc1;
/**
 * This is a default implementation of the entity IfcGeneralProfileProperties<br><br>
 *<br><br>
 * Copyright: CC BY-NC-SA 3.0 DE (cc) 2013 Eike Tauscher and Michael Theiler<br><br>
 * The whole package including this class is licensed under<br>
 * <a rel='license' href='http://creativecommons.org/licenses/by-nc-sa/3.0/de/deed.en/'>
 * Creative Commons Attribution-Non-Commercial-Share Alike 3.0 Germany</a>.<br><br>
 * If you are using the package or parts of it in any commercial way, a commercial license is required. 
 * Visit <a href='http://www.ifctoolsproject.com'>http://www.ifctoolsproject.com</a> for more information
 * or contact us directly: <a href='mailto:info@ifctoolsproject.com'>info@ifctoolsproject.com</a><br>
 */
public class IfcGeneralProfileProperties extends IfcProfileProperties implements ClassInterface
{
	private static final String[] nonInverseAttributes = new String[]{"IfcLabel","IfcProfileDef","IfcMassPerLengthMeasure","IfcPositiveLengthMeasure","IfcPositiveLengthMeasure","IfcPositiveLengthMeasure","IfcAreaMeasure"};
	private java.util.ArrayList<CloneableObject> stepParameter = null;
	private java.util.HashSet<ObjectChangeListener> listenerList = null;
	protected int stepLineNumber;
	/** PhysicalWeight is an OPTIONAL attribute**/
	protected IfcMassPerLengthMeasure PhysicalWeight;
	/** Perimeter is an OPTIONAL attribute**/
	protected IfcPositiveLengthMeasure Perimeter;
	/** MinimumPlateThickness is an OPTIONAL attribute**/
	protected IfcPositiveLengthMeasure MinimumPlateThickness;
	/** MaximumPlateThickness is an OPTIONAL attribute**/
	protected IfcPositiveLengthMeasure MaximumPlateThickness;
	/** CrossSectionArea is an OPTIONAL attribute**/
	protected IfcAreaMeasure CrossSectionArea;
	/**
	* The default constructor.
	**/
	public IfcGeneralProfileProperties(){}

	private static final String[] attributes = new String[]{"ProfileName","ProfileDefinition","PhysicalWeight"
			,"Perimeter","MinimumPlateThickness","MaximumPlateThickness","CrossSectionArea"};

	public String[] getAttributes() {
		return IfcGeneralProfileProperties.attributes;
	}

	/**
	* Constructs a new IfcGeneralProfileProperties object using the given parameters.
	*
	* @param ProfileName OPTIONAL parameter of type IfcLabel
	* @param ProfileDefinition OPTIONAL parameter of type IfcProfileDef
	* @param PhysicalWeight OPTIONAL parameter of type IfcMassPerLengthMeasure
	* @param Perimeter OPTIONAL parameter of type IfcPositiveLengthMeasure
	* @param MinimumPlateThickness OPTIONAL parameter of type IfcPositiveLengthMeasure
	* @param MaximumPlateThickness OPTIONAL parameter of type IfcPositiveLengthMeasure
	* @param CrossSectionArea OPTIONAL parameter of type IfcAreaMeasure
	**/
	public IfcGeneralProfileProperties(IfcLabel ProfileName, IfcProfileDef ProfileDefinition, IfcMassPerLengthMeasure PhysicalWeight, IfcPositiveLengthMeasure Perimeter, IfcPositiveLengthMeasure MinimumPlateThickness, IfcPositiveLengthMeasure MaximumPlateThickness, IfcAreaMeasure CrossSectionArea)
	{
		this.ProfileName = ProfileName;
		this.ProfileDefinition = ProfileDefinition;
		this.PhysicalWeight = PhysicalWeight;
		this.Perimeter = Perimeter;
		this.MinimumPlateThickness = MinimumPlateThickness;
		this.MaximumPlateThickness = MaximumPlateThickness;
		this.CrossSectionArea = CrossSectionArea;
		resolveInverses();
	}

	/**
	 * This method initializes the IfcGeneralProfileProperties object using the given parameters.
	*
	* @param ProfileName OPTIONAL parameter of type IfcLabel
	* @param ProfileDefinition OPTIONAL parameter of type IfcProfileDef
	* @param PhysicalWeight OPTIONAL parameter of type IfcMassPerLengthMeasure
	* @param Perimeter OPTIONAL parameter of type IfcPositiveLengthMeasure
	* @param MinimumPlateThickness OPTIONAL parameter of type IfcPositiveLengthMeasure
	* @param MaximumPlateThickness OPTIONAL parameter of type IfcPositiveLengthMeasure
	* @param CrossSectionArea OPTIONAL parameter of type IfcAreaMeasure
	**/
	public void setParameters(IfcLabel ProfileName, IfcProfileDef ProfileDefinition, IfcMassPerLengthMeasure PhysicalWeight, IfcPositiveLengthMeasure Perimeter, IfcPositiveLengthMeasure MinimumPlateThickness, IfcPositiveLengthMeasure MaximumPlateThickness, IfcAreaMeasure CrossSectionArea)
	{
		this.ProfileName = ProfileName;
		this.ProfileDefinition = ProfileDefinition;
		this.PhysicalWeight = PhysicalWeight;
		this.Perimeter = Perimeter;
		this.MinimumPlateThickness = MinimumPlateThickness;
		this.MaximumPlateThickness = MaximumPlateThickness;
		this.CrossSectionArea = CrossSectionArea;
		resolveInverses();
	}

	/**
	 * This method is used internally and should NOT be used for own purposes.
	**/
	void initialize(java.util.ArrayList<CloneableObject> parameters)
	{
		this.ProfileName = (IfcLabel) parameters.get(0);
		this.ProfileDefinition = (IfcProfileDef) parameters.get(1);
		this.PhysicalWeight = (IfcMassPerLengthMeasure) parameters.get(2);
		this.Perimeter = (IfcPositiveLengthMeasure) parameters.get(3);
		this.MinimumPlateThickness = (IfcPositiveLengthMeasure) parameters.get(4);
		this.MaximumPlateThickness = (IfcPositiveLengthMeasure) parameters.get(5);
		this.CrossSectionArea = (IfcAreaMeasure) parameters.get(6);
		resolveInverses();
	}

	/**
	 * This method is used internally and should NOT be used for own purposes.
	**/
	void destruct()
	{
		 super.destruct();
		listenerList = null;
	}

	private void resolveInverses()
	{
	}

	/**
	 * This method is used internally and should NOT be used for own purposes.
	**/
	String[] getNonInverseAttributeTypes()
	{
		return IfcGeneralProfileProperties.nonInverseAttributes;	}

	/**
	 * This method is used internally and should NOT be used for own purposes.
	**/
	private java.util.HashSet<String> getRedefinedDerivedAttributeTypes()
	{
		java.util.HashSet<String> redefinedDerivedAttributes = new java.util.HashSet<String>();
		return redefinedDerivedAttributes;	}

	/**
 * This method returns the object IFC  STEP representation. This method is called by the IfcModel object to write IFC STEP files.
	 *
	 * @return the IFC STEP representation of this object
	**/
	public String getStepLine()
	{
		String stepString = new String("#"+this.stepLineNumber+"= ");
		stepString = stepString.concat("IFCGENERALPROFILEPROPERTIES(");
		if(getRedefinedDerivedAttributeTypes().contains("ProfileName")) stepString = stepString.concat("*,");
		else{
		if(this.ProfileName != null)		stepString = stepString.concat(((RootInterface)this.ProfileName).getStepParameter(IfcLabel.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("ProfileDefinition")) stepString = stepString.concat("*,");
		else{
		if(this.ProfileDefinition != null)		stepString = stepString.concat(((RootInterface)this.ProfileDefinition).getStepParameter(IfcProfileDef.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("PhysicalWeight")) stepString = stepString.concat("*,");
		else{
		if(this.PhysicalWeight != null)		stepString = stepString.concat(((RootInterface)this.PhysicalWeight).getStepParameter(IfcMassPerLengthMeasure.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("Perimeter")) stepString = stepString.concat("*,");
		else{
		if(this.Perimeter != null)		stepString = stepString.concat(((RootInterface)this.Perimeter).getStepParameter(IfcPositiveLengthMeasure.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("MinimumPlateThickness")) stepString = stepString.concat("*,");
		else{
		if(this.MinimumPlateThickness != null)		stepString = stepString.concat(((RootInterface)this.MinimumPlateThickness).getStepParameter(IfcPositiveLengthMeasure.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("MaximumPlateThickness")) stepString = stepString.concat("*,");
		else{
		if(this.MaximumPlateThickness != null)		stepString = stepString.concat(((RootInterface)this.MaximumPlateThickness).getStepParameter(IfcPositiveLengthMeasure.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("CrossSectionArea")) stepString = stepString.concat("*);");
		else{
		if(this.CrossSectionArea != null)		stepString = stepString.concat(((RootInterface)this.CrossSectionArea).getStepParameter(IfcAreaMeasure.class.isInterface())+");");
		else		stepString = stepString.concat("$);");
		}
		return stepString;
	}

	/**
	 * This method is used internally and should NOT be used for own purposes.
	**/
	public String getStepParameter(boolean isSelectType)
	{
		return "#" + this.stepLineNumber;
	}

	/**
	 * This method returns the line number within a IFC  STEP representation. This method is called from other objects, where this one is referenced.
	 *
	 * @return the STEP line number
	**/
	public int getStepLineNumber()
	{
		return this.stepLineNumber;
	}

	/**
	 * This method is used internally and should NOT be used for own purposes.
	**/
	void setStepLineNumber(int number)
	{
		this.stepLineNumber = number;
	}

	/**
	* This method sets the PhysicalWeight attribute to the given value.
	*
	* @param PhysicalWeight DEMANDED value to set - may not be null
	**/
	public void setPhysicalWeight(IfcMassPerLengthMeasure PhysicalWeight)
	{
		this.PhysicalWeight = PhysicalWeight;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the PhysicalWeight attribute.
	*
	* @return the value of PhysicalWeight
	/**/
	public IfcMassPerLengthMeasure getPhysicalWeight()
	{
		return this.PhysicalWeight;
	}

	/**
	* This method sets the Perimeter attribute to the given value.
	*
	* @param Perimeter DEMANDED value to set - may not be null
	**/
	public void setPerimeter(IfcPositiveLengthMeasure Perimeter)
	{
		this.Perimeter = Perimeter;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the Perimeter attribute.
	*
	* @return the value of Perimeter
	/**/
	public IfcPositiveLengthMeasure getPerimeter()
	{
		return this.Perimeter;
	}

	/**
	* This method sets the MinimumPlateThickness attribute to the given value.
	*
	* @param MinimumPlateThickness DEMANDED value to set - may not be null
	**/
	public void setMinimumPlateThickness(IfcPositiveLengthMeasure MinimumPlateThickness)
	{
		this.MinimumPlateThickness = MinimumPlateThickness;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the MinimumPlateThickness attribute.
	*
	* @return the value of MinimumPlateThickness
	/**/
	public IfcPositiveLengthMeasure getMinimumPlateThickness()
	{
		return this.MinimumPlateThickness;
	}

	/**
	* This method sets the MaximumPlateThickness attribute to the given value.
	*
	* @param MaximumPlateThickness DEMANDED value to set - may not be null
	**/
	public void setMaximumPlateThickness(IfcPositiveLengthMeasure MaximumPlateThickness)
	{
		this.MaximumPlateThickness = MaximumPlateThickness;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the MaximumPlateThickness attribute.
	*
	* @return the value of MaximumPlateThickness
	/**/
	public IfcPositiveLengthMeasure getMaximumPlateThickness()
	{
		return this.MaximumPlateThickness;
	}

	/**
	* This method sets the CrossSectionArea attribute to the given value.
	*
	* @param CrossSectionArea DEMANDED value to set - may not be null
	**/
	public void setCrossSectionArea(IfcAreaMeasure CrossSectionArea)
	{
		this.CrossSectionArea = CrossSectionArea;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the CrossSectionArea attribute.
	*
	* @return the value of CrossSectionArea
	/**/
	public IfcAreaMeasure getCrossSectionArea()
	{
		return this.CrossSectionArea;
	}

	/**
	 * This method is used internally and should NOT be used for own purposes.
	**/
	void setStepParameter(java.util.ArrayList<CloneableObject> parameter)
	{
		this.stepParameter = parameter;
	}

	/**
	 * This method is used internally and should NOT be used for own purposes.
	**/
	java.util.ArrayList<CloneableObject> getStepParameter()
	{
		return this.stepParameter;
	}

	/**
	 * This method registers an ObjectChangeListener to this object. An event is fired whenever one of its values was changed.
	 * 
	 *@param listener the listener to register
	**/
	public void addObjectChangeListener(ObjectChangeListener listener)
	{
		if (listenerList == null)	listenerList = new java.util.HashSet<ObjectChangeListener>(1,1);
		listenerList.add(listener);
	}

	/**
	 * This method unregisters an ObjectChangeListener from this object.
	 * 
	 *@param listener the listener to unregister
	**/
	public void removeObjectChangeListener(ObjectChangeListener listener)
	{
		if (listenerList == null)	return;
		listenerList.remove(listener);
		if (listenerList.size()==0) listenerList = null;
	}

	/**
	 * This method removes all currently registered ObjectChangeListeners from this object.
	**/
	public void removeAllObjectChangeListeners()
	{
		listenerList = null;
	}

	protected void fireChangeEvent()
	{
		if(listenerList == null) return;
		for(ObjectChangeListener listener : listenerList)
			listener.ifcModelObjectChange(this);
	}

	/**
	 * This method clones the object (deep cloning).
	 *
	 * @return the cloned object
	**/
	public Object clone()
	{
		IfcGeneralProfileProperties ifcGeneralProfileProperties = new IfcGeneralProfileProperties();
		if(this.ProfileName != null)
			ifcGeneralProfileProperties.setProfileName((IfcLabel)this.ProfileName.clone());
		if(this.ProfileDefinition != null)
			ifcGeneralProfileProperties.setProfileDefinition((IfcProfileDef)this.ProfileDefinition.clone());
		if(this.PhysicalWeight != null)
			ifcGeneralProfileProperties.setPhysicalWeight((IfcMassPerLengthMeasure)this.PhysicalWeight.clone());
		if(this.Perimeter != null)
			ifcGeneralProfileProperties.setPerimeter((IfcPositiveLengthMeasure)this.Perimeter.clone());
		if(this.MinimumPlateThickness != null)
			ifcGeneralProfileProperties.setMinimumPlateThickness((IfcPositiveLengthMeasure)this.MinimumPlateThickness.clone());
		if(this.MaximumPlateThickness != null)
			ifcGeneralProfileProperties.setMaximumPlateThickness((IfcPositiveLengthMeasure)this.MaximumPlateThickness.clone());
		if(this.CrossSectionArea != null)
			ifcGeneralProfileProperties.setCrossSectionArea((IfcAreaMeasure)this.CrossSectionArea.clone());
		return ifcGeneralProfileProperties;
	}

	/**
	 * This method copys the object as shallow copy (all referenced objects are remaining).
	 *
	 * @return the cloned object
	**/
	public Object shallowCopy()
	{
		IfcGeneralProfileProperties ifcGeneralProfileProperties = new IfcGeneralProfileProperties();
		if(this.ProfileName != null)
			ifcGeneralProfileProperties.setProfileName(this.ProfileName);
		if(this.ProfileDefinition != null)
			ifcGeneralProfileProperties.setProfileDefinition(this.ProfileDefinition);
		if(this.PhysicalWeight != null)
			ifcGeneralProfileProperties.setPhysicalWeight(this.PhysicalWeight);
		if(this.Perimeter != null)
			ifcGeneralProfileProperties.setPerimeter(this.Perimeter);
		if(this.MinimumPlateThickness != null)
			ifcGeneralProfileProperties.setMinimumPlateThickness(this.MinimumPlateThickness);
		if(this.MaximumPlateThickness != null)
			ifcGeneralProfileProperties.setMaximumPlateThickness(this.MaximumPlateThickness);
		if(this.CrossSectionArea != null)
			ifcGeneralProfileProperties.setCrossSectionArea(this.CrossSectionArea);
		return ifcGeneralProfileProperties;
	}

	/**
	* This method returns the objects standard description.
	*
	* @return the standard description
	**/
	public String toString()
	{
		return "#"+ this.getStepLineNumber() + " " + this.getClass().getSimpleName();
	}


}
