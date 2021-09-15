## Autenthication:
1. Generar token mediante llamada a método POST authenticate
Ejemplo: curl --header "Content-Type: application/json"   --request POST   --data "{"""username""":"""javainuse""","""password""":"""password"""}"   http://localhost:8080/authenticate
2. Usar token:
   {"token":"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYXZhaW51c2UiLCJleHAiOjE2MzE2ODg0MTcsImlhdCI6MTYzMTY3MDQxN30.dsUPXA4A9ASeoVKxDb5yEaqOxHhVzsf0P4WHUuyDM5KQFZZiAcEO2k47Owt8SDRkHW2gfaEAbQ3nxjUIC2OPLg"}

##Métodos Implementados
 **Productos**:
1. GET products (lista los productos registrados)
2. POST products (inserta producto pasar objeto producto)
3. DELETE products (elimina producto pasando id de tipo int)

**Cliente**:
1. POST clientes (inserta cliente pasar objeto cliente)

**Venta**
1. GET ventas (lista las ventas registradas)
2. POST ventas (inserta venta pasar objeto venta)


##Log
Se registran en un fichero denominado: AppDinaTraza