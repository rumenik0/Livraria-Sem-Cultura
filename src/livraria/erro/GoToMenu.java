/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria.erro;

/**
 *
 * @author rudnik
 */
public class GoToMenu extends Exception{
    public GoToMenu(){}
    
    public GoToMenu(String erro){
        super(erro);
    }
}
