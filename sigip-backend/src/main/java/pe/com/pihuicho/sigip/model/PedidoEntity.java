package pe.com.pihuicho.sigip.model;

import java.util.Date;
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
@Table(name="pedido")
@Data
@NoArgsConstructor
public class PedidoEntity {

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pedido_id")
	private Integer codigo;
	
	@Column(name="fecha")
	private Date fecha;
	
	@Column(name="cliente")
	private String cliente;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="pedido_id")
    private List<PedidoDetalleEntity> productos;
	
	public PedidoEntity(Integer codigo) {
		super();
		this.codigo = codigo;
	}
}
