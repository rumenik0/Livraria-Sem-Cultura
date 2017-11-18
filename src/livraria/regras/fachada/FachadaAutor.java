/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria.regras.fachada;

import livraia.negocio.basica.Autor;
import livraria.erro.RegraException;
import livraria.regras.RegraAutor;

/**
 *
 * @author aluno
 */
public class FachadaAutor {
    public void cadastrar(Autor a) throws RegraException{
       
        RegraAutor ra = new RegraAutor();
        ra.validarDados(a);
        
        
    }
    
}
