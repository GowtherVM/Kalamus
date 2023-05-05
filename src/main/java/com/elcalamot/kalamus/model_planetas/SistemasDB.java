/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcalamot.kalamus.model_planetas;

import com.elcalamot.kalamus.exceptions.PlanetaExcepcio;
import com.elcalamot.kalamus.model_essers.Andorians;
import com.elcalamot.kalamus.model_essers.Essers;
import com.elcalamot.kalamus.model_essers.Ferengi;
import com.elcalamot.kalamus.model_essers.Humans;
import com.elcalamot.kalamus.model_essers.Kingon;
import com.elcalamot.kalamus.model_essers.Nibirians;
import com.elcalamot.kalamus.model_essers.Vulcanians;
import com.elcalamot.kalamus.vistas.Vistas;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Admin
 */
public class SistemasDB {

    private static SistemasDB sistemas = null;
    private HashMap<String, ArrayList<Planeta>> galaxiaplanetas = new HashMap();

    private SistemasDB() {
    }

    public static SistemasDB getInstance() {
        if (sistemas == null) {
            sistemas = new SistemasDB();
        }

        return sistemas;
    }

    public void addGalaxia(String newgalaxia) {

        ArrayList<Planeta> planetas = new ArrayList();
        galaxiaplanetas.put(newgalaxia, planetas);

    }

    public void addPlaneta(String galaxiaexist, Planeta newplaneta) {

        galaxiaplanetas.get(galaxiaexist).add(newplaneta);

    }

    public String comprobarGalaxia(String galaxia) throws PlanetaExcepcio {
        boolean keyexist = galaxiaplanetas.containsKey(galaxia);
        if (keyexist = false) {
            return null;
        }

        return galaxia;
    }

    public Planeta comprobarPlaneta(String nomplaneta, String galaxia) throws PlanetaExcepcio {
        ArrayList<Planeta> listaplanetas = galaxiaplanetas.get(galaxia);

        for (Planeta elplaneta : listaplanetas) {
            if (elplaneta.getNomplan().equalsIgnoreCase(nomplaneta)) {
                return elplaneta;
            }
        }

        return null;

    }

    public void listPlanetas() {
        Set<String> keys = galaxiaplanetas.keySet();
        for (String key : keys) {
            ArrayList<Planeta> planetas = galaxiaplanetas.get(key);
            for (Planeta planeta : planetas) {
                Vistas.mostrarPlaneta(planeta);
            }
        }
    }

    public boolean existeGalaxia(String galaxia) {
        return galaxiaplanetas.containsKey(galaxia);
    }

    public boolean existePlaneta(Planeta planeta) {
        return galaxiaplanetas.containsValue(planeta);
    }

    public void listEssers() {
        Set<String> keys = galaxiaplanetas.keySet();
        for (String key : keys) {
            ArrayList<Planeta> planetas = galaxiaplanetas.get(key);
            System.out.println("Galaxia:" + key);
            for (Planeta planeta : planetas) {
                ArrayList<Humans> poblacio_humans = planeta.getLista();
                ArrayList<Andorians> poblacio_andorians = planeta.getLista();
                ArrayList<Ferengi> poblacio_ferengi = planeta.getLista();
                ArrayList<Kingon> poblacio_kingon = planeta.getLista();
                ArrayList<Nibirians> poblacio_nibirians = planeta.getLista();
                ArrayList<Vulcanians> poblacio_vulcanians = planeta.getLista();
                System.out.println("    Planeta: "+planeta.getNomplan());
                System.out.println("        Raza: Humas");
                if(poblacio_humans.isEmpty() == false){for (Humans tipo : poblacio_humans) {Vistas.mostrarHumans(tipo);}}
                System.out.println("        Raza: Andorians");
                if(poblacio_andorians.isEmpty() == false){for (Andorians tipo : poblacio_andorians) {Vistas.mostrarAndorians(tipo);}}
                System.out.println("        Raza: Ferengis");
                if(poblacio_ferengi.isEmpty() == false){for (Ferengi tipo : poblacio_ferengi) {Vistas.mostrarFerengi(tipo);}}
                System.out.println("        Raza: Kingons");
                if(poblacio_kingon.isEmpty() == false){for (Kingon tipo : poblacio_kingon) {Vistas.mostrarKlingon(tipo);}}
                System.out.println("        Raza: Nibiritians");
                if(poblacio_nibirians.isEmpty() == false){for (Nibirians tipo : poblacio_nibirians) {Vistas.mostrarNibirians(tipo);}}
                System.out.println("        Raza: Vulcanians");
                if(poblacio_vulcanians.isEmpty() == false){for (Vulcanians tipo : poblacio_vulcanians) {Vistas.mostrarVulcanians(tipo);}}
               
            }
        }
    }

}


