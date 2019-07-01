/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.dao;

import java.util.List;

/**
 *
 * @author Cristhian
 * @param <T>
 */
public interface IMantenibleDAO<T> {
    
    T registrar(T object);
    
    T actualizar(T object);
    
    void eliminar(T object);
    
    List<T> buscarTodos();
    
    T buscarUno(String id);
    
}
