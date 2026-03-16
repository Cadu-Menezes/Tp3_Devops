package br.com.infnet.ricknmortyapi;

import br.com.infnet.ricknmortyapi.model.Personagem;
import br.com.infnet.ricknmortyapi.repository.PersonagemRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** REST controller for character endpoints. */
@RequestMapping("/api/characters")
@RestController
@Slf4j
@RequiredArgsConstructor
public final class CharacterController {
    /** Repository used to access character data. */
    private final PersonagemRepository repository;

    /**
     * Returns all characters and includes total count in response headers.
     *
     * @param page requested page number header
     * @param size requested page size header
     * @return list of characters with total count header
     */
    @GetMapping
    public ResponseEntity<?> getAllCharacters(
            @RequestHeader(
                value = "page",
                defaultValue = "0") final String page,
            @RequestHeader(
                value = "size",
                defaultValue = "10") final String size) {
        log.info("page: {} size: {}", page, size);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Total-Count", String.valueOf(repository.count()));
        List<Personagem> allCharacters = repository.findAll();
        return new ResponseEntity<>(allCharacters, headers, HttpStatus.OK);
    }
}
