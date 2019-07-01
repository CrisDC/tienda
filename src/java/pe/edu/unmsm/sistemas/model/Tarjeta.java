/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.model;

/**
 *
 * @author Cristhian
 */
public class Tarjeta {
    
    private String numeroTarjeta;
    private int cvv;
    private String fechaExpiracion;
    private String tarjetaHabiente;
    private String membresia;

    /**
     * @return the numeroTarjeta
     */
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     * @param numeroTarjeta the numeroTarjeta to set
     */
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    /**
     * @return the cvv
     */
    public int getCvv() {
        return cvv;
    }

    /**
     * @param cvv the cvv to set
     */
    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    /**
     * @return the fechaExpiracion
     */
    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    /**
     * @param fechaExpiracion the fechaExpiracion to set
     */
    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    /**
     * @return the tarjetaHabiente
     */
    public String getTarjetaHabiente() {
        return tarjetaHabiente;
    }

    /**
     * @param tarjetaHabiente the tarjetaHabiente to set
     */
    public void setTarjetaHabiente(String tarjetaHabiente) {
        this.tarjetaHabiente = tarjetaHabiente;
    }

    /**
     * @return the membresia
     */
    public String getMembresia() {
        return membresia;
    }

    /**
     * @param membresia the membresia to set
     */
    public void setMembresia(String membresia) {
        this.membresia = membresia;
    }
    
}
