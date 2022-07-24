import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

public class GeradorDeSticker {

    public void criarSticker(InputStream inputStream, String nomeArquivo) throws Exception {

        // leitura da imagem
        var imagemOriginal = ImageIO.read(inputStream);

        // cria nova imagem em memoria com transparencia e tamanho novo
        var largura = imagemOriginal.getWidth();
        var altura = imagemOriginal.getHeight();
        var novaAltura = altura + 200;

        var novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para novo imagem (em memoria)
        Graphics2D imagemCopiada = (Graphics2D) novaImagem.getGraphics();
        imagemCopiada.drawImage(imagemOriginal, 0, 0, null);

        // configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        imagemCopiada.setColor(Color.LIGHT_GRAY);
        imagemCopiada.setFont(fonte);

        // escrever uma frase na nova imagem
        imagemCopiada.drawString("RECEBAAAA", 100, novaAltura - 100);

        // escrever a imagem nova em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }
}
