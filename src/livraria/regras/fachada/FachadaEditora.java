 package livraria.regras.fachada;

import java.util.ArrayList;
import livraia.negocio.basica.Editora;
import livraria.erro.ConexaoException;
import livraria.erro.DAOException;
import livraria.erro.RegraException;
import livraria.regras.RegraEditora;

/**
 *
 * @author aluno
 */
public class FachadaEditora {
    private final RegraEditora regra;
    
    public FachadaEditora(){
        regra = new RegraEditora();
    }
    
    public void cadastrar(Editora e) throws DAOException, ConexaoException, RegraException {
        System.out.println("valida dados");  
        regra.validaDados(e);
        System.out.println("cadastrar");  
        regra.cadastrar(e); 
            
    }
    public void remover(Editora e) throws DAOException, ConexaoException{
        regra.remover(e);
    }
    public ArrayList<Editora> listar(String razao) throws ConexaoException, DAOException, Exception{
        return regra.listar(razao);
    
    }
    public ArrayList<Editora> listar() throws ConexaoException, DAOException, Exception{
        return regra.listar();
    
    }
}
