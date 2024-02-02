package net.empleosJpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.empleosJpa.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
}
