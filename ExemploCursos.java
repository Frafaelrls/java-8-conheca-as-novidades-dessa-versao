import java.util.*;
import java.util.stream.Collectors;

class Curso {
    private String nome;
    private int alunos;

    public Curso(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public int getAlunos() {
        return alunos;
    }
}

public class ExemploCursos {
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<Curso>();
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 150));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("C", 55));


        cursos.sort((Comparator.comparing(Curso::getAlunos)));

        // stream pega uma coleção e cria um fluxo dessa coleção para poder ser manipulada
        // é um método que trabalha de forma lazzy
        // Stream: Analogamente, você pode imaginar um stream como uma linha de montagem em uma fábrica,
        // onde cada elemento passa por uma série de etapas de processamento.

        int sum = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .mapToInt(Curso::getAlunos)
                .sum();

        System.out.println(sum);

        // A classe Optional permite trabalhar de uma maneira mais organizada com possíveis valores null
        // sem a necessidade de comparar "if(algumaCoisa == null)"

        Optional<Curso> optionalCurso = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .findAny();

        // "optionalCurso.orElse(null)", Leia-se: "Me devolve um curso ou retorne null"
        Curso curso = optionalCurso.orElse(null);
        //System.out.println(curso.getNome());

        // "ifPresent", leia-se: "Se existir faça, se não, não faça
        optionalCurso.ifPresent(c -> System.out.println(c.getNome()));

        // Encadeando para ficar mais legível:

        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .findAny()
                .ifPresent(c -> System.out.println(c.getNome()));

        // Pasando a classe Collectors para retornar de uma stream para uma collection, neste caso para uma lista
        cursos = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .collect(Collectors.toList());

        cursos.stream()
                .forEach(c -> System.out.println(c.getNome()));

        // transformando com "toMap" o primeiro parâmetro é a chave o segundo é o valor
        Map<String, Integer> map = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .collect(Collectors.toMap(
                       c -> c.getNome(),
                        c-> c.getAlunos()
                ));

        System.out.println(map);

        // Um forEach de um map recebe dois parâmetros, sendo: chave e valor
        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .collect(Collectors.toMap(
                        c -> c.getNome(),
                        c-> c.getAlunos()))
                .forEach((nome, aluno) -> System.out.println(nome + " tem " + aluno + " alunos"));

    }
}

