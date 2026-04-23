package ito.persistencia;

import ito.data.Alumno;
import ito.data.Genero;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class ArchivoTexto {

    private Formatter output;
    private Scanner input;
    private String nombreArchivo;

    public ArchivoTexto(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    private Alumno procesarDatos(String line) {
        Scanner inputTexto = new Scanner(line).useDelimiter(",");
        long nc=inputTexto.nextLong();
        String nombre=inputTexto.next();
        byte semestre=inputTexto.nextByte();
        String carrera=inputTexto.next();
        float promedio=inputTexto.nextFloat();
        Genero genero=Genero.valueOf(inputTexto.next());
        inputTexto.close();
        return new Alumno(nc,nombre,semestre,carrera,promedio,genero);
    };

    public ArrayList<Alumno> leerAlumnos() throws FileNotFoundException {
        File file = new File(nombreArchivo);
        input= new Scanner(file);
        ArrayList<Alumno> alumnos= new ArrayList();
        while (input.hasNextLine()) {
            String line = input.nextLine();
            alumnos.add(procesarDatos(line));
        }
        input.close();
        return alumnos;
    }

    public void escribirAlumnos(ArrayList<Alumno> alumnos) throws FileNotFoundException {
        output = new Formatter(this.nombreArchivo);
        for(Alumno alumno : alumnos){
            output.format("%s",alumno.toString());
        }
        output.close();
    }
}
