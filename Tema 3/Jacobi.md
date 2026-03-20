# Tema 3: Métodos de Solución de Sistemas de Ecuaciones
## Subtema: Método de Jacobi (Iterativo)

> **Estatus:** Documentación Técnica
> **Concepto Clave:** Es un método de "sustitución simultánea". A diferencia de Gauss-Seidel, no usa los valores nuevos de la misma iteración, sino que espera a terminar toda la vuelta para actualizar.

---

### 1. Objetivo
El objetivo del **Método de Jacobi** es obtener una aproximación de las incógnitas de un sistema de ecuaciones lineales mediante un proceso repetitivo (iterativo), partiendo de un vector inicial y reduciendo el error en cada paso hasta alcanzar una tolerancia deseada.

---

### 2. Descripción del Método
El método descompone la matriz $A$ en tres partes: una matriz diagonal ($D$), una triangular inferior ($L$) y una triangular superior ($U$). 

**El proceso lógico es:**
1. Se despeja cada incógnita $x_i$ de su respectiva ecuación en la diagonal.
2. Se inicia con valores arbitrarios (usualmente $x = 0, y = 0, z = 0$).
3. Se calculan los nuevos valores usando **únicamente** los valores de la iteración anterior.
4. Se repite hasta que la diferencia entre la iteración actual y la anterior sea menor a la tolerancia ($\varepsilon$).



---

### 3. Pseudocódigo
```text
INICIO Jacobi(A, b, x0, tol, max_iter)
  n = longitud(b)
  x_nuevo = arreglo de tamaño n
  
  PARA k = 1 HASTA max_iter:
    PARA i = 1 HASTA n:
      suma = 0
      PARA j = 1 HASTA n:
        SI i != j ENTONCES:
          suma = suma + A[i][j] * x0[j]
      
      x_nuevo[i] = (b[i] - suma) / A[i][i]
    
    // Verificar convergencia
    SI error(x_nuevo, x0) < tol ENTONCES:
      RETORNAR x_nuevo
    
    // Actualizar vector para la siguiente iteración completa
    x0 = copiar(x_nuevo)
FIN
```

---

### 4. Codigo
Implementación del método con un máximo de 100 iteraciones y una tolerancia de 0.0001.

```text
public class Jacobi {

    public static void main(String[] args) {
        double[][] A = {
            {10, 2, 1},
            {1, 5, 1},
            {2, 3, 10}
        };
        double[] b = {7, -8, 6};
        double[] x0 = {0, 0, 0}; // Estimación inicial

        resolverJacobi(A, b, x0, 0.0001, 100);
    }

    public static void resolverJacobi(double[][] A, double[] b, double[] x, double tol, int maxIter) {
        int n = b.length;
        double[] xNuevo = new double[n];

        for (int k = 0; k < maxIter; k++) {
            for (int i = 0; i < n; i++) {
                double suma = 0;
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        suma += A[i][j] * x[j];
                    }
                }
                xNuevo[i] = (b[i] - suma) / A[i][i];
            }

            // Calcular error (distancia simple)
            double error = 0;
            for (int i = 0; i < n; i++) {
                error += Math.abs(xNuevo[i] - x[i]);
            }

            // Actualizar x para la siguiente iteración
            System.arraycopy(xNuevo, 0, x, 0, n);

            if (error < tol) {
                System.out.println("Convergencia alcanzada en la iteración " + (k + 1));
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("x[%d] = %.4f%n", i, x[i]);
        }
    }
}
```

Para poder visualizar y correr el ejemplo implementado en Java es el apartado siguiente: [☕ Java](./EjemploJacobi.java)

---

### 5. Conclusion

El Método de Jacobi es la base de los métodos iterativos. Aunque es más lento que Gauss-Seidel (ya que no aprovecha los valores recién calculados), tiene una gran ventaja en la computación moderna: es fácilmente paralelizable. Como cada cálculo de $x_i$ es independiente de los demás dentro de la misma iteración, se puede procesar en diferentes núcleos de un procesador al mismo tiempo.