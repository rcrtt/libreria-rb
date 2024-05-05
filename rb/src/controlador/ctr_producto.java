/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Categoria;
import modelo.producto;
import vista.*;

/**
 *
 * @author Renato
 */
public class ctr_producto {
    
    public boolean guardar(producto obj){
        System.out.println(obj.getPreciocompra());
        
        boolean resp=false;
        inter_producto n=new inter_producto();
        Connection cone=Conexion.conectar();
        try{
            PreparedStatement consulta=cone.prepareStatement("insert into tb_producto_3 values(?,?,?,?,?,?,?,?,?)");
            
            
            consulta.setInt(1, 0);//id
            consulta.setString(2, obj.getNombre());
            consulta.setInt(3, obj.getCantidad());
            consulta.setDouble(4, n.pc);
            consulta.setString(5, obj.getDescripcion());
            consulta.setDouble(6, n.pv);
            consulta.setInt(7, 0);
            consulta.setInt(8, obj.getIdCategoria());
            consulta.setInt(9, obj.getIdProducto());
            if(consulta.executeUpdate()>0){
                resp=true;
            }
            cone.close();
        }catch(SQLException e){
            System.out.println("Error al guardar productop " + e);
        }
        return resp;
    }
    public boolean existeProducto(String producto){
        boolean resp=false;
        String sql="select descripcion from tb_producto_3 where descripcion='" + producto + "'";
        Statement st;
        
        try{
            Connection cone=Conexion.conectar();
            st=cone.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                resp=true;
            }
        }catch(SQLException e){
            System.out.println("Error al consultar productoss" + e);
        }
        return resp;
    }
    /*public boolean guardar(Categoria obj){
        boolean resp=false;
        Connection cone=Conexion.conectar();
        try{
            PreparedStatement consulta=cone.prepareStatement("insert into tb_categorias values(?,?,?)");
            consulta.setInt(1, 0);
            consulta.setString(2, obj.getDescripcion());
            consulta.setInt(3, obj.getEstado());
            if(consulta.executeUpdate()>0){
                resp=true;
            }
            cone.close();
        }catch(SQLException e){
            System.out.println("Error al guardar categoria " + e);
        }
        return resp;
    }*/
    public boolean actualizar(producto obj, int idProducto){
        boolean resp=false;
        
        Connection con=Conexion.conectar();
        try{
            PreparedStatement consulta=con.prepareStatement("update tb_producto_3 set nombre=?, cantidad=?, precioc=?, descripcion=?, preciov=?,porcIva=?, categoria=?, estado=? where idProducto='" + idProducto + "'");
            consulta.setString(1, obj.getNombre());
            consulta.setInt(2, obj.getCantidad()); 
            consulta.setDouble(3, obj.getPrecioventa());
            consulta.setDouble(5, obj.getPreciocompra());
            consulta.setString(4, obj.getDescripcion());
            consulta.setInt(6, obj.getVenta());
            consulta.setInt(7, obj.getIdCategoria());
            consulta.setInt(8, obj.getEstado());
            if(consulta.executeUpdate()>0){
                resp=true;
            }
            con.close();
        }catch(SQLException e){
            System.out.println("Error al actualizar producto " + e);
        }
        return resp;
    }
    public boolean eliminar(int idProducto){
        boolean resp=false;
        Connection con=Conexion.conectar();
        try{
            PreparedStatement consulta=con.prepareStatement("delete from tb_producto_3 where idProducto='" + idProducto + "'");
            consulta.executeUpdate();
            
            if(consulta.executeUpdate()>0){
                resp=true;
            }
            con.close();
        }catch(SQLException e){
            System.out.println("Error al eliminar producto " + e);
        }
        return resp;
    }
    //metodo para actualizar stock del producto
    public boolean actualizarStock(producto obj, int idProducto){
        boolean resp=false;
        Connection con=Conexion.conectar();
        try{
            PreparedStatement consulta=con.prepareStatement("update tb_producto set cantidad=? where idProducto='" + idProducto + "'");
            consulta.setInt(1, obj.getCantidad());
            
            if(consulta.executeUpdate()>0){
                resp=true;
            }
            con.close();
        }catch(SQLException e){
            System.out.println("Error al actualizar stock producto " + e);
        }
        return resp;
    }
}
