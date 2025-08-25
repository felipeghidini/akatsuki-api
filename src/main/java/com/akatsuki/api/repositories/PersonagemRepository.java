package com.akatsuki.api.repositories;

import com.akatsuki.api.entities.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
}
