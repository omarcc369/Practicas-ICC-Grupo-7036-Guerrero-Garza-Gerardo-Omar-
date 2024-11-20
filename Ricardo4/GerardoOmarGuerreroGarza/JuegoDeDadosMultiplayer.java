// Pedimos el nombre del usuario y apuesta inicial

import java.util.Scanner;
import java.util.Random;

public class JuegoDeDadosMultiplayer{

   
    
	public static void main(String []args){

 Scanner scanner = new Scanner(System.in);
	Random random = new Random();
	    
	    System.out.println("¡Bienvenidos al juego de Dados");
	    System.out.println("¿Cuál es tu nombre del jugador 1?");

	    String nombreUsuario1 = scanner.nextLine();

	    System.out.println("¿Cuál es tu nombre del jugador 2?");

            String nombreUsuario2 = scanner.nextLine();


	    System.out.println("Hola " + nombreUsuario1 +" ¿Cuánto vas a apostar?");

	    double apuestaInicial1 = scanner.nextDouble();

	    scanner.nextLine();

	      System.out.println("Hola " + nombreUsuario2 +" ¿Cuánto vas a apostar?");

	    double apuestaInicial2 = scanner.nextDouble();

	    scanner.nextLine();

	    //i y i2 son el dinero con el que empiezan los jugadores 

	    double i = apuestaInicial1;

	    double i2 = apuestaInicial2;
	    
	    if((i>0 && i<10000) && (i2>0 && i2<10000)){

		do{
		System.out.println("Presiona Enter para tirar el primer dado "+ nombreUsuario1 );
		String primerEnter1 = scanner.nextLine();

		int primerDado1 = random.nextInt(6)+1;

		System.out.println("El resultado del primer dado de " +nombreUsuario1+ " es: "+primerDado1);

		
		System.out.println("Presiona Enter para el segundo dado "+ nombreUsuario1);
		String segundoEnter1 = scanner.nextLine();
		int segundoDado1 = random.nextInt(6)+1;

	       	System.out.println("El resultado del segundo dado de " +nombreUsuario1+ " es: "+segundoDado1);

		System.out.println();

		int sumaDados1 = primerDado1 + segundoDado1;
		
		System.out.println("Tu resultado total es: "+sumaDados1);

		System.out.println();

				if(sumaDados1==2){
		    System.out.println("Lo siento has perdido :(, tu dinero será transferido a tu oponente");

		    i= i-i;
		    i2= i2+i;

		} else if (sumaDados1==12){

		    System.out.println("Felicidades ganaste $5000");
		    i += 5000;

			} else if (sumaDados1== 10){
		    System.out.println("Felicidades tu dinero será duplicado y el de tu oponente dividido");
		    i*= 2;
		    i2 /= 2;


		} else if(sumaDados1==7){

		    System.out.println("Lastima tu dinero será dividido entre dos y multiplicado por dos el de tu oponente :(");
		    i /= 2;
		    i2 *= 2;
		}else{
		    System.out.println("No paso nada carnal, vuelve a jugar");

		}

		System.out.println();
		System.out.println("Tu dinero actual es: $" + i  +"\n y el de tu oponente es: "+i2);
		System.out.println();


				if(i>= 10000){
 System.out.println("¡Felicidades has ganado la partida "+nombreUsuario1+" !");
 break;
 
		} else if(i<= 0){
 System.out.println("Que mal perdiste " +nombreUsuario1+" :(");
 break; 
		}
				
		//Segundo usuario

				System.out.println("Presiona Enter para tirar el primer dado "+ nombreUsuario2 );
		String primerEnter2 = scanner.nextLine();

		int primerDado2 = random.nextInt(6)+1;

		System.out.println("El resultado del primer dado de " +nombreUsuario2+ " es: "+primerDado2);

		
		System.out.println("Presiona Enter para el segundo dado "+ nombreUsuario2);
		String segundoEnter2 = scanner.nextLine();
		int segundoDado2 = random.nextInt(6)+1;

	       	System.out.println("El resultado del segundo dado de " +nombreUsuario2+ " es: "+segundoDado2);

		System.out.println();

		int sumaDados2 = primerDado2 + segundoDado2;
		
		System.out.println("Tu resultado total es: "+sumaDados2);

		System.out.println();

						if(sumaDados2==2){
		    System.out.println("Lo siento has perdido :(, tu dinero será transferido a tu oponente");

		    i2= i2-i2;
		    i= i+i2;

		} else if (sumaDados2==12){

		    System.out.println("Felicidades ganaste $5000");
		    i2 += 5000;

			} else if (sumaDados1== 10){
		    System.out.println("Felicidades tu dinero será duplicado y el de tu oponente dividido");
		    i2*= 2;
		    i /= 2;


		} else if(sumaDados1==7){

		    System.out.println("Lastima tu dinero será dividido entre dos y multiplicado por dos el de tu oponente :(");
		    i2 /= 2;
		    i *= 2;
		}else{
		    System.out.println("No paso nada carnal, vuelve a jugar");

		}

		System.out.println();
		System.out.println("Tu dinero actual es: $" + i2 +"\n y el de tu oponente es: "+i);
		System.out.println();


				if(i2>= 10000){
 System.out.println("¡Felicidades has ganado la partida"+nombreUsuario2 + "!");
 break;
 
		} else if(i2<= 0){
 System.out.println("Que mal perdiste "+nombreUsuario2+" :(");
 break; 
		}

		

		/**
		 *• Si el resultado fue 2, el usuario pierde autom ́aticamente.
• Si el resultado fue 12, el usuario gana $5000.
• Si el resultado fue 10, duplicamos el dinero del usuario.
• Si el resultado fue 7, dividimos el dinero del usuario.
• Todo otro caso, no operamos el dinero del usuario y continuamos
con otra ronda.*/






		}
		
		while(i>0 && i<10000 || i2>0 && i<100);

	
	    }
	    else{
		System.out.println("La apuesta no es válida, no puedes jugar" +"\n"+ "Tu dinero actual " +nombreUsuario1+" es:" + "$"+ i+ " y el de " +nombreUsuario2 + " es $" + i);
		System.exit(0);
		
	    }
	    
	}
    
}
