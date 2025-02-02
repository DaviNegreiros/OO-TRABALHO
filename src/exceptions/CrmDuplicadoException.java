package exceptions;

public class CrmDuplicadoException extends Exception {
    public CrmDuplicadoException (String message) {
        super("Crm já cadastrado.");
    }
}
