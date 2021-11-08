
package taller3;


public interface Sistema {
    public void ingresarLP(Personajes P);
    public void ingresarLC(Cuentas C);
    public void ingresarLE(Estadisticas E);
    public ListaSkins BuscarSkin(String NombrePersonaje);
    public void añadirRecaudacion(int RP, String nombre);
    public Personajes BuscarPersonajes(String nombre);
    public String RecaudacionesPersonaje();
    public void IngresarPersonaje(Personajes P);
    public void AñadirSkin(String nombre, Skins sk);
    public int MostrarRol(String rol);
    public Cuentas BuscarCuenta(String nombre);
}
