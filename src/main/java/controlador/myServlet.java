/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Operacion;
import modelo.OperacionDAO;
import modelo.Procesos;

/**
 *
 * @author Pato
 */
public class myServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //Variables globales
    OperacionDAO test; //objeto
    String mensaje = "Error de conexion"; //variable para enviar mensaje hacia la vista

    // metodo para dar orden de abrir la conexion
    public void init() throws ServletException {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL"); //extraigo el dato
        String jdbcUSERName = getServletContext().getInitParameter("jdbcUSERName"); //extraigo el dato
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword"); //extraigo el dato

        try {
            test = new OperacionDAO(jdbcURL, jdbcUSERName, jdbcPassword);
            mensaje = "Conexion establecida";
        } catch (SQLException ex) {
            Logger.getLogger(myServlet.class.getName()).log(Level.SEVERE, null, ex);;
            mensaje = "Error de conexion";
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet myServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet myServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        // variables 
        ArrayList<Operacion> arrobj = new ArrayList();
        ArrayList<Operacion> arrobjuno = new ArrayList();
        int d;
        int id;
        String z;
        double a, b, e, c = 0;// variables para recibir los datos desde la vista
        String op; //variable recibe la operacion que quiere realizar el usuario
        //zona de captura
        a = Double.parseDouble(request.getParameter("numero1"));//para capturar o recibir datos desde la vista
        b = Double.parseDouble(request.getParameter("numero2"));//para capturar o recibir datos desde la vista
        e = Double.parseDouble(request.getParameter("resultadoTodo"));//para capturar o recibir datos desde la vista
        d = Integer.parseInt(request.getParameter("buscarUno"));
        id = Integer.parseInt(request.getParameter("buscarUno"));
        Procesos objpr = new Procesos(a, b);
        op = request.getParameter("operacion"); // capturo la operacion quiere realizar el usuario
        // zona de proceso
        if (op.equals("Sumar")) {
            // dar orden de sumar
            c = objpr.Suma();
            z = "Suma";
            Operacion objinsertar = new Operacion(0, a, b, c, z); //cargo el obj para el DAO
            if (test.registrar(objinsertar)) {
                mensaje = "La suma se guardo exitosamente";
            } else {
                mensaje = "Error en la inserccion de los datos";
            }
        }
        if (op.equals("Restar")) {
            c = objpr.Resta();
            z = "Resta";
            Operacion objinsertar = new Operacion(0, a, b, c, z); //cargo el obj para el DAO
            if (test.registrar(objinsertar)) {
                mensaje = "La resta se guardo exitosamente";
            } else {
                mensaje = "Error en la inserccion de los datos";
            }
        }
        if (op.equals("Multiplicar")) {
            c = objpr.Multiplicar();
            z = "Multiplicacion";
            Operacion objinsertar = new Operacion(0, a, b, c, z); //cargo el obj para el DAO
            if (test.registrar(objinsertar)) {
                mensaje = "La multiplicacion se guardo exitosamente";
            } else {
                mensaje = "Error en la inserccion de los datos";
            }
        }
        if (op.equals("Dividir")) {
            c = objpr.Dividir();
            z = "Division";
            Operacion objinsertar = new Operacion(0, a, b, c, z); //cargo el obj para el DAO
            if (test.registrar(objinsertar)) {
                mensaje = "La división se guardo exitosamente";
            } else {
                mensaje = "Error en la inserccion de los datos";
            }
        }
        if (op.equalsIgnoreCase("Reporte")) {
            //dar la orden de estraer todo
            arrobj = test.SeleccionarTodo();
        }
        if (op.equalsIgnoreCase("Buscar")) {
            //dar la orden de estraer uno
            arrobjuno = test.SeleccioneUno(d);
        }
        if (op.equalsIgnoreCase("Eliminar")) {
            //dar la orden de eliminar
            Operacion objborr = new Operacion(d, 0, 0, 0, null);
            if (test.Eliminar(objborr)) {
                mensaje = "Registro eliminado";
            } else {
                mensaje = "no se eliminado";
            }
        }
        if (op.equalsIgnoreCase("Actualizar")) {
            //dar la orden de estraer uno
            Operacion obedi = new Operacion(id, a, 0, 0, null);
            if (test.Actualizar(obedi)) {
                mensaje = "Registro actualizado";
            } else {
                mensaje = "Error al actualizar";
            }
        }
        if (op.equalsIgnoreCase("Actualizar Todo")) {
            //dar la orden de estraer uno
            Operacion obedi = new Operacion(id, a, b, e, null);
            if (test.ActualizarTodo(obedi)) {
                mensaje = "Registro actualizado";
            } else {
                mensaje = "Error al actualizar";
            }
        }

        request.setAttribute("cajitarespuesta", "El resultado de la operación es: " + c);
        request.setAttribute("cajitaBD", mensaje);//para enviar los mensajes de la base
        request.setAttribute("cajitaReporte", arrobj);//para enviar los mensajes de la base
        request.setAttribute("cajitaReporteUno", arrobjuno);//para enviar los mensajes de la base
        RequestDispatcher objretorno = request.getRequestDispatcher("index.jsp");
        objretorno.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
