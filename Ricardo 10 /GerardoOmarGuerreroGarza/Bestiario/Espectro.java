/**
 * Representa un Espectro, que ataca si el jugador no ha dormido en varios días.
 * 
 * @autor Gerardo Omar
 * @version 1.0
 */
public class Espectro extends Monstruo {

    public Espectro() {
        super("Espectro", "Cielos nocturnos", true, "Fantasmagórico");
    }

    @Override
    public void morder() {
        System.out.println("El Espectro vuela y ataca desde el aire.");
    }

    @Override
    public void debilidad() {
        System.out.println("Debilidad del Espectro: Es vulnerable a la luz del sol.");
    }

    @Override
    public void generar() {
        System.out.println("Un Espectro ha aparecido en " + ubicacion + " debido a la falta de sueño del jugador.");
    }

    public void volar() {
        System.out.println("El Espectro vuela por el aire en busca de su objetivo.");
    }

    public void atacarDesdeArriba() {
        System.out.println("El Espectro ataca desde las alturas, descendiendo rápidamente.");
    }

    @Override
    public String toString() {
        return super.toString() + "\nDescripción: Aparece si el jugador no ha dormido en varios días y vuela para atacar.";
    }
}
