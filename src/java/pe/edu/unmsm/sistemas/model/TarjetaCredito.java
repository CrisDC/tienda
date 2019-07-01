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
public class TarjetaCredito extends Tarjeta {
    
    private String numeroDocumento;
    private String limiteCrediticio;

    /**
     * @return the numeroDocumento
     */
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    /**
     * @param numeroDocumento the numeroDocumento to set
     */
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    /**
     * @return the limiteCrediticio
     */
    public String getLimiteCrediticio() {
        return limiteCrediticio;
    }

    /**
     * @param limiteCrediticio the limiteCrediticio to set
     */
    public void setLimiteCrediticio(String limiteCrediticio) {
        this.limiteCrediticio = limiteCrediticio;
    }
    
}
