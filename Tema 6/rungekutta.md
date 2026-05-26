# Tema 6: Solución de Ecuaciones Diferenciales
## Subtema: Método de Runge-Kutta de Cuarto Orden (RK4)

> **Estatus:** Documentación Técnica
> **Diferencia Clave:** A diferencia del método de Euler (que utiliza únicamente la pendiente al inicio del intervalo, provocando desviaciones drásticas), el método RK4 realiza cuatro evaluaciones de pendiente distribuidas estratégicamente a lo largo de un solo paso: una al inicio, dos en puntos medios proyectados y una al final. Al promediar estas pendientes mediante una ponderación específica, logra un ajuste de curvatura de alta precisión sin requerir derivadas analíticas de orden superior.

---

### 1. Objetivo
El objetivo del método **Runge-Kutta de Orden 4 (RK4)** es resolver numéricamente un Problema de Valor Inicial (PVI) definido por $y' = f(t, y)$ con la condición inicial $y(t_0) = y_0$, dentro de un intervalo cerrado $[t_0, t_f]$. Busca minimizar drásticamente el error de truncamiento acumulado por paso mediante un promedio ponderado de pendientes, alcanzando un orden de convergencia de cuarto orden.

---

### 2. Descripción del Método
El algoritmo simula el comportamiento de una serie de Taylor de hasta cuarto orden mediante la combinación lineal de cuatro incrementos intermedios ($k_1, k_2, k_3, k_4$) calculados secuencialmente dentro del paso actual $h$:

$$k_1 = h \cdot f(t_n, y_n)$$

$$k_2 = h \cdot f\left(t_n + \frac{h}{2}, y_n + \frac{k_1}{2}\right)$$

$$k_3 = h \cdot f\left(t_n + \frac{h}{2}, y_n + \frac{k_2}{2}\right)$$

$$k_4 = h \cdot f(t_n + h, y_n + k_3)$$

Una vez obtenidas las pendientes, se calcula el siguiente estado aplicando un promedio ponderado que otorga mayor peso a los puntos medios debido a su estimación central de la curvatura:

$$y_{n+1} = y_n + \frac{1}{6}(k_1 + 2k_2 + 2k_3 + k_4)$$

Este método posee un orden de error global de $\mathcal{O}(h^4)$. Su gran ventaja es que si el tamaño de paso $h$ se reduce a la mitad, el error numérico global se reduce aproximadamente 16 veces ($2^4$), lo que le confiere una estabilidad y precisión formidables para propósitos generales de ingeniería.

---

### 3. Pseudocódigo
```text
INICIO RungeKutta4(f, t0, y0, tf, h)
    t = t0
    y = y0
    
    MIENTRAS t < tf:
        k1 = h * f(t, y)
        k2 = h * f(t + h/2, y + k1/2)
        k3 = h * f(t + h/2, y + k2/2)
        k4 = h * f(t + h, y + k3)
        
        y = y + (k1 + 2*k2 + 2*k3 + k4) / 6
        t = t + h
        
        MOSTRAR t, y
    FIN MIENTRAS
    
    RETURN t, y
FIN
```


---

### 4. Código
```text
public class RungeKutta4Principal {

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

        System.out.println("=== Solución de EDO: Método Runge-Kutta 4 (RK4) ===");
        System.out.printf("Punto Inicial: (t0=%.2f, y0=%.2f)%n", t0, y0);
        System.out.printf("Tamaño de paso h = %.4f%n%n", h);
        
        double t = t0;
        double y = y0;
        int pasos = (int) Math.ceil((tf - t0) / h);

        for (int i = 0; i < pasos; i++) {
            double k1 = h * f(t, y);
            double k2 = h * f(t + h / 2.0, y + k1 / 2.0);
            double k3 = h * f(t + h / 2.0, y + k2 / 2.0);
            double k4 = h * f(t + h, y + k3);

            // Avance síncrono aplicando la ponderación clásica
            y = y + (k1 + 2.0 * k2 + 2.0 * k3 + k4) / 6.0;
            t = t + h;

            System.out.printf("Paso %2d -> t: %.2f | y aproximada: %.6f%n", (i + 1), t, y);
        }
        
        System.out.printf("%nSolución final estimada en t = %.2f es y = %.6f%n", t, y);
    }
}
```

Para poder visualizar y correr el ejemplo implementado en Java es el apartado siguiente: [☕ CodigoEjemplo1](codigosrungekuta/RungeKutta4Principal.java)

A continuación van los siguientes codigos:
[☕ CodigoEjemplo2](codigosmetodoeuler/ExtrapolacionRichardson2.java)
[☕ CodigoEjemplo3](codigosmetodoeuler/ExtrapolacionRichardson3.java)
[☕ CodigoEjemplo4](codigosmetodoeuler/ExtrapolacionRichardson4.java)
[☕ CodigoEjemplo5](codigosmetodoeuler/ExtrapolacionRichardson5.java)

---


### 📑 5. Conclusion
El método Runge-Kutta de cuarto orden es el estándar clásico industrial por excelencia para resolver problemas de valor inicial. Ofrece un balance extraordinario entre la complejidad matemática de su implementación y la precisión de sus resultados. Salvo en escenarios muy específicos con ecuaciones rígidas (stiff equations), RK4 representa la opción por defecto más robusta y confiable para cualquier simulación numérica de variables dinámicas.