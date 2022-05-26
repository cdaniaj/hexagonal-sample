package br.com.architecture.hexagonal.ports.incoming;

import br.com.architecture.hexagonal.dto.MoviesDTO;

public interface MoviesUseCase {
    MoviesDTO create(MoviesDTO dto);
}
