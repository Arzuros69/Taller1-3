/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller3;

public class ListaSkins {
    private int cant;
    private Skins[] LS;

    public ListaSkins() {
        this.cant = 0;
        this.LS = new Skins[9999];
        
    }

    public int getCant() {
        return cant;
    }

    public Skins[] getLS() {
        return LS;
    }
    public void addSkins(Skins s){
        while(cant<9999){
            LS[cant]=s;
            cant++;
        }
    }
    public String ShowSkins(){
        String tt="";
         for(int i=0;i<cant;i++){
                tt+=LS[i].toString();
            }
         return tt;
    }
    public Skins getSkins(String nombre){
        Skins sk=null;         
        for(int i=0;i<cant;i++){
                if(LS[i].getNombre().equals(nombre)){
                    sk=LS[i];
                }
            }
        
        return sk;
    }
}
