package ito.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

import ito.data.Alumno;
import ito.data.Genero;

public class Validacion {

    private Scanner input;

    public Validacion(Scanner input) {
        this.input = input;
    }

    public long leerLong(String texto,long min,long max,String error){
        long enteroLargo;
        if(min>=max)
            throw new IllegalArgumentException("EL valor mínimo debe ser menor al máximo");
        do{
            System.out.print(texto);
            try {
                enteroLargo = Long.parseLong(input.nextLine());
            }catch(NumberFormatException e){
                enteroLargo = min-1;
            }
            if(enteroLargo<min || enteroLargo>max)
                System.err.println(error);
        }while(enteroLargo<min || enteroLargo>max);
        return enteroLargo;
    }

    public byte leerByte(String texto,byte min,byte max,String error){
        return (byte)leerLong(texto,min,max,error);
    }

    public float leerFloat(String texto,float min,float max,String error){
        float flotante;
        if(min>=max)
            throw new IllegalArgumentException("EL valor mínimo debe ser menor al máximo");
        do{
            System.out.print(texto);
            try {
                flotante = Float.parseFloat(input.nextLine());
            }catch(NumberFormatException e){
                flotante = min-1;
            }
            if(flotante<min || flotante>max)
                System.err.println(error);
        }while(flotante<min || flotante>max);
        return flotante;
    }

    public String leerString(String texto,List<String> validacion,String error){
        String resultado;
        do{
            System.out.print(texto);
            resultado=input.nextLine();
            if(validacion!=null)
                resultado = validacion.contains(resultado)?resultado:null;
            if(resultado==null)
                System.err.println(error);
        }while(resultado==null || resultado.isEmpty());
        return resultado;
    }

    public long leerNumeroControl(){
        return leerLong("Proporciona número de control:",10000000L,99999999L,"Número de control no valido!!");
    }

    public String leerNombre(){
        return leerString("Proporciona nombre:",null,"Nombre invalido!!");
    }

    public byte leerSemestre(){
        return leerByte("Proporciona Semestre:[1..13]:",(byte)1,(byte)13,"Semestre invalido!!");
    }

    public String leerCarrera(){
        ArrayList<String> carreras = new ArrayList<>(Arrays.asList("INDUSTRIAL","SISTEMAS","QUIMICA","INFORMATICA","MECANICA","ELECTRICA","ELECTRONICA","SEMICONDUCTORES","CIENCIA DE DATOS"));
        return leerString("Proporciona carrera:",carreras,"Carrera invalida!!");
    }

    public float leerPromedio(){
        return leerFloat("Proporciona promedio:",0,100,"Promedio invalido!!");
    }

    public Genero leerGenero(){
        ArrayList<String> generos= new ArrayList<>(Arrays.asList("MASCULINO","FEMENINO","BINARIO"));
        return Genero.valueOf(leerString("Proporciona genero:",generos,"Genero invalido!!"));
    }

    public Alumno leerAlumno(){
        long nc=leerNumeroControl();
        String nombre=leerNombre();
        byte semestre=leerSemestre();
        String carrera=leerCarrera();
        float promedio=leerPromedio();
        Genero genero=leerGenero();
        return new Alumno(nc,nombre,semestre,carrera,promedio,genero);
    }


}
