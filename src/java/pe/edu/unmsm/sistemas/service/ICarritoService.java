/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.service;

import java.util.List;
import pe.edu.unmsm.sistemas.model.Item;
import pe.edu.unmsm.sistemas.util.Carrito;

/**
 *
 * @author Cristhian
 */
public interface ICarritoService {
    
    List<Item> agregarItems(Carrito carrito, Item item);
    
    void eliminarItem(Carrito carrito, Item item);
    
    List<Item> listarItems(Carrito carrito);
    
}
