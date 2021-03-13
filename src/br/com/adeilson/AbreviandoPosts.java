package br.com.adeilson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class AbreviandoPosts {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String linhaLida = br.readLine();
            if(linhaLida.length()==1 && linhaLida.contentEquals(".")) break;
            StringTokenizer st = new StringTokenizer(linhaLida);

            //insira sua solução aqui
            List<String> textoOriginal = new ArrayList<String>();

            String palavra = "";
            int somaLetras = 0;
            var somaPalavras = new LinkedHashMap<String, Integer>();
            while (st.hasMoreTokens()) {
                palavra = st.nextToken();
                textoOriginal.add(palavra);
                if (palavra.length() > 2) {
                    somaLetras = 0;
                    if (somaPalavras.containsKey(palavra))
                        somaLetras = somaPalavras.get(palavra);
                    somaPalavras.put(palavra, somaLetras + (palavra.length() - 2));
                }
            }
            var palavrasCandidatas = somaPalavras.entrySet().iterator();
            var palavrasEleitas = new HashMap<Character, Map.Entry<String, Integer>>();
            for (char letra : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
                palavrasEleitas.put(letra, new AbstractMap.SimpleEntry<String, Integer>("", 0));
            }
            while (palavrasCandidatas.hasNext()) {
                Map.Entry<String, Integer> palavraAtual = palavrasCandidatas.next();
                char letraInicial = palavraAtual.getKey().charAt(0);
                if (palavrasEleitas.get(letraInicial).getValue() < palavraAtual.getValue())
                    palavrasEleitas.put(letraInicial, palavraAtual);
            }

            var palavrasParaSubstituir = new ArrayList<String>();
            for (var palavras : palavrasEleitas.values()) {
                if (!palavras.getKey().isBlank())
                    palavrasParaSubstituir.add(palavras.getKey());
            }

            for (String wordEleita : palavrasParaSubstituir) {
                for (int i = 0; i < textoOriginal.size(); ++i) {
                    if (textoOriginal.get(i).contentEquals(wordEleita)) {
                        textoOriginal.set(i, wordEleita.charAt(0) + ".");
                    }
                }
            }
            String textoFinal = "";
            for (String s : textoOriginal) {
                textoFinal += s + " ";
            }
            System.out.println(textoFinal);
            System.out.println(palavrasParaSubstituir.size());
            palavrasParaSubstituir.forEach(
                    w -> System.out.println(w.charAt(0) + ". = " + w)
            );
        }
    }
}
