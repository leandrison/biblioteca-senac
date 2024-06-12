/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author leandrison.ribeiro
 */
public class mysql {
    public static Connection conexao(){
       try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/db_biblioteca_senac?" +
                                   "user=root&password=rout15089");
        } catch (Exception ex) {
            throw new RuntimeException("erro a o conectar no banco de dados");
        } 
    }
    
}
