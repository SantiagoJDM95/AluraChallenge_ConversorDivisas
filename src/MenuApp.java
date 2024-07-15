import java.util.Scanner;

public class MenuApp {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        ConsultaExchange consulta = new ConsultaExchange();

        while (true) {
            System.out.println("Obteniendo claves de divisas...");
            ClavesDivisas clavesDivisas = consulta.consultaExchange("USD");

            System.out.println("Opciones de moneda: ");
            for (String clave : clavesDivisas.getConversionRates().keySet()) {
                System.out.print(clave + " ");
            }
            System.out.println();

            String monedaOrigen = "";
            boolean monedaOrigenValida = false;

            // Solicitar la moneda de origen hasta que sea válida
            while (!monedaOrigenValida) {
                System.out.println("Tipo de moneda de origen: ");
                monedaOrigen = userInput.next().toUpperCase();
                if (clavesDivisas.getConversionRates().containsKey(monedaOrigen)) {
                    monedaOrigenValida = true;
                } else {
                    System.out.println("Moneda de origen fuera de las opcoines. Intente de nuevo.");
                }
            }

            double monto = 0;
            boolean montoValido = false;

            // Solicitar la cantidad a convertir hasta que sea válida
            while (!montoValido) {
                System.out.println("Cantidad a convertir: ");
                if (userInput.hasNextDouble()) {
                    monto = userInput.nextDouble();
                    if (monto > 0) {
                        montoValido = true; // Salir del bucle si es un número válido
                    } else {
                        System.out.println("Por favor, ingrese un monto positivo.");
                    }
                } else {
                    System.out.println("Monto erróneo. Ingrese un número válido.");
                    userInput.next(); // Limpiar la entrada incorrecta
                }
            }

            String monedaDestino = "";
            boolean monedaDestinoValida = false;

            // Solicitar la moneda de destino hasta que sea válida
            while (!monedaDestinoValida) {
                System.out.println("Tipo de moneda destino: ");
                monedaDestino = userInput.next().toUpperCase();
                if (clavesDivisas.getConversionRates().containsKey(monedaDestino)) {
                    monedaDestinoValida = true;
                } else {
                    System.out.println("Moneda de destino fuera de las opciones. Intente de nuevo.");
                }
            }

            // Realizar la conversión
            double tasaOrigen = clavesDivisas.getConversionRates().get(monedaOrigen);
            double tasaDestino = clavesDivisas.getConversionRates().get(monedaDestino);
            double montoConvertido = monto * (tasaDestino / tasaOrigen);
            System.out.println(monto + " " + monedaOrigen + " es igual a " + montoConvertido + " " + monedaDestino);

            // Preguntar si el usuario quiere continuar o salir
            System.out.println("¿Desea realizar otra conversión? (sí/salir)");
            String respuesta = userInput.next().toLowerCase();
            if (respuesta.equals("salir")) {
                System.out.println("Saliendo del programa...");
                break; // Salir del bucle y del programa
            }
        }

        userInput.close(); // Cerrar el scanner al final
    }
}


