/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria.regras;

import livraia.negocio.basica.Funcionario;
import livraria.erro.RegraException;

/**
 *
 * @author aluno
 */
public class RegraFuncionario {
    public void validarDados(Funcionario f)throws RegraException{
        if (f == null)
            throw new RegraException("Objeto Inválido");
        
        if(f.getNome().isEmpty() || f.getNome() == null )
           throw new RegraException("Nome em branco");
        
        if(f.getCpf().isEmpty() || f.getCpf() == null)
           throw new RegraException("CPF em branco");
        
        if(f.getSexo().isEmpty() || f.getSexo() == null)
           throw new RegraException("Sexo em branco");
        
        if(f.getTelefone().isEmpty() || f.getTelefone() == null)
           throw new RegraException("Telefone em branco");
        
        if(f.getEndereco().isEmpty() || f.getEndereco() == null)
           throw new RegraException("Endereço em branco");
        
        if(f.getLogin().isEmpty() || f.getLogin() == null)
           throw new RegraException("Login em branco");
        
        if(f.getSenha().isEmpty() || f.getSenha() == null)
           throw new RegraException("Senha em branco");
        
            
    }
    
}
