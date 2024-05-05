
package modelo;
import vista.inter_producto;

/**
 *
 * @author Renato
 */
public class producto {
    inter_producto pr=new inter_producto();
    //public double pc=Double.parseDouble(pr.tf_precioc.getText());
    private int idProducto;
    private String nombre;
    private int cantidad;
    private double precioventa;
    private String descripcion;
    private double preciocompra;
    private int venta;
    private int idCategoria;
    private int estado;
    
    public producto(){
        this.idProducto=0;
        this.nombre="";
        this.cantidad=0;
        this.venta=0;
        this.idCategoria=0;
        this.estado=0;
        this.descripcion="";
        this.precioventa=0.0;
        this.preciocompra=0.0;
        
    }

    public producto(int idProducto, String nombre, int cantidad, double precioventa,  String descripcion,double preciocompra, int venta, int idCategoria, int estado) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioventa = precioventa;
        this.descripcion = descripcion;
        this.preciocompra=preciocompra;
        this.venta = venta;
        this.idCategoria = idCategoria;
        this.estado = estado;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(double precioventa) {
        this.precioventa = precioventa;
    }

    public double getPreciocompra() {
        return preciocompra;
    }

    public void setPreciocompra(double preciocompra) {
        this.preciocompra = preciocompra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getVenta() {
        return venta;
    }

    public void setVenta(int venta) {
        this.venta = venta;
    }


    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
}
