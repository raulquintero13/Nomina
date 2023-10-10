package Models;

public class Empleado {


	private int id;
	private String nombre;
	private String apellido;
	private int edad;
	private String domicilio;
	private double salario;
	private int pAcciones;
	private Puesto puesto;
	private TipoEmpleado tipoEmpleado;
	
	public Empleado() {}

	public Empleado(int id, String nombre, String apellido, int edad, String domicilio, double salario, int pAcciones,
			 Puesto puesto, TipoEmpleado tipoEmpleado) {
		
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.domicilio = domicilio;
		this.salario = salario;
		this.pAcciones = pAcciones;
		this.puesto = puesto;
		this.tipoEmpleado = tipoEmpleado;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getpAcciones() {
		return pAcciones;
	}

	public void setpAcciones(int pAcciones) {
		this.pAcciones = pAcciones;
	}

	public Puesto getPuesto() {
		return puesto;
	}

	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
	}

	public TipoEmpleado getTipoEmpleado() {
		return tipoEmpleado;
	}

	public void setTipoEmpleadoId(TipoEmpleado tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}

	@Override
	public String toString() {
		return ",tipoEmpleado: " + tipoEmpleado.getNombre() + " | id: " + id + " | " + nombre + " " + apellido + ", edad: " + edad
				+ ", domicilio: " + domicilio + ", salario: " + salario + ", porcentaje de acciones: " + pAcciones + 
				", puesto: " + puesto.getNombre();
	}

	
	

	
	

}
