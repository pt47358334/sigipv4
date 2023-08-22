package pe.com.pihuicho.sigip.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="pedido_detalle")
@Data
@NoArgsConstructor
public class PedidoDetalleEntity {

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pedido_detalle_id")
	private Integer codigo;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="pedido_id", nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
    private PedidoEntity pedido;
		
	@ManyToOne(targetEntity = ProductoEntity.class)
	@JoinColumn(name="producto_id")
	private ProductoEntity producto;
		
	@Column
	private Integer cantidad;
	
	@Column
	private String observaciones;
		
}
