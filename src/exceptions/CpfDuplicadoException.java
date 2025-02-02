package exceptions;

public class CpfDuplicadoException extends Exception {
    public CpfDuplicadoException (String message) {
        super("Cpf já cadastrado");
      
    }
}
