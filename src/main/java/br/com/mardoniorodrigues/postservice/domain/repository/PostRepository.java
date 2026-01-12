package br.com.mardoniorodrigues.postservice.domain.repository;

import br.com.mardoniorodrigues.postservice.domain.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {}
