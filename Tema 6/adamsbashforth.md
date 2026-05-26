# Tema 6: Solución de Ecuaciones Diferenciales
## Subtema: Método de Adams-Bashforth de 4 Pasos

> **Estatus:** Documentación Técnica
> **Diferencia Clave:** A diferencia de los métodos de un paso (como RK4, que descartan toda la información previa y recalculan la función $f$ múltiples veces en cada nuevo intervalo), el método de Adams-Bashforth es un método multipaso explícito. Este algoritmo almacena y reutiliza las evaluaciones funcionales de los puntos inmediatamente anteriores para proyectar el paso futuro con una sola evaluación nueva, optimizando drásticamente el costo computacional.

---

### 1. Objetivo
El objetivo del método de **Adams-Bashforth de 4 Pasos** es resolver de manera eficiente un Problema de Valor Inicial (PVI) $y' = f(t, y)$ calculando el valor de $y_{n+1}$ mediante una extrapolación polinomial que utiliza la información histórica de la derivada evaluada en los cuatro instantes previos de la solución ($t_n, t_{n-1}, t_{n-2}, t_{n-3}$).

---

### 2. Descripción del Método
Dado que el método requiere conocer los cuatro puntos inmediatamente anteriores para poder calcular el siguiente paso, presenta un problema de arranque: de manera nativa no puede calcular $y_1, y_2,$ ni $y_3$. Por contrato algorítmico, se debe ejecutar un método de un paso de igual precisión (típicamente **RK4**) para generar el historial inicial de puntos. 

Una vez que se dispone del arranque, la fórmula de recurrencia de Adams-Bashforth de 4 pasos es:

$$y_{n+1} = y_n + \frac{h}{24} \left[ 55f(t_n, y_n) - 59f(t_{n-1}, y_{n-1}) + 37f(t_{n-2}, y_{n-2}) - 9f(t_{n-3}, y_{n-3}) \right]$$

El orden de error global de este método es $\mathcal{O}(h^4)$, igualando la precisión de RK4. Su ventaja crítica es el rendimiento: solo requiere evaluar la función $f(t,y)$ **una sola vez por paso**, en contraste con las cuatro evaluaciones requeridas por RK4, haciéndolo ideal para sistemas donde la función diferencial es computacionalmente costosa de evaluar. Sin embargo, requiere un tamaño de paso estricto y fijo.

---

### 3. Pseudocódigo
```text
INICIO AdamsBashforth4(f, t[], y[], tf, h)
    // t[] e y[] ya vienen inicializados con los índices 0, 1, 2, 3 mediante RK4
    n = 3
    t_actual = t[3]
    
    MIENTRAS t_actual < tf:
        f_n   = f(t[n],   y[n])
        f_n1  = f(t[n-1], y[n-1])
        f_n2  = f(t[n-2], y[n-2])
        f_n3  = f(t[n-3], y[n-3])
        
        y_siguiente = y[n] + (h / 24.0) * (55*f_n - 59*f_n1 + 37*f_n2 - 9*f_n3)
        t_siguiente = t_actual + h
        
        // Almacenar los nuevos puntos en el historial
        t[n+1] = t_siguiente
        y[n+1] = y_siguiente
        
        t_actual = t_siguiente
        n = n + 1
    FIN MIENTRAS
    
    RETURN t_actual, y[n]
FIN
```

---

### 4. Código
```text
public class AdamsBashforthPrincipal {

    // Ejemplo de EDO: y' = t - 2y
    public static double f(double t, double y) {
        return t - (2 * y); 
    }

    // Rutina auxiliar de RK4 para generar las 3 iteraciones de arranque inicial
    public static double rk4Paso(double t, double y, double h) {
        double k1 = h * f(t, y);
        double k2 = h * f(t + h / 2.0, y + k1 / 2.0);
        double k3 = h * f(t + h / 2.0, y + k2 / 2.0);
        double k4 = h * f(t + h, y + k3);
        return y + (k1 + 2.0 * k2 + 2.0 * k3 + k4) / 6.0;
    }

    public static void main(String[] args) {
        // Condiciones Iniciales del PVI
        double t0 = 0.0;
        double y0 = 1.0;
        double tf = 2.0;
        double h = 0.1; // Tamaño de paso

        System.out.println("=== Solución de EDO: Adams-Bashforth de 4 Pasos ===");

        int totalPasos = (int) Math.ceil((tf - t0) / h);
        double[] t = new double[totalPasos + 1];
        double[] y = new double[totalPasos + 1];

        // 1. Fase de Arranque Obligatoria con RK4
        t[0] = t0;
        y[0] = y0;
        System.out.printf("Arranque [P0] -> t: %.2f | y: %.6f%n", t[0], y[0]);
        
        for (int i = 0; i < 3; i++) {
            y[i + 1] = rk4Paso(t[i], y[i], h);
            t[i + 1] = t[i] + h;
            System.out.printf("Arranque [P%d] -> t: %.2f | y: %.6f (Calculado via RK4)%n", (i + 1), t[i + 1], y[i + 1]);
        }

        // 2. Fase Principal Multipaso (Adams-Bashforth)
        for (int n = 3; n < totalPasos; n++) {
            double fn   = f(t[n], y[n]);
            double fn_1 = f(t[n - 1], y[n - 1]);
            double fn_2 = f(t[n - 2], y[n - 2]);
            double fn_3 = f(t[n - 3], y[n - 3]);

            // Aplicación de la fórmula explícita
            y[n + 1] = y[n] + (h / 24.0) * (55.0 * fn - 59.0 * fn_1 + 37.0 * fn_2 - 9.0 * fn_3);
            t[n + 1] = t[n] + h;

            System.out.printf("Principal [P%d] -> t: %.2f | y: %.6f (Calculado via Multipaso)%n", (n + 1), t[n + 1], y[n + 1]);
        }
    }
}
```

Para poder visualizar y correr el ejemplo implementado en Java es el apartado siguiente: [☕ CodigoEjemplo1](codigosadamsbashfort/AdamsBashforthPrincipal.java)

A continuación van los siguientes codigos:
[☕ CodigoEjemplo2](codigosadamsbashfort/ExtrapolacionRichardson2.java)
[☕ CodigoEjemplo3](codigosadamsbashfort/ExtrapolacionRichardson3.java)
[☕ CodigoEjemplo4](codigosadamsbashfort/ExtrapolacionRichardson4.java)
[☕ CodigoEjemplo5](codigosadamsbashfort/ExtrapolacionRichardson5.java)

---


### 📑 5. Conclusion
El método multipaso de Adams-Bashforth demuestra que la memoria histórica de cálculo es un recurso valioso en la matemática numérica. Al preservar las evaluaciones de pasos previos, reduce drásticamente las operaciones en la CPU manteniendo una precisión sobresaliente de cuarto orden. Su sensibilidad a la inestabilidad en problemas dinámicos con variaciones abruptas de paso limita su uso en mallas adaptativas, pero sigue siendo óptimo para la resolución de órbitas y trayectorias continuas masivas.