package dia.digital.control.remision.enums;

public enum TipoDocumento {
	
	CC("Cedula"),
	TI("Tarjeta de Identidad");
	
	private String tipoDocumento;

	private TipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	
	@Override
	public String toString() {
		return this.tipoDocumento;
	}

}
