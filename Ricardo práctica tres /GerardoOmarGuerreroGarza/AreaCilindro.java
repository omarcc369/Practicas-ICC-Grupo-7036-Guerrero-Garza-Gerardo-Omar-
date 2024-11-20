public class AreaCilindro{

    /*Programa que calcula el área de un cilindro

      Datos:

      - radio de la base: 3 cm
      - altura del cilindro: 9 cm

      Fórmula:

      A= 2πr(h+r)

    
    */
    
    public static void main(String [] args){


    float pi = 3.141592f;
final    int radio= 3;
final    int altura = 9;

    //Paso 1: Multiplicar 2*pi*radio de la base

    double Paso1 = 2*pi*radio;

    //Paso 2: Sumar altura más radio

    double Paso2 = altura + radio;

    //Paso 3: Multiplicar ambos pasos para obtener el área total del cilindro

    double Paso3 = Paso1 * Paso2;

	System.out.println("El radio de la base del cilindro es: " + radio + " cm");
         System.out.println("La altura del cilindro es: " + altura + " cm");
	 System.out.println("Y... el área total del cilindro es: " + Paso3 + " cm²");


    }


}
