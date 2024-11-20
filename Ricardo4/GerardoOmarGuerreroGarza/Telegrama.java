import java.util.Scanner;

public class Telegrama{

    public static void main(String[] args){
	Scanner scanner = new Scanner(System.in);

	System.out.println("¿Cuál es tu nombre?");
	String nombreRemitente = scanner.nextLine();

	System.out.println("¿A quién se lo envías?");
	String destinatario = scanner.nextLine();

	System.out.println("Escribe a continuación tu mensaje:");
	String mensaje = scanner.nextLine();


String	mensajeParaContar = mensaje.replace(" ", "");
	long letrasM = mensajeParaContar.length();
	letrasM *= 3; 
	

	System.out.println("Tu mensaje te costará: "+letrasM +" pesos ¿deseas continuar?"); 
	String desicion = scanner.nextLine();

String	desicionMayus = desicion.toUpperCase();
desicionMayus = desicionMayus.trim(); 

if(desicionMayus.contains("S")){

	    System.out.println("¡Tu telegrama ha sido enviado con éxito!");
	}

        else{
	    
	    String mensajeBully= mensaje.replaceAll("[aAáÁeEéÉiIíÍoOóÓ]", "u");

	    System.out.println("Jajajajaj que menso: " + mensajeBully); 
	    
		
	    
	}
    


	    }
	
	

    }

    

