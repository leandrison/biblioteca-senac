/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.sql.Connection;
import database.mysql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.meditoras;

/**
 *
 * @author leandrison.ribeiro
 */
public class ceditoras {

    public void cadastrar(meditoras modele) {

        Connection conn = mysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement("INSERT INTO editoras (nome) VALUES(?)");
            stmt.setString(1, modele.getNome());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "editora cadastrada om sucesso");

        } catch (SQLException ex) {
            Logger.getLogger(ceditoras.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<meditoras> listar() {
        Connection conn = mysql.conexao();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<meditoras> lista = new ArrayList<>();
        try {
            stmt = conn.prepareStatement("select* from editoras");
            rs= stmt.executeQuery();
            
            while (rs.next()){
                meditoras modele=new meditoras();
                modele.setId_editora(rs.getInt("id_editora"));
                modele.setNome(rs.getString("nome"));
                lista.add(modele);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ceditoras.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;

    }
    public List<meditoras> pesquisar(String texto) {
        Connection conn = mysql.conexao();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<meditoras> lista = new ArrayList<>();
        try {
            stmt = conn.prepareStatement("select* from editoras where nome like ?");
            stmt.setString(1, "%"+ texto+ "%");
            rs= stmt.executeQuery();
            
            while (rs.next()){
                meditoras modele=new meditoras();
                modele.setId_editora(rs.getInt("id_editora"));
                modele.setNome(rs.getString("nome"));
                lista.add(modele);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ceditoras.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;

    }
        public void alterar(meditoras modele) {

        Connection conn = mysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement("UPDATE editoras set nome = ? where id_editora =?");
            stmt.setString(1, modele.getNome());
            stmt.setInt (2,modele.getId_editora());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "editora cadastrada om sucesso");

        } catch (SQLException ex) {
            Logger.getLogger(ceditoras.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
        public void excluir(meditoras modele) {
        Connection conn = mysql.conexao();
 
        PreparedStatement stmt = null;
        ResultSet rs = null;
 
        try {
            stmt = conn.prepareStatement("DELETE FROM editoras WHERE id_editora "
                    + "?");
            stmt.setInt(1, modele.getId_editora());
 
            stmt.executeUpdate();
 
            JOptionPane.showMessageDialog(null, "Editora excluída com sucesso!");
 
        } catch (SQLException ex) {
            Logger.getLogger(ceditoras.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
}
