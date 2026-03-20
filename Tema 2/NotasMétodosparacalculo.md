#  Tema 2: Anotaciones que se realizaron para recabar información de Métodos Numéricos para el Cálculo de Raíces

Este apartado contiene la descripción y algoritmos de los principales métodos utilizados para encontrar raíces de ecuaciones no lineales, divididos en **Métodos Cerrados** y **Métodos Abiertos**.

---

##  1. Métodos Cerrados
Los métodos cerrados siempre trabajan dentro de un intervalo $[a, b]$ donde se garantiza que existe un cambio de signo.

### Teorema de Bolzano
Es el pilar de los métodos cerrados. Establece que si una función $f(x)$ es **continua** en un intervalo $[a, b]$ y el producto de sus imágenes tiene signos opuestos $f(a) \cdot f(b) < 0$, entonces existe al menos una raíz real en ese intervalo.

* **Uso:** Garantizar la existencia de la raíz y justificar métodos como Bisección y Regla Falsa.



---

###  Método de Bisección
Divide el intervalo a la mitad en cada iteración, conservando el subintervalo donde persiste el cambio de signo.

* **Características:** Es muy robusto y siempre converge, aunque suele ser **relativamente lento**.
* **Algoritmo:**
    1. Verificar $f(a) \cdot f(b) < 0$.
    2. Calcular el punto medio: $c = \frac{a + b}{2}$.
    3. Si $|f(c)| < \text{tol}$, devolver $c$.
    4. Si $f(a) \cdot f(c) < 0$ entonces $b = c$, de lo contrario $a = c$.

> [!TIP]
> **Código en Java:** El ejercicio está disponible en [biseccion.java](./biseccion.java)

---

### Método de Regla Falsa (Regula Falsi)
Mejora la bisección uniendo los puntos $(a, f(a))$ y $(b, f(b))$ con una línea recta (secante). La intersección de esta línea con el eje $x$ es la nueva aproximación.

* **Fórmula:** $c = a - \frac{f(a)(b - a)}{f(b) - f(a)}$
* **Ventajas:** Suele converger en menos iteraciones que la bisección.
* **Problemas:** Puede volverse lento si uno de los extremos se estanca (no se mueve).



> [!TIP]
> **Código en Java:** El ejercicio está disponible en [regularFalsi.java](./regularFalsi.java)

---

##  2. Métodos Abiertos
A diferencia de los cerrados, estos no necesitan un intervalo, sino que parten de uno o dos puntos iniciales y no requieren cambio de signo.

###  Método de Newton-Raphson
Utiliza la recta tangente a la curva en un punto $x_n$ para aproximar la siguiente posición de la raíz.

* **Fórmula:** $x_{n+1} = x_n - \frac{f(x_n)}{f'(x_n)}$
* **Efectividad:** Muy rápido (convergencia cuadrática) si el punto inicial $x_0$ está cerca de la raíz.
* **Limitaciones:** Requiere conocer la derivada $f'(x)$. Si la derivada es cero o el punto está lejos, puede divergir.



> [!TIP]
> **Código en Java:** El ejercicio está disponible en [newton.java](./newton.java)

---

###  Método de la Secante
Es una variante de Newton-Raphson que no requiere la derivada. En su lugar, aproxima la pendiente usando dos puntos anteriores.

* **Fórmula:** $x_{n+1} = x_n - \frac{f(x_n)(x_n - x_{n-1})}{f(x_n) - f(x_{n-1})}$
* **Ventajas:** Más "barato" computacionalmente al no requerir $f'(x)$.
* **Problemas:** Puede divergir si las aproximaciones iniciales son malas o si la función oscila demasiado.

> [!TIP]
> **Código en Java:** El ejercicio está disponible en [secante.java](./secante.java)

---

##  Comparativa de Métodos

| Método | Tipo | Convergencia | ¿Requiere Derivada? | Estabilidad |
| :--- | :--- | :--- | :---: | :--- |
| **Bisección** | Cerrado | Lenta | No | Muy Estable |
| **Regla Falsa** | Cerrado | Media | No | Estable |
| **Newton** | Abierto | Muy Rápida | Sí | Riesgo de divergencia |
| **Secante** | Abierto | Rápida | No | Riesgo de divergencia |

---
_Metodologías implementadas para la materia de Métodos Numéricos._
