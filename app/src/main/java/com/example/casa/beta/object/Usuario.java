package com.example.casa.beta.object;

/**
 * Created by CASA on 18-05-2017.
 */

public class Usuario {
    private static String correo;
    private static String nombre;
    private static String contrasenna;

    public Usuario(String CORREO, String NOMBRE, String CONTRASENNA){
        correo = CORREO;
        nombre = NOMBRE;
        contrasenna = CONTRASENNA;
    }

    public String getCorreo(){return correo;}
    public String getNombre(){return nombre;}
    public String getContra(){return contrasenna;}

}
