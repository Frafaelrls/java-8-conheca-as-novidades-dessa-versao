import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {
    public static void main(String[] args) {
        List<String> palavras = new ArrayList<>();
        palavras.add("alura online");
        palavras.add("editora casa do código");
        palavras.add("caelum");


        palavras.sort((s1, s2) -> {
            if (s1.length() < s2.length())
                return -1;
            if (s1.length() > s2.length())
                return 1;
            return 0;

        });

        // palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

        palavras.sort(Comparator.comparing(s -> s.length()));
        palavras.sort(Comparator.comparing(String::length));


        System.out.println(palavras);

//        for (String p : palavras) {
//            System.out.println(p);
//        }

        // Antes de usar a função lambda
//       palavras.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });



        // Usando Função lambda
        palavras.forEach(s -> System.out.println(s));
        // Usando Method Reference
        // Pode ser usado quando é invocado apenas um método
        // e não é passado argumentos
        palavras.forEach(System.out::println);


    }
}


class ComparadorDeStringPorTamanho implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        if (s1.length() < s2.length())
            return -1;
        if (s1.length() > s2.length())
            return 1;
        return 0;
    }
}