/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.service.impl;

import pe.edu.unmsm.sistemas.model.Tarjeta;
import pe.edu.unmsm.sistemas.service.IPagoService;

/**
 *
 * @author Cristhian
 */
public class PagoTarjetaService implements IPagoService {
    
    Tarjeta tarjeta;

    public PagoTarjetaService(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }
    
    @Override
    public boolean pagar(Double monto) {
        //se debe implementar lógica de pago tarjeta (debito o credito)
        System.out.println("SE PAGÓ CON TARJETA");
        return true;
    }
    
}
