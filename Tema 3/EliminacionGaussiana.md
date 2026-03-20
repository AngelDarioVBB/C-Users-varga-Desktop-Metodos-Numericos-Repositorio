# 📘 Tema 3: Métodos de Solución de Sistemas de Ecuaciones
## 📂 Subtema: Eliminación Gaussiana

> **Estatus:** Exposición de Equipo 03
> **Integrantes:** Vargas y Equipo

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