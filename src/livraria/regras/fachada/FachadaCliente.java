/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria.regras.fachada;

import livraia.negocio.basica.Cliente;
import livraria.acesso.DAOClienteImpl;
import livraria.erro.ConexaoException;
import livraria.erro.DAOException;
import livraria.erro.RegraException;
import livraria.regras.RegraCliente;

/**
 *
 * @author Pedro Nardelli
 */
public class FachadaCliente {
    public void cadastrar(Cliente c) throws RegraException, DAOException, ConexaoException{
        RegraCliente rc = new RegraCliente();
        rc.validarDados(c);
        
        DAOClienteImpl dci = new DAOClienteImpl();
        dci.inserir(c);
    
    }
    public void alterar(Cliente c)throws RegraException{
    
    }
    public void remover(String cpf)throws RegraException{
    }
    public Cliente consultar(String cpf) throws DAOException, ConexaoException{
        Cliente c = new Cliente();
        DAOClienteImpl dci = new DAOClienteImpl();
        c = dci.consultar(cpf);
        return c;
    }
    
}
