# Iteración vacaciones
## Especificación de requisitos de software
### Enunciado del problema
La empresa *La Verde S.A.* presta servicio de cosecha de yerba mate a distintos productores. Se busca un sistema que lleve un registro de los kilos cosechados por cada empleado y a qué productor corresponden dichos kilos. En la reunión inicial, el encargado de *La Verde S.A.* ha indicado que llevan un control de kilos cosechados por empleado a nivel de productor, lote y cuadro, pero que quieren llevar un control la diferencia entre kilos entregados al secadero y kilos registrados en pesaje a campo.
### Solución propuesta
Crear un sitio web llamado **Laverdesa**, donde ciertos miembros de la empresa *La Verde S.A.* (quienes sean designados a la carga electrónica de datos) podrán registrar sus empleados y las cosechas que éstos realizan; de ahí, los productores podrán mantener la información de sus lotes y cuadros. Además, tanto los secaderos como los que cultivan la yerba podrán observar las cosechas de *La Verde S.A.*; donde los primeros mencionados podrán ver los kilos entregados, mientras que los productores tendrán a la vista los kilos registrados en pesaje a campo.
Para que la aplicación vaya más allá de un simple CRUD o ABML, el sistema llevará un registro de las áreas abarcadas por cada lote y cuadro; controlándose que no se intercepten sectores entre sí. Los lotes se representarán como rectángulos, mientras que los cuadros podrán tener cualquier forma (siempre y cuando se pueda representar con un conjunto finito de puntos como vértices).
### Clientes potenciales
Los usuarios que probablemente utilicen este sistema son:
- Personal perteneciente a la empresa *La Verde S.A.*
- Productores de yerba mate que proveen a *La Verde S.A.*
- Personal perteneciente a cada secadero que recibe insumos de *La Verde S.A.*
### Requisitos funcionales
#### Deben estar:
- Como miembro autorizado de *La Verde S.A.*, quiero controlar el registro de empleados para almacenar datos de las personas que cosechan en nombre de la empresa.
- Como miembro autorizado de *La Verde S.A.*, quiero administrar los productores y secaderos para conservar la información sobre los proveedores y los clientes.
- Como miembro autorizado de *La Verde S.A.*, quiero gestionar las cosechas dentro del sistema para conocer cuándo se realizaron, los pesos obtenidos de ellas, quiénes realizaron tales, de quién se consiguió la yerba y el secadero al que se entregó.
- Como miembro autorizado de *La Verde S.A.*, quiero observar la diferencia entre kilos entregados al secadero y kilos registrados en pesaje a campo para saber las pérdidas en el transporte de la cosecha.
- Como productor que provee a *La Verde S.A.*, quiero registrar mis lotes y cuadros para que los cosecheron conozcan el lugar donde realizan su trabajo.
- Como productor que provee a *La Verde S.A.*, quiero ver las cosechas de mi producción para saber cuánta yerba extraen de mi propiedad.
- Como personal perteneciente a un secadero que recibe yerba de *La Verde S.A.*, quiero mirar las entregas que la empresa cosechera hace para controlar los kilos de insumo.
#### Sería bueno que estén:
- Como miembro autorizado de *La Verde S.A.*, me gustaría filtrar las cosechas según los datos registrados para visualizar el conjunto de cosechas que me interesa.
- Como miembro autorizado de *La Verde S.A.*, me gustaría clasificar las cosechas a partir de los pesos registrados (sea cantidad o porcentaje de pérdida) para ajustar la información a la visión de la empresa.
- Como miembro autorizado de *La Verde S.A.*, me gustaría observar las cosechas categorizadas según los pesos registrados para poder detectar patrones en la empresa.
- Como miembro autorizado de *La Verde S.A.*, me gustaría acceder a informes estadísticos sobre las cosechas para tomar las decisiones correctas dentro de la empresa.
### Requisitos no funcionales
#### Requisitos del producto
##### Servidor:
**Lenguaje de programación:** Java
**Framework:** Javalin *(microframework)*
##### Base de Datos:
**Motor:** PostgreSQL
**Persistencia:** Hibernate
##### Cliente:
**Lenguaje de etiquetas:** HTML
**Lenguaje de diseño gráfico:** CSS
**Lenguaje de programación:** JavaScript
#### Requisito organizacional
Al registrarse una cosecha, deberá contar previamente con las anotaciones de los kilos entregados a secaderos y de los pesajes a campo.
#### Requisito externo
Para poder acceder a los datos que corresponden al usuario que quiere ingresar, iniciará sesión con su cuenta; donde tendrá un identificatorio y una contraseña.