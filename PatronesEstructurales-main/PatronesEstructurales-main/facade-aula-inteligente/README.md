# Facade · Ejercicio de entrada: el aula inteligente

## Problema
Para empezar una clase en el aula del bloque de Ingeniería hay que manejar cuatro equipos:
`Computador`, `Proyector`, `Sonido` y `Luces`. Son **7 llamadas en un orden preciso**.

En `00-inicio`, `Main` hace las llamadas a mano para cada clase. En la clase de las 9:00 alguien
las copió en otro orden y olvidó una: la consola muestra un error del computador y el proyector
queda sin entrada.

## Cómo ejecutar
```
cd 00-inicio
javac *.java
java Main
```

## Reto (15 min)
1. Cree la clase `AulaFacade` con un atributo por cada equipo, recibidos por constructor.
2. Escriba `iniciarClase(String presentacion)` con los 7 pasos en el orden de la clase de las 7:00.
3. Escriba `terminarClase()` con los 4 pasos de cierre.
4. Reescriba `Main` para que solo use `AulaFacade`.

## Quedó bien si
- La clase de las 7:00 sale igual que en `00-inicio`.
- La clase de las 9:00 ya no muestra el error y sí selecciona la entrada HDMI.
- `Main` no llama directamente ningún método de `Proyector`, `Sonido`, `Luces` ni `Computador`.
- Las cuatro clases de equipos quedaron sin cambios.

## Reto extra (sin solución incluida)
Agregue a la fachada `modoExamen()`: luces al 100 %, sonido apagado, proyector mostrando el
reloj ("entrada RELOJ"). ¿Cuántas clases tuvo que tocar además de `AulaFacade`?

La solución está en `01-solucion`.
