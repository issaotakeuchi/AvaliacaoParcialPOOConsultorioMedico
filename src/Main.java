import java.time.LocalDate;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;

public class Main {
    public static void main(String[] args) throws PacientePublicoException, PacienteParticularException {
        //instaciar objetos PacientePublico
        PacientePublico issao = new PacientePublico("issao", "takeuchi", LocalDate.of(1989,03,01),"123");
        PacientePublico robson = new PacientePublico("robson", "reis", LocalDate.of(1988,12,12),"456");
        PacientePublico hamilton = new PacientePublico("hamilton", "okuiama", LocalDate.of(1974,10,25),"789");

        //instanciar objetos PacienteParticular
        PacienteParticular marina = new PacienteParticular("marina", "agueda", LocalDate.of(1988,06,16),"987");
        PacienteParticular telma = new PacienteParticular("telma", "toribio", LocalDate.of(1963,10,31),"654");
        PacienteParticular tom = new PacienteParticular("tom", "takeuchi", LocalDate.of(1987,05,31),"321");

        //instanciar ConsultaPublica e verificar se a método efetuarAvaliacaoInicial funciona
        System.out.println("eh a promeira consulta de " + issao.getNome() + "?" + issao.isPrimeiraConsulta());
        ConsultaPublica cissao1 = new ConsultaPublica(1,LocalDate.of(2020,01,31), "ortopedia", LocalTime.of(10,30));
        System.out.println("paciente " + issao.getNome() + ": " + cissao1.efetuarAvaliacaoInicial(issao));
        System.out.println(issao.isPrimeiraConsulta());
        ConsultaPublica cissao2 = new ConsultaPublica(3,LocalDate.of(2020,05,15), "ortopedia", LocalTime.of(11,30));
        System.out.println("paciente " + issao.getNome() + ": " + cissao2.efetuarAvaliacaoInicial(issao));
        ConsultaPublica cissao3 = new ConsultaPublica(5,LocalDate.of(2021,03,10), "ortopedia", LocalTime.of(9,0));
        System.out.println("paciente " + issao.getNome() + ": " + cissao3.efetuarAvaliacaoInicial(issao));

        //instanciar ConsultaParticular e verificar se a método efetuarAvaliacaoInicial funciona
        System.out.println("eh a promeira consulta de " + marina.getNome() + "?" + marina.isPrimeiraConsulta());
        ConsultaParticular cmarina1 = new ConsultaParticular(2,LocalDate.of(2020,02,01), "ortopedia", LocalTime.of(10,30));
        System.out.println("a paciente " + marina.getNome() + ": " + cmarina1.efetuarAvaliacaoInicial(marina));
        System.out.println(marina.isPrimeiraConsulta());
        ConsultaParticular cmarina2 = new ConsultaParticular(4,LocalDate.of(2020,05,20), "ortopedia", LocalTime.of(11,30));
        System.out.println("a paciente " + marina.getNome() + ": " + cmarina2.efetuarAvaliacaoInicial(marina));
        ConsultaParticular cmarina3 = new ConsultaParticular(6,LocalDate.of(2021,03,15), "ortopedia", LocalTime.of(9,0));
        System.out.println("a paciente " + marina.getNome() + ": " + cmarina3.efetuarAvaliacaoInicial(marina));

        //utilizar addConsulta e verificar lançamento de erros
        try {
            issao.addConsulta(cissao1);
            issao.addConsulta(cissao2);
            issao.addConsulta(cissao3);
//            issao.addConsulta(cmarina1);
            marina.addConsulta(cmarina1);
            marina.addConsulta(cmarina2);
            marina.addConsulta(cmarina3);
            marina.addConsulta(cissao3);
        } catch (PacientePublicoException | PacienteParticularException e) {
            System.out.println(e.getMessage());
        }

        //obter valor da consulta particular
        cmarina1.setValorConsulta(500.00);
        System.out.println("o valor da consulta eh: " + cmarina1.informarValorConsulta());

        //comparar as consultas públicas ordenando-as dentro de um Set em PacientePublico. Critério de ordenação é o idConsulta.
        System.out.println(issao.mostrarConsultasOrdenadas());
    }

}
