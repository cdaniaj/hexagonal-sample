package br.com.architecture.hexagonal.adapters.incoming;

import br.com.architecture.hexagonal.adapters.outgoing.MoviesServiceImpl;
import br.com.architecture.hexagonal.dto.MoviesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<MoviesDTO> getAll() {
        return this.moviesService.list();
    }

    @PutMapping("/{id}")
    public MoviesDTO update(@RequestBody MoviesDTO request, @PathVariable int id) throws Exception {
        return this.moviesService.update(request, id);
    }

    @DeleteMapping("/{id}")
    public MoviesDTO remove(@PathVariable int id) throws Exception {
        return this.moviesService.remove(id);
    }
}
