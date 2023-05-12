/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.elcalamot.kalamus;

import com.elcalamot.kalamus.controller.ControllerKalamus;
import com.elcalamot.kalamus.exceptions.PlanetaException;

import com.elcalamot.kalamus.model_planetas.SistemasDB;
import com.elcalamot.kalamus.persistencia.Persistencia;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) throws IOException, FileNotFoundException, PlanetaException {
        
        SistemasDB sistemas = SistemasDB.getInstance();
        Persistencia pers = new Persistencia();
        
        pers.comprobarRuta("/planets",".csv");
        pers.comprobarRuta("/beings",".csv");

        // FuncionesModelo_Planetas.testsPlanetas();
        // FuncionesModelo_Essers.testEssers();
        

        pers.generarDBP();
        pers.generarDBE();

        
        ControllerKalamus controller = new ControllerKalamus(sistemas, pers);
        
       
        controller.iniciarKalamus(args);
        
        
    }
}
