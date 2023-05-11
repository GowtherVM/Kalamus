/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcalamot.kalamus.model_planetas;

import com.elcalamot.kalamus.enums.Enums.Clima;
import com.elcalamot.kalamus.model_essers.Essers;
import java.util.ArrayList;

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
    private ArrayList<Essers> poblacion = new ArrayList();

    public Planeta(String nomplan, int poblacio_max, Clima clima, String flora_vermella, String essers_aquatics) {

        this.nomplan = nomplan;
        this.poblacio_max = poblacio_max;
        this.clima = clima;
        
        if (flora_vermella.equalsIgnoreCase("yes")) {
            this.flora_vermella = true;
        } else if (flora_vermella.equalsIgnoreCase("no")) {
            this.flora_vermella = false;
        }
        
        if (essers_aquatics.equalsIgnoreCase("yes")) {
            this.essers_aquatics = true;
        } else if (essers_aquatics.equalsIgnoreCase("no")) {
            this.essers_aquatics = false;
        }
        
        
    }

    public String getNomplan() {
        return nomplan;
    }

    public void addEsser(Essers nuevo) {
        poblacion.add(nuevo);

    }

    public ArrayList<Essers> getLista() {
        return poblacion;
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

    public String getFlora_vermella() {
        if (this.flora_vermella == true) {
            return "yes";
        }
        return "no";
    }

    public String getEssers_aquatics() {
        if (this.essers_aquatics == true) {
            return "yes";
        }
        return "no";
    }

}
