import java.util.Random;
import java.util.Scanner;

/**
 * Clase principal que simula una reproducción de canciones en modo aleatorio.
 * <p>
 * El programa crea una lista de 10 canciones y selecciona una al azar para reproducir.
 * Muestra la información principal y los detalles adicionales de la canción seleccionada.

 @author Omar
 @version 1.0
 * </p>
 */
public class Playlist {

    /**
     * Método principal que ejecuta el programa.
     * <p>
     * Crea 10 canciones, selecciona una al azar usando la clase {@link Random}, y muestra
     * la información de la canción seleccionada.
     * </p>
     * @param args Argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido a Spotify, presiona enter para reproducir una canción aleatoria");
        sc.nextLine();

        // Crear 10 canciones de manera individual
        Cancion cancion1 = new Cancion("Redbone", "hip hop experimental", "5:26", "Childish Gambino", "2016", "Awaken my love");
        Cancion cancion2 = new Cancion("Gone, Gone/ Thank you", "hip hop", "6:15", "Tyler the creator", "2019", "IGOR");
        Cancion cancion3 = new Cancion("Pink + White", "hip hop", "3:04", "Frank Ocean", "2016", "Blonde");
        Cancion cancion4 = new Cancion("Hotel California", "Rock", "6:30", "Eagles", "1976", "Hotel California");
        Cancion cancion5 = new Cancion("Billie Jean", "Pop", "4:54", "Michael Jackson", "1982", "Thriller");
        Cancion cancion6 = new Cancion("Smells Like Teen Spirit", "Grunge", "5:01", "Nirvana", "1991", "Nevermind");
        Cancion cancion7 = new Cancion("Shape of You", "Pop", "3:53", "Ed Sheeran", "2017", "Divide");
        Cancion cancion8 = new Cancion("Exit music", "Rock alternativo", "4:27", "Radiohead", "1997", "OK Computer");
        Cancion cancion9 = new Cancion("PARANORMAL", "Reguetón", "3:17", "Tainy", "2023", "DATA");
        Cancion cancion10 = new Cancion("Pagan Poetry", "Alternativa", "5:14", "Björk", "2001", "Vespertine");

        // Seleccionar una canción al azar usando Random
        Random random = new Random();
        int seleccion = random.nextInt(10) + 1; // Generar un número aleatorio entre 1 y 10

        // Usar un switch para reproducir una de las canciones según el número aleatorio
        Cancion cancionSeleccionada = null;

        switch (seleccion) {
            case 1:
                cancionSeleccionada = cancion1;
                break;
            case 2:
                cancionSeleccionada = cancion2;
                break;
            case 3:
                cancionSeleccionada = cancion3;
                break;
            case 4:
                cancionSeleccionada = cancion4;
                break;
            case 5:
                cancionSeleccionada = cancion5;
                break;
            case 6:
                cancionSeleccionada = cancion6;
                break;
            case 7:
                cancionSeleccionada = cancion7;
                break;
            case 8:
                cancionSeleccionada = cancion8;
                break;
            case 9:
                cancionSeleccionada = cancion9;
                break;
            case 10:
                cancionSeleccionada = cancion10;
                break;
        }

        // Mostrar la información de la canción seleccionada
        System.out.println("Reproduciendo...");
        cancionSeleccionada.imprimirInformacionPrincipal();
        cancionSeleccionada.imprimirDetallesAdicionales();
    }
}

/**
 * Clase que representa una canción.
 * <p>
 * La clase contiene atributos para el nombre de la canción, género, duración, nombre del artista,
 * año de lanzamiento y álbum. También proporciona métodos para imprimir la información de la canción.
 * </p>
 */
class Cancion {
    String nombre;
    String genero;
    String duracion;
    String nombreArtista;
    String año;
    String album;

    /**
     * Constructor que inicializa los atributos de la canción.
     *
     * @param nombre Nombre de la canción
     * @param genero Género de la canción
     * @param duracion Duración de la canción
     * @param nombreArtista Nombre del artista
     * @param año Año de lanzamiento
     * @param album Álbum de la canción
     */
    public Cancion(String nombre, String genero, String duracion, String nombreArtista, String año, String album) {
        this.nombre = nombre;
        this.genero = genero;
        this.duracion = duracion;
        this.nombreArtista = nombreArtista;
        this.año = año;
        this.album = album;
    }

    /**
     * Imprime la información principal de la canción: nombre, artista y duración.
     */
    public void imprimirInformacionPrincipal() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Artista: " + nombreArtista);
        System.out.println("Duración: " + duracion);
    }

    /**
     * Imprime los detalles adicionales de la canción: género, álbum y año de lanzamiento.
     */
    public void imprimirDetallesAdicionales() {
        System.out.println("Género: " + genero);
        System.out.println("Álbum: " + album);
        System.out.println("Año de lanzamiento: " + año);
    }
}
