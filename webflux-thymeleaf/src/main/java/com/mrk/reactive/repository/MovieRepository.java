package com.mrk.reactive.repository;

import com.mrk.reactive.Movie;
import reactor.core.publisher.Flux;

public interface MovieRepository {

    Flux<Movie> findAll();

}
