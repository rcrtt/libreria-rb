
package controlador;

import conexion.Conexion;
import java.sql.*;
import modelo.Categoria;
/**
 *
 * @author Renato
 */
public class ctr_categoria {
    public boolean guardar(Categoria obj){
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
    }
    //metodo para consultar q existe la categoria 
    public boolean existeCategoria(String categoria){
        boolean resp=false;
        String sql="select descripcion from tb_categorias where descripcion='" + categoria + "'";
        Statement st;
        
        try{
            Connection cone=Conexion.conectar();
            st=cone.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                resp=true;
            }
        }catch(SQLException e){
            System.out.println("Error al consultar categorias" + e);
        }
        return resp;
    }
    public boolean actualizar(Categoria obj, int idCat){
        boolean resp=false;
        Connection con=Conexion.conectar();
        try{
            PreparedStatement consulta=con.prepareStatement("update tb_categorias set descripcion=? where idCategoria='" + idCat + "'");
            consulta.setString(1, obj.getDescripcion());
            
            if(consulta.executeUpdate()>0){
                resp=true;
            }
            con.close();
        }catch(SQLException e){
            System.out.println("Error al actualizar categoria " + e);
        }
        return resp;
    }
    public boolean eliminar(int idCat){
        boolean resp=false;
        Connection con=Conexion.conectar();
        try{
            PreparedStatement consulta=con.prepareStatement("delete from tb_categorias where idCategoria='" + idCat + "'");
            consulta.executeUpdate();
            
            if(consulta.executeUpdate()>0){
                resp=true;
            }
            con.close();
        }catch(SQLException e){
            System.out.println("Error al eliminar categoria " + e);
        }
        return resp;
    }
}
