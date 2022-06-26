public class PacientePublicoException extends Exception {
    public PacientePublicoException() {
        super("Consulta nao corresponde a um paciente publico");
    }
}
