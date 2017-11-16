package livraria.erro;

/**
 *
 * @author aluno
 */
public class ConexaoException extends Exception {
    public ConexaoException(){
    }
    public ConexaoException(String texto) {
        super("Erro durante conexão com o banco de dados: "+texto);
    }
}
