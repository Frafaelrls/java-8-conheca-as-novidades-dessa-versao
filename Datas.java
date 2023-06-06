import java.time.*;
import java.time.format.DateTimeFormatter;

public class Datas {
    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);

        LocalDate olimpiadas = LocalDate.of(2024, Month.JUNE, 7);

        int anos = olimpiadas.getYear() - hoje.getYear();

        System.out.println(anos);

        Period periodo = Period.between(hoje, olimpiadas);

        LocalDate proximaOlimpiada = olimpiadas.plusYears(4);
        System.out.println(proximaOlimpiada);

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String valorFormatado = proximaOlimpiada.format(formatador);
        System.out.println(valorFormatado);

        DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
        LocalDateTime agora = LocalDateTime.now();
        System.out.println(agora.format(formatadorComHoras));

        LocalTime intervalo = LocalTime.of(15, 30);
        System.out.println(intervalo);

        int nano = intervalo.getNano();
        System.out.println(nano);

    }
}
