/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcalamot.kalamus.model_planetas;

import com.elcalamot.kalamus.controller.ControllerKalamus;
import com.elcalamot.kalamus.exceptions.PlanetaException;
import com.elcalamot.kalamus.model_essers.Andorians;
import com.elcalamot.kalamus.model_essers.Essers;
import com.elcalamot.kalamus.model_essers.Ferengi;
import com.elcalamot.kalamus.model_essers.Humans;
import com.elcalamot.kalamus.model_essers.Klingon;
import com.elcalamot.kalamus.model_essers.Nibirians;
import com.elcalamot.kalamus.model_essers.Vulcanians;
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

        ArrayList<Planeta> planetas = galaxiaplanetas.get(galaxiaexist);
        if (planetas != null) {
            planetas.add(newplaneta);
        }

    }

    public String comprobarGalaxia(String galaxia) throws PlanetaException {
        boolean keyexist = galaxiaplanetas.containsKey(galaxia.toUpperCase());

        if (keyexist == false) {
            return null;
        }

        return galaxia;
    }
    
    public boolean comprobarEsserP(String nomesser, String nomplaneta)throws NullPointerException{
        
        Set<String> keys = galaxiaplanetas.keySet();
        for (String key : keys) {
            ArrayList<Planeta> planetas = galaxiaplanetas.get(key);
            for (Planeta planeta : planetas) {
                if (planeta.getNomplan().equalsIgnoreCase(nomplaneta)) {
                    ArrayList <Essers> arrayessers = planeta.getLista();
                    if(!arrayessers.isEmpty()){
                        for(Essers esser: arrayessers){
                            
                            if (esser instanceof Humans) { Humans huma = (Humans) esser; if(nomesser.equalsIgnoreCase(huma.getNom())){return true;}}
                            else if (esser instanceof Andorians) { Andorians andor = (Andorians) esser; if(nomesser.equalsIgnoreCase(andor.getNom())){return true;}}
                            else if (esser instanceof Ferengi) { Ferengi fer = (Ferengi) esser; if(nomesser.equalsIgnoreCase(fer.getNom())){return true;}}
                            else if (esser instanceof Klingon) { Klingon kin = (Klingon) esser; if(nomesser.equalsIgnoreCase(kin.getNom())){return true;}}
                            else if (esser instanceof Nibirians) { Nibirians nib = (Nibirians) esser; if(nomesser.equalsIgnoreCase(nib.getNom())){return true;}}
                            else if (esser instanceof Vulcanians) { Vulcanians vul = (Vulcanians) esser; if(nomesser.equalsIgnoreCase(vul.getNom())){return true;}}
                    
                        }                    
                    }
                }
            }
        }
        
        return false;
    }

    public String devolverGalaxiaP(String nomplaneta) {
        String galaxia = "";
        Set<String> keys = galaxiaplanetas.keySet();
        for (String key : keys) {
            ArrayList<Planeta> planetas = galaxiaplanetas.get(key);
            for (Planeta planeta : planetas) {
                if (planeta.getNomplan().equalsIgnoreCase(nomplaneta)) {
                    galaxia = key;
                }
            }
        }
        return galaxia;
    }

    /* public Planeta comprobarPlaneta(String nomplaneta) throws PlanetaExcepcio {
        ArrayList<Planeta> listaplanetas = galaxiaplanetas.get(galaxia.toUpperCase());
        if(listaplanetas == null){
            return null;
        }

        for (Planeta elplaneta : listaplanetas) {
            if (elplaneta.getNomplan().equalsIgnoreCase(nomplaneta.toLowerCase())) {
                return elplaneta;
            }
        }

        return null;

    } */
    public Planeta comprobarPlaneta(String nomplaneta) throws NullPointerException {
        Set<String> keys = galaxiaplanetas.keySet();
        for (String key : keys) {
            ArrayList<Planeta> planetas = galaxiaplanetas.get(key);
            if(!planetas.isEmpty()){
                for (Planeta planeta : planetas) {
                    if (planeta.getNomplan().equalsIgnoreCase(nomplaneta)) {
                    
                        return planeta;
                    }
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
