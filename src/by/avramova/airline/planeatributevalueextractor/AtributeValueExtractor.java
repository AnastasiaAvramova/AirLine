/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.avramova.airline.planeatributevalueextractor;

import by.avramova.airline.plane.AbstractPlane;
import by.avramova.airline.planeexception.IncorrectValueException;
import by.avramova.airline.planeenum.FieldEnum;

/**
 *
 * @author tot
 */
public class AtributeValueExtractor {
    public int extractValueOfAtribute(AbstractPlane plane, FieldEnum atribute)
    {
    	int value = 0;
    	switch(atribute) {
        case SEATSNUMBER: {
        	value = plane.getSeatsNumber();
        }
        break;
        case CARGOCAPACITY: {
        	value = plane.getCargoCapacity();
        }
        break;
        case FLYINGDISTANCE: {
        	value = plane.getFlyingDistance();
        }
        break;
        case FUELEXPENDITURE: {
        	value = plane.getFuelExpenditure();
        }
        break;
        } 
        return value;
    }
}
