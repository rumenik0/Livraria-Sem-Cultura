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
import livraia.negocio.basica.Funcionario;
import livraria.erro.ConexaoException;
import livraria.erro.DAOException;
import livraria.util.GerenciadorConexao;
import livraria.util.GerenciadorConexaoImpl;

/**
 *
 * @author aluno
 */
public class DAOFuncionarioImpl implements DAOFuncionario{

    @Override
    public void inserir(Funcionario f) throws DAOException, ConexaoException {
       GerenciadorConexao ger = GerenciadorConexaoImpl.getInstancia();
        String sql = "INSERT INTO funcionario (nome,cpf,tipo,sexo,telefone,endereco) VALUES (?,?,?,?,?,?)";
        try{
            Connection con = ger.abrirConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,f.getNome());
            pstm.setString(2,f.getCpf());
            pstm.setString(3,"F");
            pstm.setString(4,f.getSexo());
            pstm.setString(5,f.getTelefone());
            pstm.setString(6,f.getEndereco());
            pstm.executeUpdate();
            ger.fecharConexao(con);
        }catch(SQLException e){
            throw new DAOException();
        }  
    }

    @Override
    public void remover(Funcionario f) throws DAOException, ConexaoException {
        GerenciadorConexao ger = GerenciadorConexaoImpl.getInstancia();
        String sql = "DELETE pessoa WHERE cpf=? and tipo =?";
        try{
            Connection con = ger.abrirConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,f.getCpf());
            pstm.setString(2,"F");
            pstm.executeUpdate();
            ger.fecharConexao(con);
        }catch(SQLException e){
            throw new DAOException();
        }    
    }

    @Override
    public void alterar(Funcionario f) throws DAOException, ConexaoException {
        GerenciadorConexao ger = GerenciadorConexaoImpl.getInstancia();
        String sql = "UPDATE pessoa SET nome = ?,cpf = ?,tipo = ?,sexo = ?,telefone = ?,endereco = ?";
        try{
            Connection con = ger.abrirConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,f.getNome());
            pstm.setString(2,f.getCpf());
            pstm.setString(3,"F");
            pstm.setString(4,f.getSexo());
            pstm.setString(5,f.getTelefone());
            pstm.setString(6,f.getEndereco());
            pstm.executeUpdate();
            ger.fecharConexao(con);
        }catch(SQLException e){
            throw new DAOException();
        }
    }

    @Override
    public Funcionario consultar(String cpf) throws DAOException, ConexaoException {
        Funcionario f = null;
        GerenciadorConexao ger = GerenciadorConexaoImpl.getInstancia();
        String sql = "SELECT id,nome,cpf,tipo,sexo,telefone,endereco FROM pessoa WHERE cpf=? and tipo =?";
        try{
            Connection con = ger.abrirConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,cpf);
            pstm.setString(2,"F");
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                f = new Funcionario();
                f.setNome(      rs.getString("nome"));
                f.setCpf(       rs.getString("cpf"));
                f.setTipo(      rs.getString("tipo"));
                f.setSexo(      rs.getString("sexo"));
                f.setTelefone(  rs.getString("telefone"));
                f.setEndereco(  rs.getString("endereco"));
            }
            ger.fecharConexao(con);
        }catch(SQLException e){
            throw new DAOException();
        }
        return f;
    }
    
}
