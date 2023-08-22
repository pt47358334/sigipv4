package pe.com.pihuicho.sigip.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="categoria_producto")
@Data
@NoArgsConstructor
public class CategoriaEntity {

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CATEGORIA_PRODUCTO_ID")
	private Integer codigo;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="URL_IMAGEN")
	private String urlImagen;
	
	public CategoriaEntity(Integer codigo) {
		super();
		this.codigo = codigo;
	}
}
