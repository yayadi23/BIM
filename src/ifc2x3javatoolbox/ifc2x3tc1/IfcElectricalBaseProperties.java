/* Generated By: IFC Tools Project EXPRESS TO JAVA COMPILER: Do not edit this file!! */
package ifc2x3javatoolbox.ifc2x3tc1;
/**
 * This is a default implementation of the entity IfcElectricalBaseProperties<br><br>
 *<br><br>
 * Copyright: CC BY-NC-SA 3.0 DE (cc) 2013 Eike Tauscher and Michael Theiler<br><br>
 * The whole package including this class is licensed under<br>
 * <a rel='license' href='http://creativecommons.org/licenses/by-nc-sa/3.0/de/deed.en/'>
 * Creative Commons Attribution-Non-Commercial-Share Alike 3.0 Germany</a>.<br><br>
 * If you are using the package or parts of it in any commercial way, a commercial license is required. 
 * Visit <a href='http://www.ifctoolsproject.com'>http://www.ifctoolsproject.com</a> for more information
 * or contact us directly: <a href='mailto:info@ifctoolsproject.com'>info@ifctoolsproject.com</a><br>
 */
public class IfcElectricalBaseProperties extends IfcEnergyProperties implements ClassInterface
{
	private static final String[] nonInverseAttributes = new String[]{"IfcGloballyUniqueId","IfcOwnerHistory","IfcLabel","IfcText","IfcEnergySequenceEnum","IfcLabel","IfcElectricCurrentEnum","IfcElectricVoltageMeasure","IfcFrequencyMeasure","IfcElectricCurrentMeasure","IfcElectricCurrentMeasure","IfcPowerMeasure","IfcPowerMeasure","INTEGER"};
	private java.util.ArrayList<CloneableObject> stepParameter = null;
	private java.util.HashSet<ObjectChangeListener> listenerList = null;
	protected int stepLineNumber;
	/** ElectricCurrentType is an OPTIONAL attribute**/
	protected IfcElectricCurrentEnum ElectricCurrentType;
	/** InputVoltage is an DEMANDED attribute - may not be null**/
	protected IfcElectricVoltageMeasure InputVoltage;
	/** InputFrequency is an DEMANDED attribute - may not be null**/
	protected IfcFrequencyMeasure InputFrequency;
	/** FullLoadCurrent is an OPTIONAL attribute**/
	protected IfcElectricCurrentMeasure FullLoadCurrent;
	/** MinimumCircuitCurrent is an OPTIONAL attribute**/
	protected IfcElectricCurrentMeasure MinimumCircuitCurrent;
	/** MaximumPowerInput is an OPTIONAL attribute**/
	protected IfcPowerMeasure MaximumPowerInput;
	/** RatedPowerInput is an OPTIONAL attribute**/
	protected IfcPowerMeasure RatedPowerInput;
	/** InputPhase is an DEMANDED attribute - may not be null**/
	protected INTEGER InputPhase;
	/**
	* The default constructor.
	**/
	public IfcElectricalBaseProperties(){}

	/**
	* Constructs a new IfcElectricalBaseProperties object using the given parameters.
	*
	* @param GlobalId DEMANDED parameter of type IfcGloballyUniqueId - may not be null.
	* @param OwnerHistory DEMANDED parameter of type IfcOwnerHistory - may not be null.
	* @param Name OPTIONAL parameter of type IfcLabel
	* @param Description OPTIONAL parameter of type IfcText
	* @param EnergySequence OPTIONAL parameter of type IfcEnergySequenceEnum
	* @param UserDefinedEnergySequence OPTIONAL parameter of type IfcLabel
	* @param ElectricCurrentType OPTIONAL parameter of type IfcElectricCurrentEnum
	* @param InputVoltage DEMANDED parameter of type IfcElectricVoltageMeasure - may not be null.
	* @param InputFrequency DEMANDED parameter of type IfcFrequencyMeasure - may not be null.
	* @param FullLoadCurrent OPTIONAL parameter of type IfcElectricCurrentMeasure
	* @param MinimumCircuitCurrent OPTIONAL parameter of type IfcElectricCurrentMeasure
	* @param MaximumPowerInput OPTIONAL parameter of type IfcPowerMeasure
	* @param RatedPowerInput OPTIONAL parameter of type IfcPowerMeasure
	* @param InputPhase DEMANDED parameter of type INTEGER - may not be null.
	**/
	public IfcElectricalBaseProperties(IfcGloballyUniqueId GlobalId, IfcOwnerHistory OwnerHistory, IfcLabel Name, IfcText Description, IfcEnergySequenceEnum EnergySequence, IfcLabel UserDefinedEnergySequence, IfcElectricCurrentEnum ElectricCurrentType, IfcElectricVoltageMeasure InputVoltage, IfcFrequencyMeasure InputFrequency, IfcElectricCurrentMeasure FullLoadCurrent, IfcElectricCurrentMeasure MinimumCircuitCurrent, IfcPowerMeasure MaximumPowerInput, IfcPowerMeasure RatedPowerInput, INTEGER InputPhase)
	{
		this.GlobalId = GlobalId;
		this.OwnerHistory = OwnerHistory;
		this.Name = Name;
		this.Description = Description;
		this.EnergySequence = EnergySequence;
		this.UserDefinedEnergySequence = UserDefinedEnergySequence;
		this.ElectricCurrentType = ElectricCurrentType;
		this.InputVoltage = InputVoltage;
		this.InputFrequency = InputFrequency;
		this.FullLoadCurrent = FullLoadCurrent;
		this.MinimumCircuitCurrent = MinimumCircuitCurrent;
		this.MaximumPowerInput = MaximumPowerInput;
		this.RatedPowerInput = RatedPowerInput;
		this.InputPhase = InputPhase;
		resolveInverses();
	}

	/**
	 * This method initializes the IfcElectricalBaseProperties object using the given parameters.
	*
	* @param GlobalId DEMANDED parameter of type IfcGloballyUniqueId - may not be null.
	* @param OwnerHistory DEMANDED parameter of type IfcOwnerHistory - may not be null.
	* @param Name OPTIONAL parameter of type IfcLabel
	* @param Description OPTIONAL parameter of type IfcText
	* @param EnergySequence OPTIONAL parameter of type IfcEnergySequenceEnum
	* @param UserDefinedEnergySequence OPTIONAL parameter of type IfcLabel
	* @param ElectricCurrentType OPTIONAL parameter of type IfcElectricCurrentEnum
	* @param InputVoltage DEMANDED parameter of type IfcElectricVoltageMeasure - may not be null.
	* @param InputFrequency DEMANDED parameter of type IfcFrequencyMeasure - may not be null.
	* @param FullLoadCurrent OPTIONAL parameter of type IfcElectricCurrentMeasure
	* @param MinimumCircuitCurrent OPTIONAL parameter of type IfcElectricCurrentMeasure
	* @param MaximumPowerInput OPTIONAL parameter of type IfcPowerMeasure
	* @param RatedPowerInput OPTIONAL parameter of type IfcPowerMeasure
	* @param InputPhase DEMANDED parameter of type INTEGER - may not be null.
	**/
	public void setParameters(IfcGloballyUniqueId GlobalId, IfcOwnerHistory OwnerHistory, IfcLabel Name, IfcText Description, IfcEnergySequenceEnum EnergySequence, IfcLabel UserDefinedEnergySequence, IfcElectricCurrentEnum ElectricCurrentType, IfcElectricVoltageMeasure InputVoltage, IfcFrequencyMeasure InputFrequency, IfcElectricCurrentMeasure FullLoadCurrent, IfcElectricCurrentMeasure MinimumCircuitCurrent, IfcPowerMeasure MaximumPowerInput, IfcPowerMeasure RatedPowerInput, INTEGER InputPhase)
	{
		this.GlobalId = GlobalId;
		this.OwnerHistory = OwnerHistory;
		this.Name = Name;
		this.Description = Description;
		this.EnergySequence = EnergySequence;
		this.UserDefinedEnergySequence = UserDefinedEnergySequence;
		this.ElectricCurrentType = ElectricCurrentType;
		this.InputVoltage = InputVoltage;
		this.InputFrequency = InputFrequency;
		this.FullLoadCurrent = FullLoadCurrent;
		this.MinimumCircuitCurrent = MinimumCircuitCurrent;
		this.MaximumPowerInput = MaximumPowerInput;
		this.RatedPowerInput = RatedPowerInput;
		this.InputPhase = InputPhase;
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
		this.EnergySequence = (IfcEnergySequenceEnum) parameters.get(4);
		this.UserDefinedEnergySequence = (IfcLabel) parameters.get(5);
		this.ElectricCurrentType = (IfcElectricCurrentEnum) parameters.get(6);
		this.InputVoltage = (IfcElectricVoltageMeasure) parameters.get(7);
		this.InputFrequency = (IfcFrequencyMeasure) parameters.get(8);
		this.FullLoadCurrent = (IfcElectricCurrentMeasure) parameters.get(9);
		this.MinimumCircuitCurrent = (IfcElectricCurrentMeasure) parameters.get(10);
		this.MaximumPowerInput = (IfcPowerMeasure) parameters.get(11);
		this.RatedPowerInput = (IfcPowerMeasure) parameters.get(12);
		this.InputPhase = (INTEGER) parameters.get(13);
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
		return IfcElectricalBaseProperties.nonInverseAttributes;	}

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
		stepString = stepString.concat("IFCELECTRICALBASEPROPERTIES(");
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
		if(getRedefinedDerivedAttributeTypes().contains("EnergySequence")) stepString = stepString.concat("*,");
		else{
		if(this.EnergySequence != null)		stepString = stepString.concat(((RootInterface)this.EnergySequence).getStepParameter(IfcEnergySequenceEnum.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("UserDefinedEnergySequence")) stepString = stepString.concat("*,");
		else{
		if(this.UserDefinedEnergySequence != null)		stepString = stepString.concat(((RootInterface)this.UserDefinedEnergySequence).getStepParameter(IfcLabel.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("ElectricCurrentType")) stepString = stepString.concat("*,");
		else{
		if(this.ElectricCurrentType != null)		stepString = stepString.concat(((RootInterface)this.ElectricCurrentType).getStepParameter(IfcElectricCurrentEnum.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("InputVoltage")) stepString = stepString.concat("*,");
		else{
		if(this.InputVoltage != null)		stepString = stepString.concat(((RootInterface)this.InputVoltage).getStepParameter(IfcElectricVoltageMeasure.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("InputFrequency")) stepString = stepString.concat("*,");
		else{
		if(this.InputFrequency != null)		stepString = stepString.concat(((RootInterface)this.InputFrequency).getStepParameter(IfcFrequencyMeasure.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("FullLoadCurrent")) stepString = stepString.concat("*,");
		else{
		if(this.FullLoadCurrent != null)		stepString = stepString.concat(((RootInterface)this.FullLoadCurrent).getStepParameter(IfcElectricCurrentMeasure.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("MinimumCircuitCurrent")) stepString = stepString.concat("*,");
		else{
		if(this.MinimumCircuitCurrent != null)		stepString = stepString.concat(((RootInterface)this.MinimumCircuitCurrent).getStepParameter(IfcElectricCurrentMeasure.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("MaximumPowerInput")) stepString = stepString.concat("*,");
		else{
		if(this.MaximumPowerInput != null)		stepString = stepString.concat(((RootInterface)this.MaximumPowerInput).getStepParameter(IfcPowerMeasure.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("RatedPowerInput")) stepString = stepString.concat("*,");
		else{
		if(this.RatedPowerInput != null)		stepString = stepString.concat(((RootInterface)this.RatedPowerInput).getStepParameter(IfcPowerMeasure.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("InputPhase")) stepString = stepString.concat("*);");
		else{
		if(this.InputPhase != null)		stepString = stepString.concat(((RootInterface)this.InputPhase).getStepParameter(INTEGER.class.isInterface())+");");
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
	* This method sets the ElectricCurrentType attribute to the given value.
	*
	* @param ElectricCurrentType DEMANDED value to set - may not be null
	**/
	public void setElectricCurrentType(IfcElectricCurrentEnum ElectricCurrentType)
	{
		this.ElectricCurrentType = ElectricCurrentType;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the ElectricCurrentType attribute.
	*
	* @return the value of ElectricCurrentType
	/**/
	public IfcElectricCurrentEnum getElectricCurrentType()
	{
		return this.ElectricCurrentType;
	}

	/**
	* This method sets the InputVoltage attribute to the given value.
	*
	* @param InputVoltage OPTIONAL value to set
	**/
	public void setInputVoltage(IfcElectricVoltageMeasure InputVoltage)
	{
		this.InputVoltage = InputVoltage;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the InputVoltage attribute.
	*
	* @return the value of InputVoltage
	/**/
	public IfcElectricVoltageMeasure getInputVoltage()
	{
		return this.InputVoltage;
	}

	/**
	* This method sets the InputFrequency attribute to the given value.
	*
	* @param InputFrequency OPTIONAL value to set
	**/
	public void setInputFrequency(IfcFrequencyMeasure InputFrequency)
	{
		this.InputFrequency = InputFrequency;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the InputFrequency attribute.
	*
	* @return the value of InputFrequency
	/**/
	public IfcFrequencyMeasure getInputFrequency()
	{
		return this.InputFrequency;
	}

	/**
	* This method sets the FullLoadCurrent attribute to the given value.
	*
	* @param FullLoadCurrent DEMANDED value to set - may not be null
	**/
	public void setFullLoadCurrent(IfcElectricCurrentMeasure FullLoadCurrent)
	{
		this.FullLoadCurrent = FullLoadCurrent;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the FullLoadCurrent attribute.
	*
	* @return the value of FullLoadCurrent
	/**/
	public IfcElectricCurrentMeasure getFullLoadCurrent()
	{
		return this.FullLoadCurrent;
	}

	/**
	* This method sets the MinimumCircuitCurrent attribute to the given value.
	*
	* @param MinimumCircuitCurrent DEMANDED value to set - may not be null
	**/
	public void setMinimumCircuitCurrent(IfcElectricCurrentMeasure MinimumCircuitCurrent)
	{
		this.MinimumCircuitCurrent = MinimumCircuitCurrent;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the MinimumCircuitCurrent attribute.
	*
	* @return the value of MinimumCircuitCurrent
	/**/
	public IfcElectricCurrentMeasure getMinimumCircuitCurrent()
	{
		return this.MinimumCircuitCurrent;
	}

	/**
	* This method sets the MaximumPowerInput attribute to the given value.
	*
	* @param MaximumPowerInput DEMANDED value to set - may not be null
	**/
	public void setMaximumPowerInput(IfcPowerMeasure MaximumPowerInput)
	{
		this.MaximumPowerInput = MaximumPowerInput;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the MaximumPowerInput attribute.
	*
	* @return the value of MaximumPowerInput
	/**/
	public IfcPowerMeasure getMaximumPowerInput()
	{
		return this.MaximumPowerInput;
	}

	/**
	* This method sets the RatedPowerInput attribute to the given value.
	*
	* @param RatedPowerInput DEMANDED value to set - may not be null
	**/
	public void setRatedPowerInput(IfcPowerMeasure RatedPowerInput)
	{
		this.RatedPowerInput = RatedPowerInput;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the RatedPowerInput attribute.
	*
	* @return the value of RatedPowerInput
	/**/
	public IfcPowerMeasure getRatedPowerInput()
	{
		return this.RatedPowerInput;
	}

	/**
	* This method sets the InputPhase attribute to the given value.
	*
	* @param InputPhase OPTIONAL value to set
	**/
	public void setInputPhase(INTEGER InputPhase)
	{
		this.InputPhase = InputPhase;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the InputPhase attribute.
	*
	* @return the value of InputPhase
	/**/
	public INTEGER getInputPhase()
	{
		return this.InputPhase;
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
		IfcElectricalBaseProperties ifcElectricalBaseProperties = new IfcElectricalBaseProperties();
		if(this.GlobalId != null)
			ifcElectricalBaseProperties.setGlobalId((IfcGloballyUniqueId)this.GlobalId.clone());
		if(this.OwnerHistory != null)
			ifcElectricalBaseProperties.setOwnerHistory((IfcOwnerHistory)this.OwnerHistory.clone());
		if(this.Name != null)
			ifcElectricalBaseProperties.setName((IfcLabel)this.Name.clone());
		if(this.Description != null)
			ifcElectricalBaseProperties.setDescription((IfcText)this.Description.clone());
		if(this.EnergySequence != null)
			ifcElectricalBaseProperties.setEnergySequence((IfcEnergySequenceEnum)this.EnergySequence.clone());
		if(this.UserDefinedEnergySequence != null)
			ifcElectricalBaseProperties.setUserDefinedEnergySequence((IfcLabel)this.UserDefinedEnergySequence.clone());
		if(this.ElectricCurrentType != null)
			ifcElectricalBaseProperties.setElectricCurrentType((IfcElectricCurrentEnum)this.ElectricCurrentType.clone());
		if(this.InputVoltage != null)
			ifcElectricalBaseProperties.setInputVoltage((IfcElectricVoltageMeasure)this.InputVoltage.clone());
		if(this.InputFrequency != null)
			ifcElectricalBaseProperties.setInputFrequency((IfcFrequencyMeasure)this.InputFrequency.clone());
		if(this.FullLoadCurrent != null)
			ifcElectricalBaseProperties.setFullLoadCurrent((IfcElectricCurrentMeasure)this.FullLoadCurrent.clone());
		if(this.MinimumCircuitCurrent != null)
			ifcElectricalBaseProperties.setMinimumCircuitCurrent((IfcElectricCurrentMeasure)this.MinimumCircuitCurrent.clone());
		if(this.MaximumPowerInput != null)
			ifcElectricalBaseProperties.setMaximumPowerInput((IfcPowerMeasure)this.MaximumPowerInput.clone());
		if(this.RatedPowerInput != null)
			ifcElectricalBaseProperties.setRatedPowerInput((IfcPowerMeasure)this.RatedPowerInput.clone());
		if(this.InputPhase != null)
			ifcElectricalBaseProperties.setInputPhase((INTEGER)this.InputPhase.clone());
		return ifcElectricalBaseProperties;
	}

	/**
	 * This method copys the object as shallow copy (all referenced objects are remaining).
	 *
	 * @return the cloned object
	**/
	public Object shallowCopy()
	{
		IfcElectricalBaseProperties ifcElectricalBaseProperties = new IfcElectricalBaseProperties();
		if(this.GlobalId != null)
			ifcElectricalBaseProperties.setGlobalId(this.GlobalId);
		if(this.OwnerHistory != null)
			ifcElectricalBaseProperties.setOwnerHistory(this.OwnerHistory);
		if(this.Name != null)
			ifcElectricalBaseProperties.setName(this.Name);
		if(this.Description != null)
			ifcElectricalBaseProperties.setDescription(this.Description);
		if(this.EnergySequence != null)
			ifcElectricalBaseProperties.setEnergySequence(this.EnergySequence);
		if(this.UserDefinedEnergySequence != null)
			ifcElectricalBaseProperties.setUserDefinedEnergySequence(this.UserDefinedEnergySequence);
		if(this.ElectricCurrentType != null)
			ifcElectricalBaseProperties.setElectricCurrentType(this.ElectricCurrentType);
		if(this.InputVoltage != null)
			ifcElectricalBaseProperties.setInputVoltage(this.InputVoltage);
		if(this.InputFrequency != null)
			ifcElectricalBaseProperties.setInputFrequency(this.InputFrequency);
		if(this.FullLoadCurrent != null)
			ifcElectricalBaseProperties.setFullLoadCurrent(this.FullLoadCurrent);
		if(this.MinimumCircuitCurrent != null)
			ifcElectricalBaseProperties.setMinimumCircuitCurrent(this.MinimumCircuitCurrent);
		if(this.MaximumPowerInput != null)
			ifcElectricalBaseProperties.setMaximumPowerInput(this.MaximumPowerInput);
		if(this.RatedPowerInput != null)
			ifcElectricalBaseProperties.setRatedPowerInput(this.RatedPowerInput);
		if(this.InputPhase != null)
			ifcElectricalBaseProperties.setInputPhase(this.InputPhase);
		return ifcElectricalBaseProperties;
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