package br.com.architecture.hexagonal.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MoviesDTO {

    private int id;

    private String name;

    private String origin;

    private String description;

    private String releasedAt;
}
