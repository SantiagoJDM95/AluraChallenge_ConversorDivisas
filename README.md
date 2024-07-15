# Alura Challenge Conversor de Divisas

## Description
Esta aplicación es un conversor de divisas en Java que utiliza la API de Exchange Rate para obtener tasas de conversión de diferentes monedas. Permite al usuario convertir un monto de una moneda a otra de manera sencilla.

## requisitos
  - Java 11 o superior
Dependencias:
  - `Gson` para el manejo de JSON (puedes incluirlo en tu archivo `pom.xml` si usas Maven)
  - 
## Estructura del Proyecto
El proyecto está compuesto por las siguientes clases:

1. **MenuApp**: La clase principal que maneja la interacción del usuario.
2. **ConsultaExchange**: Clase responsable de realizar consultas a la API de Exchange Rate y obtener las tasas de conversión.
3. **ClavesDivisas**: Clase que modela la respuesta de la API, incluyendo el código base y las tasas de conversión.

## Cómo Usar
1. Clona el repositorio en tu máquina local.
   ```bash
   git clone https://github.com/tu_usuario/CurrencyConverterApp.git
   cd CurrencyConverterApp

2. Abre el proyecto en tu IDE (IntelliJ, Eclipse, etc.).

3. Asegúrate de tener una conexión a Internet, ya que la aplicación necesita acceder a la API de Exchange Rate.

4. Ejecuta la clase MenuApp.

5. Sigue las instrucciones en la consola para ingresar:

  La moneda de origen (por ejemplo, USD)
  La cantidad a convertir
  La moneda de destino (por ejemplo, MXN)

##Licencia
Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.
  
### Ejemplo de uso
Obteniendo claves de divisas...
Opciones de moneda: 
USD MXN ARS BOB BRL CLP COP 
Tipo de moneda de origen: 
USD
Cantidad a convertir: 
100
Tipo de moneda destino: 
MXN
100.0 USD es igual a 2000.0 MXN

