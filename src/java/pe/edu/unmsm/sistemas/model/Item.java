/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.model;

/**
 *
 * @author LaboratorioFISI
 */
public class Item {
    private int iProduct_id;
    private float iPrecio;
    private int iCantidad;
    private String descripcion;
    private String productCode;

    public int getiProduct_id() {
        return iProduct_id;
    }

    public void setiProduct_id(int iProduct_id) {
        this.iProduct_id = iProduct_id;
    }

    public float getiPrecio() {
        return iPrecio;
    }

    public void setiPrecio(float iPrecio) {
        this.iPrecio = iPrecio;
    }

  

    public int getiCantidad() {
        return iCantidad;
    }

    public void setiCantidad(int iCantidad) {
        this.iCantidad = iCantidad;
    }

    @Override
    public String toString() {
        return "Item{" + "iProduct_id=" + iProduct_id + ", iPrecio=" + iPrecio + ", iCantidad=" + iCantidad + '}';
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the productCode
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * @param productCode the productCode to set
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    
    
}
