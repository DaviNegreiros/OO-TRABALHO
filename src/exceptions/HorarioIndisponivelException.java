public class HorarioIndisponivelException extends Exception {
    public HorarioIndisponivelException(String message) {
        super("Horário indisponivel, tente novamente.");
    }
}
