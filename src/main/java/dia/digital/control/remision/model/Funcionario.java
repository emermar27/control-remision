package dia.digital.control.remision.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import dia.digital.control.remision.enums.TipoDocumento;

@Entity
@Table(name="funcionario")
@PrimaryKeyJoinColumn(name = "id")
public class Funcionario extends Persona {

	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	private String estado;
	
	@Temporal(TemporalType.DATE)
	private Date fecha_registro;
	
	@ManyToOne(targetEntity = Cargo.class)
	@JoinColumn(name = "cargo_id", nullable = false, foreignKey = @ForeignKey(value=ConstraintMode.CONSTRAINT, name="cargo_fk"))
	private Cargo cargo;
	
	@Column(name = "tipo_documento")
	@Enumerated(EnumType.STRING)
	private TipoDocumento tipo_documento;

	public TipoDocumento getTipo_documento() {
		return tipo_documento;
	}
	
	public void setTipo_documento(TipoDocumento tipo_documento) {
		this.tipo_documento = tipo_documento;
	}
	
	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	
	

}
