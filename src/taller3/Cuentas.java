
package taller3;

public class Cuentas {
   private String NombreCuenta;
   private String pass;
   private String Nick;
   private int nivel;
   private int RP;
   private int cantPersonajes;
   private ListaPersonajesUsuario LPU;
   private String Region;

    public Cuentas(String NombreCuenta, String pass, String Nick, int nivel, int RP, int cantPersonajes, String Region) {
        this.NombreCuenta = NombreCuenta;
        this.pass = pass;
        this.Nick = Nick;
        this.nivel = nivel;
        this.RP = RP;
        this.cantPersonajes = cantPersonajes;
        this.Region = Region;
        LPU= new ListaPersonajesUsuario();
        
    }

    public String getNombreCuenta() {
        return NombreCuenta;
    }

    public void setNombreCuenta(String NombreCuenta) {
        this.NombreCuenta = NombreCuenta;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNick() {
        return Nick;
    }

    public void setNick(String Nick) {
        this.Nick = Nick;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getRP() {
        return RP;
    }

    public void setRP(int RP) {
        this.RP = RP;
    }

    public int getCantPersonajes() {
        return cantPersonajes;
    }

    public void setCantPersonajes(int cantPersonajes) {
        this.cantPersonajes = cantPersonajes;
    }

    public ListaPersonajesUsuario getLPU() {
        return LPU;
    }

    public void setLPU(ListaPersonajesUsuario LPU) {
        this.LPU = LPU;
    }


    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    @Override
    public String toString() {
        String[] parts=pass.split("");
        String pass1="";
        for(int i=0; i<parts.length;i++){
            if(i<parts.length-3){
                pass1+="*";
            }
            else{
                pass1+=parts[i];
            }
        }
        
        
        return "Cuentas{" + "NombreCuenta=" + NombreCuenta + ", pass=" + pass1 + ", Nick=" + Nick + ", nivel=" + nivel + ", RP=" + RP + ", cantPersonajes=" + cantPersonajes + ", Region=" + Region + '}';
    }
   
}
