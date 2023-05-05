/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elcalamot.kalamus.model_essers;

import com.elcalamot.kalamus.enums.Enums;
import com.elcalamot.kalamus.enums.Enums.Categoria;
import com.elcalamot.kalamus.enums.Enums.Esser;

/**
 *
 * @author A200238614
 */
public class Essers {
    
    private Esser esser;
    private Categoria categoria;

    public Essers(String esser) {
        
        this.esser = Enums.elegirEsser(esser);
        this.categoria = Enums.elegirCategoria(this.esser); 
               
    }

    public Esser getEsser() {
        return esser;
    }

    public void setEsser(Esser esser) {
        this.esser = esser;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
    
    
}
