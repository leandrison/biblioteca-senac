/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import database.mysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.mlivros;

/**
 *
 * @author leandrison.ribeiro
 */
public class clivros {
       public void cadastrar(mlivros modell) {

        Connection conn = mysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement("INSERT INTO livros (fk_editoras_id_editoras, fk_autores_id_autor, titulo, descriocao, ano) VALUES(?,?,?,?,?)");
            stmt.setInt(1, modell.getEditoras().getId_editora());
            stmt.setInt(2, modell.getAutores().getId_autores());
            stmt.setString(3, modell.getTitulo());
            stmt.setString(4, modell.getDescricao());
            stmt.setInt(5, modell.getAno());
            
            
            
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "livro cadastrado om sucesso");

        } catch (SQLException ex) {
            Logger.getLogger(ceditoras.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
}
