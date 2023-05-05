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
import java.util.ArrayList;

/**
 *
 * @author A200238614
 */
public class FuncionesModelo_Essers {

    public static String getGenere(boolean opcio, String mensaje) {
        if (opcio == true) {
            return "maculino";
        } else if (opcio == false) {
            return "femenino";
        } else {
            System.out.println(mensaje);
        }

        return "femenino";

    }

    public static boolean elegirGenere(String opcio, String mensaje) {
        if (opcio.equalsIgnoreCase("masculino")) {
            return true;
        } else if (opcio.equalsIgnoreCase("femenino")) {
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
        if(destino.getFlora_vermella() == false){
            return false;
        }
        if(nib.isPeix() == true && destino.getEssers_aquatics() == false){
            return false;
        }
        
        return true;
    }
}
