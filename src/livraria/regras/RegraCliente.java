/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria.regras;

import livraia.negocio.basica.Cliente;
import livraria.erro.RegraException;

/**
 *
 * @author Pedro Nardelli e Gandof
 */
public class RegraCliente {
    /**
     * Validar a integridade dos dados do cliente.
     * @param c
     * @throws RegraException 
     */
    public void validarDados(Cliente c) throws RegraException{
        
        if(c == null){
           throw new RegraException("Objeto Nulo"); 
        }
        
        if(c.getNome().isEmpty() || c.getNome() == null ){
           throw new RegraException("Nome em branco");
        }
        if(c.getCpf().isEmpty() || c.getCpf() == null){
           throw new RegraException("CPF em branco");
        }
        if(c.getSexo().isEmpty() || c.getSexo() == null){
           throw new RegraException("Sexo em branco");
        }
        if(c.getTelefone().isEmpty() || c.getTelefone() == null){
           throw new RegraException("Telefone em branco");
        }
    }
}
