/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author leandrison.ribeiro
 */
public class mlivros {
   private int id_livro;
   private String titulo;
   private String descricao;
   private int ano;
   private meditoras editoras;
   private mautores autores;

    public int getId_livro() {
        return id_livro;
    }

    public void setId_livro(int id_livro) {
        this.id_livro = id_livro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public meditoras getEditoras() {
        return editoras;
    }

    public void setEditoras(meditoras editoras) {
        this.editoras = editoras;
    }

    public mautores getAutores() {
        return autores;
    }

    public void setAutores(mautores autores) {
        this.autores = autores;
    }

    
    
    
    
    
    
    
}
