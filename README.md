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
| **Notas de Clase** | Resumen teórico sobre criterios de convergencia y errores de aproximación. | [📝 MD](./Tema%202/NotasMétodosparacalculo.md) |
| **Problemario T2** |Son ejercicios de todos los metodos| [📝 XLSX](./Tema%202/ProblemarioTema%202.xlsx) |

---

### 🔹 Tema 3: Metodos de solucion de Sistema de Ecuaciones
Estos métodos buscan reducir el sistema a una sola ecuación con una sola incógnita.

| Método | Descripción del Sistema | Enlace |
| :--- | :--- | :---: |
| **Sistema de Gauss Seidel EXPOSICION EQUIPO** | Comienza con una "estimación inicial" y la va refinando hasta que el error es lo suficientemente pequeño. | [📄 PDF](./Tema%203/Presentacion%20Gauss%20Seidel.pdf) |
| **Video EXPOSICION EQUIPO Gauss Seidel** | Realizado con nuevas librerias impartidas por el docente. | [📹 VIDEO](./Tema%203/VideoGrafico.mp4) |
| **Sistema Eliminación Gaussiana** | Una vez que el sistema está "escalonado", los valores de las incógnitas se encuentran mediante sustitución hacia atrás, empezando por la última variable hasta llegar a la primera. | [☕ MD](./Tema%203/EliminacionGaussiana.md) |
| **Sistema Gauss Jordan** | El método transforma la matriz de coeficientes de un sistema de ecuaciones lineales en una **matriz identidad** (I). Al finalizar el proceso, los valores de las incógnitas aparecen directamente en la columna de los términos independientes. | [☕ MD](./Tema%203/GaussJordan.md) |
| **Sistema Jacobi** | El método descompone la matriz A en tres partes: una matriz diagonal (D), una triangular inferior (L) y una triangular superior (U). | [☕ MD](./Tema%203/Jacobi.md) |
| **Problemario T3** |Son ejercicios de todos los Sistemas Explicando el Algoritmo, Codigo y los Codigos dependiendo de casa tipo de Sistema| [📝 PDF](./Tema%203/T3Problemario.pdf) |

---


### 🔹 Tema 4: Metodos y Video IA
Estos métodos buscan reducir el error al marcar dos o mas puntos con los siguientes puntos.

| Método | Descripción del Sistema | Enlace |
| :--- | :--- | :---: |
| **Video explicativo con IA de los temas** | Es importante ya que es para analizar los temas explicados con una IA todo referenciado | [📄 txt](./linkexpoIA.txt) |
| **Video EXPOSICION EQUIPO Gauss Seidel** | Realizado con nuevas librerias impartidas por el docente. | [📹 VIDEO](./Tema%203/VideoGrafico.mp4) |
| **Método del Trapecio** | El método aproxima el Área bajo la curva reemplazando el tramo de la función entre los dos formando así un trapecio. | [☕ MD](./Tema%204/metodotrapecio.md) |
| **Método de Simpson 1/3** | El método mejora la precisión del trapecio al aproximar función mediante parábolas en lugar de segmentos rectos. | [☕ MD](./Tema%204/metodosimpsonuntercio.md) |
| **Método de Simpson 3/8** | El método utiliza polinomios cúbicospara aproximar la curva en grupos de tres subinter.Resulta especialmente útil cuando la cantidad de divisiones es múltiplo de tres o cuando se conbina con particiones mixtas. | [☕ MD](./Tema%204/Metodosimpsontresoctavos.md) |
| **Método de la Cuadratura Gaussiana** | El método de la cuadratura gaussiana aproxima integrales mediante una conbinación óptima de puntos especifícos dentro del intervalo de integración. A diferencia de métodos tradicionales que usan divisiones estratégicamente nodos para maximizar la precisión con pocas evaluzaciones. | [☕ MD](./Tema%204/Metodocuadraturagauss.md) |

---

### 🔹 Tema 5: Solución de Ecuaciones Diferenciales
Mientras que la interpolación estima valores *dentro* del rango de datos conocidos, la extrapolación pronostica valores *fuera* de ese rango. La extrapolación lineal asume que la tendencia local (generalmente de los dos últimos puntos conocidos) continuará constante hacia el futuro o el pasado. Y para el apartado de la regresión se utiliza cuando los datos tienen ruido, errores de medición o dispersión. El objetivo no es tocar cada punto, sino encontrar una tendencia global única (una línea recta) que minimice la distancia promedio a todos ellos.

| Método | Descripción del Sistema | Enlace |
| :--- | :--- | :---: |
| **Interpolación Segmentada** | Se utiliza polinomios de bajo grado en cada subintervalo, garantizando una curva suave, precisa y libre de oscilaciones. | [☕ MD](./Tema%205/interpolacionsegmentada.md) |
| **Extrapolación Lineal** | Asume que la tendencia local (generalmente de los dos últimos puntos conocidos) continuará constante hacia el futuro o el pasado. | [☕ MD](./Tema%205/extrapolacionlineal.md) |
| **Extrapolación Polinomica** | Utiliza un polinomio de grado $n$ construido a partir de múltiples puntos. Esto le permite capturar curvas, aceleraciones y tendencias no lineales. | [☕ MD](./Tema%205/extrapolacionpolinomica.md) |
| **Extrapolación de Richardson** | Se utiliza para mejorar drásticamente la precisión de un algoritmo numérico (como derivadas o integrales) eliminando sistemáticamente los términos de error de menor orden sin necesidad de reducir el tamaño | [☕ MD](./Tema%205/extrapolacionrichardson.md) |
| **Regresión Lineal** | Se utiliza cuando los datos tienen ruido, errores de medición o dispersión. El objetivo no es tocar cada punto, sino encontrar una tendencia global única (una línea recta). | [☕ MD](./Tema%205/regresión.md) |

---

### 🔹 Tema 6: Extrapolación, interpolación y Regresión
Mientras que la interpolación estima valores *dentro* del rango de datos conocidos, la extrapolación pronostica valores *fuera* de ese rango. La extrapolación lineal asume que la tendencia local (generalmente de los dos últimos puntos conocidos) continuará constante hacia el futuro o el pasado. Y para el apartado de la regresión se utiliza cuando los datos tienen ruido, errores de medición o dispersión. El objetivo no es tocar cada punto, sino encontrar una tendencia global única (una línea recta) que minimice la distancia promedio a todos ellos.

| Método | Descripción del Sistema | Enlace |
| :--- | :--- | :---: |
| **Método de Euler** | Es un procedimiento numérico que avanza paso a paso en una rejilla discreta de puntos. Utiliza la pendiente al inicio de cada intervalo como una aproximación constante para proyectar el valor del siguiente punto | [☕ MD](./Tema%206/metodoeuler.md) |
| **Runge-Kutta de Cuarto Orden (RK4)** | Realiza cuatro evaluaciones de pendiente distribuidas estratégicamente a lo largo de un solo paso: una al inicio, dos en puntos medios proyectados y una al final. Al promediar estas pendientes mediante una ponderación específica. | [☕ MD](./Tema%206/rungekutta.md) |
| **Adams-Bashforth de 4 Pasos** | Es un método multipaso explícito. Este algoritmo almacena y reutiliza las evaluaciones funcionales de los puntos inmediatamente anteriores para proyectar el paso futuro con una sola evaluación nueva. | [☕ MD](./Tema%206/adamsbashforth.md) |
| **Sistemas de Ecuaciones Diferenciales Ordinarias (EDO** | Operan en espacios vectoriales multidimensionales. Esto les permite modelar ecuaciones acopladas independientes simultáneamente y transformar cualquier ecuación diferencial ordinaria de orden superior. | [☕ MD](./Tema%206/edo.md) |
| **Video Animacion Euler Visualgo** | Es un video sobre el metodo de Euler. | [📹 VIDEO](https://github.com/user-attachments/assets/943c0ac9-5134-4086-bdb8-dea9fb5be478) |

---
https://github.com/user-attachments/assets/f3308e4e-3490-4914-942c-3b1a0548e455


## 🛠️ Tecnologías y Requisitos

* **Lenguaje:** Java 17 o superior.
* **Paradigma:** Programación Estructurada y Orientada a Objetos.


* **Conceptos clave:** Estándar IEEE 754, Convergencia, Tolerancia ($\epsilon$).

## 🚀 Cómo utilizar este repositorio

1. **Clonar el repositorio:**
   ```bash
   git clone [https://github.com/tu-usuario/nombre-de-tu-repo.git](https://github.com/tu-usuario/nombre-de-tu-repo.git)
