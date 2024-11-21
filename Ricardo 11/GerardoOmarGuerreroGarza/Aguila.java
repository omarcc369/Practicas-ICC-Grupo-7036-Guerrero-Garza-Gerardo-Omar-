import java.util.Random; 

/**
 * Clase Aguila que representa un águila depredadora en el ecosistema.
 * Implementa la interfaz Depredador.
 * <p>
 * Un águila intenta cazar y tiene una probabilidad de éxito o fracaso.
 * </p>
 * 
 * @author Gerardo Omar
 * @version 1.0
 */
public class Aguila implements Depredador{

    /**
     * Método que simula la acción de cazar de un águila.
     * La probabilidad de éxito es determinada de manera aleatoria.
     */
    public void cazar(){
        System.out.println("El aguila vio una serpiente en un nopal y y quiere acercarse para alimentarse de ella...");
        Random rd = new Random(); 
        int azar= rd.nextInt(11);
        if (azar< 5){
            System.out.println("No lo logro y ahora volara con el estómago vacio");
        } else{ 
            System.out.println("Si lo logro y ahora se fue volando por los cielos...");
        }
    }
}
