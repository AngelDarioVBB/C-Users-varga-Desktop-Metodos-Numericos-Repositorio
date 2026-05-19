# Tema 5: Métodos de Extrapolación
## Subtema: Extrapolación Polinómica

> **Estatus:** Documentación Técnica
> **Diferencia Clave:** A diferencia de la extrapolación lineal que solo toma los dos últimos puntos y asume un cambio constante, la extrapolación polinómica utiliza un polinomio de grado $n$ construido a partir de múltiples puntos. Esto le permite capturar curvas, aceleraciones y tendencias no lineales, aunque introduce un riesgo crítico de oscilaciones salvajes e inestabilidad numérica en los extremos (Fenómeno de Runge).

---

### 1. Objetivo
El objetivo de la **Extrapolación Polinómica** es proyectar el comportamiento de un sistema no lineal hacia valores fuera del rango muestreado ($x > x_n$ o $x < x_0$), modelando la tendencia mediante una función polinomial de grado superior. Se utiliza cuando se sabe de antemano que la variable estudiada no se comporta de forma recta (por ejemplo, crecimientos exponenciales aproximados, órbitas físicas o cinemática).

---

### 2. Descripción del Método

La extrapolación polinómica consiste en hallar el único polinomio de grado $n$ (o menor) que pasa exactamente por $n+1$ puntos conocidos, para luego evaluarlo en un punto objetivo externo. Matemáticamente se puede construir mediante el método de Lagrange o las Diferencias Divididas de Newton.

La forma general del Polinomio de Newton es:

$$
P_n(x) = f[x_0] + f[x_0, x_1](x - x_0) + f[x_0, x_1, x_2](x - x_0)(x - x_1) + \dots + f[x_0, \dots, x_n] \prod_{i=0}^{n-1}(x - x_i)
$$

**Advertencia de estabilidad:** Aunque un polinomio de mayor grado se ajusta perfectamente a los datos históricos, su comportamiento fuera del rango suele divergir de forma catastrófica hacia el infinito positivo o negativo. Por ello, rara vez se recomienda usar grados mayores a 3 o 4 para extrapolar.

---

### 3. Pseudocódigo
```text
INICIO ExtrapolacionNeville(X, Y, x_eval, n)
  // X, Y: Arreglos de puntos históricos de tamaño n
  // x_eval: Punto fuera del rango a proyectar
  
  // Crear una matriz cuadrada para los pasos intermedios de Neville
  Definir Q[n][n]
  
  // Inicializar la primera columna con los valores de Y
  PARA i = 0 HASTA n-1:
    Q[i][0] = Y[i]
  FIN PARA
  
  // Calcular aproximaciones polinómicas iterativas
  PARA i = 1 HASTA n-1:
    PARA j = i HASTA n-1:
      numerador = (x_eval - X[j-i]) * Q[j][i-1] - (x_eval - X[j]) * Q[j-1][i-1]
      denominador = X[j] - X[j-i]
      Q[j][i] = numerador / denominador
    FIN PARA
  FIN PARA
  
  // El último elemento calculado contiene la extrapolación de mayor grado
  RETURN Q[n-1][n-1]
FIN
```

---

### 4. Código
```text
public class ExtrapolacionPolinomialPrincipal {

    public static void main(String[] args) {
        // Datos de un objeto acelerando (Tiempo vs Distancia)
        double[] tiempo = {0.0, 1.0, 2.0, 3.0};
        double[] distancia = {0.0, 2.5, 10.0, 22.5}; // Sigue la curva 2.5 * t^2

        double tiempoProyeccion = 4.0; // Punto fuera del rango original

        System.out.println("=== Extrapolación Polinómica de Newton ===");
        double[][] tabla = calcularDiferenciasDivididas(tiempo, distancia);
        double resultado = evaluarNewton(tabla, tiempo, tiempoProyeccion);

        System.out.printf("Proyección para t = %.1f s -> Distancia estimada: %.2f m%n", 
                          tiempoProyeccion, resultado);
        System.out.printf("Valor real esperado: %.2f m%n", 2.5 * Math.pow(tiempoProyeccion, 2));
    }

    private static double[][] calcularDiferenciasDivididas(double[] x, double[] y) {
        int n = x.length;
        double[][] tabla = new double[n][n];
        for (int i = 0; i < n; i++) {
            tabla[i][0] = y[i];
        }
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                tabla[i][j] = (tabla[i + 1][j - 1] - tabla[i][j - 1]) / (x[i + j] - x[i]);
            }
        }
        return tabla;
    }

    private static double evaluarNewton(double[][] tabla, double[] x, double xEval) {
        int n = x.length;
        double resultado = tabla[0][0];
        double producto = 1.0;

        for (int i = 1; i < n; i++) {
            producto *= (xEval - x[i - 1]);
            resultado += tabla[0][i] * producto;
        }
        return resultado;
    }
}
```


Para poder visualizar y correr el ejemplo implementado en Java es el apartado siguiente: [☕ CodigoEjemplo1](codigosextrapolacionpoli/ExtrapolacionPolinomialPrincipal.java)

A continuación van los siguientes codigos:
[☕ CodigoEjemplo2](codigosextrapolacionpoli/ExtrapolacionPolinomial2.java)
[☕ CodigoEjemplo3](codigosextrapolacionpoli/ExtrapolacionPolinomial3.java)
[☕ CodigoEjemplo4](codigosextrapolacionpoli/ExtrapolacionPolinomial4.java)
[☕ CodigoEjemplo5](codigosextrapolacionpoli/ExtrapolacionPolinomial5.java)

---

### 📑 5. Conclusion
La extrapolación polinómica es una espada de doble filo. Aunque ofrece la capacidad matemática de amoldarse y proyectar tendencias curvas complejas que la extrapolación lineal ignora, se vuelve extremadamente inestable con conjuntos de datos grandes debido a la alta sensibilidad de los términos polinomiales de grado elevado. Se debe emplear con cautela, en rangos de alcance cortos y manteniendo el grado del polinomio lo más bajo posible.
