package br.com.alura.linguagensapi.controller;


import br.com.alura.linguagensapi.model.Linguagem;
import br.com.alura.linguagensapi.repository.LinguagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class LinguagensController {

    @Autowired
    private LinguagemRepository linguagemRepository;

    @GetMapping("/linguagens")
    public List<Linguagem> obterLinguagens() {
        List<Linguagem> linguagens = linguagemRepository.findAll();
        return linguagens;
    }

    @PostMapping("/linguagens")
    public Linguagem cadastrarLinguagem(@RequestBody Linguagem linguagem) {
        Linguagem linguagemSalva = linguagemRepository.save(linguagem);
        return linguagemSalva;
    }

}
