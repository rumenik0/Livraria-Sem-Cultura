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
import livraia.negocio.basica.Cliente;
import livraria.erro.ConexaoException;
import livraria.erro.DAOException;
import livraria.util.GerenciadorConexao;
import livraria.util.GerenciadorConexaoImpl;

/**
 *
 * @author rudnik
 */
public class DAOClienteImpl implements DAOCliente{

    @Override
    public void inserir(Cliente c)throws DAOException,ConexaoException {
        GerenciadorConexao ger = GerenciadorConexaoImpl.getInstancia();
        String sql = "INSERT INTO pessoa (nome,cpf,tipo,sexo,telefone) VALUES (?,?,?,?,?)";
        try{
            Connection con = ger.abrirConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,c.getNome());
            pstm.setString(2,c.getCpf());
            pstm.setString(3,"C");
            pstm.setString(4,c.getSexo());
            pstm.setString(5,c.getTelefone());
            pstm.executeUpdate();
            ger.fecharConexao(con);
        }catch(SQLException e){
            throw new DAOException();
        }  
    }

    @Override
    public void remover(Cliente c)throws DAOException,ConexaoException {
        GerenciadorConexao ger = GerenciadorConexaoImpl.getInstancia();
        String sql = "DELETE pessoa WHERE cpf=? and tipo =?";
        try{
            Connection con = ger.abrirConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,c.getCpf());
            pstm.setString(2,"C");
            pstm.executeUpdate();
            ger.fecharConexao(con);
        }catch(SQLException e){
            throw new DAOException();
        }
    }

    @Override
    public void alterar(Cliente c)throws DAOException,ConexaoException {
        GerenciadorConexao ger = GerenciadorConexaoImpl.getInstancia();
        String sql = "UPDATE pessoa SET nome = ?,cpf = ?,tipo = ?,sexo = ?,telefone = ?";
        try{
            Connection con = ger.abrirConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,c.getNome());
            pstm.setString(2,c.getCpf());
            pstm.setString(3,"C");
            pstm.setString(4,c.getSexo());
            pstm.setString(5,c.getTelefone());
            pstm.executeUpdate();
            ger.fecharConexao(con);
        }catch(SQLException e){
            throw new DAOException();
        }
    }

    @Override
    public Cliente consultar(String cpf) throws DAOException,ConexaoException{
        Cliente c = null;
        GerenciadorConexao ger = GerenciadorConexaoImpl.getInstancia();
        String sql = "SELECT id,nome,cpf,tipo,sexo,telefone FROM pessoa WHERE cpf=? and tipo =?";
        try{
            Connection con = ger.abrirConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,cpf);
            pstm.setString(2,"C");
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                c = new Cliente();
                c.setNome(      rs.getString("nome"));
                c.setCpf(       rs.getString("cpf"));
                c.setTipo(      rs.getString("tipo"));
                c.setSexo(      rs.getString("sexo"));
                c.setTelefone(  rs.getString("telefone"));
            }
            ger.fecharConexao(con);
        }catch(SQLException e){
            throw new DAOException();
        }
        return c;
    }
    
}
