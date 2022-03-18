# La Verde SA

Este sistema pretende llevar control de las cosechas de **La Verde S.A.**, incluyendo los pesos (estos son, los kilos entregados al secadero y los kilos registrados en pesaje a campo; de los cuales se puede obtener la diferencia), los lotes, los cuadros, los cosecheros, los productores de las plantaciones y los secaderos de yerba.

## Instalación

### Requerimientos
- OpenJDK 14 o superior
- Postgresql 12 o superior
- PostGIS 3 o superior
- Apache Maven 3

### Ubuntu 20.04
1. Descargar el repositorio en la ubicación que desee.
2. Crear la base de datos con el nombre "laverde".
3. Conectarse a la base de datos "laverde" y agregarle la extensión PostGIS con el siguiente comando.  `    CREATE EXTENSION PostGIS;`
4. Editar en el archivo persistence.xml ubicado en directorio "src/main/java/META-INF/persistence.xml" las siguientes lineas de código:
```xml
<property name="hibernate.connection.username" value="postgres" />
<property name="hibernate.connection.password" value="postgres" />
```
Cambiando los atributos value por los valores que sean correctos acorde a su configuración de PostgreSQL.

5. Ejecutar el programa App.java, en nuestro caso utilizamos el IDE de Visual Studio Code con la extensión "Extension Pack for Java" instalada.
6. Si siguió los pasos correctamente debe ingresar a su navegador y en la barra de navegación ingresar http://localhost:7000/ y debería poder ver la interfaz del sistema.