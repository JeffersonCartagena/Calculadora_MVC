package modelo;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Pato
 */
public class OperacionDAO {

    //xona de atributos
    private CinexionBd conecta;

    //constructor
    public OperacionDAO(String jdbcURL, String jdbcUSERName, String jdbcPassword) throws SQLException {
        conecta = new CinexionBd(jdbcURL, jdbcUSERName, jdbcPassword);
    }

    // metodo para insertar en la base de datos
    public boolean registrar(Operacion objop) {

        boolean estado = false;//variable para insertar la inserccion de datos  
        Statement stm; //interpreta cod SQL desde JAVA
        String sql = "insert into operacion values(null, '" + objop.getDato1() + "', '" + objop.getDato2() + "', '" + objop.getResultado()+ "', '"+objop.getOperacion()+"');";
        try {
            conecta.connection();//abrir la conexion
            stm = conecta.getJdbcConnection().createStatement();
            stm.executeUpdate(sql); //ejecuto el script de la variable SQL
            estado = true; // si se ejecuta la inserccion 
            stm.close();
            conecta.disconnect();// cierra la conexion

        } catch (SQLException objerr) {
            estado = false;// no se ejecuto la inserccion
            objerr.printStackTrace();//imprimo toda la traza del error
        }
        return estado;
    }

    // metodo para hacer reportes
    public ArrayList SeleccionarTodo() {
        //xona de objetos
        Operacion objDAOdatos = null; //declaro obj q trabaja con el DAO
        ArrayList<Operacion> arrayDAOdatos = new ArrayList<>(); // declaro array q va a recibir la consulta desde la base
        Statement stm;//interpreta sql desde java
        ResultSet resConsulta = null; // para recibir cada registro de la base
        String sql = "SELECT * FROM operacion;";
        try {
            conecta.connection(); //abrir conexion
            stm = conecta.getJdbcConnection().createStatement();
            resConsulta = stm.executeQuery(sql);
            while (resConsulta.next()) {//mientras haya datos en el resultset recoorrer
                objDAOdatos = new Operacion(resConsulta.getInt("idOperacion"), resConsulta.getDouble("dato1"), resConsulta.getDouble("dato2"), resConsulta.getDouble("resultado"), resConsulta.getString("operacion"));

                arrayDAOdatos.add(objDAOdatos);//agrego una fila al array con el registro extraido
            }
            stm.close();
            conecta.disconnect();

        } catch (SQLException e) {
            e.printStackTrace();//imprimo toda la traza del error en el servidor
        }
        return arrayDAOdatos;
    }

    public ArrayList SeleccioneUno(int id) {
        //xona de objetos
        Operacion objDAOdatos = null; //declaro obj q trabaja con el DAO
        ArrayList<Operacion> arrayDAOdatos = new ArrayList<>(); // declaro array q va a recibir la consulta desde la base
        Statement stm;//interpreta sql desde java
        ResultSet resConsulta = null; // para recibir cada registro de la base
        String sql = "SELECT * FROM operacion where idOperacion = " + id;
        try {
            conecta.connection(); //abrir conexion
            stm = conecta.getJdbcConnection().createStatement();
            resConsulta = stm.executeQuery(sql);
            while (resConsulta.next()) {//mientras haya datos en el resultset recoorrer
                objDAOdatos = new Operacion(resConsulta.getInt("idOperacion"), resConsulta.getDouble("dato1"), resConsulta.getDouble("dato2"), resConsulta.getDouble("resultado"), resConsulta.getString("operacion"));

                arrayDAOdatos.add(objDAOdatos);//agrego una fila al array con el registro extraido
            }
            stm.close();
            conecta.disconnect();

        } catch (SQLException e) {
            e.printStackTrace();//imprimo toda la traza del error en el servidor
        }
        return arrayDAOdatos;
    }
    //metodo para elminar

    public boolean Eliminar(Operacion objborr) {
        boolean estado = false;
        Statement stm;
        String sql = "delete from operacion where idOperacion = " + objborr.getIdOperacion();
        try {
            conecta.connection();
            stm = conecta.getJdbcConnection().createStatement();
            stm.executeUpdate(sql);
            estado = true;
            stm.close();
            conecta.disconnect();
        } catch (SQLException e) {
            estado = false;
            e.printStackTrace();
        }
        return estado;
    }

    public boolean Actualizar(Operacion objedi) {
        boolean estado = false;
        Statement stm;
        String sql = "update operacion set dato1 = '" + objedi.getDato1() + "' where idOperacion = " + objedi.getIdOperacion();
        try {
            conecta.connection();
            stm = conecta.getJdbcConnection().createStatement();
            stm.executeUpdate(sql);
            estado = true;
            stm.close();
            conecta.disconnect();
        } catch (SQLException e) {
            estado = false;
            e.printStackTrace();
        }
        return estado;

    }
      public boolean ActualizarTodo (Operacion objedi) {
        boolean estado = false;
        Statement stm;
        String sql = "update operacion set dato1 = '"+objedi.getDato1()+"', dato2 = '"+objedi.getDato2()+"', resultado = '"+objedi.getResultado()+"' where idOperacion = "+objedi.getIdOperacion();
        try {
            conecta.connection();
            stm = conecta.getJdbcConnection().createStatement();
            stm.executeUpdate(sql);
            estado = true;
            stm.close();
            conecta.disconnect();
        } catch (SQLException e) {
            estado = false;
            e.printStackTrace();
        }
        return estado;

    }
    

}
