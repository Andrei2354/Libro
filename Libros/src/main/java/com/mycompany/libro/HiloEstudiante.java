package com.mycompany.libro;

import java.util.Random;

public class HiloEstudiante implements Runnable {
    private final String nombre;
    private final GestorLibro gestor;
    private final int NUMERO_PETICIONES;
    private final Random random = new Random();

    public HiloEstudiante(String nombre, GestorLibro gestor, int maxPrestamos) {
        this.nombre = nombre;
        this.gestor = gestor;
        this.NUMERO_PETICIONES = maxPrestamos;
    }

    @Override
    public void run() {
        for (int i = 0; i < NUMERO_PETICIONES; i++) {
            try {
                // Obtener dos libros
                Libro[] librosPrestados = gestor.obtenerDosLibros(nombre);
                System.out.println(nombre + " ha tomado los libros: " + librosPrestados[0].obtenerNombreLibro() + " y " + librosPrestados[1].obtenerNombreLibro());

                //Una o tres hora
                int tiempoUso = 60 + random.nextInt(180);
                Thread.sleep(tiempoUso * 10);

                System.out.println(nombre + " ha terminado de usar los libros.");

                gestor.devolverLibros(librosPrestados);
                System.out.println(nombre + " ha devuelto los libros.");
                
                //Una o tres hora
                int tiempoDescanso = 60 + random.nextInt(120);
                Thread.sleep(tiempoDescanso * 10); 
                
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(nombre + " a tenido un problema.");
            }
        }
    }
}
