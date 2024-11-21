import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

/**
 * Clase que realiza operaciones de lectura y escritura en un archivo de texto.
 * Lee un archivo con números separados por comas, los almacena en un arreglo, 
 * calcula la suma de esos números y agrega el resultado como el último elemento del arreglo.
 * 
 * @author Gerardo Omar
 * @version 1.0
 */
public class txt {

    // Primer paso leer y crear arreglo:

    /**
     * Método principal que realiza las siguientes operaciones:
     * 1. Lee el contenido de un archivo de texto pasado como argumento.
     * 2. Crea un arreglo de enteros a partir del contenido leído.
     * 3. Calcula la suma de los elementos del arreglo.
     * 4. Agrega la suma como último elemento del arreglo.
     * 5. Escribe el nuevo contenido en el archivo.
     *
     * @param args Nombre del archivo a procesar como argumento de línea de comandos.
     */
    public static void main(String[] args) {
        try {

            String read;
            BufferedReader bf = new BufferedReader(new FileReader(args[0]));

            read = bf.readLine();

            int ext = Integer.parseInt(read);

            ext = ext + 1;

            String extS = Integer.toString(ext);
            int[] arr = new int[ext];

            String segundaL = bf.readLine();

            // Transformar y meter

            String[] string = segundaL.split(",");

            for (int i = 0; i < string.length; i++) {

                arr[i] = Integer.parseInt(string[i].trim());

            }

            // Sumar todos los elementos para obtener el último :

            int suma = 0;
            for (int i = 0; i < string.length; i++) {

                suma += arr[i];

            }

            // Cree el String suma para poder imprimir

            arr[arr.length - 1] = suma;

            String sumaN = Integer.toString(arr[arr.length - 1]);

            bf.close();

            // Ahora escribir

            try {

                FileWriter fw = new FileWriter(args[0]);
                fw.write(extS);
                fw.write("\n");

                for (int i = 0; i < string.length; i++) {
                    fw.write(string[i] + ",");
                }
                fw.write(sumaN);
                fw.close();

            } catch (IOException e) {

                System.out.println("ERRRORRR");

            }

        } catch (IOException e) {

            System.out.println("ERRRORRR");

        }

    }

} // Fin de txt
