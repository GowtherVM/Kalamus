
package com.elcalamot.kalamus.exceptions;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author pau
 */
public class PlanetaException extends Exception {
    

    public static final int GALAXIA_EXIST = 0;
    public static final int MUNDO_EXIST = 1;

    
    private final List<String> missatges = Arrays.asList(
            "ERROR: Galaxia existe. ",
            "ERROR: Mundo existe. ");
    
    private final int code;

    public PlanetaException(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return missatges.get(code);
    }
    
}
