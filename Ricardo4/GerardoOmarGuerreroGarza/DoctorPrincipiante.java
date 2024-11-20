import java.util.Scanner;

public class DoctorPrincipiante{

    

    public static void main(String [] args){

	Scanner scanner = new Scanner(System.in);

	System.out.println("¡Bienvenido a mi consultorio");
	System.out.println("¿Cuál es tu nombre?");

	String nombre= scanner.nextLine();

	System.out.println("¿Cuál es tu edad en años " + nombre  +"? (Escribe sólo la cantidad númerica)");

	int edad = scanner.nextInt();
	
	System.out.println("¿Cuál es tu peso " +nombre +"?  (Escribe sólo la cantidad númerica)");

	double peso = scanner.nextDouble();

	/**• Si la edad es mayor de 75, recomendar una funeraria
• Si la edad es menor de 18 años, recomendar un pediatra
• Si el peso es menor de 50 kg, recomendar un puesto de tacos
• Si el peso es mayor de 150 kg, recomendar una dieta
	*/

	String diagnostico = "";

	if(edad>75){

	    diagnostico += " \n -Te recomiendo una funeraria";
	}
	else{

	    diagnostico = diagnostico;}
	

	if(edad<18){
	    diagnostico += " \n  -Te recomiendo ir a un pediatra";

	}
		else{

	    diagnostico = diagnostico;}
	

	if(peso<50.0){

	    diagnostico += " \n -Vete a chingarte unos tacos";
	   
	}
		else{

	    diagnostico = diagnostico;}

	if(peso>150.0){

	    diagnostico += " \n -Ya metele a la dieta pa";
	}
		else{

	    diagnostico = diagnostico;}

	System.out.println("Tu diagnostico es: "+ diagnostico);

	if(diagnostico==""){

	    System.out.println("Pues al paracer estás bien pero...");
	}
	

	System.out.println();
			      

		Scanner sc = new Scanner(System.in);


	System.out.println("Mmmm... ¿qué le sucede?");
	
	    String padecimiento = sc.nextLine();
	  
	    System.out.println("Mmmm ya veo, dígame ¿Qué hizo para padecer " + padecimiento+ "?");

	    String causa =  sc.nextLine();

	    System.out.println("Ok le voy a recetar un PARACETAMOL, hasta luego...");

    }

    

}
