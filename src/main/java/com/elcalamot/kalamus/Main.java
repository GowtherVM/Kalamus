/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.elcalamot.kalamus;

import com.elcalamot.kalamus.controller.ControllerKalamus;
import com.elcalamot.kalamus.exceptions.DemanarDades;
import com.elcalamot.kalamus.exceptions.PlanetaExcepcio;
import com.elcalamot.kalamus.model.SistemasDB;
import com.elcalamot.kalamus.persistencia.Persistencia;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) throws IOException {
        
        SistemasDB sistemas = SistemasDB.getInstance();
        Persistencia pers = new Persistencia();
        DemanarDades demanar = new DemanarDades();
        
        pers.comprobarRuta("/planets",".csv");
        pers.comprobarRuta("/beings",".csv");
        
        ControllerKalamus controller = new ControllerKalamus(sistemas, pers, demanar);
        
        try{
        controller.iniciarKalamus(args);
        }catch(PlanetaExcepcio a){
            System.out.println("A saltado algo.");
        }
        
    }
}
