/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.unmsm.sistemas.configuracion.Conexion;
import pe.edu.unmsm.sistemas.dao.IItemDAO;
import pe.edu.unmsm.sistemas.model.Item;
import pe.edu.unmsm.sistemas.model.ParametrosSistema;

/**
 *
 * @author Cristhian
 */
public class ItemDAO implements IItemDAO {

    private final Conexion conexion;
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;

    public ItemDAO() {
        this.conexion = Conexion.getConexion(
                ParametrosSistema.DRIVER, 
                ParametrosSistema.URL, 
                ParametrosSistema.CONECTION_USER, 
                ParametrosSistema.CONECTION_PASS);
        this.connection = this.conexion.getCon();    
    }
    
    @Override
    public Item registrar(Item object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Item actualizar(Item object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Item object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Item> buscarTodos() {
        List<Item> items = null;
        try {
            this.ps = this.connection.prepareStatement("SELECT * FROM PRODUCT");
            
            this.rs = ps.executeQuery();
            items = new ArrayList<>();
            Item item;
            while (rs.next()) {                
                item = new Item();
                item.setiProduct_id(rs.getInt("PRODUCT_ID"));
                item.setProductCode(rs.getString("PRODUCT_CODE"));
                item.setiCantidad(rs.getInt("QUANTITY_ON_HAND"));
                item.setiPrecio(rs.getFloat("PURCHASE_COST"));
                item.setDescripcion(rs.getString("DESCRIPTION"));
                items.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return items;
    }

    @Override
    public Item buscarUno(String id) {
        Item item = null;
        try {
            this.ps = this.connection.prepareStatement("SELECT * FROM PRODUCT WHERE PRODUCT_ID = ?");
            this.ps.setInt(1, Integer.parseInt(id));
            
            this.rs = ps.executeQuery();
            
            if (rs.next()) {                
                item = new Item();
                item.setiProduct_id(rs.getInt("PRODUCT_ID"));
                item.setProductCode(rs.getString("PRODUCT_CODE"));
                item.setiCantidad(rs.getInt("QUANTITY_ON_HAND"));
                item.setiPrecio(rs.getFloat("PURCHASE_COST"));
                item.setDescripcion(rs.getString("DESCRIPTION"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return item;
    }
    
}
