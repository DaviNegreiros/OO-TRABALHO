package exceptions;

public class CampoEmBrancoException extends Exception {
    public CampoEmBrancoException(String campo) {
        super("O campo " + campo + " não pode estar em branco.");
    }
}