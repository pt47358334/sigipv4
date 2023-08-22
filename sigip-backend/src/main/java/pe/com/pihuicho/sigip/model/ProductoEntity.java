package pe.com.pihuicho.sigip.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="producto")
@Data
@NoArgsConstructor
public class ProductoEntity {

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="producto_id")
	private Integer codigo;
	
	@Column
	private String titulo;
	
	@Column
	private String descripcion;
	
	@Column
	private Double precio;
	
	@Column(name="url_imagen")
	private String urlImagen;
		
	@ManyToOne(targetEntity = CategoriaEntity.class)
	@JoinColumn(name="categoria_producto_id")
	private CategoriaEntity categoria;
	
	public ProductoEntity(Integer codigo) {
		super();
		this.codigo = codigo;
	}
}
