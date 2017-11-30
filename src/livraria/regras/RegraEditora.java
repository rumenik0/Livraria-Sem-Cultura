/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria.regras;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import livraia.negocio.basica.Editora;
import livraria.acesso.produto.DAOEditoraImpl;
import livraria.erro.ConexaoException;
import livraria.erro.DAOException;
import livraria.erro.RegraException;

/**
 *
 * @author rudnik
 */
public class RegraEditora {
    private final DAOEditoraImpl dao;
    private Editora editora;
    public RegraEditora(){
        editora = new Editora();
        dao = new DAOEditoraImpl();
    }
    public void validaDados(Editora e) throws RegraException{
        if (e == null)
            throw new RegraException("Objeto Nulo!");
        if (e.getRazaoSocial().isEmpty())
            throw new RegraException("Editora sem Razao Social!");

    }
    public void cadastrar(Editora e) throws DAOException, RegraException, ConexaoException{
        try {
            editora = dao.consultar(e.getRazaoSocial());
        }catch (DAOException ex) {
            System.out.println("DAO Exception"+ex.getMessage());
            throw ex;
        }
        if (editora== null){
            System.out.println("inserir"); 
            dao.inserir(e);
            e = dao.consultar(e.getRazaoSocial());  
        }else
            throw new RegraException("Editora já existe!");
    }
    public void alterar(Editora e) throws RegraException, DAOException, ConexaoException{
        validaDados(e);
            if(e.getCodigo() != null)
                dao.alterar(e);
    }
    
    public Editora consultar(String razao) throws DAOException, ConexaoException{
        return dao.consultar(razao);
    }

    /**
     * 
     * @param e Editora a ser removida do BD.
     * @throws livraria.erro.DAOException Erro na camada de acesso.
     * @throws livraria.erro.ConexaoException Erro na camada de acesso.
     */
    public void remover(Editora e) throws DAOException, ConexaoException, RegraException, SQLException{
        if (e != null)
            dao.remover(e);
        else
            throw new RegraException("Remover Editora error: objeto nulo");
    }
    public DefaultTableModel defaultTable() throws Exception{
        return dao.defaultTable();
    }

    public ArrayList<Editora> listar(String razao) throws ConexaoException, DAOException, Exception {
        return dao.listar(razao);
                
    }
    public ArrayList<Editora> listar( ) throws ConexaoException, DAOException, Exception {
        return dao.listar();
                
    }
}
