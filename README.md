
# Conversor de monedas



![Static Badge](https://img.shields.io/badge/java-17-green)
![Static Badge](https://img.shields.io/badge/javaFx-v21.0.3-green)
![Badge en Desarollo](https://img.shields.io/badge/status-EN%20DESARROLLO-blue)
![GitHub last commit](https://img.shields.io/github/last-commit/diego-vilca/Conversor-de-monedas)
[![MIT License](https://img.shields.io/badge/license-MIT-blue.svg)](https://choosealicense.com/licenses/mit/)

Este proyecto permite convertir un tipo de moneda a otra a partir de la selección de las divisas correspondientes y el monto a convertir. Además, guarda un historial con cada una de las conversiones realizadas, incluyendo la fecha de cada una de ellas. Para facilitar su uso, el proyecto cuenta con una interfaz gráfica amigable e intuitiva.

![Animación de conversión de moneda](https://media.giphy.com/media/v1.Y2lkPTc5MGI3NjExa3lrbmFtOXJkMXlkemMzb2dramNsYXJ5YWtpZnpoZ3pzcWoxendrdCZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/Dz83CWuNYrlxSuxT0l/giphy.gif)
## Tecnologías Utilizadas
- **Java 17**
- **JavaFX 21.0.3**
- **ExchangeRate-API**
- **Gson 2.10.1**
- **IntelliJ IDEA 2024.1.1**
## Instrucciones
Para utilizar el programa debes descargar el archivo.zip o clonar el proyecto a la ubicación que desees:

```bash
  git clone https://github.com/diego-vilca/Conversor-de-monedas.git
```

Para correr este proyecto, necesitaras agregar la siguiente variable de entorno a tu sistema.

`API_KEY`

Para obtener tu clave, es necesario realizar un registro inicial
en [https://app.exchangerate-api.com](https://app.exchangerate-api.com/sign-in) ingresando tu correo electrónico. Después de esto, recibirás una clave en el correo electrónico proporcionado y estará lista para su uso, ahora asignala a tu variable de entorno `API_KEY`.
## Uso

Abre el proyecto en tu IDE preferido y ejecuta la clase `Main`. Aparecerá una interfaz gráfica con una serie de campos:

- **Amount**: Ingresa aquí el monto que quieras convertir.
- **From**: Selecciona la moneda en la cual está el monto.
- **To**: Selecciona la moneda a la que quieres convertir.

Para realizar la conversión, pulsa el botón **Convert** y el resultado aparecerá inmediatamente en la caja de texto.

También puedes consultar tu historial de conversiones desde el botón **Log History**.

>[!NOTE]
>Próximamente se añadirá un gráfico que muestre la variación de la tasa de divisas durante el último período.
## Autor

- [@diego-vilca](https://github.com/diego-vilca)


## Licencia

Este proyecto está licenciado bajo la [licencia MIT](https://choosealicense.com/licenses/mit/)


