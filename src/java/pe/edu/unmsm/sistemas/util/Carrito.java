/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LaboratorioFISI
 */
public class Carrito {
    private List<Item> carrito = new ArrayList();

    public List<Item> getCarrito() {
        return carrito;
    }

    public void setCarrito(List carrito) {
        this.carrito = carrito;
    }
    public int buscarItemCarrito(int idItem) {
        int result =-1;
        if(carrito.size()>0){
            for( int i=0;i<carrito.size();i++){
                if(carrito.get(i).getiProduct_id()==idItem){
                    result=i;
                    break;
                }
            }
        }
        return result;
    }
    public void agregarItemCarrito(Item item) {
        //Busca si el item existe en el carrito
        System.out.println("Id Item:"+item.getiProduct_id());
        int index=this.buscarItemCarrito(item.getiProduct_id());
        System.out.println("Index:"+index);
        // Si existe
        if(index!=-1){
            Item i =carrito.get(index);
            //incrementamos su cantidad en 1
            i.setiCantidad(i.getiCantidad()+1);
            carrito.set(index, i);
        }else{
        //Si no existe lo añade
            carrito.add(item);
        }
    }
    public void eliminarItemCarrito(Item item) {
        //Busca si el item existe en el carrito
        int index=this.buscarItemCarrito(item.getiProduct_id());
        //Si existe
        if(index!=-1){
            Item i =carrito.get(index);
            //Disminuimos en uno su cantidad
            i.setiCantidad(i.getiCantidad()-1);
            //Si al disminuir su cantidad se hace 0
            if(i.getiCantidad()<=0){
                //Lo quitamos del carrito
                carrito.remove(index);
            }else{
                //Sino solo modificamos el elemento
                carrito.set(index, i);
            }     
        }else{
            //Sino indicamos que no existe
            System.out.println("El item no existe en el carrito");
        }
    }

    @Override
    public String toString() {
        return "Carrito{" + "carrito=" + carrito + '}';
    }
    
    
    
}
