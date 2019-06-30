/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas;

import pe.edu.unmsm.sistemas.util.Carrito;
import pe.edu.unmsm.sistemas.util.Item;

/**
 *
 * @author mnst4
 */
public class addItemTo implements IComando{

    Carrito carrito;
    Item item;
    
    public addItemTo(Carrito carrito, Item item){
        this.carrito = carrito;
        this.item = item;
    }
    
    @Override
    public void ejecutar() {
        carrito.agregarItemCarrito(item);
    }

    
    
    
    
}
