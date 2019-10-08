package py.edu.upa.TGrupal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "producto", schema = "public")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "producto_id_producto_seq", sequenceName = "producto_id_producto_seq", allocationSize = 1, schema = "public")
	@GeneratedValue(generator = "producto_id_producto_seq")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_type")
	private Producto producto;

	private Boolean delete;

	private String description;

	private Boolean estado;

	@Column(name = "limit_date")
	private Timestamp limitDate;

	private String name;

	@Column(name = "update_date")
	private Timestamp updateDate;

	private String descripcion;

	public Producto() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getDeleted() {
		return this.delete;
	}

	public void setDeleted(Boolean delete) {
		this.delete = delete;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String descripcion) {
		this.setDescripcion(descripcion);
	}

	public Timestamp getLimitDate() {
		return this.limitDate;
	}

	public void setLimitDate(Timestamp limitDate) {
		this.limitDate = limitDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setType(Producto producto) {
		this.producto = producto;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}