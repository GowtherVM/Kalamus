/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcalamot.kalamus.model_planetas;

import com.elcalamot.kalamus.controller.ControllerKalamus;
import com.elcalamot.kalamus.exceptions.PlanetaExcepcio;
import com.elcalamot.kalamus.model_essers.Andorians;
import com.elcalamot.kalamus.model_essers.Essers;
import com.elcalamot.kalamus.model_essers.Ferengi;
import com.elcalamot.kalamus.model_essers.Humans;
import com.elcalamot.kalamus.model_essers.Klingon;
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
    
    public Planeta devolverPlaneta(String nomplaneta){
        Set<String> keys = galaxiaplanetas.keySet();
        for (String key : keys) {
            ArrayList<Planeta> planetas = galaxiaplanetas.get(key);
            for (Planeta planeta : planetas) {
                if(planeta.getNomplan().equalsIgnoreCase(nomplaneta)){
                    return planeta;
                }
            }
        }
        return null;
    }

    public void listPlanetas() {
        Set<String> keys = galaxiaplanetas.keySet();
        for (String key : keys) {
            ArrayList<Planeta> planetas = galaxiaplanetas.get(key);
            for (Planeta planeta : planetas) {
               ControllerKalamus.generarCadenasPlanetas(planeta);
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
                ControllerKalamus.generarCadenasEssers(planeta);

            }
        }
    }

}
