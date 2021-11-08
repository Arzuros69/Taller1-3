
package taller3;
//Clase personajes que incluye nombre,rol,cantidad skins, nombreSkin,rareza....
public class Personajes {
    private String Nombre;
    private String Rol;
    private ListaSkins listaSkins;

    public Personajes(String Nombre, String Rol, int cant) {
        this.Nombre = Nombre;
        this.Rol = Rol;
        listaSkins = new ListaSkins();
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    public ListaSkins getListaSkins() {
        return listaSkins;
    }

    public void setListaSkins(ListaSkins listaSkins) {
        this.listaSkins = listaSkins;
    }



}
