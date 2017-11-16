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
public class Cliente extends Pessoa{
    /**
     * Construtor padrão sem paramentros.
     */
    public Cliente(){}
    
    /**
     * Cliente com todos os dados preenchidos.
     * @param nome
     * @param cpf
     * @param telefone
     * @param sexo
     * @param tipo 
     */
    public Cliente(String nome, String cpf, String telefone, String sexo){
        super(nome, cpf, telefone, sexo, "C");
        
    }

    
}
