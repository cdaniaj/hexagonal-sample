package br.com.architecture.hexagonal.ports.incoming;

import br.com.architecture.hexagonal.dto.MoviesDTO;

import java.util.List;

public interface MoviesUseCase {
    MoviesDTO create(MoviesDTO dto);

    List<MoviesDTO> list();

    MoviesDTO remove(int id) throws Exception;

    MoviesDTO update(MoviesDTO dto, int id) throws Exception;
}
