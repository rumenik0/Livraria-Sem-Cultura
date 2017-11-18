/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria.regras.fachada;

import livraia.negocio.basica.Livro;
import livraria.erro.RegraException;

/**
 *
 * @author aluno
 */
public class RegraLivro {

    public void validarDados(Livro livro) throws RegraException{
       if (livro == null){
           throw new RegraException("Objeto Nulo");
       } 
       if (livro.getTitulo().isEmpty() || livro.getTitulo() == null){
           throw new RegraException("Titulo Vazio");
       }
       if (livro.getEditora().isEmpty() || livro.getEditora() == null){
           throw new RegraException("Editora Vazio");
       }
       if (livro.getGenero().isEmpty() || livro.getGenero()== null){
           throw new RegraException("Genero Vazio");
       }
       if (livro.getAno().isEmpty() || livro.getAno()== null){
           throw new RegraException("Ano Vazio");
       }
       if (livro.getEdicao().isEmpty() || livro.getEdicao()== null){
           throw new RegraException("Edicao Vazio");
       }
    
       }
    
    
}
