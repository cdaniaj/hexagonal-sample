package br.com.architecture.hexagonal.mappers;

import br.com.architecture.hexagonal.domain.Movies;
import br.com.architecture.hexagonal.dto.MoviesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MoviesMapper {

    MoviesMapper INSTANCE = Mappers.getMapper(MoviesMapper.class);

    MoviesDTO moviesToMoviesDTO(Movies movies);

    Movies moviesDTOToMovies(MoviesDTO dto);

    List<MoviesDTO> moviesListToMoviesDTOs(List<Movies> moviesList);

    Movies moviesToMovies(Movies movies);

}
