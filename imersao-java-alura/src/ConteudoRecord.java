public record ConteudoRecord(String titulo, String urlImagem, String data) {
    public ConteudoRecord(String titulo, String urlImagem, String data){
        this.titulo = titulo;
        this.urlImagem = urlImagem;
        this.data = data;
    }

    public String titulo(){
        return this.titulo;
    }

    public String urlImagem(){
        return this.urlImagem;
    }

    public String data(){
        return this.data;
    }
}