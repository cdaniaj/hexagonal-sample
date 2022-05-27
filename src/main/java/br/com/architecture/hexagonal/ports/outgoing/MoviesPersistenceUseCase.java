package br.com.architecture.hexagonal.ports.outgoing;

import br.com.architecture.hexagonal.domain.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoviesPersistenceUseCase extends JpaRepository<Movies, Integer> {

    Movies save(Movies movies);

    List<Movies> findAll();

    void deleteById(Integer integer);
}
