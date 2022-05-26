package br.com.architecture.hexagonal.adapters.incoming;

import br.com.architecture.hexagonal.adapters.outgoing.MoviesServiceImpl;
import br.com.architecture.hexagonal.dto.MoviesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/movies")
public class MoviesController {

    @Autowired
    private MoviesServiceImpl moviesService;

    @PostMapping
    public void create(@RequestBody MoviesDTO request) {
        this.moviesService.create(request);
    }
}
