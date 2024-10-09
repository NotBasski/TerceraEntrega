package com.proyecto.ventas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        
        String archivoEntrada = "C:/Users/DonCo/OneDrive/datos.csv";
        
        String archivoSalida = "C:/Users/DonCo/OneDrive/reporte.txt";
        
        int totalRegistros = 0;
        double sumaEdades = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(archivoEntrada))) {
            String linea;
            
            
            br.readLine();
            
            
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                try {
                    
                    int edad = Integer.parseInt(campos[2]);
                    sumaEdades += edad;
                    totalRegistros++;
                } catch (NumberFormatException e) {
                    
                    System.out.println("Error al procesar la edad: " + campos[2]);
                }
            }

            // 
            double promedioEdad = (totalRegistros > 0) ? sumaEdades / totalRegistros : 0;

            // 
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida))) {
                bw.write("Reporte de análisis de datos:\n");
                bw.write("Total de registros procesados: " + totalRegistros + "\n");
                bw.write("Promedio de edad: " + promedioEdad + "\n");
            }

            System.out.println("Reporte generado exitosamente en " + archivoSalida);

        } catch (IOException e) {
            System.out.println("Error al procesar el archivo: " + e.getMessage());
        }
    }
}

