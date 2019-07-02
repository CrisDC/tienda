/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.service.impl;

import java.util.List;
import pe.edu.unmsm.sistemas.model.Item;
import pe.edu.unmsm.sistemas.service.ICarritoService;
import pe.edu.unmsm.sistemas.util.Carrito;
import pe.edu.unmsm.sistemas.service.IComando;

/**
 *
 * @author Cristhian
 */
public class CarritoService implements ICarritoService {

    @Override
    public List<Item> agregarItems(Carrito carrito, Item item) {
        IComando comando = new addItemTo(carrito,item);
        comando.ejecutar();
        //carrito.agregarItemCarrito(item);
        return carrito.getCarrito();
    }

    @Override
    public void eliminarItem(Carrito carrito, Item item) {
        IComando comando = new removeItemTo(carrito,item);
        comando.ejecutar();
    }

    @Override
    public List<Item> listarItems(Carrito carrito) {
        return carrito.getCarrito();
    }
    
}
