package net.empleosJpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.empleosJpa.model.Categoria;

public interface CategoriasRepository extends JpaRepository<Categoria, Integer> {
    
}
