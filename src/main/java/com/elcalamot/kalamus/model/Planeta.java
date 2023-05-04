/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcalamot.kalamus.model;

import com.elcalamot.kalamus.enums.Enums.Clima;
import com.elcalamot.kalamus.enums.Enums.Respuesta;

/**
 *
 * @author Admin
 */
public class Planeta {


    private String nomplan;
    private int poblacio_max;
    private Clima clima;
    private boolean flora_vermella;
    private boolean essers_aquatics;

    public Planeta(String nomplan, int poblacio_max, Clima clima,boolean flora_vermella, boolean essers_aquatics) {

        this.nomplan = nomplan;
        this.poblacio_max = poblacio_max;
        this.clima= clima;
        this.flora_vermella = flora_vermella;
        this.essers_aquatics = essers_aquatics;
    }

    public String getNomplan() {
        return nomplan;
    }

    public void setNomplan(String nomplan) {
        this.nomplan = nomplan;
    }

    public int getPoblacio_max() {
        return poblacio_max;
    }

    public void setPoblacio_max(int poblacio_max) {
        this.poblacio_max = poblacio_max;
    }

    public Clima getClima() {
        return clima;
    }

    public boolean getFlora_vermella() {
        return flora_vermella;
    }

    public boolean getEssers_aquatics() {
        return essers_aquatics;
    }





}
