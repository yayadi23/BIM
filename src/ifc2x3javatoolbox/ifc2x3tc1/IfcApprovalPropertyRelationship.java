/* Generated By: IFC Tools Project EXPRESS TO JAVA COMPILER: Do not edit this file!! */
package ifc2x3javatoolbox.ifc2x3tc1;
/**
 * This is a default implementation of the entity IfcApprovalPropertyRelationship<br><br>
 *<br><br>
 * Copyright: CC BY-NC-SA 3.0 DE (cc) 2013 Eike Tauscher and Michael Theiler<br><br>
 * The whole package including this class is licensed under<br>
 * <a rel='license' href='http://creativecommons.org/licenses/by-nc-sa/3.0/de/deed.en/'>
 * Creative Commons Attribution-Non-Commercial-Share Alike 3.0 Germany</a>.<br><br>
 * If you are using the package or parts of it in any commercial way, a commercial license is required. 
 * Visit <a href='http://www.ifctoolsproject.com'>http://www.ifctoolsproject.com</a> for more information
 * or contact us directly: <a href='mailto:info@ifctoolsproject.com'>info@ifctoolsproject.com</a><br>
 */
public class IfcApprovalPropertyRelationship extends InternalAccessClass implements ClassInterface
{
	private static final String[] nonInverseAttributes = new String[]{"SET<IfcProperty>","IfcApproval"};
	private java.util.ArrayList<CloneableObject> stepParameter = null;
	private java.util.HashSet<ObjectChangeListener> listenerList = null;
	protected int stepLineNumber;
	/** ApprovedProperties is an DEMANDED attribute - may not be null**/
	protected SET<IfcProperty> ApprovedProperties;
	/** Approval is an DEMANDED attribute - may not be null**/
	protected IfcApproval Approval;
	/**
	* The default constructor.
	**/
	public IfcApprovalPropertyRelationship(){}

	private static final String[] attributes = new String[]{"ApprovedProperties","Approval"};

	public String[] getAttributes() {
		return IfcApprovalPropertyRelationship.attributes;
	}

	/**
	* Constructs a new IfcApprovalPropertyRelationship object using the given parameters.
	*
	* @param ApprovedProperties DEMANDED parameter of type SET<IfcProperty> - may not be null.
	* @param Approval DEMANDED parameter of type IfcApproval - may not be null.
	**/
	public IfcApprovalPropertyRelationship(SET<IfcProperty> ApprovedProperties, IfcApproval Approval)
	{
		this.ApprovedProperties = ApprovedProperties;
		this.Approval = Approval;
		resolveInverses();
	}

	/**
	 * This method initializes the IfcApprovalPropertyRelationship object using the given parameters.
	*
	* @param ApprovedProperties DEMANDED parameter of type SET<IfcProperty> - may not be null.
	* @param Approval DEMANDED parameter of type IfcApproval - may not be null.
	**/
	public void setParameters(SET<IfcProperty> ApprovedProperties, IfcApproval Approval)
	{
		this.ApprovedProperties = ApprovedProperties;
		this.Approval = Approval;
		resolveInverses();
	}

	/**
	 * This method is used internally and should NOT be used for own purposes.
	**/
	@SuppressWarnings("unchecked")
	void initialize(java.util.ArrayList<CloneableObject> parameters)
	{
		this.ApprovedProperties = (SET<IfcProperty>) parameters.get(0);
		this.Approval = (IfcApproval) parameters.get(1);
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
	}

	/**
	 * This method is used internally and should NOT be used for own purposes.
	**/
	String[] getNonInverseAttributeTypes()
	{
		return IfcApprovalPropertyRelationship.nonInverseAttributes;	}

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
		stepString = stepString.concat("IFCAPPROVALPROPERTYRELATIONSHIP(");
		if(getRedefinedDerivedAttributeTypes().contains("ApprovedProperties")) stepString = stepString.concat("*,");
		else{
		if(this.ApprovedProperties != null)		stepString = stepString.concat(((RootInterface)this.ApprovedProperties).getStepParameter(IfcProperty.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("Approval")) stepString = stepString.concat("*);");
		else{
		if(this.Approval != null)		stepString = stepString.concat(((RootInterface)this.Approval).getStepParameter(IfcApproval.class.isInterface())+");");
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
	* This method sets the ApprovedProperties attribute to the given value.
	*
	* @param ApprovedProperties OPTIONAL value to set
	**/
	public void setApprovedProperties(SET<IfcProperty> ApprovedProperties)
	{
		this.ApprovedProperties = ApprovedProperties;
		fireChangeEvent();
	}

	/**
	* This method returns a copy of the set of the ApprovedProperties attribute.
	*
	* @return a copy of the ApprovedProperties set
	**/
	public SET<IfcProperty> getApprovedProperties()
	{
		if(this.ApprovedProperties != null)
			return new SET<IfcProperty>(this.ApprovedProperties);
		return null;
	}

	/**
	* This method adds an IfcProperty object to the ApprovedProperties set.
	* @param ApprovedProperties element to be appended to this set.
	**/
	public void addApprovedProperties(IfcProperty ApprovedProperties)
	{
		if(this.ApprovedProperties == null)
			this.ApprovedProperties = new SET<IfcProperty>();
		this.ApprovedProperties.add(ApprovedProperties);
		fireChangeEvent();
	}

	/**
	* This method adds a collection of IfcProperty objects to the ApprovedProperties set.
	* @param ApprovedProperties collection containing elements to be added to this set.
	**/
	public void addAllApprovedProperties(java.util.Collection<IfcProperty> ApprovedProperties)
	{
		if(this.ApprovedProperties == null)
			this.ApprovedProperties = new SET<IfcProperty>();
		this.ApprovedProperties.addAll(ApprovedProperties);
		fireChangeEvent();
	}

	/**
	* This method removes all elements from the ApprovedProperties set.
	**/
	public void clearApprovedProperties()
	{
		if(this.ApprovedProperties != null)
		{
			this.ApprovedProperties.clear();
			fireChangeEvent();
		}
	}

	/**
	* This method removes an IfcProperty object from the ApprovedProperties set.
	* @param ApprovedProperties element to be removed from this set.
	**/
	public void removeApprovedProperties(IfcProperty ApprovedProperties)
	{
		if(this.ApprovedProperties != null)
		{
			this.ApprovedProperties.remove(ApprovedProperties);
			fireChangeEvent();
		}
	}

	/**
	* This method removes a collection of IfcProperty objects from the ApprovedProperties set.
	* @param ApprovedProperties collection containing elements to be removed from this set.
	**/
	public void removeAllApprovedProperties(java.util.Collection<IfcProperty> ApprovedProperties)
	{
		if(this.ApprovedProperties != null)
		{
			this.ApprovedProperties.removeAll(ApprovedProperties);
			fireChangeEvent();
		}
	}

	/**
	* This method sets the Approval attribute to the given value.
	*
	* @param Approval OPTIONAL value to set
	**/
	public void setApproval(IfcApproval Approval)
	{
		this.Approval = Approval;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the Approval attribute.
	*
	* @return the value of Approval
	/**/
	public IfcApproval getApproval()
	{
		return this.Approval;
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
		IfcApprovalPropertyRelationship ifcApprovalPropertyRelationship = new IfcApprovalPropertyRelationship();
		if(this.ApprovedProperties != null)
			ifcApprovalPropertyRelationship.setApprovedProperties((SET<IfcProperty>)this.ApprovedProperties.clone());
		if(this.Approval != null)
			ifcApprovalPropertyRelationship.setApproval((IfcApproval)this.Approval.clone());
		return ifcApprovalPropertyRelationship;
	}

	/**
	 * This method copys the object as shallow copy (all referenced objects are remaining).
	 *
	 * @return the cloned object
	**/
	public Object shallowCopy()
	{
		IfcApprovalPropertyRelationship ifcApprovalPropertyRelationship = new IfcApprovalPropertyRelationship();
		if(this.ApprovedProperties != null)
			ifcApprovalPropertyRelationship.setApprovedProperties(this.ApprovedProperties);
		if(this.Approval != null)
			ifcApprovalPropertyRelationship.setApproval(this.Approval);
		return ifcApprovalPropertyRelationship;
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
