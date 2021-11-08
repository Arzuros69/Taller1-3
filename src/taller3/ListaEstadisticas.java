
package taller3;


public class ListaEstadisticas {
   private int cant;
   private Estadisticas[] LE; 

    public ListaEstadisticas(int cant) {
        this.cant = cant;
        LE = new Estadisticas[9999];
    }

    public int getCant() {
        return cant;
    }

    public Estadisticas[] getLE() {
        return LE;
    }
     public void AddEstadisticas(Estadisticas E){
        if(cant<9999){
            LE[cant]=E;
            cant++;
        }
    }
    public Estadisticas getEstadisticas(String nombre){
        for(int i=0;i<cant;i++){
            if(LE[i].getNombre().equals(nombre)){
                return LE[i];
            }
        }
        return null;
    }

}
