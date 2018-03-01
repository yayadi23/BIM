/* Generated By: IFC Tools Project EXPRESS TO JAVA COMPILER: Do not edit this file!! */
package ifc2x3javatoolbox.ifc2x3tc1;
/**
 * This is a default implementation of the entity IfcFaceSurface<br><br>
 *<br><br>
 * Copyright: CC BY-NC-SA 3.0 DE (cc) 2013 Eike Tauscher and Michael Theiler<br><br>
 * The whole package including this class is licensed under<br>
 * <a rel='license' href='http://creativecommons.org/licenses/by-nc-sa/3.0/de/deed.en/'>
 * Creative Commons Attribution-Non-Commercial-Share Alike 3.0 Germany</a>.<br><br>
 * If you are using the package or parts of it in any commercial way, a commercial license is required. 
 * Visit <a href='http://www.ifctoolsproject.com'>http://www.ifctoolsproject.com</a> for more information
 * or contact us directly: <a href='mailto:info@ifctoolsproject.com'>info@ifctoolsproject.com</a><br>
 */
public class IfcFaceSurface extends IfcFace implements IfcSurfaceOrFaceSurface, ClassInterface
{
	private static final String[] nonInverseAttributes = new String[]{"SET<IfcFaceBound>","IfcSurface","BOOLEAN"};
	private java.util.ArrayList<CloneableObject> stepParameter = null;
	private java.util.HashSet<ObjectChangeListener> listenerList = null;
	protected int stepLineNumber;
	/** FaceSurface is an DEMANDED attribute - may not be null**/
	protected IfcSurface FaceSurface;
	/** SameSense is an DEMANDED attribute - may not be null**/
	protected BOOLEAN SameSense;
	/**
	* The default constructor.
	**/
	public IfcFaceSurface(){}

	private static final String[] attributes = new String[]{"Bounds","FaceSurface","SameSense"};

	public String[] getAttributes() {
		return IfcFaceSurface.attributes;
	}

	/**
	* Constructs a new IfcFaceSurface object using the given parameters.
	*
	* @param Bounds DEMANDED parameter of type SET<IfcFaceBound> - may not be null.
	* @param FaceSurface DEMANDED parameter of type IfcSurface - may not be null.
	* @param SameSense DEMANDED parameter of type BOOLEAN - may not be null.
	**/
	public IfcFaceSurface(SET<IfcFaceBound> Bounds, IfcSurface FaceSurface, BOOLEAN SameSense)
	{
		this.Bounds = Bounds;
		this.FaceSurface = FaceSurface;
		this.SameSense = SameSense;
		resolveInverses();
	}

	/**
	 * This method initializes the IfcFaceSurface object using the given parameters.
	*
	* @param Bounds DEMANDED parameter of type SET<IfcFaceBound> - may not be null.
	* @param FaceSurface DEMANDED parameter of type IfcSurface - may not be null.
	* @param SameSense DEMANDED parameter of type BOOLEAN - may not be null.
	**/
	public void setParameters(SET<IfcFaceBound> Bounds, IfcSurface FaceSurface, BOOLEAN SameSense)
	{
		this.Bounds = Bounds;
		this.FaceSurface = FaceSurface;
		this.SameSense = SameSense;
		resolveInverses();
	}

	/**
	 * This method is used internally and should NOT be used for own purposes.
	**/
	@SuppressWarnings("unchecked")
	void initialize(java.util.ArrayList<CloneableObject> parameters)
	{
		this.Bounds = (SET<IfcFaceBound>) parameters.get(0);
		this.FaceSurface = (IfcSurface) parameters.get(1);
		this.SameSense = (BOOLEAN) parameters.get(2);
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
		return IfcFaceSurface.nonInverseAttributes;	}

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
		stepString = stepString.concat("IFCFACESURFACE(");
		if(getRedefinedDerivedAttributeTypes().contains("Bounds")) stepString = stepString.concat("*,");
		else{
		if(this.Bounds != null)		stepString = stepString.concat(((RootInterface)this.Bounds).getStepParameter(IfcFaceBound.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("FaceSurface")) stepString = stepString.concat("*,");
		else{
		if(this.FaceSurface != null)		stepString = stepString.concat(((RootInterface)this.FaceSurface).getStepParameter(IfcSurface.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("SameSense")) stepString = stepString.concat("*);");
		else{
		if(this.SameSense != null)		stepString = stepString.concat(((RootInterface)this.SameSense).getStepParameter(BOOLEAN.class.isInterface())+");");
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
	* This method sets the FaceSurface attribute to the given value.
	*
	* @param FaceSurface OPTIONAL value to set
	**/
	public void setFaceSurface(IfcSurface FaceSurface)
	{
		this.FaceSurface = FaceSurface;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the FaceSurface attribute.
	*
	* @return the value of FaceSurface
	/**/
	public IfcSurface getFaceSurface()
	{
		return this.FaceSurface;
	}

	/**
	* This method sets the SameSense attribute to the given value.
	*
	* @param SameSense OPTIONAL value to set
	**/
	public void setSameSense(BOOLEAN SameSense)
	{
		this.SameSense = SameSense;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the SameSense attribute.
	*
	* @return the value of SameSense
	/**/
	public BOOLEAN getSameSense()
	{
		return this.SameSense;
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
		IfcFaceSurface ifcFaceSurface = new IfcFaceSurface();
		if(this.Bounds != null)
			ifcFaceSurface.setBounds((SET<IfcFaceBound>)this.Bounds.clone());
		if(this.FaceSurface != null)
			ifcFaceSurface.setFaceSurface((IfcSurface)this.FaceSurface.clone());
		if(this.SameSense != null)
			ifcFaceSurface.setSameSense((BOOLEAN)this.SameSense.clone());
		return ifcFaceSurface;
	}

	/**
	 * This method copys the object as shallow copy (all referenced objects are remaining).
	 *
	 * @return the cloned object
	**/
	public Object shallowCopy()
	{
		IfcFaceSurface ifcFaceSurface = new IfcFaceSurface();
		if(this.Bounds != null)
			ifcFaceSurface.setBounds(this.Bounds);
		if(this.FaceSurface != null)
			ifcFaceSurface.setFaceSurface(this.FaceSurface);
		if(this.SameSense != null)
			ifcFaceSurface.setSameSense(this.SameSense);
		return ifcFaceSurface;
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
