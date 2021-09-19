##Entrenamiento

### Autenthication:
1. Generar token mediante llamada a método POST authenticate
Ejemplo: curl --header "Content-Type: application/json"   --request POST   --data "{"""username""":"""javainuse""","""password""":"""password"""}"   http://localhost:8080/authenticate
2. Usar token:
   {"token":"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYXZhaW51c2UiLCJleHAiOjE2MzE2ODg0MTcsImlhdCI6MTYzMTY3MDQxN30.dsUPXA4A9ASeoVKxDb5yEaqOxHhVzsf0P4WHUuyDM5KQFZZiAcEO2k47Owt8SDRkHW2gfaEAbQ3nxjUIC2OPLg"}

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
1. GET ventas (lista las ventas registradas)
2. POST ventas (inserta venta pasar objeto venta)

### Pruebas
Implementado ProductRepositoryTest para probar CRUD de producto

### Excepciones
Add RestExceptionHandler para el tratamiento de excepciones con @ExceptionHandler

##Log
Se registran en un fichero denominado: AppDinaTraza
