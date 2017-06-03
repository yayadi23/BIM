/* Generated By: IFC Tools Project EXPRESS TO JAVA COMPILER: Do not edit this file!! */
package ifc2x3javatoolbox.ifc2x3tc1;
/**
 * This is a default implementation of the entity IfcRectangularTrimmedSurface<br><br>
 *<br><br>
 * Copyright: CC BY-NC-SA 3.0 DE (cc) 2013 Eike Tauscher and Michael Theiler<br><br>
 * The whole package including this class is licensed under<br>
 * <a rel='license' href='http://creativecommons.org/licenses/by-nc-sa/3.0/de/deed.en/'>
 * Creative Commons Attribution-Non-Commercial-Share Alike 3.0 Germany</a>.<br><br>
 * If you are using the package or parts of it in any commercial way, a commercial license is required. 
 * Visit <a href='http://www.ifctoolsproject.com'>http://www.ifctoolsproject.com</a> for more information
 * or contact us directly: <a href='mailto:info@ifctoolsproject.com'>info@ifctoolsproject.com</a><br>
 */
public class IfcRectangularTrimmedSurface extends IfcBoundedSurface implements ClassInterface
{
	private static final String[] nonInverseAttributes = new String[]{"IfcSurface","IfcParameterValue","IfcParameterValue","IfcParameterValue","IfcParameterValue","BOOLEAN","BOOLEAN"};
	private java.util.ArrayList<CloneableObject> stepParameter = null;
	private java.util.HashSet<ObjectChangeListener> listenerList = null;
	protected int stepLineNumber;
	/** BasisSurface is an DEMANDED attribute - may not be null**/
	protected IfcSurface BasisSurface;
	/** U1 is an DEMANDED attribute - may not be null**/
	protected IfcParameterValue U1;
	/** V1 is an DEMANDED attribute - may not be null**/
	protected IfcParameterValue V1;
	/** U2 is an DEMANDED attribute - may not be null**/
	protected IfcParameterValue U2;
	/** V2 is an DEMANDED attribute - may not be null**/
	protected IfcParameterValue V2;
	/** Usense is an DEMANDED attribute - may not be null**/
	protected BOOLEAN Usense;
	/** Vsense is an DEMANDED attribute - may not be null**/
	protected BOOLEAN Vsense;
	/**
	* The default constructor.
	**/
	public IfcRectangularTrimmedSurface(){}

	/**
	* Constructs a new IfcRectangularTrimmedSurface object using the given parameters.
	*
	* @param BasisSurface DEMANDED parameter of type IfcSurface - may not be null.
	* @param U1 DEMANDED parameter of type IfcParameterValue - may not be null.
	* @param V1 DEMANDED parameter of type IfcParameterValue - may not be null.
	* @param U2 DEMANDED parameter of type IfcParameterValue - may not be null.
	* @param V2 DEMANDED parameter of type IfcParameterValue - may not be null.
	* @param Usense DEMANDED parameter of type BOOLEAN - may not be null.
	* @param Vsense DEMANDED parameter of type BOOLEAN - may not be null.
	**/
	public IfcRectangularTrimmedSurface(IfcSurface BasisSurface, IfcParameterValue U1, IfcParameterValue V1, IfcParameterValue U2, IfcParameterValue V2, BOOLEAN Usense, BOOLEAN Vsense)
	{
		this.BasisSurface = BasisSurface;
		this.U1 = U1;
		this.V1 = V1;
		this.U2 = U2;
		this.V2 = V2;
		this.Usense = Usense;
		this.Vsense = Vsense;
		resolveInverses();
	}

	/**
	 * This method initializes the IfcRectangularTrimmedSurface object using the given parameters.
	*
	* @param BasisSurface DEMANDED parameter of type IfcSurface - may not be null.
	* @param U1 DEMANDED parameter of type IfcParameterValue - may not be null.
	* @param V1 DEMANDED parameter of type IfcParameterValue - may not be null.
	* @param U2 DEMANDED parameter of type IfcParameterValue - may not be null.
	* @param V2 DEMANDED parameter of type IfcParameterValue - may not be null.
	* @param Usense DEMANDED parameter of type BOOLEAN - may not be null.
	* @param Vsense DEMANDED parameter of type BOOLEAN - may not be null.
	**/
	public void setParameters(IfcSurface BasisSurface, IfcParameterValue U1, IfcParameterValue V1, IfcParameterValue U2, IfcParameterValue V2, BOOLEAN Usense, BOOLEAN Vsense)
	{
		this.BasisSurface = BasisSurface;
		this.U1 = U1;
		this.V1 = V1;
		this.U2 = U2;
		this.V2 = V2;
		this.Usense = Usense;
		this.Vsense = Vsense;
		resolveInverses();
	}

	/**
	 * This method is used internally and should NOT be used for own purposes.
	**/
	void initialize(java.util.ArrayList<CloneableObject> parameters)
	{
		this.BasisSurface = (IfcSurface) parameters.get(0);
		this.U1 = (IfcParameterValue) parameters.get(1);
		this.V1 = (IfcParameterValue) parameters.get(2);
		this.U2 = (IfcParameterValue) parameters.get(3);
		this.V2 = (IfcParameterValue) parameters.get(4);
		this.Usense = (BOOLEAN) parameters.get(5);
		this.Vsense = (BOOLEAN) parameters.get(6);
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
		return IfcRectangularTrimmedSurface.nonInverseAttributes;	}

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
		stepString = stepString.concat("IFCRECTANGULARTRIMMEDSURFACE(");
		if(getRedefinedDerivedAttributeTypes().contains("BasisSurface")) stepString = stepString.concat("*,");
		else{
		if(this.BasisSurface != null)		stepString = stepString.concat(((RootInterface)this.BasisSurface).getStepParameter(IfcSurface.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("U1")) stepString = stepString.concat("*,");
		else{
		if(this.U1 != null)		stepString = stepString.concat(((RootInterface)this.U1).getStepParameter(IfcParameterValue.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("V1")) stepString = stepString.concat("*,");
		else{
		if(this.V1 != null)		stepString = stepString.concat(((RootInterface)this.V1).getStepParameter(IfcParameterValue.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("U2")) stepString = stepString.concat("*,");
		else{
		if(this.U2 != null)		stepString = stepString.concat(((RootInterface)this.U2).getStepParameter(IfcParameterValue.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("V2")) stepString = stepString.concat("*,");
		else{
		if(this.V2 != null)		stepString = stepString.concat(((RootInterface)this.V2).getStepParameter(IfcParameterValue.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("Usense")) stepString = stepString.concat("*,");
		else{
		if(this.Usense != null)		stepString = stepString.concat(((RootInterface)this.Usense).getStepParameter(BOOLEAN.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("Vsense")) stepString = stepString.concat("*);");
		else{
		if(this.Vsense != null)		stepString = stepString.concat(((RootInterface)this.Vsense).getStepParameter(BOOLEAN.class.isInterface())+");");
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
	* This method sets the BasisSurface attribute to the given value.
	*
	* @param BasisSurface OPTIONAL value to set
	**/
	public void setBasisSurface(IfcSurface BasisSurface)
	{
		this.BasisSurface = BasisSurface;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the BasisSurface attribute.
	*
	* @return the value of BasisSurface
	/**/
	public IfcSurface getBasisSurface()
	{
		return this.BasisSurface;
	}

	/**
	* This method sets the U1 attribute to the given value.
	*
	* @param U1 OPTIONAL value to set
	**/
	public void setU1(IfcParameterValue U1)
	{
		this.U1 = U1;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the U1 attribute.
	*
	* @return the value of U1
	/**/
	public IfcParameterValue getU1()
	{
		return this.U1;
	}

	/**
	* This method sets the V1 attribute to the given value.
	*
	* @param V1 OPTIONAL value to set
	**/
	public void setV1(IfcParameterValue V1)
	{
		this.V1 = V1;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the V1 attribute.
	*
	* @return the value of V1
	/**/
	public IfcParameterValue getV1()
	{
		return this.V1;
	}

	/**
	* This method sets the U2 attribute to the given value.
	*
	* @param U2 OPTIONAL value to set
	**/
	public void setU2(IfcParameterValue U2)
	{
		this.U2 = U2;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the U2 attribute.
	*
	* @return the value of U2
	/**/
	public IfcParameterValue getU2()
	{
		return this.U2;
	}

	/**
	* This method sets the V2 attribute to the given value.
	*
	* @param V2 OPTIONAL value to set
	**/
	public void setV2(IfcParameterValue V2)
	{
		this.V2 = V2;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the V2 attribute.
	*
	* @return the value of V2
	/**/
	public IfcParameterValue getV2()
	{
		return this.V2;
	}

	/**
	* This method sets the Usense attribute to the given value.
	*
	* @param Usense OPTIONAL value to set
	**/
	public void setUsense(BOOLEAN Usense)
	{
		this.Usense = Usense;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the Usense attribute.
	*
	* @return the value of Usense
	/**/
	public BOOLEAN getUsense()
	{
		return this.Usense;
	}

	/**
	* This method sets the Vsense attribute to the given value.
	*
	* @param Vsense OPTIONAL value to set
	**/
	public void setVsense(BOOLEAN Vsense)
	{
		this.Vsense = Vsense;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the Vsense attribute.
	*
	* @return the value of Vsense
	/**/
	public BOOLEAN getVsense()
	{
		return this.Vsense;
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
		IfcRectangularTrimmedSurface ifcRectangularTrimmedSurface = new IfcRectangularTrimmedSurface();
		if(this.BasisSurface != null)
			ifcRectangularTrimmedSurface.setBasisSurface((IfcSurface)this.BasisSurface.clone());
		if(this.U1 != null)
			ifcRectangularTrimmedSurface.setU1((IfcParameterValue)this.U1.clone());
		if(this.V1 != null)
			ifcRectangularTrimmedSurface.setV1((IfcParameterValue)this.V1.clone());
		if(this.U2 != null)
			ifcRectangularTrimmedSurface.setU2((IfcParameterValue)this.U2.clone());
		if(this.V2 != null)
			ifcRectangularTrimmedSurface.setV2((IfcParameterValue)this.V2.clone());
		if(this.Usense != null)
			ifcRectangularTrimmedSurface.setUsense((BOOLEAN)this.Usense.clone());
		if(this.Vsense != null)
			ifcRectangularTrimmedSurface.setVsense((BOOLEAN)this.Vsense.clone());
		return ifcRectangularTrimmedSurface;
	}

	/**
	 * This method copys the object as shallow copy (all referenced objects are remaining).
	 *
	 * @return the cloned object
	**/
	public Object shallowCopy()
	{
		IfcRectangularTrimmedSurface ifcRectangularTrimmedSurface = new IfcRectangularTrimmedSurface();
		if(this.BasisSurface != null)
			ifcRectangularTrimmedSurface.setBasisSurface(this.BasisSurface);
		if(this.U1 != null)
			ifcRectangularTrimmedSurface.setU1(this.U1);
		if(this.V1 != null)
			ifcRectangularTrimmedSurface.setV1(this.V1);
		if(this.U2 != null)
			ifcRectangularTrimmedSurface.setU2(this.U2);
		if(this.V2 != null)
			ifcRectangularTrimmedSurface.setV2(this.V2);
		if(this.Usense != null)
			ifcRectangularTrimmedSurface.setUsense(this.Usense);
		if(this.Vsense != null)
			ifcRectangularTrimmedSurface.setVsense(this.Vsense);
		return ifcRectangularTrimmedSurface;
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
