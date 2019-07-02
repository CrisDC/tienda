/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.dao;

import java.util.List;
import pe.edu.unmsm.sistemas.model.Item;

/**
 *
 * @author Cristhian
 */
public interface IItemDAO extends IMantenibleDAO<Item> {
    public List<Item> buscarDisponibles() ;
}
