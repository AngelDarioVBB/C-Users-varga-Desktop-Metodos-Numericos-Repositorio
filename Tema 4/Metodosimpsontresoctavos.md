# Tema 4: Métodos de Integración Numérica
## Subtema: Método de Simpson 3/8

> **Estatus:** Documentación Técnica
> **Diferencia Clave:** A diferencia de Simpson 1/3 (que usa un polinomio cuadrático), Simpson 3/8 aproxima la función con un polinomio cúbico, lo que permite integrar con mayor precisión y manejar casos donde n es múltiplo de 3.

---

### 1. Objetivo
El objetivo del **Método de Simpson 3/8** es aproximar el valor de una integral definida $\int_{a}^{b} f(x) \, dx$ utilizando polinomios de tercer grado (cúbicos) en cada subintervalo, proporcionando una aproximación más precisa que Simpson 1/3 para ciertos tipos de funciones.

---

### 2. Descripción del Método
La regla de Simpson 3/8 se basa en aproximar la función $f(x)$ por un polinomio cúbico que pasa por cuatro puntos igualmente espaciados: $(x_i, f(x_i))$, $(x_{i+1}, f(x_{i+1}))$, $(x_{i+2}, f(x_{i+2}))$ y $(x_{i+3}, f(x_{i+3}))$.

**Fórmula general (Regla de Simpson 3/8 Compuesta):**

Para $n$ subintervalos (donde $n$ debe ser **múltiplo de 3**):

$$
\int_{a}^{b} f(x) \, dx \approx \frac{3h}{8} \left[ f(x_0) + 3\sum_{i=1}^{n-1} f(x_i) + 3\sum_{j=2}^{n-2} f(x_j) + 2\sum_{k=3,6,9,\dots}^{n-3} f(x_k) + f(x_n) \right]
$$

De forma más clara, para grupos de 3 subintervalos (4 puntos):

$$
\int_{x_0}^{x_3} f(x) \, dx \approx \frac{3h}{8} \left[ f(x_0) + 3f(x_1) + 3f(x_2) + f(x_3) \right]
$$

donde:
- $h = \frac{b-a}{n}$ es el ancho de cada subintervalo.
- $x_i = a + i \cdot h$ son los puntos de la partición.
- El patrón de coeficientes es: **1, 3, 3, 2, 3, 3, 2, ..., 3, 3, 1**

**Pasos principales:**
1. Verificar que $n$ sea múltiplo de 3. Si no lo es, ajustar al siguiente múltiplo.
2. Calcular $h = (b-a)/n$.
3. Evaluar $f(x_0)$ y $f(x_n)$ (extremos).
4. Recorrer los puntos interiores aplicando coeficientes según su posición.
5. Multiplicar por $3h/8$.

---

### 3. Pseudocódigo
```text
INICIO Simpson38(f, a, b, n)
  // Asegurar que n sea múltiplo de 3
  MIENTRAS n % 3 != 0:
    n = n + 1
  
  h = (b - a) / n
  suma = f(a) + f(b)

  PARA i = 1 HASTA n-1:
    x = a + i * h
    SI i % 3 == 0 ENTONCES:
      suma = suma + 2 * f(x)    // puntos cada 3 (múltiplos de 3)
    SINO:
      suma = suma + 3 * f(x)    // puntos intermedios

  integral = (3 * h / 8) * suma
  RETURN integral
FIN
```
### 📑 4. Codigo
```text
public class MetodoSimpson38 {

    public static void main(String[] args) {
        double a = 0;
        double b = Math.PI;
        int n = 9; // Debe ser múltiplo de 3

        double resultado = simpson38(a, b, n);
        System.out.printf("Aproximación de ∫ sen(x) dx [0, π] = %.8f%n", resultado);
        System.out.printf("Valor exacto (2)                     = %.8f%n", 2.0);
    }

    public static double funcion(double x) {
        return Math.sin(x);
    }

    public static double simpson38(double a, double b, int n) {
        // Asegurar que n sea múltiplo de 3
        while (n % 3 != 0) {
            n++;
        }

        double h = (b - a) / n;
        double suma = funcion(a) + funcion(b);

        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            if (i % 3 == 0) {
                suma += 2 * funcion(x);
            } else {
                suma += 3 * funcion(x);
            }
        }

        return (3 * h / 8) * suma;
    }
}
```

Para poder visualizar y correr el ejemplo implementado en Java es el apartado siguiente: [☕ CodigoEjemplo1](CodigoSim13MetodoSimpson38.java)

A continuación van los siguientes codigos:
[☕ CodigoEjemplo2](CodigoSim38/MetodoSimpson382.java)
[☕ CodigoEjemplo3](CodigoSim38/MetodoSimpson383.java)
[☕ CodigoEjemplo4](CodigoSim38/MetodoSimpson384.java)
[☕ CodigoEjemplo5](CodigoSim38/MetodoSimpson385.java)



### 📑 5. Conclusion

El Método de Simpson 3/8 es una extensión natural del método de Simpson 1/3 que utiliza interpolación cúbica en lugar de cuadrática. Aunque tiene el mismo orden de error 
Oh(4), ofrece flexibilidad adicional cuando se requiere que el número de subintervalos sea múltiplo de 3. En la práctica, se recomienda usar Simpson 1/3 cuando n es par y Simpson 3/8 cuando n es múltiplo de 3, o combinarlos para casos mixtos.
