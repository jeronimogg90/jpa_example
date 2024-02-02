package con.jobs.offers.empleos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import con.jobs.offers.empleos.model.Vacante;
import con.jobs.offers.empleos.service.IVacantesService;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

    @Autowired
    private IVacantesService serviceVacantes;

    @GetMapping("/delete")
    public String eliminar(@RequestParam("id") int idVacante){
        //Ejemplo url: http://localhost:8080/vacantes/delete?id=1
        System.out.println("Borrando vacante con idVacante: " + idVacante);
        return "vacantes/delete";
    }
    
    @GetMapping("/view/{id}")
    public String verDetalle(
        @PathVariable("id") int idVacante,
        Model model
    ){
        System.out.println("idVacante: " + idVacante);
        Vacante vacante = this.serviceVacantes.buscarPorId(idVacante);
        model.addAttribute("idVacante", idVacante);
        return "vacantes/detalle";
    }
}
