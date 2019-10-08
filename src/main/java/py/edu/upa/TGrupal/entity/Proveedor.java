package py.edu.upa.TGrupal.entity;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "proveedor", schema = "public")
public class Proveedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "proveedor_id_proveedor_seq_1", sequenceName = "proveedor_id_proveedor_seq_1", allocationSize = 1, schema = "public")
	@GeneratedValue(generator = "proveedor_id_proveedor_seq_1")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_type")
	private Proveedor proveedor;

	public Proveedor() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String nombre_marca) {
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setType(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}


	

}