# Tema 4: Métodos de Integración Numérica
## Subtema: Método de Simpson 1/3

> **Estatus:** Documentación Técnica
> **Diferencia Clave:** A diferencia del método del trapecio (que usa aproximación lineal), Simpson 1/3 aproxima la función con un polinomio cuadrático, logrando mayor precisión con menos subintervalos.

---

### 1. Objetivo
El objetivo del **Método de Simpson 1/3** es aproximar el valor de una integral definida $\int_{a}^{b} f(x) \, dx$ utilizando polinomios de segundo grado (parábolas) en cada subintervalo, lo que proporciona una aproximación más precisa que la regla del trapecio.

---

### 2. Descripción del Método
La regla de Simpson 1/3 se basa en aproximar la función $f(x)$ por un polinomio cuadrático que pasa por tres puntos igualmente espaciados: $(x_i, f(x_i))$, $(x_{i+1}, f(x_{i+1}))$ y $(x_{i+2}, f(x_{i+2}))$.

**Fórmula general (Regla de Simpson 1/3 Compuesta):**

Para $n$ subintervalos (donde $n$ debe ser **par**):

$$
\int_{a}^{b} f(x) \, dx \approx \frac{h}{3} \left[ f(x_0) + 4\sum_{i=1,3,5,\dots}^{n-1} f(x_i) + 2\sum_{j=2,4,6,\dots}^{n-2} f(x_j) + f(x_n) \right]
$$

donde:
- $h = \frac{b-a}{n}$ es el ancho de cada subintervalo.
- $x_i = a + i \cdot h$ son los puntos de la partición.
- Los términos con coeficiente **4** corresponden a índices **impares** (puntos medios).
- Los términos con coeficiente **2** corresponden a índices **pares** (excepto extremos).

**Pasos principales:**
1.  Verificar que $n$ sea par. Si no lo es, aumentar en 1.
2.  Calcular $h = (b-a)/n$.
3.  Evaluar $f(x_0)$ y $f(x_n)$ (extremos).
4.  Sumar $4 \times f(x_i)$ para $i = 1, 3, 5, \dots, n-1$.
5.  Sumar $2 \times f(x_j)$ para $j = 2, 4, 6, \dots, n-2$.
6.  Multiplicar por $h/3$.

---

### 3. Pseudocódigo
```text
INICIO Simpson13(f, a, b, n)
  SI n % 2 != 0 ENTONCES:
    n = n + 1   // n debe ser par
  
  h = (b - a) / n
  suma = f(a) + f(b)

  PARA i = 1 HASTA n-1:
    x = a + i * h
    SI i % 2 == 1 ENTONCES:
      suma = suma + 4 * f(x)    // índices impares
    SINO:
      suma = suma + 2 * f(x)    // índices pares

  integral = (h / 3) * suma
  RETURN integral
FIN
```

### 📑 4. Codigo
Implementación funcional para resolver un sistema de n X n.
```text
public class MetodoSimpson13 {

    public static void main(String[] args) {
        double a = 0;
        double b = Math.PI;
        int n = 100; // Debe ser par

        double resultado = simpson13(a, b, n);
        System.out.printf("Aproximación de ∫ sen(x) dx [0, π] = %.8f%n", resultado);
        System.out.printf("Valor exacto (2)                 = %.8f%n", 2.0);
    }

    public static double funcion(double x) {
        return Math.sin(x);
    }

    public static double simpson13(double a, double b, int n) {
        // Asegurar que n sea par
        if (n % 2 != 0) {
            n++;
        }

        double h = (b - a) / n;
        double suma = funcion(a) + funcion(b);

        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            if (i % 2 == 1) {
                suma += 4 * funcion(x);
            } else {
                suma += 2 * funcion(x);
            }
        }

        return (h / 3) * suma;
    }
}
```
Para poder visualizar y correr el ejemplo implementado en Java es el apartado siguiente: [☕ CodigoEjemplo1](CodigoSim13/MetodoSimpson13.java)

A continuación van los siguientes codigos:
[☕ CodigoEjemplo2](CodigoSim13/MetodoSimpson132.java)
[☕ CodigoEjemplo3](CodigoSim13/MetodoSimpson133.java)
[☕ CodigoEjemplo4](CodigoSim13/MetodoSimpson134.java)
[☕ CodigoEjemplo5](CodigoSim13/MetodoSimpson135.java)



### 📑 5. Conclusion

El Método del Trapecio es uno de los enfoques más simples y didácticos para la integración numérica. Su principal ventaja es la facilidad de implementación y comprensión. Sin embargo, para funciones con alta curvatura o alta precisión, se requieren métodos más avanzados como la regla de Simpson.
