public class Prescricoes {
    Consulta consultaAssociada;
    Exame examesPrescritos[];
    Medicamento medicamentosPrescritos[];
    Date dataValidade;

    //Métodos
    Prescricoes(Consulta c, Exame e[], Medicamento m[], Date dV){
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
    Date getDataValidade(){
        return dataValidade;
    }

    //Write






}