/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcalamot.kalamus.model_essers;

/**
 *
 * @author A200238614
 */
public class Nibirians extends Essers {

    private boolean peix;

    public Nibirians( boolean peix, String esser) {
        super(esser);

        this.peix = peix;
    }

    public boolean isPeix() {
        return peix;
    }

    public void setPeix(boolean peix) {
        this.peix = peix;
    }
    
    
}
