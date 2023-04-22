/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolALZ;

/**
 *
 * @author Pablo Alazraki
 */
public class ArbolALZ<T extends Comparable<T>> {
    private Comparable[] arbol;
    private int cont;
    private NodoALZ<T> raiz;
    private int operations;
    private final int MAX_ELEM = 10;
    
    public ArbolALZ(){
        arbol = new Comparable[MAX_ELEM];
        cont = 0;
        operations = 0;
        raiz = null;
    }
    
    public ArbolALZ(Comparable elem){
        this();
        arbol[cont] = elem;
        cont++;
    }
    
    public int getCont(){
        return this.cont;
    }
    
    //Es un algoritmo de busqueda binaria, que cumple ser O(log_2(n))
    //Regresa el índice del arreglo en el que se encuentra el dato
    /*NOTA: Cuando no está y debería estar en la primera posición también regresa cero. 
              Se maneja este caso en el elimina, que es donde importa. */
    private int busca(Comparable dato){
        int pos;
        int inicio = 0;
        int fin = cont - 1;
        int mitad = (inicio + fin) / 2; 
        while (inicio <= fin && !arbol[mitad].equals(dato)) {
            if (dato.compareTo(arbol[mitad]) < 0)
                fin = mitad - 1; 
            else 
                inicio = mitad +1 ;
            mitad = (inicio + fin) / 2;
        }
        if (inicio > fin)		// elemento no encontrado regresa el índice negativo de donde debería estar.
            pos =  -fin-1;	
        else 				// elemento sí encontrado
            pos = mitad;
        return pos;
	}
    
    private void expande(){
        Comparable[] masGrande = new Comparable[arbol.length * 2];
        for(int i = 0; i < cont; i++)
            masGrande[i] = arbol[i];
        arbol = masGrande;
    }
    
    public NodoALZ <T> getRaiz(){
        if (this.raiz == null || operations != 0){
            this.raiz = parte(0, cont - 1, cont);
            this.operations = 0;
        }
        return raiz;
    }
    
    private NodoALZ<T> parte(int inicio, int fin, int n){
        if (n == 1)
            return new NodoALZ(arbol[inicio]);
        
        if (n == 2){
            NodoALZ<T> papa = new NodoALZ(arbol[inicio]);
            NodoALZ<T> hijo = new NodoALZ(arbol[fin]);
            papa.setDer(hijo);
            return papa;
        }
        
        int mitad = inicio + (fin - inicio) / 2; 
        
        NodoALZ<T> papa = new NodoALZ(arbol[mitad]);    
        NodoALZ<T> hijoIzq = parte(inicio, mitad - 1, mitad - inicio);
        NodoALZ<T> hijoDer = parte(mitad + 1, fin, fin - mitad);
        
        papa.setIzq(hijoIzq);
        papa.setDer(hijoDer);
        
        return papa;
    }
    
    public void inserta(Comparable dato){
        if (cont == 0)
            arbol[cont] = dato;
        else{
            if(cont == arbol.length)
                expande();
            int i = busca(dato);
            if (i < 0)
                i *= -1;
            for (int j = cont; j>i; j--)
                arbol[j] = arbol[j-1];
            arbol[i] = dato;
        }
        cont++;
        operations ++;
    }
    
    public Comparable elimina(Comparable dato){
        if (cont == 0)
            throw new RuntimeException("Error: el arbol esta vacio");
        Comparable res;
        int pos = busca(dato);
        if (pos < 0)
            res = null;
        else{
            if (pos == 0 && !arbol[0].equals(dato))
                return null;
            res = arbol[pos];
            for (int i = pos; i < cont - 1; i++)
                arbol[i] = arbol[i+1];
            arbol[cont - 1] = null;
            cont--;
        }
        operations ++;
        return res;
    }
    
    public boolean contiene(Comparable dato){
        int pos = busca(dato);
        return pos >= 0;
    }
    
    public boolean estaVacio(){
        return cont == 0;
    }
    
    //Método que calcula la altura del arbol completo
    public int alturaArbol(){
        return alturaArbol(this.getRaiz());
    }
    
    private int alturaArbol(NodoALZ<T> actual) {
        if (actual == null) 
            return 0;
        int f1 = alturaArbol(actual.getIzq()) + 1;
        int f2 = alturaArbol(actual.getDer()) + 1;
        
        return Math.max(f1, f2);
    }

    //Imprime el arreglo interno del arbol SIN PODER MODIFICARLO a menos que se inserte o se elimine.
    @Override
    public String toString(){
        StringBuilder cad = new StringBuilder();
        cad.append("[");
        for (int i = 0; i < cont; i++){
            cad.append(arbol[i]).append(", ");
        }
        cad.append("]");
        return cad.toString();
    }
    
}
