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

    }
    public void cadastrar(Editora e) throws DAOException, ConexaoException, RegraException{
        if (dao.consultar(e.getRazaoSocial() )== null)
            throw new RegraException("Editora já existe!");
        dao.inserir(e);
        
    }
}
