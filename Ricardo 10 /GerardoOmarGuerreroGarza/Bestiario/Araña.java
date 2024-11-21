/**
 * Representa una Araña, que puede escalar paredes y atacar en la oscuridad.
 * 
 * @autor Gerardo Omar
 * @version 1.0
 */
public class Araña extends Monstruo {

    public Araña() {
        super("Araña", "Cuevas y superficies oscuras", false, "Pequeña y rápida");
    }

    @Override
    public void morder() {
        System.out.println("La Araña muerde al jugador.");
    }

    @Override
    public void debilidad() {
        System.out.println("Debilidad de la Araña: Es más vulnerable a la luz del día.");
    }

    @Override
    public void generar() {
        System.out.println("Una Araña ha aparecido en " + ubicacion + ".");
    }

    public void escalar() {
        System.out.println("La Araña escala una pared.");
    }

    public void acecharEnLaOscuridad() {
        System.out.println("La Araña espera en la oscuridad para atacar.");
    }

    @Override
    public String toString() {
        return super.toString() + "\nDescripción: Escala paredes y ataca en la oscuridad o en espacios cerrados.";
    }
}
