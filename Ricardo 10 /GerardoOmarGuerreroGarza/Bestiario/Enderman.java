/**
 * Representa un Enderman, que se teletransporta y ataca si el jugador lo mira.
 * 
 * @autor Gerardo Omar
 * @version 1.0
 */
public class Enderman extends Monstruo {

    public Enderman() {
        super("Enderman", "Dimensión del End", true, "Alto y oscuro");
    }

    @Override
    public void morder() {
        System.out.println("El Enderman ataca al jugador al mirarlo fijamente.");
    }

    @Override
    public void debilidad() {
        System.out.println("Debilidad del Enderman: El agua le causa daño.");
    }

    @Override
    public void generar() {
        System.out.println("Un Enderman ha aparecido en " + ubicacion + ".");
    }

    public void teletransportarse() {
        System.out.println("El Enderman se teletransporta.");
    }

    public void recogerBloque() {
        System.out.println("El Enderman recoge un bloque del suelo.");
    }

    @Override
    public String toString() {
        return super.toString() + "\nDescripción: El Enderman puede teletransportarse y ataca si el jugador lo mira directamente.";
    }
}
