package ito.data;
/*
     Reglas de negocio
     1) semestre debe ser un valor entre 1 y 13
     2) Promedio debe ser un valor entre 0 y 100
     3) Genero debe ser MASCULINO,FEMENINO,BINARIO

 */
public class Alumno {

    private long numeroControl;
    private String nombre;
    private byte semestre;
    private String carrera;
    private float promedio;
    private Genero genero;
    private static final byte MIN_SEM=1;
    private static final byte MAX_SEM=13;
    private static final byte MIN_PROM=0;
    private static final byte MAX_PROM=100;

    public Alumno(long numeroControl, String nombre, byte semestre, String carrera, float promedio, Genero genero) {

        this.numeroControl = numeroControl;
        this.nombre = nombre;
        setSemestre(semestre);
        this.carrera = carrera;
        setPromedio(promedio);
        this.genero = genero;
    }

    public void setSemestre(byte semestre) {
        if(semestre<MIN_SEM || semestre>MAX_SEM)
            throw new IllegalArgumentException("semestre no valido");
        this.semestre = semestre;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setPromedio(float promedio) {
        if(promedio<MIN_PROM || promedio>MAX_PROM)
            throw new IllegalArgumentException("promedio no valido");
        this.promedio = promedio;
    }

    public long getNumeroControl() {
        return numeroControl;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSemestre() {
        return semestre;
    }

    public String getCarrera() {
        return carrera;
    }

    public float getPromedio() {
        return promedio;
    }

    public String getGenero() {
        return genero.name();
    }


    public String toString(){
       /* String texto=String.format("%d",numeroControl);
        texto=texto+nombre;
        texto=texto+semestre;
        texto=texto+carrera;
        texto=texto+promedio;
        texto=texto+genero;
        return texto;*/
        return String.format("%d,%s,%d,%s,%5.2f,%s\n",numeroControl, nombre, semestre, carrera, promedio, genero);
        //return ""+numeroControl+nombre+semestre+carrera+promedio+genero;
    }
}
