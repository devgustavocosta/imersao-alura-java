import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoLinguagens implements ExtratorDeConteudo{
    public List<ConteudoRecord> extraiConteudos(String json){

        // extrair só os dados que interessam
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        List<ConteudoRecord> conteudos = new ArrayList<>();

        for (Map<String, String> atributos : listaDeAtributos) {
            var titulo =  atributos.get("title");
            var urlImagem =  atributos.get("image");
            var rating = atributos.get("rating");

            var conteudo = new ConteudoRecord(titulo, urlImagem, rating);

            conteudos.add(conteudo);
        }

        return conteudos;


    }
}
