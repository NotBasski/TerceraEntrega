package com.proyecto.ventas;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateInfoFiles {
    
    public static void main(String[] args) {
        String filePath = "C:/Users/DonCo/OneDrive/datos.csv";

        try (FileWriter writer = new FileWriter(filePath)) {
            Random random = new Random();
            writer.append("ID,Nombre,Edad\n");
            for (int i = 1; i <= 100; i++) {
                writer.append(i + ",Nombre_" + i + "," + (random.nextInt(50) + 20) + "\n");
            }
            System.out.println("Archivo generado exitosamente en: " + filePath);
        } catch (IOException e) {
            System.out.println("Error al generar el archivo: " + e.getMessage());
        }
    }
}