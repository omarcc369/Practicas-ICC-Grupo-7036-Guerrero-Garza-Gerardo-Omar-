public class Hackerman {

    public static void main(String[] args) {

        int base = 3, exponente = 4;
        double resultado = 1;

        while (exponente != 0) {
            resultado *= base;
            --exponente;
        }

	System.out.println("Este programa lo que hace es multiplicar un número (en este caso 3) 4 veces por si mismo, pero lo hace por partes por medio del condicional 'while', este condicional lo que nos indica es que mientras la variable y (el exponente) sea diferente de 0, multplicara 3 por si mismo las veces que valga y.		   \n En otras palabaras con este programa se obtiene el valor de elevar a 3 a la 4ta potencia: 3⁴");
	
        System.out.println("Resultado = " + resultado);
    }
}
