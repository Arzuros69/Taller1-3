
package taller3;


public class ListaPersonajesUsuario {
    private int cant;
    private PersonajesUsuario[] LPU;

    public ListaPersonajesUsuario() {
        this.cant = 0;
        LPU = new PersonajesUsuario[9999];
    }

    
    public int getCant() {
        return cant;
    }

    public PersonajesUsuario[] getLPU() {
        return LPU;
    }
    public void addPU(String pu){
        int val=0;
        if(cant<9999){
            for(int i=0;i<cant;i++){
                if(LPU[i].getCampeon()== pu){
                   val++; 
                }
            }
           if(val==0){
               cant++;
           }
        }
    }
    public PersonajesUsuario buscarPU(String name){
        for(int i=0;i<cant;i++){
            if(LPU[i].getCampeon().equals(name)){
                
                return LPU[i];
            }
        }
        return null;
    }
}
