/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria.acesso;

import livraia.negocio.basica.Funcionario;
import livraria.erro.ConexaoException;
import livraria.erro.DAOException;

/**
 *
 * @author aluno
 */
public interface DAOFuncionario {
    /**
     * Responsável por inserir um Cliente no banco de dados
     * @param f Objeto Funcionario
     * @throws DAOException Erro na camada de dados
     * @throws ConexaoException  Erro durante conexão com o Banco de Dados
     */
     public void inserir(Funcionario f)throws DAOException,ConexaoException;
     /**
      * Responsável por remover um Cliente no banco de dados
      * @param f
      * @throws DAOException Erro na camada de dados
      * @throws ConexaoException Erro durante conexão com o Banco de Dados
      */
     public void remover(Funcionario f)throws DAOException,ConexaoException;
     /**
      * Responsável por alterar um Cliente no banco de dados
      * @param f
      * @throws DAOException Erro na camada de dados
      * @throws ConexaoException Erro durante conexão com o Banco de Dados
      */
     public void alterar(Funcionario f)throws DAOException,ConexaoException;
     /**
      * Responsável por consultar e retornar um Cliente no banco de dados
      * @param cpf CPF do funcionário a ser consultado
      * @return Objeto Funcionario
      * @throws DAOException Erro na camada de dados
      * @throws ConexaoException Erro durante conexão com o Banco de Dados
      */
     public Funcionario consultar(String cpf)throws DAOException,ConexaoException;
}
