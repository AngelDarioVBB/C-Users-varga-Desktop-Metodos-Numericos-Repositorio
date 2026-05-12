# Tema 4: Métodos de Integración Numérica
## Subtema: Método del Trapecio

> **Estatus:** Documentación Técnica
> **Diferencia Clave:** A diferencia de la integración analítica, este método aproxima el área bajo la curva mediante trapecios, no requiere encontrar la antiderivada.

---

### 1. Objetivo
El objetivo del **Método del Trapecio** es aproximar el valor de una integral definida $\int_{a}^{b} f(x) \, dx$ dividiendo el área bajo la curva en $n$ trapecios y sumando sus áreas.

---

### 2. Descripción del Método
En lugar de calcular la integral exacta, se aproxima la función $f(x)$ por un polinomio lineal entre dos puntos consecutivos. El área bajo ese segmento es un trapecio.

**Fórmula general (Regla del Trapecio Compuesta):**
$$
\int_{a}^{b} f(x) \, dx \approx \frac{h}{2} \left[ f(x_0) + 2\sum_{i=1}^{n-1} f(x_i) + f(x_n) \right]
$$
donde:
- $h = \frac{b-a}{n}$ es el ancho de cada subintervalo.
- $x_i = a + i \cdot h$ son los puntos de la partición.

**Pasos principales:**
1.  Definir la función $f(x)$, los límites $a$ y $b$, y el número de subintervalos $n$.
2.  Calcular el ancho $h = (b-a)/n$.
3.  Evaluar $f(x)$ en $x_0, x_1, \dots, x_n$.
4.  Aplicar la fórmula: sumar los extremos y el doble de los puntos medios.
5.  Multiplicar por $h/2$.

---

### 3. Pseudocódigo
```text
INICIO Trapecio(f, a, b, n)
  h = (b - a) / n
  suma = f(a) + f(b)

  PARA i = 1 HASTA n-1:
    x = a + i * h
    suma = suma + 2 * f(x)

  integral = (h / 2) * suma
  RETURN integral
FIN
```

### 📑 4. Codigo
Implementación funcional para resolver un sistema de n X n.
```text
public class MetodoTrapecio {

    public static void main(String[] args) {
        double a = 0;
        double b = Math.PI;
        int n = 100; // número de subintervalos

        double resultado = trapecio(a, b, n);
        System.out.printf("Aproximación de ∫ sen(x) dx [0, π] = %.6f%n", resultado);
    }

    public static double funcion(double x) {
        return Math.sin(x);
    }

    public static double trapecio(double a, double b, int n) {
        double h = (b - a) / n;
        double suma = funcion(a) + funcion(b);

        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            suma += 2 * funcion(x);
        }

        return (h / 2) * suma;
    }
}
```
Para poder visualizar y correr el ejemplo implementado en Java es el apartado siguiente: [☕ CodigoEjemplo1](Codigos/MetodoTrapecio.java)

A continuación van los siguientes codigos:
[☕ CodigoEjemplo2](Codigos/MetodoTrapecio2.java)
[☕ CodigoEjemplo3](Codigos/MetodoTrapecio3.java)
[☕ CodigoEjemplo4](Codigos/MetodoTrapecio4.java)
[☕ CodigoEjemplo5](Codigos/MetodoTrapecio5.java)



### 📑 5. Conclusion

El Método del Trapecio es uno de los enfoques más simples y didácticos para la integración numérica. Su principal ventaja es la facilidad de implementación y comprensión. Sin embargo, para funciones con alta curvatura o alta precisión, se requieren métodos más avanzados como la regla de Simpson.
