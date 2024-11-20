// Pedimos el nombre del usuario y apuesta inicial

import java.util.Scanner;
import java.util.Random;

public class JuegoDeDados{

   
    
	public static void main(String []args){

 Scanner scanner = new Scanner(System.in);
	Random random = new Random();
	    
	    System.out.println("¡Bienvenido al juego de Dados");
	    System.out.println("¿Cuál es tu nombre?");

	    String nombreUsuario = scanner.nextLine();

	    System.out.println("Hola " + nombreUsuario + " ¿Cuánto quieres apostar? (Elije un número del $1 a $10000, PERO SOLO ESCRIBE LA CANTIDAD NÚMERICA POR FAVOR)");

	    double apuestaInicial = scanner.nextDouble();

	    scanner.nextLine(); 

	    double i = apuestaInicial;
	    
	    if(i>0 && i<10000){

		do{
		System.out.println("Presiona Enter para tirar el primer dado");
		String primerEnter = scanner.nextLine();

		int primerDado = random.nextInt(6)+1;

		System.out.println("El resultado del primer dado es: "+primerDado);

		
		System.out.println("Presiona Enter para el segundo dado");
		String segundoEnter = scanner.nextLine();
		int segundoDado = random.nextInt(6)+1;

	       	System.out.println("El resultado del segundo dado es: "+segundoDado);

		System.out.println();

		int sumaDados = primerDado + segundoDado;
		
		System.out.println("Tu resultado total es: "+sumaDados);

		System.out.println();

		/**
		 *• Si el resultado fue 2, el usuario pierde autom ́aticamente.
• Si el resultado fue 12, el usuario gana $5000.
• Si el resultado fue 10, duplicamos el dinero del usuario.
• Si el resultado fue 7, dividimos el dinero del usuario.
• Todo otro caso, no operamos el dinero del usuario y continuamos
con otra ronda.*/

		if(sumaDados==2){
		    System.out.println("Lo siento has perdido :(");
		    System.exit(0);

		} else if (sumaDados==12){

		    System.out.println("Felicidades ganaste $5000");
		    i += 5000;

			} else if (sumaDados== 10){
		    System.out.println("Felicidades tu dinero será duplicado");
		    i*= 2;


		} else if(sumaDados==7){

		    System.out.println("Lastima tu dinero será dividido entre dos :(");
		    i /= 2;
		}else{
		    System.out.println("No paso nada carnal, vuelve a jugar");

		}

		System.out.println();
		System.out.println("Tu dinero actual es: $" + i + "( Recuerda que ganas si llegas a los $10000 y pierdes si te quedas en $0)");
		System.out.println();

		if(i>= 10000){
 System.out.println("¡Felicidades has ganado la partida!");
 break;
 
		} else if(i<= 0){
 System.out.println("Que mal perdiste :(");
 break; 
		}


		}
		
		while(i>0 && i<10000);

	
	    }
	    else{
		System.out.println("La apuesta no es válida, no puedes jugar" +"\n"+ "Tu dinero actual es: " + "$"+ i);
		System.exit(0);
		
	    }
	    
	}
    
}
