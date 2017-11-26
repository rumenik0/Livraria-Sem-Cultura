package livraria.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import livraria.erro.ConexaoException;

/**
 *
 * @author rudnik
 */
public class GerenciadorConexaoImpl implements GerenciadorConexao{
    private static GerenciadorConexaoImpl instancia;
    private final String url = "jdbc:mysql://localhost/livraria";
    private final String user = "root";
    private final String password = "";
    
    private GerenciadorConexaoImpl(){

    }
    
    /**
     * Implantando padrão singleton na Classe.
     * @return 
     */
    public  static GerenciadorConexaoImpl getInstancia(){
        if (instancia == null) 
            instancia = new GerenciadorConexaoImpl();
        return instancia;
    }
    
    
    @Override
    public Connection abrirConexao() throws ConexaoException, SQLException {
        Connection c;   
        System.out.println("getConnection, URL:"+url+"  USER:"+user+"  PASS: "+password); 
        c = DriverManager.getConnection(url, user, password);
        System.out.println("Passou?"); 
        return c;
        
    }
    
    @Override
    public void fecharConexao(Connection c)throws ConexaoException{
        try {
            c.close();
        } catch (SQLException e) {
            throw new ConexaoException();
        }
    }
}
