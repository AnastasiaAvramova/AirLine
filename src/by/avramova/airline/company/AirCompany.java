/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.avramova.airline.company;

import by.avramova.airline.plane.AbstractPlane;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author tot
 */
public class AirCompany {
    private List <AbstractPlane> planeList;
    
    public AirCompany()
    {
        this.planeList = new ArrayList<AbstractPlane>();
    }
    public AirCompany(List <AbstractPlane> planeList_)
    {
        if (!planeList.isEmpty()) {
            this.planeList = planeList_;
        }
    }
    public void setPlaneList(ArrayList<AbstractPlane> list)
    {
        this.planeList = list;
    }
    public List<AbstractPlane> getPlaneList()
    {
        return Collections.unmodifiableList(this.planeList);
    }
    public void addPlane(AbstractPlane plane)
    {
        if (plane != null) {
            planeList.add(plane);
        } 
    }
    public void removePlane(String id)
    {
        for1 (AbstractPlane plane : this.planeList) {
            if (plane.getId().equals(id)) {
                this.planeList.remove(plane);
                break;
            }
        }
    }
}