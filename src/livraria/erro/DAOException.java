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
public class DAOException extends Exception{
    public DAOException(){}
    public DAOException(String texto) {
        super(texto);
    }
}
