# Tema 4: Métodos de Integración Numérica
## Subtema: Método de Cuadratura Gaussiana

> **Estatus:** Documentación Técnica
> **Diferencia Clave:** A diferencia de los métodos de Newton-Cotes (Trapecio, Simpson) que usan puntos igualmente espaciados, la Cuadratura Gaussiana utiliza puntos y pesos óptimamente seleccionados para maximizar la precisión.

---

### 1. Objetivo
El objetivo del **Método de Cuadratura Gaussiana** es aproximar el valor de una integral definida $\int_{a}^{b} f(x) \, dx$ utilizando una suma ponderada de evaluaciones de la función en puntos estratégicamente elegidos (raíces de polinomios ortogonales), logrando máxima precisión con el menor número posible de evaluaciones.

---

### 2. Descripción del Método
La cuadratura gaussiana se basa en la idea de que, para un número dado de puntos $n$, se pueden elegir los puntos $x_i$ y los pesos $w_i$ de manera que la aproximación sea exacta para polinomios de grado hasta $2n-1$.

**Fórmula general:**
```text
Para una integral en el intervalo estándar $[-1, 1]$:

$$
\int_{-1}^{1} f(x) \, dx \approx \sum_{i=1}^{n} w_i \, f(x_i)
$$

donde:
- $x_i$ son las **raíces del polinomio de Legendre** $P_n(x)$
- $w_i$ son los **pesos** asociados

**Transformación a un intervalo arbitrario $[a, b]$:**

$$
\int_{a}^{b} f(x) \, dx = \frac{b-a}{2} \int_{-1}^{1} f\left( \frac{b-a}{2}t + \frac{b+a}{2} \right) dt \approx \frac{b-a}{2} \sum_{i=1}^{n} w_i \, f\left( \frac{b-a}{2}x_i + \frac{b+a}{2} \right)
```
### 3. Pseudocódigo
```text
INICIO CuadraturaGaussiana(f, a, b, n)
  // n: número de puntos (2, 3, 4, o 5)
  
  // Definir puntos y pesos según n (tablas precomputadas)
  x[], w[] = obtenerPuntosYPesos(n)
  
  suma = 0
  PARA i = 0 HASTA n-1:
    // Transformar del intervalo [-1,1] a [a,b]
    t = ((b - a) / 2) * x[i] + ((b + a) / 2)
    suma = suma + w[i] * f(t)
  
  integral = ((b - a) / 2) * suma
  RETURN integral
FIN
```

### 📑 4. Codigo
```text
public class CuadraturaGaussiana {

    public static void main(String[] args) {
        double a = 0;
        double b = Math.PI;

        System.out.println("=== Cuadratura Gaussiana ===");
        System.out.printf("∫ sen(x) dx [0, π] = 2.0000000000 (exacto)%n%n");

        // Probar con diferentes números de puntos
        for (int n = 2; n <= 5; n++) {
            double resultado = cuadraturaGaussiana(a, b, n);
            System.out.printf("n = %d: %.10f (error: %.2e)%n", 
                n, resultado, Math.abs(2.0 - resultado));
        }
    }

    public static double funcion(double x) {
        return Math.sin(x);
    }

    public static double cuadraturaGaussiana(double a, double b, int n) {
        double[] x, w;
        
        // Seleccionar puntos y pesos según n
        switch (n) {
            case 2:
                x = new double[]{-0.5773502692, 0.5773502692};
                w = new double[]{1.0000000000, 1.0000000000};
                break;
            case 3:
                x = new double[]{-0.7745966692, 0.0000000000, 0.7745966692};
                w = new double[]{0.5555555556, 0.8888888889, 0.5555555556};
                break;
            case 4:
                x = new double[]{-0.8611363116, -0.3399810436, 0.3399810436, 0.8611363116};
                w = new double[]{0.3478548451, 0.6521451549, 0.6521451549, 0.3478548451};
                break;
            case 5:
                x = new double[]{-0.9061798459, -0.5384693101, 0.0000000000, 0.5384693101, 0.9061798459};
                w = new double[]{0.2369268851, 0.4786286705, 0.5688888889, 0.4786286705, 0.2369268851};
                break;
            default:
                throw new IllegalArgumentException("n debe ser 2, 3, 4 o 5");
        }

        double suma = 0;
        double factor = (b - a) / 2;
        double medio = (b + a) / 2;

        for (int i = 0; i < n; i++) {
            double t = factor * x[i] + medio;
            suma += w[i] * funcion(t);
        }

        return factor * suma;
    }
}
```

``

Para poder visualizar y correr el ejemplo implementado en Java es el apartado siguiente: [☕ CodigoEjemplo1](./Codigogauss/CuadraturaGaussiana.java)

A continuación van los siguientes codigos:
[☕ CodigoEjemplo2](./Codigogauss/CuadraturaGaussiana2.java)
[☕ CodigoEjemplo3](./Codigogauss/CuadraturaGaussiana3.java)
[☕ CodigoEjemplo4](./Codigogauss/CuadraturaGaussiana4.java)
[☕ CodigoEjemplo5](./Codigogauss/CuadraturaGaussiana5.java)



### 📑 5. Conclusion

El Método de Cuadratura Gaussiana es el más sofisticado y preciso de los métodos de integración numérica presentados. Su principal ventaja es lograr altísima precisión con muy pocas evaluaciones de la función, gracias a la elección óptima de puntos y pesos. Esto es especialmente valioso cuando la función f(x) es costosa de evaluar.
