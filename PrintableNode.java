/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package arbolALZ;

/**
 *
 * @author Pablo Alazraki
 */
public interface PrintableNode<T extends Comparable<T>> {
    PrintableNode getIzq();
    PrintableNode getDer();
    T getElem();
}
