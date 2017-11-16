/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria.acesso;

import livraia.negocio.basica.Cliente;
import livraria.erro.ConexaoException;
import livraria.erro.DAOException;

/**
 *
 * @author rudnik
 */
public interface DAOCliente {
    
    public void inserir(Cliente c)throws DAOException,ConexaoException;
    
    public void remover(Cliente c)throws DAOException,ConexaoException;
    
    public void alterar(Cliente c)throws DAOException,ConexaoException;
    
    public Cliente consultar(String cpf)throws DAOException,ConexaoException;
}
