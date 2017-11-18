
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraia.negocio.basica;

/**
 *
 * @author aluno
 */
public class Livro {
    
    public Livro(){}
    
    public Livro(String titulo, String edicao, String ano, Editora editora, Genero genero){
            this.titulo = titulo;
            this.edicao = edicao;
            this.ano = ano;
            this.editora = editora;
            this.genero = genero;    
    }
        private String titulo;
        private String edicao;
        private String ano;
        private Editora editora;
        private Genero genero;

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the edicao
     */
    public String getEdicao() {
        return edicao;
    }

    /**
     * @param edicao the edicao to set
     */
    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    /**
     * @return the ano
     */
    public String getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(String ano) {
        this.ano = ano;
    }

    /**
     * @return the editora
     */
    public Editora getEditora() {
        return editora;
    }

    /**
     * @return the genero
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * @param editora the editora to set
     */
    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
