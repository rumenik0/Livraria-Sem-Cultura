/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria.acesso.produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
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
    private PreparedStatement pstm;
    private GerenciadorConexao ger;
    private Connection con;
    private String sql;
    private ArrayList<Editora> lista;
    private ResultSet rs;
    private Exception erro;
    
    public DAOEditoraImpl(){
        lista = new ArrayList<>();
    }
    
    
    @Override
    public void inserir(Editora e) throws DAOException, ConexaoException {
        GerenciadorConexao ger = GerenciadorConexaoImpl.getInstancia();
        String sql = "INSERT INTO editora (telefone,razao_social) VALUES (?,?)";
        try{
            Connection con = ger.abrirConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(2,e.getRazaoSocial());
            pstm.setString(1,e.getTelefone());
            pstm.executeUpdate();
            ger.fecharConexao(con);
        }catch(SQLException ex){
            throw new DAOException(ex.getMessage());
        }
    }

    @Override
    public void remover(Editora e) throws DAOException, ConexaoException,SQLException {
        GerenciadorConexao ger = GerenciadorConexaoImpl.getInstancia();
        String sql = "DELETE FROM EDITORA WHERE CODIGO = ?";

        Connection con = ger.abrirConexao();
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setInt(1,e.getCodigo());
        pstm.executeUpdate();
        ger.fecharConexao(con);

    }

    @Override
    public void alterar(Editora e) throws DAOException, ConexaoException {
        GerenciadorConexao ger = GerenciadorConexaoImpl.getInstancia();
        String sql = "UPDATE EDITORA SET RAZAO_SOCIAL = ?,TELEFONE = ? WHERE CODIGO = ?";
        try{
            Connection con = ger.abrirConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,e.getRazaoSocial());
            pstm.setString(2,e.getTelefone());
            pstm.setInt(3,e.getCodigo());
            pstm.executeUpdate();
            ger.fecharConexao(con);
        }catch(SQLException ex){
            throw new DAOException("DAO Editora erro: "+ex.getMessage());
        }
    }

    @Override
    public Editora consultar(String razao) throws DAOException {
        editora = null;
        GerenciadorConexao ger = GerenciadorConexaoImpl.getInstancia();
        String sql = "SELECT CODIGO,RAZAO_SOCIAL,TELEFONE FROM EDITORA WHERE RAZAO_SOCIAL =?";
        try{
            Connection con = ger.abrirConexao();
            pstm = con.prepareStatement(sql);
            pstm.setString(1,razao);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                editora = new Editora();
                System.out.println("Select Editora codigo: "+ rs.getInt("CODIGO".toString()));
                editora.setCodigo(rs.getInt("CODIGO"));
                editora.setRazaoSocial(rs.getString("RAZAO_SOCIAL"));
                editora.setTelefone(rs.getString("TELEFONE"));
            }
            ger.fecharConexao(con);
        }catch(Exception e){
            throw new DAOException("SQL Exception no DAOEditora: "+e.getMessage());
        }
        return editora;
    }
    public ArrayList<Editora> listar() throws ConexaoException, DAOException, Exception{
        ger = GerenciadorConexaoImpl.getInstancia();
        sql = "SELECT CODIGO,RAZAO_SOCIAL,TELEFONE FROM EDITORA";
        try{ 
            con = ger.abrirConexao();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            System.out.println("listar");
            Editora e;
            while(rs.next()){
                e = new Editora();
                e.setCodigo(rs.getInt("CODIGO"));
                e.setRazaoSocial(rs.getString("razao_social"));
                e.setTelefone(rs.getString("telefone"));
                lista.add(e);
            }
        }catch(SQLException e){
           System.out.println("SQL Ex:" + e.getMessage());
            erro = new DAOException("SQL Exception no DAOEditora: "+e.getMessage());
        }catch(ConexaoException e){
            System.out.println("Conex Ex");
            erro = new DAOException("Conexao Exception no DAOEditora: "+e.getMessage());
        }finally{
            ger.fecharConexao(con);;
        }
        return lista;
    }
    
    public ArrayList<Editora> listar(String razao) throws ConexaoException, DAOException, Exception{
        ger = GerenciadorConexaoImpl.getInstancia();
        sql = "SELECT codigo,RAZAO_SOCIAL,TELEFONE FROM EDITORA WHERE RAZAO_SOCIAL LIKE '%?%'";
        try{ 
            con = ger.abrirConexao();
            pstm = con.prepareStatement(sql);
            pstm.setString(1,razao);
            rs = pstm.executeQuery();
            System.out.println("listar");
            Editora e;
            while(rs.next()){
                e = new Editora();
                System.out.println(rs.getString("razao_social"));
                e.setCodigo(rs.getInt("codigo"));
                e.setRazaoSocial(rs.getString("razao_social"));
                e.setTelefone(rs.getString("telefone"));
                lista.add(e);
            }
        }catch(SQLException e){
           System.out.println("SQL Ex:" + e.getMessage());
            erro = new DAOException("SQL Exception no DAOEditora: "+e.getMessage());
        }catch(ConexaoException e){
            System.out.println("Conex Ex");
            erro = new DAOException("Conexao Exception no DAOEditora: "+e.getMessage());
        }finally{
            ger.fecharConexao(con);
            //throw erro;
        }
        return lista;
    }
    
    
    public DefaultTableModel defaultTable() throws Exception{
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        sql = "select * from editora";
        pstm = con.prepareStatement(sql);
        rs = pstm.executeQuery();

        dtm.addColumn("codigo");
        dtm.addColumn("razao_social");
        dtm.addColumn("telefone");
        while (rs.next()) {
            dtm.addRow(new String[] {rs.getString("codigo"), rs.getString("razao_social"), rs.getString("telefone") });
        }
        ger.fecharConexao(con);                
        return dtm;
    }
    
}
