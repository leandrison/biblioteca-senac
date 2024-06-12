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
import model.mautores;


/**
 *
 * @author leandrison.ribeiro
 */
public class cautores {

    public void cadastrar(mautores modele) {

        Connection conn = mysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement("INSERT INTO autores (nome) VALUES(?)");
            stmt.setString(1, modele.getNome());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "autor cadastrado com sucesso");

        } catch (SQLException ex) {
            Logger.getLogger(ceditoras.class.getName()).log(Level.SEVERE, null, ex);
        }
throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<mautores> listar() {
        Connection conn = mysql.conexao();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<mautores> lista = new ArrayList<>();
        try {
            stmt = conn.prepareStatement("select* from autores");
            rs= stmt.executeQuery();
            
            while (rs.next()){
                mautores modele=new mautores();
                modele.setId_autores(rs.getInt("id_autor"));
                modele.setNome(rs.getString("nome"));
                lista.add(modele);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ceditoras.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;

    }
    public List<mautores> pesquisar(String texto) {
        Connection conn = mysql.conexao();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<mautores> lista = new ArrayList<>();
        try {
            stmt = conn.prepareStatement("select* from autores where nome like ?");
            stmt.setString(1, "%"+ texto+ "%");
            rs= stmt.executeQuery();
            
            while (rs.next()){
                mautores modele=new mautores();
                modele.setId_autores(rs.getInt("id_autor"));
                modele.setNome(rs.getString("nome"));
                lista.add(modele);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(cautores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;

    }
public void excluir(mautores modele) {
        Connection conn = mysql.conexao();
 
        PreparedStatement stmt = null;
        ResultSet rs = null;
 
        try {
            stmt = conn.prepareStatement("DELETE FROM autores WHERE id_autor = " + "=?");
            stmt.setInt(1, modele.getId_autores());
 
            stmt.executeUpdate();
 
            JOptionPane.showMessageDialog(null, "autor excluído com sucesso!");
 
        } catch (SQLException ex) {
            Logger.getLogger(cautores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    }


