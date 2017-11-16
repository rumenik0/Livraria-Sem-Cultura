package livraria.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import livraria.erro.ConexaoException;

/**
 *
 * @author rudnik
 */
public class GerenciadorConexaoImpl implements GerenciadorConexao{
    private static GerenciadorConexaoImpl instancia;
    private final String url;
    private final String user;
    private final String password;
    
    private GerenciadorConexaoImpl(){
        url     = "url";
        user    = "usuario";
        password= "senha";
    }
    
    /**
     * Implantando padrão...na Classe.
     * @return 
     */
    public  static GerenciadorConexaoImpl getInstancia(){
        if (instancia == null) 
            instancia = new GerenciadorConexaoImpl();
        return instancia;
    }
    
    
    @Override
    public Connection abrirConexao() throws ConexaoException {
        Connection c;
        try{    
            c = DriverManager.getConnection(url, user, password);
            return c;
        }catch(SQLException e){
            throw new ConexaoException();
        }
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
