package com.mycompany.prestamolibros;

import java.util.Random;

public class GestorLibros  {
    private final Libro[] libros;
    private final Random random = new Random();

    public GestorLibros(Libro[] libros) {
        this.libros = libros;
    }

    // Obtiene dos libros
    
    public Libro[] obtenerDosLibros(String nombreEstudiante) {
        Libro[] librosPrestados = new Libro[2];
        int librosObtenidos = 0;

        while (librosObtenidos < 2) {
            int indice = random.nextInt(libros.length);
            Libro libro = libros[indice];

            synchronized (libro) {
                if (!libro.Estaocupado()) {
                    libro.setPrestado(true);
                    librosPrestados[librosObtenidos] = libro;
                    librosObtenidos++;
                } else {
                    System.out.println(nombreEstudiante + " no pudo obtener el libro " + libro.obtenerNombreLibro() + " esta en uso.");
                }
            }
        }
        return librosPrestados;
    }

    //  Devolver los libros
    
    public void devolverLibros(Libro[] librosPrestados) {
        for (Libro libro : librosPrestados) {
            if (libro != null) {
                synchronized (libro) {
                    libro.setPrestado(false);
                }
            }
        }
    }
}