/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria.util;

import java.sql.Connection;
import livraria.erro.ConexaoException;


/**
 *
 * @author rudnik
 */
public interface GerenciadorConexao {
    /**
     * 
     * @return
     * @throws ConexaoException 
     */
    public Connection abrirConexao() throws ConexaoException;
    
    /**
     * 
     * @param c Connection Object
     * @throws ConexaoException Erro de execução pode aparecer durante execução.
     */
    public void fecharConexao(Connection c)throws ConexaoException;
}
