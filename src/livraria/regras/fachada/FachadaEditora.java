/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria.regras.fachada;

import livraia.negocio.basica.Editora;
import livraria.erro.ConexaoException;
import livraria.erro.DAOException;
import livraria.erro.RegraException;
import livraria.regras.RegraEditora;

/**
 *
 * @author aluno
 */
public class FachadaEditora {
    private final RegraEditora regra;
    
    public FachadaEditora(){
        regra = new RegraEditora();
    }
    
    public void cadastrar(Editora e) throws DAOException, ConexaoException, RegraException {
        try{
            regra.validaDados(e);
            regra.cadastrar(e); 
        }catch(RegraException ex){
            throw ex;
        }     
    }
}
