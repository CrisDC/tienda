/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.service.impl;

import pe.edu.unmsm.sistemas.model.CredencialesPaypal;
import pe.edu.unmsm.sistemas.service.IPagoService;

/**
 *
 * @author Cristhian
 */
public class PagoPaypalService implements IPagoService{

    CredencialesPaypal credencialesPaypal;

    public PagoPaypalService(CredencialesPaypal credencialesPaypal) {
        this.credencialesPaypal = credencialesPaypal;
    }

    @Override
    public boolean pagar(Double monto) {
        //se debe implementar lógica de pago paypal
        System.out.println("PAGO VIA PAYPAL");
        return true;
    }
    
}
