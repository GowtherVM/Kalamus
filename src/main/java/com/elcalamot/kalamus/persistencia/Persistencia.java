/*+
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcalamot.kalamus.persistencia;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Admin
 */
public class Persistencia {
    

    public void comprobarRuta(String nombre, String extension) throws IOException {

        File file = new File(crearRuta(nombre,extension));

        if (!file.exists()) {
            file.createNewFile();

        }

    }

    public void anadirPokedom(String ruta, String contenido) throws IOException {
        File file = new File(ruta);
        FileWriter archivo = new FileWriter(file, true);
        PrintWriter write = new PrintWriter(archivo);
        write.println(contenido);
        write.close();
    }

    public void buscarAlgo(String buscar, File fil) throws FileNotFoundException, IOException {

        BufferedReader archivo = new BufferedReader(new FileReader(fil));
        String linea;

        while ((linea = archivo.readLine()) != null) {
            if (linea.contains(buscar.toUpperCase())) {

                System.out.println(linea);

            }
        }

    }

    public String crearRuta(String nombre, String formato) {     
        String path = System.getProperty("user.home");
        String archivo = path + nombre + formato;
        return archivo;     
    }
}
