package com.mycompany.prestamolibros;

public class Libro {
    private final String isbn;
    private final String nombreLibro;
    private boolean utilizando;
    private String nombreEstudiante;

    public Libro(String isbn, String nombreLibro) {
        this.isbn = isbn;
        this.nombreLibro = nombreLibro;
        this.utilizando = false;
        this.nombreEstudiante = null;
    }

    public String obtenerIsbn() {
        return isbn;
    }
    

    public String obtenerNombreLibro() {
        return nombreLibro;
    }

    public synchronized boolean Estaocupado() {
        return utilizando;
    }

    public synchronized void setPrestado(boolean prestado, String estudiante) {
        this.utilizando = prestado;
        this.nombreEstudiante = estudiante;
        if (prestado) {
            this.nombreEstudiante = estudiante;
            System.out.println(estudiante + " tiene el Libro " + nombreLibro + ", ISBN: " + isbn + ".");
        } else {
            System.out.println(estudiante +" a devuelto el Libro " + nombreLibro + ", ISBN: " + isbn + ".");
            this.nombreEstudiante = null;
        }
    }
}
