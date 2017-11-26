/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria.regras;

import livraia.negocio.basica.Editora;
import livraria.acesso.DAOEditoraImpl;
import livraria.erro.ConexaoException;
import livraria.erro.DAOException;
import livraria.erro.RegraException;

/**
 *
 * @author rudnik
 */
public class RegraEditora {
    private DAOEditoraImpl dao;
    public RegraEditora(){
        dao = new DAOEditoraImpl();
    }
    public void validaDados(Editora e) throws RegraException{
        if (e == null)
            throw new RegraException("Objeto Nulo!");
        if (e.getRazaoSocial().isEmpty())
            throw new RegraException("Editora sem Razao Social!");
        System.out.println("validou");  

    }
    public void cadastrar(Editora e) throws DAOException, ConexaoException, RegraException{
        System.out.println("consultar");  
        if (dao.consultar(e.getRazaoSocial() )== null){
            System.out.println("inserir"); 
            dao.inserir(e);
        }else
            throw new RegraException("Editora já existe!");
        
    }
}
