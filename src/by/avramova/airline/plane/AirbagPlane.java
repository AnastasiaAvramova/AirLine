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
public class AirbagPlane extends AbstractPlane {
    private int airbagMotorPower;
    private String airbagMotorName;
    
    public AirbagPlane()
    {
        super();
        this.airbagMotorName = "";
    }
    
    public void setAirbagMotorPower(int power)
    {
        if (power <= 0) {
            String message = "Incorrect initialization of variable airbagMotorPower by ";
            String gripe = message.concat(String.valueOf(power));
        }
        this.airbagMotorPower = power;
    }
    public int getAirbagMotorPower()
    {
        return this.airbagMotorPower;
    }
    
    public void setAirbagMotorName(String motorName)
    {
        if (motorName == null) {
            String message = "Incorrect initialization of variable airbagMotorName by ";
            String gripe = message.concat(String.valueOf(motorName));
        } 
        this.airbagMotorName = motorName;
    }
    public String getAirbagMotorName()
    {
        return this.airbagMotorName;
    }
    
    @Override
    public String toString()
    {
    	StringBuilder stringRepresentation = new StringBuilder(super.toString());
    	stringRepresentation.append(" "); 
    	stringRepresentation.append("Airbag motor name: ");
    	stringRepresentation.append(this.getAirbagMotorName());
    	stringRepresentation.append(" ");
    	stringRepresentation.append("Airbag motor power: ");
    	stringRepresentation.append(this.getAirbagMotorPower());
        return stringRepresentation.toString();
    }
}
