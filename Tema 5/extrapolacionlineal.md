# Tema 5: Métodos de Extrapolación
## Subtema: Extrapolación Lineal

> **Estatus:** Documentación Técnica
> **Diferencia Clave:** Mientras que la interpolación estima valores *dentro* del rango de datos conocidos, la extrapolación pronostica valores *fuera* de ese rango. La extrapolación lineal asume que la tendencia local (generalmente de los dos últimos puntos conocidos) continuará constante hacia el futuro o el pasado.

---

### 1. Objetivo
El objetivo de la **Extrapolación Lineal** es predecir el valor de una función para un punto $x$ que se encuentra fuera del intervalo de los datos históricos o experimentales $[x_0, x_n]$. Se utiliza ampliamente para proyecciones a corto plazo, pronósticos financieros, estimaciones de población o prolongación de tendencias físicas simples.

---

### 2. Descripción del Método

La extrapolación lineal utiliza la ecuación de la recta secante que pasa por dos puntos de datos adyacentes (usualmente los extremos del conjunto de datos) para extender esa línea más allá de los datos medidos. 

**Riesgo matemático:** A medida que el punto a estimar se aleja del último dato conocido, el error potencial crece significativamente, ya que asume que el comportamiento del sistema no cambiará.

**Fórmula de la Extrapolación Lineal:**
Dada una pareja de puntos $(x_{n-1}, y_{n-1})$ y $(x_n, y_n)$ ubicados al final del conjunto de datos, el valor extrapolado para un punto $x$ (donde $x > x_n$) se calcula como:

$$
y = y_n + \frac{y_n - y_{n-1}}{x_n - x_{n-1}} (x - x_n)
$$

*Nota: La ecuación es matemáticamente idéntica a la interpolación lineal; la diferencia radica en que $x$ está fuera del dominio de los puntos proporcionados.*

---

### 3. Pseudocódigo
```text
INICIO ExtrapolacionLineal(x_conocidos, y_conocidos, x_evaluar)
  n = longitud(x_conocidos)
  
  // Identificar si la extrapolación es hacia atrás o hacia adelante
  SI x_evaluar < x_conocidos[0] ENTONCES
    // Usar los dos primeros puntos (Hacia atrás)
    x1 = x_conocidos[0]
    y1 = y_conocidos[0]
    x2 = x_conocidos[1]
    y2 = y_conocidos[1]
  SINO SI x_evaluar > x_conocidos[n-1] ENTONCES
    // Usar los dos últimos puntos (Hacia adelante)
    x1 = x_conocidos[n-2]
    y1 = y_conocidos[n-2]
    x2 = x_conocidos[n-1]
    y2 = y_conocidos[n-1]
  FIN SI
  
  // Calcular pendiente
  m = (y2 - y1) / (x2 - x1)
  
  // Calcular valor extrapolado
  resultado = y2 + m * (x_evaluar - x2)
  RETURN resultado
FIN
```
### 4. Código

```text
public class ExtrapolacionLinealPrincipal {

    public static void main(String[] args) {
        // Datos históricos de población (Años y Millones de habitantes)
        double[] anios = {2018, 2019, 2020, 2021, 2022};
        double[] poblacion = {100.5, 102.1, 103.8, 105.4, 107.0}; 

        double anioProyeccion = 2025; // Fuera del rango

        System.out.println("=== Proyección por Extrapolación Lineal ===");
        try {
            double poblacionEstimada = extrapolar(anios, poblacion, anioProyeccion);
            System.out.printf("Población proyectada para el año %.0f: %.2f millones%n", 
                              anioProyeccion, poblacionEstimada);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static double extrapolar(double[] x, double[] y, double xEval) {
        int n = x.length;
        if (n < 2) throw new IllegalArgumentException("Se requieren al menos 2 puntos.");

        // Solo usar los dos últimos puntos asumiendo tendencia reciente
        double x1 = x[n - 2], y1 = y[n - 2];
        double x2 = x[n - 1], y2 = y[n - 1];

        double pendiente = (y2 - y1) / (x2 - x1);
        return y2 + pendiente * (xEval - x2);
    }
}
```

Para poder visualizar y correr el ejemplo implementado en Java es el apartado siguiente: [☕ CodigoEjemplo1](codigosextrapolacionlineal/ExtrapolacionLinealPrincipal.java)

A continuación van los siguientes codigos:
[☕ CodigoEjemplo2](codigosextrapolacionlineal/InterpolacionSegment2.java)
[☕ CodigoEjemplo3](codigosextrapolacionlineal/InterpolacionSegment3.java)
[☕ CodigoEjemplo4](codigosextrapolacionlineal/InterpolacionSegment4.java)
[☕ CodigoEjemplo5](codigosextrapolacionlineal/InterpolacionSegment5.java)


### 📑 5. Conclusion

La extrapolación lineal es una técnica rápida y computacionalmente muy económica para realizar proyecciones inmediatas. Sin embargo, debe usarse con extrema precaución, ya que asume que no habrá cambios en la dinámica del sistema. Su grado de confiabilidad disminuye drásticamente a medida que el punto a estimar se aleja del conjunto de datos medidos.
