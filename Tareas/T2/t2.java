/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kex
 */
public class T2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
Boolean salida = true;
String nombresito = "";
String nombresitot = "";
String nombresitoc = "";
int Cant=0;
InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader (isr);
Integer opcion =null;
        ArrayList<Monedas> Monedero = new ArrayList<Monedas>();
        Monedas monedita = new Monedas("Quetzal",50);
        Monedero.add(monedita);
        monedita = new Monedas("Tukis", 75);
        Monedero.add(monedita);
        if (Monedero.get(0).getNombre().equals("Quetzal")) {
            System.out.println("aqui andamos");
            Monedero.get(0).Suma(30);
        }
        System.out.println(Monedero.get(0).getCantidad().toString()); 
       System.out.println(Monedero.get(1).getNombre().toString());
      
          ArrayList<Clientes> Cuentas = new ArrayList<Clientes>();
          Clientes client = new Clientes("Pedro", 30, "Quetzal");
           Cuentas.add(client); 
          client = new Clientes("Mario", 20, "Quetzal");
          Cuentas.add(client);
           client = new Clientes("Andrea", 40, "Tukis");
          Cuentas.add(client);
          while(salida){
    try {
        System.out.println("       Sistema de monedas");
        System.out.println("-------------------------------------------");
        System.out.println("Ingrese el numero indicado para cada accion");
        System.out.println("-------------------------------------------");
        System.out.println(" 1 para la creacion de moneda");
        System.out.println(" 2 para Transferir del monedero a cliente");
        System.out.println(" 3 para transferir entre clientes");
        System.out.println(" 4 Mostrar Datos Clientes");
        System.out.println(" 5 Salida");
        System.out.println("-------------------------------------------");
        opcion = Integer.parseInt( br.readLine());
     switch(opcion){
         case 1:
             System.out.println("Ingresa el nombre de la moneda");
             nombresito = br.readLine();
             System.out.println("Ingresa la cantidad de monedas de " + nombresito);
             Cant = Integer.parseInt(br.readLine());
             monedita = new Monedas(nombresito, Cant);
             Monedero.add(monedita);
             System.out.println("Moneda agregada Exitosamente");
             break;
             
         case 2:
             System.out.println("Ingresa el tipo de moneda que se quiere transferir");
             nombresito =br.readLine();
             for (int i = 0; i < Monedero.size(); i++) {
                 if (nombresito.equals(Monedero.get(i).getNombre())) {
                     
                     System.out.println("Ingrese a cual cliente se quiere realizar la transferencia");
                     nombresitot =br.readLine();
                     for (int j = 0; j < Cuentas.size(); j++) {
                         if (nombresitot.equals(Cuentas.get(j).getNombre()) && nombresito.equals(Cuentas.get(j).getTipoMon())) {
                             
                             System.out.println("Que cantidad se desea transferir2");
                             Cant = Integer.parseInt(br.readLine());
                             if (Cant <= Monedero.get(i).getCantidad()) {
                                 
                                 Monedero.get(i).Resta(Cant);
                                 Cuentas.get(j).suma(Cant);
                                 System.out.println("Transaccion Realizada exitosamente");
                                 System.out.println(Cuentas.get(j).getCantidad());
                             }
                             
                         }else if(nombresitot.equals(Cuentas.get(j).getNombre())){
                               System.out.println("Que cantidad se desea transferir");
                             Cant = Integer.parseInt(br.readLine());
                                if (Cant <= Monedero.get(i).getCantidad()) {
                                 
                              client = new Clientes(nombresitot,Cant,nombresito);
                                Cuentas.add(client);
                                 Monedero.get(i).Resta(Cant);
                                 System.out.println("Transaccion Realizada exitosamente");
                                 System.out.println(Cuentas.get(j).getCantidad());
                                 break;
                             }
                         }
                     }
                 }
             }
         break;
             
         case 3:
                 System.out.println("Ingrese el nombre del cliente desde el que se va a transferir");
             nombresito =br.readLine();
                     System.out.println("Ingrese el tipo de moneda que se quiere realizar el cambio ");
                     nombresitot =br.readLine();
                     for (int j = 0; j < Cuentas.size(); j++) {
                         if (nombresito.equals(Cuentas.get(j).getNombre()) && nombresitot.equals(Cuentas.get(j).getTipoMon())) {
                             
                             System.out.println("Ingrese al cliente el cual recibira el dinero");
                              nombresitoc = br.readLine();
                              for (int k = 0; k < Cuentas.size(); k++) {
                                    if (nombresitoc.equals(Cuentas.get(k).getNombre()) && nombresitot.equals(Cuentas.get(k).getTipoMon())) {
                                                        System.out.println("Que cantidad se desea transferir");
                             Cant = Integer.parseInt(br.readLine());
                             if (Cant <= Cuentas.get(j).getCantidad()) {
                                 
                                 Cuentas.get(j).resta(Cant);
                                 Cuentas.get(k).suma(Cant);
                                 System.out.println("Transaccion Realizada exitosamente");
                                 System.out.println(Cuentas.get(k).getCantidad());
                              }
                                        
                                    } 
                             }
                                 
                            
                        
                             
                             
                        
                 }
             }
             
             break;
             
         case 4:
             for (int i = 0; i < Cuentas.size(); i++) {
                 System.out.println(Cuentas.get(i).getNombre() + " Tiene " + Cuentas.get(i).getCantidad() + " monedas de " + Cuentas.get(i).getTipoMon());
             }
             break;
             
         case 5:
             salida = false;
             break;
         default:
             System.out.println("Error opcion no existente");
             break;
     }
    } catch (IOException ex) {
        System.out.println("Una de las opciones fue colocada de mala forma");
    }
        }
    }
    
}
