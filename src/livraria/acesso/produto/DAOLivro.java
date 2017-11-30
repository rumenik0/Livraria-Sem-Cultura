/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria.acesso.produto;

import livraia.negocio.basica.Livro;
import livraria.erro.ConexaoException;
import livraria.erro.DAOException;

/**
 *
 * @author aluno
 */
public interface DAOLivro {
    /**
     * Responsável por inserir um livro no banco de dados
     * @param l livro a ser inserido
     * @throws DAOException Erro na camada de dados
     * @throws ConexaoException  Erro durante conexão com o Banco de Dados
     */
    public void inserir(Livro l)throws DAOException,ConexaoException;
    /**
     * Responsável por remover um cliente do banco de dados
     * @param Id Identificador do livro a ser removido
     * @throws DAOException Erro na camada de dados
     * @throws ConexaoException  Erro durante conexão com o Banco de Dados
     */
    public void remover(String Id)throws DAOException,ConexaoException;
    /**
     * Responsável por alterar um Livro já existente no banco de dados.
     * @param l Objeto Livro a ser alterado
     * @throws DAOException Erro na camada de dados
     * @throws ConexaoException  Erro durante conexão com o Banco de Dados
     */
    public void alterar(Livro l)throws DAOException,ConexaoException;
    /**
     * Responsável por consultar e retornar um Livro no banco de dados
     * @param id Idendificador do livro a ser consultado
     * @return Objeto Livro
     * @throws DAOException Erro na camada de dados
     * @throws ConexaoException  Erro durante conexão com o Banco de Dados
     */
    public Livro consultar(String id) throws DAOException,ConexaoException;
            
}
