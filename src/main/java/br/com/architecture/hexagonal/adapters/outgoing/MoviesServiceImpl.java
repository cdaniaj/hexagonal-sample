package br.com.architecture.hexagonal.adapters.outgoing;

import br.com.architecture.hexagonal.domain.Movies;
import br.com.architecture.hexagonal.dto.MoviesDTO;
import br.com.architecture.hexagonal.mappers.MoviesMapper;
import br.com.architecture.hexagonal.ports.incoming.MoviesUseCase;
import br.com.architecture.hexagonal.ports.outgoing.MoviesPersistenceUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoviesServiceImpl implements MoviesUseCase {

    @Autowired
    private MoviesPersistenceUseCase moviesPersistenceUseCase;

    @Override
    public MoviesDTO create(MoviesDTO dto) {
        Movies movies = MoviesMapper.INSTANCE.moviesDTOToMovies(dto);
        this.moviesPersistenceUseCase.save(movies);

        return dto;
    }
}
