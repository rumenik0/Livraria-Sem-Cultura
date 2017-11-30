/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria.regras.fachada;

import livraia.negocio.basica.Genero;
import livraria.erro.ConexaoException;
import livraria.erro.DAOException;
import livraria.erro.RegraException;
import livraria.regras.RegraEditora;
import livraria.regras.RegraGenero;

/**
 *
 * @author aluno
 */
public class FachadaGenero {
    //private final RegraEditora regra;
    
   // public FachadaGenero(){
        //regra = new RegraGenero();
   // }
    public void cadastrar(Genero g)throws DAOException, ConexaoException, RegraException {
        System.out.println("valida dados"); 
    
    }
}
