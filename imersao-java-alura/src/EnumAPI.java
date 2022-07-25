public enum EnumAPI {
    LINGUAGEM("https://linguagens-api-gustavo.herokuapp.com/linguagens", new ExtratorDeConteudoLinguagens()),
    NASA("https://api.mocki.io/v2/549a5d8b/NASA-APOD-JamesWebbSpaceTelescope", new ExtratorConteudoNasa()),
    IMDB("https://api.mocki.io/v2/549a5d8b/MostPopularTVs", new ExtratorConteudoIMDB());

    private final String url;
    private final ExtratorDeConteudo extrair;
    EnumAPI(String url, ExtratorDeConteudo extrair) {
        this.url = url;
        this.extrair = extrair;
    }
    public String url() {
        return url;
    }
    public ExtratorDeConteudo extrator() {
        return extrair;
    }
}
