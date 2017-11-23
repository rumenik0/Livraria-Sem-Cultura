/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria.acesso;

import livraia.negocio.basica.Autor;
import livraria.erro.ConexaoException;
import livraria.erro.DAOException;

/**
 *
 * @author aluno
 */
public interface DAOAutor {
        
    /**
     *Responsavel por inserir um Autor
     * @param a
     * @throws DAOException erro na camada de dados
     * @throws ConexaoException erro durante a conexão com o Banco de Dados
     */
    public void inserir(Autor a)throws DAOException, ConexaoException;
    
    /**
     * Responsavel por alterar Autor
     * @param a
     * @throws DAOException erro na camada de dados
     * @throws ConexaoException erro durante a conexão com o Banco de Dados
     */
    public void alterar(Autor a) throws DAOException, ConexaoException;
    
    /**
     * Responsavel por remover um Autor cadastrado
     * @param codigo
     * @throws DAOException erro na camada de dados
     * @throws ConexaoException erro durante a conexão com o Banco de Dados
     */
    public void remover (Integer codigo) throws DAOException, ConexaoException;
    
    /**
     * Responsavel por consultar um Autor cadastrado
     * @param codigo
     * @return
     * @throws DAOException erro na camada de dados
     * @throws ConexaoException erro durante a conexão com o Banco de Dados
     */
    public Autor consultar(String nome)throws DAOException, ConexaoException;
           
    
}
