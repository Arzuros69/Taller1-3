
package taller3;
public class ListaPersonajes {
    private int cant;
    private Personajes[] LP;

    public ListaPersonajes(int cant) {
        this.cant = cant;
        LP = new Personajes[155];
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public Personajes[] getLP() {
        return LP;
    }

    public void setLP(Personajes[] LP) {
        this.LP = LP;
    }
    public void addPersonaje(Personajes P){
        if(cant<155){
            LP[cant]=P;
            cant++;
        }
    }
    public Personajes getPersonaje(String nombre){
        for(int i=0;i<cant;i++){
            if(LP[i].getNombre().equals(nombre)){
                return LP[i];
            }
        }
        return null;
    }
    
}
