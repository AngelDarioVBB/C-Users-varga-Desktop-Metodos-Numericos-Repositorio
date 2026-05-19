# Tema 5: Ajuste de Curvas
## Subtema: Regresión Lineal

> **Estatus:** Documentación Técnica
> **Diferencia Clave:** A diferencia de la interpolación (donde la curva debe pasar obligatoriamente por *todos* los puntos), la regresión se utiliza cuando los datos tienen ruido, errores de medición o dispersión. El objetivo no es tocar cada punto, sino encontrar una tendencia global única (una línea recta) que minimice la distancia promedio a todos ellos.

---

### 1. Objetivo
El objetivo de la **Regresión Lineal** es encontrar los parámetros de la línea recta $y = mx + b$ (donde $m$ es la pendiente y $b$ la intersección) que mejor se adapte a un conjunto de pares ordenados $(x_1, y_1), (x_2, y_2), \dots, (x_n, y_n)$, minimizando la suma de los cuadrados de los residuos (errores verticales).

---

### 2. Descripción del Método
Para encontrar la "recta perfecta", definimos el error o residuo de cada punto como la diferencia entre el valor real $y_i$ y el valor predicho por la recta $(mx_i + b)$. El método de **Mínimos Cuadrados** busca minimizar la suma de estos errores al cuadrado:

$$
E(m, b) = \sum_{i=1}^{n} (y_i - (mx_i + b))^2
$$

Al aplicar derivadas parciales respecto a $m$ y $b$ e igualarlas a cero, obtenemos un sistema de ecuaciones lineales conocido como *Ecuaciones Normales*. Al resolverlo, las fórmulas directas para los coeficientes son:

$$
m = \frac{n\sum(x_i y_i) - \sum x_i \sum y_i}{n\sum(x_i^2) - (\sum x_i)^2}
$$

$$
b = \frac{\sum y_i - m\sum x_i}{n} = \bar{y} - m\bar{x}
$$

Donde $n$ es el número total de puntos, $\bar{x}$ es el promedio de $x$, y $\bar{y}$ es el promedio de $y$.

---

### 3. Pseudocódigo
```text
INICIO RegresionLineal(X, Y)
  n = longitud(X)
  sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0
  
  PARA i = 0 HASTA n-1:
    sumX   = sumX + X[i]
    sumY   = sumY + Y[i]
    sumXY  = sumXY + X[i] * Y[i]
    sumX2  = sumX2 + X[i] * X[i]
  FIN PARA
  
  // Calcular pendiente (m) e intersección (b)
  denominador = n * sumX2 - (sumX * sumX)
  
  SI denominador == 0 ENTONCES
    ERROR "No se puede calcular la regresión (todos los puntos X son iguales)"
  FIN SI
  
  m = (n * sumXY - sumX * sumY) / denominador
  b = (sumY - m * sumX) / n
  
  RETURN m, b
FIN
```

---

### 4. Código
```text
public class RegresionLinealPrincipal {

    public static void main(String[] args) {
        // Ejemplo: Horas de estudio (X) vs Calificación obtenida (Y)
        double[] horas = {1.0, 2.0, 3.0, 4.0, 5.0};
        double[] calificaciones = {5.5, 6.2, 7.8, 8.3, 9.5};

        System.out.println("=== Ajuste de Curvas: Regresión Lineal ===");
        
        int n = horas.length;
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;

        for (int i = 0; i < n; i++) {
            sumX += horas[i];
            sumY += calificaciones[i];
            sumXY += horas[i] * calificaciones[i];
            sumX2 += horas[i] * horas[i];
        }

        double denominador = (n * sumX2) - (sumX * sumX);
        
        if (Math.abs(denominador) < 1e-9) {
            System.out.println("Error: No hay variación en el eje X.");
            return;
        }

        // Cálculo de coeficientes
        double m = (n * sumXY - sumX * sumY) / denominador;
        double b = (sumY - m * sumX) / n;

        System.out.printf("Ecuación de la recta óptima: Y = %.4f * X + %.4f%n", m, b);
        
        // Predicción
        double horasExtra = 6.0;
        double prediccion = (m * horasExtra) + b;
        System.out.printf("Predicción para %.1f horas de estudio: Calificación de %.2f%n", horasExtra, prediccion);
    }
}
```
---

### 📑 5. Conclusion
La regresión lineal por mínimos cuadrados es la herramienta predictiva fundamental de la estadística y la analítica de datos. Acepta de forma natural el error experimental y busca simplificar el entendimiento de un fenómeno mediante una tendencia lineal. Es un método sumamente estable, rápido de calcular y con una interpretación física directa (la pendiente indica la tasa de cambio).
