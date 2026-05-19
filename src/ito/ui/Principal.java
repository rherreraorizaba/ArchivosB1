package ito.ui;

import ito.data.Alumno;
import ito.persistencia.ArchivoRandom;
import java.util.Arrays;
import java.util.Scanner;

public class Principal {

    private Scanner input = new Scanner(System.in);
    private Visualizacion visualizacion;
    private Validacion validacion;
    private String menu;
    ArchivoRandom archivo;

    public Principal(){
        visualizacion=new Visualizacion();
        validacion= new Validacion(input);
        archivo= new ArchivoRandom("alumnos.rand");
        inicializaMenu();
    }

    private void inicializaMenu(){
        menu="Menu pricipal\n";
        menu+="1.- Agregar Alumno\n";
        menu+="2.- Eliminar Alumno\n";
        menu+="3.- Modificar Alumno\n";
        menu+="4.- Mostrar alumno\n";
        menu+="5.- Listar alumnos\n";
        menu+="6.- Recuperar registros eliminados\n";
        menu+="7.- Salir\n";
        menu+="Proporciona opción:[1..7]:";
    }

    private byte opcion(){
        return validacion.leerByte(menu,(byte)1,(byte)7,"Opcionn invalida");
    }

    private void agregarAlumno(){
        Alumno alumno=validacion.leerAlumno();
        try {
            archivo.agregaAlumno(alumno);
        }catch(IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
    }

    private void eliminarAlumno(){
        long nc=validacion.leerNumeroControl();
        Alumno alumno=archivo.obtenerAlumno(nc);
        if(alumno!=null) {
            visualizacion.visualizaAlumno(alumno);
            String resp = validacion.leerString("Es el alumno a eliminar:[Si/No]:", Arrays.asList("Si", "No"), "Opcion incorrecta!!");
            if (resp.equals("Si")) {
                archivo.eliminarAlumno(alumno);
                System.out.println("Alumno eliminado!!");
            }
        }
        else
            System.out.println("Alumno no encontrado!!");
    }

    private void modificaSemestre(Alumno alumno){
        alumno.setSemestre(validacion.leerSemestre());
    }

    private void modificaCarrera(Alumno alumno){
        alumno.setCarrera(validacion.leerCarrera());
    }

    private void modificaPromedio(Alumno alumno){
        alumno.setPromedio(validacion.leerPromedio());
    }

    private void capturaModificaciones(Alumno alumno){
        String menu="Menu de opciones\n";
        menu+="1.- Modificar semestre\n";
        menu+="2.- Modificar carrera\n";
        menu+="3.- Modificar promedio\n";
        menu+="Selecciona opcion[1..3]:\n";
        byte  opcion=validacion.leerByte(menu,(byte)1,(byte)3,"Opcion invalida");
        switch(opcion){
            case 1:modificaSemestre(alumno);break;
            case 2:modificaCarrera(alumno);break;
            case 3:modificaPromedio(alumno);
        }
    }

    private void modificarAlumno(){
        long nc=validacion.leerNumeroControl();
        Alumno alumno=archivo.obtenerAlumno(nc);
        if(alumno!=null){
            visualizacion.visualizaAlumno(alumno);
            capturaModificaciones(alumno);
            archivo.modificaAlumno(alumno);
        }else
            System.err.println("Alumno no existe!!");
    }

    private void mostrarAlumno(){
        long nc=validacion.leerNumeroControl();
        Alumno alumno=archivo.obtenerAlumno(nc);
        if(alumno!=null)
            visualizacion.visualizaAlumno(alumno);
        else
            System.err.println("Alumno no existe!!");
    }

    private void listarAlumnos(){
        long  numReg=archivo.getNumeroRegistros();
        for(int i=1;i<=numReg;i++){
            Alumno alumno=archivo.obtenerAlumno(i);
            visualizacion.visualizaAlumno(alumno);
        }
    }

    public void run()  {
        byte opcion;
        do{
            opcion=opcion();
            switch(opcion){
                case 1: agregarAlumno();break;
                case 2: eliminarAlumno();break;
                case 3: modificarAlumno();break;
                case 4: mostrarAlumno();break;
                case 5: listarAlumnos();break;
                case 6: archivo.recuperarEliminados();
            }
        }while(opcion!=7);
    }
}
