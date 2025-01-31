public class EspecialidadeInvalidaException extends Exception {
    public EspecialidadeInvalidaException(String message) {
        super("Especialidade não encontrada.");
    }
}
