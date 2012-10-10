/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.avramova.airline.plane;

import by.avramova.airline.planeexception.IncorrectValueException;
import by.avramova.airline.planeenum.FieldEnum;
import by.avramova.airline.planeatributevalueextractor.AtributeValueExtractor;

/**
 *
 * @author tot
 */
public abstract class AbstractPlane {
    private int seatsNumber;
    private int cargoCapacity;
    private int flyingDistance;
    private int fuelExpenditure;
    private int wingspan;
    private int length;
    private int height;
    private int weight;
    private int cruisingSpeed;
    private String id;
    private String bortNumber;
        
    public AbstractPlane()
    {
        this.id = "";
    }
    
    public void setSeatsNumber(int number)
    {
        this.seatsNumber = number;
    }
    public int getSeatsNumber()
    {
        return this.seatsNumber;
    }
    
    public String getId()
    {
        return this.id;
    }
    public void setId(String identifier)
    {
        if (identifier.isEmpty()) {
            String message = "Incorrect initialization of variable id";
        }
        this.id = identifier;
    }
  
    public String getBortNumber()
    {
        return this.bortNumber;
    }
    public void setBortNumber(String number)
    {
        this.bortNumber = number;
    }
    
    public void setWingspan(int span)
    {
        if (span <= 0) {
            String message = "Incorrect initialization of variable wingspan by ";
            String gripe = message.concat(String.valueOf(span));
        } 
        this.wingspan = span;
    }
    public int getWingspan()
    {
        return this.wingspan;
    }
    
    public void setLength(int planeLength)
    {
        if (planeLength <= 0) {
            String message = "Incorrect initialization of variable lehgth by ";
            String gripe = message.concat(String.valueOf(planeLength));
        } 
        this.length = planeLength;
    }
    public int getLength()
    {
        return this.length;
    }
    
    public void setHeight(int planeHeight)
    {
        if (planeHeight <= 0) {
            String message = "Incorrect initialization of variable height by ";
            String gripe = message.concat(String.valueOf(planeHeight));
        } 
        this.height = planeHeight;
    }
    public int getHeight()
    {
        return this.height;
    }
    
    public void setWeight(int planeWeight)
    {
        if (planeWeight <= 0) {
            String message = "Incorrect initialization of variable weight by ";
            String gripe = message.concat(String.valueOf(planeWeight));
        } 
        this.weight = planeWeight;
    }
    public int getWeight()
    {
        return this.weight;
    }
    
    public void setCruisingSpeed(int speed)
    {
        if (speed <= 0) {
            String message = "Incorrect initialization of variable cruisingSpeed by ";
            String gripe = message.concat(String.valueOf(speed));
        } 
        this.cruisingSpeed = speed;
    }
    public int getCruisingSpeed()
    {
        return this.cruisingSpeed;
    }
    
    public void setCargoCapacity(int capacity)
    {
        this.cargoCapacity = capacity;
    }
    public int getCargoCapacity()
    {
        return this.cargoCapacity;
    }
    
    public void setFlyingDistance(int distance)
    { 
        this.flyingDistance = distance;
    }
    public int getFlyingDistance()
    {
        return this.flyingDistance;
    }
    
    public void setFuelExpenditure(int expenditure)
    {
        this.fuelExpenditure = expenditure;
    }
    public int getFuelExpenditure()
    {
        return this.fuelExpenditure;
    }
    
    public int compareTo(AbstractPlane plane, FieldEnum atribute)
    {
        
            AtributeValueExtractor extractor = new AtributeValueExtractor();
            int thisValue = extractor.extractValueOfAtribute(this, atribute);
            int thatValue = extractor.extractValueOfAtribute(plane, atribute);

            if(thisValue > thatValue) {
                    return 1;
            } else if(thisValue < thatValue) {
                    return -1;
            } else {
                    return 0;
            }
    }
    
    @Override
    public String toString()
    {
    	StringBuilder stringRepresentation = new StringBuilder(this.getClass().getName());
    	stringRepresentation.append("Speed: ");
    	stringRepresentation.append(this.getCruisingSpeed());
    	stringRepresentation.append(" ");
    	stringRepresentation.append("Height: ");
    	stringRepresentation.append(this.getHeight());
    	stringRepresentation.append(" ");
    	stringRepresentation.append("Length: ");
    	stringRepresentation.append(this.getLength());
    	stringRepresentation.append(" ");
    	stringRepresentation.append("SeatsNumber: ");
    	stringRepresentation.append(this.getSeatsNumber());
    	stringRepresentation.append(" ");
    	stringRepresentation.append("Weight: ");
    	stringRepresentation.append(this.getWeight());
    	stringRepresentation.append(" ");
    	stringRepresentation.append("Wingspan: ");
    	stringRepresentation.append(this.getWingspan());
    	stringRepresentation.append(" ");
    	stringRepresentation.append("FlyingDistance: ");
    	stringRepresentation.append(this.getFlyingDistance());
    	stringRepresentation.append(" ");
    	stringRepresentation.append("FuelExpenditure: ");
    	stringRepresentation.append(this.getFuelExpenditure());
        return stringRepresentation.toString();
    }
}
