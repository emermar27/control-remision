package dia.digital.control.remision.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="acceso")
@SequenceGenerator(name = "seq_acceso", sequenceName = "seq_acceso", initialValue = 1, allocationSize = 1)
public class Acceso implements GrantedAuthority{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_acceso")
	private Long id;
	
	@Column(name="des_acceso", nullable = false)
	private String des_acceso;

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDes_acceso() {
		return des_acceso;
	}

	public void setDes_acceso(String des_acceso) {
		this.des_acceso = des_acceso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Acceso other = (Acceso) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
