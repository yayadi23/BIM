/* Generated By: IFC Tools Project EXPRESS TO JAVA COMPILER: Do not edit this file!! */
package ifc2x3javatoolbox.ifc2x3tc1;
/**
 * This is a default implementation of the entity IfcWindowLiningProperties<br><br>
 *<br><br>
 * Copyright: CC BY-NC-SA 3.0 DE (cc) 2013 Eike Tauscher and Michael Theiler<br><br>
 * The whole package including this class is licensed under<br>
 * <a rel='license' href='http://creativecommons.org/licenses/by-nc-sa/3.0/de/deed.en/'>
 * Creative Commons Attribution-Non-Commercial-Share Alike 3.0 Germany</a>.<br><br>
 * If you are using the package or parts of it in any commercial way, a commercial license is required. 
 * Visit <a href='http://www.ifctoolsproject.com'>http://www.ifctoolsproject.com</a> for more information
 * or contact us directly: <a href='mailto:info@ifctoolsproject.com'>info@ifctoolsproject.com</a><br>
 */
public class IfcWindowLiningProperties extends IfcPropertySetDefinition implements ClassInterface
{
	private static final String[] nonInverseAttributes = new String[]{"IfcGloballyUniqueId","IfcOwnerHistory","IfcLabel","IfcText","IfcPositiveLengthMeasure","IfcPositiveLengthMeasure","IfcPositiveLengthMeasure","IfcPositiveLengthMeasure","IfcNormalisedRatioMeasure","IfcNormalisedRatioMeasure","IfcNormalisedRatioMeasure","IfcNormalisedRatioMeasure","IfcShapeAspect"};
	private java.util.ArrayList<CloneableObject> stepParameter = null;
	private java.util.HashSet<ObjectChangeListener> listenerList = null;
	protected int stepLineNumber;
	/** LiningDepth is an OPTIONAL attribute**/
	protected IfcPositiveLengthMeasure LiningDepth;
	/** LiningThickness is an OPTIONAL attribute**/
	protected IfcPositiveLengthMeasure LiningThickness;
	/** TransomThickness is an OPTIONAL attribute**/
	protected IfcPositiveLengthMeasure TransomThickness;
	/** MullionThickness is an OPTIONAL attribute**/
	protected IfcPositiveLengthMeasure MullionThickness;
	/** FirstTransomOffset is an OPTIONAL attribute**/
	protected IfcNormalisedRatioMeasure FirstTransomOffset;
	/** SecondTransomOffset is an OPTIONAL attribute**/
	protected IfcNormalisedRatioMeasure SecondTransomOffset;
	/** FirstMullionOffset is an OPTIONAL attribute**/
	protected IfcNormalisedRatioMeasure FirstMullionOffset;
	/** SecondMullionOffset is an OPTIONAL attribute**/
	protected IfcNormalisedRatioMeasure SecondMullionOffset;
	/** ShapeAspectStyle is an OPTIONAL attribute**/
	protected IfcShapeAspect ShapeAspectStyle;
	/**
	* The default constructor.
	**/
	public IfcWindowLiningProperties(){}

	private static final String[] attributes = new String[]{"GlobalId","OwnerHistory","Name","Description",
			"LiningDepth","LiningThickness","TransomThickness","MullionThickness","FirstTransomOffset","SecondTransomOffset","FirstMullionOffset","SecondMullionOffset","ShapeAspectStyle"};

	public String[] getAttributes(){
		return IfcWindowLiningProperties.attributes;
	}

	/**
	* Constructs a new IfcWindowLiningProperties object using the given parameters.
	*
	* @param GlobalId DEMANDED parameter of type IfcGloballyUniqueId - may not be null.
	* @param OwnerHistory DEMANDED parameter of type IfcOwnerHistory - may not be null.
	* @param Name OPTIONAL parameter of type IfcLabel
	* @param Description OPTIONAL parameter of type IfcText
	* @param LiningDepth OPTIONAL parameter of type IfcPositiveLengthMeasure
	* @param LiningThickness OPTIONAL parameter of type IfcPositiveLengthMeasure
	* @param TransomThickness OPTIONAL parameter of type IfcPositiveLengthMeasure
	* @param MullionThickness OPTIONAL parameter of type IfcPositiveLengthMeasure
	* @param FirstTransomOffset OPTIONAL parameter of type IfcNormalisedRatioMeasure
	* @param SecondTransomOffset OPTIONAL parameter of type IfcNormalisedRatioMeasure
	* @param FirstMullionOffset OPTIONAL parameter of type IfcNormalisedRatioMeasure
	* @param SecondMullionOffset OPTIONAL parameter of type IfcNormalisedRatioMeasure
	* @param ShapeAspectStyle OPTIONAL parameter of type IfcShapeAspect
	**/
	public IfcWindowLiningProperties(IfcGloballyUniqueId GlobalId, IfcOwnerHistory OwnerHistory, IfcLabel Name, IfcText Description, IfcPositiveLengthMeasure LiningDepth, IfcPositiveLengthMeasure LiningThickness, IfcPositiveLengthMeasure TransomThickness, IfcPositiveLengthMeasure MullionThickness, IfcNormalisedRatioMeasure FirstTransomOffset, IfcNormalisedRatioMeasure SecondTransomOffset, IfcNormalisedRatioMeasure FirstMullionOffset, IfcNormalisedRatioMeasure SecondMullionOffset, IfcShapeAspect ShapeAspectStyle)
	{
		this.GlobalId = GlobalId;
		this.OwnerHistory = OwnerHistory;
		this.Name = Name;
		this.Description = Description;
		this.LiningDepth = LiningDepth;
		this.LiningThickness = LiningThickness;
		this.TransomThickness = TransomThickness;
		this.MullionThickness = MullionThickness;
		this.FirstTransomOffset = FirstTransomOffset;
		this.SecondTransomOffset = SecondTransomOffset;
		this.FirstMullionOffset = FirstMullionOffset;
		this.SecondMullionOffset = SecondMullionOffset;
		this.ShapeAspectStyle = ShapeAspectStyle;
		resolveInverses();
	}

	/**
	 * This method initializes the IfcWindowLiningProperties object using the given parameters.
	*
	* @param GlobalId DEMANDED parameter of type IfcGloballyUniqueId - may not be null.
	* @param OwnerHistory DEMANDED parameter of type IfcOwnerHistory - may not be null.
	* @param Name OPTIONAL parameter of type IfcLabel
	* @param Description OPTIONAL parameter of type IfcText
	* @param LiningDepth OPTIONAL parameter of type IfcPositiveLengthMeasure
	* @param LiningThickness OPTIONAL parameter of type IfcPositiveLengthMeasure
	* @param TransomThickness OPTIONAL parameter of type IfcPositiveLengthMeasure
	* @param MullionThickness OPTIONAL parameter of type IfcPositiveLengthMeasure
	* @param FirstTransomOffset OPTIONAL parameter of type IfcNormalisedRatioMeasure
	* @param SecondTransomOffset OPTIONAL parameter of type IfcNormalisedRatioMeasure
	* @param FirstMullionOffset OPTIONAL parameter of type IfcNormalisedRatioMeasure
	* @param SecondMullionOffset OPTIONAL parameter of type IfcNormalisedRatioMeasure
	* @param ShapeAspectStyle OPTIONAL parameter of type IfcShapeAspect
	**/
	public void setParameters(IfcGloballyUniqueId GlobalId, IfcOwnerHistory OwnerHistory, IfcLabel Name, IfcText Description, IfcPositiveLengthMeasure LiningDepth, IfcPositiveLengthMeasure LiningThickness, IfcPositiveLengthMeasure TransomThickness, IfcPositiveLengthMeasure MullionThickness, IfcNormalisedRatioMeasure FirstTransomOffset, IfcNormalisedRatioMeasure SecondTransomOffset, IfcNormalisedRatioMeasure FirstMullionOffset, IfcNormalisedRatioMeasure SecondMullionOffset, IfcShapeAspect ShapeAspectStyle)
	{
		this.GlobalId = GlobalId;
		this.OwnerHistory = OwnerHistory;
		this.Name = Name;
		this.Description = Description;
		this.LiningDepth = LiningDepth;
		this.LiningThickness = LiningThickness;
		this.TransomThickness = TransomThickness;
		this.MullionThickness = MullionThickness;
		this.FirstTransomOffset = FirstTransomOffset;
		this.SecondTransomOffset = SecondTransomOffset;
		this.FirstMullionOffset = FirstMullionOffset;
		this.SecondMullionOffset = SecondMullionOffset;
		this.ShapeAspectStyle = ShapeAspectStyle;
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
		this.LiningDepth = (IfcPositiveLengthMeasure) parameters.get(4);
		this.LiningThickness = (IfcPositiveLengthMeasure) parameters.get(5);
		this.TransomThickness = (IfcPositiveLengthMeasure) parameters.get(6);
		this.MullionThickness = (IfcPositiveLengthMeasure) parameters.get(7);
		this.FirstTransomOffset = (IfcNormalisedRatioMeasure) parameters.get(8);
		this.SecondTransomOffset = (IfcNormalisedRatioMeasure) parameters.get(9);
		this.FirstMullionOffset = (IfcNormalisedRatioMeasure) parameters.get(10);
		this.SecondMullionOffset = (IfcNormalisedRatioMeasure) parameters.get(11);
		this.ShapeAspectStyle = (IfcShapeAspect) parameters.get(12);
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
		return IfcWindowLiningProperties.nonInverseAttributes;	}

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
		stepString = stepString.concat("IFCWINDOWLININGPROPERTIES(");
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
		if(getRedefinedDerivedAttributeTypes().contains("LiningDepth")) stepString = stepString.concat("*,");
		else{
		if(this.LiningDepth != null)		stepString = stepString.concat(((RootInterface)this.LiningDepth).getStepParameter(IfcPositiveLengthMeasure.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("LiningThickness")) stepString = stepString.concat("*,");
		else{
		if(this.LiningThickness != null)		stepString = stepString.concat(((RootInterface)this.LiningThickness).getStepParameter(IfcPositiveLengthMeasure.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("TransomThickness")) stepString = stepString.concat("*,");
		else{
		if(this.TransomThickness != null)		stepString = stepString.concat(((RootInterface)this.TransomThickness).getStepParameter(IfcPositiveLengthMeasure.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("MullionThickness")) stepString = stepString.concat("*,");
		else{
		if(this.MullionThickness != null)		stepString = stepString.concat(((RootInterface)this.MullionThickness).getStepParameter(IfcPositiveLengthMeasure.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("FirstTransomOffset")) stepString = stepString.concat("*,");
		else{
		if(this.FirstTransomOffset != null)		stepString = stepString.concat(((RootInterface)this.FirstTransomOffset).getStepParameter(IfcNormalisedRatioMeasure.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("SecondTransomOffset")) stepString = stepString.concat("*,");
		else{
		if(this.SecondTransomOffset != null)		stepString = stepString.concat(((RootInterface)this.SecondTransomOffset).getStepParameter(IfcNormalisedRatioMeasure.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("FirstMullionOffset")) stepString = stepString.concat("*,");
		else{
		if(this.FirstMullionOffset != null)		stepString = stepString.concat(((RootInterface)this.FirstMullionOffset).getStepParameter(IfcNormalisedRatioMeasure.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("SecondMullionOffset")) stepString = stepString.concat("*,");
		else{
		if(this.SecondMullionOffset != null)		stepString = stepString.concat(((RootInterface)this.SecondMullionOffset).getStepParameter(IfcNormalisedRatioMeasure.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("ShapeAspectStyle")) stepString = stepString.concat("*);");
		else{
		if(this.ShapeAspectStyle != null)		stepString = stepString.concat(((RootInterface)this.ShapeAspectStyle).getStepParameter(IfcShapeAspect.class.isInterface())+");");
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
	* This method sets the LiningDepth attribute to the given value.
	*
	* @param LiningDepth DEMANDED value to set - may not be null
	**/
	public void setLiningDepth(IfcPositiveLengthMeasure LiningDepth)
	{
		this.LiningDepth = LiningDepth;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the LiningDepth attribute.
	*
	* @return the value of LiningDepth
	/**/
	public IfcPositiveLengthMeasure getLiningDepth()
	{
		return this.LiningDepth;
	}

	/**
	* This method sets the LiningThickness attribute to the given value.
	*
	* @param LiningThickness DEMANDED value to set - may not be null
	**/
	public void setLiningThickness(IfcPositiveLengthMeasure LiningThickness)
	{
		this.LiningThickness = LiningThickness;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the LiningThickness attribute.
	*
	* @return the value of LiningThickness
	/**/
	public IfcPositiveLengthMeasure getLiningThickness()
	{
		return this.LiningThickness;
	}

	/**
	* This method sets the TransomThickness attribute to the given value.
	*
	* @param TransomThickness DEMANDED value to set - may not be null
	**/
	public void setTransomThickness(IfcPositiveLengthMeasure TransomThickness)
	{
		this.TransomThickness = TransomThickness;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the TransomThickness attribute.
	*
	* @return the value of TransomThickness
	/**/
	public IfcPositiveLengthMeasure getTransomThickness()
	{
		return this.TransomThickness;
	}

	/**
	* This method sets the MullionThickness attribute to the given value.
	*
	* @param MullionThickness DEMANDED value to set - may not be null
	**/
	public void setMullionThickness(IfcPositiveLengthMeasure MullionThickness)
	{
		this.MullionThickness = MullionThickness;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the MullionThickness attribute.
	*
	* @return the value of MullionThickness
	/**/
	public IfcPositiveLengthMeasure getMullionThickness()
	{
		return this.MullionThickness;
	}

	/**
	* This method sets the FirstTransomOffset attribute to the given value.
	*
	* @param FirstTransomOffset DEMANDED value to set - may not be null
	**/
	public void setFirstTransomOffset(IfcNormalisedRatioMeasure FirstTransomOffset)
	{
		this.FirstTransomOffset = FirstTransomOffset;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the FirstTransomOffset attribute.
	*
	* @return the value of FirstTransomOffset
	/**/
	public IfcNormalisedRatioMeasure getFirstTransomOffset()
	{
		return this.FirstTransomOffset;
	}

	/**
	* This method sets the SecondTransomOffset attribute to the given value.
	*
	* @param SecondTransomOffset DEMANDED value to set - may not be null
	**/
	public void setSecondTransomOffset(IfcNormalisedRatioMeasure SecondTransomOffset)
	{
		this.SecondTransomOffset = SecondTransomOffset;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the SecondTransomOffset attribute.
	*
	* @return the value of SecondTransomOffset
	/**/
	public IfcNormalisedRatioMeasure getSecondTransomOffset()
	{
		return this.SecondTransomOffset;
	}

	/**
	* This method sets the FirstMullionOffset attribute to the given value.
	*
	* @param FirstMullionOffset DEMANDED value to set - may not be null
	**/
	public void setFirstMullionOffset(IfcNormalisedRatioMeasure FirstMullionOffset)
	{
		this.FirstMullionOffset = FirstMullionOffset;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the FirstMullionOffset attribute.
	*
	* @return the value of FirstMullionOffset
	/**/
	public IfcNormalisedRatioMeasure getFirstMullionOffset()
	{
		return this.FirstMullionOffset;
	}

	/**
	* This method sets the SecondMullionOffset attribute to the given value.
	*
	* @param SecondMullionOffset DEMANDED value to set - may not be null
	**/
	public void setSecondMullionOffset(IfcNormalisedRatioMeasure SecondMullionOffset)
	{
		this.SecondMullionOffset = SecondMullionOffset;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the SecondMullionOffset attribute.
	*
	* @return the value of SecondMullionOffset
	/**/
	public IfcNormalisedRatioMeasure getSecondMullionOffset()
	{
		return this.SecondMullionOffset;
	}

	/**
	* This method sets the ShapeAspectStyle attribute to the given value.
	*
	* @param ShapeAspectStyle DEMANDED value to set - may not be null
	**/
	public void setShapeAspectStyle(IfcShapeAspect ShapeAspectStyle)
	{
		this.ShapeAspectStyle = ShapeAspectStyle;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the ShapeAspectStyle attribute.
	*
	* @return the value of ShapeAspectStyle
	/**/
	public IfcShapeAspect getShapeAspectStyle()
	{
		return this.ShapeAspectStyle;
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
		IfcWindowLiningProperties ifcWindowLiningProperties = new IfcWindowLiningProperties();
		if(this.GlobalId != null)
			ifcWindowLiningProperties.setGlobalId((IfcGloballyUniqueId)this.GlobalId.clone());
		if(this.OwnerHistory != null)
			ifcWindowLiningProperties.setOwnerHistory((IfcOwnerHistory)this.OwnerHistory.clone());
		if(this.Name != null)
			ifcWindowLiningProperties.setName((IfcLabel)this.Name.clone());
		if(this.Description != null)
			ifcWindowLiningProperties.setDescription((IfcText)this.Description.clone());
		if(this.LiningDepth != null)
			ifcWindowLiningProperties.setLiningDepth((IfcPositiveLengthMeasure)this.LiningDepth.clone());
		if(this.LiningThickness != null)
			ifcWindowLiningProperties.setLiningThickness((IfcPositiveLengthMeasure)this.LiningThickness.clone());
		if(this.TransomThickness != null)
			ifcWindowLiningProperties.setTransomThickness((IfcPositiveLengthMeasure)this.TransomThickness.clone());
		if(this.MullionThickness != null)
			ifcWindowLiningProperties.setMullionThickness((IfcPositiveLengthMeasure)this.MullionThickness.clone());
		if(this.FirstTransomOffset != null)
			ifcWindowLiningProperties.setFirstTransomOffset((IfcNormalisedRatioMeasure)this.FirstTransomOffset.clone());
		if(this.SecondTransomOffset != null)
			ifcWindowLiningProperties.setSecondTransomOffset((IfcNormalisedRatioMeasure)this.SecondTransomOffset.clone());
		if(this.FirstMullionOffset != null)
			ifcWindowLiningProperties.setFirstMullionOffset((IfcNormalisedRatioMeasure)this.FirstMullionOffset.clone());
		if(this.SecondMullionOffset != null)
			ifcWindowLiningProperties.setSecondMullionOffset((IfcNormalisedRatioMeasure)this.SecondMullionOffset.clone());
		if(this.ShapeAspectStyle != null)
			ifcWindowLiningProperties.setShapeAspectStyle((IfcShapeAspect)this.ShapeAspectStyle.clone());
		return ifcWindowLiningProperties;
	}

	/**
	 * This method copys the object as shallow copy (all referenced objects are remaining).
	 *
	 * @return the cloned object
	**/
	public Object shallowCopy()
	{
		IfcWindowLiningProperties ifcWindowLiningProperties = new IfcWindowLiningProperties();
		if(this.GlobalId != null)
			ifcWindowLiningProperties.setGlobalId(this.GlobalId);
		if(this.OwnerHistory != null)
			ifcWindowLiningProperties.setOwnerHistory(this.OwnerHistory);
		if(this.Name != null)
			ifcWindowLiningProperties.setName(this.Name);
		if(this.Description != null)
			ifcWindowLiningProperties.setDescription(this.Description);
		if(this.LiningDepth != null)
			ifcWindowLiningProperties.setLiningDepth(this.LiningDepth);
		if(this.LiningThickness != null)
			ifcWindowLiningProperties.setLiningThickness(this.LiningThickness);
		if(this.TransomThickness != null)
			ifcWindowLiningProperties.setTransomThickness(this.TransomThickness);
		if(this.MullionThickness != null)
			ifcWindowLiningProperties.setMullionThickness(this.MullionThickness);
		if(this.FirstTransomOffset != null)
			ifcWindowLiningProperties.setFirstTransomOffset(this.FirstTransomOffset);
		if(this.SecondTransomOffset != null)
			ifcWindowLiningProperties.setSecondTransomOffset(this.SecondTransomOffset);
		if(this.FirstMullionOffset != null)
			ifcWindowLiningProperties.setFirstMullionOffset(this.FirstMullionOffset);
		if(this.SecondMullionOffset != null)
			ifcWindowLiningProperties.setSecondMullionOffset(this.SecondMullionOffset);
		if(this.ShapeAspectStyle != null)
			ifcWindowLiningProperties.setShapeAspectStyle(this.ShapeAspectStyle);
		return ifcWindowLiningProperties;
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
