package ito.ui;

import ito.data.Alumno;

import java.util.ArrayList;

public class Visualizacion {

    public void visualizaAlumno(Alumno alumno){
        StringBuilder sb=new StringBuilder();
        sb.append(String.format("%08d ",alumno.getNumeroControl()));
        sb.append(String.format("%-30s ",alumno.getNombre()));
        sb.append(String.format("%02d ",alumno.getSemestre()));
        sb.append(String.format("%-20s ",alumno.getCarrera()));
        sb.append(String.format("%6.2f ",alumno.getPromedio()));
        sb.append(String.format("%-12s ",alumno.getGenero()));
        System.out.println(sb.toString());
    }

    public void visualizaEncabezado(){
        System.out.println(String.format("%-8s %-30s %-4s %-20s %-6s %-12s","No. C","Nombre","Sem","Carrera","Prom","Genero"));
    }

    public void visualizaTodos(ArrayList<Alumno> alumnos){
        visualizaEncabezado();
        for(Alumno alumno:alumnos){
            visualizaAlumno(alumno);
        }
    }
}
