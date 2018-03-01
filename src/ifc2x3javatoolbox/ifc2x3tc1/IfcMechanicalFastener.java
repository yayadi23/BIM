/* Generated By: IFC Tools Project EXPRESS TO JAVA COMPILER: Do not edit this file!! */
package ifc2x3javatoolbox.ifc2x3tc1;
/**
 * This is a default implementation of the entity IfcMechanicalFastener<br><br>
 *<br><br>
 * Copyright: CC BY-NC-SA 3.0 DE (cc) 2013 Eike Tauscher and Michael Theiler<br><br>
 * The whole package including this class is licensed under<br>
 * <a rel='license' href='http://creativecommons.org/licenses/by-nc-sa/3.0/de/deed.en/'>
 * Creative Commons Attribution-Non-Commercial-Share Alike 3.0 Germany</a>.<br><br>
 * If you are using the package or parts of it in any commercial way, a commercial license is required. 
 * Visit <a href='http://www.ifctoolsproject.com'>http://www.ifctoolsproject.com</a> for more information
 * or contact us directly: <a href='mailto:info@ifctoolsproject.com'>info@ifctoolsproject.com</a><br>
 */
public class IfcMechanicalFastener extends IfcFastener implements ClassInterface
{
	private static final String[] nonInverseAttributes = new String[]{"IfcGloballyUniqueId","IfcOwnerHistory","IfcLabel","IfcText","IfcLabel","IfcObjectPlacement","IfcProductRepresentation","IfcIdentifier","IfcPositiveLengthMeasure","IfcPositiveLengthMeasure"};
	private java.util.ArrayList<CloneableObject> stepParameter = null;
	private java.util.HashSet<ObjectChangeListener> listenerList = null;
	protected int stepLineNumber;
	/** NominalDiameter is an OPTIONAL attribute**/
	protected IfcPositiveLengthMeasure NominalDiameter;
	/** NominalLength is an OPTIONAL attribute**/
	protected IfcPositiveLengthMeasure NominalLength;
	/**
	* The default constructor.
	**/
	public IfcMechanicalFastener(){}

	private static final String[] attributes = new String[]{"GlobalId","OwnerHistory","Name","Description"
			,"ObjectType","ObjectPlacement","Representation","Tag","NominalDiameter","NominalLength"};

	public String[] getAttributes() {
		return IfcMechanicalFastener.attributes;
	}

	/**
	* Constructs a new IfcMechanicalFastener object using the given parameters.
	*
	* @param GlobalId DEMANDED parameter of type IfcGloballyUniqueId - may not be null.
	* @param OwnerHistory DEMANDED parameter of type IfcOwnerHistory - may not be null.
	* @param Name OPTIONAL parameter of type IfcLabel
	* @param Description OPTIONAL parameter of type IfcText
	* @param ObjectType OPTIONAL parameter of type IfcLabel
	* @param ObjectPlacement OPTIONAL parameter of type IfcObjectPlacement
	* @param Representation OPTIONAL parameter of type IfcProductRepresentation
	* @param Tag OPTIONAL parameter of type IfcIdentifier
	* @param NominalDiameter OPTIONAL parameter of type IfcPositiveLengthMeasure
	* @param NominalLength OPTIONAL parameter of type IfcPositiveLengthMeasure
	**/
	public IfcMechanicalFastener(IfcGloballyUniqueId GlobalId, IfcOwnerHistory OwnerHistory, IfcLabel Name, IfcText Description, IfcLabel ObjectType, IfcObjectPlacement ObjectPlacement, IfcProductRepresentation Representation, IfcIdentifier Tag, IfcPositiveLengthMeasure NominalDiameter, IfcPositiveLengthMeasure NominalLength)
	{
		this.GlobalId = GlobalId;
		this.OwnerHistory = OwnerHistory;
		this.Name = Name;
		this.Description = Description;
		this.ObjectType = ObjectType;
		this.ObjectPlacement = ObjectPlacement;
		this.Representation = Representation;
		this.Tag = Tag;
		this.NominalDiameter = NominalDiameter;
		this.NominalLength = NominalLength;
		resolveInverses();
	}

	/**
	 * This method initializes the IfcMechanicalFastener object using the given parameters.
	*
	* @param GlobalId DEMANDED parameter of type IfcGloballyUniqueId - may not be null.
	* @param OwnerHistory DEMANDED parameter of type IfcOwnerHistory - may not be null.
	* @param Name OPTIONAL parameter of type IfcLabel
	* @param Description OPTIONAL parameter of type IfcText
	* @param ObjectType OPTIONAL parameter of type IfcLabel
	* @param ObjectPlacement OPTIONAL parameter of type IfcObjectPlacement
	* @param Representation OPTIONAL parameter of type IfcProductRepresentation
	* @param Tag OPTIONAL parameter of type IfcIdentifier
	* @param NominalDiameter OPTIONAL parameter of type IfcPositiveLengthMeasure
	* @param NominalLength OPTIONAL parameter of type IfcPositiveLengthMeasure
	**/
	public void setParameters(IfcGloballyUniqueId GlobalId, IfcOwnerHistory OwnerHistory, IfcLabel Name, IfcText Description, IfcLabel ObjectType, IfcObjectPlacement ObjectPlacement, IfcProductRepresentation Representation, IfcIdentifier Tag, IfcPositiveLengthMeasure NominalDiameter, IfcPositiveLengthMeasure NominalLength)
	{
		this.GlobalId = GlobalId;
		this.OwnerHistory = OwnerHistory;
		this.Name = Name;
		this.Description = Description;
		this.ObjectType = ObjectType;
		this.ObjectPlacement = ObjectPlacement;
		this.Representation = Representation;
		this.Tag = Tag;
		this.NominalDiameter = NominalDiameter;
		this.NominalLength = NominalLength;
		resolveInverses();
	}

	/**
	 * This method is used internally and should NOT be used for own purposes.
	**/
	void initialize(java.util.ArrayList<CloneableObject> parameters)
	{
		this.GlobalId = (IfcGloballyUniqueId) parameters.get(0);
		this.OwnerHistory = (IfcOwnerHistory) parameters.get(1);
		this.Name = (IfcLabel) parameters.get(2);
		this.Description = (IfcText) parameters.get(3);
		this.ObjectType = (IfcLabel) parameters.get(4);
		this.ObjectPlacement = (IfcObjectPlacement) parameters.get(5);
		this.Representation = (IfcProductRepresentation) parameters.get(6);
		this.Tag = (IfcIdentifier) parameters.get(7);
		this.NominalDiameter = (IfcPositiveLengthMeasure) parameters.get(8);
		this.NominalLength = (IfcPositiveLengthMeasure) parameters.get(9);
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
		if(ObjectPlacement != null)
		{
				if(ObjectPlacement.PlacesObject_Inverse == null)
				{
					ObjectPlacement.PlacesObject_Inverse = new SET<IfcProduct>();
				}
				ObjectPlacement.PlacesObject_Inverse.add(this);
		}
		if(Representation != null)
		{
				if(Representation instanceof IfcProductDefinitionShape)
				{
				if(((IfcProductDefinitionShape)Representation).ShapeOfProduct_Inverse == null)
				{
					((IfcProductDefinitionShape)Representation).ShapeOfProduct_Inverse = new SET<IfcProduct>();
				}
				((IfcProductDefinitionShape)Representation).ShapeOfProduct_Inverse.add(this);
				}
		}
	}

	/**
	 * This method is used internally and should NOT be used for own purposes.
	**/
	String[] getNonInverseAttributeTypes()
	{
		return IfcMechanicalFastener.nonInverseAttributes;	}

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
		stepString = stepString.concat("IFCMECHANICALFASTENER(");
		if(getRedefinedDerivedAttributeTypes().contains("GlobalId")) stepString = stepString.concat("*,");
		else{
		if(this.GlobalId != null)		stepString = stepString.concat(((RootInterface)this.GlobalId).getStepParameter(IfcGloballyUniqueId.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("OwnerHistory")) stepString = stepString.concat("*,");
		else{
		if(this.OwnerHistory != null)		stepString = stepString.concat(((RootInterface)this.OwnerHistory).getStepParameter(IfcOwnerHistory.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("Name")) stepString = stepString.concat("*,");
		else{
		if(this.Name != null)		stepString = stepString.concat(((RootInterface)this.Name).getStepParameter(IfcLabel.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("Description")) stepString = stepString.concat("*,");
		else{
		if(this.Description != null)		stepString = stepString.concat(((RootInterface)this.Description).getStepParameter(IfcText.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("ObjectType")) stepString = stepString.concat("*,");
		else{
		if(this.ObjectType != null)		stepString = stepString.concat(((RootInterface)this.ObjectType).getStepParameter(IfcLabel.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("ObjectPlacement")) stepString = stepString.concat("*,");
		else{
		if(this.ObjectPlacement != null)		stepString = stepString.concat(((RootInterface)this.ObjectPlacement).getStepParameter(IfcObjectPlacement.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("Representation")) stepString = stepString.concat("*,");
		else{
		if(this.Representation != null)		stepString = stepString.concat(((RootInterface)this.Representation).getStepParameter(IfcProductRepresentation.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("Tag")) stepString = stepString.concat("*,");
		else{
		if(this.Tag != null)		stepString = stepString.concat(((RootInterface)this.Tag).getStepParameter(IfcIdentifier.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("NominalDiameter")) stepString = stepString.concat("*,");
		else{
		if(this.NominalDiameter != null)		stepString = stepString.concat(((RootInterface)this.NominalDiameter).getStepParameter(IfcPositiveLengthMeasure.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("NominalLength")) stepString = stepString.concat("*);");
		else{
		if(this.NominalLength != null)		stepString = stepString.concat(((RootInterface)this.NominalLength).getStepParameter(IfcPositiveLengthMeasure.class.isInterface())+");");
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
	* This method sets the NominalDiameter attribute to the given value.
	*
	* @param NominalDiameter DEMANDED value to set - may not be null
	**/
	public void setNominalDiameter(IfcPositiveLengthMeasure NominalDiameter)
	{
		this.NominalDiameter = NominalDiameter;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the NominalDiameter attribute.
	*
	* @return the value of NominalDiameter
	/**/
	public IfcPositiveLengthMeasure getNominalDiameter()
	{
		return this.NominalDiameter;
	}

	/**
	* This method sets the NominalLength attribute to the given value.
	*
	* @param NominalLength DEMANDED value to set - may not be null
	**/
	public void setNominalLength(IfcPositiveLengthMeasure NominalLength)
	{
		this.NominalLength = NominalLength;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the NominalLength attribute.
	*
	* @return the value of NominalLength
	/**/
	public IfcPositiveLengthMeasure getNominalLength()
	{
		return this.NominalLength;
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
		IfcMechanicalFastener ifcMechanicalFastener = new IfcMechanicalFastener();
		if(this.GlobalId != null)
			ifcMechanicalFastener.setGlobalId((IfcGloballyUniqueId)this.GlobalId.clone());
		if(this.OwnerHistory != null)
			ifcMechanicalFastener.setOwnerHistory((IfcOwnerHistory)this.OwnerHistory.clone());
		if(this.Name != null)
			ifcMechanicalFastener.setName((IfcLabel)this.Name.clone());
		if(this.Description != null)
			ifcMechanicalFastener.setDescription((IfcText)this.Description.clone());
		if(this.ObjectType != null)
			ifcMechanicalFastener.setObjectType((IfcLabel)this.ObjectType.clone());
		if(this.ObjectPlacement != null)
			ifcMechanicalFastener.setObjectPlacement((IfcObjectPlacement)this.ObjectPlacement.clone());
		if(this.Representation != null)
			ifcMechanicalFastener.setRepresentation((IfcProductRepresentation)this.Representation.clone());
		if(this.Tag != null)
			ifcMechanicalFastener.setTag((IfcIdentifier)this.Tag.clone());
		if(this.NominalDiameter != null)
			ifcMechanicalFastener.setNominalDiameter((IfcPositiveLengthMeasure)this.NominalDiameter.clone());
		if(this.NominalLength != null)
			ifcMechanicalFastener.setNominalLength((IfcPositiveLengthMeasure)this.NominalLength.clone());
		return ifcMechanicalFastener;
	}

	/**
	 * This method copys the object as shallow copy (all referenced objects are remaining).
	 *
	 * @return the cloned object
	**/
	public Object shallowCopy()
	{
		IfcMechanicalFastener ifcMechanicalFastener = new IfcMechanicalFastener();
		if(this.GlobalId != null)
			ifcMechanicalFastener.setGlobalId(this.GlobalId);
		if(this.OwnerHistory != null)
			ifcMechanicalFastener.setOwnerHistory(this.OwnerHistory);
		if(this.Name != null)
			ifcMechanicalFastener.setName(this.Name);
		if(this.Description != null)
			ifcMechanicalFastener.setDescription(this.Description);
		if(this.ObjectType != null)
			ifcMechanicalFastener.setObjectType(this.ObjectType);
		if(this.ObjectPlacement != null)
			ifcMechanicalFastener.setObjectPlacement(this.ObjectPlacement);
		if(this.Representation != null)
			ifcMechanicalFastener.setRepresentation(this.Representation);
		if(this.Tag != null)
			ifcMechanicalFastener.setTag(this.Tag);
		if(this.NominalDiameter != null)
			ifcMechanicalFastener.setNominalDiameter(this.NominalDiameter);
		if(this.NominalLength != null)
			ifcMechanicalFastener.setNominalLength(this.NominalLength);
		return ifcMechanicalFastener;
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
