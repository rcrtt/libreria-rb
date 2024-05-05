/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author Renato
 */
public class Conexion {
    //conexion local
    public static Connection conectar(){
        try{
            Connection cone=DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_rb", "root", "renato");
            return cone;
        }catch(SQLException e){
            System.out.println("Error en la conexion: " + e);
        }
        return null;
    }
}
