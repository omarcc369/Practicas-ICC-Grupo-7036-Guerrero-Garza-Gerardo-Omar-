/**
 * Representa un Creeper, que explota cuando se acerca al jugador.
 * 
 * @autor Gerardo Omar
 * @version 1.0
 */
public class Creeper extends Monstruo {

    public Creeper() {
        super("Creeper", "Bosques y cuevas", false, "Explosiva");
    }

    @Override
    public void morder() {
        System.out.println("El Creeper no muerde, en su lugar, explota cerca de su objetivo.");
    }

    @Override
    public void debilidad() {
        System.out.println("Debilidad del Creeper: Puede ser atacado desde lejos antes de explotar.");
    }

    @Override
    public void generar() {
        System.out.println("Un Creeper ha aparecido en " + ubicacion + " y está listo para explotar.");
    }

    public void explotar() {
        System.out.println("El Creeper explota, causando daño en un área cercana.");
    }

    public void acechar() {
        System.out.println("El Creeper se mueve en silencio, acercándose a su presa.");
    }

    @Override
    public String toString() {
        return super.toString() + "\nDescripción: El Creeper es un monstruo explosivo que se acerca sigilosamente para detonar.";
    }
}
