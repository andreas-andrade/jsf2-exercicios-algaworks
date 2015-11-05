import javax.faces.bean.ManagedBean;


@ManagedBean
public class TesteBean {
	private Integer valor;
	private String texto;
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
}
