/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.avramova.airline.plane;

import by.avramova.airline.planeexception.IncorrectValueException;

/**
 *
 * @author tot
 */
public class BobberedPlane extends HydroPlane {
    private int bobbersNumber;
    
    public BobberedPlane()
    {
        super();
    }
    
    public void setBobbersNumber(int number)
    {
        if (number <= 0) {
            String message = "Incorrect initialization of variable bobbersNumber by ";
            String gripe = message.concat(String.valueOf(number));
        } 
        this.bobbersNumber = number;
    }
    public int getBobbersNumber()
    {
        return this.bobbersNumber;
    }
    
    @Override
    public String toString()
    {
    	StringBuilder stringRepresentation = new StringBuilder(super.toString());
    	stringRepresentation.append(" ");
    	stringRepresentation.append("Bobbers number: ");
    	stringRepresentation.append(this.getBobbersNumber());
        return stringRepresentation.toString();
    }
}
