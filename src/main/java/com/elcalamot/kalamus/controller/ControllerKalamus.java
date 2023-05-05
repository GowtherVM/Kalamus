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
import com.elcalamot.kalamus.model_essers.Kingon;
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

    public static void generarCadenas(Planeta planeta_essers) {

        ArrayList<String> cadenas = new ArrayList();
        ArrayList<Humans> poblacio_humans = new ArrayList();
        ArrayList<Andorians> poblacio_andorians = new ArrayList();
        ArrayList<Ferengi> poblacio_ferengi = new ArrayList();
        ArrayList<Kingon> poblacio_kingon = new ArrayList();
        ArrayList<Nibirians> poblacio_nibirians = new ArrayList();
        ArrayList<Vulcanians> poblacio_vulcanians = new ArrayList();
        
        for (Object lista : planeta_essers.getLista()) {
            if (lista.getClass() == Humans.class) { Humans huma = (Humans) lista; poblacio_humans.add(huma);}
            if (lista.getClass() == Andorians.class) { Andorians andor = (Andorians) lista; poblacio_andorians.add(andor);}
            if (lista.getClass() == Ferengi.class) { Ferengi fer = (Ferengi) lista; poblacio_ferengi.add(fer);}
            if (lista.getClass() == Kingon.class) { Kingon kin = (Kingon) lista; poblacio_kingon.add(kin);}
            if (lista.getClass() == Nibirians.class) { Nibirians nib = (Nibirians) lista; poblacio_nibirians.add(nib);}
            if (lista.getClass() == Vulcanians.class) { Vulcanians vul = (Vulcanians) lista; poblacio_vulcanians.add(vul);}
                   
        }

        System.out.println("    Planeta: " + planeta_essers.getNomplan());

        System.out.println("        Raza: Humas");
        if (poblacio_humans.isEmpty() == false) {
            for (Humans tipo : poblacio_humans) {
                cadenas.clear();
                cadenas.add("             Nombre: " + tipo.getNom());
                cadenas.add("             Edad: " + String.valueOf(tipo.getEdad()));
                cadenas.add("             Genere: " + tipo.getGenere());
                cadenas.add(" ");
                Vistas.mostrarInformacionEssers(cadenas);
            }
        }

        System.out.println("        Raza: Andorians");
        if (poblacio_andorians.isEmpty() == false) {
            for (Andorians tipo : poblacio_andorians) {
                cadenas.clear();
                cadenas.add("             Nombre: " + tipo.getNom());
                cadenas.add("             Rango: " + tipo.getRango().toString());
                cadenas.add(" ");
                Vistas.mostrarInformacionEssers(cadenas);
            }
        }

        System.out.println("        Raza: Ferengis");
        if (poblacio_ferengi.isEmpty() == false) {
            for (Ferengi tipo : poblacio_ferengi) {
                cadenas.clear();
                cadenas.add("             Nombre: " + tipo.getNom());
                cadenas.add("             Latinum: " + tipo.getLatinum());
                cadenas.add(" ");

                Vistas.mostrarInformacionEssers(cadenas);
            }
        }

        System.out.println("        Raza: Kingons");
        if (poblacio_kingon.isEmpty() == false) {
            for (Kingon tipo : poblacio_kingon) {
                cadenas.clear();
                cadenas.add("             Nombre: " + tipo.getNom());
                cadenas.add("             Fuerza: " + tipo.getFuerza());
                cadenas.add(" ");

                Vistas.mostrarInformacionEssers(cadenas);
            }
        }

        System.out.println("        Raza: Nibiritians");
        if (poblacio_nibirians.isEmpty() == false) {
            for (Nibirians tipo : poblacio_nibirians) {
                cadenas.clear();
                cadenas.add("             Nombre: " + tipo.getNom());
                cadenas.add("                Peix: " + tipo.isPeix());
                cadenas.add(" ");

                Vistas.mostrarInformacionEssers(cadenas);
            }
        }

        System.out.println("        Raza: Vulcanians");
        if (poblacio_vulcanians.isEmpty() == false) {
            for (Vulcanians tipo : poblacio_vulcanians) {
                cadenas.clear();
                cadenas.add("             Nombre: " + tipo.getNom());
                cadenas.add("             Meditacio: " + tipo.getMeditacio());
                cadenas.add(" ");

                Vistas.mostrarInformacionEssers(cadenas);
            }
        }

    }
}
