/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria.regras;

import java.util.logging.Level;
import java.util.logging.Logger;
import livraia.negocio.basica.Cliente;
import livraria.acesso.DAOClienteImpl;
import livraria.erro.ConexaoException;
import livraria.erro.DAOException;
import livraria.erro.RegraException;

/**
 *
 * @author Pedro Nardelli e Gandof
 */
public class RegraCliente {
    private final DAOClienteImpl dao;
    public RegraCliente(){
        dao = new DAOClienteImpl();
    }
    public void inserir(Cliente c) throws RegraException, DAOException, ConexaoException{
        try{
            if (existe(c))
                throw new RegraException("Já existe um cliente com este CPF!");
        }catch(RegraException e){
            throw e;
        }catch(DAOException e){
            throw e;
        }catch(ConexaoException e){
            throw e;
        }
    }
    public void alterar(Cliente c) throws RegraException, DAOException, ConexaoException{
        try {
            if (existe(c))
                throw new RegraException("Não existe cliente para este CPF!");
        } catch (RegraException e) {
            throw e;
        } catch (DAOException e) {
            throw e;
        } catch (ConexaoException e) {
            throw e;
        }
        
    }
    public void validarDados(Cliente c) throws RegraException{
        if(c == null)
           throw new RegraException("Objeto Nulo"); 
        if(c.getNome().isEmpty() || c.getNome() == null )
           throw new RegraException("Nome em branco");
        if(c.getCpf().isEmpty() || c.getCpf() == null)
           throw new RegraException("CPF em branco");
        if(c.getSexo().isEmpty() || c.getSexo() == null)
           throw new RegraException("Sexo em branco");
        if(c.getTelefone().isEmpty() || c.getTelefone() == null)
           throw new RegraException("Telefone em branco");
    }
    public boolean existe(Cliente c) throws RegraException, DAOException, ConexaoException{
        try{
            c = dao.consultar(c.getCpf());
            if(c == null)
                return false;
            return true;
        }catch(DAOException e){
            throw e;
        }catch(ConexaoException e){
            throw e;
        }
        
        
    }
    
}
