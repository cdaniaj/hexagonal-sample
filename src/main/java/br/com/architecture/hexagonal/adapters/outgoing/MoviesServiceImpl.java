package br.com.architecture.hexagonal.adapters.outgoing;

import br.com.architecture.hexagonal.domain.Movies;
import br.com.architecture.hexagonal.dto.MoviesDTO;
import br.com.architecture.hexagonal.mappers.MoviesMapper;
import br.com.architecture.hexagonal.ports.incoming.MoviesUseCase;
import br.com.architecture.hexagonal.ports.outgoing.MoviesPersistenceUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<MoviesDTO> list() {
        return MoviesMapper.INSTANCE.moviesListToMoviesDTOs(this.moviesPersistenceUseCase.findAll());
    }

    @Override
    public MoviesDTO remove(int id) throws Exception {
        Optional<Movies> moviesopt = this.moviesPersistenceUseCase.findById(id);

        if(!moviesopt.isPresent())
             throw new Exception("Registro não existe");

        this.moviesPersistenceUseCase.deleteById(id);

        return MoviesMapper.INSTANCE.moviesToMoviesDTO(moviesopt.get());
    }

    @Override
    public MoviesDTO update(MoviesDTO dto, int id) throws Exception {
        Optional<Movies> moviesopt = this.moviesPersistenceUseCase.findById(id);

        if(!moviesopt.isPresent())
            throw new Exception("Registro não existe");

        Movies movies = this.moviesPersistenceUseCase
                .save(MoviesMapper.INSTANCE.moviesToMovies(moviesopt.get()));

        return MoviesMapper.INSTANCE.moviesToMoviesDTO(movies);
    }
}
