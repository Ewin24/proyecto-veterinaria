package entity;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "pacientes")
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 100)
	private String nombre;

	@NotBlank
	@Size(max = 100)
	private String especie;

	@NotBlank
	@Size(max = 100)
	private String raza;

	@NotNull
	@Min(0)
	private Integer edad;

	@Lob
	private byte[] foto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;


	// Método para cargar la foto desde un archivo multipart
	public void cargarFoto(MultipartFile file) {
		try {
			this.foto = file.getBytes();
		} catch (IOException e) {
		}
	}

	// Método para obtener la foto como un array de bytes
	public byte[] getFoto() {
		return foto;
	}

	public Paciente(Long id, @NotBlank @Size(max = 100) String nombre, @NotBlank @Size(max = 100) String especie,
			@NotBlank @Size(max = 100) String raza, @NotNull @Min(0) Integer edad, byte[] foto, Usuario usuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.especie = especie;
		this.raza = raza;
		this.edad = edad;
		this.foto = foto;
		this.usuario = usuario;
	}

	public Paciente() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

}
