/**
 * Representa una Bruja, que lanza pociones dañinas al jugador.
 * 
 * @autor Gerardo Omar
 * @version 1.0
 */
public class Bruja extends Monstruo {

    public Bruja() {
        super("Bruja", "Pueblos abandonados", false, "Humanoide");
    }

    @Override
    public void morder() {
        System.out.println("La Bruja no muerde, lanza una poción dañina.");
    }

    @Override
    public void debilidad() {
        System.out.println("Debilidad de la Bruja: Puede ser atacada en combate rápido.");
    }

    @Override
    public void generar() {
        System.out.println("Una Bruja ha aparecido en " + ubicacion + ".");
    }

    public void lanzarPocion() {
        System.out.println("La Bruja lanza una poción de veneno.");
    }

    public void reirse() {
        System.out.println("La Bruja se ríe de manera espeluznante.");
    }

    @Override
    public String toString() {
        return super.toString() + "\nDescripción: Lanza pociones de veneno y otras pociones dañinas para debilitar al jugador.";
    }
}
