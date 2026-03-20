# Tema 3: Métodos de Solución de Sistemas de Ecuaciones
## Subtema: Método de Gauss-Jordan

> **Estatus:** Documentación Técnica
> **Diferencia Clave:** A diferencia de la Eliminación Gaussiana, este método no requiere sustitución hacia atrás.

---

### 1. Objetivo
El objetivo del método de **Gauss-Jordan** es transformar la matriz de coeficientes de un sistema de ecuaciones lineales en una **matriz identidad** ($I$). Al finalizar el proceso, los valores de las incógnitas aparecen directamente en la columna de los términos independientes.

---

### 2. Descripción del Método
Es una variación del método de eliminación gaussiana. Mientras que en el método de Gauss se busca una forma triangular superior, en **Gauss-Jordan** se continúa el proceso de eliminación tanto por debajo como por **encima** de la diagonal principal.

**Pasos principales:**
1.  Escribir la matriz aumentada $[A|b]$.
2.  Normalizar la fila del pivote (hacer que el elemento de la diagonal sea $1$).
3.  Eliminar los elementos de la columna del pivote (hacerlos $0$) en todas las demás filas, tanto arriba como abajo.
4.  Repetir para todas las columnas hasta obtener la matriz identidad en el lado izquierdo.



---

### 3. Pseudocódigo
```text
INICIO Gauss_Jordan(A, b, n)
  PARA i = 1 HASTA n:
    // 1. Normalizar la fila i para que A[i][i] sea 1
    pivote = A[i][i]
    PARA j = i HASTA n:
      A[i][j] = A[i][j] / pivote
    b[i] = b[i] / pivote

    // 2. Hacer cero los demás elementos de la columna i
    PARA k = 1 HASTA n:
      SI k != i ENTONCES:
        factor = A[k][i]
        PARA j = i HASTA n:
          A[k][j] = A[k][j] - factor * A[i][j]
        b[k] = b[k] - factor * b[i]
FIN
```
### 📑 4. Codigo
Implementación funcional para resolver un sistema de n X n.
```text
public class GaussJordan {

    public static void main(String[] args) {
        double[][] A = {
            {2, -1, 3},
            {1, 1, 1},
            {3, -1, 2}
        };
        double[] b = {9, 6, 8};

        resolverGaussJordan(A, b);
    }

    public static void resolverGaussJordan(double[][] A, double[] b) {
        int n = b.length;

        for (int i = 0; i < n; i++) {
            // Normalizar la fila del pivote
            double pivote = A[i][i];
            for (int j = 0; j < n; j++) {
                A[i][j] /= pivote;
            }
            b[i] /= pivote;

            // Eliminar elementos en las otras filas
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = A[k][i];
                    for (int j = 0; j < n; j++) {
                        A[k][j] -= factor * A[i][j];
                    }
                    b[k] -= factor * b[i];
                }
            }
        }

        // Mostrar resultados
        System.out.println("Solución por Gauss-Jordan:");
        for (int i = 0; i < n; i++) {
            System.out.printf("x[%d] = %.2f%n", i, b[i]);
        }
    }
}
```

### 📑 5. Conclusion

El método de Gauss-Jordan es una herramienta poderosa y directa para resolver sistemas de ecuaciones lineales. Su principal ventaja sobre la eliminación gaussiana simple es que elimina la necesidad de realizar la sustitución hacia atrás, entregando los resultados de forma inmediata.