
package taller3;
import ucn.*;


public class Taller3 {
    public static void leerListaPersonajes(Sistema sistema) throws IOException{
        ArchivoEntrada arch= new ArchivoEntrada("Personajes.txt");
        //Se lee el archivo
        while(!arch.isEndFile()){
            Registro reg= arch.getRegistro();
            String name= reg.getString();
            String rol=reg.getString();
            int cant= reg.getInt();
            ListaSkins LS= new ListaSkins();
            Personajes P= new Personajes(name,rol,cant);
            //Se crea la clase Personajes para almacenar la informacion para luego hacer la lista de skins de ese personaje
            for(int i=0;i<cant*2;i++){
                //Con la clase ListaSKins almacenamos la cantidad de skins total
                String N=reg.getString();
                String RR= reg.getString();
                LS.addSkins(new Skins(N,RR));
            }
            //Se añade la listaSkins al Personaje
            P.setListaSkins(LS);    
            sistema.ingresarLP(P);
        }
       arch.close();
    }
    public static void leerListaCuentas(Sistema sistema) throws IOException{
        ArchivoEntrada arch= new ArchivoEntrada("Cuentas.txt");
        //Se lee el archivo
        while(!arch.isEndFile()){
            Registro reg= arch.getRegistro();
            String name= reg.getString();
            String pass=reg.getString();
            String nick=reg.getString();
            int nivel=reg.getInt();
            int RP= reg.getInt();
            int cant= reg.getInt();
            ListaPersonajesUsuario LPU= new ListaPersonajesUsuario();
            //Aqui se crea una listaPersonajesUsuario que tiene el nombre y la cantidad de skins que tiene el usuario
            for(int i=0;i<cant;i++){
                String campeon= reg.getString();
                //ahora viene la cantidad de skins
                int canSkins=reg.getInt();
                ListaSkins LS= new ListaSkins();
                //Ahora recorremos hasta tener todas las skins de la cuenta
                for(int k=0;k<canSkins*2;k++){
                    String n=reg.getString();
                    String RR= reg.getString();
                    Skins s= new Skins(n,RR);
                    LS.addSkins(s);
                }
                //con esto tenemos la lsita de personajes del usuario
                
                PersonajesUsuario pu=new PersonajesUsuario(campeon,canSkins);
                pu.setLS(LS);
                LPU.addPU(pu);
            }
            String Region = reg.getString();
            Cuentas c= new Cuentas(name,pass,nick,nivel,RP,cant,Region);
            c.setLPU(LPU);
            
            //Se añade la lista de skins a la cuenta

        }
       arch.close();
    }
    public static void leerListaEstadisticas(Sistema sistema)throws IOException{
        ArchivoEntrada arch= new ArchivoEntrada("Estadisticas.txt");
        //Se lee el archivo
        while(arch.isEndFile()){
            Registro reg= arch.getRegistro();
            String name= reg.getString();
            int rec= reg.getInt();
            sistema.ingresarLE(new Estadisticas(name,rec));
        }
        arch.close();
        
    }   
    public static int PasarRPS(String Rareza){
        int RP=0;
        if(Rareza.equals("Mítica")){
            RP=3250;
        }if(Rareza.equals("Definitiva")){
            RP=2750;
        }
        if(Rareza.equals("Legendaria")){
            RP=1820;
        }
        if(Rareza.equals("Épica")){
            RP=1350;
        }
        if(Rareza.equals("Normal")){
            RP=975;
        }
        return RP;
    }
    public static void ComprarSkin(String Nombre,Cuentas C,Sistema sistema){
        ListaSkins LS= sistema.BuscarSkin(Nombre);
        //buscamos si se encuentra el personaje
        if(LS==null){
            StdOut.println("No se encontro el personaje");
        }
        else{
            //mostarmos las skins y luego el usuario ingresa el nombre de la Skin
           StdOut.println("Escriba nombre de la Skin");
           LS.toString();
           String NS= StdIn.readString();
           Skins sc=LS.getSkins(NS);
           if(sc==null){
               StdOut.println("No se encontro la skin");
           }
           else{
               //Ahora se comprueba el precio de ls Skin
               int RPS= PasarRPS(sc.getRareza());
               if(C.getRP()>= RPS){
                   //Se compra con exito y se añade a la lista del usuario la skin, ademas de añadir los fondos a las estadiscticas
                   StdOut.println("Se compro con exito la Skin");
                   C.setRP(C.getRP()-RPS);
                   C.getLPU().buscarPU(Nombre).getLS().addSkins(sc);
                   sistema.añadirRecaudacion(RPS, Nombre);
                   
               }
               else{
                   StdOut.println("Saldo Insuficiente");
               }
           }
           
        }
        
    }
    public static void ComprarPersonaje(String nombre,Cuentas C,Sistema sis){
        Personajes P= sis.BuscarPersonajes(nombre);
        if(P==null){
            StdOut.println("No se encontro el personaje");
        }
        else{
            //Se encontro el personaje, ahora se revisa el precio
            if(C.getRP()>=975){
                //Ahora se resta el rp, se añade a las estadisticas y se añade a la lista del usuario
                StdOut.println("Se compro el personaje");
                C.setRP(C.getRP()-975);
                C.getLPU().addPU(nombre);
                sis.añadirRecaudacion(975, nombre);
        }else{
                StdOut.println("No hay RP suficiente!!!");
            }
        }
    }
    //Skins disponibles que no tiene el usuario
    public static String MostrarInventario(Cuentas C){
        String R="";
        ListaPersonajesUsuario LPU= C.getLPU();
        R+= " Cantidad de personajes "+ LPU.getCant();
        //Se recorre la lista de los personajes que tiene el usuario
        for(int i=0;i< LPU.getCant();i++){
            PersonajesUsuario[] PU=LPU.getLPU();
            R+= PU[i].getCampeon()+"Cantidad Skins "+PU[i].getCant();
            //Ahora se recorre cada lista de skins
            for(int j=0;j<PU[i].getCant();j++){
                ListaSkins LS= PU[i].getLS();
                R+= LS.getCant()+" ";
                for(int k=0;k<LS.getCant();k++){
                    //Se muestra las SKins
                    R+= LS.getLS().toString();
                }
                R+= "\n";
            }
        
        }
        
        return R;
    }
    public static void RecargarRP(double cant,Cuentas C){
        C.setRP((int)(cant/6.15));
        StdOut.println("Recarga con exito");
    }
    public static void MostrarDatosCuenta(Cuentas C){
        StdOut.println(C.toString());
        StdOut.println("¿Desea cambiar de contraseña? y/n");
        String res=StdIn.readString();
        boolean ff=true;
        while(ff){
            if(res.equals("y")){
                ff=false;
                StdOut.println("Ingrese contraseña antigua");
                String npass=newPass(StdIn.readString(),C.getPass());
                if(!npass.equals("No valida")){
                    StdOut.println("Se cambio la contraseña");
                }
                else{
                    StdOut.println("Contraseña erronea");
                }
            }
            if(res.equals("n")){
                ff=false;
            }
            else{
                StdOut.println("Ingrese opcion valida");
            }
        }
    }
    public static String newPass(String pass,String passold){
        String npass="No valida";
        if(passold.equals(pass)){
            StdOut.println("ingrese nueva contraseña");
            String nupass=StdIn.readString();
            StdOut.println("ingreselo de nuevo contraseña");
            npass= StdIn.readString();
            if(!nupass.equals(npass)){
                npass= "No valida";
            }
        }
        return npass;
    }
    public static String Region(){
        String res="";
        StdOut.println("1- LAS\n" +"2- LAN\n" +"3- EUW\n" +"4- KR\n" +"5- NA\n" +"6- RU");
        boolean t=true;
        while(t){
            res =StdIn.readString();
            if(res.equals("LAS")){
                t=false;
            }if(res.equals("LAN")){
                t=false;
            }if(res.equals("EUW")){
                t=false;
            }if(res.equals("KR")){
                t=false;
            }if(res.equals("NA")){
                t=false;
            }if(res.equals("Ru")){
                t=false;
            }else{
                StdOut.println("Reingrese respuesta");
            }
        }
        return res;
    }
    
    public static Cuentas IngresarUsuario(String respuesta){
        Cuentas C = null;
        if(respuesta.equals("y")){
            StdOut.println("Ingrese Nombre de cuenta");
            String cuenta= StdIn.readString();
            StdOut.println("Ingrese contraseña");
            String pass= StdIn.readString();
            StdOut.println("Ingrese Nick");
            String nick= StdIn.readString();
            StdOut.println("Seleccione Region");
            String r= Region();
            C= new Cuentas(cuenta,pass,nick,0,0,0,r); 
            
        }else{
            StdOut.println("Hasta pronto");
        }
        return C;
    }
    public static void MenuAdmin(Sistema sis, Cuentas C){
        StdOut.println("Menu de Admin");
        StdOut.println("Ingrese opcion");
        StdOut.println("1) Desplegar recaudación de ventas por rol\n" +
"2) Desplegar recaudación total de ventas por región \n" +
"3) Desplegar recaudación de ventas por personaje\n" +
"4) Desplegar la cantidad de personajes por cada rol existente\n" +
"5) Agregar un personaje al juego\n" +
"6) Agregar un skin\n" +
"7) Bloquear a un jugador\n" +
"8) Desplegar todas las cuentas de mayor a menor\n"+
                "9) Salir");
    String res =StdIn.readString();
    boolean t=true;
    while(t){
        switch (res) {
        case "1":
        //sis.ventaRol(sistema sis);
        break;
      case "2":
        //sis.ventaPorRegion(sistema sis);
          break;
      case "3":
        sis.RecaudacionesPersonaje();
          break;
      case "4":
          StdOut.println("Suport");
        sis.MostrarRol("SUP");
          StdOut.println("Atack Damage Carry");
        sis.MostrarRol("ADC");
          StdOut.println("Top Laner");
        sis.MostrarRol("TOP");
          StdOut.println("Middle Laner");
        sis.MostrarRol("MID");
          StdOut.println("Jungler");
        sis.MostrarRol("JG");
           break;   
      case "6":
          StdOut.println("Ingrese nombre de personaje");
          String resp= StdIn.readString();
          StdOut.println("Ingrese nombre de la Skin");
          String names= StdIn.readString();
          StdOut.println("Ingrese Rareza");
          String RR= StdIn.readString();
          Skins sk= new Skins(names,RR);
            sis.AñadirSkin(resp, sk);
            break;
      case "5":
          StdOut.println("Ingrese nombre del personaje");
          String namea=StdIn.readString();
          String rol =StdIn.readString();
          int cant= StdIn.readInt();
        sis.IngresarPersonaje(new Personajes(namea,rol,cant));
        int cont=0;
        while(cont !=cant){
            StdOut.println("Ingrese nombre de la Skin");
          String names1= StdIn.readString();
          StdOut.println("Ingrese Rareza");
          String RR1= StdIn.readString();
          Skins sk1= new Skins(names1,RR1);
            sis.AñadirSkin(namea, sk1);
            cont++;
        }
          break;

           case "7":
        //sis.bloquearJugadro(nombrejugador);
          break;
           case "8":
        //sis.ordenarCuentas();
          break;  
           case "9":
        t=false;
          break;
      default:
        System.out.println("Respuesta invalida");
        break;
        }
    }
    }
    public static void MenuCliente(Sistema sis,Cuentas C){
    StdOut.println("Menu de Admin");
        StdOut.println("Ingrese opcion");
        StdOut.println("1) Comprar Skin\n" +
"2) Comprar Personaje \n" +
"3) Skins Disponibles\n" +
"4) Mostrar inventario\n" +
"5) Recargar RP\n" +
"6) Mostrar Datos Cuenta\n" +
"7) Salir");
    String res =StdIn.readString();
    boolean t =true;
    while(t){
                switch (res) {
        case "1":
            StdOut.println("Ingrese nombre del personaje");
            String nombre= StdIn.readString();
            ComprarSkin(nombre,C,sis);
        break;
      case "2":
          StdOut.println("Ingrese nombre del personaje");
            String nombre2= StdIn.readString();
            ComprarPersonaje(nombre2,C,sis);
          break;
      case "3":
        //sis.skinsDisponibles()
          break;
      case "4":
          StdOut.println(MostrarInventario(C));
           break;   
      case "5":
          StdOut.println("ingrese dinero en CLP");
          double clp = StdIn.readDouble();
          RecargarRP(clp,C);
            break;
      case "6":
          MostrarDatosCuenta(C);
          break;
          case "7":
          t=false;
          break;
      default:
        System.out.println("Respuesta invalida");
        break;
    }    
    }
    }
    public static void main(String[] args) {
    Sistema sis= new SistemaImpl();
    leerListaEstadisticas(sis);
    leerListaPersonajes(sis);
    leerListaCuentas(sis);
    boolean t= true;
    while(t){    
        StdOut.println("Bienvenido, Inicie sesion");
        StdOut.println("ingrese Usuario");
        String user= StdIn.readString();
        Cuentas c= sis.BuscarCuenta(user);
        if(user.equals("ADMIN")){
           MenuAdmin(sis,c);
            t=false;
        }
        if(c==null){
            StdOut.println("¿Desea registrarse? y/otro");
            String res= StdIn.readString();
            Cuentas C= IngresarUsuario(res);
            Cuentas X = sis.BuscarCuenta(C.getNombreCuenta());
            if(C!=null && X == null){
                StdOut.println("Cuenta creada");
            }else{
                StdOut.println("No se pudo crear la cuenta");
            }
        }
        else{
            StdOut.println("Ingrese contraseña");
            String pass= StdIn.readString();
            //Se busca al usuario
            if(!c.getPass().equals(pass)){
                StdOut.println("Usuario o contraseña incorrecta");
            }else{
                StdOut.println("Bienvenido");
              //Aceder al menu de clientes  
              t=false;
            }
        }

        }
    }
    
}
