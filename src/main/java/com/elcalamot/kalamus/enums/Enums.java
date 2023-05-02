/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcalamot.kalamus.enums;

import com.elcalamot.kalamus.exceptions.PlanetaExcepcio;

/**
 *
 * @author Admin
 */


public class Enums {
    
    public static enum Clima{FRED,CALID,TEMPERAT};
    public static enum Respuesta{YES,NO};
    
    
    public static Clima elegirClima(String clima)  throws PlanetaExcepcio{
        Clima nuevoclima = Clima.FRED;
        
                switch (clima.toLowerCase()) {
            case "fred":
                nuevoclima = nuevoclima.FRED;
                break;
            case "calid":
                nuevoclima = nuevoclima.CALID;
                break;
            case "temperat":
                nuevoclima = nuevoclima.TEMPERAT;
                break;
                
            default:
                System.out.println("No existe ese clima");
        }
        
        
    return nuevoclima;
}
    
    public static Respuesta elegirOpcion(String opcio) throws PlanetaExcepcio{
        if(opcio.equalsIgnoreCase("yes")&& opcio.equalsIgnoreCase("no")){
            return Respuesta.valueOf(opcio);
        } else {
            System.out.println("ERROR: Respuesta incorrecta (yes/no).");
        }
        
        return null;
        
}
    
}
