/* Generated By: IFC Tools Project EXPRESS TO JAVA COMPILER: Do not edit this file!! */
package ifc2x3javatoolbox.ifc2x3tc1;
/**
 * This is a default implementation of the entity IfcCurrencyRelationship<br><br>
 *<br><br>
 * Copyright: CC BY-NC-SA 3.0 DE (cc) 2013 Eike Tauscher and Michael Theiler<br><br>
 * The whole package including this class is licensed under<br>
 * <a rel='license' href='http://creativecommons.org/licenses/by-nc-sa/3.0/de/deed.en/'>
 * Creative Commons Attribution-Non-Commercial-Share Alike 3.0 Germany</a>.<br><br>
 * If you are using the package or parts of it in any commercial way, a commercial license is required. 
 * Visit <a href='http://www.ifctoolsproject.com'>http://www.ifctoolsproject.com</a> for more information
 * or contact us directly: <a href='mailto:info@ifctoolsproject.com'>info@ifctoolsproject.com</a><br>
 */
public class IfcCurrencyRelationship extends InternalAccessClass implements ClassInterface
{
	private static final String[] nonInverseAttributes = new String[]{"IfcMonetaryUnit","IfcMonetaryUnit","IfcPositiveRatioMeasure","IfcDateAndTime","IfcLibraryInformation"};
	private java.util.ArrayList<CloneableObject> stepParameter = null;
	private java.util.HashSet<ObjectChangeListener> listenerList = null;
	protected int stepLineNumber;
	/** RelatingMonetaryUnit is an DEMANDED attribute - may not be null**/
	protected IfcMonetaryUnit RelatingMonetaryUnit;
	/** RelatedMonetaryUnit is an DEMANDED attribute - may not be null**/
	protected IfcMonetaryUnit RelatedMonetaryUnit;
	/** ExchangeRate is an DEMANDED attribute - may not be null**/
	protected IfcPositiveRatioMeasure ExchangeRate;
	/** RateDateTime is an DEMANDED attribute - may not be null**/
	protected IfcDateAndTime RateDateTime;
	/** RateSource is an OPTIONAL attribute**/
	protected IfcLibraryInformation RateSource;
	/**
	* The default constructor.
	**/
	public IfcCurrencyRelationship(){}

	private static final String[] attributes = new String[]{"RelatingMonetaryUnit","RelatedMonetaryUnit","ExchangeRate","RateDateTime","RateSource"};

	public String[] getAttributes() {
		return IfcCurrencyRelationship.attributes;
	}

	/**
	* Constructs a new IfcCurrencyRelationship object using the given parameters.
	*
	* @param RelatingMonetaryUnit DEMANDED parameter of type IfcMonetaryUnit - may not be null.
	* @param RelatedMonetaryUnit DEMANDED parameter of type IfcMonetaryUnit - may not be null.
	* @param ExchangeRate DEMANDED parameter of type IfcPositiveRatioMeasure - may not be null.
	* @param RateDateTime DEMANDED parameter of type IfcDateAndTime - may not be null.
	* @param RateSource OPTIONAL parameter of type IfcLibraryInformation
	**/
	public IfcCurrencyRelationship(IfcMonetaryUnit RelatingMonetaryUnit, IfcMonetaryUnit RelatedMonetaryUnit, IfcPositiveRatioMeasure ExchangeRate, IfcDateAndTime RateDateTime, IfcLibraryInformation RateSource)
	{
		this.RelatingMonetaryUnit = RelatingMonetaryUnit;
		this.RelatedMonetaryUnit = RelatedMonetaryUnit;
		this.ExchangeRate = ExchangeRate;
		this.RateDateTime = RateDateTime;
		this.RateSource = RateSource;
		resolveInverses();
	}

	/**
	 * This method initializes the IfcCurrencyRelationship object using the given parameters.
	*
	* @param RelatingMonetaryUnit DEMANDED parameter of type IfcMonetaryUnit - may not be null.
	* @param RelatedMonetaryUnit DEMANDED parameter of type IfcMonetaryUnit - may not be null.
	* @param ExchangeRate DEMANDED parameter of type IfcPositiveRatioMeasure - may not be null.
	* @param RateDateTime DEMANDED parameter of type IfcDateAndTime - may not be null.
	* @param RateSource OPTIONAL parameter of type IfcLibraryInformation
	**/
	public void setParameters(IfcMonetaryUnit RelatingMonetaryUnit, IfcMonetaryUnit RelatedMonetaryUnit, IfcPositiveRatioMeasure ExchangeRate, IfcDateAndTime RateDateTime, IfcLibraryInformation RateSource)
	{
		this.RelatingMonetaryUnit = RelatingMonetaryUnit;
		this.RelatedMonetaryUnit = RelatedMonetaryUnit;
		this.ExchangeRate = ExchangeRate;
		this.RateDateTime = RateDateTime;
		this.RateSource = RateSource;
		resolveInverses();
	}

	/**
	 * This method is used internally and should NOT be used for own purposes.
	**/
	void initialize(java.util.ArrayList<CloneableObject> parameters)
	{
		this.RelatingMonetaryUnit = (IfcMonetaryUnit) parameters.get(0);
		this.RelatedMonetaryUnit = (IfcMonetaryUnit) parameters.get(1);
		this.ExchangeRate = (IfcPositiveRatioMeasure) parameters.get(2);
		this.RateDateTime = (IfcDateAndTime) parameters.get(3);
		this.RateSource = (IfcLibraryInformation) parameters.get(4);
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
		return IfcCurrencyRelationship.nonInverseAttributes;	}

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
		stepString = stepString.concat("IFCCURRENCYRELATIONSHIP(");
		if(getRedefinedDerivedAttributeTypes().contains("RelatingMonetaryUnit")) stepString = stepString.concat("*,");
		else{
		if(this.RelatingMonetaryUnit != null)		stepString = stepString.concat(((RootInterface)this.RelatingMonetaryUnit).getStepParameter(IfcMonetaryUnit.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("RelatedMonetaryUnit")) stepString = stepString.concat("*,");
		else{
		if(this.RelatedMonetaryUnit != null)		stepString = stepString.concat(((RootInterface)this.RelatedMonetaryUnit).getStepParameter(IfcMonetaryUnit.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("ExchangeRate")) stepString = stepString.concat("*,");
		else{
		if(this.ExchangeRate != null)		stepString = stepString.concat(((RootInterface)this.ExchangeRate).getStepParameter(IfcPositiveRatioMeasure.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("RateDateTime")) stepString = stepString.concat("*,");
		else{
		if(this.RateDateTime != null)		stepString = stepString.concat(((RootInterface)this.RateDateTime).getStepParameter(IfcDateAndTime.class.isInterface())+",");
		else		stepString = stepString.concat("$,");
		}
		if(getRedefinedDerivedAttributeTypes().contains("RateSource")) stepString = stepString.concat("*);");
		else{
		if(this.RateSource != null)		stepString = stepString.concat(((RootInterface)this.RateSource).getStepParameter(IfcLibraryInformation.class.isInterface())+");");
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
	* This method sets the RelatingMonetaryUnit attribute to the given value.
	*
	* @param RelatingMonetaryUnit OPTIONAL value to set
	**/
	public void setRelatingMonetaryUnit(IfcMonetaryUnit RelatingMonetaryUnit)
	{
		this.RelatingMonetaryUnit = RelatingMonetaryUnit;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the RelatingMonetaryUnit attribute.
	*
	* @return the value of RelatingMonetaryUnit
	/**/
	public IfcMonetaryUnit getRelatingMonetaryUnit()
	{
		return this.RelatingMonetaryUnit;
	}

	/**
	* This method sets the RelatedMonetaryUnit attribute to the given value.
	*
	* @param RelatedMonetaryUnit OPTIONAL value to set
	**/
	public void setRelatedMonetaryUnit(IfcMonetaryUnit RelatedMonetaryUnit)
	{
		this.RelatedMonetaryUnit = RelatedMonetaryUnit;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the RelatedMonetaryUnit attribute.
	*
	* @return the value of RelatedMonetaryUnit
	/**/
	public IfcMonetaryUnit getRelatedMonetaryUnit()
	{
		return this.RelatedMonetaryUnit;
	}

	/**
	* This method sets the ExchangeRate attribute to the given value.
	*
	* @param ExchangeRate OPTIONAL value to set
	**/
	public void setExchangeRate(IfcPositiveRatioMeasure ExchangeRate)
	{
		this.ExchangeRate = ExchangeRate;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the ExchangeRate attribute.
	*
	* @return the value of ExchangeRate
	/**/
	public IfcPositiveRatioMeasure getExchangeRate()
	{
		return this.ExchangeRate;
	}

	/**
	* This method sets the RateDateTime attribute to the given value.
	*
	* @param RateDateTime OPTIONAL value to set
	**/
	public void setRateDateTime(IfcDateAndTime RateDateTime)
	{
		this.RateDateTime = RateDateTime;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the RateDateTime attribute.
	*
	* @return the value of RateDateTime
	/**/
	public IfcDateAndTime getRateDateTime()
	{
		return this.RateDateTime;
	}

	/**
	* This method sets the RateSource attribute to the given value.
	*
	* @param RateSource DEMANDED value to set - may not be null
	**/
	public void setRateSource(IfcLibraryInformation RateSource)
	{
		this.RateSource = RateSource;
		fireChangeEvent();
	}

	/**
	* This method returns the value of the RateSource attribute.
	*
	* @return the value of RateSource
	/**/
	public IfcLibraryInformation getRateSource()
	{
		return this.RateSource;
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
		IfcCurrencyRelationship ifcCurrencyRelationship = new IfcCurrencyRelationship();
		if(this.RelatingMonetaryUnit != null)
			ifcCurrencyRelationship.setRelatingMonetaryUnit((IfcMonetaryUnit)this.RelatingMonetaryUnit.clone());
		if(this.RelatedMonetaryUnit != null)
			ifcCurrencyRelationship.setRelatedMonetaryUnit((IfcMonetaryUnit)this.RelatedMonetaryUnit.clone());
		if(this.ExchangeRate != null)
			ifcCurrencyRelationship.setExchangeRate((IfcPositiveRatioMeasure)this.ExchangeRate.clone());
		if(this.RateDateTime != null)
			ifcCurrencyRelationship.setRateDateTime((IfcDateAndTime)this.RateDateTime.clone());
		if(this.RateSource != null)
			ifcCurrencyRelationship.setRateSource((IfcLibraryInformation)this.RateSource.clone());
		return ifcCurrencyRelationship;
	}

	/**
	 * This method copys the object as shallow copy (all referenced objects are remaining).
	 *
	 * @return the cloned object
	**/
	public Object shallowCopy()
	{
		IfcCurrencyRelationship ifcCurrencyRelationship = new IfcCurrencyRelationship();
		if(this.RelatingMonetaryUnit != null)
			ifcCurrencyRelationship.setRelatingMonetaryUnit(this.RelatingMonetaryUnit);
		if(this.RelatedMonetaryUnit != null)
			ifcCurrencyRelationship.setRelatedMonetaryUnit(this.RelatedMonetaryUnit);
		if(this.ExchangeRate != null)
			ifcCurrencyRelationship.setExchangeRate(this.ExchangeRate);
		if(this.RateDateTime != null)
			ifcCurrencyRelationship.setRateDateTime(this.RateDateTime);
		if(this.RateSource != null)
			ifcCurrencyRelationship.setRateSource(this.RateSource);
		return ifcCurrencyRelationship;
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
