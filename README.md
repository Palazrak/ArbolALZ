# Arbol ALZ: Arbol binario de busqueda balanceado sin rotaciones.

Para la clase de Estructuras de Datos Avanzadas se nos encargo encontrar una manera de mantener un arbol binario de busqueda balanceado, es decir, con complejidad de busqueda de O(log n), sin utilizar las rotaciones de un arbol AVL.

Para resolver este problema, propuse crear un arbol que funcionara de manera interna con un arreglo. Este arbol ALZ (iniciales obtenidas por mi apellido), tiene las siguientes caracteristicas:
- El arreglo interno siempre estara ordenado para poder aplicar busqueda binaria, que tiene la misma complejidad en la busqueda que un Arbol AVL.
- Al querer visualizar el arbol, iria "partiendo en mitades" de manera recursiva. De "abajo hacia arriba" iria colgando a los nodos hijos en los padres, y a los padres en sus padres.
- Implementa una logica lazy, en donde solo construye todo el arbol (que si funciona con memoria dinamica) cuando se especifica que se construya, y no cada vez que se agregue o se elimine algo en el arbol.

## Consideraciones sobre mi solucion:

- A pesar de que la solucion responde al requisito de mantener la busqueda con complejidad O(log n), la insercion y la eliminacion tienen complejidad de O(n + log n)
- Al funcionar internamente con un arreglo, no se aprovecha la propiedad de memoria dinamica que si tiene un arbol AVL tradicional
- Solo se puede garantizar que sea un arbol binario de busqueda cuando se insertan elementos distintos. Sin embargo, el arbol ALZ garantiza ser un arbol binario en el que la busqueda es O(log n).
- Utiliza tanto espacio fijo en memoria como memoria dinamica.

## Sobre el repositorio:

El repositorio contiene los siguientes archivos:
- PrintableNode.java y TreePrinter.java, que permiten visualizar al arbol de manera limpia y clara.
- NodoALZ.java y ArbolALZ.java, que contienen los metodos para la funcionalidad de la clase.
- NodoALZMain.java, que contiene pruebas de la clase ArbolALZ.

## Sobre el codigo:

ArbolALZ.java contiene los metodos busca, inserta y elimina. Como metodos privados de la clase contiene la forma en la que se construye el arbol ALZ cuando se solicita que sea impreso (y solo lo crea desde cero cuando ha habido modificaciones).
