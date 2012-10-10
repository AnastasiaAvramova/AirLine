/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.avramova.airline.XMLParser;

import by.avramova.airline.plane.AbstractPlane;
import by.avramova.airline.plane.AirbagPlane;
import by.avramova.airline.plane.BobberedPlane;
import by.avramova.airline.plane.HydroPlane;
import by.avramova.airline.plane.SkiedChassisPlane;
import by.avramova.airline.plane.WheeledChassisPlane;
import java.util.ArrayList;
import org.xml.sax.Attributes; 
import org.xml.sax.ContentHandler; 
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/**
 *
 * @author tot
 */
public class PlaneHandler implements ContentHandler {
    ArrayList<AbstractPlane> planes = new ArrayList<AbstractPlane>(); 
    AbstractPlane curr = null; 
    PlaneFieldsEnum currEnum = null;
    
    public ArrayList<AbstractPlane> getPlanes()
    {
        return this.planes;
    }
    
    @Override
    public void setDocumentLocator(Locator locator) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void startDocument() 
    {
        System.out.println("parsing started");
    }

    @Override
    public void endDocument() {
        System.out.println("parsing ended");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) 
    {
        if (localName.equals("airPlane")) { 
            curr = new AirbagPlane();
            curr.setHeight(Integer.parseInt(atts.getValue(0)));
            curr.setId(atts.getValue(1));
            curr.setLength(Integer.parseInt(atts.getValue(2)));
            curr.setWeight(Integer.parseInt(atts.getValue(3)));
            curr.setWingspan(Integer.parseInt(atts.getValue(4)));
        } else if (localName.equals("hydroPlane")) {
            curr = new HydroPlane();
            curr.setHeight(Integer.parseInt(atts.getValue(0)));
            curr.setId(atts.getValue(1));
            curr.setLength(Integer.parseInt(atts.getValue(2)));
            curr.setWeight(Integer.parseInt(atts.getValue(3)));
            curr.setWingspan(Integer.parseInt(atts.getValue(4)));
        } else if (localName.equals("bobberedPlane")) { 
            curr = new BobberedPlane();
            curr.setHeight(Integer.parseInt(atts.getValue(0)));
            curr.setId(atts.getValue(1));
            curr.setLength(Integer.parseInt(atts.getValue(2)));
            curr.setWeight(Integer.parseInt(atts.getValue(3)));
            curr.setWingspan(Integer.parseInt(atts.getValue(4)));
        } else if (localName.equals("skiedPlane")) {
            curr = new SkiedChassisPlane();
            curr.setHeight(Integer.parseInt(atts.getValue(0)));
            curr.setId(atts.getValue(1));
            curr.setLength(Integer.parseInt(atts.getValue(2)));
            curr.setWeight(Integer.parseInt(atts.getValue(3)));
            curr.setWingspan(Integer.parseInt(atts.getValue(4)));
        } else if (localName.equals("wheeledPlane")) {
            curr = new WheeledChassisPlane();
            curr.setHeight(Integer.parseInt(atts.getValue(0)));
            curr.setId(atts.getValue(1));
            curr.setLength(Integer.parseInt(atts.getValue(2)));
            curr.setWeight(Integer.parseInt(atts.getValue(3)));
            curr.setWingspan(Integer.parseInt(atts.getValue(4)));
        } else if(!localName.equals("planeList") && !"planeList".equals(localName)) {
            System.out.println(localName.toUpperCase());
            currEnum =  PlaneFieldsEnum.valueOf(localName.toUpperCase());
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) 
    {
        if(localName.equals("airPlane") || localName.equals("hydroPlane") || localName.equals("bobberedPlane") ||
                localName.equals("skiedPlane") || localName.equals("wheeledPlane")) {
            planes.add(curr); 
        }
        currEnum = null; 
    }

    @Override
    public void characters(char[] ch, int start, int length) 
    {
        String s = new String(ch, start, length).trim(); 
        if(currEnum == null) {
            return; 
        }
        switch (currEnum) { 
            case SEATSNUMBER:
                curr.setSeatsNumber(Integer.parseInt(s));
                break;
            case CARGOCAPACITY:
                curr.setCargoCapacity(Integer.parseInt(s));
                break;
            case FLYINGDISTANCE:
                curr.setFlyingDistance(Integer.parseInt(s));
                break;
            case FUELEXPENDITURE:
                curr.setFuelExpenditure(Integer.parseInt(s));
                break;
            case CRUISINGSPEED:
                curr.setCruisingSpeed(Integer.parseInt(s));
                break;
            case BORTNUMBER:
                curr.setBortNumber(s);
                break;
            case AIRBAGMOTORPOWER: {
                AirbagPlane plane = (AirbagPlane) curr;
                plane.setAirbagMotorPower(Integer.parseInt(s));
                curr = plane;
                break;
            }
            case AIRBAGMOTORNAME: {
                AirbagPlane plane = (AirbagPlane) curr;
                plane.setAirbagMotorName(s);
                curr = plane;
                break;
            }
            case SEAWORTHINESS: {
                HydroPlane plane = (HydroPlane) curr;
                plane.setSeaworthiness(Integer.parseInt(s));
                curr = plane;
                break;
            }
            case MAXWAVEHEIGHT: {
                HydroPlane plane = (HydroPlane) curr;
                plane.setMaxWaveHeight(Integer.parseInt(s));
                curr = plane;
                break;
            }
            case BOBBERSNUMBER: {
                BobberedPlane plane = (BobberedPlane) curr;
                plane.setBobbersNumber(Integer.parseInt(s));
                curr = plane;
                break;
            }
            case SKILENGTH: {
                SkiedChassisPlane plane = (SkiedChassisPlane) curr;
                plane.setSkiLength(Integer.parseInt(s));
                curr = plane;
                break;
            }
            case SKIWIDTH: {
                SkiedChassisPlane plane = (SkiedChassisPlane) curr;
                plane.setSkiWidth(Integer.parseInt(s));
                curr = plane;
                break;
            }
            case ROOT: {
                WheeledChassisPlane plane = (WheeledChassisPlane) curr;
                plane.setRut(Integer.parseInt(s));
                curr = plane;
                break;
            }
            case BASE: {
                WheeledChassisPlane plane = (WheeledChassisPlane) curr;
                plane.setBase(Integer.parseInt(s));
                curr = plane;
                break;
            }
            case MAINWHEEELDIAMETER: {
                WheeledChassisPlane plane = (WheeledChassisPlane) curr;
                plane.setMainWheeelDiameter(Integer.parseInt(s));
                curr = plane;
                break;
            }
            case BACKWHEEELDIAMETER: {
                WheeledChassisPlane plane = (WheeledChassisPlane) curr;
                plane.setBackWheelDiameter(Integer.parseInt(s));
                curr = plane;
                break;
            }
        } 
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void skippedEntity(String name) throws SAXException {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
