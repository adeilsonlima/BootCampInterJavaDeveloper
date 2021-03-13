package br.com.adeilson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class ValidarSenha {
    public final static int MAX = 200;

    public static void main(String[] args) throws IOException {
        //	String8  = new String8(MAX);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //insira sua resolução suaClasseAqui

        String entrada = "";
        while ((entrada = br.readLine()) != null && entrada.length() != 0) {
            boolean isValid = false;
            boolean hasUpperCase = false;
            boolean hasLowerCase = false;
            boolean hasNumeric = false;
            boolean hasInvalid = false;
            if (entrada.length() < 6 || entrada.length() > 32)
                isValid = false;
            else {
                for (int ascii : entrada.toCharArray()) {
                    if (isBetween(ascii, 48, 57))//[0-9] -> 48-57
                        hasNumeric = true;
                    else if (isBetween(ascii, 65, 90))//[A-Z] -> 65-90
                        hasUpperCase = true;
                    else if (isBetween(ascii, 97, 122))//[a-z] -> 97-122
                        hasLowerCase = true;
                    else {//caracter invalido
                        hasInvalid = true;
                        break;
                    }
                }
                if (hasNumeric && hasLowerCase && hasUpperCase && !hasInvalid)
                    isValid = true;
            }
            //	if( ||  ||  ||  == 0) { //complete o if de acordo com suas variaveis
            if (!isValid) {
                System.out.println("Senha invalida.");
            } else {
                System.out.println("Senha valida.");
            }
        }
    }

    static boolean isBetween(int value, int lower, int upper) {
        return (value >= lower && value <= upper);
    }
}
