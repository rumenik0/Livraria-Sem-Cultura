/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria.regras;

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
    private DAOEditoraImpl dao;
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
        System.out.println("validou");  

    }
    public void cadastrar(Editora e) throws DAOException, RegraException, ConexaoException{
        try {
            editora = dao.consultar(e.getRazaoSocial());
        } catch (ConexaoException ex) {
            System.out.println("Conexao exception");
            throw ex;
        }catch (DAOException ex) {
            System.out.println("DAO Exception"+ex.getMessage());
            throw ex;
        }
        if (editora== null){
            System.out.println("inserir"); 
            dao.inserir(e);
        }else
            throw new RegraException("Editora já existe!");
        
    }
    public DefaultTableModel defaultTable() throws Exception{
        return dao.defaultTable();
    }

    public ArrayList<Editora> listar() throws ConexaoException, DAOException {
        return dao.listar();
                
    }
}
