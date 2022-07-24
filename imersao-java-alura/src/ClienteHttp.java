import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteHttp {

    public String buscaDados (String url) {

        try {

            var endereco = URI.create(url);
            var cliente = HttpClient.newHttpClient();
            var requisicao = HttpRequest.newBuilder(endereco).GET().build();
            var response = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());
            return response.body();

        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }
}
