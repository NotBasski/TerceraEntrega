package com.proyecto.ventas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateInfoFiles {
    
    public static void main(String[] args) {
        try {
            createSalesMenFile(10, "Carlos", 123456);
            createProductsFile(5);
            createSalesManInfoFile(10);
            System.out.println("Archivos generados exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al generar archivos: " + e.getMessage());
        }
    }
    
    public static void createSalesMenFile(int randomSalesCount, String name, long id) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ventas_" + id + ".txt"))) {
            writer.write("DNI;" + id);
            writer.newLine();
            Random random = new Random();
            for (int i = 0; i < randomSalesCount; i++) {
                int productId = random.nextInt(10) + 1;
                int quantity = random.nextInt(10) + 1;
                writer.write(productId + ";" + quantity);
                writer.newLine();
            }
        }
    }

    public static void createProductsFile(int productsCount) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("productos.txt"))) {
            Random random = new Random();
            for (int i = 1; i <= productsCount; i++) {
                writer.write(i + ";Producto" + i + ";" + (random.nextInt(100) + 1));
                writer.newLine();
            }
        }
    }

    public static void createSalesManInfoFile(int salesmanCount) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("vendedores.txt"))) {
            Random random = new Random();
            for (int i = 0; i < salesmanCount; i++) {
                writer.write("DNI;" + (random.nextInt(900000) + 100000) + ";Nombre" + i + ";Apellido" + i);
                writer.newLine();
            }
        }
    }
}
