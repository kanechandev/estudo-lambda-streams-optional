import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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

    }
}
