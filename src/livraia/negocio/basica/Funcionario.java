/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraia.negocio.basica;

/**
 *
 * @author aluno
 */
public class Funcionario extends Pessoa {
    /**
     * Construtor padrão sem paramentros.
     */
    public Funcionario(){}
   /**
    * Funcionario com todos os dados preenchidos.
    * @param nome
    * @param cpf
    * @param telefone
    * @param sexo
    * @param tipo
    * @param endereco 
    */
    public Funcionario(String nome, String cpf, String telefone, String sexo, String endereco, String login, String senha) {
        super(nome, cpf, telefone, sexo, "F");
        this.endereco = endereco;
        this.login = login;
        this.senha = senha;
    }
    
    private String login;
    private String senha;
    private String endereco;
    
    
       /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
   
    
}
