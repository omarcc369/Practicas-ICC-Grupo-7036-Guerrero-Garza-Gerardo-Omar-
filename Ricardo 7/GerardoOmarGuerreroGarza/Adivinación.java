import java.util.Scanner;
import java.util.Random;

/**
 * La clase Adivinación simula una lectura de tarot donde se selecciona una carta al azar
 * de los arcanos mayores. Cada carta tiene un significado especial que se muestra 
 * al usuario.
 * 
 * La clase utiliza la clase Scanner para la entrada de usuario y Random para 
 * seleccionar una carta al azar.
 * 
 * <p> Contiene el método principal (main) que permite al usuario interactuar con
 * el programa y obtener una carta con su respectivo significado.</p>
 * 
 * @author Gerardo Omar
 * @version 1.0
 */
public class Adivinación {

    /**
     * El método main es el punto de entrada de la aplicación. Simula una lectura de tarot
     * seleccionando y mostrando una carta de los arcanos mayores al azar.
     * 
     * @param args Argumentos de línea de comando, no utilizados en este programa.
     */
    public static void main (String [] args){

        Scanner sc = new Scanner (System.in);
        Random rd = new Random();

        System.out.println("Bienvenido al Tarot");
        System.out.println("Las cartas se están barajeando...");

        // Array que contiene las descripciones de cada una de las 22 cartas principales de los arcanos mayores.
        String [] cartas = {
            "El Loco: Nuevos comienzos, aventura, libertad. Augura un salto de fe y nuevas oportunidades.",
            "El Mago: Habilidad, destreza, poder. Indica el uso de habilidades y recursos para alcanzar metas.",
            "La Sacerdotisa: Intuición, misterio, conocimiento oculto. Sugiere confiar en la intuición y el conocimiento interno.",
            "La Emperatriz: Fertilidad, abundancia, naturaleza. Predice crecimiento, creatividad y prosperidad.",
            "El Emperador: Autoridad, estructura, control. Señala estabilidad y liderazgo.",
            "El Hierofante: Tradición, espiritualidad, enseñanza. Indica la búsqueda de guía espiritual o educación.",
            "Los Enamorados: Amor, relaciones, decisiones. Augura elecciones importantes en relaciones y armonía.",
            "El Carro: Victoria, determinación, control. Predice éxito a través de la fuerza de voluntad.",
            "la Justicia: Equilibrio, justicia, verdad. Señala decisiones justas y consecuencias equilibradas.",
            "El Ermitaño: Introspección, soledad, sabiduría. Sugiere un período de reflexión y búsqueda interna.",
            "La Rueda de la fortuna: Cambio, destino, ciclos. Indica cambios inevitables y giros del destino.",
            "La Fuerza: Coraje, paciencia, control interno. Predice superar desafíos con fuerza interna.",
            "El Colgado: Sacrificio, perspectiva, pausa. Señala la necesidad de ver las cosas desde otro ángulo.",
            "La Muerte: Transformación, final, renacimiento. Indica el fin de una etapa y el comienzo de otra.",
            "La Templanza: Moderación, equilibrio, armonía. Sugiere la necesidad de equilibrio y paciencia.",
            "El Diablo: Tentación, materialismo, ataduras. Predice enfrentarse a adicciones o comportamientos negativos.",
            "La Torre: Ruina, cambio repentino, revelación. Indica cambios drásticos y revelaciones inesperadas.",
            "La Estrella: Esperanza, inspiración, serenidad. Augura un período de paz y renovación.",
            "La luna: Ilusión, intuición, confusión. Señala la necesidad de confiar en la intuición y enfrentar miedos.",
            "El Sol: Éxito, vitalidad, alegría. Predice felicidad, éxito y claridad.",
            "El Juicio: Renacimiento, evaluación, despertar. Indica un llamado a la acción y autoevaluación.",
            "El Mundo: Finalización, éxito, realización. Señala la culminación de un ciclo y la realización de metas."
        };

        System.out.println("Para elegir su carta al azar presione enter");

        sc.nextLine();

        // Genera un número aleatorio entre 0 y 21 para seleccionar una carta al azar
        int azar = rd.nextInt(21);

        // Almacena la carta seleccionada al azar
        String azarCarta = cartas[azar];

        // Muestra la carta seleccionada con su descripción correspondiente
        System.out.println("Tu suerte es: " + azarCarta );

    } // Fin de método main 

} // Fin de clase
