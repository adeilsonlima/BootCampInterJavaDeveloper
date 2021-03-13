import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;


public class ConjuntosBonsRuins {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //insira sua solução aqui
        while (true) {
            String linhaLida = br.readLine();
            if (linhaLida.length() == 1 && linhaLida.contentEquals("0")) break;
            int N = Integer.parseInt(linhaLida);
            if(N <1 || N>100000) break;

            List<String> entradas = new LinkedList<String>();
            for(int i=0; i< N; ++i){
                entradas.add(br.readLine());
            }
            Collections.sort(entradas);

            boolean contains = false;
            for (int i=1; i< N;++i){
                if(entradas.get(i).startsWith(entradas.get(i-1)))
                    contains = true;
            }
            if (contains)
                System.out.println("Conjunto Ruim");
            else
                System.out.println("Conjunto Bom");
        }

    }
}