/**
 * Representa un Esqueleto, que ataca desde la distancia usando arco y flechas.
 * 
 * @autor Gerardo Omar
 * @version 1.0
 */
public class Esqueleto extends Monstruo {

    public Esqueleto() {
        super("Esqueleto", "Bosques y terrenos abiertos", true, "Ósea");
    }

    @Override
    public void morder() {
        System.out.println("El Esqueleto no muerde, dispara una flecha.");
    }

    @Override
    public void debilidad() {
        System.out.println("Debilidad del Esqueleto: Vulnerable en combate cuerpo a cuerpo.");
    }

    @Override
    public void generar() {
        System.out.println("Un Esqueleto aparece con su arco y flechas en " + ubicacion + ".");
    }

    public void dispararFlecha() {
        System.out.println("El Esqueleto dispara una flecha con gran precisión.");
    }

    public void retroceder() {
        System.out.println("El Esqueleto retrocede para mantener la distancia del enemigo.");
    }

    @Override
    public String toString() {
        return super.toString() + "\nDescripción: Un esqueleto armado con arco y flechas, evitando el combate cuerpo a cuerpo.";
    }
}
