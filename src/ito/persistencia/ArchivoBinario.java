package ito.persistencia;

import ito.data.Alumno;
import ito.data.Genero;

import java.io.*;
import java.util.ArrayList;

public class ArchivoBinario {

    private DataOutputStream output;
    private DataInputStream input;
    private FileOutputStream fileOutput;
    private FileInputStream fileInput;
    private String nombreArchivo;

    public ArchivoBinario(String nombreArchivo){
        this.nombreArchivo=nombreArchivo;
    }
    public void escribirAlumnos(ArrayList<Alumno> alumnos) throws FileNotFoundException {
        fileOutput = new FileOutputStream(this.nombreArchivo);
        output = new DataOutputStream(fileOutput);
        try{
           for (Alumno alumno : alumnos) {
               output.writeLong(alumno.getNumeroControl());
               output.writeUTF(String.format("%-30s",alumno.getNombre()));
               output.writeByte(alumno.getSemestre());
               output.writeUTF(alumno.getCarrera());
               output.writeFloat(alumno.getPromedio());
               output.writeByte(Genero.valueOf(alumno.getGenero()).ordinal());
           }
           output.close();
         }catch(IOException e){
        }
    }

    public ArrayList<Alumno> leerAlumnos() throws FileNotFoundException {
        fileInput = new FileInputStream(this.nombreArchivo);
        input = new DataInputStream(fileInput);
        ArrayList<Alumno> alumnos = new ArrayList<>();
        try{
            while(true){
               long nc=input.readLong();
               String nombre=input.readUTF();
               byte semestre=input.readByte();
               String carrera=input.readUTF();
               float promedio=input.readFloat();
               Genero genero=Genero.values()[input.readByte()];
               alumnos.add(new Alumno(nc,nombre,semestre,carrera,promedio,genero));
            }
        }catch(IOException e){}
        try {
            input.close();
        }catch(IOException e){}
        return alumnos;
    }

}
