/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcalamot.kalamus.enums;


/**
 *
 * @author Admin
 */
public class Enums {

    public static enum Clima {
        FRED, CALID, TEMPERAT
    };

    public static enum Esser {
        HUMANS,VULCANIANS,ANDORIANS,NIBIRIANS,KLINGON,FERENGI
    };
    
    public static enum Categoria {
        I,II,III,O
    };
    
    public static enum Rango {
        DEFENSOR,ENTRENADOR,LLUITADOR,CAVALLER
    };

    public static Clima elegirClima(String clima){
        Clima nuevoclima = Clima.TEMPERAT;

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
                System.out.println("No existe ese clima. Se assignara temperat.");
        }

        return nuevoclima;
    }
    
    public static Esser elegirEsser(String nombre){
        Esser nuevoesser = Esser.HUMANS;
        
        switch (nombre.toLowerCase()) {
            case "humans":
                nuevoesser = Esser.HUMANS;
                break;
            case "vulcanians":
                nuevoesser = Esser.VULCANIANS;
                break;
            case "andorians":
                nuevoesser = Esser.ANDORIANS;
                break;
            case "nibirians":
                nuevoesser = Esser.NIBIRIANS;
                break;
            case "klingon":
                nuevoesser = Esser.KLINGON;
                break;
            case "ferengi":
                nuevoesser = Esser.FERENGI;
                break;
            default:
                System.out.println("El esser no existe. Se assignara human.");
                
        }
        
        
        return nuevoesser;
        
    }
    
    public static Categoria elegirCategoria(Esser especie){
        Categoria sucategoria = Categoria.O;
        
        switch (especie) {
            case HUMANS,FERENGI:
                sucategoria = Categoria.I;
                break;
            case VULCANIANS,KLINGON:
                sucategoria = Categoria.III;
                break;
            case ANDORIANS,NIBIRIANS:
                sucategoria = Categoria.II;
                break;
            default:
                System.out.println("El esser no li correspon cap catgoria. Es quedara amb O.");
        }
        
        return sucategoria;
    }

    public static Rango elegirRango(String rango){
        switch (rango.toLowerCase()){
            case "defensor":
                return Rango.DEFENSOR;
            case "lluitador":
                return Rango.LLUITADOR;
            case "cavaller":
                return Rango.CAVALLER;
            case "entrenador":
                return Rango.ENTRENADOR;
            default:
                System.out.println("Rango incorrecto, se assigna Entrenador.");
                
        }
          
        return Rango.ENTRENADOR;
    }

}
