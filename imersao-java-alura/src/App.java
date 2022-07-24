import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static final String FUNDO_AZUL ="\033[0;34m";
    public static final String FUNDO_VERMELHO = "\033[0;31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) throws Exception {

        // criar diretório
        var nomeDoDiretorio = "C:\\Users\\gustavoc\\Desktop\\imersao-alura\\imersao-alura\\saida";
        if (nomeDoDiretorio == null){
            var path = Paths.get(nomeDoDiretorio);
            Files.createDirectories(path);
            System.out.println("Diretório criado!" + nomeDoDiretorio);
        } else {
            System.out.println("Diretório já existe. Aproveite!");
            System.out.println();
        }

        String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD-JamesWebbSpaceTelescope";
        ExtratorDeConteudo extratorNasa = new ExtratorConteudoNasa();

        var http = new ClienteHttp();
        var json = http.buscaDados(url);

        var extraiConteudos =  extratorNasa.extraiConteudos(json);

        var geradorDeSticker = new GeradorDeSticker();

        for (int i = 0; i < 3; i++){

            var conteudo = extraiConteudos.get(i);

            var inputStream = new URL(conteudo.urlImagem()).openStream();
            var nomeArquivo = "saida/" + conteudo.titulo() + ".png";

            geradorDeSticker.criarSticker(inputStream, nomeArquivo);

            System.out.println("Titulo: " + FUNDO_AZUL + conteudo.titulo() + ANSI_RESET);
            System.out.println("Data: " + FUNDO_VERMELHO + conteudo.data() + ANSI_RESET);
            System.out.println();

        }
    }
}
