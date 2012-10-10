/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.avramova.airline.planeoutput;

import java.util.*;

import by.avramova.airline.company.AirCompany;
import by.avramova.airline.planesearch.PlaneSearch;
import by.avramova.airline.planesorting.PlaneSorting;
import by.avramova.airline.planesumm.PlaneSummator;
import by.avramova.airline.plane.AbstractPlane;
import by.avramova.airline.planeenum.FieldEnum;
import by.avramova.airline.planeexception.IncorrectValueException;
/**
 *
 * @author tot
 */
public class PlaneOutput {
    public void showSumm(FieldEnum atribute, AirCompany company)
    {
        try {
            int number = 0;
            PlaneSummator summator = new PlaneSummator();
            number = summator.summOfPlainsAtribute(company.getPlaneList(), atribute);
            String message = "Summ of all " + atribute + ": " + String.valueOf(number);
            System.out.println(message);
        } catch(IncorrectValueException exception) {
            System.out.println(exception.getMessage());
        }
    }
    
    public void showPlanesWithAtributeFromSpecifiedInterval(FieldEnum atribute, int from, int to, AirCompany company)
    {
        try {
            ArrayList<AbstractPlane> planeList = new ArrayList<AbstractPlane>();
            PlaneSearch search = new PlaneSearch();
            planeList = search.findPlanesWithSpecifiedIntervalOfAtribute(company.getPlaneList(), atribute, from, to);
            String message = "Planes with " + atribute + " from " + String.valueOf(from) + 
                    " to " + String.valueOf(to) + ":";
            System.out.println(message);
            for (AbstractPlane plane : planeList) {
                System.out.println(plane.toString());
            }
        } catch(IncorrectValueException exception) {
            System.out.println(exception.getMessage());
        }
    }
    
    public void showPlanesWithSpecifiedValueOfIntAtribute(FieldEnum atribute, int value, AirCompany company)
    {
        try {
            ArrayList<AbstractPlane> planeList = new ArrayList<AbstractPlane>();
            PlaneSearch search = new PlaneSearch();
            planeList = search.findPlanesWithSpecifiedIntField(company.getPlaneList(), atribute, value);
            String message = "Planes with " + atribute + " " + String.valueOf(value) + ":";
            System.out.println(message);
            for (AbstractPlane plane : planeList) {
                System.out.println(plane.toString());
            }
        } catch(IncorrectValueException exception) {
            System.out.println(exception.getMessage());
        }
    }
    
    public void showSortedPlains(FieldEnum atribute, AirCompany company)
    {
        try {
            List<AbstractPlane> planeList = new ArrayList<AbstractPlane>();
            PlaneSorting sorting = new PlaneSorting(company.getPlaneList());
            planeList = sorting.sort(atribute);
            String message = "Planes, sorted by " + atribute + ":";
            System.out.println(message);
            for (AbstractPlane plane : planeList) {
                System.out.println(plane.toString());
            }
        } catch(IncorrectValueException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
