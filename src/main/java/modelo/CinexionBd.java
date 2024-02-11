/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;

/**
 *
 * @author Pato
 */
public class CinexionBd {

    //zona de atributos
    private String jdbcURL;//Cadena de conexion
    private String jdbcUSERName;
    private String jdbcPassword;
    private Connection jdbcConnection;//Objeto para manejar el driver de SGBD
    //constructor para los datos iniciales de los atributos

    public CinexionBd(String jdbcURL, String jdbcUSERName, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUSERName = jdbcUSERName;
        this.jdbcPassword = jdbcPassword;
    }

    //metodo para abrir la conexion
    public void connection() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Conexion exitosa");
            } catch (ClassNotFoundException e) {
                System.out.println("Error de conexion");
                throw new SQLException(e);
            }
            jdbcConnection = (Connection) DriverManager.getConnection(jdbcURL, jdbcUSERName, jdbcPassword); //abre la conexion a la base de datos

        }

    }

    //metodo para cerrar la conexion
    public void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    //metodo para abrir la conexion
    public Connection getJdbcConnection() {
        return jdbcConnection;
    }
}
