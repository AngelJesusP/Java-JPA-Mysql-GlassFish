/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author angel
 */
import java.util.List;
import Modelos.PersonaTest;

public interface CRUD {
    
    public byte setRegistrar(PersonaTest persona);
    public List<PersonaTest> getListar();
    public byte setEliminarRegistro(Integer codigoId);
    public byte setActualizar(PersonaTest persona);
    
}
