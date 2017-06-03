/* Generated By: IFC Tools Project EXPRESS TO JAVA COMPILER: Do not edit this file!! */
package ifc2x3javatoolbox.ifc2x3tc1;
/**
 * This is a default implementation of the entity IfcInventory<br><br>
 *<br><br>
 * Copyright: CC BY-NC-SA 3.0 DE (cc) 2013 Eike Tauscher and Michael Theiler<br><br>
 * The whole package including this class is licensed under<br>
 * <a rel='license' href='http://creativecommons.org/licenses/by-nc-sa/3.0/de/deed.en/'>
 * Creative Commons Attribution-Non-Commercial-Share Alike 3.0 Germany</a>.<br><br>
 * If you are using the package or parts of it in any commercial way, a commercial license is required. 
 * Visit <a href='http://www.ifctoolsproject.com'>http://www.ifctoolsproject.com</a> for more information
 * or contact us directly: <a href='mailto:info@ifctoolsproject.com'>info@ifctoolsproject.com</a><br>
 */
public class IfcInventory extends IfcGroup implements ClassInterface
{
	private static final String[] nonInverseAttributes = new String[]{"IfcGloballyUniqueId","IfcOwnerHistory","IfcLabel","IfcText","IfcLabel","IfcInventoryTypeEnum","IfcActorSelect","SET<IfcPerson>","IfcCalendarDate","IfcCostValue","IfcCostValue"};
	private java.util.ArrayList<CloneableObject> stepParameter = null;
	private java.util.HashSet<ObjectChangeListener> listenerList = null;
	protected int stepLineNumber;
	/** InventoryType is an DEMANDED attribute - may not be null**/
	protected IfcInventoryTypeEnum InventoryType;
	/** Jurisdiction is an DEMANDED attribute - may not be null**/
	protected IfcActorSelect Jurisdiction;
	/** ResponsiblePersons is an DEMANDED attribute - may not be null**/
	protected SET<IfcPerson> ResponsiblePersons;
	/** LastUpdateDate is an DEMANDED attribute - may not be null**/
	protected IfcCalendarDate LastUpdateDate;
	/** CurrentValue is an OPTIONAL attribute**/
	protected IfcCostValue CurrentValue;
	/** OriginalValue is an OPTIONAL attribute**/
	protected IfcCostValue OriginalValue;
	/**
	* The default constructor.
	**/
	public IfcInventory(){}

	/**
	* Constructs a new IfcInventory object using the given parameters.
	*
	* @param GlobalId DEMANDED parameter of type IfcGloballyUniqueId - may not be null.
	* @param OwnerHistory DEMANDED parameter of type IfcOwnerHistory - may not be null.
	* @param Name OPTIONAL parameter of type IfcLabel
	* @param Description OPTIONAL parameter of type IfcText
	* @param ObjectType OPTIONAL parameter of type IfcLabel
	* @param InventoryType DEMANDED parameter of type IfcInventoryTypeEnum - may not be null.
	* @param Jurisdiction DEMANDED parameter of type IfcActorSelect - may not be null.
	* @param ResponsiblePersons DEMANDED parameter of type SET<IfcPerson> - may not be null.
	* @param LastUpdateDate DEMANDED parameter of type IfcCalendarDate - may not be null.
	* @param CurrentValue OPTIONAL parameter of type IfcCostValue
	* @param OriginalValue OPTIONAL parameter of type IfcCostValue
	**/
	public IfcInventory(IfcGloballyUniqueId GlobalId, IfcOwnerHistory OwnerHistory, IfcLabel Name, IfcText Description, IfcLabel ObjectType, IfcInventoryTypeEnum InventoryType, IfcActorSelect Jurisdiction, SET<IfcPerson> ResponsiblePersons, IfcCalendarDate LastUpdateDate, IfcCostValue CurrentValue, IfcCostValue OriginalValue)
	{
		this.GlobalId = GlobalId;
		this.OwnerHistory = OwnerHistory;
		this.Name = Name;
		this.Description = Description;
		this.ObjectType = ObjectType;
		this.InventoryType = InventoryType;
		this.Jurisdiction = Jurisdiction;
		this.ResponsiblePersons = ResponsiblePersons;
		this.LastUpdateDate = LastUpdateDate;
		this.CurrentValue = CurrentValue;
		this.OriginalValue = OriginalValue;
		resolveInverses();
	}

	/**
	 * This method initializes the IfcInventory object using the given parameters.
	*
	* @param GlobalId DEMANDED parameter of type IfcGloballyUniqueId - may not be null.
	* @param OwnerHistory DEMANDED parameter of type IfcOwnerHistory - may not be null.
	* @param Name OPTIONAL parameter of type IfcLabel
	* @param Description OPTIONAL parameter of type IfcText
	* @param ObjectType OPTIONAL parameter of type IfcLabel
	* @param InventoryType DEMANDED parameter of type IfcInventoryTypeEnum - may not be null.
	* @param Jurisdiction DEMANDED parameter of type IfcActorSelect - may not be null.
	* @param ResponsiblePersons DEMANDED parameter of type SET<IfcPerson> - may not be null.
	* @param LastUpdateDate DEMANDED parameter of type IfcCalendarDate - may not be null.
	* @param CurrentValue OPTIONAL parameter of type IfcCostValue
	* @param OriginalValue OPTIONAL parameter of type IfcCostValue
	**/
	public void setParameters(IfcGloballyUniqueId GlobalId, IfcOwnerHistory OwnerHistory, IfcLabel Name, IfcText Description, IfcLabel ObjectType, IfcInventoryTypeEnum InventoryType, IfcActorSelect Jurisdiction, SET<IfcPerson> ResponsiblePersons, IfcCalendarDate LastUpdateDate, IfcCostValue CurrentValue, IfcCostValue OriginalValue)
	{
		this.GlobalId = GlobalId;
		this.OwnerHistory = OwnerHistory;
		this.Name = Name;
		this.Description = Description;
		this.ObjectType = ObjectType;
		this.InventoryType = InventoryType;
		this.Jurisdiction = Jurisdiction;
		this.ResponsiblePersons = ResponsiblePersons;
		this.LastUpdateDate = LastUpdateDate;
		this.CurrentValue = CurrentValue;
		this.OriginalValue = OriginalValue;
		resolveInverses();
	}

	/**
	 * This method is used internally and should NOT be used for own purposes.
	**/
	@SuppressWarnings("unchecked")
	void initialize(java.util.ArrayList<CloneableObject> parameters)
	{
		this.GlobalId = (IfcGloballyUniqueId) parameters.get(0);
		this.OwnerHistory = (IfcOwnerHistory) parameters.get(1);
		this.Name = (IfcLabel) parameters.get(2);
		this.Description = (IfcText) parameters.get(3);
		this.ObjectType = (IfcLabel) parameters.get(4);
		this.InventoryType = (IfcInventoryTypeEnum) parameters.get(5);
		this.Jurisdiction = (IfcActorSelect) parameters.get(6);
		this.ResponsiblePersons = (SET<IfcPerson>) parameters.get(7);
		this.LastUpdateDate = (IfcCalendarDate) parameters.get(8);
		this.CurrentValue = (IfcCostValue) parameters.get(9);
		this.OriginalValue = (IfcCostValue) parameters.get(10);
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
		return IfcInventory.nonInverseAttributes;	}

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
		stepString = stepString.concat("IFCINVENTORY(");
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
		if(getRedefinedDerivedAttributeTypes().contains("InventoryType")) stepString = stepString.concat("*,");
		else{
		if(this.InventoryType != null)		stepString = stepString.concat(((RootInterface)this.InventoryType).getStepParameter(IfcInventoryTypeEnum.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("Jurisdiction")) stepString = stepString.concat("*,");
		else{
		if(this.Jurisdiction != null)		stepString = stepString.concat(((RootInterface)this.Jurisdiction).getStepParameter(IfcActorSelect.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("ResponsiblePersons")) stepString = stepString.concat("*,");
		else{
		if(this.ResponsiblePersons != null)		stepString = stepString.concat(((RootInterface)this.ResponsiblePersons).getStepParameter(IfcPerson.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("LastUpdateDate")) stepString = stepString.concat("*,");
		else{
		if(this.LastUpdateDate != null)		stepString = stepString.concat(((RootInterface)this.LastUpdateDate).getStepParameter(IfcCalendarDate.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("CurrentValue")) stepString = stepString.concat("*,");
		else{
		if(this.CurrentValue != null)		stepString = stepString.concat(((RootInterface)this.CurrentValue).getStepParameter(IfcCostValue.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("OriginalValue")) stepString = stepString.concat("*);");
		else{
		if(this.OriginalValue != null)		stepString = stepString.concat(((RootInterface)this.OriginalValue).getStepParameter(IfcCostValue.class.isInterface())+");");
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
	* This method sets the InventoryType attribute to the given value.
	*
	* @param InventoryType OPTIONAL value to set
	**/
	public void setInventoryType(IfcInventoryTypeEnum InventoryType)
	{
		this.InventoryType = InventoryType;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the InventoryType attribute.
	*
	* @return the value of InventoryType
	/**/
	public IfcInventoryTypeEnum getInventoryType()
	{
		return this.InventoryType;
	}

	/**
	* This method sets the Jurisdiction attribute to the given value.
	*
	* @param Jurisdiction OPTIONAL value to set
	**/
	public void setJurisdiction(IfcActorSelect Jurisdiction)
	{
		this.Jurisdiction = Jurisdiction;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the Jurisdiction attribute.
	*
	* @return the value of Jurisdiction
	/**/
	public IfcActorSelect getJurisdiction()
	{
		return this.Jurisdiction;
	}

	/**
	* This method sets the ResponsiblePersons attribute to the given value.
	*
	* @param ResponsiblePersons OPTIONAL value to set
	**/
	public void setResponsiblePersons(SET<IfcPerson> ResponsiblePersons)
	{
		this.ResponsiblePersons = ResponsiblePersons;
		fireChangeEvent();
	}

	/**
	* This method returns a copy of the set of the ResponsiblePersons attribute.
	*
	* @return a copy of the ResponsiblePersons set
	**/
	public SET<IfcPerson> getResponsiblePersons()
	{
		if(this.ResponsiblePersons != null)
			return new SET<IfcPerson>(this.ResponsiblePersons);
		return null;
	}

	/**
	* This method adds an IfcPerson object to the ResponsiblePersons set.
	* @param ResponsiblePersons element to be appended to this set.
	**/
	public void addResponsiblePersons(IfcPerson ResponsiblePersons)
	{
		if(this.ResponsiblePersons == null)
			this.ResponsiblePersons = new SET<IfcPerson>();
		this.ResponsiblePersons.add(ResponsiblePersons);
		fireChangeEvent();
	}

	/**
	* This method adds a collection of IfcPerson objects to the ResponsiblePersons set.
	* @param ResponsiblePersons collection containing elements to be added to this set.
	**/
	public void addAllResponsiblePersons(java.util.Collection<IfcPerson> ResponsiblePersons)
	{
		if(this.ResponsiblePersons == null)
			this.ResponsiblePersons = new SET<IfcPerson>();
		this.ResponsiblePersons.addAll(ResponsiblePersons);
		fireChangeEvent();
	}

	/**
	* This method removes all elements from the ResponsiblePersons set.
	**/
	public void clearResponsiblePersons()
	{
		if(this.ResponsiblePersons != null)
		{
			this.ResponsiblePersons.clear();
			fireChangeEvent();
		}
	}

	/**
	* This method removes an IfcPerson object from the ResponsiblePersons set.
	* @param ResponsiblePersons element to be removed from this set.
	**/
	public void removeResponsiblePersons(IfcPerson ResponsiblePersons)
	{
		if(this.ResponsiblePersons != null)
		{
			this.ResponsiblePersons.remove(ResponsiblePersons);
			fireChangeEvent();
		}
	}

	/**
	* This method removes a collection of IfcPerson objects from the ResponsiblePersons set.
	* @param ResponsiblePersons collection containing elements to be removed from this set.
	**/
	public void removeAllResponsiblePersons(java.util.Collection<IfcPerson> ResponsiblePersons)
	{
		if(this.ResponsiblePersons != null)
		{
			this.ResponsiblePersons.removeAll(ResponsiblePersons);
			fireChangeEvent();
		}
	}

	/**
	* This method sets the LastUpdateDate attribute to the given value.
	*
	* @param LastUpdateDate OPTIONAL value to set
	**/
	public void setLastUpdateDate(IfcCalendarDate LastUpdateDate)
	{
		this.LastUpdateDate = LastUpdateDate;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the LastUpdateDate attribute.
	*
	* @return the value of LastUpdateDate
	/**/
	public IfcCalendarDate getLastUpdateDate()
	{
		return this.LastUpdateDate;
	}

	/**
	* This method sets the CurrentValue attribute to the given value.
	*
	* @param CurrentValue DEMANDED value to set - may not be null
	**/
	public void setCurrentValue(IfcCostValue CurrentValue)
	{
		this.CurrentValue = CurrentValue;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the CurrentValue attribute.
	*
	* @return the value of CurrentValue
	/**/
	public IfcCostValue getCurrentValue()
	{
		return this.CurrentValue;
	}

	/**
	* This method sets the OriginalValue attribute to the given value.
	*
	* @param OriginalValue DEMANDED value to set - may not be null
	**/
	public void setOriginalValue(IfcCostValue OriginalValue)
	{
		this.OriginalValue = OriginalValue;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the OriginalValue attribute.
	*
	* @return the value of OriginalValue
	/**/
	public IfcCostValue getOriginalValue()
	{
		return this.OriginalValue;
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
	@SuppressWarnings("unchecked")
	public Object clone()
	{
		IfcInventory ifcInventory = new IfcInventory();
		if(this.GlobalId != null)
			ifcInventory.setGlobalId((IfcGloballyUniqueId)this.GlobalId.clone());
		if(this.OwnerHistory != null)
			ifcInventory.setOwnerHistory((IfcOwnerHistory)this.OwnerHistory.clone());
		if(this.Name != null)
			ifcInventory.setName((IfcLabel)this.Name.clone());
		if(this.Description != null)
			ifcInventory.setDescription((IfcText)this.Description.clone());
		if(this.ObjectType != null)
			ifcInventory.setObjectType((IfcLabel)this.ObjectType.clone());
		if(this.InventoryType != null)
			ifcInventory.setInventoryType((IfcInventoryTypeEnum)this.InventoryType.clone());
		if(this.Jurisdiction != null)
			ifcInventory.setJurisdiction((IfcActorSelect)this.Jurisdiction.clone());
		if(this.ResponsiblePersons != null)
			ifcInventory.setResponsiblePersons((SET<IfcPerson>)this.ResponsiblePersons.clone());
		if(this.LastUpdateDate != null)
			ifcInventory.setLastUpdateDate((IfcCalendarDate)this.LastUpdateDate.clone());
		if(this.CurrentValue != null)
			ifcInventory.setCurrentValue((IfcCostValue)this.CurrentValue.clone());
		if(this.OriginalValue != null)
			ifcInventory.setOriginalValue((IfcCostValue)this.OriginalValue.clone());
		return ifcInventory;
	}

	/**
	 * This method copys the object as shallow copy (all referenced objects are remaining).
	 *
	 * @return the cloned object
	**/
	public Object shallowCopy()
	{
		IfcInventory ifcInventory = new IfcInventory();
		if(this.GlobalId != null)
			ifcInventory.setGlobalId(this.GlobalId);
		if(this.OwnerHistory != null)
			ifcInventory.setOwnerHistory(this.OwnerHistory);
		if(this.Name != null)
			ifcInventory.setName(this.Name);
		if(this.Description != null)
			ifcInventory.setDescription(this.Description);
		if(this.ObjectType != null)
			ifcInventory.setObjectType(this.ObjectType);
		if(this.InventoryType != null)
			ifcInventory.setInventoryType(this.InventoryType);
		if(this.Jurisdiction != null)
			ifcInventory.setJurisdiction(this.Jurisdiction);
		if(this.ResponsiblePersons != null)
			ifcInventory.setResponsiblePersons(this.ResponsiblePersons);
		if(this.LastUpdateDate != null)
			ifcInventory.setLastUpdateDate(this.LastUpdateDate);
		if(this.CurrentValue != null)
			ifcInventory.setCurrentValue(this.CurrentValue);
		if(this.OriginalValue != null)
			ifcInventory.setOriginalValue(this.OriginalValue);
		return ifcInventory;
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
