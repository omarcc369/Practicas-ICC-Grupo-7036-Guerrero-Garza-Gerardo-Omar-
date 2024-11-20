public class DatosOmar{


    public static void main(String[] args){

    String nombre = "Gerardo Omar Guerrero Garza";
	int  edad = 18;
	double peso=  62;
	float altura = 1.65f;
	final String música = "Me gusta mucho la música de Tainy, DATA>>>>>>Cualquier álbum del género urbano";

	/* Ahora voy a convertir los datos a días, libras y pies*/

	edad *= 365;
	peso *= 2.20462;
	altura *= 3.28084;

	System.out.println("Mis días vividos son: " +edad+ " días");
	System.out.println("Mi peso en libras es: " +peso +" libras");
       	System.out.println("Mi altura en pies es: " +altura+" pies");
	System.out.println("Mis gustos musicales son: " +música);
    
}
}
