/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.modelo;

import ventas.modelo.*;
import ventas.controlador.clselectrodomesticos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoelectrodomesticos {

    private static final String SQL_SELECT = "SELECT elecid, elecmarca, electipo, elecprecio  FROM tbl_electrodomesticos";
    private static final String SQL_INSERT = "INSERT INTO tbl_electrodomesticos(elecmarca,electipo, elecprecio) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_electrodomesticos SET elecmarca=?, electipo=?, elecprecio=? WHERE elecid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_electrodomesticos WHERE elecid=?";
    private static final String SQL_QUERY = "SELECT  elecid, elecmarca, electipo,elecprecio FROM tbl_electrodomesticos WHERE elecid = ?";

    public List<clselectrodomesticos> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clselectrodomesticos eletrodomestico = null;
        List<clselectrodomesticos> eletrodomesticos = new ArrayList<clselectrodomesticos>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("elecid");
                String marca = rs.getString("elecmarca");
                String tipo = rs.getString("electipo");
                 String precio = rs.getString("elecprecio");
               
                

                eletrodomestico = new clselectrodomesticos();
                eletrodomestico.setelecid(id);
                eletrodomestico.setelecmarca(marca);
                eletrodomestico.setelectipo(tipo);
                eletrodomestico.setelecprecio(precio);
                          
                eletrodomesticos.add(eletrodomestico);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return eletrodomesticos;
    }

    public int insert(clselectrodomesticos eletrodomestico) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, eletrodomestico.getelecmarca());
            stmt.setString(2, eletrodomestico.getelectipo());
            stmt.setString(3, eletrodomestico.getelecprecio());
       
            

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

    public int update(clselectrodomesticos eletrodomestico) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            
         
            stmt.setString(1, eletrodomestico.getelecmarca());
            stmt.setString(2, eletrodomestico.getelectipo());
            stmt.setString(3, eletrodomestico.getelecprecio());
            stmt.setInt(4, eletrodomestico.getelecid());
            
            
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

    public int delete(clselectrodomesticos eletrodomestico) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, eletrodomestico.getelecid());
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

    public clselectrodomesticos query(clselectrodomesticos eletrodomestico) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, eletrodomestico.getelecid());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("elecid");
                String marca = rs.getString("elecmarca");
                String tipo = rs.getString("electipo");
                String precio = rs.getString("elecprecio");
      

                eletrodomestico = new clselectrodomesticos();
                eletrodomestico.setelecid(id);
                eletrodomestico.setelecmarca(marca);
                eletrodomestico.setelectipo(tipo);
                eletrodomestico.setelectipo(precio);
              
                
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
        return eletrodomestico;
    }
}
