# Facade · Caso aplicado: matrícula académica

## Necesidad
Matricular una materia toca **cinco servicios** de la universidad, en este orden:

1. `ServicioEstudiantes`: ¿existe y está activo?
2. `ServicioFinanciero`: ¿tiene deuda?
3. `ServicioCupos`: ¿hay cupo?
4. `ServicioHorarios`: ¿se cruza con otra materia?
5. Si todo pasa: reservar cupo, generar recibo y enviar correo de confirmación.

Hay dos canales: el portal web y la app móvil. En `00-inicio` **cada canal copia las reglas**.
Ejecútelo y revise las líneas 2 y 3 de la consola: Andrés tiene deuda, la app le aprueba la
matrícula y el portal se la rechaza. La app olvidó la regla de deuda y además le quitó el
último cupo a otro estudiante.

## Cómo ejecutar
```
cd 00-inicio
javac *.java
java Main
```

## Reto (25 min)
1. Cree `ResultadoMatricula` con `boolean exitosa` y `String mensaje`.
2. Cree `MatriculaFacade` con los cinco servicios como atributos (recibidos por constructor).
3. Escriba `ResultadoMatricula matricular(String codigo, String materia)` con las reglas del
   portal, en el mismo orden.
4. Reduzca `PortalWeb` y `AppMovil` a un atributo `MatriculaFacade` y un `matricular()` de dos líneas.
5. En `Main`, cree los servicios una sola vez y entréguelos a la fachada.

## Quedó bien si
- Andrés queda **rechazado por deuda** en los dos canales.
- Quedan **1** cupo en Programación I (en `00-inicio` quedaban 0).
- `PortalWeb` y `AppMovil` no importan ni mencionan ningún `Servicio...`.
- Las cinco clases de servicios quedaron sin cambios.

## Reto extra (necesidad nueva, sin solución incluida)
Llega un tercer canal: el **kiosco** de autoservicio en la biblioteca. Además, Registro
Académico pide una regla nueva: máximo 20 créditos por semestre. ¿Cuántas clases toca
para cada cambio con la fachada? ¿Y cuántas habría tocado en `00-inicio`?

La solución está en `01-solucion`.
