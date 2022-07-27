import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        
        List<Integer> lista = Arrays.asList(1, 6, 4, 3, 2, 6, 8, 0, 4, 3, 1);

        System.out.println("\n--------Laço For--------\n");
        
        //Loop tradicional
        for(Iterator<Integer> numero = lista.iterator(); numero.hasNext();){
            Integer integer = numero.next();
            System.out.println(integer);
        }

        System.out.println("\n--------For-Each--------\n");

        //For-Each
        for (Integer numero : lista) {
            System.out.println(numero);
        }

        System.out.println("\n--------Streams, Java 8 --------\n");
        /*
         * method reference: System.out::print
         */
        lista.stream()
            .skip(3) //pula os três primeiros números
            .limit(7) //litado busca a 7 números
            .distinct() //ignora repetição de números
            .forEach(System.out::print);
        /*
         * method filter: customização de filtros mais avançados,
         * ou que atenda uma necessidade específica.
         */
        System.out.println("\n-------- Método filter --------\n");
        lista.stream()
            .filter(e -> e % 2 == 0)
            .forEach(System.out::print);

        /*
         * method map: caso seja necessário realizar alguma validação/manipulação
         * antes de passar para o método stream.
         */
        System.out.println("\n-------- Método map --------\n");
        lista.stream()
            .map(e -> e * 50)
            .forEach(e -> System.out.print(e+" "));   
            
        /*
         * methods: max, min e count.
         */
        System.out.println("\n-------- Maior, Menor e Count --------\n");
        Optional<Integer> maior = lista.stream()
            .max(Comparator.naturalOrder());
        System.out.println("Maior é: "+maior.get());

        Optional<Integer> menor = lista.stream()
            .min(Comparator.naturalOrder());
        System.out.println("Menor é: "+menor.get());

        Long qtd = lista.stream()
            .count();
        System.out.println("Quantidade: "+qtd);

        System.out.println("\n-------- Collectors(Agrupamento) --------\n");
        Map<Boolean, List<Integer>> mapa = lista.stream()
        .map(e -> e* 2)
        .collect(Collectors.groupingBy(e -> e > 10));
        System.out.println("Agrupamento > 10: "+mapa);
        
        System.out.println("\n-------- Collectors(Joining) --------\n");
        /*
         * Gerar uma única string com todos os valores.
         */
        String texto = lista.stream()
        .map(String::valueOf)
        .collect(Collectors.joining(";"));
        System.out.println(texto);

    }
}
