/**
 * Representa un monstruo genérico con métodos básicos y atributos comunes.
 * 
 * @autor Gerardo Omar
 * @version 1.0
 */
public class Monstruo {

    protected String nombre;
    protected String ubicacion;
    protected boolean esNoMuerto;
    protected String formaFisica;

    public Monstruo(String nombre, String ubicacion, boolean esNoMuerto, String formaFisica) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.esNoMuerto = esNoMuerto;
        this.formaFisica = formaFisica;
    }

    public void morder() {
        System.out.println(nombre + " muerde a su objetivo.");
    }

    public void debilidad() {
        System.out.println("Debilidad de " + nombre + ": desconocida.");
    }

    public void generar() {
        System.out.println("Se ha generado un " + nombre + " en " + ubicacion + ".");
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nUbicación: " + ubicacion + "\nEs No-Muerto: " + esNoMuerto + "\nForma Física: " + formaFisica;
    }
}
