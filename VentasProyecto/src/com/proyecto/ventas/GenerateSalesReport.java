package com.proyecto.ventas;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateSalesReport {
    public static void main(String[] args) {
        
        String desktopPath = "C:\\Users\\DonCo\\OneDrive\\Escritorio";

        String salesReportFile = desktopPath + "reporte_ventas.csv";
        String productReportFile = desktopPath + "reporte_productos.csv";

       
        generateSalesReport(salesReportFile);
        generateProductReport(productReportFile);
    }

    private static void generateSalesReport(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Vendedor;TotalRecaudado\n");
            
            writer.write("Juan;4999000 COP\n");
            writer.write("Maria;6400000 COP\n");
            writer.write("Pablo;4450000 COP\n");
            System.out.println("Archivo de reporte de ventas generado en: " + filePath);
        } catch (IOException e) {
            System.out.println("Error al generar el archivo de ventas: " + e.getMessage());
        }
    }

    private static void generateProductReport(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Producto;CantidadVendida;Precio\n");
            
            writer.write("Lenovo Legion 7;1;4999000 COP\n");
            writer.write("Iphone 15;2;3200000 COP\n");
            writer.write("Play Station 5 Pro;1;4450000 COP\n");
            System.out.println("Archivo de reporte de productos generado en: " + filePath);
        } catch (IOException e) {
            System.out.println("Error al generar el archivo de productos: " + e.getMessage());
        }
    }
}

