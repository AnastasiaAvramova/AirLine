/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.avramova.airline.XMLParser;

import java.util.ArrayList; 
import java.io.IOException; 
import org.xml.sax.SAXException; 
import org.w3c.dom.Element; 
import org.w3c.dom.Node; 
import org.w3c.dom.NodeList;
import by.avramova.airline.plane.AbstractPlane;
import by.avramova.airline.plane.AirbagPlane;
import by.avramova.airline.plane.BobberedPlane;
import by.avramova.airline.plane.HydroPlane;
import by.avramova.airline.plane.SkiedChassisPlane;
import by.avramova.airline.plane.WheeledChassisPlane;

/**
 *
 * @author tot
 */
public class PlaneAnalyzer {
    public static ArrayList<AbstractPlane> listBuilder(Element root) throws SAXException, IOException { 
    ArrayList<AbstractPlane> planes  = new ArrayList<AbstractPlane>();
    NodeList airbagNodes =  root.getElementsByTagName("airPlane"); 
    NodeList hydroNodes = root.getElementsByTagName("hydroPlane");
    NodeList bobberedNodes =  root.getElementsByTagName("bobberedPlane"); 
    NodeList skiedNodes = root.getElementsByTagName("skiedPlane");
    NodeList wheeledNodes = root.getElementsByTagName("wheeledPlane");
    for (int i = 0; i < airbagNodes.getLength(); i++) { 
        AirbagPlane plane = new AirbagPlane(); 
        Element planeElement =  (Element) airbagNodes.item(i); 
        plane.setHeight(Integer.parseInt(planeElement.getAttribute("height")));
        plane.setId(planeElement.getAttribute("id"));
        String str = planeElement.getAttribute("lenght");
        plane.setLength(Integer.parseInt(planeElement.getAttribute("lenght")));
        plane.setWeight(Integer.parseInt(planeElement.getAttribute("weight")));
        plane.setWingspan(Integer.parseInt(planeElement.getAttribute("wingspan")));
        plane.setBortNumber(getBabyValue(planeElement, "bortNumber"));
        plane.setCargoCapacity(Integer.parseInt(getBabyValue(planeElement, "cargoCapacity")));
        plane.setCruisingSpeed(Integer.parseInt(getBabyValue(planeElement, "cruisingSpeed")));
        plane.setFlyingDistance(Integer.parseInt(getBabyValue(planeElement, "flyingDistance")));
        plane.setFuelExpenditure(Integer.parseInt(getBabyValue(planeElement, "fuelExpenditure")));
        plane.setAirbagMotorName(getBabyValue(planeElement, "airbagMotorName"));
        plane.setAirbagMotorPower(Integer.parseInt(getBabyValue(planeElement, "airbagMotorPower")));
        plane.setSeatsNumber(Integer.parseInt(getBabyValue(planeElement, "seatsNumber")));
        planes.add(plane); 
    }
    for (int i = 0; i < hydroNodes.getLength(); i++) { 
        HydroPlane plane = new HydroPlane(); 
        Element planeElement =  (Element) hydroNodes.item(i); 
        plane.setHeight(Integer.parseInt(planeElement.getAttribute("height")));
        plane.setId(planeElement.getAttribute("id"));
        plane.setLength(Integer.parseInt(planeElement.getAttribute("lenght")));
        plane.setWeight(Integer.parseInt(planeElement.getAttribute("weight")));
        plane.setWingspan(Integer.parseInt(planeElement.getAttribute("wingspan")));
        plane.setBortNumber(getBabyValue(planeElement, "bortNumber"));
        plane.setCargoCapacity(Integer.parseInt(getBabyValue(planeElement, "cargoCapacity")));
        plane.setCruisingSpeed(Integer.parseInt(getBabyValue(planeElement, "cruisingSpeed")));
        plane.setFlyingDistance(Integer.parseInt(getBabyValue(planeElement, "flyingDistance")));
        plane.setFuelExpenditure(Integer.parseInt(getBabyValue(planeElement, "fuelExpenditure")));
        plane.setSeatsNumber(Integer.parseInt(getBabyValue(planeElement, "seatsNumber")));
        plane.setSeaworthiness(Integer.parseInt(getBabyValue(planeElement, "seaworthiness")));
        plane.setMaxWaveHeight(Integer.parseInt(getBabyValue(planeElement, "maxWaveHeight")));
        planes.add(plane); 
    } 
    for (int i = 0; i < bobberedNodes.getLength(); i++) { 
        BobberedPlane plane = new BobberedPlane(); 
        Element planeElement =  (Element) bobberedNodes.item(i); 
        plane.setHeight(Integer.parseInt(planeElement.getAttribute("height")));
        plane.setId(planeElement.getAttribute("id"));
        plane.setLength(Integer.parseInt(planeElement.getAttribute("lenght")));
        plane.setWeight(Integer.parseInt(planeElement.getAttribute("weight")));
        plane.setWingspan(Integer.parseInt(planeElement.getAttribute("wingspan")));
        plane.setBortNumber(getBabyValue(planeElement, "bortNumber"));
        plane.setCargoCapacity(Integer.parseInt(getBabyValue(planeElement, "cargoCapacity")));
        plane.setCruisingSpeed(Integer.parseInt(getBabyValue(planeElement, "cruisingSpeed")));
        plane.setFlyingDistance(Integer.parseInt(getBabyValue(planeElement, "flyingDistance")));
        plane.setFuelExpenditure(Integer.parseInt(getBabyValue(planeElement, "fuelExpenditure")));
        plane.setSeatsNumber(Integer.parseInt(getBabyValue(planeElement, "seatsNumber")));
        plane.setSeaworthiness(Integer.parseInt(getBabyValue(planeElement, "seaworthiness")));
        plane.setMaxWaveHeight(Integer.parseInt(getBabyValue(planeElement, "maxWaveHeight")));
        plane.setBobbersNumber(Integer.parseInt(getBabyValue(planeElement, "bobbersNumber")));
        planes.add(plane); 
    }
    for (int i = 0; i < skiedNodes.getLength(); i++) { 
        SkiedChassisPlane plane = new SkiedChassisPlane(); 
        Element planeElement =  (Element) skiedNodes.item(i); 
        plane.setHeight(Integer.parseInt(planeElement.getAttribute("height")));
        plane.setId(planeElement.getAttribute("id"));
        plane.setLength(Integer.parseInt(planeElement.getAttribute("lenght")));
        plane.setWeight(Integer.parseInt(planeElement.getAttribute("weight")));
        plane.setWingspan(Integer.parseInt(planeElement.getAttribute("wingspan")));
        plane.setBortNumber(getBabyValue(planeElement, "bortNumber"));
        plane.setCargoCapacity(Integer.parseInt(getBabyValue(planeElement, "cargoCapacity")));
        plane.setCruisingSpeed(Integer.parseInt(getBabyValue(planeElement, "cruisingSpeed")));
        plane.setFlyingDistance(Integer.parseInt(getBabyValue(planeElement, "flyingDistance")));
        plane.setFuelExpenditure(Integer.parseInt(getBabyValue(planeElement, "fuelExpenditure")));
        plane.setSeatsNumber(Integer.parseInt(getBabyValue(planeElement, "seatsNumber")));
        plane.setSkiLength(Integer.parseInt(getBabyValue(planeElement, "skiLength")));
        plane.setSkiWidth(Integer.parseInt(getBabyValue(planeElement, "skiWidth")));
        planes.add(plane); 
    }
    for (int i = 0; i < wheeledNodes.getLength(); i++) { 
        WheeledChassisPlane plane = new WheeledChassisPlane(); 
        Element planeElement =  (Element) wheeledNodes.item(i); 
        plane.setHeight(Integer.parseInt(planeElement.getAttribute("height")));
        plane.setId(planeElement.getAttribute("id"));
        plane.setLength(Integer.parseInt(planeElement.getAttribute("lenght")));
        plane.setWeight(Integer.parseInt(planeElement.getAttribute("weight")));
        plane.setWingspan(Integer.parseInt(planeElement.getAttribute("wingspan")));
        plane.setBortNumber(getBabyValue(planeElement, "bortNumber"));
        plane.setCargoCapacity(Integer.parseInt(getBabyValue(planeElement, "cargoCapacity")));
        plane.setCruisingSpeed(Integer.parseInt(getBabyValue(planeElement, "cruisingSpeed")));
        plane.setFlyingDistance(Integer.parseInt(getBabyValue(planeElement, "flyingDistance")));
        plane.setFuelExpenditure(Integer.parseInt(getBabyValue(planeElement, "fuelExpenditure")));
        plane.setSeatsNumber(Integer.parseInt(getBabyValue(planeElement, "seatsNumber")));
        plane.setBackWheelDiameter(Integer.parseInt(getBabyValue(planeElement, "backWheeelDiameter")));
        plane.setMainWheeelDiameter(Integer.parseInt(getBabyValue(planeElement, "mainWheeelDiameter")));
        plane.setBase(Integer.parseInt(getBabyValue(planeElement, "base")));
        plane.setRut(Integer.parseInt(getBabyValue(planeElement, "root")));
        planes.add(plane); 
    }
    return planes; 
  } 
  private static Element getBaby(Element parent, String childName) { 
    NodeList nlist = parent.getElementsByTagName(childName); 
    Element child = (Element) nlist.item(0); 
    return child; 
  } 
  private static String getBabyValue(Element parent, String childName) { 
    Element child = getBaby(parent, childName); 
    Node node = child.getFirstChild(); 
    String value = node.getNodeValue(); 
    return value; 
  } 
}
