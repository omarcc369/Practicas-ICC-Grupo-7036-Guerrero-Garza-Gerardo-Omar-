import java.util.Scanner;

/**
 * Clase principal que simula una búsqueda de canciones por atributos.
 * El programa toma dos argumentos de la línea de comandos: el número máximo de resultados
 * a mostrar y el atributo a buscar. Busca entre todas las canciones creadas alguna que
 * contenga el atributo, y si se encuentran coincidencias, muestra los datos de la canción.
 * 
 * @author Gerardo Omar
 * @version 1.0
 */
public class Spotify {

    /**
     * Método principal que ejecuta el programa.
     * Crea 10 canciones, busca coincidencias basadas en el atributo ingresado por
     * línea de comandos y muestra un número limitado de resultados.
     * 
     * @param args Argumentos de la línea de comandos: [Número de resultados, Atributo de búsqueda]
     */
    public static void main(String[] args) {
        // Validar que se proporcionen los argumentos necesarios
        if (args.length < 2) {
            System.out.println("Por favor, ingresa el número de resultados a mostrar y el atributo a buscar.");
            return;
        }

        // Obtener los argumentos de la línea de comandos
        int maxResultados = Integer.parseInt(args[0]);
        String atributoBusqueda = args[1].toLowerCase(); // Convertir a minúsculas para hacer búsqueda insensible a mayúsculas

        // Crear 10 canciones de manera individual
        Cancion[] canciones = {
            new Cancion("Redbone", "hip hop experimental", "5:26", "Childish Gambino", "2016", "Awaken my love"),
            new Cancion("Gone, Gone/ Thank you", "hip hop", "6:15", "Tyler the creator", "2019", "IGOR"),
            new Cancion("Pink + White", "hip hop", "3:04", "Frank Ocean", "2016", "Blonde"),
            new Cancion("Hotel California", "Rock", "6:30", "Eagles", "1976", "Hotel California"),
            new Cancion("COLMILLO", "Requetón", "4:25","Tainy", "2023", "DATA" ),
            new Cancion("No Surprises", "Rock alternativo", "3:49", "RadioHead", "1997", "OK Computer"),
            new Cancion("Shape of You", "Pop", "3:53", "Ed Sheeran", "2017", "Divide"),
            new Cancion("Exit music", "Rock alternativo", "4:27", "Radiohead", "1997", "OK Computer"),
            new Cancion("PARANORMAL", "Reguetón", "3:17", "Tainy", "2023", "DATA"),
            new Cancion("Pagan Poetry", "Alternativa", "5:14", "Björk", "2001", "Vespertine")
        };

        int resultadosMostrados = 0;

        System.out.println("Buscando: " + atributoBusqueda);
        System.out.println("Resultados de la búsqueda (Limitado a " + maxResultados + "):");
        System.out.println("--------------------------------");

        // Buscar canciones que coincidan con el atributo
        for (Cancion cancion : canciones) {
            if (resultadosMostrados >= maxResultados) break; // Detenerse si se alcanzó el límite de resultados

            if (cancion.tieneAtributo(atributoBusqueda)) {
                cancion.imprimirInformacionCompleta();
                System.out.println("--------------------------------");
                resultadosMostrados++;
            }
        }

        // Si no se encontraron coincidencias, mostrar mensaje
        if (resultadosMostrados == 0) {
            System.out.println("No hubo coincidencias en la búsqueda.");
        }
    }
}

/**
 * Clase que representa una canción.
 * La clase contiene atributos para el nombre de la canción, género, duración, nombre del artista,
 * año de lanzamiento y álbum. También proporciona métodos para imprimir la información de la canción.
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
     * Verifica si la canción contiene el atributo especificado.
     * Compara el atributo con cada uno de los atributos de la canción (nombre, género, duración, artista, año, álbum).
     *
     * @param atributo El atributo a buscar en la canción
     * @return true si se encuentra coincidencia, false en caso contrario
     */
    public boolean tieneAtributo(String atributo) {
        return nombre.toLowerCase().contains(atributo) ||
               genero.toLowerCase().contains(atributo) ||
               duracion.toLowerCase().contains(atributo) ||
               nombreArtista.toLowerCase().contains(atributo) ||
               año.toLowerCase().contains(atributo) ||
               album.toLowerCase().contains(atributo);
    }

    /**
     * Imprime toda la información de la canción.
     */
    public void imprimirInformacionCompleta() {
        System.out.println("Nombre de la Cancion: " + nombre);
        System.out.println("Artista: " + nombreArtista);
        System.out.println("Album: " + album);
        System.out.println("Duracion: " + duracion);
        System.out.println("Lanzamiento: " + año);
        System.out.println("Genero: " + genero);
    }
}
