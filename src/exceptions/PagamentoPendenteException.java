package exceptions;

public class PagamentoPendenteException extends Exception {
    public PagamentoPendenteException(String message) {
        super("O paciente possui um pagamento pendente.");
    }
}
