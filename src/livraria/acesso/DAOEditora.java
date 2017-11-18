/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria.acesso;

import livraia.negocio.basica.Editora;
import livraria.erro.ConexaoException;
import livraria.erro.DAOException;

/**
 *
 * @author aluno
 */
public interface DAOEditora {

    /**
     *
     * @param e Objeto Editora
     * @throws DAOException Erro na camada de dados
     * @throws ConexaoException  Erro durante conexão com o Banco de Dados 
     */
    public void inserir(Editora e)throws DAOException,ConexaoException;

    /**
     *
     * @throws DAOException Erro na camada de dados
     * @throws ConexaoException  Erro durante conexão com o Banco de Dados 
     */
    public void remover()throws DAOException,ConexaoException;

    /**
     *
     * @throws DAOException Erro na camada de dados
     * @throws ConexaoException  Erro durante conexão com o Banco de Dados 
     */
    public void alterar()throws DAOException,ConexaoException;

    /**
     * Consult
     * @param codigo
     * @return 
     * @throws DAOException Erro na camada de dados
     * @throws ConexaoException  Erro durante conexão com o Banco de Dados 
     */
    public Editora consultar(Integer codigo)throws DAOException,ConexaoException;
}
