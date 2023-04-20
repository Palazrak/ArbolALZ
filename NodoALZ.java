/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolALZ;

/**
 *
 * @author Pablo Alazraki
 */
public class NodoALZ<T extends Comparable<T>> implements PrintableNode<T> {
    private T elem;
    private NodoALZ<T> izq, der;
    
    public NodoALZ (T elem) {
        this.elem = elem;
        this.der = null;
        this.izq = null;
    }

    @Override
    public T getElem() {
        return elem;
    }

    @Override
    public NodoALZ<T> getIzq() {
        return izq;
    }

    @Override
    public NodoALZ<T> getDer() {
        return der;
    }

    public void setElem(T elem) {
        this.elem = elem;
    }

    public void setIzq(NodoALZ<T> izq) {
        this.izq = izq;
    }

    public void setDer(NodoALZ<T> der) {
        this.der = der;
    }
    
    @Override
    public String toString(){
        return this.elem.toString();
    }
}
