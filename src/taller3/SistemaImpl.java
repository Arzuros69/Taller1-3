
package taller3;


public class SistemaImpl implements Sistema {
    private ListaPersonajes LP;
    private ListaCuentas LC;
    private ListaEstadisticas LE;

  
     public SistemaImpl() {
        this.LP = new ListaPersonajes(155);
        this.LC = new ListaCuentas();
        this.LE = new ListaEstadisticas(155);
    }
     @Override
     public void ingresarLP(Personajes P){
        LP.addPersonaje(P);
    }
     @Override
     public void ingresarLC(Cuentas C){
        LC.addCuenta(C);
    }
     @Override
     public void ingresarLE(Estadisticas E){
        LE.AddEstadisticas(E);
    }
     @Override
     public ListaSkins BuscarSkin(String NombrePersonaje){
        Personajes per= LP.getPersonaje(NombrePersonaje);
        if(per==null){
            return null;
        }
        return per.getListaSkins();
    }
     @Override
     public Personajes BuscarPersonajes(String nombre){
        Personajes per= LP.getPersonaje(nombre);
        return per;
    }
     @Override
     public void añadirRecaudacion(int RP, String nombre){
        if(LE.getEstadisticas(nombre)!=null){
            LE.getEstadisticas(nombre).HuboCompra(RP);
        }
        
        
    }
     @Override
     public String RecaudacionesPersonaje(){
        String total="";
        for(int i=0;i<LE.getCant();i++){
            total+= LE.getLE()[i].getNombre();
            total+=" recaudo un total de ";
            int tot= LE.getLE()[i].getRecaudado();
            total+= tot+ " CLP";
        }
        return total;
     }
     @Override
     public void IngresarPersonaje(Personajes P){
         LP.addPersonaje(P);
     }
     @Override
     public void AñadirSkin(String nombre, Skins sk){
         Personajes p=BuscarPersonajes(nombre);
         p.getListaSkins().addSkins(sk);
     }
     @Override
     public int MostrarRol(String rol){
         int cantidad=0;
         for(int i=0;i<LP.getCant();i++){
             if(LP.getLP()[i].getRol().equals(rol)){
                 cantidad++;
             }
         }
         return cantidad;
     }
     @Override
     public Cuentas BuscarCuenta(String nombre){
         Cuentas C= null;
         LC.getCuenta(nombre);
         return C;   
     }
}
