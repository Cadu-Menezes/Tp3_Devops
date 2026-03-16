package br.com.infnet.ricknmortyapi.repository;

import br.com.infnet.ricknmortyapi.model.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;

/** Repository for Character entities. */
public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
}
