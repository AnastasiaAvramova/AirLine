/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.avramova.airline.main;

import by.avramova.airline.company.AirCompany;
import by.avramova.airline.planeoutput.PlaneOutput;
import by.avramova.airline.planeenum.FieldEnum;
import by.avramova.airline.XMLParser.PlaneSAXParser;
import by.avramova.airline.XMLParser.PlaneStAXParser;
import by.avramova.airline.XMLParser.FileLoader;
import by.avramova.airline.XMLParser.PlaneDOMParser;

/**
 *
 * @author tot
 */
public class AirLine 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        
        AirCompany company = new AirCompany();
        PlaneSAXParser parser = new PlaneSAXParser();
        parser.parse();
        PlaneStAXParser stParser = new PlaneStAXParser();
        stParser.parse(FileLoader.loadFile("XMLDocuments\\Planes.xml"));
        PlaneDOMParser dParser = new PlaneDOMParser();
        dParser.parse();
        company.setPlaneList(parser.getPlaneList());
        PlaneOutput output = new PlaneOutput();
        FieldEnum seatsNumber = FieldEnum.SEATSNUMBER;
        FieldEnum cargoCapacity = FieldEnum.CARGOCAPACITY;
        FieldEnum flyingDistance = FieldEnum.FLYINGDISTANCE;
        FieldEnum fuelExpenditure = FieldEnum.FUELEXPENDITURE;
        output.showSumm(seatsNumber, company);
        output.showSumm(cargoCapacity, company);
        output.showSortedPlains(flyingDistance, company);
        output.showPlanesWithAtributeFromSpecifiedInterval(fuelExpenditure, 30, 60, company);
        output.showPlanesWithSpecifiedValueOfIntAtribute(cargoCapacity, 15, company);
    }
}
