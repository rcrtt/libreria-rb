/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexion.Conexion;
/**
 *
 * @author Renato
 */
public class ctr_usuario {
    //atributos
   //metodo para Iniciar sesion
    public boolean LoginUser(usuario obj){
        boolean resp=false;
        Connection cone=Conexion.conectar();
        String sql="select usuario, password from tb_usuario where usuario='" + obj.getUsuario() + "' and password='" + obj.getPassword() + "'";
        Statement st;
        try{
            st=cone.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                resp=true;
            }
        }catch(Exception e){
            System.out.println("Error al iniciar sesion: ");
            JOptionPane.showMessageDialog(null, "Error al iniciar sesion");
        }
        return resp;
    }
    public boolean guardar(usuario obj){
        boolean resp=false;
        Connection cone=Conexion.conectar();
        try{
            PreparedStatement consulta=cone.prepareStatement("insert into tb_usuario values(?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);
            consulta.setString(2, obj.getNombre());
            consulta.setString(3, obj.getApellido());
            consulta.setString(4, obj.getUsuario());
            consulta.setString(5, obj.getPassword());
            consulta.setString(6, obj.getTelefono());
            consulta.setInt(7, obj.getEstado());
            if(consulta.executeUpdate()>0){
                resp=true;
            }
            cone.close();
        }catch(SQLException e){
            System.out.println("Error al guardar usuario " + e);
        }
        return resp;
    }
    public boolean existeCliente(String usuario){
        boolean resp=false;
        String sql="select usuario from tb_usuario where usuario='" + usuario + "'";
        Statement st;
        
        try{
            Connection cone=Conexion.conectar();
            st=cone.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                resp=true;
            }
        }catch(SQLException e){
            System.out.println("Error al consultar usuario" + e);
        }
        return resp;
    }
    public boolean actualizar(usuario obj, int idUsuario){
        boolean resp=false;
        Connection con=Conexion.conectar();
        try{
            PreparedStatement consulta=con.prepareStatement("update tb_usuario set nombre=?, apellido=?, usuario=?, password=?, telefono=?,  estado=? where idUsuario='" + idUsuario + "'");
            consulta.setString(1, obj.getNombre());
            consulta.setString(2, obj.getApellido());
            consulta.setString(3, obj.getUsuario());
            consulta.setString(4, obj.getPassword());
            consulta.setString(5, obj.getTelefono());
            consulta.setInt(6, obj.getEstado());
            if(consulta.executeUpdate()>0){
                resp=true;
            }
            con.close();
        }catch(SQLException e){
            System.out.println("Error al actualizar usuario " + e);
        }
        return resp;
    }
    public boolean eliminar(int idUsuario){
        boolean resp=false;
        Connection con=Conexion.conectar();
        try{
            PreparedStatement consulta=con.prepareStatement("delete from tb_usuario where idUsuario='" + idUsuario + "'");
            consulta.executeUpdate();
            
            if(consulta.executeUpdate()>0){
                resp=true;
            }
            
            con.close();
        }catch(SQLException e){
            System.out.println("Error al eliminar usuario " + e);
        }
        return resp;
        
    }
}
