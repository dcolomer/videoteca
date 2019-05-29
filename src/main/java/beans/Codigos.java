package beans;

import java.io.Serializable;

public class Codigos implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String codigo;
	private String valor;
	
	public Codigos() {}
	
	public Codigos(String codigo, String valor)
	{
		this.setCodigo(codigo);
		this.setValor(valor);
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
}