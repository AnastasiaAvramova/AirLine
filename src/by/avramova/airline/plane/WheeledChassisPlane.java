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
public class WheeledChassisPlane extends AbstractPlane {
    private int rut;
    private int base;
    private int mainWheeelDiameter;
    private int backWheelDiameter;
    
    public WheeledChassisPlane()
    {
        super();
    }
    
    public void setRut(int planeRut)
    {
        if (planeRut <= 0) {
            String message = "Incorrect initialization of variable rut by ";
            String gripe = message.concat(String.valueOf(planeRut));
        } 
        this.rut = planeRut;
    }
    public int getRut()
    {
        return this.rut;
    }
    
    public void setBase(int planeBase)
    {
        if (planeBase <= 0) {
            String message = "Incorrect initialization of variable base by ";
            String gripe = message.concat(String.valueOf(planeBase));
        } 
        this.base = planeBase;
    }
    public int getBase()
    {
        return this.base;
    }
    
    public void setMainWheeelDiameter(int diameter)
    {
        if (diameter <= 0) {
            String message = "Incorrect initialization of variable mainWheeelDiameter by ";
            String gripe = message.concat(String.valueOf(diameter));
        } 
        this.mainWheeelDiameter = diameter;
    }
    public int getMainWheelDiameter()
    {
        return this.mainWheeelDiameter;
    }
    
    public void setBackWheelDiameter(int diameter)
    {
        if (diameter <= 0) {
            String message = "Incorrect initialization of variable backWheelDiameter by ";
            String gripe = message.concat(String.valueOf(diameter));
        } 
        this.backWheelDiameter = diameter;
    }
    public int getBackWheelDiameter()
    {
        return this.backWheelDiameter;
    }
    
    @Override
    public String toString()
    {
    	StringBuilder stringRepresentation = new StringBuilder(super.toString());
    	stringRepresentation.append(" ");
    	stringRepresentation.append("Back wheel diameter: ");
    	stringRepresentation.append(this.getBackWheelDiameter());
    	stringRepresentation.append(" ");
    	stringRepresentation.append("Base: ");
    	stringRepresentation.append(this.getBase());
    	stringRepresentation.append(" ");
    	stringRepresentation.append("Main wheel diameter: ");
    	stringRepresentation.append(this.getMainWheelDiameter());
    	stringRepresentation.append(" ");
    	stringRepresentation.append("Rut: ");
    	stringRepresentation.append(this.getRut());
        return stringRepresentation.toString();
    }
}
