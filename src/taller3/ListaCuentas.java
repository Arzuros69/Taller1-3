
package taller3;


public class ListaCuentas {
   private int cant;
   private Cuentas[] LC; 

    public ListaCuentas() {
        this.cant = 0;
        LC = new Cuentas[9999];
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public Cuentas[] getLC() {
        return LC;
    }

    public void setLC(Cuentas[] LC) {
        this.LC = LC;
    }
    public void addCuenta(Cuentas C){
        if(cant<9999){
            LC[cant]=C;
            cant++;
        }
    }
    public Cuentas getCuenta(String nombre){
        for(int i=0;i<cant;i++){
            if(LC[i].getNombreCuenta().equals(nombre)){
                return LC[i];
            }
        }
        return null;
    }


}
