/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hzh.soil.control;

import java.util.ArrayList;
import java.util.List;
import org.hzh.soil.model.data.SoilEntry;

/**
 *
 * @author wei lu
 */
public class SoilCalculate {
    private List<SoilEntry> SoilVals;

    public SoilCalculate(List<SoilEntry> SoilVals) {
        this.SoilVals = SoilVals;
    }
    
    public double sumPh(){
        double ret = 0.0;
        if(SoilVals == null || SoilVals.size() == 0){
            return ret;
        }
        for(SoilEntry se : SoilVals){
            ret += se.getPh();
        }
        return ret;
    }
    
    public double avgPh(){
        double avg = 0;
        if(SoilVals == null || SoilVals.size() == 0){
            return avg;
        }
        return sumPh()/SoilVals.size();
    }
    
    
    public double powSum(){
        double mean = avgPh();
        if(SoilVals == null || SoilVals.size() == 0){
            return 0.;
        }
        double res = 0.0;
        for(SoilEntry se : SoilVals){
            res += (se.getPh() - mean) * (se.getPh() - mean);
        }
        return res;
    }
    
    public double stdDev(){
        return Math.sqrt(powSum()/(SoilVals.size() - 1));
    }
    
    
    
    public List<Double> pow2Ph(){
        if(SoilVals == null || SoilVals.size() == 0){
            return new ArrayList();
        }
        List<Double> res = new ArrayList();
        for(SoilEntry se : SoilVals){
            res.add(se.getPh() * se.getPh());
        }
        return res;
    }
}
