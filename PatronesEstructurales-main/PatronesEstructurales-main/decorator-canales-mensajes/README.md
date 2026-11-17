# Decorator · Caso aplicado: notificaciones del sistema académico

## Necesidad
El sistema académico envía avisos por correo y por SMS. Cada aviso necesita una mezcla
distinta de opciones:

| Aviso | Canal | Opciones |
|---|---|---|
| Nota publicada | correo | firma institucional + registro |
| Clase cancelada | SMS | recortar a 40 caracteres + registro |
| Clave temporal | correo | cifrado + firma (y seguridad pide que la firma también vaya cifrada) |

En `00-inicio` las opciones son banderas `boolean` dentro de `CanalCorreo`, y `CanalSMS` es una
copia pegada. Ejecútelo y revise la consola:
- El SMS **no aparece en el registro**, aunque se activó `setRegistrar(true)`: en la copia se olvidó ese bloque.
- El orden está fijo (siempre cifra antes de firmar), así que es imposible cifrar la firma sin editar la clase.

## Cómo ejecutar
```
cd 00-inicio
javac *.java
java Main
```

## Reto (25 min)
1. Cree la interfaz `Canal` con `void enviar(String destinatario, String mensaje)`.
2. Deje `CanalCorreo` y `CanalSMS` sin banderas: solo imprimen.
3. Cree la clase abstracta `DecoradorCanal implements Canal` con un atributo `protected Canal envuelto`.
4. Cree un decorador por opción: `ConFirma`, `ConCifrado`, `ConLimite(canal, maximo)` y `ConRegistro`.
   Cada uno transforma el mensaje (o registra) y luego llama a `envuelto.enviar(...)`.
5. En `Main`, arme cada aviso apilando capas, por ejemplo:
   `new ConRegistro(new ConLimite(new CanalSMS(), 40))`.
6. Arme el correo de clave temporal en los **dos** órdenes y compare la consola.

## Quedó bien si
- Los avisos 1, 2 y 3 salen igual que en `00-inicio`, y ahora el SMS **sí** tiene su línea `[LOG #1]`.
- En el aviso 4 la firma también aparece cifrada.
- No queda ningún `boolean` de configuración ni código de cifrado repetido.

## Reto extra (necesidad nueva, sin solución incluida)
Bienestar universitario quiere enviar por WhatsApp. Cree `CanalWhatsApp` y úselo con firma y
registro sin escribir una sola línea nueva de firma o registro.

La solución está en `01-solucion`.
