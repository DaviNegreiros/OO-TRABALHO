package classes;

import java.time.LocalDate;

public class PessoaFisica {

    // Instâncias das Váriaveis

    private String nome, cpf;
    private LocalDate nasc;

    public PessoaFisica(String nome, String cpf, LocalDate nasc) {
        this.nome = nome;
        this.cpf = cpf;
        this.nasc = nasc;
    }

    // Métodos Gets e Sets

    public final String getNome() {
        return nome;
    }

    public final String getCpf() {
        return cpf;
    }

    public final LocalDate getNasc() {
        return nasc;
    }

    public void setNasc(LocalDate nasc) {
        this.nasc = nasc;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String exibirDados() {
        return "Nome: " + getNome() + "\n" +
                "CPF: " + getCpf() + "\n" +
                "Data de Nascimento: " + getNasc() + " \n";
    }
}