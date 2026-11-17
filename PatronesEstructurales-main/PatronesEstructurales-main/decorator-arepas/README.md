# Decorator · Ejercicio de entrada: arepas con adiciones

## Problema
Un puesto de arepas vende la arepa de maíz ($3.500) con adiciones: queso (+$2.500),
huevo (+$2.000) y chorizo (+$4.000). En `00-inicio` cada combinación es una **subclase**:
`ArepaConQueso`, `ArepaConHuevo`, `ArepaConQuesoYHuevo`, `ArepaConQuesoHuevoYChorizo`…

**Requisito nuevo:** adición de aguacate (+$3.000) y la opción "doble queso".
Con 4 adiciones habría 16 combinaciones = 16 clases, y "doble queso" no se puede.

## Cómo ejecutar
```
cd 00-inicio
javac *.java
java Main
```

## Reto (15 min)
1. Convierta `Arepa` en una **interfaz** con `descripcion()` y `precio()`.
2. Cree `ArepaBase implements Arepa` (la arepa sola).
3. Cree la clase abstracta `Adicion implements Arepa` con un atributo `protected Arepa arepa` que recibe por constructor.
4. Cree `Queso`, `Huevo` y `Chorizo` que extiendan `Adicion`: cada método llama al de la arepa envuelta y le suma lo suyo.
5. Borre las subclases de combinaciones y arme el pedido así: `new Huevo(new Queso(new ArepaBase()))`.
6. Cree `Aguacate` y pida una arepa con doble queso y aguacate.

## Quedó bien si
- Las cuatro primeras líneas de la consola son idénticas a las de `00-inicio`.
- La arepa con doble queso y aguacate cuesta **$11.500**.
- Hay una clase por adición, no una por combinación.

## Reto extra (sin solución incluida)
Agregue el decorador `ParaLlevar` que suma $500 de empaque. ¿En qué posición de la cadena
conviene ponerlo para que aparezca al final de la descripción?

La solución está en `01-solucion`.
