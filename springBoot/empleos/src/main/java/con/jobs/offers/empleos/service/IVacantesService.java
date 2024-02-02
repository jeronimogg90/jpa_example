package con.jobs.offers.empleos.service;

import java.util.List;

import con.jobs.offers.empleos.model.Vacante;

public interface IVacantesService {
    List<Vacante> buscarTodas();
    Vacante buscarPorId(Integer idVacante);
}
