/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.avramova.airline.planesumm;

import java.util.List;

import by.avramova.airline.plane.AbstractPlane;
import by.avramova.airline.planeenum.FieldEnum;
import by.avramova.airline.planeexception.IncorrectValueException;
import by.avramova.airline.planeatributevalueextractor.AtributeValueExtractor;

/**
 *
 * @author tot
 */
public class PlaneSummator {
    public int summOfPlainsAtribute(List<AbstractPlane> planeList, FieldEnum atribute) throws IncorrectValueException
    {
    	if(!(atribute == null)) {
            AtributeValueExtractor extractor = new AtributeValueExtractor();
            int summ = 0;
            for(AbstractPlane plane : planeList) {
    		int res = extractor.extractValueOfAtribute(plane, atribute);
    		summ += res;
            }
            return summ;
    	} else {
            String message = "Incorrect value of argument";
            throw new IncorrectValueException(message);
    	}
    }
}
