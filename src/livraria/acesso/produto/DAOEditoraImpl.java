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
        GerenciadorConexao ger = GerenciadorConexaoImpl.getInstancia();
        String sql = "SELECT codigo,RAZAO_SOCIAL,TELEFONE FROM EDITORA WHERE RAZAO_SOCIAL =?";
        try{
            Connection con = ger.abrirConexao();
            pstm = con.prepareStatement(sql);
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
            throw new DAOException("SQL Exception no DAOEditora: "+e.getMessage());
        }
        return editora;
    }
    public ArrayList<Editora> listar() throws ConexaoException, DAOException{
        ger = GerenciadorConexaoImpl.getInstancia();
        sql = "SELECT codigo,RAZAO_SOCIAL,TELEFONE FROM EDITORA";
        try{ 
            con = ger.abrirConexao();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            System.out.println("listar");
            Editora e;
            while(rs.next()){
                e = new Editora();
                System.out.println("teste 1");
                System.out.println(rs.getString("razao_social"));
                System.out.println("teste 2");
                e.setCodigo(rs.getInt("codigo"));
                e.setRazaoSocial(rs.getString("razao_social"));
                e.setTelefone(rs.getString("telefone"));
                System.out.println("teste 3");
                lista.add(e);
                System.out.println("teste 4");
            }
        }catch(SQLException e){
           System.out.println("SQL Ex:" + e.getMessage());
            throw new DAOException("SQL Exception no DAOEditora: "+e.getMessage());
        }catch(ConexaoException e){
            System.out.println("Conex Ex");
            throw new DAOException("Conexao Exception no DAOEditora: "+e.getMessage());
        }finally{
            ger.fecharConexao(con);
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
