package net.empleosJpa;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.empleosJpa.model.Categoria;
import net.empleosJpa.model.Perfil;
import net.empleosJpa.model.Usuario;
import net.empleosJpa.model.Vacante;
import net.empleosJpa.repository.CategoriasRepository;
import net.empleosJpa.repository.PerfilesRepository;
import net.empleosJpa.repository.UsuarioRepository;
import net.empleosJpa.repository.VacantesRespository;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner{

	@Autowired
	private CategoriasRepository repository;
	@Autowired
	private VacantesRespository vacantesRepository;
	@Autowired
	private PerfilesRepository perfilesRepository;
	@Autowired
	private UsuarioRepository usuariosRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("************************ Empiezan las categorias ****************************");
		verTodos();
		buscarPorId();
		guardar();
		eliminar();
		System.out.println("************************ Empiezan las vacantes ****************************");
		//guardarVacante(); // Solo se ejecuta una vez
		buscarVacantesPorEstatus("Aprobada");
		buscarVacantePorDestacadoEstatus();
		buscarVacantesEntreSalarios();
		buscarVacantes();
		eliminarVacantes();
		System.out.println("************************ Empiezan los perfiles ****************************");
		//crearPerfilesApp(); // Solo se ejecuta una vez
		System.out.println("****************************************************");
		System.out.println("************************ Empiezan los usuarios ****************************");
		///crearUsuariosAppConDosPerfiles(); // Solo se ejecuta cuando queremos crear un usuario
		buscarUsuario();
		System.out.println("****************************************************");
	}

	private void guardar(){
		System.out.println("Insertando un registro");
		Categoria categoria = new Categoria();
		categoria.setNombre("Categoria 1");
		categoria.setDescripcion("Descripcion 1");
		repository.save(categoria);
	}

	private void buscarPorId(){
		System.out.println("Buscando un registro");
		Categoria categoria = repository.findById(1).get();
		System.out.println(categoria.getId());
		System.out.println(categoria.getNombre());
		System.out.println(categoria.getDescripcion());
	}

	private void eliminar(){
		System.out.println("Eliminando un registro");
	}

	private void verTodos(){
		System.out.println("Ver todos los registros");
		Iterable<Categoria> categorias = repository.findAll();
		for(Categoria categoria: categorias){
			System.out.println(categoria.getId());
			System.out.println(categoria.getNombre());
			System.out.println(categoria.getDescripcion());
		}
		System.out.println("----------- FIN de VerTodos -----------------");
	}

	private void buscarVacantes(){
		System.out.println("Buscando vacantes");
		List<Vacante> vacantes = vacantesRepository.findAll();
		for(Vacante v: vacantes){
			System.out.print(v.getId());
			System.out.print(" - ");
			System.out.print(v.getNombre());
			System.out.print(" - ");
			System.out.println(v.getCategoria().getNombre());
		}
	}

	private void guardarVacante(){
		System.out.println("Guardando vacante");
		Vacante vacante = new Vacante();
		vacante.setNombre("Ingeniero de Sistemas");
		vacante.setDescripcion("Se solicita ingeniero de sistemas para trabajar en el area de desarrollo");
		vacante.setFecha("2020-01-01");
		vacante.setSalario(10000.0);
		vacante.setDestacado(1);
		vacante.setImagen("noimage.png");
		vacante.setEstatus("Aprobada");
		vacante.setDetalles("<h1>Los detalles de la vacante</h1>");
		Categoria categoria = new Categoria();
		categoria.setId(2);
		vacante.setCategoria(categoria);
		vacantesRepository.save(vacante);
	}

	private void crearPerfilesApp(){
		System.out.println("Creando perfiles de la aplicacion");
		List<Perfil> perfiles = obtenerPerfilesApp();
		perfilesRepository.saveAll(perfiles);
	}

	private List<Perfil> obtenerPerfilesApp(){
		System.out.println("Obteniendo perfiles de la aplicacion");
		
		List<Perfil> perfiles = new LinkedList<Perfil>();
		Perfil per1 = new Perfil();
		per1.setPerfil("SUPERVISOR");

		Perfil per2 = new Perfil();
		per2.setPerfil("USUARIO");

		Perfil per3 = new Perfil();
		per3.setPerfil("ADMINISTRADOR");

		perfiles.add(per1);
		perfiles.add(per2);
		perfiles.add(per3);

		return perfiles;
	}

	private void crearUsuariosAppConDosPerfiles(){
		System.out.println("Creando usuarios de la aplicacion");
		Usuario user = new Usuario();
		user.setNombre("Juan");
		user.setUsername("juanApp");
		user.setPassword("123");
		user.setEmail("juan@juan.com");
		user.setEstatus(1);
		user.setFechaRegistro(new Date());

		Perfil per1 = new Perfil();
		per1.setId(2);

		Perfil per2 = new Perfil();
		per2.setId(3);

		user.agregar(per1);
		user.agregar(per2);

		usuariosRepository.save(user);
		System.out.println("----------- FIN de crearUsuariosAppConDosPerfiles -----------------");
	}

	public void buscarUsuario(){
		System.out.println("Buscando usuario");
		Usuario user = usuariosRepository.findById(1).get();
		System.out.println(user.getNombre());
		System.out.println(user.getUsername());
		System.out.println(user.getEmail());
		System.out.print("Perfiles: ");
		for(Perfil p: user.getPerfiles()){
			System.out.print(p.getPerfil() + ", ");
		}
		System.out.println("");
		System.out.println("----------- FIN de buscarUsuario -----------------");
	}

	private void buscarVacantesPorEstatus(String estatus){
		System.out.println("Buscando vacantes por estatus");
		List<Vacante> vacantes = vacantesRepository.findByEstatus(estatus);
		for(Vacante v: vacantes){
			System.out.print(v.getId());
			System.out.print(" - ");
			System.out.print(v.getNombre());
			System.out.print(" - ");
			System.out.println(v.getCategoria().getNombre());
		}
		System.out.println("----------- FIN de buscarVacantesPorEstatus -----------------");
	}

	private void eliminarVacantes(){
		System.out.println("Eliminando vacantes");
		List<Vacante> vacantes = vacantesRepository.findAll();
		for(Vacante v: vacantes){
			if(v.getId() > 14){
				vacantesRepository.delete(v);
			}
		}
		System.out.println("----------- FIN de eliminarVacantes -----------------");
	}

	private void buscarVacantePorDestacadoEstatus(){
		System.out.println("Buscando vacantes por destacado y estatus");
		List<Vacante> vacantes = vacantesRepository.findByDestacadoAndEstatusOrderByIdDesc(1, "Aprobada");
		for(Vacante v: vacantes){
			System.out.print(v.getId());
			System.out.print(" - ");
			System.out.print(v.getNombre());
			System.out.print(" - ");
			System.out.println(v.getCategoria().getNombre());
		}
		System.out.println("----------- FIN de buscarVacantePorDestacadoEstatus -----------------");
	}

	private void buscarVacantesEntreSalarios(){
		System.out.println("Buscando vacantes entre salarios");
		List<Vacante> vacantes = vacantesRepository.findBySalarioBetween(10000.0, 20000.0);
		for(Vacante v: vacantes){
			System.out.print(v.getId());
			System.out.print(" - ");
			System.out.print(v.getNombre());
			System.out.print(" - ");
			System.out.println(v.getCategoria().getNombre());
			System.out.println("Salario: "+v.getSalario());
		}
		System.out.println("----------- FIN de buscarVacantesEntreSalarios -----------------");
	}

}
