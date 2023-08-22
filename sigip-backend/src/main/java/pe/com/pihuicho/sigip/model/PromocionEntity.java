package pe.com.pihuicho.sigip.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="promocion")
@Data
@NoArgsConstructor
public class PromocionEntity {

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="promocion_id")
	private Integer codigo;
	
	@Column
	private String titulo;
	
	@Column(name="url_imagen")
	private String urlImagen;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="promocion_id")
    private List<PromocionDetalleEntity> productos;
	
	public PromocionEntity(Integer codigo) {
		super();
		this.codigo = codigo;
	}
}
