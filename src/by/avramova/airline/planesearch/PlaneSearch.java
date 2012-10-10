/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.avramova.airline.planesearch;

import by.avramova.airline.plane.AbstractPlane;
import by.avramova.airline.planeenum.FieldEnum;
import by.avramova.airline.planeexception.IncorrectValueException;
import by.avramova.airline.planeatributevalueextractor.AtributeValueExtractor;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author tot
 */
public class PlaneSearch {
    public ArrayList<AbstractPlane> findPlanesWithSpecifiedIntField(List<AbstractPlane> planeList, 
            FieldEnum atribute, int value) throws IncorrectValueException
    {
    	if(!(atribute == null) && value > 0) {
            AtributeValueExtractor extractor = new AtributeValueExtractor();
	    ArrayList<AbstractPlane> resultList = new ArrayList<AbstractPlane>();
	    for(AbstractPlane plane : planeList) {
	        int result = extractor.extractValueOfAtribute(plane, atribute);
	        if(result == value) {
	            resultList.add(plane);
	        }   
            }
	    return resultList;
    	} else {
    		String message = "Incorrect value of argument";
    		throw new IncorrectValueException(message);
    	}
    }
    
    public ArrayList<AbstractPlane> findPlanesWithSpecifiedIntervalOfAtribute(List<AbstractPlane> planeList, 
            FieldEnum atribute, int from, int to) throws IncorrectValueException
    {
    	if(!(atribute == null) && from >= 0 && to > 0) {
            AtributeValueExtractor extractor = new AtributeValueExtractor();
	    ArrayList<AbstractPlane> resultList = new ArrayList<AbstractPlane>();
	    for(AbstractPlane plane : planeList) {
	        int result = extractor.extractValueOfAtribute(plane, atribute);
	        if(result >= from && result <= to) {
	            resultList.add(plane);
	        }     
	    }
	    return resultList;
    	} else {
            String message = "Incorrect value of argument";
            throw new IncorrectValueException(message);
    	}
    }
}
