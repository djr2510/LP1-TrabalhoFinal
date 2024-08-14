package exception;

import javax.persistence.PersistenceException;

public class AplicacaoException extends Exception{
    public AplicacaoException(String message) {
        super(message);
    }

    public AplicacaoException(String falha_ao_inserir_funcionario, PersistenceException e) {
    }
}
