package classes;

import java.time.LocalDate;

public class Medicamento {
    String nomeMed, uso;
    LocalDate dataPrescricao;

    // Construtor completo
    public Medicamento(String nM, String u, LocalDate dP) {
        nomeMed = nM;
        uso = u;
        dataPrescricao = dP;
    }

    // Novo construtor simplificado
    public Medicamento(String nM, String u) {
        this(nM, u, LocalDate.now()); // Define a data de prescrição como a data atual
    }

    // Métodos get
    String getNomeMed() {
        return nomeMed;
    }

    String getUso() {
        return uso;
    }

    LocalDate getDataPrescricao() {
        return dataPrescricao;
    }

    // Métodos set
    void setNomeMed(String a) {
        nomeMed = a;
    }

    void setUso(String a) {
        uso = a;
    }

    void setDataPrescricao(LocalDate a) {
        dataPrescricao = a;
    }
}