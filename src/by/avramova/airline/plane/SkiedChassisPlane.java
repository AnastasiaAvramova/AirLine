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
public class SkiedChassisPlane extends AbstractPlane {
    private int skiLength;
    private int skiWidth;
    
    public SkiedChassisPlane()
    {
        super();
    }
    
    public void setSkiLength(int length)
    {
        if (length <= 0) {
            String message = "Incorrect initialization of variable skiLength by ";
            String gripe = message.concat(String.valueOf(length));
        } 
        this.skiLength = length;
    }
    public int getSkiLength()
    {
        return this.skiLength;
    }
    
    public void setSkiWidth(int width)
    {
        if (width <= 0) {
            String message = "Incorrect initialization of variable skiWidth by ";
            String gripe = message.concat(String.valueOf(width));
        } 
        this.skiWidth = width;
    }
    public int getSkiWidth()
    {
        return this.skiWidth;
    }
    
    @Override
    public String toString()
    {
    	StringBuilder stringRepresentation = new StringBuilder(super.toString());
    	stringRepresentation.append(" ");
    	stringRepresentation.append("Ski length: ");
    	stringRepresentation.append(this.getSkiLength());
    	stringRepresentation.append(" ");
    	stringRepresentation.append("Ski width: ");
    	stringRepresentation.append(this.getSkiWidth());
        return stringRepresentation.toString();
    }
}
