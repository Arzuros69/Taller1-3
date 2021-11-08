
package taller3;


public class PersonajesUsuario {
    private String campeon;
    private int cant;
    private ListaSkins LS;

    public PersonajesUsuario(String campeon, int cant) {
        this.campeon = campeon;
        this.cant = cant;
        LS = new ListaSkins();
    }

    public String getCampeon() {
        return campeon;
    }

    public void setCampeon(String campeon) {
        this.campeon = campeon;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public ListaSkins getLS() {
        return LS;
    }

    public void setLS(ListaSkins LS) {
        this.LS = LS;
    }
    
}
