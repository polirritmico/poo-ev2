# AirbnbPet

_Implementación de un sistema de registro de mascotas._

## Contexto

Una veterinaria llamada AirbnbPet, ha decidido mejorar su proceso de atención y
contratar los servicios de un especialista para desarrolle un sistema que
permita almacenar la información de las mascotas que se alojan en sus
dependencias

## Requerimiento Inicial

Las mascotas que son alojadas se identifican con un nombre, peso, edad y días de
alojamiento e inicialmente se atenderán solo perros, gatos y conejos.

Los perros se caracterizan por salir hacer ejercicio durante el día. En cambio,
los gatos se definen por medio de un pedigrí y los conejos se identifican con
tipo de comida que ingieran (dieta).

---

El desarrollo de la aplicación debe responder a los siguientes requerimientos:

- Cada mascota debe identificarse con un código alfanumérico único.
- Cada mascota puede o no requerir la supervisión de un veterinario durante la
  noche.
- Debe existir un método para mostrar los datos de mascota que debe ser
  sobrescrito dependiendo del tipo.
- La clase padre debe ser abstracta.
- Debe considerar generar por lo menos un constructor vacío y uno sobrecargado
  con todos sus datos en cada clase que se deba instanciar.

La veterinaria ha definido que el costo diario de alojamiento se establece por
medio de las siguientes reglas:

- Para el perro, tendrá un incremento de 7%, siempre y cuando el perro, salga
  más de 3 veces al día a hacer ejercicio, de lo contrario el valor día se
  mantiene.
- Para el gato, tiene un incremento de un 5%
- Y finalmente para los conejos, y como comparten jaula con otros, tiene un
  descuento de 7%

Dado lo anterior, debe implementar una clase del tipo interface que almacene los
valores anteriores, además de la constante `VALOR_DIA_ALOJAMIENTO: $25.000`.
Adicional, y en la misma interface, considerar un método que calcule el valor
final de alojamiento de una mascota a partir de los días que permanezca.

Considere una clase auxiliar que permita almacenar las mascotas que se alojen en
el hotel con las siguientes funcionalidades implementadas:

- Validar que la mascota agregada no exista por su código antes de ingresarla.
- Un método que liste todas las mascotas alojadas.
- Un método que retorne la cantidad de mascotas.

> [!NOTE]
>
> Todas las clases deben tener los siguientes métodos implementados:
> constructores, accesadores y mutadores.

En la clase **principal** debe:

- Agregar 3 perros, 2 gatos y 2 conejos a la colección.
- Listar todas las mascotas y el total de mascotas.
- Calcular y mostrar el costo total a pagar por todas las mascotas que estén
  registradas como alojadas (7 en total).

**Recuerda** que se debe desarrollar el código aplicando todas las convenciones
aprendidas en clases.
