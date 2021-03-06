/* Generated By: IFC Tools Project EXPRESS TO JAVA COMPILER: Do not edit this file!! */
package ifc2x3javatoolbox.ifc2x3tc1;
/**
 * This is a default implementation of the entity IfcMaterialClassificationRelationship<br><br>
 *<br><br>
 * Copyright: CC BY-NC-SA 3.0 DE (cc) 2013 Eike Tauscher and Michael Theiler<br><br>
 * The whole package including this class is licensed under<br>
 * <a rel='license' href='http://creativecommons.org/licenses/by-nc-sa/3.0/de/deed.en/'>
 * Creative Commons Attribution-Non-Commercial-Share Alike 3.0 Germany</a>.<br><br>
 * If you are using the package or parts of it in any commercial way, a commercial license is required. 
 * Visit <a href='http://www.ifctoolsproject.com'>http://www.ifctoolsproject.com</a> for more information
 * or contact us directly: <a href='mailto:info@ifctoolsproject.com'>info@ifctoolsproject.com</a><br>
 */
public class IfcMaterialClassificationRelationship extends InternalAccessClass implements ClassInterface
{
	private static final String[] nonInverseAttributes = new String[]{"SET<IfcClassificationNotationSelect>","IfcMaterial"};
	private java.util.ArrayList<CloneableObject> stepParameter = null;
	private java.util.HashSet<ObjectChangeListener> listenerList = null;
	protected int stepLineNumber;
	/** MaterialClassifications is an DEMANDED attribute - may not be null**/
	protected SET<IfcClassificationNotationSelect> MaterialClassifications;
	/** ClassifiedMaterial is an DEMANDED attribute - may not be null**/
	protected IfcMaterial ClassifiedMaterial;
	/**
	* The default constructor.
	**/
	public IfcMaterialClassificationRelationship(){}

	private static final String[] attributes = new String[]{"MaterialClassifications","ClassifiedMaterial"};

	public String[] getAttributes() {
		return IfcMaterialClassificationRelationship.attributes;
	}

	/**
	* Constructs a new IfcMaterialClassificationRelationship object using the given parameters.
	*
	* @param MaterialClassifications DEMANDED parameter of type SET<IfcClassificationNotationSelect> - may not be null.
	* @param ClassifiedMaterial DEMANDED parameter of type IfcMaterial - may not be null.
	**/
	public IfcMaterialClassificationRelationship(SET<IfcClassificationNotationSelect> MaterialClassifications, IfcMaterial ClassifiedMaterial)
	{
		this.MaterialClassifications = MaterialClassifications;
		this.ClassifiedMaterial = ClassifiedMaterial;
		resolveInverses();
	}

	/**
	 * This method initializes the IfcMaterialClassificationRelationship object using the given parameters.
	*
	* @param MaterialClassifications DEMANDED parameter of type SET<IfcClassificationNotationSelect> - may not be null.
	* @param ClassifiedMaterial DEMANDED parameter of type IfcMaterial - may not be null.
	**/
	public void setParameters(SET<IfcClassificationNotationSelect> MaterialClassifications, IfcMaterial ClassifiedMaterial)
	{
		this.MaterialClassifications = MaterialClassifications;
		this.ClassifiedMaterial = ClassifiedMaterial;
		resolveInverses();
	}

	/**
	 * This method is used internally and should NOT be used for own purposes.
	**/
	@SuppressWarnings("unchecked")
	void initialize(java.util.ArrayList<CloneableObject> parameters)
	{
		this.MaterialClassifications = (SET<IfcClassificationNotationSelect>) parameters.get(0);
		this.ClassifiedMaterial = (IfcMaterial) parameters.get(1);
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
		if(ClassifiedMaterial != null)
		{
				if(ClassifiedMaterial.ClassifiedAs_Inverse == null)
				{
					ClassifiedMaterial.ClassifiedAs_Inverse = new SET<IfcMaterialClassificationRelationship>();
				}
				ClassifiedMaterial.ClassifiedAs_Inverse.add(this);
		}
	}

	/**
	 * This method is used internally and should NOT be used for own purposes.
	**/
	String[] getNonInverseAttributeTypes()
	{
		return IfcMaterialClassificationRelationship.nonInverseAttributes;	}

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
		stepString = stepString.concat("IFCMATERIALCLASSIFICATIONRELATIONSHIP(");
		if(getRedefinedDerivedAttributeTypes().contains("MaterialClassifications")) stepString = stepString.concat("*,");
		else{
		if(this.MaterialClassifications != null)		stepString = stepString.concat(((RootInterface)this.MaterialClassifications).getStepParameter(IfcClassificationNotationSelect.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("ClassifiedMaterial")) stepString = stepString.concat("*);");
		else{
		if(this.ClassifiedMaterial != null)		stepString = stepString.concat(((RootInterface)this.ClassifiedMaterial).getStepParameter(IfcMaterial.class.isInterface())+");");
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
	* This method sets the MaterialClassifications attribute to the given value.
	*
	* @param MaterialClassifications OPTIONAL value to set
	**/
	public void setMaterialClassifications(SET<IfcClassificationNotationSelect> MaterialClassifications)
	{
		this.MaterialClassifications = MaterialClassifications;
		fireChangeEvent();
	}

	/**
	* This method returns a copy of the set of the MaterialClassifications attribute.
	*
	* @return a copy of the MaterialClassifications set
	**/
	public SET<IfcClassificationNotationSelect> getMaterialClassifications()
	{
		if(this.MaterialClassifications != null)
			return new SET<IfcClassificationNotationSelect>(this.MaterialClassifications);
		return null;
	}

	/**
	* This method adds an IfcClassificationNotationSelect object to the MaterialClassifications set.
	* @param MaterialClassifications element to be appended to this set.
	**/
	public void addMaterialClassifications(IfcClassificationNotationSelect MaterialClassifications)
	{
		if(this.MaterialClassifications == null)
			this.MaterialClassifications = new SET<IfcClassificationNotationSelect>();
		this.MaterialClassifications.add(MaterialClassifications);
		fireChangeEvent();
	}

	/**
	* This method adds a collection of IfcClassificationNotationSelect objects to the MaterialClassifications set.
	* @param MaterialClassifications collection containing elements to be added to this set.
	**/
	public void addAllMaterialClassifications(java.util.Collection<IfcClassificationNotationSelect> MaterialClassifications)
	{
		if(this.MaterialClassifications == null)
			this.MaterialClassifications = new SET<IfcClassificationNotationSelect>();
		this.MaterialClassifications.addAll(MaterialClassifications);
		fireChangeEvent();
	}

	/**
	* This method removes all elements from the MaterialClassifications set.
	**/
	public void clearMaterialClassifications()
	{
		if(this.MaterialClassifications != null)
		{
			this.MaterialClassifications.clear();
			fireChangeEvent();
		}
	}

	/**
	* This method removes an IfcClassificationNotationSelect object from the MaterialClassifications set.
	* @param MaterialClassifications element to be removed from this set.
	**/
	public void removeMaterialClassifications(IfcClassificationNotationSelect MaterialClassifications)
	{
		if(this.MaterialClassifications != null)
		{
			this.MaterialClassifications.remove(MaterialClassifications);
			fireChangeEvent();
		}
	}

	/**
	* This method removes a collection of IfcClassificationNotationSelect objects from the MaterialClassifications set.
	* @param MaterialClassifications collection containing elements to be removed from this set.
	**/
	public void removeAllMaterialClassifications(java.util.Collection<IfcClassificationNotationSelect> MaterialClassifications)
	{
		if(this.MaterialClassifications != null)
		{
			this.MaterialClassifications.removeAll(MaterialClassifications);
			fireChangeEvent();
		}
	}

	/**
	* This method sets the ClassifiedMaterial attribute to the given value.
	*
	* @param ClassifiedMaterial OPTIONAL value to set
	**/
	public void setClassifiedMaterial(IfcMaterial ClassifiedMaterial)
	{
		synchronizeInversesRemoveClassifiedMaterial(this.ClassifiedMaterial);
		this.ClassifiedMaterial = ClassifiedMaterial;
		synchronizeInversesAddClassifiedMaterial(this.ClassifiedMaterial);
		fireChangeEvent();
	}

	/**
	* This method returns the value of the ClassifiedMaterial attribute.
	*
	* @return the value of ClassifiedMaterial
	/**/
	public IfcMaterial getClassifiedMaterial()
	{
		return this.ClassifiedMaterial;
	}

	private void synchronizeInversesAddClassifiedMaterial(IfcMaterial ClassifiedMaterial)
	{
		if(ClassifiedMaterial != null)
		{
				if(ClassifiedMaterial.ClassifiedAs_Inverse == null)
				{
					ClassifiedMaterial.ClassifiedAs_Inverse = new SET<IfcMaterialClassificationRelationship>();
				}
				ClassifiedMaterial.ClassifiedAs_Inverse.add(this);
		}
	}

	private void synchronizeInversesRemoveClassifiedMaterial(IfcMaterial ClassifiedMaterial)
	{
		if(ClassifiedMaterial != null)
		{
				if(ClassifiedMaterial.ClassifiedAs_Inverse != null)
				{
					ClassifiedMaterial.ClassifiedAs_Inverse.remove(this);
				}
		}
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
		IfcMaterialClassificationRelationship ifcMaterialClassificationRelationship = new IfcMaterialClassificationRelationship();
		if(this.MaterialClassifications != null)
			ifcMaterialClassificationRelationship.setMaterialClassifications((SET<IfcClassificationNotationSelect>)this.MaterialClassifications.clone());
		if(this.ClassifiedMaterial != null)
			ifcMaterialClassificationRelationship.setClassifiedMaterial((IfcMaterial)this.ClassifiedMaterial.clone());
		return ifcMaterialClassificationRelationship;
	}

	/**
	 * This method copys the object as shallow copy (all referenced objects are remaining).
	 *
	 * @return the cloned object
	**/
	public Object shallowCopy()
	{
		IfcMaterialClassificationRelationship ifcMaterialClassificationRelationship = new IfcMaterialClassificationRelationship();
		if(this.MaterialClassifications != null)
			ifcMaterialClassificationRelationship.setMaterialClassifications(this.MaterialClassifications);
		if(this.ClassifiedMaterial != null)
			ifcMaterialClassificationRelationship.setClassifiedMaterial(this.ClassifiedMaterial);
		return ifcMaterialClassificationRelationship;
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
