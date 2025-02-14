package cadastro;

import classes.*;
import exceptions.*;
import java.util.ArrayList;
import java.util.List;

public class CadastroConsulta {
    private List<Consulta> consultas;

    // Construtor
    public CadastroConsulta() {
        consultas = new ArrayList<>();
    }

    // Método para adicionar uma consulta
  //  public void adicionarConsulta(Consulta consulta) throws HorarioIndisponivelException, PagamentoPendenteException {
   //     consulta.agendarConsulta(); // Verifica se a consulta pode ser agendada
    //    consultas.add(consulta);
   // }

    // Método para remover uma consulta
    public void removerConsulta(Consulta consulta) {
        consultas.remove(consulta);
    }

    // Método para buscar consultas por paciente
    public List<Consulta> buscarConsultasPorPaciente(Paciente paciente) {
        List<Consulta> consultasDoPaciente = new ArrayList<>();
        for (Consulta consulta : consultas) {
            if (consulta.getPacienteAssociado().equals(paciente)) {
                consultasDoPaciente.add(consulta);
            }
        }
        return consultasDoPaciente;
    }

    // Método para buscar consultas por médico
    public List<Consulta> buscarConsultasPorMedico(Medico medico) {
        List<Consulta> consultasDoMedico = new ArrayList<>();
        for (Consulta consulta : consultas) {
            if (consulta.getMedicoAssociado().equals(medico)) {
                consultasDoMedico.add(consulta);
            }
        }
        return consultasDoMedico;
    }

    // Método para listar todas as consultas
    public List<Consulta> listarConsultas() {
        return consultas;
    }

    // Método para atualizar uma consulta
    public void atualizarConsulta(Consulta consultaAntiga, Consulta consultaNova) throws HorarioIndisponivelException, PagamentoPendenteException {
        consultaNova.agendarConsulta(); // Verifica se a nova consulta pode ser agendada
        int index = consultas.indexOf(consultaAntiga);
        if (index != -1) {
            consultas.set(index, consultaNova);
        }
    }
}
