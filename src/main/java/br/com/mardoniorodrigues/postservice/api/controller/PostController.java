package br.com.mardoniorodrigues.postservice.api.controller;

import br.com.mardoniorodrigues.postservice.api.model.PostInput;
import br.com.mardoniorodrigues.postservice.api.model.PostOutput;
import br.com.mardoniorodrigues.postservice.api.model.PostSummaryOutput;
import br.com.mardoniorodrigues.postservice.domain.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService service;

    @PostMapping
    public ResponseEntity<PostOutput> create(@RequestBody PostInput input) {
        PostOutput output = service.create(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(output);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostOutput> findById(@PathVariable UUID postId) {
        return ResponseEntity.ok(service.findById(postId));
    }

    @GetMapping
    public PagedModel<PostSummaryOutput> list(@PageableDefault Pageable pageable) {
        return service.list(pageable);
    }

}
