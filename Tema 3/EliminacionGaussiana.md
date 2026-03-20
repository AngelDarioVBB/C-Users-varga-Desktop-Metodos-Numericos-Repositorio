# 📘 Tema 3: Métodos de Solución de Sistemas de Ecuaciones
## 📂 Subtema: Eliminación Gaussiana

> **Estatus:** Apuntes sobre exposición de compañeros

---

### 🎯 1. Objetivo
El objetivo primordial del método de **Eliminación Gaussiana** es transformar un sistema de ecuaciones lineales complejo en un **sistema triangular superior**. Esto permite resolver las incógnitas de manera sencilla mediante una **sustitución hacia atrás**, reduciendo significativamente el error humano y el tiempo de cálculo.

---

### 📝 2. Descripción del Método
Este método algebraico utiliza la **matriz aumentada** (que combina los coeficientes de las variables y los términos independientes). A través de operaciones elementales de fila, buscamos generar ceros debajo de la diagonal principal.

**Operaciones permitidas:**
* Intercambio de filas.
* Multiplicación de una fila por un número distinto de cero.
* Sumar o restar múltiplos de una fila a otra.



---

### 📑 3. Pseudocódigo
Este algoritmo representa la lógica que sigue el programa para limpiar la matriz:

```text
INICIO Eliminación_Gaussiana
  PARA k = 1 HASTA n-1:
    PARA i = k+1 HASTA n:
      Factor = A[i,k] / A[k,k]
      Fila[i] = Fila[i] - Factor * Fila[k]
  
  // Sustitución hacia atrás
  x[n] = b[n] / A[n,n]
  PARA i = n-1 HASTA 1:
    Suma = 0
    PARA j = i+1 HASTA n:
      Suma = Suma + A[i,j] * x[j]
    x[i] = (b[i] - Suma) / A[i,i]
FIN
```

---

### 📑 4. Codigo
Este Codigo mostrara un ejemplo sobre el ejercicio de limpiar la matriz:

```textpublic class EliminacionGaussiana {

    public static void main(String[] args) {
        // Matriz de coeficientes (A)
        double[][] A = {
            {3, 2, -1},
            {2, -2, 4},
            {-1, 0.5, -1}
        };
        // Vector de términos independientes (b)
        double[] b = {1, -2, 0};

        double[] solucion = resolver(A, b);

        // Imprimir resultados
        System.out.println("Solución del sistema:");
        for (int i = 0; i < solucion.length; i++) {
            System.out.printf("x[%d] = %.2f%n", i, solucion[i]);
        }
    }

    public static double[] resolver(double[][] A, double[] b) {
        int n = b.length;

        // 1. Fase de Eliminación hacia adelante
        for (int i = 0; i < n; i++) {
            // Pivoteo: Buscar el máximo en la columna para mayor precisión (opcional)
            for (int k = i + 1; k < n; k++) {
                double factor = A[k][i] / A[i][i];
                b[k] -= factor * b[i];
                for (int j = i; j < n; j++) {
                    A[k][j] -= factor * A[i][j];
                }
            }
        }

        // 2. Fase de Sustitución hacia atrás
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double suma = 0.0;
            for (int j = i + 1; j < n; j++) {
                suma += A[i][j] * x[j];
            }
            x[i] = (b[i] - suma) / A[i][i];
        }
        return x;
    }
}
```

Para poder visualizar y correr el ejemplo implementado en Java es el apartado siguiente: [☕ Java](./EjemploImplemetado.java)

---
