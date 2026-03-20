# 🧮 Repositorio de Métodos Numéricos

Este repositorio contiene el desarrollo práctico y teórico de la asignatura de **Métodos Numéricos**. El objetivo es comprender cómo las computadoras procesan datos numéricos, las limitaciones de su precisión y la implementación de algoritmos para resolver problemas matemáticos complejos mediante **Java**.

---

## 📂 Estructura del Repositorio

El contenido está organizado por unidades temáticas, abarcando desde la aritmética computacional hasta métodos iterativos de resolución.

---

### 🔹 Tema 1: Errores y Precisión Numérica
En esta unidad se analiza por qué las computadoras no son "exactas" y cómo la representación binaria afecta los cálculos científicos.

| Recurso / Código | Descripción Técnica | Enlace |
| :--- | :--- | :---: |
| **Tipos de Errores** | Documentación sobre error absoluto, relativo y de truncamiento. | [📄 PDF](./Tema%201/Tipos%20de%20errores.pdf) |
| **Error de Redondeo Binario** | Demuestra cómo números decimales simples (como 0.1) no tienen representación exacta en base 2. | [☕ Java](./Tema%201/Error%20de%20Redondeo%20Binario.java) |
| **Cancelación por Resta** | Ejemplo de la pérdida masiva de dígitos significativos al restar dos números muy cercanos entre sí. | [☕ Java](./Tema%201/Cancelación%20por%20Resta.java) |
| **Pérdida por Magnitud** | Ilustra qué sucede cuando sumamos un número muy grande con uno muy pequeño; el pequeño desaparece. | [☕ Java](./Tema%201/Pérdida%20de%20Precisión%20por%20Magnitud.java) |
| **Acumulación en Bucles** | Muestra cómo un pequeño error se magnifica al realizar miles de iteraciones. | [☕ Java](./Tema%201/Acumulación%20de%20Errores%20en%20Bucles.java) |
| **Comparación con `==`** | Explicación práctica de por qué usar `==` con `double` devuelve `false` inesperadamente. | [☕ Java](./Tema%201/Comparación%20Directa%20con%20==.java) |
| **Conversión Estrecha** | Riesgos de pérdida de datos al realizar "casting" de `double` a `float` o `int`. | [☕ Java](./Tema%201/Conversión%20Estrecha.java) |
| **Desbordamiento Silencioso** | Qué ocurre cuando un cálculo supera el valor máximo permitido por el tipo de dato (`Overflow`). | [☕ Java](./Tema%201/Desbordamiento%20Silencioso.java) |
| **Problemario MN EJ26** | Solución detallada a los ejercicios de la unidad 1. | [📄 PDF](./Tema%201/T1%20----E2%20----%20Problemario-%20MN%20EJ26%20.pdf) |

---

### 🔹 Tema 2: Raíces de Ecuaciones
Implementación de métodos numéricos para hallar el valor de $x$ que satisface la ecuación $f(x) = 0$.

| Método | Descripción del Algoritmo | Enlace |
| :--- | :--- | :---: |
| **Método de Bisección** | Basado en el teorema de Bolzano. Divide el intervalo a la mitad sucesivamente. Es lento pero siempre converge. | [☕ Java](./Tema%202/biseccion.java) |
| **Newton-Raphson** | Método abierto que utiliza la derivada de la función. Es extremadamente rápido pero requiere una buena aproximación inicial. | [☕ Java](./☕%20Java/Tema%202/newton.java) |
| **Regula Falsi** | Similar a la bisección, pero une los puntos con una línea recta para aproximar la raíz más rápido. | [☕ Java](./Tema%202/regulaFalsi.java) |
| **Método de la Secante** | Una variante de Newton que no requiere calcular la derivada, usando en su lugar una diferencia finita. | [☕ Java](./Tema%202/secante.java) |
| **Notas de Clase** | Resumen teórico sobre criterios de convergencia y errores de aproximación. | [📝 TXT](./Tema%202/Métodos%20numéricos%20para%20el%20cálculo%20de%20raíces%20de%20ecuaciones.txt) |
| **Problemario T2** |Son ejercicios de todos los metodos| [📝 XLSX](./Tema%202/ProblemarioTema%202.xlsx) |

---

### 🔹 Tema 3: Metodos de solucion de Sistema de Ecuaciones
Estos métodos buscan reducir el sistema a una sola ecuación con una sola incógnita.

| Método | Descripción del Sistema | Enlace |
| :--- | :--- | :---: |
| **Sistema de Gauss Seidel EXPOSICION EQUIPO** | Comienza con una "estimación inicial" y la va refinando hasta que el error es lo suficientemente pequeño. | [📄 PDF](./Tema%203/Presentacion%20Gauss%20Seidel.pdf) |
| **Video EXPOSICION EQUIPO Gauss Seidel** | Realizado con nuevas librerias impartidas por el docente. | [📹 VIDEO](./Tema%203/VideoGrafico.mp4) |
| **Newton-Raphson** | Método abierto que utiliza la derivada de la función. Es extremadamente rápido pero requiere una buena aproximación inicial. | [☕ Java](./☕%20Java/Tema%202/newton.java) |
| **Regula Falsi** | Similar a la bisección, pero une los puntos con una línea recta para aproximar la raíz más rápido. | [☕ Java](./Tema%202/regulaFalsi.java) |
| **Método de la Secante** | Una variante de Newton que no requiere calcular la derivada, usando en su lugar una diferencia finita. | [☕ Java](./Tema%202/secante.java) |
| **Notas de Clase** | Resumen teórico sobre criterios de convergencia y errores de aproximación. | [📝 TXT](./Tema%202/Métodos%20numéricos%20para%20el%20cálculo%20de%20raíces%20de%20ecuaciones.txt) |
| **Problemario T3** |Son ejercicios de todos los Sistemas Explicando el Algoritmo, Codigo y los Codigos dependiendo de casa tipo de Sistema| [📝 PDF](./Tema%203/T3%20-%20E2%20-%20Problemario.pdf) |

---



## 🛠️ Tecnologías y Requisitos

* **Lenguaje:** Java 17 o superior.
* **Paradigma:** Programación Estructurada y Orientada a Objetos.
* **Conceptos clave:** Estándar IEEE 754, Convergencia, Tolerancia ($\epsilon$).

## 🚀 Cómo utilizar este repositorio

1. **Clonar el repositorio:**
   ```bash
   git clone [https://github.com/tu-usuario/nombre-de-tu-repo.git](https://github.com/tu-usuario/nombre-de-tu-repo.git)
