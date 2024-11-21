import java.util.Scanner;
import java.util.Random;

/**
 * Descripción de la clase.
 * 
 * @author Omar
 * @version 1.0
 */


/**
 * La clase `Dados` es el punto de entrada principal para el juego de dados.
 * Permite a dos jugadores realizar apuestas y jugar a un juego de dados donde las apuestas pueden cambiar
 * en función del resultado de los dados. El programa sigue ejecutándose hasta que uno de los jugadores gane o pierda.
 */
public class Dados {

    /**
     * El punto de entrada principal del programa.
     * Permite a los jugadores ingresar sus nombres y apuestas, y luego simula un juego de dados con opciones para ganar o perder dinero.
     *
     * @param args Los argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("¡Bienvenidos al juego de Dados");
        System.out.println("¿Cuál es tu nombre del jugador 1?");
        String nombreUsuario1 = scanner.nextLine();

        System.out.println("¿Cuál es tu nombre del jugador 2?");
        String nombreUsuario2 = scanner.nextLine();

        System.out.println("Hola " + nombreUsuario1 + " ¿Cuánto vas a apostar?");
        double apuestaInicial1 = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Hola " + nombreUsuario2 + " ¿Cuánto vas a apostar?");
        double apuestaInicial2 = scanner.nextDouble();
        scanner.nextLine();

        // i y i2 son el dinero con el que empiezan los jugadores
        double i = apuestaInicial1;
        double i2 = apuestaInicial2;

        Usuario u1 = new Usuario(nombreUsuario1, i);
        Usuario u2 = new Usuario(nombreUsuario2, i2);

        if ((i > 0 && i < 10000) && (i2 > 0 && i2 < 10000)) {
            do {
                System.out.println("Presiona Enter para tirar tus dados " + nombreUsuario1);
                String primerEnter1 = scanner.nextLine();
                int suerte1 = u1.TirarDados();
                System.out.println("El resultado de tus dados " + nombreUsuario1 + " es: " + suerte1);

                if (suerte1 == 2) {
                    i = u1.Perder(i, i2);
                    i2 = u2.SumarT(i, i2);
                    System.out.println("Lo siento has perdido, " + nombreUsuario1 + " todo tu dinero será transferido a tu oponente");
                } else if (suerte1 == 12) {
                    i = u1.Ganar5(i);
                    System.out.println("Felicidades, " + nombreUsuario1 + " has ganado $5000, ahora tu saldo es: " + i);
                } else if (suerte1 == 10) {
                    i = u1.Duplicar(i, i2);
                    i2 = u2.SerDivid(i2);
                    System.out.println("Felicidades tu dinero será duplicado " + nombreUsuario1 + " y el de tu oponente dividido");
                } else if (suerte1 == 7) {
                    i = u1.Dividir(i, i2);
                    i2 = u2.SerMulti(i2);
                    System.out.println("Lástima tu dinero será dividido " + nombreUsuario1 + " y el de tu oponente multiplicado");
                } else {
                    System.out.println("No pasó nada, vuelve a jugar");
                }

                System.out.println();
                System.out.println("Tu dinero actual es: $" + i + "\n y el de tu oponente es: " + i2);
                System.out.println();

                if (i >= 10000) {
                    System.out.println("¡Felicidades has ganado la partida " + nombreUsuario1 + "!");
                    break;
                } else if (i <= 0) {
                    System.out.println("Qué mal perdiste " + nombreUsuario1 + " :(");
                    break;
                }

                // Segundo usuario
                System.out.println("Presiona Enter para tirar tus dados " + nombreUsuario2);
                String primerEnter2 = scanner.nextLine();
                int suerte2 = u2.TirarDados();
                System.out.println("El resultado de tus dados " + nombreUsuario2 + " es " + suerte2);

                if (suerte2 == 2) {
                    i2 = u2.Perder(i2, i);
                    i = u1.SumarT(i, i2);
                    System.out.println("Lo siento has perdido, " + nombreUsuario2 + " todo tu dinero será transferido a tu oponente, ahora tu saldo es: " + i2 + " y el de " + nombreUsuario1 + " es " + i);
                } else if (suerte2 == 12) {
                    i2 = u2.Ganar5(i2);
                    System.out.println("Felicidades, " + nombreUsuario2 + " has ganado $5000, ahora tu saldo es: " + i2);
                } else if (suerte2 == 10) {
                    i2 = u2.Duplicar(i2, i);
                    i = u1.SerDivid(i);
                    System.out.println("Felicidades tu dinero será duplicado " + nombreUsuario2 + " y el de tu oponente dividido");
                } else if (suerte2 == 7) {
                    i2 = u2.Dividir(i2, i);
                    i = u1.SerMulti(i);
                    System.out.println("Lástima tu dinero será dividido " + nombreUsuario2 + " y el de tu oponente multiplicado");
                } else {
                    System.out.println("No pasó nada, vuelve a jugar");
                }

                if (i2 >= 10000) {
                    System.out.println("¡Felicidades has ganado la partida " + nombreUsuario2 + "!");
                    break;
                } else if (i2 <= 0) {
                    System.out.println("Qué mal perdiste " + nombreUsuario2 + " :(");
                    break;
                }

            } while (i > 0 && i < 10000 || i2 > 0 && i2 < 10000);
        } else {
            System.out.println("La apuesta no es válida, no puedes jugar" + "\n" + "Tu dinero actual " + nombreUsuario1 + " es: $" + i + " y el de " + nombreUsuario2 + " es $" + i2);
            System.exit(0);
        }
    }
} // Fin de la clase de los dados 

/**
 * La clase `Usuario` representa a un jugador en el juego de dados.
 * Mantiene el nombre del jugador y su saldo de apuesta, y proporciona métodos para manejar los resultados del juego de dados.
 */
class Usuario {
    private String nombre;
    private double apuesta;

    /**
     * Crea una nueva instancia de `Usuario` con el nombre y la apuesta inicial proporcionados.
     *
     * @param nombre El nombre del jugador.
     * @param apuesta El saldo inicial del jugador.
     */
    public Usuario(String nombre, double apuesta) {
        this.nombre = nombre;
        this.apuesta = apuesta;
    }

    /**
     * Simula el lanzamiento de dados y retorna un resultado aleatorio entre 1 y 12.
     *
     * @return El resultado del lanzamiento de dados.
     */
    public int TirarDados() {
        Random random = new Random();
        return random.nextInt(12) + 1;
    }

    /**
     * Maneja la situación en la que el jugador pierde. Transfiere todo el dinero del jugador al oponente.
     *
     * @param i El saldo actual del jugador que está perdiendo.
     * @param i2 El saldo del oponente que recibe el dinero.
     * @return El nuevo saldo del jugador que está perdiendo (siempre será 0).
     */
    public double Perder(double i, double i2) {
        i -= i;
        i2 += i;
        return i;
    }

    /**
     * Maneja la situación en la que el jugador gana $5000.
     *
     * @param i El saldo actual del jugador que está ganando.
     * @return El nuevo saldo del jugador que está ganando.
     */
    public double Ganar5(double i) {
        i += 5000;
        return i;
    }

    /**
     * Maneja la situación en la que el saldo del jugador se duplica y el saldo del oponente se divide a la mitad.
     *
     * @param i El saldo actual del jugador que está duplicando su dinero.
     * @param i2 El saldo del oponente que se dividirá.
     * @return El nuevo saldo del jugador que está duplicando su dinero.
     */
    public double Duplicar(double i, double i2) {
        i *= 2;
        i2 /= 2;
        return i;
    }

    /**
     * Maneja la situación en la que el saldo del jugador se divide a la mitad y el saldo del oponente se multiplica por dos.
     *
     * @param i El saldo actual del jugador que está dividiendo su dinero.
     * @param i2 El saldo del oponente que se multiplicará.
     * @return El nuevo saldo del jugador que está dividiendo su dinero.
     */
    public double Dividir(double i, double i2) {
        i /= 2;
        i2 *= 2;
        return i;
    }

    /**
     * Transfiere el saldo del oponente al jugador que ha ganado.
     *
     * @param i2 El saldo del oponente que se transfiere.
     * @param i El saldo del jugador que gana el dinero.
     * @return El nuevo saldo del oponente después de la transferencia.
     */
    public double SumarT(double i2, double i) {
        i2 += i;
        return i2;
    }

    /**
     * Divide el saldo del oponente a la mitad.
     *
     * @param i2 El saldo del oponente que se divide.
     * @return El nuevo saldo del oponente después de la división.
     */
    public double SerDivid(double i2) {
        i2 /= 2;
        return i2;
    }

    /**
     * Multiplica el saldo del oponente por dos.
     *
     * @param i2 El saldo del oponente que se multiplica.
     * @return El nuevo saldo del oponente después de la multiplicación.
     */
    public double SerMulti(double i2) {
        i2 *= 2;
        return i2;
    }
}
