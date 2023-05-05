/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcalamot.kalamus.model_essers;

import com.elcalamot.kalamus.enums.Enums;
import com.elcalamot.kalamus.enums.Enums.Rango;

/**
 *
 * @author A200238614
 */
public class Andorians extends Essers {
    private Rango rango;

    public Andorians(String rango, String esser) {
        super(esser);
        this.rango = Enums.elegirRango(rango);
    }

    public Rango getRango() {
        return rango;
    }

    public void setRango(Rango rango) {
        this.rango = rango;
    }
    
}
