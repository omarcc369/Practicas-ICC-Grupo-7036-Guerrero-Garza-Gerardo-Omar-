import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Aplicación Bestiario que permite al usuario seleccionar diferentes monstruos
 * y obtener información sobre ellos. Proporciona un menú interactivo para
 * explorar las características y habilidades de cada monstruo.
 * <p>
 * Cada monstruo implementa métodos de comportamiento y debilidades, y el usuario
 * puede seleccionar un monstruo para ver detalles adicionales. La aplicación
 * continúa ejecutándose en un bucle hasta que el usuario decide salir.
 * </p>
 * 
 * @author Gerardo Omar
 * @version 1.0
 */
public class BestiarioApp {
    
    /**
     * Método principal que ejecuta la aplicación Bestiario.
     * <p>
     * Este método inicializa un array de diferentes monstruos, muestra un menú
     * con las opciones disponibles y permite al usuario seleccionar un monstruo
     * para ver sus detalles. También maneja excepciones de entrada para asegurar
     * que el programa no falle debido a entradas no válidas.
     * </p>
     * 
     * @param args Los argumentos de línea de comandos (no utilizados en esta aplicación).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        // Array de monstruos disponibles en el bestiario
        Monstruo[] monstruos = {
            new Creeper(),
            new Esqueleto(),
            new Zombie(),
            new Enderman(),
            new Araña(),
            new Bruja(),
            new Espectro()
        };

        // Bucle del menú interactivo
        while (continuar) {
            System.out.println("----- BESTIARIO -----");
            for (int i = 0; i < monstruos.length; i++) {
                System.out.println("[" + (i + 1) + "] " + monstruos[i].getClass().getSimpleName());
            }
            System.out.println("[0] Salir");
            System.out.print("Seleccione un monstruo para aprender más: ");
            
            try {
                int opcion = scanner.nextInt();
                System.out.println();

                if (opcion == 0) {
                    continuar = false;
                    System.out.println("Saliendo del Bestiario...");
                } else if (opcion > 0 && opcion <= monstruos.length) {
                    // Se muestra la información del monstruo seleccionado
                    Monstruo seleccionado = monstruos[opcion - 1];
                    System.out.println(seleccionado.toString());
                    seleccionado.morder();
                    seleccionado.debilidad();
                    seleccionado.generar();
                    System.out.println();
                } else {
                    System.out.println("Opción no válida. Intente de nuevo.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número. Intente de nuevo.");
                scanner.next(); // limpiar el buffer
            }
        }
        
        scanner.close();
    }
}
