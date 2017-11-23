/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria.acesso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import livraia.negocio.basica.Autor;
import livraria.erro.ConexaoException;
import livraria.erro.DAOException;
import livraria.util.GerenciadorConexao;
import livraria.util.GerenciadorConexaoImpl;

/**
 *
 * @author Pedro Nardelli
 */
public class DAOAutorImpl implements DAOAutor {

    /**
     * Abre conexão com o banco de dados e inseri um novo autor
     * @param a
     * @throws DAOException
     * @throws ConexaoException 
     */
    @Override
    public void inserir(Autor a) throws DAOException, ConexaoException {
        GerenciadorConexao ger = GerenciadorConexaoImpl.getInstancia();
        String sql = "INSERT INTO autor (nome) VALUES (?)";
        try{
            Connection con = ger.abrirConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,a.getNome());
            pstm.executeUpdate();
            ger.fecharConexao(con); 
            
        }catch(SQLException e){
            throw new DAOException();
        }
        
    }
    
    public void remover(Autor a)throws DAOException,ConexaoException {
        GerenciadorConexao ger = GerenciadorConexaoImpl.getInstancia();
        String sql = "DELETE autor WHERE nome=?";
        try{
            Connection con = ger.abrirConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,a.getNome());
            pstm.executeUpdate();
            ger.fecharConexao(con);
        }catch(SQLException e){
            throw new DAOException();
        }
    }

    @Override
    public void alterar(Autor a)throws DAOException,ConexaoException {
        GerenciadorConexao ger = GerenciadorConexaoImpl.getInstancia();
        String sql = "UPDATE autor SET nome = ?";
        try{
            Connection con = ger.abrirConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,a.getNome());
            pstm.executeUpdate();
            ger.fecharConexao(con);
        }catch(SQLException e){
            throw new DAOException();
        }
    }

    public Autor consultar(String nome) throws DAOException,ConexaoException{
        Autor a = null;
        GerenciadorConexao ger = GerenciadorConexaoImpl.getInstancia();
        String sql = "SELECT nome FROM autor WHERE nome=?";
        try{
            Connection con = ger.abrirConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,nome);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                a = new Autor();
                a.setNome(      rs.getString("nome"));
            }
            ger.fecharConexao(con);
        }catch(SQLException e){
            throw new DAOException();
        }
        return a;
    }

    @Override
    public void remover(Integer codigo) throws DAOException, ConexaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Autor consultar(Integer codigo) throws DAOException, ConexaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
