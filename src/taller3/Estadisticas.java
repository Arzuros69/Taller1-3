
package taller3;

public class Estadisticas {
   private String nombre;
   private int recaudado;

    public Estadisticas(String nombre, int recaudado) {
        this.nombre = nombre;
        this.recaudado = recaudado;
    }

    public String getNombre() {
        return nombre;
    }
    public int getRecaudado() {
        return recaudado;
    }
    public void HuboCompra(int cant){
        recaudado+=cant;
    }
    public double TransformarCLP(){
        double trans = recaudado*6.15;
        return trans;
    }
   
}
