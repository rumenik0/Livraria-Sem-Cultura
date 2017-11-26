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
import livraia.negocio.basica.Editora;
import livraria.erro.ConexaoException;
import livraria.erro.DAOException;
import livraria.util.GerenciadorConexao;
import livraria.util.GerenciadorConexaoImpl;

/**
 *
 * @author aluno
 */
public class DAOEditoraImpl implements DAOEditora{
    private Editora editora;
    
    
    @Override
    public void inserir(Editora e) throws DAOException, ConexaoException {
        GerenciadorConexao ger = GerenciadorConexaoImpl.getInstancia();
        String sql = "INSERT INTO editora (telefone,razao_social) VALUES (?,?)";
        try{
            Connection con = ger.abrirConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,e.getRazaoSocial());
            pstm.setString(2,e.getTelefone());
            pstm.executeUpdate();
            ger.fecharConexao(con);
        }catch(SQLException ex){
            throw new DAOException(ex.getMessage());
        }
    }

    @Override
    public void remover() throws DAOException, ConexaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar() throws DAOException, ConexaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Editora consultar(String razao) throws DAOException, ConexaoException {
        editora = null;
        System.out.println("get instancia"); 
        GerenciadorConexao ger = GerenciadorConexaoImpl.getInstancia();
        String sql = "SELECT codigo,razao_social,telefone FROM pessoa WHERE razao_social =?";
        try{
            System.out.println("abrir conexao"); 
            Connection con = ger.abrirConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,razao);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                editora = new Editora();
                editora.setCodigo(rs.getInt("codigo"));
                editora.setRazaoSocial(rs.getString("razao_social"));
                editora.setTelefone(rs.getString("telefone"));
            }
            ger.fecharConexao(con);
        }catch(SQLException e){
            throw new DAOException();
        }
        return editora;
    }
    
}
