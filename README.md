##Entrenamiento

### Autenthication:
1. Generar token mediante llamada a método POST authenticate
Ejemplo: curl --header "Content-Type: application/json"   --request POST   --data "{"""username""":"""dina""","""password""":"""entrenamiento"""}"   http://localhost:8080/authenticate
2. El listado de usuarios se obtiene desde la db 
3. Por defecto:
4. user:dina password:entrenamiento
5. user:jorge password:entrenamiento
6. Para insertar nuevos user: /user pasando en el json username y password

### Métodos Implementados
 **Productos**:
1. GET products (lista los productos registrados)
2. GET products/{idproducto} (muestra producto por id)
3. POST products (inserta producto pasar objeto producto)
4. DELETE products (elimina producto pasando id de tipo int)
5. PUT products/{idproducto} (modifica un producto)


**Cliente**:
1. GET clientes (lista los clientes registrados)
2. GET clientes/{idclientes} (muestra clientes por id)
3. POST clientes (inserta clientes pasar objeto clientes)
4. DELETE clientes (elimina clientes pasando id de tipo int)
5. PUT clientes/{idclientes} (modifica un producto)

**Venta**
1. GET venta/{idventa} (muestra venta solicitada incluido el listado de detalles)
2. GET ventadetalle/{idventa} (muestra el listado de detalles)
3. POST ventas (inserta venta pasar objeto venta)

### Pruebas
Implementado ProductRepositoryTest para probar CRUD de producto

### Excepciones
Add RestExceptionHandler para el tratamiento de excepciones con @ExceptionHandler

##Log
Se registran en un fichero denominado: AppTraza
