
package com.mycompany.pruebaproyecto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class LeerArchivo {
    ArbolBinario arbolito = new ArbolBinario();
    
 
    public void leerArch(ArbolBinario arbolito, File file, JTextArea txtArea) {
    StringBuilder texto = new StringBuilder();
    try (BufferedReader lectura = new BufferedReader(new FileReader(file))) {
        // Leer y descartar la primera línea
        String linea = lectura.readLine();

        int numLinesToRead = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántas líneas desea leer?"));
        int linesRead = 0; // Inicializar el contador de líneas leídas a 0

        while ((linea = lectura.readLine()) != null && linesRead < numLinesToRead) {
            String[] partes = linea.split("\t"); // Separar el nombre y el DPI
            String nombre = partes[0].replaceAll("1", " ");
            String dpiST = partes[1];
            long dpi = Long.parseLong(dpiST);
            arbolito.AgregarNodo(dpi);
            texto.append(nombre).append("\t").append(dpi).append("\n"); // Agregar el nombre y el DPI a texto
            linesRead++;
        }

        lectura.close();
        JOptionPane.showMessageDialog(null, "Texto Correcta");

        // Establecer el texto de jTextArea2
        txtArea.setText(texto.toString());
    } catch (IOException | NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Texto Fallida");
    }

    
}

    
}



