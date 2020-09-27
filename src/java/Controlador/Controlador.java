/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.PersonaTestDAO;
import Modelos.PersonaTest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author angel
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    private PersonaTestDAO personaDAO = new PersonaTestDAO();
    private PersonaTest persona = new PersonaTest();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");

        switch (accion) {
            case "POST":
                persona.setCodigoId(Integer.parseInt(request.getParameter("codigo")));
                persona.setNombre(request.getParameter("nombre"));
                persona.setApellido(request.getParameter("apellido"));
                persona.setSueldo(Double.parseDouble(request.getParameter("sueldo")));
                byte respuesta = personaDAO.setRegistrar(persona);
                try (PrintWriter out = response.getWriter()) {
                    out.print(respuesta);
                }
                break;
            case "Listar":
                List lista = personaDAO.getListar();
                request.setAttribute("persona", lista);
                RequestDispatcher vista = request.getRequestDispatcher("index.jsp");
                vista.forward(request, response);
                break;
            case "DELETE":
                int codigoId = Integer.parseInt(request.getParameter("codigoId"));
                byte respuestaEliminar = this.personaDAO.setEliminarRegistro(codigoId);
                try (PrintWriter out = response.getWriter()) {
                    out.print(respuestaEliminar);
                }
                break;
            case "PUT":
                persona.setCodigoId(Integer.parseInt(request.getParameter("codigo")));
                persona.setNombre(request.getParameter("nombre"));
                persona.setApellido(request.getParameter("apellido"));
                persona.setSueldo(Double.parseDouble(request.getParameter("sueldo")));
                byte respuestaPut = personaDAO.setActualizar(persona);
                try (PrintWriter out = response.getWriter()) {
                    out.print(respuestaPut);
                }
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
