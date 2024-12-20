import java.util.Scanner;

/**
 * La clase Restaurante simula la interacción con un cliente en una taquería, donde
 * el usuario ingresa la cantidad de tacos que desea pedir y especifica el tipo de taco.
 * El programa muestra la orden completa y el precio total basado en la cantidad de tacos pedidos.
 * 
 * <p> Contiene el método principal (main) que guía al usuario a través del proceso de 
 * selección de tacos y calcula el costo total de la orden.</p>
 * 
 * @author Gerardo Omar
 * @version 1.0
 */
public class Restaurante {

    /**
     * El método main es el punto de entrada de la aplicación. Permite al usuario 
     * interactuar para realizar un pedido de tacos, especificando la cantidad y el tipo de taco.
     * Luego muestra la orden completa y calcula el costo total.
     * 
     * @param args Argumentos de línea de comando, no utilizados en este programa.
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("¡Hola, bienvenidos a taquería 'EL GÜERO' \n ¿Cuántos tacos va a querer?");

        int num = sc.nextInt();

        // Si el usuario no desea tacos, el programa se cierra automáticamente.
        if (num == 0) {
            System.exit(0);
        }
        
        sc.nextLine(); // Consumir el salto de línea pendiente después de nextInt()

        // Arreglo que almacena la descripción de cada taco ordenado.
        String[] orden = new String[num];

        // Bucle para registrar el tipo de taco para cada orden ingresada.
        for (int i = 0; i < num; i++) {

            if (i == 0) {
                System.out.println("¿De qué van a ser?");
                orden[i] = sc.nextLine();

            } else {
                System.out.println("¿De qué más?");
                orden[i] = sc.nextLine();
            }
        }

        System.out.println("Vavava salen " + num + " tacos joven");

        // Mostrar cada taco ordenado con su respectivo tipo.
        for (int i = 0; i < num; i++) {
            System.out.println("Sale un " + orden[i]);
        }

        // Calcular el precio total: cada taco tiene un costo de 15 pesos.
        int precio = num * 15;
        System.out.println("Serían nada más y nada menos que: " + precio + " pesos");

    } // Fin de método main 

} // Fin de clase
