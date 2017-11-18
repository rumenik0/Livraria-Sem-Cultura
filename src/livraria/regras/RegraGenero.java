/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria.regras;

import livraia.negocio.basica.Genero;
import livraria.erro.RegraException;

/**
 *
 * @author aluno
 */
public class RegraGenero {
    
    public void validarDados(Genero g) throws RegraException{
        if (g == null){
            throw new RegraException("Objeto nulo");
        }    
        if (g.getCodigo() == null){
            throw new RegraException("Codigo em branco");
        }    
        if (g.getNome().isEmpty() || g.getNome() == null){
            throw new RegraException("Nome em branco");
        }    
    }        
}
