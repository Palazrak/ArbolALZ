/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolALZ;

/**
 *
 * @author Pablo Alazraki
 */
import static arbolALZ.TreePrinter.print;
public class ArbolALZMain {
    public static void main(String[] args) {
        ArbolALZ prueba = new ArbolALZ();
        int n = 100;
        for (int i = 1; i <= n; i++)
            prueba.inserta(i);

        System.out.println(".-.-.-.-.-.-.-.-.-.PRIMER ARBOL.-.-.-.-.-.-.-.-.-.");
        System.out.println(prueba.toString());
        print(prueba.getRaiz());
        System.out.println("La altura es: " + prueba.alturaArbol());
        System.out.println(Math.ceil(Math.log(n)/Math.log(2)));
        
    }
  
}
