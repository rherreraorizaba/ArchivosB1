package ito.data;

import ito.persistencia.ArchivoBinario;
import ito.persistencia.ArchivoTexto;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ListaAlumnos {

    private ArrayList<Alumno> alumnos;
    private ArchivoTexto archivoTexto;
    private ArchivoBinario archivoBinario;

    public ListaAlumnos(String nombre) {
        this.archivoTexto = new ArchivoTexto(nombre+".txt");
        this.archivoBinario = new ArchivoBinario(nombre+".dat");
       // this.recuperaDatos();  // Formato de texto
        this.recuperarBinario(); // Formato binario
    }

    private void recuperarBinario(){
        try{
            alumnos=archivoBinario.leerAlumnos();
        } catch (FileNotFoundException e) {
            alumnos=new ArrayList<>();
        }
    }


    private void recuperaDatos(){
        try {
            alumnos=archivoTexto.leerAlumnos();
        }catch(FileNotFoundException e){
            alumnos=new ArrayList<>();
        }
    }

    public void salvarBinario() throws FileNotFoundException {
        archivoBinario.escribirAlumnos(alumnos);
    }

    public void salvarDatos() throws FileNotFoundException {
        archivoTexto.escribirAlumnos(alumnos);
    }

    public boolean existe(Alumno alumno){
        boolean existe=false;
        for(Alumno a:alumnos)
            if(a.getNumeroControl()==alumno.getNumeroControl()){
                existe=true;
                break;
            }
        return existe;
    }


    public void addAlumno(Alumno alumno){
        if(existe(alumno))
            throw new IllegalArgumentException("Alumno ya existe!!");
        alumnos.add(alumno);

    }

    public void deleteAlumno(Alumno alumno){
         if(!alumnos.contains(alumno))
             throw new IllegalArgumentException("Alumno no existe!!");
         alumnos.remove(alumno);
    }

    public void deleteAlumno(long numeroControl){
        boolean test=false;
        for(Alumno alumno:alumnos)
            if(alumno.getNumeroControl()==numeroControl){
                test=true;
                alumnos.remove(alumno);
                break;
            }
        if(!test)
            throw new IllegalArgumentException("Alumno no existe!!");
    }

    public void deleteAlumno(int pos){
        if(pos<0 || pos>alumnos.size())
            throw new IllegalArgumentException("Alumno no existe!!");
        alumnos.remove(pos);
    }

    public Alumno getAlumno(int pos){
        if(pos<0 || pos>alumnos.size())
            throw new IllegalArgumentException("Alumno no existe!!");
        return alumnos.get(pos);
    }

    public Alumno getAlumno(long numeroControl){
        Alumno alumno=null;
        for(Alumno a:alumnos)
            if(a.getNumeroControl()==numeroControl) {
                alumno = a;
                break;
            }
        return alumno;
    }
    public ArrayList<Alumno> getAlumnos(){
        return alumnos;
    }
}
