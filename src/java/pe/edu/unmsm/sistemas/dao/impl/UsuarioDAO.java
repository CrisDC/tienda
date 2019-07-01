/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import pe.edu.unmsm.sistemas.configuracion.Conexion;
import pe.edu.unmsm.sistemas.dao.IUsuarioDAO;
import pe.edu.unmsm.sistemas.model.ParametrosSistema;
import pe.edu.unmsm.sistemas.model.Usuario;

/**
 *
 * @author Cristhian
 */
public class UsuarioDAO implements IUsuarioDAO {
    
    private Conexion conexion;
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;

    public UsuarioDAO() {
        this.conexion = Conexion.getConexion(
                ParametrosSistema.DRIVER, 
                ParametrosSistema.URL, 
                ParametrosSistema.CONECTION_USER, 
                ParametrosSistema.CONECTION_PASS);
        this.connection = this.conexion.getCon();    
    }

    @Override
    public Usuario registrar(Usuario object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario actualizar(Usuario object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Usuario object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario buscarUno(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
