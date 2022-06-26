public class PacienteParticularException extends Exception {
    public PacienteParticularException() {
        super("Consulta nao corresponde a um paciente particular");
    }
}
