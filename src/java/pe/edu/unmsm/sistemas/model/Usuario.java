/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LaboratorioFISI
 */
public class Usuario {
    private String username;
    private String password;
    private boolean sesionActiva;

    public Usuario() {
        this.sesionActiva=false;
    }
    
    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
        this.sesionActiva=false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getSesionActiva() {
        return sesionActiva;
    }

    public void setSesionActiva(boolean sesionActiva) {
        this.sesionActiva = sesionActiva;
    }
    
    
    
    
}
