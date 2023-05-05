/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcalamot.kalamus.controller;

import com.elcalamot.kalamus.exceptions.DemanarDades;
import com.elcalamot.kalamus.exceptions.PlanetaExcepcio;
import com.elcalamot.kalamus.model_essers.Andorians;
import com.elcalamot.kalamus.model_essers.Ferengi;
import com.elcalamot.kalamus.model_essers.FuncionesModelo_Essers;
import com.elcalamot.kalamus.model_essers.Humans;
import com.elcalamot.kalamus.model_essers.Klingon;
import com.elcalamot.kalamus.model_essers.Nibirians;
import com.elcalamot.kalamus.model_essers.Vulcanians;
import com.elcalamot.kalamus.model_planetas.FuncionesModelo_Planetas;
import com.elcalamot.kalamus.model_planetas.Planeta;

import com.elcalamot.kalamus.model_planetas.SistemasDB;
import com.elcalamot.kalamus.persistencia.Persistencia;
import com.elcalamot.kalamus.vistas.Vistas;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ControllerKalamus {

    private SistemasDB sistemas;
    private Persistencia persistencia;
    private DemanarDades demanar;

    public ControllerKalamus(SistemasDB sistemas, Persistencia persistencia, DemanarDades demanar) {
        this.sistemas = sistemas;
        this.persistencia = persistencia;
        this.demanar = demanar;
    }

    public void iniciarKalamus(String[] args) {
        FuncionesModelo_Planetas.testsPlanetas();
        FuncionesModelo_Essers.testEssers();

        switch (args[0]) {
            case "planet":

                switch (args[1]) {

                    case "add":

                        FuncionesModelo_Planetas.crearPlaneta(args);

                        break;
                    case "list":
                        sistemas.listPlanetas();
                        break;
                    default:
                        System.out.println("Comando no existe. Unicamente se acepta (add/list).");
                }
                break;

            case "being":
                switch (args[1]) {
                    case "add":
                        
                        FuncionesModelo_Essers.crearEsser(args);
                        
                        break;
                    case "list":

                        sistemas.listEssers();
                        break;
                    default:
                        System.out.println("Comando no existe. Unicamente se acepta (add/list).");
                }
                break;
            default:
                System.out.println("Caso incorrecto. Debe indicar como primer valor (planets/being)");

        }

    }

    public static void generarCadenasEssers(Planeta planeta_essers) {

        ArrayList<String> cadenas = new ArrayList();
        ArrayList<Humans> poblacio_humans = new ArrayList();
        ArrayList<Andorians> poblacio_andorians = new ArrayList();
        ArrayList<Ferengi> poblacio_ferengi = new ArrayList();
        ArrayList<Klingon> poblacio_kingon = new ArrayList();
        ArrayList<Nibirians> poblacio_nibirians = new ArrayList();
        ArrayList<Vulcanians> poblacio_vulcanians = new ArrayList();
        
        for (Object lista : planeta_essers.getLista()) {
            if (lista.getClass() == Humans.class) { Humans huma = (Humans) lista; poblacio_humans.add(huma);}
            if (lista.getClass() == Andorians.class) { Andorians andor = (Andorians) lista; poblacio_andorians.add(andor);}
            if (lista.getClass() == Ferengi.class) { Ferengi fer = (Ferengi) lista; poblacio_ferengi.add(fer);}
            if (lista.getClass() == Klingon.class) { Klingon kin = (Klingon) lista; poblacio_kingon.add(kin);}
            if (lista.getClass() == Nibirians.class) { Nibirians nib = (Nibirians) lista; poblacio_nibirians.add(nib);}
            if (lista.getClass() == Vulcanians.class) { Vulcanians vul = (Vulcanians) lista; poblacio_vulcanians.add(vul);}
                   
        }
        if(planeta_essers.getLista().isEmpty() == false){
            cadenas.clear();
            cadenas.add("    Planeta: " + planeta_essers.getNomplan());
            
        }else{
            cadenas.clear();
            cadenas.add("    Planeta: " + planeta_essers.getNomplan());
            cadenas.add("       [Sin datos registrados]");
        }
        
        Vistas.mostrarInformacion(cadenas);
        
         if (poblacio_humans.isEmpty() == false) {
        System.out.println("        Raza: Humas");
            for (Humans tipo : poblacio_humans) {
                cadenas.clear();
                cadenas.add("             Nombre: " + tipo.getNom());
                cadenas.add("             Edad: " + String.valueOf(tipo.getEdad()));
                cadenas.add("             Genere: " + tipo.getGenere());
                cadenas.add(" ");
                Vistas.mostrarInformacion(cadenas);
            }
        }
         
        if (poblacio_andorians.isEmpty() == false) {
        System.out.println("        Raza: Andorians");
            for (Andorians tipo : poblacio_andorians) {
                cadenas.clear();
                cadenas.add("             Nombre: " + tipo.getNom());
                cadenas.add("             Rango: " + tipo.getRango().toString());
                cadenas.add(" ");
                Vistas.mostrarInformacion(cadenas);
            }
        }
        
        if (poblacio_ferengi.isEmpty() == false) {
        System.out.println("        Raza: Ferengis");
            for (Ferengi tipo : poblacio_ferengi) {
                cadenas.clear();
                cadenas.add("             Nombre: " + tipo.getNom());
                cadenas.add("             Latinum: " + tipo.getLatinum());
                cadenas.add(" ");

                Vistas.mostrarInformacion(cadenas);
            }
        }
        
        if (poblacio_kingon.isEmpty() == false) {
        System.out.println("        Raza: Kingons");
            for (Klingon tipo : poblacio_kingon) {
                cadenas.clear();
                cadenas.add("             Nombre: " + tipo.getNom());
                cadenas.add("             Fuerza: " + tipo.getFuerza());
                cadenas.add(" ");

                Vistas.mostrarInformacion(cadenas);
            }
        }
        
        if (poblacio_nibirians.isEmpty() == false) {
        System.out.println("        Raza: Nibiritians");
            for (Nibirians tipo : poblacio_nibirians) {
                cadenas.clear();
                cadenas.add("             Nombre: " + tipo.getNom());
                cadenas.add("                Peix: " + tipo.isPeix());
                cadenas.add(" ");

                Vistas.mostrarInformacion(cadenas);
            }
        }
        
        if (poblacio_vulcanians.isEmpty() == false) {
        System.out.println("        Raza: Vulcanians");
            for (Vulcanians tipo : poblacio_vulcanians) {
                cadenas.clear();
                cadenas.add("             Nombre: " + tipo.getNom());
                cadenas.add("             Meditacio: " + tipo.getMeditacio());
                cadenas.add(" ");

                Vistas.mostrarInformacion(cadenas);
            }
        }

    }
    
    
    public static void generarCadenasPlanetas(Planeta plan){
        ArrayList<String> cadenas = new ArrayList();
        cadenas.add("Planeta: " + plan.getNomplan());
        cadenas.add("   Poblacion maxima: "+plan.getPoblacio_max());
        cadenas.add("   Poblacion actual: "+plan.getLista().size());
        cadenas.add("   Clima: "+plan.getClima());
        cadenas.add("   Flora vermella: "+plan.getFlora_vermella());
        cadenas.add("   Animals acuatics: "+plan.getEssers_aquatics());
        cadenas.add(" ");
        Vistas.mostrarInformacion(cadenas);
        
    }
}
