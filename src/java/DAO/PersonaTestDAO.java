/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author angel
 */
import Interfaces.CRUD;
import Modelos.PersonaTest;
import java.sql.Connection;
import ConexionMysql.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonaTestDAO implements CRUD {

    private Conexion conexion = new Conexion();
    private Connection conexionMysql;
    private PreparedStatement preparedStatement;
    private ResultSet resultados;
    
    private String INSERT = "INSERT INTO personaTest(codigoId, nombre, apellido, sueldo, fechaIngreso)"
            + "VALUES(?,?,?,?,?)";
    private String SELECT = "SELECT * FROM personaTest";
    private String DELETE = "DELETE FROM personaTest WHERE codigoId = ?";
    private String UPDATE = "UPDATE personaTest SET nombre = ?, apellido = ?, sueldo = ? WHERE codigoId = ?";
    
    @Override
    public byte setRegistrar(PersonaTest persona) {
        try {
            this.conexionMysql = this.conexion.getConexionMysql();
            if (this.conexionMysql == null) {
                return 0;
            } else {
                this.preparedStatement = this.conexionMysql.prepareStatement(INSERT);
                this.preparedStatement.setInt(1, persona.getCodigoId());
                this.preparedStatement.setString(2, persona.getNombre());
                this.preparedStatement.setString(3, persona.getApellido());
                this.preparedStatement.setDouble(4, persona.getSueldo());
                Date fecha = new Date();
                Timestamp timestamp = new Timestamp(fecha.getTime());
                Timestamp myTimeStamp= timestamp;
                this.preparedStatement.setTimestamp(5, null);
                this.preparedStatement.executeUpdate();
               
                return 1;
            }
        } catch (Exception e) {
            return 2;
        } finally {
            try {
                this.preparedStatement.close();
                this.conexionMysql.close();
            } catch (Exception e) {
            }
        }
    }

    @Override
    public List<PersonaTest> getListar() {
        List<PersonaTest> lista = new ArrayList<>();
        try {
            this.conexionMysql = this.conexion.getConexionMysql();
            if (this.conexionMysql == null) {
                return null;
            } else {
                this.preparedStatement = this.conexionMysql.prepareStatement(SELECT);
                this.resultados = this.preparedStatement.executeQuery();
                PersonaTest persona;
                while (this.resultados.next()) {
                    persona = new PersonaTest();
                    persona.setCodigoId(this.resultados.getInt("codigoId"));
                    persona.setNombre(this.resultados.getString("nombre"));
                    persona.setApellido(this.resultados.getString("apellido"));
                    persona.setSueldo(this.resultados.getDouble("sueldo"));
                    persona.setFechaIngreso(this.resultados.getTimestamp("fechaIngreso"));
                    lista.add(persona);
                }
            }
            return lista;
        } catch (Exception e) {
            return null;
        } finally {
            try {
                this.preparedStatement.close();
                this.conexionMysql.close();
            } catch (Exception e) {
            }
        }
    }

    @Override
    public byte setEliminarRegistro(Integer codigoId) {
        try {
            this.conexionMysql = this.conexion.getConexionMysql();
            if (this.conexionMysql == null) {
                return 0;
            } else {
                this.preparedStatement = this.conexionMysql.prepareStatement(DELETE);
                this.preparedStatement.setInt(1, codigoId);
                this.preparedStatement.executeUpdate();
                return 1;
            }
        } catch (Exception e) {
            return 2;
        } finally {
            try {
                this.preparedStatement.close();
                this.conexionMysql.close();
            } catch (Exception e) {
            }
        }
    }

    @Override
    public byte setActualizar(PersonaTest persona) {
        try {
            this.conexionMysql = this.conexion.getConexionMysql();
            if (this.conexionMysql == null) {
                return 0;
            } else {
                this.preparedStatement = this.conexionMysql.prepareStatement(UPDATE);
                this.preparedStatement.setString(1, persona.getNombre());
                this.preparedStatement.setString(2, persona.getApellido());
                this.preparedStatement.setDouble(3, persona.getSueldo());
                this.preparedStatement.setInt(4, persona.getCodigoId());
                this.preparedStatement.executeUpdate();
                return 1;
            }
        } catch (Exception e) {
            return 2;
        } finally {
            try {
                this.preparedStatement.close();
                this.conexionMysql.close();
            } catch (Exception e) {
            }
        }
    }

}
