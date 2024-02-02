package net.empleosJpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.empleosJpa.model.Vacante;

public interface VacantesRespository extends JpaRepository<Vacante, Integer>{
    List<Vacante> findByEstatus(String estatus);
    List<Vacante> findByDestacadoAndEstatusOrderByIdDesc(Integer destacado, String estatus);
    List<Vacante> findBySalarioBetween(double salario, double salario2);
}
