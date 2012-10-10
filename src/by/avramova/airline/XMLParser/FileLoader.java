/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.avramova.airline.XMLParser;

import java.io.FileInputStream; 
import java.io.InputStream;
import java.io.FileNotFoundException;

/**
 *
 * @author tot
 */
public class FileLoader {
    public static InputStream loadFile(String fileName)
    {
        InputStream input = null;
        try {
            input = new FileInputStream(fileName);
        } catch(FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return input;
    }
}
