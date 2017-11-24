package livraria.regras.fachada;

import livraia.negocio.basica.Cliente;
import livraria.acesso.DAOClienteImpl;
import livraria.erro.ConexaoException;
import livraria.erro.DAOException;
import livraria.erro.RegraException;
import livraria.regras.RegraCliente;

/**
 *
 * @author Pedro Nardelli
 */
public class FachadaCliente {
    
    private RegraCliente rc;
    private Cliente c;
    
    public FachadaCliente(){
        dci = new DAOClienteImpl();
    }
    
    
    public void cadastrar(Cliente c) throws RegraException, DAOException, ConexaoException{
        try{
            rc.validarDados(c);
            dci.inserir(c);
        }catch(DAOException e){
            throw e;
        }catch(ConexaoException e){
            throw e;
        }catch(RegraException e){
            throw e;
        }
    }
    public void alterar(Cliente c)throws RegraException, DAOException, ConexaoException{
        try{
            
            dci.alterar(c);
           
        }catch(DAOException e){
            throw e;
        }catch(ConexaoException e){
            throw e;
        }catch(RegraException e){
            throw e;
        }
        
    }
    public void remover(String cpf)throws RegraException, DAOException, ConexaoException{
        try{
            c = dci.consultar(cpf);
            if (c == null)
                throw new RegraException("Cliente não existe");
            dci.remover(c);
            
        }catch (RegraException e){
            throw e;
        }
    }
    public Cliente consultar(String cpf) throws RegraException,DAOException, ConexaoException{
        try{         
            c = dci.consultar(cpf);
            if (c == null)
                throw new RegraException("Cliente não existe");            
        }catch(RegraException e){
            throw e;
        }  
        return c;
    }
    
}
