/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.avramova.airline.XMLParser;

import javax.xml.stream.XMLInputFactory; 
import javax.xml.stream.XMLStreamConstants; 
import javax.xml.stream.XMLStreamException; 
import javax.xml.stream.XMLStreamReader; 
import java.io.InputStream;
import java.util.ArrayList;
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
public class PlaneStAXParser {
    private ArrayList<AbstractPlane> planes;
    private AbstractPlane curr;
    private String name = "";
    public void parse(InputStream input) 
    { 
        XMLInputFactory inputFactory = XMLInputFactory.newInstance(); 
        try { 
            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
            process(reader); 
        } catch (XMLStreamException e) { 
            e.printStackTrace(); 
        } 
    }
    public void process(XMLStreamReader reader) throws XMLStreamException 
    { 
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) { 
                case XMLStreamConstants.START_ELEMENT: 
                    name = reader.getLocalName();
                    switch (PlaneFieldsEnum.valueOf(name.toUpperCase())) { 
                        case PLANELIST:
                            planes = new ArrayList<AbstractPlane>();
                            break; 
                        case AIRPLANE: {
                            AirbagPlane plane = new AirbagPlane();
                            processStart(reader, plane);
                            curr = plane;
                            break; 
                        }
                        case HYDROPLANE: {
                            HydroPlane plane = new HydroPlane();
                            processStart(reader, plane);
                            curr = plane;
                            break;
                        }
                        case BOBBEREDPLANE: {
                            BobberedPlane plane = new BobberedPlane();
                            processStart(reader, plane);
                            curr = plane;
                            break;
                        }
                        case SKIEDPLANE: {
                            SkiedChassisPlane plane = new SkiedChassisPlane();
                            processStart(reader, plane);
                            curr = plane;
                            break;
                        }
                        case WHEELEDPLANE: {
                            WheeledChassisPlane plane = new WheeledChassisPlane();
                            processStart(reader, plane);
                            curr = plane;
                            break;
                        }
                    } 
                    break; 
                case XMLStreamConstants.END_ELEMENT: 
                    name = reader.getLocalName(); 
                    switch (PlaneFieldsEnum.valueOf(name.toUpperCase())) { 
                        case AIRPLANE:
                            planes.add(curr);
                            break; 
                        case HYDROPLANE: 
                            planes.add(curr); 
                            break; 
                        case BOBBEREDPLANE: 
                            planes.add(curr); 
                            break;
                        case SKIEDPLANE:
                            planes.add(curr);
                            break;
                        case WHEELEDPLANE:
                            planes.add(curr);
                            break; 
                    }
                    break;
                case XMLStreamConstants.CHARACTERS: 
                    switch(PlaneFieldsEnum.valueOf(name.toUpperCase())) {
                        case SEATSNUMBER:
                            if(!reader.getText().equals("\n    ")) {
                                curr.setSeatsNumber(Integer.parseInt(reader.getText()));
                            }
                            break;
                        case CARGOCAPACITY:
                            if(!reader.getText().equals("\n    ")) {
                                curr.setCargoCapacity(Integer.parseInt(reader.getText()));
                            }
                            break;
                        case FLYINGDISTANCE:
                            if(!reader.getText().equals("\n    ")) {
                                curr.setFlyingDistance(Integer.parseInt(reader.getText()));
                            }
                            break;
                        case FUELEXPENDITURE:
                            if(!reader.getText().equals("\n    ")) {
                                curr.setFuelExpenditure(Integer.parseInt(reader.getText()));
                            }
                            break;
                        case CRUISINGSPEED: {
                            System.out.println(reader.getText());
                            if(!reader.getText().equals("\n    ")) {
                                curr.setCruisingSpeed(Integer.parseInt(reader.getText()));
                            }
                            break;
                        }
                        case BORTNUMBER:
                            if(!reader.getText().equals("\n    ")) {
                                curr.setBortNumber(reader.getText());
                            }
                            break;
                        case SEAWORTHINESS: {
                            if(!reader.getText().equals("\n    ")) {
                                HydroPlane plane = (HydroPlane) curr;
                                plane.setSeaworthiness(Integer.parseInt(reader.getText()));
                                curr = plane;
                            }
                            break;
                        }
                        case MAXWAVEHEIGHT: {
                            String text = reader.getText();
                            if(!reader.getText().equals("\n  ") && !reader.getText().equals("\n    ")) {
                                HydroPlane plane = (HydroPlane) curr;
                                plane.setMaxWaveHeight(Integer.parseInt(reader.getText()));
                                curr = plane;
                            }
                            break;
                        }
                        case BOBBERSNUMBER: {
                            if(!reader.getText().equals("\n  ") && !reader.getText().equals("\n    ")) {
                                BobberedPlane plane = (BobberedPlane) curr;
                                plane.setBobbersNumber(Integer.parseInt(reader.getText()));
                                curr = plane;
                            }
                            break;
                        }
                        case SKILENGTH: {
                            if(!reader.getText().equals("\n  ") && !reader.getText().equals("\n    ")) {
                                SkiedChassisPlane plane = (SkiedChassisPlane) curr;
                                plane.setSkiLength(Integer.parseInt(reader.getText()));
                                curr = plane;
                            }
                            break;
                        }
                        case SKIWIDTH: {
                            if(!reader.getText().equals("\n  ") && !reader.getText().equals("\n    ")) {
                                SkiedChassisPlane plane = (SkiedChassisPlane) curr;
                                plane.setSkiWidth(Integer.parseInt(reader.getText()));
                                curr = plane;
                            }
                            break;
                        }
                        case ROOT: {
                            if(!reader.getText().equals("\n  ") && !reader.getText().equals("\n    ")) {
                                WheeledChassisPlane plane = (WheeledChassisPlane) curr;
                                plane.setRut(Integer.parseInt(reader.getText()));
                                curr = plane;
                            }
                            break;
                        }
                        case BASE: {
                            if(!reader.getText().equals("\n  ") && !reader.getText().equals("\n    ")) {
                                WheeledChassisPlane plane = (WheeledChassisPlane) curr;
                                plane.setBase(Integer.parseInt(reader.getText()));
                                curr = plane;
                            }
                            break;
                        }
                        case MAINWHEEELDIAMETER: {
                            if(!reader.getText().equals("\n    ")) {
                                WheeledChassisPlane plane = (WheeledChassisPlane) curr;
                                plane.setMainWheeelDiameter(Integer.parseInt(reader.getText()));
                                curr = plane;
                            }
                            break;
                        }
                        case BACKWHEEELDIAMETER: {
                            if(!reader.getText().equals("\n  ") && !reader.getText().equals("\n    ")) {
                                WheeledChassisPlane plane = (WheeledChassisPlane) curr;
                                plane.setBackWheelDiameter(Integer.parseInt(reader.getText()));
                                curr = plane;
                            }
                            break;
                        }
                    }
                    break; 
            } 
        } 
    }
    public void processStart(XMLStreamReader reader, AbstractPlane plane)
    {
        plane.setHeight(Integer.parseInt(reader.getAttributeValue(0)));
        plane.setId(reader.getAttributeValue(1));
        plane.setLength(Integer.parseInt(reader.getAttributeValue(2)));
        plane.setWeight(Integer.parseInt(reader.getAttributeValue(3)));
        plane.setWingspan(Integer.parseInt(reader.getAttributeValue(3)));
    }
}
