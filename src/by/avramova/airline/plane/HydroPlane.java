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
public class HydroPlane extends AbstractPlane {
    
    private int seaworthiness;
    private int maxWaveHeight;
    
    public HydroPlane()
    {
        super();
    }
    
    public void setSeaworthiness(int planeSeaworthiness)
    {
        if (planeSeaworthiness <= 0) {
            String message = "Incorrect initialization of variable seaworthiness by ";
            String gripe = message.concat(String.valueOf(planeSeaworthiness));
        } 
        this.seaworthiness = planeSeaworthiness;
    }
    public int getSeaworthiness()
    {
        return this.seaworthiness;
    }
    
    public void setMaxWaveHeight(int height)
    {
        if (height <= 0) {
            String message = "Incorrect initialization of variable maxWaveHeight by ";
            String gripe = message.concat(String.valueOf(height));
        } 
        this.maxWaveHeight = height;
    }
    public int getMaxWaveHeight()
    {
        return this.maxWaveHeight;
    }
    
    @Override
    public String toString()
    {
    	StringBuilder stringRepresentation = new StringBuilder(super.toString());
    	stringRepresentation.append(" ");
    	stringRepresentation.append("Max wave height: ");
    	stringRepresentation.append(this.getMaxWaveHeight());
    	stringRepresentation.append(" ");
    	stringRepresentation.append("Seaworthiness: ");
    	stringRepresentation.append(this.getSeaworthiness());
        return stringRepresentation.toString();
    }
}
