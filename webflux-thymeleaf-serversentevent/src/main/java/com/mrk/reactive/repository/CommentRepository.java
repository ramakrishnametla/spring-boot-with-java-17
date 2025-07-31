package com.mrk.reactive.repository;

import com.mrk.reactive.model.Comment;
import reactor.core.publisher.Flux;

public interface CommentRepository {

    Flux<Comment> findAll();

}
