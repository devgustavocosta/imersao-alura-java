package br.com.alura.linguagensapi.repository;

import br.com.alura.linguagensapi.model.Linguagem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LinguagemRepository extends MongoRepository<Linguagem, String> {
}
