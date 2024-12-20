import java.io.*;
import java.util.*;

/**
 * JuegoDeDeletreo es un juego donde el usuario debe teclear palabras presentadas en pantalla.
 * El puntaje depende de la rapidez y precisión con que se escriban las palabras.
 */
public class JuegoDeDeletreo {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static final String SCORES_FILE = "puntajes_obtenidos.dat";
    private static final List<Score> mejoresPuntuaciones = new ArrayList<>();
    
    /**
     * Método principal que inicia el juego y controla el menú principal.
     * 
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        cargarMejoresPuntuaciones();
        boolean jugando = true;
        while (jugando) {
            limpiarPantalla();
            mostrarMenu();
            int opcion = leerOpcion();
            switch (opcion) {
                case 1:
                    iniciarJuego();
                    break;
                case 2:
                    mostrarMejoresPuntuaciones();
                    break;
                case 3:
                    jugando = false;
                    break;
                default:
                    System.out.println("Opcion no valida. Intenta de nuevo.");
            }
        }
    }

    /**
     * Muestra el menú principal del juego.
     */
    private static void mostrarMenu() {
        System.out.println("1. Iniciar Juego");
        System.out.println("2. Mejores Puntuaciones");
        System.out.println("3. Salir del juego");
        System.out.print("Seleccione una opcion: ");
    }

    /**
     * Lee la opción seleccionada por el usuario desde el teclado.
     * 
     * @return La opción seleccionada por el usuario.
     */
    private static int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Inicia una nueva partida del juego, donde el usuario debe escribir palabras según la dificultad seleccionada.
     */
    private static void iniciarJuego() {
        System.out.println("Seleccione la dificultad: (1) Facil, (2) Medio, (3) Dificil");
        int dificultad = leerOpcion();
        String[] palabras;

        switch (dificultad) {
            case 1:
                palabras = new String[]{"gato", "perro", "casa", "luz", "sol", "lago", "paz"};
                break;
            case 2:
                palabras = new String[]{"elefante", "computadora", "naranja", "dificultad", "guitarra", "teclado", "programacion"};
                break;
            case 3:
                palabras = new String[]{"transcendental", "hipopotomonstrosesquipedaliofobia", "encriptacion", "paralelepipedo", "otorinolaringologo", "inconstitucional", "biocompatibilidad"};
                break;
            default:
                System.out.println("Dificultad no valida. Regresando al menu principal.");
                return;
        }

        List<String> listaPalabras = Arrays.asList(palabras);
        Collections.shuffle(listaPalabras);

        int puntajeTotal = 0;
        long tiempoTotal = 0;

        for (String palabra : listaPalabras) {
            System.out.println("Teclee la palabra: " + palabra);
            long inicio = System.currentTimeMillis();
            String entrada = scanner.nextLine();
            long fin = System.currentTimeMillis();

            if (entrada.equals(palabra)) {
                long tiempo = (fin - inicio) / 1000;
                int puntaje = Math.max(10 - (int) tiempo, 1);
                puntajeTotal += puntaje;
                tiempoTotal += tiempo;
                System.out.println("Correcto! Tiempo: " + tiempo + " segundos. Puntaje: " + puntaje);
            } else {
                System.out.println("Incorrecto. La palabra era: " + palabra);
            }
        }

        System.out.println("Juego terminado! Tiempo total: " + tiempoTotal + " segundos. Puntaje total: " + puntajeTotal);
        verificarMejoresPuntuaciones(puntajeTotal);
    }

    /**
     * Muestra las mejores puntuaciones almacenadas.
     */
    private static void mostrarMejoresPuntuaciones() {
        System.out.println("--- Mejores Puntuaciones ---");
        for (Score score : mejoresPuntuaciones) {
            System.out.println(score);
        }
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
    }

    /**
     * Verifica si el puntaje obtenido es suficiente para ingresar a las mejores puntuaciones.
     * 
     * @param puntajeTotal Puntaje total obtenido por el usuario.
     */
    private static void verificarMejoresPuntuaciones(int puntajeTotal) {
        if (mejoresPuntuaciones.size() < 10 || puntajeTotal > mejoresPuntuaciones.get(mejoresPuntuaciones.size() - 1).puntaje) {
            System.out.println("Felicidades! Obtuviste una puntuacion alta. Ingresa tu nombre: ");
            String nombre = scanner.nextLine();
            mejoresPuntuaciones.add(new Score(nombre, puntajeTotal));
            Collections.sort(mejoresPuntuaciones);
            if (mejoresPuntuaciones.size() > 10) {
                mejoresPuntuaciones.remove(mejoresPuntuaciones.size() - 1);
            }
            guardarMejoresPuntuaciones();
        }
        System.out.println("Presione Enter para regresar al menu principal...");
        scanner.nextLine();
    }

    /**
     * Carga las mejores puntuaciones desde un archivo.
     */
    private static void cargarMejoresPuntuaciones() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SCORES_FILE))) {
            Object obj = ois.readObject();
            if (obj instanceof List) {
                List<?> lista = (List<?>) obj;
                for (Object item : lista) {
                    if (item instanceof Score) {
                        mejoresPuntuaciones.add((Score) item);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de puntuaciones no encontrado. Se creara un nuevo archivo.");
        } catch (EOFException e) {
            System.out.println("Archivo de puntuaciones vacio.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar las mejores puntuaciones.");
        }
    }

    /**
     * Guarda las mejores puntuaciones en un archivo.
     */
    private static void guardarMejoresPuntuaciones() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SCORES_FILE))) {
            oos.writeObject(mejoresPuntuaciones);
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo para guardar las puntuaciones.");
        } catch (IOException e) {
            System.out.println("Error guardando las mejores puntuaciones.");
        } finally {
            System.out.println("Proceso de guardado finalizado.");
        }
    }

    /**
     * Limpia la pantalla de la consola.
     */
    private static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Clase que representa una puntuación obtenida por un jugador.
     */
    static class Score implements Serializable, Comparable<Score> {
        private final String nombre;
        private final int puntaje;

        /**
         * Constructor de la clase Score.
         * 
         * @param nombre Nombre del jugador.
         * @param puntaje Puntaje obtenido por el jugador.
         */
        public Score(String nombre, int puntaje) {
            this.nombre = nombre;
            this.puntaje = puntaje;
        }

        @Override
        public int compareTo(Score o) {
            return Integer.compare(o.puntaje, this.puntaje);
        }

        @Override
        public String toString() {
            return nombre + " - " + puntaje;
        }
    }
}

