# Tema 5: Métodos de Interpolación
## Subtema: Interpolación Segmentada (Splines)

> **Estatus:** Documentación Técnica
> **Diferencia Clave:** A diferencia de la interpolación polinómica global (como Lagrange o Newton) que sufre del fenómeno de Runge (oscilaciones extremas en los bordes con polinomios de alto grado), la interpolación segmentada utiliza polinomios de bajo grado en cada subintervalo, garantizando una curva suave, precisa y libre de oscilaciones.

---

### 1. Objetivo
El objetivo de la **Interpolación Segmentada** es construir una función continua a trozos que pase exactamente por un conjunto de $n+1$ puntos dados $(x_0, y_0), (x_1, y_1), \dots, (x_n, y_n)$. Se logra utilizando polinomios de bajo grado (típicamente grado 1 para lineal, o grado 3 para splines cúbicos) en cada intervalo $[x_i, x_{i+1}]$ para asegurar un ajuste perfecto sin el riesgo de divergencia global.

---

### 2. Descripción del Método



La interpolación segmentada divide el dominio en pequeños intervalos y ajusta un polinomio diferente en cada uno de ellos. El método más utilizado es el **Spline Cúbico**, ya que asegura que tanto la primera como la segunda derivada sean continuas en los puntos de unión (nodos), logrando una transición visualmente y matemáticamente suave.

**Fórmula general del Spline Cúbico en un intervalo $[x_i, x_{i+1}]$:**

$$
S_i(x) = a_i + b_i(x - x_i) + c_i(x - x_i)^2 + d_i(x - x_i)^3
$$

donde:
- $a_i, b_i, c_i, d_i$ son los **coeficientes** del polinomio cúbico para el subintervalo $i$.
- $x$ es el valor a evaluar dentro del rango $[x_i, x_{i+1}]$.

**Condiciones del Spline Cúbico Natural:**
1. $S_i(x_i) = y_i$ y $S_i(x_{i+1}) = y_{i+1}$ (Pasa por los puntos).
2. $S_i'(x_{i+1}) = S_{i+1}'(x_{i+1})$ (Primera derivada continua).
3. $S_i''(x_{i+1}) = S_{i+1}''(x_{i+1})$ (Segunda derivada continua).
4. $S_0''(x_0) = 0$ y $S_{n-1}''(x_n) = 0$ (Fronteras "naturales").

---

### 3. Pseudocódigo
```text
INICIO InterpolacionSplineLineal(X, Y, x_eval, n)
  // X, Y: arreglos de puntos conocidos
  // x_eval: punto a interpolar
  // n: cantidad de puntos
  
  // Encontrar el intervalo correcto
  PARA i = 0 HASTA n-2:
    SI x_eval >= X[i] Y x_eval <= X[i+1] ENTONCES
      // Fórmula de la recta entre dos puntos (Spline de grado 1)
      m = (Y[i+1] - Y[i]) / (X[i+1] - X[i])
      resultado = Y[i] + m * (x_eval - X[i])
      RETURN resultado
    FIN SI
  
  RETURN Error "Fuera de rango"
FIN
```
### 4. Codigo

```text
public class SplineLinealPrincipal {

    public static void main(String[] args) {
        double[] x = {0.0, 1.0, 2.0, 3.0};
        double[] y = {0.0, 1.0, 4.0, 9.0}; // Puntos de f(x) = x^2

        double xEval = 1.5;

        System.out.println("=== Interpolación Segmentada Lineal ===");
        try {
            double resultado = interpolarLineal(x, y, xEval);
            System.out.printf("El valor interpolado en x = %.2f es: %.4f%n", xEval, resultado);
            System.out.printf("Valor real f(1.5) = 2.25 (La lineal promedia entre 1 y 4)%n");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static double interpolarLineal(double[] x, double[] y, double xEval) {
        int n = x.length;
        for (int i = 0; i < n - 1; i++) {
            if (xEval >= x[i] && xEval <= x[i + 1]) {
                double pendiente = (y[i + 1] - y[i]) / (x[i + 1] - x[i]);
                return y[i] + pendiente * (xEval - x[i]);
            }
        }
        throw new IllegalArgumentException("El valor a evaluar está fuera del dominio de los datos.");
    }
}
```

Para poder visualizar y correr el ejemplo implementado en Java es el apartado siguiente: [☕ CodigoEjemplo1](codigosextrapolacionlineal/ExtrapolacionLinealPrincipal.java)

A continuación van los siguientes codigos:
[☕ CodigoEjemplo2](codigosextrapolacionlineal/ExtrapolacionLineal2.java)
[☕ CodigoEjemplo3](codigosextrapolacionlineal/ExtrapolacionLineal3.java)
[☕ CodigoEjemplo4](codigosextrapolacionlineal/ExtrapolacionLineal4.java)
[☕ CodigoEjemplo5](codigosextrapolacionlineal/ExtrapolacionLineal5.java)

### 📑 5. Conclusion

La Interpolación Segmentada, especialmente mediante Splines Cúbicos, es una herramienta indispensable en los métodos numéricos. Resuelve elegantemente el problema de las oscilaciones extremas de la interpolación global de alto grado, ofreciendo ajustes muy precisos, continuos y computacionalmente estables, siendo la base de los gráficos por computadora y el modelado de trayectorias.