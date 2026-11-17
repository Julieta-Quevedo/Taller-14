# Composite · Caso aplicado: combos de una app de domicilios

## Necesidad
Un restaurante vende por app de domicilios. Mercadeo quiere **combos dentro de combos**:
el "Combo Familiar" (10 % de descuento) trae un "Combo Hamburguesa" y un "Combo Perro"
(5 % cada uno) más una malteada. El recibo debe mostrar el árbol, el precio de cada nivel
y cuántos productos lleva el pedido.

En `00-inicio`, `Combo` y `Pedido` guardan `List<Object>` y preguntan `instanceof` en cada
método. Ejecútelo y revise la consola:
- El recibo dice **4 productos**, pero el pedido lleva **8**: `contarProductos()` cuenta cada
  combo anidado como uno solo.
- `pedido.agregar("Gaseosa")` compila y la gaseosa desaparece sin aviso.

## Cómo ejecutar
```
cd 00-inicio
javac *.java
java Main
```

## Reto (25 min)
1. Cree la interfaz `ItemMenu` con `getNombre()`, `getPrecio()`, `contarProductos()` e `imprimir(String sangria)`.
2. `Producto implements ItemMenu`: es la hoja (`contarProductos()` devuelve 1).
3. `Combo implements ItemMenu` con `List<ItemMenu> items`. Cada método es un solo ciclo que delega en sus hijos y aplica el descuento.
4. `Pedido` guarda `List<ItemMenu>`; borre todos los `instanceof` y casts.
5. Comente la línea `pedido.agregar("Gaseosa")` y compruebe que ya no compila.

## Quedó bien si
- Los precios no cambian: Combo Familiar **$51.705**, total **$58.705**.
- El total dice **8 productos**.
- No queda ningún `instanceof` ni ningún `Object` en el proyecto.

## Reto extra (necesidad nueva, sin solución incluida)
El restaurante quiere un `ComboPrecioFijo`: un combo que cuesta siempre $25.000 sin importar
lo que tenga adentro. Agréguelo sin modificar `Pedido`.

La solución está en `01-solucion`.
