/* Generated By: IFC Tools Project EXPRESS TO JAVA COMPILER: Do not edit this file!! */
package ifc2x3javatoolbox.ifc2x3tc1;
/**
 * This is a default implementation of the entity IfcAppliedValueRelationship<br><br>
 *<br><br>
 * Copyright: CC BY-NC-SA 3.0 DE (cc) 2013 Eike Tauscher and Michael Theiler<br><br>
 * The whole package including this class is licensed under<br>
 * <a rel='license' href='http://creativecommons.org/licenses/by-nc-sa/3.0/de/deed.en/'>
 * Creative Commons Attribution-Non-Commercial-Share Alike 3.0 Germany</a>.<br><br>
 * If you are using the package or parts of it in any commercial way, a commercial license is required. 
 * Visit <a href='http://www.ifctoolsproject.com'>http://www.ifctoolsproject.com</a> for more information
 * or contact us directly: <a href='mailto:info@ifctoolsproject.com'>info@ifctoolsproject.com</a><br>
 */
public class IfcAppliedValueRelationship extends InternalAccessClass implements ClassInterface
{
	private static final String[] nonInverseAttributes = new String[]{"IfcAppliedValue","SET<IfcAppliedValue>","IfcArithmeticOperatorEnum","IfcLabel","IfcText"};
	private java.util.ArrayList<CloneableObject> stepParameter = null;
	private java.util.HashSet<ObjectChangeListener> listenerList = null;
	protected int stepLineNumber;
	/** ComponentOfTotal is an DEMANDED attribute - may not be null**/
	protected IfcAppliedValue ComponentOfTotal;
	/** Components is an DEMANDED attribute - may not be null**/
	protected SET<IfcAppliedValue> Components;
	/** ArithmeticOperator is an DEMANDED attribute - may not be null**/
	protected IfcArithmeticOperatorEnum ArithmeticOperator;
	/** Name is an OPTIONAL attribute**/
	protected IfcLabel Name;
	/** Description is an OPTIONAL attribute**/
	protected IfcText Description;
	/**
	* The default constructor.
	**/
	public IfcAppliedValueRelationship(){}

	/**
	* Constructs a new IfcAppliedValueRelationship object using the given parameters.
	*
	* @param ComponentOfTotal DEMANDED parameter of type IfcAppliedValue - may not be null.
	* @param Components DEMANDED parameter of type SET<IfcAppliedValue> - may not be null.
	* @param ArithmeticOperator DEMANDED parameter of type IfcArithmeticOperatorEnum - may not be null.
	* @param Name OPTIONAL parameter of type IfcLabel
	* @param Description OPTIONAL parameter of type IfcText
	**/
	public IfcAppliedValueRelationship(IfcAppliedValue ComponentOfTotal, SET<IfcAppliedValue> Components, IfcArithmeticOperatorEnum ArithmeticOperator, IfcLabel Name, IfcText Description)
	{
		this.ComponentOfTotal = ComponentOfTotal;
		this.Components = Components;
		this.ArithmeticOperator = ArithmeticOperator;
		this.Name = Name;
		this.Description = Description;
		resolveInverses();
	}

	/**
	 * This method initializes the IfcAppliedValueRelationship object using the given parameters.
	*
	* @param ComponentOfTotal DEMANDED parameter of type IfcAppliedValue - may not be null.
	* @param Components DEMANDED parameter of type SET<IfcAppliedValue> - may not be null.
	* @param ArithmeticOperator DEMANDED parameter of type IfcArithmeticOperatorEnum - may not be null.
	* @param Name OPTIONAL parameter of type IfcLabel
	* @param Description OPTIONAL parameter of type IfcText
	**/
	public void setParameters(IfcAppliedValue ComponentOfTotal, SET<IfcAppliedValue> Components, IfcArithmeticOperatorEnum ArithmeticOperator, IfcLabel Name, IfcText Description)
	{
		this.ComponentOfTotal = ComponentOfTotal;
		this.Components = Components;
		this.ArithmeticOperator = ArithmeticOperator;
		this.Name = Name;
		this.Description = Description;
		resolveInverses();
	}

	/**
	 * This method is used internally and should NOT be used for own purposes.
	**/
	@SuppressWarnings("unchecked")
	void initialize(java.util.ArrayList<CloneableObject> parameters)
	{
		this.ComponentOfTotal = (IfcAppliedValue) parameters.get(0);
		this.Components = (SET<IfcAppliedValue>) parameters.get(1);
		this.ArithmeticOperator = (IfcArithmeticOperatorEnum) parameters.get(2);
		this.Name = (IfcLabel) parameters.get(3);
		this.Description = (IfcText) parameters.get(4);
		resolveInverses();
	}

	/**
	 * This method is used internally and should NOT be used for own purposes.
	**/
	void destruct()
	{
		listenerList = null;
	}

	private void resolveInverses()
	{
		if(ComponentOfTotal != null)
		{
				if(ComponentOfTotal.ValueOfComponents_Inverse == null)
				{
					ComponentOfTotal.ValueOfComponents_Inverse = new SET<IfcAppliedValueRelationship>();
				}
				ComponentOfTotal.ValueOfComponents_Inverse.add(this);
		}
		if(Components != null)
		{
			for(IfcAppliedValue Components$ : Components)
			{
				if(Components$.IsComponentIn_Inverse == null)
				{
					Components$.IsComponentIn_Inverse = new SET<IfcAppliedValueRelationship>();
				}
				Components$.IsComponentIn_Inverse.add(this);
			}
		}
	}

	/**
	 * This method is used internally and should NOT be used for own purposes.
	**/
	String[] getNonInverseAttributeTypes()
	{
		return IfcAppliedValueRelationship.nonInverseAttributes;	}

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
		stepString = stepString.concat("IFCAPPLIEDVALUERELATIONSHIP(");
		if(getRedefinedDerivedAttributeTypes().contains("ComponentOfTotal")) stepString = stepString.concat("*,");
		else{
		if(this.ComponentOfTotal != null)		stepString = stepString.concat(((RootInterface)this.ComponentOfTotal).getStepParameter(IfcAppliedValue.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("Components")) stepString = stepString.concat("*,");
		else{
		if(this.Components != null)		stepString = stepString.concat(((RootInterface)this.Components).getStepParameter(IfcAppliedValue.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("ArithmeticOperator")) stepString = stepString.concat("*,");
		else{
		if(this.ArithmeticOperator != null)		stepString = stepString.concat(((RootInterface)this.ArithmeticOperator).getStepParameter(IfcArithmeticOperatorEnum.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("Name")) stepString = stepString.concat("*,");
		else{
		if(this.Name != null)		stepString = stepString.concat(((RootInterface)this.Name).getStepParameter(IfcLabel.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("Description")) stepString = stepString.concat("*);");
		else{
		if(this.Description != null)		stepString = stepString.concat(((RootInterface)this.Description).getStepParameter(IfcText.class.isInterface())+");");
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
	* This method sets the ComponentOfTotal attribute to the given value.
	*
	* @param ComponentOfTotal OPTIONAL value to set
	**/
	public void setComponentOfTotal(IfcAppliedValue ComponentOfTotal)
	{
		synchronizeInversesRemoveComponentOfTotal(this.ComponentOfTotal);
		this.ComponentOfTotal = ComponentOfTotal;
		synchronizeInversesAddComponentOfTotal(this.ComponentOfTotal);
		fireChangeEvent();
	}

	/**
	* This method returns the value of the ComponentOfTotal attribute.
	*
	* @return the value of ComponentOfTotal
	/**/
	public IfcAppliedValue getComponentOfTotal()
	{
		return this.ComponentOfTotal;
	}

	private void synchronizeInversesAddComponentOfTotal(IfcAppliedValue ComponentOfTotal)
	{
		if(ComponentOfTotal != null)
		{
				if(ComponentOfTotal.ValueOfComponents_Inverse == null)
				{
					ComponentOfTotal.ValueOfComponents_Inverse = new SET<IfcAppliedValueRelationship>();
				}
				ComponentOfTotal.ValueOfComponents_Inverse.add(this);
		}
	}

	private void synchronizeInversesRemoveComponentOfTotal(IfcAppliedValue ComponentOfTotal)
	{
		if(ComponentOfTotal != null)
		{
				if(ComponentOfTotal.ValueOfComponents_Inverse != null)
				{
					ComponentOfTotal.ValueOfComponents_Inverse.remove(this);
				}
		}
	}

	/**
	* This method sets the Components attribute to the given value.
	*
	* @param Components OPTIONAL value to set
	**/
	public void setComponents(SET<IfcAppliedValue> Components)
	{
		synchronizeInversesRemoveComponents(this.Components);
		this.Components = Components;
		synchronizeInversesAddComponents(this.Components);
		fireChangeEvent();
	}

	/**
	* This method returns a copy of the set of the Components attribute.
	*
	* @return a copy of the Components set
	**/
	public SET<IfcAppliedValue> getComponents()
	{
		if(this.Components != null)
			return new SET<IfcAppliedValue>(this.Components);
		return null;
	}

	/**
	* This method adds an IfcAppliedValue object to the Components set.
	* @param Components element to be appended to this set.
	**/
	public void addComponents(IfcAppliedValue Components)
	{
		if(this.Components == null)
			this.Components = new SET<IfcAppliedValue>();
		this.Components.add(Components);
		synchronizeInversesAddComponents(Components);
		fireChangeEvent();
	}

	/**
	* This method adds a collection of IfcAppliedValue objects to the Components set.
	* @param Components collection containing elements to be added to this set.
	**/
	public void addAllComponents(java.util.Collection<IfcAppliedValue> Components)
	{
		if(this.Components == null)
			this.Components = new SET<IfcAppliedValue>();
		this.Components.addAll(Components);
		synchronizeInversesAddComponents(Components);
		fireChangeEvent();
	}

	/**
	* This method removes all elements from the Components set.
	**/
	public void clearComponents()
	{
		if(this.Components != null)
		{
			synchronizeInversesRemoveComponents(this.Components);
			this.Components.clear();
			fireChangeEvent();
		}
	}

	/**
	* This method removes an IfcAppliedValue object from the Components set.
	* @param Components element to be removed from this set.
	**/
	public void removeComponents(IfcAppliedValue Components)
	{
		if(this.Components != null)
		{
			this.Components.remove(Components);
			synchronizeInversesRemoveComponents(Components);
			fireChangeEvent();
		}
	}

	/**
	* This method removes a collection of IfcAppliedValue objects from the Components set.
	* @param Components collection containing elements to be removed from this set.
	**/
	public void removeAllComponents(java.util.Collection<IfcAppliedValue> Components)
	{
		if(this.Components != null)
		{
			this.Components.removeAll(Components);
			synchronizeInversesRemoveComponents(Components);
			fireChangeEvent();
		}
	}

	private void synchronizeInversesAddComponents(IfcAppliedValue Components)
	{
		if(Components != null)
		{
				if(Components.IsComponentIn_Inverse == null)
				{
					Components.IsComponentIn_Inverse = new SET<IfcAppliedValueRelationship>();
				}
				Components.IsComponentIn_Inverse.add(this);
		}
	}

	private void synchronizeInversesAddComponents(java.util.Collection<IfcAppliedValue> Components)
	{
		if(Components != null)
		{
			for(IfcAppliedValue Components$ : Components)
			{
				synchronizeInversesAddComponents(Components$);
			}
		}
	}

	private void synchronizeInversesRemoveComponents(IfcAppliedValue Components)
	{
		if(Components != null)
		{
				if(Components.IsComponentIn_Inverse != null)
				{
					Components.IsComponentIn_Inverse.remove(this);
				}
		}
	}

	private void synchronizeInversesRemoveComponents(java.util.Collection<IfcAppliedValue> Components)
	{
		if(Components != null)
		{
			for(IfcAppliedValue Components$ : Components)
			{
				synchronizeInversesRemoveComponents(Components$);
			}
		}
	}

	/**
	* This method sets the ArithmeticOperator attribute to the given value.
	*
	* @param ArithmeticOperator OPTIONAL value to set
	**/
	public void setArithmeticOperator(IfcArithmeticOperatorEnum ArithmeticOperator)
	{
		this.ArithmeticOperator = ArithmeticOperator;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the ArithmeticOperator attribute.
	*
	* @return the value of ArithmeticOperator
	/**/
	public IfcArithmeticOperatorEnum getArithmeticOperator()
	{
		return this.ArithmeticOperator;
	}

	/**
	* This method sets the Name attribute to the given value.
	*
	* @param Name DEMANDED value to set - may not be null
	**/
	public void setName(IfcLabel Name)
	{
		this.Name = Name;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the Name attribute.
	*
	* @return the value of Name
	/**/
	public IfcLabel getName()
	{
		return this.Name;
	}

	/**
	* This method sets the Description attribute to the given value.
	*
	* @param Description DEMANDED value to set - may not be null
	**/
	public void setDescription(IfcText Description)
	{
		this.Description = Description;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the Description attribute.
	*
	* @return the value of Description
	/**/
	public IfcText getDescription()
	{
		return this.Description;
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
		IfcAppliedValueRelationship ifcAppliedValueRelationship = new IfcAppliedValueRelationship();
		if(this.ComponentOfTotal != null)
			ifcAppliedValueRelationship.setComponentOfTotal((IfcAppliedValue)this.ComponentOfTotal.clone());
		if(this.Components != null)
			ifcAppliedValueRelationship.setComponents((SET<IfcAppliedValue>)this.Components.clone());
		if(this.ArithmeticOperator != null)
			ifcAppliedValueRelationship.setArithmeticOperator((IfcArithmeticOperatorEnum)this.ArithmeticOperator.clone());
		if(this.Name != null)
			ifcAppliedValueRelationship.setName((IfcLabel)this.Name.clone());
		if(this.Description != null)
			ifcAppliedValueRelationship.setDescription((IfcText)this.Description.clone());
		return ifcAppliedValueRelationship;
	}

	/**
	 * This method copys the object as shallow copy (all referenced objects are remaining).
	 *
	 * @return the cloned object
	**/
	public Object shallowCopy()
	{
		IfcAppliedValueRelationship ifcAppliedValueRelationship = new IfcAppliedValueRelationship();
		if(this.ComponentOfTotal != null)
			ifcAppliedValueRelationship.setComponentOfTotal(this.ComponentOfTotal);
		if(this.Components != null)
			ifcAppliedValueRelationship.setComponents(this.Components);
		if(this.ArithmeticOperator != null)
			ifcAppliedValueRelationship.setArithmeticOperator(this.ArithmeticOperator);
		if(this.Name != null)
			ifcAppliedValueRelationship.setName(this.Name);
		if(this.Description != null)
			ifcAppliedValueRelationship.setDescription(this.Description);
		return ifcAppliedValueRelationship;
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