package com.mycompany.libro;

public class ListaLibros {
    public static final int NUMERO_LIBROS = 9;
    public static final int NUMERO_ESTUDIANTES = 4;
    public static final int NUMERO_PETICIONES = 2;

    // Array de los libros
    public static void main(String[] args) {
        Libro[] libros = {
            new Libro("978-0-7653-2635-7", "The Way of Kings"),
            new Libro("978-0-7653-2636-4", "Words of Radiance"),
            new Libro("978-0-7653-2637-1", "Oathbringer"),
            new Libro("978-0-7653-2638-8", "Rhythm of War"),
            new Libro("978-0-7653-5038-3", "Mistborn: The Final Empire"),
            new Libro("978-0-7653-2030-0", "The Well of Ascension"),
            new Libro("978-0-7653-5611-8", "The Hero of Ages"),
            new Libro("978-0-7653-2030-0", "Warbreaker"),
            new Libro("978-0-7653-1176-6", "Elantris")
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
