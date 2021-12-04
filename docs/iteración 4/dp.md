# Iteración 4
## Trabajo en equipo:
El líder de equipo para esta iteración será Fernando Iván Paredes y se permitira el avance mayor posible de cada miembro, considerando que se carece de tiempo para una distribución ordenada. Los miembros estarán en contacto constante para informar sobre los avances y dónde tiene dificultades cada uno, tratando de lograr incentivar la combinación y lograr funcionar la estrategia de reuniones que simulen un encuentro presencial.
## Diseño OO:
![](./clases.JPG)
## Casos de uso:
Para esta iteración, se posee todos los CRUD de las tablas; por lo tanto, para cada clase se posee los siguientes casos de uso (para cada uno, se usa el término de instancia para expresar un objeto de clase):
### Ver instancias:
- El usuario visita la aplicación web a través de un navegador
- Se le muestra la página de inicio al usuario
- El usuario selecciona la clase que desea observar
- Se devuelve la tabla con las tablas correspondientes a la clase
### Registrar instancia:
- Primero, se tuvo que haber desarrollado el caso de uso Ver instancias
- De ahí, el usuario hace clic en el botón para Nueva instancia (en la implementación, tendrá el nombre que corresponda al objeto específico a agregar)
- Se devuelve el formulario para el registro de una instancia nueva
- El usuario completa los campos requeridos por el formulario (resulta ser la totalidad de campos)
- El usuario confirma para generar la nueva instancia
- Se confirma que la instancia fue creada correctamente
- Se vuelve a la tabla mostrada al principio del caso de uso, junto con la instancia nueva
### Modificar instancia:
- Primero, se tuvo que haber desarrollado el caso de uso Ver instancias
- De ahí, el usuario hace clic en el botón para Editar la instancia de la tupla en donde se ubica el botón
- Se devuelve el formulario para la edición de una instancia nueva, junto con los datos que se guardan actualmente en la instancia
- El usuario edita los campos desados el formulario (aunque los campos deben estar completos)
- El usuario confirma para actualizar la instancia
- Se confirma que la instancia fue editada correctamente
- Se vuelve a la tabla mostrada al principio del caso de uso con la instancia que contiene los datos actualizados
### Eliminar instancia:
- Primero, se tuvo que haber desarrollado el caso de uso Ver instancias
- De ahí, el usuario hace clic en el botón para Eliminar instancia
- Se vuelve a la tabla mostrada al principio del caso de uso sin la instancia eliminada
## Backlog de iteraciones:
(Aquí debería incluirse la totalidad de requerimientos funcionales y no funcionales, lo cual es similar a todas las historias de usuario que se encuentran en el mapa de camino o roadmap de la iteración 0; esto es sin incluir la iteración 5, que es de mejora de código)
## Tareas:
- Realizar los CRUD del sistema.
- Diseñar los casos de uso, las clases UML y el wireframe.
- Implementar el sistema, integrando una interfaz de interacción.
- Evaluar con pruebas si el sistema funciona correctamente.
