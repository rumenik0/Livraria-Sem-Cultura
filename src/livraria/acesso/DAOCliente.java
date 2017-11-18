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
    /**
     * Responsável por inserir um Cliente 
     * @param c
     * @throws DAOException Erro na camada de dados
     * @throws ConexaoException  Erro durante conexão com o Banco de Dados 
     */
    public void inserir(Cliente c)throws DAOException,ConexaoException;
    /**
     * Responsável por remover Cliente
     * @param c
     * @throws DAOException Erro na camada de dados
     * @throws ConexaoException  Erro durante conexão com o Banco de Dados
     */
    public void remover(Cliente c)throws DAOException,ConexaoException;
    /**
     * Responsável por alterar um Cliente
     * @param c
     * @throws DAOException Erro na camada de dados
     * @throws ConexaoException  Erro durante conexão com o Banco de Dados
     */
    public void alterar(Cliente c)throws DAOException,ConexaoException;
    /**
     * Responsável por consultar e retornar um Cliente no banco de dados
     * @param cpf
     * @return
     * @throws DAOException Erro na camada de dados
     * @throws ConexaoException  Erro durante conexão com o Banco de Dados 
     */
    public Cliente consultar(String cpf)throws DAOException,ConexaoException;
}
