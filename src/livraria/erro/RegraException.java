/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria.erro;

/**
 *
 * @author Pedro Nardelli
 */
public class RegraException extends Exception {
    public RegraException(){}
    
    public RegraException(String erro){
        super(erro);
    }
    
}
