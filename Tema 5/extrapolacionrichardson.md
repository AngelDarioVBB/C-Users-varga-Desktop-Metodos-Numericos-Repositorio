# Tema 5: Métodos de Extrapolación
## Subtema: Extrapolación de Richardson

> **Estatus:** Documentación Técnica
> **Diferencia Clave:** A diferencia de las extrapolaciones lineal y polinómica que proyectan datos experimentales en el espacio ($x$ fuera de rango), la Extrapolación de Richardson es un método de *aceleración de convergencia*. Se utiliza para mejorar drásticamente la precisión de un algoritmo numérico (como derivadas o integrales) eliminando sistemáticamente los términos de error de menor orden sin necesidad de reducir el tamaño de paso $h$ hasta el límite de la cancelación destructiva.

---

### 1. Objetivo
El objetivo de la **Extrapolación de Richardson** es obtener una aproximación de alta precisión de una cantidad limitante $A^* = \lim_{h \to 0} A(h)$, combinando hábilmente dos o más aproximaciones de menor precisión calculadas con diferentes tamaños de paso (típicamente $h$ y $h/2$).

---

### 2. Descripción del Método

El método se basa en el desarrollo en serie de Taylor del error de una aproximación numérica. Si un método numérico $A(h)$ aproxima al valor real $A^*$ con un error de orden $O(h^2)$, su expansión de error se puede escribir como:

$$
A^* = A(h) + C_1 h^2 + C_2 h^4 + C_3 h^6 + \dots
$$

Si calculamos la misma aproximación pero reduciendo el paso a la mitad ($h/2$), obtenemos:

$$
A^* = A\left(\frac{h}{2}\right) + C_1 \left(\frac{h}{2}\right)^2 + C_2 \left(\frac{h}{2}\right)^4 + \dots = A\left(\frac{h}{2}\right) + \frac{C_1}{4} h^2 + \frac{C_2}{16} h^4 + \dots
$$

Multiplicando la segunda ecuación por 4 y restándole la primera, eliminamos por completo el término de error dominante $C_1 h^2$. Al despejar $A^*$, obtenemos la fórmula clásica de la **Extrapolación de Richardson**:

$$
A^* \approx A_{\text{mejorado}} = A\left(\frac{h}{2}\right) + \frac{A\left(\frac{h}{2}\right) - A(h)}{3}
$$

Este nuevo estimador ahora tiene un error de orden $O(h^4)$, una convergencia significativamente más rápida utilizando los mismos datos de entrada. El proceso puede repetirse jerárquicamente construyendo una tabla triangular (base del método de integración de Romberg).

---

### 3. Pseudocódigo
```text
INICIO ExtrapolacionRichardson(funcion, x, h_inicial, niveles)
  // Crear una matriz para almacenar la tabla de extrapolación
  Definir R[niveles][niveles]
  
  // Nivel 0: Calcular aproximaciones base con pasos decrecientes (h, h/2, h/4...)
  PARA i = 0 HASTA niveles-1:
    h = h_inicial / (2^i)
    R[i][0] = CalcularAproximacionBase(funcion, x, h)
  FIN PARA
  
  // Columnas siguientes: Aceleración de Richardson
  PARA j = 1 HASTA niveles-1:
    PARA i = j HASTA niveles-1:
      factor = 4^j
      R[i][j] = R[i][j-1] + (R[i][j-1] - R[i-1][j-1]) / (factor - 1)
    FIN PARA
  FIN PARA
  
  // El último elemento de la diagonal contiene el valor con mayor precisión
  RETURN R[niveles-1][niveles-1]
FIN
```

---

### 4. Código

```text
import java.util.function.Function;

public class ExtrapolacionRichardsonPrincipal {

    public static void main(String[] args) {
        // Función de prueba: f(x) = ln(x)
        Function<Double, Double> f = Math::log;
        double x = 2.0;          // Punto donde queremos evaluar la derivada
        double h = 0.4;          // Tamaño de paso inicial grande

        System.out.println("=== Extrapolación de Richardson (Derivada) ===");
        
        // Aproximaciones base usando diferencia central de O(h^2)
        double D_h = diferenciaCentral(f, x, h);
        double D_h2 = diferenciaCentral(f, x, h / 2.0);
        
        // Aplicación de Richardson para obtener O(h^4)
        double derivadaRichardson = D_h2 + (D_h2 - D_h) / 3.0;
        double valorReal = 1.0 / x; // f'(x) = 1/x -> 1/2 = 0.5

        System.out.printf("Aproximación con h=0.4: %.6f (Error: %.6f)%n", D_h, Math.abs(valorReal - D_h));
        System.out.printf("Aproximación con h=0.2: %.6f (Error: %.6f)%n", D_h2, Math.abs(valorReal - D_h2));
        System.out.printf("Richardson optimizado : %.6f (Error: %.6f)%n", derivadaRichardson, Math.abs(valorReal - derivadaRichardson));
    }

    private static double diferenciaCentral(Function<Double, Double> f, double x, double h) {
        return (f.apply(x + h) - f.apply(x - h)) / (2.0 * h);
    }
}
```


Para poder visualizar y correr el ejemplo implementado en Java es el apartado siguiente: [☕ CodigoEjemplo1](codigosextrapolacionrichard/ExtrapolacionRichardsonPrincipal.java)

A continuación van los siguientes codigos:
[☕ CodigoEjemplo2](codigosextrapolacionrichard/ExtrapolacionRichardson2.java)
[☕ CodigoEjemplo3](codigosextrapolacionrichard/ExtrapolacionRichardson3.java)
[☕ CodigoEjemplo4](codigosextrapolacionrichard/ExtrapolacionRichardson4.java)
[☕ CodigoEjemplo5](codigosextrapolacionrichard/ExtrapolacionRichardson5.java)

---

### 📑 5. Conclusion

La extrapolación de Richardson es una de las herramientas más potentes del análisis numérico. Permite transformar algoritmos ordinarios de baja precisión en maquinaria de alta fidelidad matemática con un costo computacional mínimo. Al combinar pasos grandes, esquiva de manera brillante los errores de redondeo por hardware que ocurren cuando se intenta hacer un paso $h$ infinitesimalmente pequeño.
