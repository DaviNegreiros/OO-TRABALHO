public class Prescricoes {
    Consulta consultaAssociada;
    Exame examesPrescritos[];
    Medicamento medicamentosPrescritos[];
    LocalDate dataValidade;

    //Métodos
    Prescricoes(Consulta c, Exame e[], Medicamento m[], LocalDate dV){
        consultaAssociada = c;
        examesPrescritos[] = e[];
        medicamentosPrescritos[] = m[];
        dataValidade = dV;

    }

    //Read
    Consulta getConsultaAssociada(){
        return consultaAssociada; //é provavel que os métodos get e set de classes criadas por nós não funcionem igual outras classes como String, então é provavel que nós vamos ter que arrumar isso depois
                                    //possível tratamento do retorno necessário
    }
    Exame getExamesPrescritos(){
        return examesPrescritos[];
    }
    Medicamento getMedicamentosPrescritos(){
        return medicamentosPrescritos[];
    }
    LocalDate getDataValidade(){
        return dataValidade;
    }






}