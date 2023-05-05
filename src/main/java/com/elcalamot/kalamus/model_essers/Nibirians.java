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

    public Nibirians(String nom, boolean peix, String esser) {
        super(nom,esser);

        this.peix = peix;
    }

    public String isPeix() {
        return FuncionesModelo_Essers.getPeix(peix);
    }

    public void setPeix(boolean peix) {
        this.peix = peix;
    }
    
    
}
