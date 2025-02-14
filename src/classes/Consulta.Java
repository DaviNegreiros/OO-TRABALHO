package classes;

import exceptions.HorarioIndisponivelException;
import exceptions.PagamentoPendenteException;
import java.time.LocalDate;

public class Consulta {
    // Atributos privados
    private LocalDate data;
    private String hora;
    private String status;
    private int min;
    private float valor;
    private Paciente pacienteAssociado;
    private Medico medicoAssociado;
    private Exame[] exames;
    private Medicamento[] medicamentos;

    // Construtor completo
    public Consulta(LocalDate d, String h, String s, int mi, float v, Paciente pA, Medico mA, Exame[] e, Medicamento[] m) {
        this.data = d;
        this.hora = h;
        this.status = s;
        this.min = mi;
        this.valor = v;
        this.pacienteAssociado = pA;
        this.medicoAssociado = mA;
        this.exames = e;
        this.medicamentos = m;
    }

    // Construtor provisório
    public Consulta(LocalDate d, String h, String s, int mi, float v, Paciente pA, Medico mA) {
        this(d, h, s, mi, v, pA, mA, new Exame[0], new Medicamento[0]); // Inicializa arrays vazios
    }

    // Métodos get (públicos)
    public LocalDate getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public String getStatus() {
        return status;
    }

    public int getMin() {
        return min;
    }

    public float getValor() {
        return valor;
    }

    public Paciente getPacienteAssociado() {
        return pacienteAssociado;
    }

    public Medico getMedicoAssociado() {
        return medicoAssociado;
    }

    public Exame[] getExames() {
        return exames;
    }

    public Medicamento[] getMedicamentos() {
        return medicamentos;
    }

    // Métodos set (públicos)
    public void setData(LocalDate a) {
        this.data = a;
    }

    public void setHora(String a) {
        this.hora = a;
    }

    public void setStatus(String a) {
        this.status = a;
    }

    public void setMin(int a) {
        this.min = a;
    }

    public void setValor(float a) {
        this.valor = a;
    }

    public void setPacienteAssociado(Paciente a) {
        this.pacienteAssociado = a;
    }

    public void setMedicoAssociado(Medico a) {
        this.medicoAssociado = a;
    }

    public void setExames(Exame[] a) {
        this.exames = a;
    }

    public void setMedicamentos(Medicamento[] a) {
        this.medicamentos = a;
    }

    // Método para agendar consulta
    public void agendarConsulta() throws HorarioIndisponivelException, PagamentoPendenteException {
        if (pacienteAssociado.getPagamentoPendente()) {
            throw new PagamentoPendenteException("Consulta não pode ser agendada. O paciente possui pagamentos pendentes.");
        }

        if (medicoAssociado.horarioOcupado(data, hora)) {
            throw new HorarioIndisponivelException("O médico já tem uma consulta agendada neste horário.");
        }
        status = "Confirmada";
        System.out.println("Consulta agendada com sucesso para " + data + " às " + hora);
    }
}