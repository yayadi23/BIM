/* Generated By: IFC Tools Project EXPRESS TO JAVA COMPILER: Do not edit this file!! */
package ifc2x3javatoolbox.ifc2x3tc1;
/**
 * This is a default implementation of the entity IfcTransportElement<br><br>
 *<br><br>
 * Copyright: CC BY-NC-SA 3.0 DE (cc) 2013 Eike Tauscher and Michael Theiler<br><br>
 * The whole package including this class is licensed under<br>
 * <a rel='license' href='http://creativecommons.org/licenses/by-nc-sa/3.0/de/deed.en/'>
 * Creative Commons Attribution-Non-Commercial-Share Alike 3.0 Germany</a>.<br><br>
 * If you are using the package or parts of it in any commercial way, a commercial license is required. 
 * Visit <a href='http://www.ifctoolsproject.com'>http://www.ifctoolsproject.com</a> for more information
 * or contact us directly: <a href='mailto:info@ifctoolsproject.com'>info@ifctoolsproject.com</a><br>
 */
public class IfcTransportElement extends IfcElement implements ClassInterface
{
	private static final String[] nonInverseAttributes = new String[]{"IfcGloballyUniqueId","IfcOwnerHistory","IfcLabel","IfcText","IfcLabel","IfcObjectPlacement","IfcProductRepresentation","IfcIdentifier","IfcTransportElementTypeEnum","IfcMassMeasure","IfcCountMeasure"};
	private java.util.ArrayList<CloneableObject> stepParameter = null;
	private java.util.HashSet<ObjectChangeListener> listenerList = null;
	protected int stepLineNumber;
	/** OperationType is an OPTIONAL attribute**/
	protected IfcTransportElementTypeEnum OperationType;
	/** CapacityByWeight is an OPTIONAL attribute**/
	protected IfcMassMeasure CapacityByWeight;
	/** CapacityByNumber is an OPTIONAL attribute**/
	protected IfcCountMeasure CapacityByNumber;
	/**
	* The default constructor.
	**/
	public IfcTransportElement(){}

	/**
	* Constructs a new IfcTransportElement object using the given parameters.
	*
	* @param GlobalId DEMANDED parameter of type IfcGloballyUniqueId - may not be null.
	* @param OwnerHistory DEMANDED parameter of type IfcOwnerHistory - may not be null.
	* @param Name OPTIONAL parameter of type IfcLabel
	* @param Description OPTIONAL parameter of type IfcText
	* @param ObjectType OPTIONAL parameter of type IfcLabel
	* @param ObjectPlacement OPTIONAL parameter of type IfcObjectPlacement
	* @param Representation OPTIONAL parameter of type IfcProductRepresentation
	* @param Tag OPTIONAL parameter of type IfcIdentifier
	* @param OperationType OPTIONAL parameter of type IfcTransportElementTypeEnum
	* @param CapacityByWeight OPTIONAL parameter of type IfcMassMeasure
	* @param CapacityByNumber OPTIONAL parameter of type IfcCountMeasure
	**/
	public IfcTransportElement(IfcGloballyUniqueId GlobalId, IfcOwnerHistory OwnerHistory, IfcLabel Name, IfcText Description, IfcLabel ObjectType, IfcObjectPlacement ObjectPlacement, IfcProductRepresentation Representation, IfcIdentifier Tag, IfcTransportElementTypeEnum OperationType, IfcMassMeasure CapacityByWeight, IfcCountMeasure CapacityByNumber)
	{
		this.GlobalId = GlobalId;
		this.OwnerHistory = OwnerHistory;
		this.Name = Name;
		this.Description = Description;
		this.ObjectType = ObjectType;
		this.ObjectPlacement = ObjectPlacement;
		this.Representation = Representation;
		this.Tag = Tag;
		this.OperationType = OperationType;
		this.CapacityByWeight = CapacityByWeight;
		this.CapacityByNumber = CapacityByNumber;
		resolveInverses();
	}

	/**
	 * This method initializes the IfcTransportElement object using the given parameters.
	*
	* @param GlobalId DEMANDED parameter of type IfcGloballyUniqueId - may not be null.
	* @param OwnerHistory DEMANDED parameter of type IfcOwnerHistory - may not be null.
	* @param Name OPTIONAL parameter of type IfcLabel
	* @param Description OPTIONAL parameter of type IfcText
	* @param ObjectType OPTIONAL parameter of type IfcLabel
	* @param ObjectPlacement OPTIONAL parameter of type IfcObjectPlacement
	* @param Representation OPTIONAL parameter of type IfcProductRepresentation
	* @param Tag OPTIONAL parameter of type IfcIdentifier
	* @param OperationType OPTIONAL parameter of type IfcTransportElementTypeEnum
	* @param CapacityByWeight OPTIONAL parameter of type IfcMassMeasure
	* @param CapacityByNumber OPTIONAL parameter of type IfcCountMeasure
	**/
	public void setParameters(IfcGloballyUniqueId GlobalId, IfcOwnerHistory OwnerHistory, IfcLabel Name, IfcText Description, IfcLabel ObjectType, IfcObjectPlacement ObjectPlacement, IfcProductRepresentation Representation, IfcIdentifier Tag, IfcTransportElementTypeEnum OperationType, IfcMassMeasure CapacityByWeight, IfcCountMeasure CapacityByNumber)
	{
		this.GlobalId = GlobalId;
		this.OwnerHistory = OwnerHistory;
		this.Name = Name;
		this.Description = Description;
		this.ObjectType = ObjectType;
		this.ObjectPlacement = ObjectPlacement;
		this.Representation = Representation;
		this.Tag = Tag;
		this.OperationType = OperationType;
		this.CapacityByWeight = CapacityByWeight;
		this.CapacityByNumber = CapacityByNumber;
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
		this.OperationType = (IfcTransportElementTypeEnum) parameters.get(8);
		this.CapacityByWeight = (IfcMassMeasure) parameters.get(9);
		this.CapacityByNumber = (IfcCountMeasure) parameters.get(10);
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
		return IfcTransportElement.nonInverseAttributes;	}

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
		stepString = stepString.concat("IFCTRANSPORTELEMENT(");
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
		if(getRedefinedDerivedAttributeTypes().contains("OperationType")) stepString = stepString.concat("*,");
		else{
		if(this.OperationType != null)		stepString = stepString.concat(((RootInterface)this.OperationType).getStepParameter(IfcTransportElementTypeEnum.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("CapacityByWeight")) stepString = stepString.concat("*,");
		else{
		if(this.CapacityByWeight != null)		stepString = stepString.concat(((RootInterface)this.CapacityByWeight).getStepParameter(IfcMassMeasure.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("CapacityByNumber")) stepString = stepString.concat("*);");
		else{
		if(this.CapacityByNumber != null)		stepString = stepString.concat(((RootInterface)this.CapacityByNumber).getStepParameter(IfcCountMeasure.class.isInterface())+");");
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
	* This method sets the OperationType attribute to the given value.
	*
	* @param OperationType DEMANDED value to set - may not be null
	**/
	public void setOperationType(IfcTransportElementTypeEnum OperationType)
	{
		this.OperationType = OperationType;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the OperationType attribute.
	*
	* @return the value of OperationType
	/**/
	public IfcTransportElementTypeEnum getOperationType()
	{
		return this.OperationType;
	}

	/**
	* This method sets the CapacityByWeight attribute to the given value.
	*
	* @param CapacityByWeight DEMANDED value to set - may not be null
	**/
	public void setCapacityByWeight(IfcMassMeasure CapacityByWeight)
	{
		this.CapacityByWeight = CapacityByWeight;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the CapacityByWeight attribute.
	*
	* @return the value of CapacityByWeight
	/**/
	public IfcMassMeasure getCapacityByWeight()
	{
		return this.CapacityByWeight;
	}

	/**
	* This method sets the CapacityByNumber attribute to the given value.
	*
	* @param CapacityByNumber DEMANDED value to set - may not be null
	**/
	public void setCapacityByNumber(IfcCountMeasure CapacityByNumber)
	{
		this.CapacityByNumber = CapacityByNumber;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the CapacityByNumber attribute.
	*
	* @return the value of CapacityByNumber
	/**/
	public IfcCountMeasure getCapacityByNumber()
	{
		return this.CapacityByNumber;
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
		IfcTransportElement ifcTransportElement = new IfcTransportElement();
		if(this.GlobalId != null)
			ifcTransportElement.setGlobalId((IfcGloballyUniqueId)this.GlobalId.clone());
		if(this.OwnerHistory != null)
			ifcTransportElement.setOwnerHistory((IfcOwnerHistory)this.OwnerHistory.clone());
		if(this.Name != null)
			ifcTransportElement.setName((IfcLabel)this.Name.clone());
		if(this.Description != null)
			ifcTransportElement.setDescription((IfcText)this.Description.clone());
		if(this.ObjectType != null)
			ifcTransportElement.setObjectType((IfcLabel)this.ObjectType.clone());
		if(this.ObjectPlacement != null)
			ifcTransportElement.setObjectPlacement((IfcObjectPlacement)this.ObjectPlacement.clone());
		if(this.Representation != null)
			ifcTransportElement.setRepresentation((IfcProductRepresentation)this.Representation.clone());
		if(this.Tag != null)
			ifcTransportElement.setTag((IfcIdentifier)this.Tag.clone());
		if(this.OperationType != null)
			ifcTransportElement.setOperationType((IfcTransportElementTypeEnum)this.OperationType.clone());
		if(this.CapacityByWeight != null)
			ifcTransportElement.setCapacityByWeight((IfcMassMeasure)this.CapacityByWeight.clone());
		if(this.CapacityByNumber != null)
			ifcTransportElement.setCapacityByNumber((IfcCountMeasure)this.CapacityByNumber.clone());
		return ifcTransportElement;
	}

	/**
	 * This method copys the object as shallow copy (all referenced objects are remaining).
	 *
	 * @return the cloned object
	**/
	public Object shallowCopy()
	{
		IfcTransportElement ifcTransportElement = new IfcTransportElement();
		if(this.GlobalId != null)
			ifcTransportElement.setGlobalId(this.GlobalId);
		if(this.OwnerHistory != null)
			ifcTransportElement.setOwnerHistory(this.OwnerHistory);
		if(this.Name != null)
			ifcTransportElement.setName(this.Name);
		if(this.Description != null)
			ifcTransportElement.setDescription(this.Description);
		if(this.ObjectType != null)
			ifcTransportElement.setObjectType(this.ObjectType);
		if(this.ObjectPlacement != null)
			ifcTransportElement.setObjectPlacement(this.ObjectPlacement);
		if(this.Representation != null)
			ifcTransportElement.setRepresentation(this.Representation);
		if(this.Tag != null)
			ifcTransportElement.setTag(this.Tag);
		if(this.OperationType != null)
			ifcTransportElement.setOperationType(this.OperationType);
		if(this.CapacityByWeight != null)
			ifcTransportElement.setCapacityByWeight(this.CapacityByWeight);
		if(this.CapacityByNumber != null)
			ifcTransportElement.setCapacityByNumber(this.CapacityByNumber);
		return ifcTransportElement;
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