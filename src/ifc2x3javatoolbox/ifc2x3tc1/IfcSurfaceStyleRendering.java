/* Generated By: IFC Tools Project EXPRESS TO JAVA COMPILER: Do not edit this file!! */
package ifc2x3javatoolbox.ifc2x3tc1;
/**
 * This is a default implementation of the entity IfcSurfaceStyleRendering<br><br>
 *<br><br>
 * Copyright: CC BY-NC-SA 3.0 DE (cc) 2013 Eike Tauscher and Michael Theiler<br><br>
 * The whole package including this class is licensed under<br>
 * <a rel='license' href='http://creativecommons.org/licenses/by-nc-sa/3.0/de/deed.en/'>
 * Creative Commons Attribution-Non-Commercial-Share Alike 3.0 Germany</a>.<br><br>
 * If you are using the package or parts of it in any commercial way, a commercial license is required. 
 * Visit <a href='http://www.ifctoolsproject.com'>http://www.ifctoolsproject.com</a> for more information
 * or contact us directly: <a href='mailto:info@ifctoolsproject.com'>info@ifctoolsproject.com</a><br>
 */
public class IfcSurfaceStyleRendering extends IfcSurfaceStyleShading implements ClassInterface
{
	private static final String[] nonInverseAttributes = new String[]{"IfcColourRgb","IfcNormalisedRatioMeasure","IfcColourOrFactor","IfcColourOrFactor","IfcColourOrFactor","IfcColourOrFactor","IfcColourOrFactor","IfcSpecularHighlightSelect","IfcReflectanceMethodEnum"};
	private java.util.ArrayList<CloneableObject> stepParameter = null;
	private java.util.HashSet<ObjectChangeListener> listenerList = null;
	protected int stepLineNumber;
	/** Transparency is an OPTIONAL attribute**/
	protected IfcNormalisedRatioMeasure Transparency;
	/** DiffuseColour is an OPTIONAL attribute**/
	protected IfcColourOrFactor DiffuseColour;
	/** TransmissionColour is an OPTIONAL attribute**/
	protected IfcColourOrFactor TransmissionColour;
	/** DiffuseTransmissionColour is an OPTIONAL attribute**/
	protected IfcColourOrFactor DiffuseTransmissionColour;
	/** ReflectionColour is an OPTIONAL attribute**/
	protected IfcColourOrFactor ReflectionColour;
	/** SpecularColour is an OPTIONAL attribute**/
	protected IfcColourOrFactor SpecularColour;
	/** SpecularHighlight is an OPTIONAL attribute**/
	protected IfcSpecularHighlightSelect SpecularHighlight;
	/** ReflectanceMethod is an DEMANDED attribute - may not be null**/
	protected IfcReflectanceMethodEnum ReflectanceMethod;
	/**
	* The default constructor.
	**/
	public IfcSurfaceStyleRendering(){}

	private static final String[] attributes = new String[]{"SurfaceColour","Transparency","DiffuseColour","TransmissionColour",
			"DiffuseTransmissionColour","ReflectionColour","SpecularColour","SpecularHighlight","ReflectanceMethod"};

	public String[] getAttributes(){
		return IfcSurfaceStyleRendering.attributes;
	}

	/**
	* Constructs a new IfcSurfaceStyleRendering object using the given parameters.
	*
	* @param SurfaceColour DEMANDED parameter of type IfcColourRgb - may not be null.
	* @param Transparency OPTIONAL parameter of type IfcNormalisedRatioMeasure
	* @param DiffuseColour OPTIONAL parameter of type IfcColourOrFactor
	* @param TransmissionColour OPTIONAL parameter of type IfcColourOrFactor
	* @param DiffuseTransmissionColour OPTIONAL parameter of type IfcColourOrFactor
	* @param ReflectionColour OPTIONAL parameter of type IfcColourOrFactor
	* @param SpecularColour OPTIONAL parameter of type IfcColourOrFactor
	* @param SpecularHighlight OPTIONAL parameter of type IfcSpecularHighlightSelect
	* @param ReflectanceMethod DEMANDED parameter of type IfcReflectanceMethodEnum - may not be null.
	**/
	public IfcSurfaceStyleRendering(IfcColourRgb SurfaceColour, IfcNormalisedRatioMeasure Transparency, IfcColourOrFactor DiffuseColour, IfcColourOrFactor TransmissionColour, IfcColourOrFactor DiffuseTransmissionColour, IfcColourOrFactor ReflectionColour, IfcColourOrFactor SpecularColour, IfcSpecularHighlightSelect SpecularHighlight, IfcReflectanceMethodEnum ReflectanceMethod)
	{
		this.SurfaceColour = SurfaceColour;
		this.Transparency = Transparency;
		this.DiffuseColour = DiffuseColour;
		this.TransmissionColour = TransmissionColour;
		this.DiffuseTransmissionColour = DiffuseTransmissionColour;
		this.ReflectionColour = ReflectionColour;
		this.SpecularColour = SpecularColour;
		this.SpecularHighlight = SpecularHighlight;
		this.ReflectanceMethod = ReflectanceMethod;
		resolveInverses();
	}

	/**
	 * This method initializes the IfcSurfaceStyleRendering object using the given parameters.
	*
	* @param SurfaceColour DEMANDED parameter of type IfcColourRgb - may not be null.
	* @param Transparency OPTIONAL parameter of type IfcNormalisedRatioMeasure
	* @param DiffuseColour OPTIONAL parameter of type IfcColourOrFactor
	* @param TransmissionColour OPTIONAL parameter of type IfcColourOrFactor
	* @param DiffuseTransmissionColour OPTIONAL parameter of type IfcColourOrFactor
	* @param ReflectionColour OPTIONAL parameter of type IfcColourOrFactor
	* @param SpecularColour OPTIONAL parameter of type IfcColourOrFactor
	* @param SpecularHighlight OPTIONAL parameter of type IfcSpecularHighlightSelect
	* @param ReflectanceMethod DEMANDED parameter of type IfcReflectanceMethodEnum - may not be null.
	**/
	public void setParameters(IfcColourRgb SurfaceColour, IfcNormalisedRatioMeasure Transparency, IfcColourOrFactor DiffuseColour, IfcColourOrFactor TransmissionColour, IfcColourOrFactor DiffuseTransmissionColour, IfcColourOrFactor ReflectionColour, IfcColourOrFactor SpecularColour, IfcSpecularHighlightSelect SpecularHighlight, IfcReflectanceMethodEnum ReflectanceMethod)
	{
		this.SurfaceColour = SurfaceColour;
		this.Transparency = Transparency;
		this.DiffuseColour = DiffuseColour;
		this.TransmissionColour = TransmissionColour;
		this.DiffuseTransmissionColour = DiffuseTransmissionColour;
		this.ReflectionColour = ReflectionColour;
		this.SpecularColour = SpecularColour;
		this.SpecularHighlight = SpecularHighlight;
		this.ReflectanceMethod = ReflectanceMethod;
		resolveInverses();
	}

	/**
	 * This method is used internally and should NOT be used for own purposes.
	**/
	void initialize(java.util.ArrayList<CloneableObject> parameters)
	{
		this.SurfaceColour = (IfcColourRgb) parameters.get(0);
		this.Transparency = (IfcNormalisedRatioMeasure) parameters.get(1);
		this.DiffuseColour = (IfcColourOrFactor) parameters.get(2);
		this.TransmissionColour = (IfcColourOrFactor) parameters.get(3);
		this.DiffuseTransmissionColour = (IfcColourOrFactor) parameters.get(4);
		this.ReflectionColour = (IfcColourOrFactor) parameters.get(5);
		this.SpecularColour = (IfcColourOrFactor) parameters.get(6);
		this.SpecularHighlight = (IfcSpecularHighlightSelect) parameters.get(7);
		this.ReflectanceMethod = (IfcReflectanceMethodEnum) parameters.get(8);
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
		return IfcSurfaceStyleRendering.nonInverseAttributes;	}

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
		stepString = stepString.concat("IFCSURFACESTYLERENDERING(");
		if(getRedefinedDerivedAttributeTypes().contains("SurfaceColour")) stepString = stepString.concat("*,");
		else{
		if(this.SurfaceColour != null)		stepString = stepString.concat(((RootInterface)this.SurfaceColour).getStepParameter(IfcColourRgb.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("Transparency")) stepString = stepString.concat("*,");
		else{
		if(this.Transparency != null)		stepString = stepString.concat(((RootInterface)this.Transparency).getStepParameter(IfcNormalisedRatioMeasure.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("DiffuseColour")) stepString = stepString.concat("*,");
		else{
		if(this.DiffuseColour != null)		stepString = stepString.concat(((RootInterface)this.DiffuseColour).getStepParameter(IfcColourOrFactor.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("TransmissionColour")) stepString = stepString.concat("*,");
		else{
		if(this.TransmissionColour != null)		stepString = stepString.concat(((RootInterface)this.TransmissionColour).getStepParameter(IfcColourOrFactor.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("DiffuseTransmissionColour")) stepString = stepString.concat("*,");
		else{
		if(this.DiffuseTransmissionColour != null)		stepString = stepString.concat(((RootInterface)this.DiffuseTransmissionColour).getStepParameter(IfcColourOrFactor.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("ReflectionColour")) stepString = stepString.concat("*,");
		else{
		if(this.ReflectionColour != null)		stepString = stepString.concat(((RootInterface)this.ReflectionColour).getStepParameter(IfcColourOrFactor.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("SpecularColour")) stepString = stepString.concat("*,");
		else{
		if(this.SpecularColour != null)		stepString = stepString.concat(((RootInterface)this.SpecularColour).getStepParameter(IfcColourOrFactor.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("SpecularHighlight")) stepString = stepString.concat("*,");
		else{
		if(this.SpecularHighlight != null)		stepString = stepString.concat(((RootInterface)this.SpecularHighlight).getStepParameter(IfcSpecularHighlightSelect.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("ReflectanceMethod")) stepString = stepString.concat("*);");
		else{
		if(this.ReflectanceMethod != null)		stepString = stepString.concat(((RootInterface)this.ReflectanceMethod).getStepParameter(IfcReflectanceMethodEnum.class.isInterface())+");");
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
	* This method sets the Transparency attribute to the given value.
	*
	* @param Transparency DEMANDED value to set - may not be null
	**/
	public void setTransparency(IfcNormalisedRatioMeasure Transparency)
	{
		this.Transparency = Transparency;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the Transparency attribute.
	*
	* @return the value of Transparency
	/**/
	public IfcNormalisedRatioMeasure getTransparency()
	{
		return this.Transparency;
	}

	/**
	* This method sets the DiffuseColour attribute to the given value.
	*
	* @param DiffuseColour DEMANDED value to set - may not be null
	**/
	public void setDiffuseColour(IfcColourOrFactor DiffuseColour)
	{
		this.DiffuseColour = DiffuseColour;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the DiffuseColour attribute.
	*
	* @return the value of DiffuseColour
	/**/
	public IfcColourOrFactor getDiffuseColour()
	{
		return this.DiffuseColour;
	}

	/**
	* This method sets the TransmissionColour attribute to the given value.
	*
	* @param TransmissionColour DEMANDED value to set - may not be null
	**/
	public void setTransmissionColour(IfcColourOrFactor TransmissionColour)
	{
		this.TransmissionColour = TransmissionColour;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the TransmissionColour attribute.
	*
	* @return the value of TransmissionColour
	/**/
	public IfcColourOrFactor getTransmissionColour()
	{
		return this.TransmissionColour;
	}

	/**
	* This method sets the DiffuseTransmissionColour attribute to the given value.
	*
	* @param DiffuseTransmissionColour DEMANDED value to set - may not be null
	**/
	public void setDiffuseTransmissionColour(IfcColourOrFactor DiffuseTransmissionColour)
	{
		this.DiffuseTransmissionColour = DiffuseTransmissionColour;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the DiffuseTransmissionColour attribute.
	*
	* @return the value of DiffuseTransmissionColour
	/**/
	public IfcColourOrFactor getDiffuseTransmissionColour()
	{
		return this.DiffuseTransmissionColour;
	}

	/**
	* This method sets the ReflectionColour attribute to the given value.
	*
	* @param ReflectionColour DEMANDED value to set - may not be null
	**/
	public void setReflectionColour(IfcColourOrFactor ReflectionColour)
	{
		this.ReflectionColour = ReflectionColour;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the ReflectionColour attribute.
	*
	* @return the value of ReflectionColour
	/**/
	public IfcColourOrFactor getReflectionColour()
	{
		return this.ReflectionColour;
	}

	/**
	* This method sets the SpecularColour attribute to the given value.
	*
	* @param SpecularColour DEMANDED value to set - may not be null
	**/
	public void setSpecularColour(IfcColourOrFactor SpecularColour)
	{
		this.SpecularColour = SpecularColour;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the SpecularColour attribute.
	*
	* @return the value of SpecularColour
	/**/
	public IfcColourOrFactor getSpecularColour()
	{
		return this.SpecularColour;
	}

	/**
	* This method sets the SpecularHighlight attribute to the given value.
	*
	* @param SpecularHighlight DEMANDED value to set - may not be null
	**/
	public void setSpecularHighlight(IfcSpecularHighlightSelect SpecularHighlight)
	{
		this.SpecularHighlight = SpecularHighlight;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the SpecularHighlight attribute.
	*
	* @return the value of SpecularHighlight
	/**/
	public IfcSpecularHighlightSelect getSpecularHighlight()
	{
		return this.SpecularHighlight;
	}

	/**
	* This method sets the ReflectanceMethod attribute to the given value.
	*
	* @param ReflectanceMethod OPTIONAL value to set
	**/
	public void setReflectanceMethod(IfcReflectanceMethodEnum ReflectanceMethod)
	{
		this.ReflectanceMethod = ReflectanceMethod;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the ReflectanceMethod attribute.
	*
	* @return the value of ReflectanceMethod
	/**/
	public IfcReflectanceMethodEnum getReflectanceMethod()
	{
		return this.ReflectanceMethod;
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
		IfcSurfaceStyleRendering ifcSurfaceStyleRendering = new IfcSurfaceStyleRendering();
		if(this.SurfaceColour != null)
			ifcSurfaceStyleRendering.setSurfaceColour((IfcColourRgb)this.SurfaceColour.clone());
		if(this.Transparency != null)
			ifcSurfaceStyleRendering.setTransparency((IfcNormalisedRatioMeasure)this.Transparency.clone());
		if(this.DiffuseColour != null)
			ifcSurfaceStyleRendering.setDiffuseColour((IfcColourOrFactor)this.DiffuseColour.clone());
		if(this.TransmissionColour != null)
			ifcSurfaceStyleRendering.setTransmissionColour((IfcColourOrFactor)this.TransmissionColour.clone());
		if(this.DiffuseTransmissionColour != null)
			ifcSurfaceStyleRendering.setDiffuseTransmissionColour((IfcColourOrFactor)this.DiffuseTransmissionColour.clone());
		if(this.ReflectionColour != null)
			ifcSurfaceStyleRendering.setReflectionColour((IfcColourOrFactor)this.ReflectionColour.clone());
		if(this.SpecularColour != null)
			ifcSurfaceStyleRendering.setSpecularColour((IfcColourOrFactor)this.SpecularColour.clone());
		if(this.SpecularHighlight != null)
			ifcSurfaceStyleRendering.setSpecularHighlight((IfcSpecularHighlightSelect)this.SpecularHighlight.clone());
		if(this.ReflectanceMethod != null)
			ifcSurfaceStyleRendering.setReflectanceMethod((IfcReflectanceMethodEnum)this.ReflectanceMethod.clone());
		return ifcSurfaceStyleRendering;
	}

	/**
	 * This method copys the object as shallow copy (all referenced objects are remaining).
	 *
	 * @return the cloned object
	**/
	public Object shallowCopy()
	{
		IfcSurfaceStyleRendering ifcSurfaceStyleRendering = new IfcSurfaceStyleRendering();
		if(this.SurfaceColour != null)
			ifcSurfaceStyleRendering.setSurfaceColour(this.SurfaceColour);
		if(this.Transparency != null)
			ifcSurfaceStyleRendering.setTransparency(this.Transparency);
		if(this.DiffuseColour != null)
			ifcSurfaceStyleRendering.setDiffuseColour(this.DiffuseColour);
		if(this.TransmissionColour != null)
			ifcSurfaceStyleRendering.setTransmissionColour(this.TransmissionColour);
		if(this.DiffuseTransmissionColour != null)
			ifcSurfaceStyleRendering.setDiffuseTransmissionColour(this.DiffuseTransmissionColour);
		if(this.ReflectionColour != null)
			ifcSurfaceStyleRendering.setReflectionColour(this.ReflectionColour);
		if(this.SpecularColour != null)
			ifcSurfaceStyleRendering.setSpecularColour(this.SpecularColour);
		if(this.SpecularHighlight != null)
			ifcSurfaceStyleRendering.setSpecularHighlight(this.SpecularHighlight);
		if(this.ReflectanceMethod != null)
			ifcSurfaceStyleRendering.setReflectanceMethod(this.ReflectanceMethod);
		return ifcSurfaceStyleRendering;
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
