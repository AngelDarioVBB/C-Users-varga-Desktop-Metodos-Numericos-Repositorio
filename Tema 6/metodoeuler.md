# Tema 6: Solución de Ecuaciones Diferenciales
## Subtema: Método de Euler

> **Estatus:** Documentación Técnica
> **Diferencia Clave:** A diferencia de los métodos analíticos tradicionales (que buscan una función matemática exacta como solución), el método de Euler es un procedimiento numérico que avanza paso a paso en una rejilla discreta de puntos. Utiliza la pendiente al inicio de cada intervalo como una aproximación constante para proyectar el valor del siguiente punto, aceptando un error de truncamiento local inherente a cambio de resolver ecuaciones que analíticamente serían imposibles.

---

### 1. Objetivo
El objetivo del **Método de Euler** es aproximar la solución de un Problema de Valor Inicial (PVI) de primer orden de la forma $y' = f(t, y)$ con $y(t_0) = y_0$, dentro de un intervalo cerrado $[t_0, t_f]$. Busca construir una secuencia de puntos $(t_n, y_n)$ espaciados por un tamaño de paso constante $h$, donde cada valor aproximado se calcula mediante la relación lineal:

$$y_{n+1} = y_n + h \cdot f(t_n, y_n)$$

---

### 2. Descripción del Método
El método se fundamenta en la interpretación geométrica de la derivada y en la serie de Taylor truncada después del término de primer orden. Si conocemos el estado actual $(t_n, y_n)$, la pendiente de la curva solución en ese punto exacto viene dada por la función de la ecuación diferencial, es decir, $m = f(t_n, y_n)$. 

Suponiendo que dicha pendiente se mantiene constante a lo largo de un pequeño incremento de tiempo $h$ (donde $t_{n+1} = t_n + h$), podemos trazar una línea recta para estimar el nuevo valor de la variable dependiente:

$$y(t_n + h) \approx y(t_n) + h \cdot y'(t_n)$$

Este método posee un orden de error global de $\mathcal{O}(h)$, lo que significa que es un método de primer orden. Si reducimos el tamaño de paso $h$ a la mitad, el error global aproximado se reducirá proporcionalmente a la mitad. Su principal limitación radica en la rápida acumulación del error de truncamiento local, volviéndose inestable si el paso $h$ no es críticamente pequeño.

---

### 3. Pseudocódigo
```text
INICIO Euler(f, t0, y0, tf, h)
    t = t0
    y = y0
    
    MIENTRAS t < tf:
        // Evaluar la pendiente actual
        pendiente = f(t, y)
        
        // Calcular el siguiente punto
        y = y + h * pendiente
        t = t + h
        
        MOSTRAR t, y
    FIN MIENTRAS
    
    RETURN t, y
FIN
```

---

### 4. Código
```text
public class EulerPrincipal {

    // Ejemplo de EDO: y' = t - 2y
    public static double f(double t, double y) {
        return t - (2 * y);
    }

    public static void main(String[] args) {
        // Condiciones Iniciales del PVI
        double t0 = 0.0;
        double y0 = 1.0;
        double tf = 2.0;
        double h = 0.1; // Tamaño de paso

        System.out.println("=== Solución de EDO: Método de Euler ===");
        System.out.printf("Punto Inicial: (t0=%.2f, y0=%.2f)%n", t0, y0);
        System.out.printf("Tamaño de paso h = %.4f%n%n", h);

        double t = t0;
        double y = y0;
        int pasos = (int) Math.ceil((tf - t0) / h);

        for (int i = 0; i < pasos; i++) {
            double pendiente = f(t, y);
            y = y + h * pendiente;
            t = t + h;

            System.out.printf("Paso %2d -> t: %.2f | y aproximada: %.6f%n", (i + 1), t, y);
        }
        
        System.out.printf("%nSolución final estimada en t = %.2f es y = %.6f%n", t, y);
    }
}
```

Para poder visualizar y correr el ejemplo implementado en Java es el apartado siguiente: [☕ CodigoEjemplo1](codigosmetodoeuler/EulerPrincipal.java)

A continuación van los siguientes codigos:
[☕ CodigoEjemplo2](codigosmetodoeuler/ExtrapolacionRichardson2.java)
[☕ CodigoEjemplo3](codigosmetodoeuler/ExtrapolacionRichardson3.java)
[☕ CodigoEjemplo4](codigosmetodoeuler/ExtrapolacionRichardson4.java)
[☕ CodigoEjemplo5](codigosmetodoeuler/ExtrapolacionRichardson5.java)

---

### 📑 5. Conclusion
El método de Euler representa el cimiento fundamental de la integración numérica de ecuaciones diferenciales ordinarias. Aunque su simplicidad algebraica lo vuelve ideal para la introducción didáctica de los conceptos de discretización y error de truncamiento, su baja precisión teórica y susceptibilidad a la inestabilidad numérica restringen drásticamente su uso en entornos de simulación de producción o ingeniería avanzada.
