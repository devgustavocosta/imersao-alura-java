import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) throws Exception {

        // enum de api
        var apiCriada = EnumAPI.LINGUAGEM;
        var apiNasa = EnumAPI.NASA;
        var apiIMDB = EnumAPI.IMDB;

        // enum de cores
        var azul = EnumCor.AZUL;
        var vermelho = EnumCor.VERMELHO;
        var reset = EnumCor.RESET;

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

        var http = new ClienteHttp();
        var json = http.buscaDados(apiCriada.url());

        var extraiConteudos =  apiCriada.extrator().extraiConteudos(json);

        var geradorDeSticker = new GeradorDeSticker();

        for (int i = 0; i < 3; i++){

            var conteudo = extraiConteudos.get(i);

            var inputStream = new URL(conteudo.urlImagem()).openStream();
            var nomeArquivo = "saida/" + conteudo.titulo() + ".png";

            geradorDeSticker.criarSticker(inputStream, nomeArquivo);

            System.out.println("Titulo: " + azul + conteudo.titulo() + reset);
            System.out.println("Data: " + vermelho + conteudo.data() + reset);
            System.out.println();

        }
    }
}
