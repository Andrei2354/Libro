package com.mycompany.libro;

public class ListaLibros {
    public static final int NUMERO_LIBROS = 9;
    public static final int NUMERO_ESTUDIANTES = 4;
    public static final int NUMERO_PETICIONES = 2;

    // Array de los libros
    public static void main(String[] args) {
        Libro[] libros = {
            new Libro(1, "The Way of Kings"),
            new Libro(2, "Words of Radiance"),
            new Libro(3, "Oathbringer"),
            new Libro(4, "Rhythm of War"),
            new Libro(5, "Mistborn: The Final Empire"),
            new Libro(6, "The Well of Ascension"),
            new Libro(7, "The Hero of Ages"),
            new Libro(8, "Warbreaker"),
            new Libro(9, "Elantris")
        };

        GestorLibro gestor = new GestorLibro(libros);
        // Crear y ejecutar los estudiantes como hilos (nombre, instancia, NUMERO_PETICIONES)
        for (int i = 0; i < NUMERO_ESTUDIANTES; i++) {
            String nombreEstudiante = "Estudiante " + (i + 1);
            Thread estudiante = new Thread(new HiloEstudiante(nombreEstudiante, gestor, NUMERO_PETICIONES));
            estudiante.start();
        }
    }
}

