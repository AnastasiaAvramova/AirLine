/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.avramova.airline.planesorting;

import java.util.ArrayList;
import java.util.List;

import by.avramova.airline.plane.AbstractPlane;
import by.avramova.airline.planeexception.IncorrectValueException;
import by.avramova.airline.planeenum.FieldEnum;


/**
 *
 * @author tot
 */
public class PlaneSorting {
    private List<AbstractPlane> planeList;
    private ArrayList<AbstractPlane> sortedList;
    public PlaneSorting(List<AbstractPlane> planesList)
    {
        this.planeList = planesList;
        this.sortedList = new ArrayList<AbstractPlane> (planesList);
    }
    public List<AbstractPlane> sort(FieldEnum atribute) throws IncorrectValueException
    {
    	if(!(atribute == null)) {
    		quickSort(0, planeList.size() - 1, atribute);
    		return this.sortedList;  		
    	} else {
    		String message = "Incorrect value of argument";
    		throw new IncorrectValueException(message);
    	}
    }
    private void quickSort(int first, int last, FieldEnum atribute)
    {
        int low = first;
        int high = last;
        AbstractPlane middle = sortedList.get(first + (last - first) / 2);
        while(low < high) {
            while(sortedList.get(low).compareTo(middle, atribute) < 0) {
                low ++;
            }
            while(sortedList.get(high).compareTo(middle, atribute) > 0) {
                high --;
            }
            if(low <= high) {
                exchange(low, high);
                low ++;
                high --;
            }
        }
        if(first < high) {
            quickSort(first, high, atribute);
        }
        if(low < last) {
            quickSort(low, last, atribute);
        }
    }
    private void exchange(int low, int high)
    {
        AbstractPlane lowPlane = sortedList.get(low);
        AbstractPlane highPlane = sortedList.get(high);
        sortedList.set(high, lowPlane);
        sortedList.set(low, highPlane);
    }
}
