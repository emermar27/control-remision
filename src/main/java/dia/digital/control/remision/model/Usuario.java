package dia.digital.control.remision.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="usuario")
@SequenceGenerator(name =" seq_usuario", sequenceName = "seq_usuario", allocationSize = 1, initialValue = 1)
public class Usuario implements UserDetails {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_usuario")
	private Long id;
	
	private String login;
	
	private String password;
	
	@Temporal(TemporalType.DATE)
	private Date fecha_reg_password;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuarios_accesso", uniqueConstraints = @UniqueConstraint (columnNames = {"usuario_id", "accesso_id"} ,
	 name = "unique_accesso_user"), 
	joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id", table = "usuario", 
	unique = false, foreignKey = @ForeignKey(name = "usuario_fk", value = ConstraintMode.CONSTRAINT)), 
	inverseJoinColumns = @JoinColumn(name = "accesso_id", unique = false, referencedColumnName = "id", table = "accesso",
	foreignKey = @ForeignKey(name = "acceso_fk", value = ConstraintMode.CONSTRAINT)))
	private List<Acceso> accesos;

	/*Autoridades son los accesos o sea ROLE_ADMIN, ROLE_SECRETARIO, ROLE_FINANCIERO*/
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.accesos;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
