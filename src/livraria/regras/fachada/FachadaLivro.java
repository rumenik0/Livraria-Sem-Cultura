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
public class FachadaLivro {
    
    public void cadastrarLivro(Livro livro) throws RegraException{
        RegraLivro regralivro = new RegraLivro();
        regralivro.validarDados(livro);
    }
}
