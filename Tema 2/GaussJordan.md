\# Tema 3: Métodos de Solución de Sistemas de Ecuaciones

\## Subtema: Método de Gauss-Jordan



> \*\*Estatus:\*\* Documentación Técnica

> \*\*Diferencia Clave:\*\* A diferencia de la Eliminación Gaussiana, este método no requiere sustitución hacia atrás.



\---



\### 1. Objetivo

El objetivo del método de \*\*Gauss-Jordan\*\* es transformar la matriz de coeficientes de un sistema de ecuaciones lineales en una \*\*matriz identidad\*\* ($I$). Al finalizar el proceso, los valores de las incógnitas aparecen directamente en la columna de los términos independientes.



\---



\### 2. Descripción del Método

Es una variación del método de eliminación gaussiana. Mientras que en el método de Gauss se busca una forma triangular superior, en \*\*Gauss-Jordan\*\* se continúa el proceso de eliminación tanto por debajo como por \*\*encima\*\* de la diagonal principal.



\*\*Pasos principales:\*\*

1\.  Escribir la matriz aumentada $\[A|b]$.

2\.  Normalizar la fila del pivote (hacer que el elemento de la diagonal sea $1$).

3\.  Eliminar los elementos de la columna del pivote (hacerlos $0$) en todas las demás filas, tanto arriba como abajo.

4\.  Repetir para todas las columnas hasta obtener la matriz identidad en el lado izquierdo.







\---



\### 3. Pseudocódigo

```text

INICIO Gauss\_Jordan(A, b, n)

&#x20; PARA i = 1 HASTA n:

&#x20;   // 1. Normalizar la fila i para que A\[i]\[i] sea 1

&#x20;   pivote = A\[i]\[i]

&#x20;   PARA j = i HASTA n:

&#x20;     A\[i]\[j] = A\[i]\[j] / pivote

&#x20;   b\[i] = b\[i] / pivote



&#x20;   // 2. Hacer cero los demás elementos de la columna i

&#x20;   PARA k = 1 HASTA n:

&#x20;     SI k != i ENTONCES:

&#x20;       factor = A\[k]\[i]

&#x20;       PARA j = i HASTA n:

&#x20;         A\[k]\[j] = A\[k]\[j] - factor \* A\[i]\[j]

&#x20;       b\[k] = b\[k] - factor \* b\[i]

FIN



```

\### 📑 4. Codigo

Este Codigo mostrara un ejemplo sobre el ejercicio de limpiar la matriz:



```text

public class GaussJordan {



&#x20;   public static void main(String\[] args) {

&#x20;       double\[]\[] A = {

&#x20;           {2, -1, 3},

&#x20;           {1, 1, 1},

&#x20;           {3, -1, 2}

&#x20;       };

&#x20;       double\[] b = {9, 6, 8};



&#x20;       resolverGaussJordan(A, b);

&#x20;   }



&#x20;   public static void resolverGaussJordan(double\[]\[] A, double\[] b) {

&#x20;       int n = b.length;



&#x20;       for (int i = 0; i < n; i++) {

&#x20;           // Normalizar la fila del pivote

&#x20;           double pivote = A\[i]\[i];

&#x20;           for (int j = 0; j < n; j++) {

&#x20;               A\[i]\[j] /= pivote;

&#x20;           }

&#x20;           b\[i] /= pivote;



&#x20;           // Eliminar elementos en las otras filas

&#x20;           for (int k = 0; k < n; k++) {

&#x20;               if (k != i) {

&#x20;                   double factor = A\[k]\[i];

&#x20;                   for (int j = 0; j < n; j++) {

&#x20;                       A\[k]\[j] -= factor \* A\[i]\[j];

&#x20;                   }

&#x20;                   b\[k] -= factor \* b\[i];

&#x20;               }

&#x20;           }

&#x20;       }



&#x20;       // Mostrar resultados

&#x20;       System.out.println("Solución por Gauss-Jordan:");

&#x20;       for (int i = 0; i < n; i++) {

&#x20;           System.out.printf("x\[%d] = %.2f%n", i, b\[i]);

&#x20;       }

&#x20;   }

}

```

Para poder visualizar y correr el ejemplo implementado en Java es el apartado siguiente: \[☕ Java](./EjemploImplemetado.java)



\---



\### 📑 5. Conclusion

El método de Gauss-Jordan es una herramienta poderosa y directa para resolver sistemas de ecuaciones lineales. Su principal ventaja sobre la eliminación gaussiana simple es que elimina la necesidad de realizar la sustitución hacia atrás, entregando los resultados de forma inmediata.



