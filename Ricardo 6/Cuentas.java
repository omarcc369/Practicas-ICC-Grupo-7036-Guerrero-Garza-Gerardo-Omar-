import java.util.Scanner;

/**
 * Clase principal que gestiona las operaciones bancarias como crear cuenta,
 * retirar dinero, depositar dinero y conocer el saldo.
 * <p>
 * El programa permite al usuario seleccionar una opción de un menú para realizar
 * operaciones sobre una cuenta bancaria. La cuenta se mantiene en un bucle hasta
 * que el usuario decide salir del programa.
 * </p>
 * 
 * @author Omar
 * @version 1.0
 */
public class Cuentas {

    /**
     * Método principal que ejecuta el programa.
     * <p>
     * Muestra un menú de opciones y ejecuta la operación correspondiente según la elección
     * del usuario. Permite crear una cuenta, retirar dinero, depositar dinero, conocer el saldo,
     * o salir del programa.
     * </p>
     *
     * @param args Argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cuenta cuenta = null;
        boolean continuar = true;

        while (continuar) {
            System.out.println("Menú:");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Depositar dinero");
            System.out.println("4. Conocer saldo");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    if (cuenta == null) {
                        System.out.print("Ingrese el número de cuenta: ");
                        String numeroCuenta = scanner.nextLine();
                        System.out.print("Ingrese el saldo inicial: ");
                        double saldoInicial = scanner.nextDouble();
                        scanner.nextLine(); // Limpiar el buffer
                        cuenta = new Cuenta(numeroCuenta, saldoInicial);
                        System.out.println("Cuenta creada con éxito.");
                    } else {
                        System.out.println("La cuenta ya ha sido creada.");
                    }
                    break;

                case 2:
                    if (cuenta != null) {
                        System.out.print("Ingrese el monto a retirar: ");
                        double montoRetiro = scanner.nextDouble();
                        scanner.nextLine(); // Limpiar el buffer
                        boolean exito = cuenta.retirar(montoRetiro);
                        if (exito) {
                            System.out.println("Retiro exitoso.");
                        } else {
                            System.out.println("Saldo insuficiente.");
                        }
                    } else {
                        System.out.println("No se ha creado ninguna cuenta.");
                    }
                    break;

                case 3:
                    if (cuenta != null) {
                        System.out.print("Ingrese el monto a depositar: ");
                        double montoDeposito = scanner.nextDouble();
                        scanner.nextLine(); // Limpiar el buffer
                        cuenta.depositar(montoDeposito);
                        System.out.println("Depósito exitoso.");
                    } else {
                        System.out.println("No se ha creado ninguna cuenta.");
                    }
                    break;

                case 4:
                    if (cuenta != null) {
                        System.out.println("Saldo actual: " + cuenta.getSaldo());
                    } else {
                        System.out.println("No se ha creado ninguna cuenta.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                    break;
            }
        }

        scanner.close();
    }
}

/**
 * Clase que representa una cuenta bancaria.
 * <p>
 * La clase maneja operaciones básicas como retirar dinero, depositar dinero y obtener el saldo.
 * </p>
 * 
 * @author Omar
 * @version 1.0
 */
class Cuenta {
    private String numeroCuenta;
    private double saldo;

    /**
     * Constructor que inicializa el número de cuenta y el saldo inicial.
     *
     * @param numeroCuenta Número de la cuenta
     * @param saldoInicial Saldo inicial de la cuenta
     */
    public Cuenta(String numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    /**
     * Retira una cantidad específica de la cuenta si hay suficiente saldo.
     *
     * @param monto Monto a retirar
     * @return true si el retiro fue exitoso, false si el saldo es insuficiente
     */
    public boolean retirar(double monto) {
        if (monto > saldo) {
            return false; // No hay suficiente saldo
        }
        saldo -= monto;
        return true;
    }

    /**
     * Deposita una cantidad específica en la cuenta.
     *
     * @param monto Monto a depositar
     */
    public void depositar(double monto) {
        saldo += monto;
    }

    /**
     * Obtiene el saldo actual de la cuenta.
     *
     * @return Saldo actual de la cuenta
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Obtiene el número de la cuenta.
     *
     * @return Número de la cuenta
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
}
