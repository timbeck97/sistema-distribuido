package com.br.faccat.sistdist;

import com.br.faccat.sistdist.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
