# CursoJava-ReservasCine
Crea un programa que modele el sistema de reservas de un cine. Cada sala tiene un número total de asientos organizados de forma secuencial (en una sola fila o
identificados por números).

Crea una clase Sala con los siguientes atributos:
• nombre (String): Nombre de la sala. //numAsientos (int): Número total de asientos disponibles en la sala. // asientos (Array de booleanos): Cada posición del array
representa un asiento, donde true indica que está ocupado y false que está libre.

Métodos de la clase Sala:
• Reservar asiento: Recibe como entrada el número del asiento y lo marca como ocupado si está libre.
• Liberar asiento: Recibe como entrada el número del asiento y lo marca como libre si estaba ocupado.
• Mostrar mapa de asientos: Imprime el estado de todos los asientos en forma de lista secuencial. Usa O para ocupados y L para libres. Ejemplo: Si hay 10 asientos
y los 2 primeros están ocupados, muestra: O O L L L L L L L L.
• Calcular asientos libres: Devuelve la cantidad total de asientos libres en la sala.

En el main:
• Permite al usuario crear salas especificando su nombre y número total de asientos.
• Crea un array con todos las salas creadas (el máximo de salas serán 20)
• Implementa un menú con las siguientes opciones:
• Crear una nueva sala: Solicita el nombre y número de asientos.
• Reservar un asiento: Solicita el nombre de la sala y el número del asiento.
• Liberar un asiento: Solicita el nombre de la sala y el número del asiento.
• Mostrar el mapa de asiento de cada salas: Muestra el estado de los asientos de una sala específica.
• Mostrar el mapa de asientos del total: Por cada sala se mostrará el nombre y el mapa de sus asientos.
• Mostrar asientos libres: Muestra cuántos asientos libres quedan en una sala específica.
• Salir del programa.
