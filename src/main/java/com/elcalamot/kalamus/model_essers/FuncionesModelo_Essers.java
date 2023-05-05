/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcalamot.kalamus.model_essers;

import static com.elcalamot.kalamus.enums.Enums.Clima.CALID;
import static com.elcalamot.kalamus.enums.Enums.Clima.FRED;
import static com.elcalamot.kalamus.enums.Enums.Esser.ANDORIANS;
import static com.elcalamot.kalamus.enums.Enums.Esser.VULCANIANS;
import com.elcalamot.kalamus.model_planetas.Planeta;
import com.elcalamot.kalamus.model_planetas.SistemasDB;
import java.util.ArrayList;

/**
 *
 * @author A200238614
 */
public class FuncionesModelo_Essers {
    
    public static void crearEsser(String[] args){
        
    }

    public static String getGenere(boolean opcio) {
        if (opcio == true) {
            return "masculi";
        } else if (opcio == false) {
            return "femeni";
        } 

        return "femenino";

    }
    
    public static String getPeix(boolean opcio) {
        if (opcio == true) {
            return "Si";
        } else if (opcio == false) {
            return "No";
        } 

        return "No";

    }

    public static boolean elegirGenere(String opcio, String mensaje) {
        if (opcio.equalsIgnoreCase("masculi")) {
            return true;
        } else if (opcio.equalsIgnoreCase("femeni")) {
            return false;
        } else {
            System.out.println(mensaje);
        }

        return false;

    }

    public static boolean reglasVA(Essers va, Planeta destino) {
        ArrayList <Essers> poblacion_planeta = destino.getLista();
        switch (va.getEsser()) {
            case VULCANIANS:
                for(Essers esser: poblacion_planeta){
                    if(esser.getEsser() == ANDORIANS){
                        return false;
                    }
                }
                break;
            case ANDORIANS:
                for(Essers esser: poblacion_planeta){
                    if(esser.getEsser() == VULCANIANS){
                        return false;
                    }
                }
                break;
        }

        return true;
    }
    
    public static boolean reglasKlingon(Planeta destino){
        if(destino.getClima() == CALID){
            return false;
        }
        
        return true;
    }
    
    
        public static boolean reglasFerengi(Planeta destino){
        if(destino.getClima() == FRED){
            return false;
        }
        
        return true;
    }
    
    public static boolean reglasNibirians(Nibirians nib, Planeta destino){
        if(destino.getFlora_vermella().equalsIgnoreCase("No")){
            return false;
        }
        if(nib.isPeix().equalsIgnoreCase("Si") && destino.getEssers_aquatics().equalsIgnoreCase("No")){
            return false;
        }
        
        return true;
    }
    
    
    public static void testEssers(){
        SistemasDB sis = SistemasDB.getInstance();
        Planeta pla = sis.devolverPlaneta("Tierra");
        Planeta marte = sis.devolverPlaneta("Marte");
        
        Humans nuevo = new Humans("Sarah","humans",21,"femeni");
        Humans nuevo1 = new Humans("Pau","humans",23,"masculi");
        Klingon nuevo2 =  new Klingon("Eric",5,"klingon");
        
        
        pla.addEsser(nuevo);
        pla.addEsser(nuevo1);
        marte.addEsser(nuevo2);
    }
}
