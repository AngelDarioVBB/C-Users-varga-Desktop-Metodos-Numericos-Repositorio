# 📂 Repositorio de Métodos Numéricos

Bienvenido a mi espacio de estudio sobre **Métodos Numéricos**. Aquí documento mis ejercicios, códigos en Java y material teórico enfocado en la precisión computacional y el manejo de errores.

---

## 📘 Tema 1: Introducción a los Errores en Programación
En este módulo exploramos cómo la computadora representa los números y las consecuencias de las limitaciones de memoria y precisión.

### 📄 Documentación y Teoría
* [Tipos de errores.pdf](./Tema1/Tipos%20de%20errores.pdf) — Conceptos fundamentales.
* [Errores de programación - Act. Clase.pdf](./Tema1/Errores%20de%20programaciónAct_Clase.pdf) — Notas tomadas durante la sesión.

### 💻 Ejemplos de Código (Java)
Aquí se demuestran los errores más comunes al trabajar con punto flotante y tipos de datos:

| Archivo | Descripción |
| :--- | :--- |
| `Error de Redondeo Binario.java` | Demostración de la imprecisión en la base 2. |
| `Cancelación por Resta.java` | Pérdida de dígitos significativos al restar números cercanos. |
| `Pérdida de Precisión por Magnitud.java` | Sumar números de escalas muy diferentes. |
| `Acumulación de Errores en Bucles.java` | Cómo el error crece en procesos iterativos. |
| `Comparación Directa con ==.java` | Por qué nunca debes usar `==` con `double` o `float`. |
| `Conversión Estrecha.java` | Riesgos de pasar de un tipo de dato grande a uno pequeño. |
| `Desbordamiento Silencioso.java` | Qué pasa cuando superamos el límite del tipo de dato. |

### 📝 Actividades y Problemarios
* [Ejercicios en clase.pdf](./Tema1/Ejercicios%20en%20clase.pdf)
* [T1-E2: Problemario MN EJ26](./Tema1/T1%20----E2%20----%20Proble Mario-%20MN%20EJ26.pdf)

---

## 🛠️ Herramientas utilizadas
* **Lenguaje:** Java ☕
* **Conceptos clave:** Aritmética de punto flotante, Épsilon de la máquina, Errores de truncamiento y redondeo.

---
> "En computación, 0.1 + 0.2 no siempre es 0.3."
