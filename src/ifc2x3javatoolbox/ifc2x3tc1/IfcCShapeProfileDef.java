/* Generated By: IFC Tools Project EXPRESS TO JAVA COMPILER: Do not edit this file!! */
package ifc2x3javatoolbox.ifc2x3tc1;
/**
 * This is a default implementation of the entity IfcCShapeProfileDef<br><br>
 *<br><br>
 * Copyright: CC BY-NC-SA 3.0 DE (cc) 2013 Eike Tauscher and Michael Theiler<br><br>
 * The whole package including this class is licensed under<br>
 * <a rel='license' href='http://creativecommons.org/licenses/by-nc-sa/3.0/de/deed.en/'>
 * Creative Commons Attribution-Non-Commercial-Share Alike 3.0 Germany</a>.<br><br>
 * If you are using the package or parts of it in any commercial way, a commercial license is required. 
 * Visit <a href='http://www.ifctoolsproject.com'>http://www.ifctoolsproject.com</a> for more information
 * or contact us directly: <a href='mailto:info@ifctoolsproject.com'>info@ifctoolsproject.com</a><br>
 */
public class IfcCShapeProfileDef extends IfcParameterizedProfileDef implements ClassInterface
{
	private static final String[] nonInverseAttributes = new String[]{"IfcProfileTypeEnum","IfcLabel","IfcAxis2Placement2D","IfcPositiveLengthMeasure","IfcPositiveLengthMeasure","IfcPositiveLengthMeasure","IfcPositiveLengthMeasure","IfcPositiveLengthMeasure","IfcPositiveLengthMeasure"};
	private java.util.ArrayList<CloneableObject> stepParameter = null;
	private java.util.HashSet<ObjectChangeListener> listenerList = null;
	protected int stepLineNumber;
	/** Depth is an DEMANDED attribute - may not be null**/
	protected IfcPositiveLengthMeasure Depth;
	/** Width is an DEMANDED attribute - may not be null**/
	protected IfcPositiveLengthMeasure Width;
	/** WallThickness is an DEMANDED attribute - may not be null**/
	protected IfcPositiveLengthMeasure WallThickness;
	/** Girth is an DEMANDED attribute - may not be null**/
	protected IfcPositiveLengthMeasure Girth;
	/** InternalFilletRadius is an OPTIONAL attribute**/
	protected IfcPositiveLengthMeasure InternalFilletRadius;
	/** CentreOfGravityInX is an OPTIONAL attribute**/
	protected IfcPositiveLengthMeasure CentreOfGravityInX;
	/**
	* The default constructor.
	**/
	public IfcCShapeProfileDef(){}

	private static final String[] attributes = new String[]{"ProfileType","ProfileName","Position","Depth"
			,"Width","WallThickness","Girth","InternalFilletRadius","CentreOfGravityInX"};

	public String[] getAttributes() {
		return IfcCShapeProfileDef.attributes;
	}


	/**
	* Constructs a new IfcCShapeProfileDef object using the given parameters.
	*
	* @param ProfileType DEMANDED parameter of type IfcProfileTypeEnum - may not be null.
	* @param ProfileName OPTIONAL parameter of type IfcLabel
	* @param Position DEMANDED parameter of type IfcAxis2Placement2D - may not be null.
	* @param Depth DEMANDED parameter of type IfcPositiveLengthMeasure - may not be null.
	* @param Width DEMANDED parameter of type IfcPositiveLengthMeasure - may not be null.
	* @param WallThickness DEMANDED parameter of type IfcPositiveLengthMeasure - may not be null.
	* @param Girth DEMANDED parameter of type IfcPositiveLengthMeasure - may not be null.
	* @param InternalFilletRadius OPTIONAL parameter of type IfcPositiveLengthMeasure
	* @param CentreOfGravityInX OPTIONAL parameter of type IfcPositiveLengthMeasure
	**/
	public IfcCShapeProfileDef(IfcProfileTypeEnum ProfileType, IfcLabel ProfileName, IfcAxis2Placement2D Position, IfcPositiveLengthMeasure Depth, IfcPositiveLengthMeasure Width, IfcPositiveLengthMeasure WallThickness, IfcPositiveLengthMeasure Girth, IfcPositiveLengthMeasure InternalFilletRadius, IfcPositiveLengthMeasure CentreOfGravityInX)
	{
		this.ProfileType = ProfileType;
		this.ProfileName = ProfileName;
		this.Position = Position;
		this.Depth = Depth;
		this.Width = Width;
		this.WallThickness = WallThickness;
		this.Girth = Girth;
		this.InternalFilletRadius = InternalFilletRadius;
		this.CentreOfGravityInX = CentreOfGravityInX;
		resolveInverses();
	}

	/**
	 * This method initializes the IfcCShapeProfileDef object using the given parameters.
	*
	* @param ProfileType DEMANDED parameter of type IfcProfileTypeEnum - may not be null.
	* @param ProfileName OPTIONAL parameter of type IfcLabel
	* @param Position DEMANDED parameter of type IfcAxis2Placement2D - may not be null.
	* @param Depth DEMANDED parameter of type IfcPositiveLengthMeasure - may not be null.
	* @param Width DEMANDED parameter of type IfcPositiveLengthMeasure - may not be null.
	* @param WallThickness DEMANDED parameter of type IfcPositiveLengthMeasure - may not be null.
	* @param Girth DEMANDED parameter of type IfcPositiveLengthMeasure - may not be null.
	* @param InternalFilletRadius OPTIONAL parameter of type IfcPositiveLengthMeasure
	* @param CentreOfGravityInX OPTIONAL parameter of type IfcPositiveLengthMeasure
	**/
	public void setParameters(IfcProfileTypeEnum ProfileType, IfcLabel ProfileName, IfcAxis2Placement2D Position, IfcPositiveLengthMeasure Depth, IfcPositiveLengthMeasure Width, IfcPositiveLengthMeasure WallThickness, IfcPositiveLengthMeasure Girth, IfcPositiveLengthMeasure InternalFilletRadius, IfcPositiveLengthMeasure CentreOfGravityInX)
	{
		this.ProfileType = ProfileType;
		this.ProfileName = ProfileName;
		this.Position = Position;
		this.Depth = Depth;
		this.Width = Width;
		this.WallThickness = WallThickness;
		this.Girth = Girth;
		this.InternalFilletRadius = InternalFilletRadius;
		this.CentreOfGravityInX = CentreOfGravityInX;
		resolveInverses();
	}

	/**
	 * This method is used internally and should NOT be used for own purposes.
	**/
	void initialize(java.util.ArrayList<CloneableObject> parameters)
	{
		this.ProfileType = (IfcProfileTypeEnum) parameters.get(0);
		this.ProfileName = (IfcLabel) parameters.get(1);
		this.Position = (IfcAxis2Placement2D) parameters.get(2);
		this.Depth = (IfcPositiveLengthMeasure) parameters.get(3);
		this.Width = (IfcPositiveLengthMeasure) parameters.get(4);
		this.WallThickness = (IfcPositiveLengthMeasure) parameters.get(5);
		this.Girth = (IfcPositiveLengthMeasure) parameters.get(6);
		this.InternalFilletRadius = (IfcPositiveLengthMeasure) parameters.get(7);
		this.CentreOfGravityInX = (IfcPositiveLengthMeasure) parameters.get(8);
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
		return IfcCShapeProfileDef.nonInverseAttributes;	}

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
		stepString = stepString.concat("IFCCSHAPEPROFILEDEF(");
		if(getRedefinedDerivedAttributeTypes().contains("ProfileType")) stepString = stepString.concat("*,");
		else{
		if(this.ProfileType != null)		stepString = stepString.concat(((RootInterface)this.ProfileType).getStepParameter(IfcProfileTypeEnum.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("ProfileName")) stepString = stepString.concat("*,");
		else{
		if(this.ProfileName != null)		stepString = stepString.concat(((RootInterface)this.ProfileName).getStepParameter(IfcLabel.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("Position")) stepString = stepString.concat("*,");
		else{
		if(this.Position != null)		stepString = stepString.concat(((RootInterface)this.Position).getStepParameter(IfcAxis2Placement2D.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("Depth")) stepString = stepString.concat("*,");
		else{
		if(this.Depth != null)		stepString = stepString.concat(((RootInterface)this.Depth).getStepParameter(IfcPositiveLengthMeasure.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("Width")) stepString = stepString.concat("*,");
		else{
		if(this.Width != null)		stepString = stepString.concat(((RootInterface)this.Width).getStepParameter(IfcPositiveLengthMeasure.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("WallThickness")) stepString = stepString.concat("*,");
		else{
		if(this.WallThickness != null)		stepString = stepString.concat(((RootInterface)this.WallThickness).getStepParameter(IfcPositiveLengthMeasure.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("Girth")) stepString = stepString.concat("*,");
		else{
		if(this.Girth != null)		stepString = stepString.concat(((RootInterface)this.Girth).getStepParameter(IfcPositiveLengthMeasure.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("InternalFilletRadius")) stepString = stepString.concat("*,");
		else{
		if(this.InternalFilletRadius != null)		stepString = stepString.concat(((RootInterface)this.InternalFilletRadius).getStepParameter(IfcPositiveLengthMeasure.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("CentreOfGravityInX")) stepString = stepString.concat("*);");
		else{
		if(this.CentreOfGravityInX != null)		stepString = stepString.concat(((RootInterface)this.CentreOfGravityInX).getStepParameter(IfcPositiveLengthMeasure.class.isInterface())+");");
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
	* This method sets the Depth attribute to the given value.
	*
	* @param Depth OPTIONAL value to set
	**/
	public void setDepth(IfcPositiveLengthMeasure Depth)
	{
		this.Depth = Depth;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the Depth attribute.
	*
	* @return the value of Depth
	/**/
	public IfcPositiveLengthMeasure getDepth()
	{
		return this.Depth;
	}

	/**
	* This method sets the Width attribute to the given value.
	*
	* @param Width OPTIONAL value to set
	**/
	public void setWidth(IfcPositiveLengthMeasure Width)
	{
		this.Width = Width;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the Width attribute.
	*
	* @return the value of Width
	/**/
	public IfcPositiveLengthMeasure getWidth()
	{
		return this.Width;
	}

	/**
	* This method sets the WallThickness attribute to the given value.
	*
	* @param WallThickness OPTIONAL value to set
	**/
	public void setWallThickness(IfcPositiveLengthMeasure WallThickness)
	{
		this.WallThickness = WallThickness;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the WallThickness attribute.
	*
	* @return the value of WallThickness
	/**/
	public IfcPositiveLengthMeasure getWallThickness()
	{
		return this.WallThickness;
	}

	/**
	* This method sets the Girth attribute to the given value.
	*
	* @param Girth OPTIONAL value to set
	**/
	public void setGirth(IfcPositiveLengthMeasure Girth)
	{
		this.Girth = Girth;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the Girth attribute.
	*
	* @return the value of Girth
	/**/
	public IfcPositiveLengthMeasure getGirth()
	{
		return this.Girth;
	}

	/**
	* This method sets the InternalFilletRadius attribute to the given value.
	*
	* @param InternalFilletRadius DEMANDED value to set - may not be null
	**/
	public void setInternalFilletRadius(IfcPositiveLengthMeasure InternalFilletRadius)
	{
		this.InternalFilletRadius = InternalFilletRadius;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the InternalFilletRadius attribute.
	*
	* @return the value of InternalFilletRadius
	/**/
	public IfcPositiveLengthMeasure getInternalFilletRadius()
	{
		return this.InternalFilletRadius;
	}

	/**
	* This method sets the CentreOfGravityInX attribute to the given value.
	*
	* @param CentreOfGravityInX DEMANDED value to set - may not be null
	**/
	public void setCentreOfGravityInX(IfcPositiveLengthMeasure CentreOfGravityInX)
	{
		this.CentreOfGravityInX = CentreOfGravityInX;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the CentreOfGravityInX attribute.
	*
	* @return the value of CentreOfGravityInX
	/**/
	public IfcPositiveLengthMeasure getCentreOfGravityInX()
	{
		return this.CentreOfGravityInX;
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
		IfcCShapeProfileDef ifcCShapeProfileDef = new IfcCShapeProfileDef();
		if(this.ProfileType != null)
			ifcCShapeProfileDef.setProfileType((IfcProfileTypeEnum)this.ProfileType.clone());
		if(this.ProfileName != null)
			ifcCShapeProfileDef.setProfileName((IfcLabel)this.ProfileName.clone());
		if(this.Position != null)
			ifcCShapeProfileDef.setPosition((IfcAxis2Placement2D)this.Position.clone());
		if(this.Depth != null)
			ifcCShapeProfileDef.setDepth((IfcPositiveLengthMeasure)this.Depth.clone());
		if(this.Width != null)
			ifcCShapeProfileDef.setWidth((IfcPositiveLengthMeasure)this.Width.clone());
		if(this.WallThickness != null)
			ifcCShapeProfileDef.setWallThickness((IfcPositiveLengthMeasure)this.WallThickness.clone());
		if(this.Girth != null)
			ifcCShapeProfileDef.setGirth((IfcPositiveLengthMeasure)this.Girth.clone());
		if(this.InternalFilletRadius != null)
			ifcCShapeProfileDef.setInternalFilletRadius((IfcPositiveLengthMeasure)this.InternalFilletRadius.clone());
		if(this.CentreOfGravityInX != null)
			ifcCShapeProfileDef.setCentreOfGravityInX((IfcPositiveLengthMeasure)this.CentreOfGravityInX.clone());
		return ifcCShapeProfileDef;
	}

	/**
	 * This method copys the object as shallow copy (all referenced objects are remaining).
	 *
	 * @return the cloned object
	**/
	public Object shallowCopy()
	{
		IfcCShapeProfileDef ifcCShapeProfileDef = new IfcCShapeProfileDef();
		if(this.ProfileType != null)
			ifcCShapeProfileDef.setProfileType(this.ProfileType);
		if(this.ProfileName != null)
			ifcCShapeProfileDef.setProfileName(this.ProfileName);
		if(this.Position != null)
			ifcCShapeProfileDef.setPosition(this.Position);
		if(this.Depth != null)
			ifcCShapeProfileDef.setDepth(this.Depth);
		if(this.Width != null)
			ifcCShapeProfileDef.setWidth(this.Width);
		if(this.WallThickness != null)
			ifcCShapeProfileDef.setWallThickness(this.WallThickness);
		if(this.Girth != null)
			ifcCShapeProfileDef.setGirth(this.Girth);
		if(this.InternalFilletRadius != null)
			ifcCShapeProfileDef.setInternalFilletRadius(this.InternalFilletRadius);
		if(this.CentreOfGravityInX != null)
			ifcCShapeProfileDef.setCentreOfGravityInX(this.CentreOfGravityInX);
		return ifcCShapeProfileDef;
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
