package Models;

public class Puesto {

	private int id;
	private String nombre;
	private Double salarioDia;
	private Double pagoHExtra;
	
	
	public Puesto() {}


	public Puesto(int id, String nombre, Double salarioDia, Double pagoHExtra) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.salarioDia = salarioDia;
		this.pagoHExtra = pagoHExtra;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Double getSalarioDia() {
		return salarioDia;
	}


	public void setSalarioDia(Double salarioDia) {
		this.salarioDia = salarioDia;
	}


	public Double getPagoHExtra() {
		return pagoHExtra;
	}


	public void setPagoHExtra(Double pagoHExtra) {
		this.pagoHExtra = pagoHExtra;
	}


	@Override
	public String toString() {
		return "id:" + id + " | nombre=" + nombre + ", salarioDia=" + salarioDia + ", pagoHExtra=" + pagoHExtra;
	}
	
	
	
	
	
}
