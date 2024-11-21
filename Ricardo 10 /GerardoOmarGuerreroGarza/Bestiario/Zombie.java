/**
 * Representa un Zombie, que ataca cuerpo a cuerpo y persigue al jugador.
 * 
 * @autor Gerardo Omar
 * @version 1.0
 */
public class Zombie extends Monstruo {

    public Zombie() {
        super("Zombie", "Bosques y aldeas", true, "Descompuesto");
    }

    @Override
    public void morder() {
        System.out.println("El Zombie muerde y ataca cuerpo a cuerpo.");
    }

    @Override
    public void debilidad() {
        System.out.println("Debilidad del Zombie: Es lento y vulnerable a la luz del sol.");
    }

    @Override
    public void generar() {
        System.out.println("Un Zombie ha aparecido en " + ubicacion + ", buscando presas.");
    }

    public void perseguir() {
        System.out.println("El Zombie sigue al jugador incansablemente.");
    }

    public void gruñir() {
        System.out.println("El Zombie emite un sonido gutural.");
    }

    @Override
    public String toString() {
        return super.toString() + "\nDescripción: Un enemigo persistente que ataca cuerpo a cuerpo.";
    }
}
