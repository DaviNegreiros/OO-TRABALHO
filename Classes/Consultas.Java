import java.time.LocalDate;

public class Consulta{
    //CRUD
    LocalDate data;
    String hora, status;
    int min;
    float valor;
    Paciente pacienteAssociado;
    Medico medicoAssociado;
    Exame exames[]
    Medicamento medicamentos[]
    
    //Métodos
    Consulta(LocalDate d, String h, String s, int m, float v, Paciente pA, Medico mA, Exame e[], Medicamento m[]){
        data = d;
        hora = h;
        status = s;
        min = m;
        valor = v;
        pacienteAssociado = pA;
        medicoAssociado = mA;
        exames[] = e[];
        medicamentos[] = medicamentos[];
    }
    
    //void newConsulta(if pagamento){}

    //Read
    LocalDate getData(){
        return data;
    }
    String getHora(){
        return hora;
    }
    String getStatus(){
        return status;
    }
    int getMin(){
        return min;
    }
    float getValor(){
        return valor;
    }
    Paciente getPacienteAssociado(){
        return pacienteAssociado;
    }
    Medico getMedicoAssociado(){
        return medicoAssociado;
    }
    Exame getExames(){
        return exames[];
    }
    Medicamento getMedicamentos(){
        return medicamentos[];
    }

    //Write
    void setData(LocalDate a){
        data = a;
    }
    void setHora(String a){
        hora = a;
    }
    void setStatus(String a){
        status = a;
    }
    void setMin (int a){
        min = a;
    }
    void setValor(float a){
        valor = a;
    }
    void setPacienteAssociado(Paciente a){
        pacienteAssociado = a;
    }
    void setMedicoAssociado(Medico a){
        medicoAssociado = a;
    }
    void setExames(Exame a[]){
        exames[] = a[];
    }
    void setMedicamentos(Medicamento a[]){
        medicamentos[] = a[];
    }


}