/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.avramova.airline.XMLParser;

import java.util.ArrayList; 
import java.io.IOException; 
import javax.xml.parsers.DocumentBuilder; 
import javax.xml.parsers.DocumentBuilderFactory; 
import javax.xml.parsers.ParserConfigurationException; 
import org.w3c.dom.Document; 
import org.w3c.dom.Element; 
import org.xml.sax.SAXException;
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
public class PlaneDOMParser {
    
    private ArrayList<AbstractPlane> planes;
    
    public ArrayList<AbstractPlane> getPlaneList()
    {
        return planes;
    }
// создание DOM-анализатора(JSDK) 
    public void parse()
    {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); 
        try { 
            DocumentBuilder db = dbf.newDocumentBuilder(); 
        // распознавание XML-документа 
            Document document = db.parse("XMLDocuments\\Planes.xml");  
         // создание DOM-анализатора (Xerces) 
            /* DOMParser parser = new DOMParser(); 
            parser.parse("students.xml"); 
            Document document = parser.getDocument();*/ 
            Element root = document.getDocumentElement(); 
            planes = PlaneAnalyzer.listBuilder(root);  
            
        } catch (SAXException e) { 
            e.printStackTrace(); 
            System.out.print("ошибка SAX парсера"); 
        } catch (ParserConfigurationException e) { 
            e.printStackTrace(); 
            System.out.print("ошибка конфигурации"); 
        } catch (IOException e) { 
            e.printStackTrace(); 
            System.out.print("ошибка I/О потока"); 
        } 
    }
}
