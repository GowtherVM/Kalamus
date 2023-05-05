/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcalamot.kalamus.model_essers;

/**
 *
 * @author A200238614
 */
public class Vulcanians extends Essers {
    private int meditacio;

    public Vulcanians(String nom,String esser, int meditacio) {
        super(nom,esser);
        this.meditacio = meditacio;
    }

    public int getMeditacio() {
        return meditacio;
    }

    public void setMeditacio(int meditacio) {
        this.meditacio = meditacio;
    }
    
    
}
