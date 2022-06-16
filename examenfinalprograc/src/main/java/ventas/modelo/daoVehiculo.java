/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.modelo;

import rrhh.modelo.*;
import ventas.controlador.clsVehiculo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoVehiculo {

    private static final String SQL_SELECT = "SELECT vehiid, vehimarca, vehimodelo, vehicolor, vehitipo FROM tbl_vehiculos";
    private static final String SQL_INSERT = "INSERT INTO tbl_vehiculos(vehimarca,vehimodelo, vehicolor, vehitipo) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_vehiculos SET vehimarca=?, vehimodelo=?, vehicolor=?,vehitipo=? WHERE vehiid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_vehiculos WHERE vehiid=?";
    private static final String SQL_QUERY = "SELECT  vehiid, vehimarca, vehimodelo,vehicolor, vehitipo FROM tbl_vehiculos WHERE vehiid = ?";

    public List<clsVehiculo> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsVehiculo vehiculo = null;
        List<clsVehiculo> vehiculos = new ArrayList<clsVehiculo>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("vehiid");
                String marca = rs.getString("vehimarca");
                String modelo = rs.getString("vehimodelo");
                 String color = rs.getString("vehicolor");
                 String tipo = rs.getString("vehitipo");
                

                vehiculo = new clsVehiculo();
                vehiculo.setvehiid(id);
                vehiculo.setvehimarca(marca);
                vehiculo.setvehimodelo(modelo);
                vehiculo.setvehicolor(color);
                vehiculo.setvehitipo(tipo);
                
                vehiculos.add(vehiculo);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return vehiculos;
    }

    public int insert(clsVehiculo vehiculo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, vehiculo.getvehimarca());
            stmt.setString(2, vehiculo.getvehimodelo());
            stmt.setString(3, vehiculo.getvehicolor());
            stmt.setString(4, vehiculo.getvehitipo());
            

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int update(clsVehiculo vehiculo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            
         
            stmt.setString(1, vehiculo.getvehimarca());
            stmt.setString(2, vehiculo.getvehimodelo());
            stmt.setString(3, vehiculo.getvehicolor());
            stmt.setString(4, vehiculo.getvehitipo());
            stmt.setInt(5, vehiculo.getvehiid());
            
            
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int delete(clsVehiculo vehiculo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, vehiculo.getvehiid());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public clsVehiculo query(clsVehiculo vehiculo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, vehiculo.getvehiid());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("vehiid");
                String marca = rs.getString("vehimarca");
                String modelo = rs.getString("vehimodelo");
                String color = rs.getString("vehicolor");
                String tipo = rs.getString("vehitipo");

                vehiculo = new clsVehiculo();
                vehiculo.setvehiid(id);
                vehiculo.setvehimarca(marca);
                vehiculo.setvehimodelo(modelo);
                vehiculo.setvehimodelo(color);
                vehiculo.setvehimodelo(tipo);
                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return vehiculo;
    }
}
