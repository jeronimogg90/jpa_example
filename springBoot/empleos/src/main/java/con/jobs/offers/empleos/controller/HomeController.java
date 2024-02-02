package con.jobs.offers.empleos.controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import con.jobs.offers.empleos.model.Vacante;
import con.jobs.offers.empleos.service.IVacantesService;

@Controller
public class HomeController {

    @Autowired
    private IVacantesService serviceVacantes;

    @GetMapping("/tabla")
    public String mostrarVacantes(Model model){
        List<Vacante> lista = this.serviceVacantes.buscarTodas();
        model.addAttribute("vacantes", lista);
        return "vacantes";
    }

    @GetMapping("/detalle")
    public String mostrarDetalle(Model model){
        Vacante vacante = new Vacante();
        vacante.setId(1);
        vacante.setNombre("Ingeniero de Sistemas");
        vacante.setDescripcion("Se solicita ingeniero de sistemas con experiencia en Java");
        vacante.setFecha(new Date());
        vacante.setSalario(8000.00);

        model.addAttribute("vacante", vacante);

        return "detalle";
    }

    @GetMapping("/listado")
    public String mostrarListado(Model model) {
        List<String> lista = new LinkedList<String>();
        lista.add("Ingeniero de Sistemas");
        lista.add("Ingeniero de Software");
        lista.add("Ingeniero de Telecomunicaciones");
        lista.add("Ingeniero de Redes");
        lista.add("Ingeniero de Seguridad");

        model.addAttribute("empleos", lista);

        return "listado";
    }
    
    @GetMapping("/")
    public String mostrarHome(Model model) {
        /* 
        model.addAttribute("titulo", "Bienvenido a la pagina de empleos");
        model.addAttribute("fecha", new Date());
        */

        String nombre = "Auxiliar de Contabiliad";
        Date fechaPub = new Date();
        double salario = 8000.00;
        boolean vigente = true;

        model.addAttribute("nombre", nombre);
        model.addAttribute("fechaPub", fechaPub);
        model.addAttribute("salario", salario);
        model.addAttribute("vigente", vigente);

        return "home";
    }
}
