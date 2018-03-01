/* Generated By: IFC Tools Project EXPRESS TO JAVA COMPILER: Do not edit this file!! */
package ifc2x3javatoolbox.ifc2x3tc1;
/**
 * This is a default implementation of the entity IfcStructuralLoadSingleForce<br><br>
 *<br><br>
 * Copyright: CC BY-NC-SA 3.0 DE (cc) 2013 Eike Tauscher and Michael Theiler<br><br>
 * The whole package including this class is licensed under<br>
 * <a rel='license' href='http://creativecommons.org/licenses/by-nc-sa/3.0/de/deed.en/'>
 * Creative Commons Attribution-Non-Commercial-Share Alike 3.0 Germany</a>.<br><br>
 * If you are using the package or parts of it in any commercial way, a commercial license is required. 
 * Visit <a href='http://www.ifctoolsproject.com'>http://www.ifctoolsproject.com</a> for more information
 * or contact us directly: <a href='mailto:info@ifctoolsproject.com'>info@ifctoolsproject.com</a><br>
 */
public class IfcStructuralLoadSingleForce extends IfcStructuralLoadStatic implements ClassInterface
{
	private static final String[] nonInverseAttributes = new String[]{"IfcLabel","IfcForceMeasure","IfcForceMeasure","IfcForceMeasure","IfcTorqueMeasure","IfcTorqueMeasure","IfcTorqueMeasure"};
	private java.util.ArrayList<CloneableObject> stepParameter = null;
	private java.util.HashSet<ObjectChangeListener> listenerList = null;
	protected int stepLineNumber;
	/** ForceX is an OPTIONAL attribute**/
	protected IfcForceMeasure ForceX;
	/** ForceY is an OPTIONAL attribute**/
	protected IfcForceMeasure ForceY;
	/** ForceZ is an OPTIONAL attribute**/
	protected IfcForceMeasure ForceZ;
	/** MomentX is an OPTIONAL attribute**/
	protected IfcTorqueMeasure MomentX;
	/** MomentY is an OPTIONAL attribute**/
	protected IfcTorqueMeasure MomentY;
	/** MomentZ is an OPTIONAL attribute**/
	protected IfcTorqueMeasure MomentZ;
	/**
	* The default constructor.
	**/
	public IfcStructuralLoadSingleForce(){}

	private static final String[] attributes = new String[]{"Name","ForceX","ForceY","ForceZ","MomentX","MomentY","MomentZ"};

	public String[] getAttributes(){
		return IfcStructuralLoadSingleForce.attributes;
	}

	/**
	* Constructs a new IfcStructuralLoadSingleForce object using the given parameters.
	*
	* @param Name OPTIONAL parameter of type IfcLabel
	* @param ForceX OPTIONAL parameter of type IfcForceMeasure
	* @param ForceY OPTIONAL parameter of type IfcForceMeasure
	* @param ForceZ OPTIONAL parameter of type IfcForceMeasure
	* @param MomentX OPTIONAL parameter of type IfcTorqueMeasure
	* @param MomentY OPTIONAL parameter of type IfcTorqueMeasure
	* @param MomentZ OPTIONAL parameter of type IfcTorqueMeasure
	**/
	public IfcStructuralLoadSingleForce(IfcLabel Name, IfcForceMeasure ForceX, IfcForceMeasure ForceY, IfcForceMeasure ForceZ, IfcTorqueMeasure MomentX, IfcTorqueMeasure MomentY, IfcTorqueMeasure MomentZ)
	{
		this.Name = Name;
		this.ForceX = ForceX;
		this.ForceY = ForceY;
		this.ForceZ = ForceZ;
		this.MomentX = MomentX;
		this.MomentY = MomentY;
		this.MomentZ = MomentZ;
		resolveInverses();
	}

	/**
	 * This method initializes the IfcStructuralLoadSingleForce object using the given parameters.
	*
	* @param Name OPTIONAL parameter of type IfcLabel
	* @param ForceX OPTIONAL parameter of type IfcForceMeasure
	* @param ForceY OPTIONAL parameter of type IfcForceMeasure
	* @param ForceZ OPTIONAL parameter of type IfcForceMeasure
	* @param MomentX OPTIONAL parameter of type IfcTorqueMeasure
	* @param MomentY OPTIONAL parameter of type IfcTorqueMeasure
	* @param MomentZ OPTIONAL parameter of type IfcTorqueMeasure
	**/
	public void setParameters(IfcLabel Name, IfcForceMeasure ForceX, IfcForceMeasure ForceY, IfcForceMeasure ForceZ, IfcTorqueMeasure MomentX, IfcTorqueMeasure MomentY, IfcTorqueMeasure MomentZ)
	{
		this.Name = Name;
		this.ForceX = ForceX;
		this.ForceY = ForceY;
		this.ForceZ = ForceZ;
		this.MomentX = MomentX;
		this.MomentY = MomentY;
		this.MomentZ = MomentZ;
		resolveInverses();
	}

	/**
	 * This method is used internally and should NOT be used for own purposes.
	**/
	void initialize(java.util.ArrayList<CloneableObject> parameters)
	{
		this.Name = (IfcLabel) parameters.get(0);
		this.ForceX = (IfcForceMeasure) parameters.get(1);
		this.ForceY = (IfcForceMeasure) parameters.get(2);
		this.ForceZ = (IfcForceMeasure) parameters.get(3);
		this.MomentX = (IfcTorqueMeasure) parameters.get(4);
		this.MomentY = (IfcTorqueMeasure) parameters.get(5);
		this.MomentZ = (IfcTorqueMeasure) parameters.get(6);
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
		return IfcStructuralLoadSingleForce.nonInverseAttributes;	}

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
		stepString = stepString.concat("IFCSTRUCTURALLOADSINGLEFORCE(");
		if(getRedefinedDerivedAttributeTypes().contains("Name")) stepString = stepString.concat("*,");
		else{
		if(this.Name != null)		stepString = stepString.concat(((RootInterface)this.Name).getStepParameter(IfcLabel.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("ForceX")) stepString = stepString.concat("*,");
		else{
		if(this.ForceX != null)		stepString = stepString.concat(((RootInterface)this.ForceX).getStepParameter(IfcForceMeasure.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("ForceY")) stepString = stepString.concat("*,");
		else{
		if(this.ForceY != null)		stepString = stepString.concat(((RootInterface)this.ForceY).getStepParameter(IfcForceMeasure.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("ForceZ")) stepString = stepString.concat("*,");
		else{
		if(this.ForceZ != null)		stepString = stepString.concat(((RootInterface)this.ForceZ).getStepParameter(IfcForceMeasure.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("MomentX")) stepString = stepString.concat("*,");
		else{
		if(this.MomentX != null)		stepString = stepString.concat(((RootInterface)this.MomentX).getStepParameter(IfcTorqueMeasure.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("MomentY")) stepString = stepString.concat("*,");
		else{
		if(this.MomentY != null)		stepString = stepString.concat(((RootInterface)this.MomentY).getStepParameter(IfcTorqueMeasure.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("MomentZ")) stepString = stepString.concat("*);");
		else{
		if(this.MomentZ != null)		stepString = stepString.concat(((RootInterface)this.MomentZ).getStepParameter(IfcTorqueMeasure.class.isInterface())+");");
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
	* This method sets the ForceX attribute to the given value.
	*
	* @param ForceX DEMANDED value to set - may not be null
	**/
	public void setForceX(IfcForceMeasure ForceX)
	{
		this.ForceX = ForceX;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the ForceX attribute.
	*
	* @return the value of ForceX
	/**/
	public IfcForceMeasure getForceX()
	{
		return this.ForceX;
	}

	/**
	* This method sets the ForceY attribute to the given value.
	*
	* @param ForceY DEMANDED value to set - may not be null
	**/
	public void setForceY(IfcForceMeasure ForceY)
	{
		this.ForceY = ForceY;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the ForceY attribute.
	*
	* @return the value of ForceY
	/**/
	public IfcForceMeasure getForceY()
	{
		return this.ForceY;
	}

	/**
	* This method sets the ForceZ attribute to the given value.
	*
	* @param ForceZ DEMANDED value to set - may not be null
	**/
	public void setForceZ(IfcForceMeasure ForceZ)
	{
		this.ForceZ = ForceZ;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the ForceZ attribute.
	*
	* @return the value of ForceZ
	/**/
	public IfcForceMeasure getForceZ()
	{
		return this.ForceZ;
	}

	/**
	* This method sets the MomentX attribute to the given value.
	*
	* @param MomentX DEMANDED value to set - may not be null
	**/
	public void setMomentX(IfcTorqueMeasure MomentX)
	{
		this.MomentX = MomentX;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the MomentX attribute.
	*
	* @return the value of MomentX
	/**/
	public IfcTorqueMeasure getMomentX()
	{
		return this.MomentX;
	}

	/**
	* This method sets the MomentY attribute to the given value.
	*
	* @param MomentY DEMANDED value to set - may not be null
	**/
	public void setMomentY(IfcTorqueMeasure MomentY)
	{
		this.MomentY = MomentY;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the MomentY attribute.
	*
	* @return the value of MomentY
	/**/
	public IfcTorqueMeasure getMomentY()
	{
		return this.MomentY;
	}

	/**
	* This method sets the MomentZ attribute to the given value.
	*
	* @param MomentZ DEMANDED value to set - may not be null
	**/
	public void setMomentZ(IfcTorqueMeasure MomentZ)
	{
		this.MomentZ = MomentZ;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the MomentZ attribute.
	*
	* @return the value of MomentZ
	/**/
	public IfcTorqueMeasure getMomentZ()
	{
		return this.MomentZ;
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
		IfcStructuralLoadSingleForce ifcStructuralLoadSingleForce = new IfcStructuralLoadSingleForce();
		if(this.Name != null)
			ifcStructuralLoadSingleForce.setName((IfcLabel)this.Name.clone());
		if(this.ForceX != null)
			ifcStructuralLoadSingleForce.setForceX((IfcForceMeasure)this.ForceX.clone());
		if(this.ForceY != null)
			ifcStructuralLoadSingleForce.setForceY((IfcForceMeasure)this.ForceY.clone());
		if(this.ForceZ != null)
			ifcStructuralLoadSingleForce.setForceZ((IfcForceMeasure)this.ForceZ.clone());
		if(this.MomentX != null)
			ifcStructuralLoadSingleForce.setMomentX((IfcTorqueMeasure)this.MomentX.clone());
		if(this.MomentY != null)
			ifcStructuralLoadSingleForce.setMomentY((IfcTorqueMeasure)this.MomentY.clone());
		if(this.MomentZ != null)
			ifcStructuralLoadSingleForce.setMomentZ((IfcTorqueMeasure)this.MomentZ.clone());
		return ifcStructuralLoadSingleForce;
	}

	/**
	 * This method copys the object as shallow copy (all referenced objects are remaining).
	 *
	 * @return the cloned object
	**/
	public Object shallowCopy()
	{
		IfcStructuralLoadSingleForce ifcStructuralLoadSingleForce = new IfcStructuralLoadSingleForce();
		if(this.Name != null)
			ifcStructuralLoadSingleForce.setName(this.Name);
		if(this.ForceX != null)
			ifcStructuralLoadSingleForce.setForceX(this.ForceX);
		if(this.ForceY != null)
			ifcStructuralLoadSingleForce.setForceY(this.ForceY);
		if(this.ForceZ != null)
			ifcStructuralLoadSingleForce.setForceZ(this.ForceZ);
		if(this.MomentX != null)
			ifcStructuralLoadSingleForce.setMomentX(this.MomentX);
		if(this.MomentY != null)
			ifcStructuralLoadSingleForce.setMomentY(this.MomentY);
		if(this.MomentZ != null)
			ifcStructuralLoadSingleForce.setMomentZ(this.MomentZ);
		return ifcStructuralLoadSingleForce;
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
