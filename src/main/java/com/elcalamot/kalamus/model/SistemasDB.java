/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcalamot.kalamus.model;

import com.elcalamot.kalamus.exceptions.PlanetaExcepcio;
import com.elcalamot.kalamus.vistas.Vistas;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Admin
 */
public class SistemasDB {
    private static SistemasDB sistemas = null;
    private HashMap <String, ArrayList<Planeta>> galaxiaplanetas = new HashMap();
    
    private SistemasDB(){}
    
    public static SistemasDB getInstance(){
       if (sistemas == null){
           sistemas = new SistemasDB();
       }
       
       return sistemas;
    }
    
    public void addGalaxia(String newgalaxia){
        
        ArrayList <Planeta> planetas = new ArrayList();      
        galaxiaplanetas.put(newgalaxia, planetas);

        
    }
    
    public void addPlaneta(String galaxiaexist, Planeta newplaneta){
        
        galaxiaplanetas.get(galaxiaexist).add(newplaneta);
            
        }
    
    public String comprobarGalaxia(String galaxia) throws PlanetaExcepcio{
        boolean keyexist = galaxiaplanetas.containsKey(galaxia);
        if (keyexist = false){
            return null;
        }
        
        return galaxia;
    }
    
    public Planeta comprobarPlaneta(String nomplaneta, String galaxia)throws PlanetaExcepcio{
            ArrayList <Planeta> listaplanetas = galaxiaplanetas.get(galaxia);
            
            for(Planeta elplaneta: listaplanetas){
                if(elplaneta.getNomplan().equalsIgnoreCase(nomplaneta)){
                    return elplaneta;
                }
            }
            
            return null;
        
    } 
    
    public void listPlanetas(){
       Set <String> keys = galaxiaplanetas.keySet();
       for(String key: keys){          
           ArrayList <Planeta> planetas = galaxiaplanetas.get(key);
           for(Planeta planeta: planetas){
               Vistas.mostrarPlaneta(planeta);
           }
       }
    }
        

    
 
}
