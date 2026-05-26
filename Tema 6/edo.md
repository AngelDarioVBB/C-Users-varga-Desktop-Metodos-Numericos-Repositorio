# Tema 6: Solución de Ecuaciones Diferenciales
## Subtema: Sistemas de Ecuaciones Diferenciales Ordinarias (EDO)

> **Estatus:** Documentación Técnica
> **Diferencia Clave:** A diferencia de los solucionadores escalares (que procesan únicamente una variable aislada en una dimensión), los solucionadores de sistemas EDO operan en espacios vectoriales multidimensionales. Esto les permite modelar ecuaciones acopladas independientes simultáneamente y transformar cualquier ecuación diferencial ordinaria de orden superior ($n \ge 2$) en un sistema equivalente de primer orden mediante la introducción de variables de estado.

---

### 1. Objetivo
El objetivo de la resolución de **Sistemas EDO** es aplicar algoritmos de un paso (como RK4) de forma vectorial a un conjunto de ecuaciones diferenciales que dependen mutuamente entre sí. Esto permite simular sistemas físicos complejos, tales como dinámicas acopladas o ecuaciones de movimiento de orden superior estructuradas bajo la forma matricial:

$$\mathbf{Y}' = \mathbf{F}(t, \mathbf{Y}), \quad \mathbf{Y}(t_0) = \mathbf{Y}_0$$

---

### 2. Descripción del Método
Cualquier ecuación de orden superior se puede reducir a un sistema de primer orden. Por ejemplo, en el modelado de un péndulo simple con gravedad $g$ y longitud de cuerda $L$:

$$\theta'' + \frac{g}{L}\sin\theta = 0$$

Se definen dos variables de estado acopladas: $y_1 = \theta$ (posición angular) y $y_2 = \theta'$ (velocidad angular). Al derivarlas, el sistema se reformula como dos ecuaciones de primer orden:

$$\begin{cases} y_1' = y_2 \\ y_2' = -\dfrac{g}{L}\sin(y_1) \end{cases}$$

Para resolverlo, el método Runge-Kutta de cuarto orden (RK4) se procesa de forma idéntica pero sustituyendo sus variables y funciones por vectores columna ($\mathbf{Y}$ y $\mathbf{K}$). De esta manera, cada etapa intermedia de pendiente evalúa simultáneamente las variaciones cruzadas de todas las variables dinámicas involucradas antes de consolidar el salto definitivo en el tiempo.

---

### 3. Pseudocódigo
```text
INICIO RK4_Sistema(F_vectorial, t0, Y0[], tf, h)
    t = t0
    Y = CopiarArreglo(Y0) // Vector de estado inicial [y1, y2, ..., ym]
    m = longitud(Y)
    
    MIENTRAS t < tf:
        // Cada K es un vector de tamaño m
        K1 = F_vectorial(t, Y)
        K2 = F_vectorial(t + h/2, Y + K1 * h/2)
        K3 = F_vectorial(t + h/2, Y + K2 * h/2)
        K4 = F_vectorial(t + h, Y + K3 * h)
        
        // Actualización síncrona de todo el vector de estado
        PARA j = 0 HASTA m-1:
            Y[j] = Y[j] + (h / 6.0) * (K1[j] + 2*K2[j] + 2*K3[j] + K4[j])
        FIN PARA
        
        t = t + h
        MOSTRAR t, Y
    FIN MIENTRAS
    
    RETURN t, Y
FIN
```

---

### 4. Código
```text
public class SistemaEDOPrincipal {

    // Sistema del Péndulo Simple: Y[0] = theta (posición), Y[1] = omega (velocidad)
    public static double[] F(double t, double[] Y) {
        double g = 9.81;
        double L = 1.0;
        
        double[] dY = new double[2];
        dY[0] = Y[1];                         // y1' = y2
        dY[1] = -(g / L) * Math.sin(Y[0]);    // y2' = -(g/L)*sin(y1)
        return dY;
    }

    public static void main(String[] args) {
        double t0 = 0.0;
        double tf = 1.0;
        double h = 0.1;

        // Condiciones iniciales: theta = 45 grados (en radianes), velocidad = 0
        double[] Y = { Math.toRadians(45.0), 0.0 };

        System.out.println("=== Solución de Sistemas EDO: RK4 Vectorial ===");
        System.out.printf("Estado Inicial -> t: %.1f | Posicion: %.4f rad | Velocidad: %.4f rad/s%n%n", t0, Y[0], Y[1]);

        double t = t0;
        int pasos = (int) Math.ceil((tf - t0) / h);

        for (int i = 0; i < pasos; i++) {
            int m = Y.length;
            
            double[] k1 = F(t, Y);
            
            // Vectores auxiliares para las evaluaciones intermedias vectoriales
            double[] aux2 = new double[m];
            for(int j=0; j<m; j++) aux2[j] = Y[j] + k1[j] * h / 2.0;
            double[] k2 = F(t + h / 2.0, aux2);
            
            double[] aux3 = new double[m];
            for(int j=0; j<m; j++) aux3[j] = Y[j] + k2[j] * h / 2.0;
            double[] k3 = F(t + h / 2.0, aux3);
            
            double[] aux4 = new double[m];
            for(int j=0; j<m; j++) aux4[j] = Y[j] + k3[j] * h;
            double[] k4 = F(t + h, aux4);

            // Actualización simultánea del vector de estado
            for (int j = 0; j < m; j++) {
                Y[j] = Y[j] + (h / 6.0) * (k1[j] + 2.0 * k2[j] + 2.0 * k3[j] + k4[j]);
            }
            t = t + h;

            System.out.printf("Paso %2d -> t: %.1f | Posicion: %.5f | Velocidad: %.5f%n", (i + 1), t, Y[0], Y[1]);
        }
    }
}
```

Para poder visualizar y correr el ejemplo implementado en Java es el apartado siguiente: [☕ CodigoEjemplo1](codigosadamsbashfort/SistemaEDOPrincipal.java)

A continuación van los siguientes codigos:
[☕ CodigoEjemplo2](codigosadamsbashfort/ExtrapolacionRichardson2.java)
[☕ CodigoEjemplo3](codigosadamsbashfort/ExtrapolacionRichardson3.java)
[☕ CodigoEjemplo4](codigosadamsbashfort/ExtrapolacionRichardson4.java)
[☕ CodigoEjemplo5](codigosadamsbashfort/ExtrapolacionRichardson5.java)

---


### 📑 5. Conclusion
La resolución vectorial de sistemas EDO es una de las herramientas de simulación más potentes dentro del cálculo numérico. Permite a los programadores e ingenieros modelar escenarios físicos reales (como sistemas de suspensión automotriz, órbitas aeroespaciales o circuitos electrónicos) sin importar cuán complejas sean las relaciones de acoplamiento, explotando la estabilidad lineal del núcleo numérico de RK4 de forma uniforme.