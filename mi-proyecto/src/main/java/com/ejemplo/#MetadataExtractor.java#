package com.ejemplo;
import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.GpsDirectory;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.Scanner;

/**
 * MetadataExtractor es una herramienta para extraer, visualizar y modificar los metadatos de imágenes.
 * Los metadatos extraídos incluyen información EXIF y, si está disponible, la ubicación GPS.
 * Los metadatos también pueden ser guardados en un archivo de texto.
 * 
 * Autores: Gerardo Omar, Cristopher Carrada
 * Versión: 1.0
 */
public class MetadataExtractor {

    /**
     * El método principal que ejecuta el extractor de metadatos. 
     * Muestra un menú de opciones para el usuario y ejecuta la acción seleccionada.
     * 
     * @param args Argumentos de línea de comandos (no se usan en este caso).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Mostrar bienvenida
        System.out.println("------BIENVENIDO AL EXTRACTOR DE DATOS----------");

        // Solicitar la ruta de la imagen
        System.out.println("Ingrese la ruta de la imagen (JPG, JPEG, PNG): ");
        String filePath = scanner.nextLine();

        File imageFile = new File(filePath);

        // Verificar que el archivo exista y tenga un formato aceptado
        if (!imageFile.exists() || (!filePath.endsWith(".jpg") && !filePath.endsWith(".jpeg") && !filePath.endsWith(".png"))) {
            System.out.println("Archivo no encontrado o formato no compatible.");
            return;
        }

        // Mostrar opciones de menú
        System.out.println("¿Qué acción desea realizar?");
        System.out.println("1. Extraer los metadatos.");
        System.out.println("2. Escribir los metadatos en un archivo.");
        System.out.println("3. Ver ubicación GPS en Google Maps.");
        int option = scanner.nextInt();
        scanner.nextLine();  // Consumir la nueva línea restante

        try {
            // Leer los metadatos de la imagen
            Metadata metadata = ImageMetadataReader.readMetadata(imageFile);

            if (option == 1) {
                // Extraer los metadatos y mostrarlos en la consola
                System.out.println("Metadatos encontrados:");
                for (Directory directory : metadata.getDirectories()) {
                    for (Tag tag : directory.getTags()) {
                        System.out.format("[%s] - %s = %s%n", directory.getName(), tag.getTagName(), tag.getDescription());
                    }
                }
            } 
            else if (option == 2) {
                // Escribir los metadatos en un archivo
                FileWriter writer = new FileWriter("metadatos_imagen.txt");
                writer.write("Metadatos de la imagen:\n");

                for (Directory directory : metadata.getDirectories()) {
                    for (Tag tag : directory.getTags()) {
                        writer.write(String.format("[%s] - %s = %s%n", directory.getName(), tag.getTagName(), tag.getDescription()));
                    }
                }

                // Verificar si hay información GPS y escribirla
                GpsDirectory gpsDirectory = metadata.getFirstDirectoryOfType(GpsDirectory.class);
                if (gpsDirectory != null && gpsDirectory.getGeoLocation() != null) {
                    double latitude = gpsDirectory.getGeoLocation().getLatitude();
                    double longitude = gpsDirectory.getGeoLocation().getLongitude();
                    writer.write("\nUbicación GPS encontrada:\n");
                    writer.write("Latitud: " + latitude + "\n");
                    writer.write("Longitud: " + longitude + "\n");
                }

                writer.close();
                System.out.println("Metadatos escritos en 'metadatos_imagen.txt'.");
            } 
            else if (option == 3) {
                // Obtener la ubicación GPS y abrir Google Maps
                GpsDirectory gpsDirectory = metadata.getFirstDirectoryOfType(GpsDirectory.class);
                if (gpsDirectory != null && gpsDirectory.getGeoLocation() != null) {
                    double latitude = gpsDirectory.getGeoLocation().getLatitude();
                    double longitude = gpsDirectory.getGeoLocation().getLongitude();

                    System.out.println("Coordenadas GPS encontradas:");
                    System.out.println("Latitud: " + latitude);
                    System.out.println("Longitud: " + longitude);

                    // Construir la URL para abrir en Google Maps
                    String url = "https://www.google.com/maps?q=" + latitude + "," + longitude;
                    Desktop.getDesktop().browse(new URI(url));  // Abre la URL en el navegador predeterminado
                } else {
                    System.out.println("No se encontraron datos GPS en la imagen.");
                }
            } 
            else {
                System.out.println("Opción no válida.");
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
