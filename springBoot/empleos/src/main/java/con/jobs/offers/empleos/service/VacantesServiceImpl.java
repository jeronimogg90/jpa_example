package con.jobs.offers.empleos.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import con.jobs.offers.empleos.model.Vacante;

@Service
public class VacantesServiceImpl implements IVacantesService{
    private List<Vacante> lista = null;

    public VacantesServiceImpl() {
        // TODO Auto-generated constructor stub
        lista = new LinkedList<Vacante>();
        Vacante vacante1 = new Vacante();
        vacante1.setId(1);
        vacante1.setNombre("Ingeniero de Sistemas");
        vacante1.setDescripcion("Se solicita ingeniero de sistemas con experiencia en Java");
        vacante1.setFecha(new Date());
        vacante1.setSalario(8000.00);
        vacante1.setDestacado(1);

        Vacante vacante2 = new Vacante();
        vacante2.setId(2);
        vacante2.setNombre("Ingeniero de Software");
        vacante2.setDescripcion("Se solicita ingeniero de software con experiencia en Java");
        vacante2.setFecha(new Date());
        vacante2.setSalario(9000.00);
        vacante2.setDestacado(0);

        Vacante vacante3 = new Vacante();
        vacante3.setId(3);
        vacante3.setNombre("Ingeniero de Redes");
        vacante3.setDescripcion("Se solicita ingeniero de redes con experiencia en Cisco");
        vacante3.setFecha(new Date());
        vacante3.setSalario(10000.00);
        vacante3.setDestacado(0);

        lista.add(vacante1);
        lista.add(vacante2);
        lista.add(vacante3);
    }

    @Override
    public List<Vacante> buscarTodas() {
        // TODO Auto-generated method stub
        return lista;
    }

    @Override
    public Vacante buscarPorId(Integer idVacante) {
        // TODO Auto-generated method stub
        for(Vacante vacante: lista){
            if(vacante.getId() == idVacante){
                return vacante;
            }
        }
        return null;
    }
    
}
