/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hzh.soil.model.data;

/**
 *
 * @author wei lu
 */
public class SoilEntry {
    private int id;
    private double lng;
    private double lat;
    private double ph;
    private String timestamp;
    
    public SoilEntry(){}

    public SoilEntry(int id, double lng, double lat, double ph, String timestmp) {
        this.id = id;
        this.lng = lng;
        this.lat = lat;
        this.ph = ph;
        this.timestamp = timestmp;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getPh() {
        return ph;
    }

    public void setPh(double ph) {
        this.ph = ph;
    }

    public String getTimestmp() {
        return timestamp;
    }

    public void setTimestmp(String timestmp) {
        this.timestamp = timestmp;
    }

    @Override
    public String toString() {
        return "SoilEntry{" + "id=" + id + ", lng=" + lng + ", lat=" + lat + ", ph=" + ph + ", timestamp=" + timestamp + '}';
    }
    
    
    
}
