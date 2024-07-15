import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class ConsultaExchange {
    public ClavesDivisas consultaExchange(String monedaOrigen){
        URI url = URI.create("https://v6.exchangerate-api.com/v6/286e37f9dc49ee96c078618f/latest/" + monedaOrigen);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            ClavesDivisas todasClaves = new Gson().fromJson(response.body(), ClavesDivisas.class);

            // Filtrar las claves de interés
            Map<String, Double> conversionRatesFiltrados = new HashMap<>();
            String[] clavesApi = {"MXN","ARS", "BOB", "BRL", "CLP", "COP", "USD"};
            for (String clave : clavesApi) {
                if (todasClaves.getConversionRates().containsKey(clave)) {
                    conversionRatesFiltrados.put(clave, todasClaves.getConversionRates().get(clave));
                }
            }
            todasClaves.setConversionRates(conversionRatesFiltrados);
            return todasClaves;

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}