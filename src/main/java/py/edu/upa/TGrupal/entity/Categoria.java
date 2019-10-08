package py.edu.upa.TGrupal.entity;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="categoria", schema="public")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "categoria_id_categoria_seq_1", sequenceName = "categoria_id_categoria_seq_1", allocationSize = 1, schema= "public")
    @GeneratedValue(generator = "categoria_id_categoria_seq_1")
	private Integer id;
	private String descripcion;
	private String nombre;

	public Categoria() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setName(String nombre) {
		this.nombre = nombre;
	}
	


}