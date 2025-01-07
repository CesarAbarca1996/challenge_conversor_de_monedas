import com.google.gson.Gson; // Librería para trabajar con JSON, usada para convertir cadenas JSON en objetos Java.
import java.io.IOException; // Excepción para manejo de errores de entrada/salida.
import java.net.URI; // Clase para manejar URIs.
import java.net.http.HttpClient; // Cliente HTTP para enviar solicitudes.
import java.net.http.HttpRequest; // Clase para construir solicitudes HTTP.
import java.net.http.HttpResponse; // Clase para manejar las respuestas HTTP.
import java.util.ArrayList; // Clase para trabajar con listas dinámicas.
import java.util.List; // Interfaz para listas.
import java.util.Map; // Interfaz para manejar mapas clave-valor.

public class ConversorDeDivisa { // Clase principal para convertir divisas.

    // Método que convierte de pesos chilenos (CLP) a otras monedas.
    public List<Moneda> buscarDivisa(String nombre) {
        // URL del servicio de API para obtener tasas de cambio de pesos chilenos.
        URI uri = URI.create("https://v6.exchangerate-api.com/v6/52c3fb3128b04499240fbb98/latest/"+nombre);

        // Crea un cliente HTTP con redirecciones automáticas.
        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build(); // Configuración para seguir redirecciones.

        // Construye una solicitud HTTP para la URI especificada.
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();

        // Instancia de Gson para convertir entre JSON y objetos Java.
        Gson gson = new Gson();

        try {
            // Envía la solicitud y obtiene la respuesta como cadena.
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Convierte el cuerpo de la respuesta JSON en un objeto de tipo `Divisa`.
            Divisa divisa = gson.fromJson(response.body(), Divisa.class);

            // Crea una lista para almacenar las monedas y sus tasas de conversión.
            List<Moneda> monedas = new ArrayList<>();

            // Recorre el mapa de tasas de conversión del objeto `Divisa`.
            for (Map.Entry<String, Double> entry : divisa.conversion_rates().entrySet()) {
                // Crea una nueva instancia de `Moneda` con el nombre y la tasa de conversión.
                monedas.add(new Moneda(entry.getKey(), entry.getValue()));
            }

            // Devuelve la lista de monedas con sus tasas de conversión.
            return monedas;
        } catch (IOException | InterruptedException e) {
            // Lanza una excepción en caso de error al enviar la solicitud o procesar la respuesta.
            throw new RuntimeException(e);
        }
    }
}
