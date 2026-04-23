package ito.app;

import ito.data.Alumno;
import ito.data.Genero;
import ito.persistencia.ArchivoTexto;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MyApp {

    static void inicialzaAlumnos() throws FileNotFoundException {
        ArrayList<Alumno> a= new  ArrayList<Alumno>();
        a.add(new Alumno(3248237,"Juan Perez Montero",(byte)2,"QUIMICA",67.4f,Genero.MASCULINO));
        a.add(new Alumno(3243237,"Juan Perez Alvarez",(byte)2,"INDUSTRIAL",67.4f,Genero.MASCULINO));
        a.add(new Alumno(3248237,"Juan Luna Perez",(byte)2,"ELECTRICA",67.4f,Genero.MASCULINO));
        a.add(new Alumno(3243237,"Juan Perez Hidalgo",(byte)2,"SISTEMAS",67.4f,Genero.MASCULINO));
        a.add(new Alumno(3234007,"Juan Perez",(byte)2,"QUIMICA",67.4f,Genero.FEMENINO));
        a.add(new Alumno(3240437,"Juan Perez",(byte)2,"QUIMICA",67.4f,Genero.MASCULINO));
        a.add(new Alumno(3232007,"Juan Perez",(byte)2,"QUIMICA",67.4f,Genero.MASCULINO));
        a.add(new Alumno(3209237,"Juan Perez",(byte)2,"ELCTRONICA",67.4f,Genero.BINARIO));
        a.add(new Alumno(3998237,"Juan Perez",(byte)2,"SISTEMA",67.4f,Genero.MASCULINO));
        a.add(new Alumno(1248237,"Juan Perez",(byte)2,"QUIMICA",67.4f,Genero.MASCULINO));
        a.add(new Alumno(4248237,"Juan Perez",(byte)2,"INFORMATICA",67.4f,Genero.MASCULINO));

        ArchivoTexto archivo= new ArchivoTexto("alumnos.txt");
        archivo.escribirAlumnos(a);
    }

    static void leeDatos() throws FileNotFoundException {
        ArchivoTexto archivo= new ArchivoTexto("alumnos.txt");
        ArrayList<Alumno> alumnos=archivo.leerAlumnos();
        System.out.printf("# Alumnos encontrados: %d\n", alumnos.size());
        for(Alumno a:alumnos){
            System.out.println(a);
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        inicialzaAlumnos();
        //leeDatos();
    }
}
