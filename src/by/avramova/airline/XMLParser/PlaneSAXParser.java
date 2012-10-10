/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.avramova.airline.XMLParser;

import org.xml.sax.XMLReader; 
import org.xml.sax.helpers.XMLReaderFactory; 
import org.xml.sax.SAXException; 
import java.util.ArrayList;  
import java.io.IOException;
import by.avramova.airline.plane.AbstractPlane;

/**
 *
 * @author tot
 */
public class PlaneSAXParser {
    private PlaneHandler handler = new PlaneHandler();
    public ArrayList<AbstractPlane> getPlaneList()
    {
        return handler.getPlanes();
    }
    public void parse()
    {
        try { 
            XMLReader reader = XMLReaderFactory.createXMLReader(); 
            reader.setContentHandler(handler);  
            if(handler != null) { 
                reader.parse("XMLDocuments/Planes.xml"); 
            }
        } catch (SAXException e) { 
            e.printStackTrace(); 
            System.out.print("ошибка SAX парсера"); 
        } catch (IOException e) { 
            e.printStackTrace(); 
            System.out.print("ошибка I/О потока"); 
        }
    }
}
