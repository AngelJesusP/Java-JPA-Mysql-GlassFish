/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  angel
 * Created: 22/09/2020
 */

DROP DATABASE IF EXISTS testJPACRUD;
CREATE DATABASE IF NOT EXISTS testJPACRUD;
USE testJPACRUD;

DROP TABLE IF EXISTS personaTest;
CREATE TABLE IF NOT EXISTS personaTest(
    codigoId INT NOT NULL,
    nombre CHAR(30) NOT NULL,
    apellido CHAR(50) NOT NULL,
    sueldo DECIMAL(10.2) NOT NULL,
    fechaIngreso TIMESTAMP NOT NULL,
    PRIMARY KEY(codigoId)
);