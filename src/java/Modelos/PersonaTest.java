/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author angel
 */
import java.sql.Timestamp;

public class PersonaTest {
    
    private int codigoId;
    private String nombre;
    private String apellido;
    private double sueldo;
    private Timestamp fechaIngreso;

    public PersonaTest() {
        this.codigoId = -1;
        this.nombre = this.apellido = "";
        this.sueldo = 0;
        this.fechaIngreso = null;
    }

    public int getCodigoId()    { return codigoId; }
    public String getNombre()   { return nombre;   }
    public String getApellido() { return apellido; }
    public double getSueldo()   { return sueldo;   }
    public Timestamp getFechaIngreso() { return fechaIngreso; }
    
    public void setCodigoId(int codigoId)    { this.codigoId = codigoId; }
    public void setNombre(String nombre)     { this.nombre = nombre;     }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setSueldo(double sueldo)     { this.sueldo = sueldo;     }
    public void setFechaIngreso(Timestamp fec) { this.fechaIngreso = fec;}
}
