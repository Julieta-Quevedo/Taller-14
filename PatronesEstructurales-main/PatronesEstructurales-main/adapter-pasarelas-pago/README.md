# Adapter · Caso aplicado: pasarelas de pago de una tienda en línea

## Necesidad
Una tienda en línea colombiana cobra con su propia pasarela (`PagoTarjetaLocal`), que ya
cumple el contrato `ProcesadorPago`. Gerencia firmó con dos proveedores nuevos:

| Proveedor | Clase (librería, **no se puede modificar**) | Moneda | Cliente | Errores |
|---|---|---|---|---|
| Billetera digital | `BilleteraYaApi` | centavos (long) | celular | códigos 200 / 402 / 404 |
| Pasarela internacional | `GlobalPayClient` | dólares (double) | correo | lanza `GlobalPayException` |

En `00-inicio` el `Checkout` conoce los tres mundos: un `if` por método, conversiones de moneda,
códigos numéricos y un `try/catch`, todo en el mismo método. Fíjese en la última línea de la
consola: `"GLOBAL_PAY"` mal escrito compila y termina en "Metodo de pago desconocido".

## Cómo ejecutar
```
cd 00-inicio
javac *.java
java Main
```

## Reto (25 min)
1. Cree `AdaptadorBilleteraYa implements ProcesadorPago`. Recibe por constructor la
   `BilleteraYaApi` y el celular del cliente. En `pagar()`: pesos → centavos, llamar
   `enviarCobro`, convertir el código en `ResultadoPago`.
2. Cree `AdaptadorGlobalPay implements ProcesadorPago`. Recibe el `GlobalPayClient`, el correo
   y la tasa (4000 COP por USD). En `pagar()`: pesos → dólares, llamar `charge`, y convertir la
   excepción en un `ResultadoPago` rechazado.
3. Deje `Checkout.procesar(String referencia, double montoCOP, ProcesadorPago procesador)`
   con dos líneas: pagar e imprimir. Sin `if`, sin `try`, sin tasas.
4. En `Main`, cree un procesador por cliente y páselo al checkout.

## Quedó bien si
- Los pedidos PED-001 a PED-005 dan el mismo resultado que en `00-inicio`.
- `Checkout.java` no menciona `BilleteraYaApi`, `GlobalPayClient` ni `GlobalPayException`.
- Ninguna clase de librería fue modificada.
- Pasar un texto en lugar de un procesador ya no compila.

## Reto extra (necesidad nueva, sin solución incluida)
Llega un tercer proveedor, `CriptoPagoSDK`, con el método
`boolean transfer(String wallet, int satoshis)` (1 satoshi = 2 pesos en este ejercicio).
Intégrelo **sin abrir** `Checkout.java`.

La solución está en `01-solucion`.
