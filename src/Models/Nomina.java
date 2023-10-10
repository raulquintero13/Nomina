package Models;

public class Nomina {

	private int id;
	private int year;
	private int month;
	private int empleadoId;
	private Empleado empleado;
	private int tipoEmpleado;
	private int diasTrabajados;//<=20 dias x mes
	private double sueldoDia;
	private int horasExtras; // <= 40 hrs x mes 
	private double pagoHExtra; 
	private double totalSueldo;
	private double totalHExtras;
	private double totalSueldoMes;
	
	public Nomina() {
	}

	public Nomina(int id, int year, int month, int diasTrabajados, double sueldoDia, int horasExtras, double pagoHExtra,
			double totalSueldo, double totalHExtras, double totalSueldoMes) {
		this.id = id;
		this.year = year;
		this.month = month;
		this.diasTrabajados = diasTrabajados;
		this.sueldoDia = sueldoDia;
		this.horasExtras = horasExtras;
		this.pagoHExtra = pagoHExtra;
		this.totalSueldo = totalSueldo;
		this.totalHExtras = totalHExtras;
		this.totalSueldoMes = totalSueldoMes;
	}
	

	

	@Override
	public String toString() {
		return "| " + empleado.getId() + " | " +empleado.getTipoEmpleado().getNombre()+ " | " + year + " | " + month + " | " 
				+ empleado.getNombre() + " " + empleado.getApellido()+ " | "+empleado.getTipoEmpleado().getNombre()+" |dT: " 
				+  diasTrabajados + " |sD: " + sueldoDia + " |hEx: "
				+ horasExtras + " | pagoHExtra:" + pagoHExtra + " |  tSueldo" + totalSueldo + " | tHExtras:"
				+ totalHExtras + " | tSMes=" + totalSueldoMes ;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public int getTipoEmpleado() {
		return tipoEmpleado;
	}

	public void setTipoEmpleado(int tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}

	public int getEmpleadoId() {
		return empleadoId;
	}

	public void setEmpleadoId(int empleadoId) {
		this.empleadoId = empleadoId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDiasTrabajados() {
		return diasTrabajados;
	}

	public void setDiasTrabajados(int diasTrabajados) {
		this.diasTrabajados = diasTrabajados;
	}

	public double getSueldoDia() {
		return sueldoDia;
	}

	public void setSueldoDia(double sueldoDia) {
		this.sueldoDia = sueldoDia;
	}

	public int getHorasExtras() {
		return horasExtras;
	}

	public void setHorasExtras(int horasExtras) {
		this.horasExtras = horasExtras;
	}

	public double getPagoHExtra() {
		return pagoHExtra;
	}

	public void setPagoHExtra(double pagoHExtra) {
		this.pagoHExtra = pagoHExtra;
	}

	public double getTotalSueldo() {
		return totalSueldo;
	}

	public void setTotalSueldo(double totalSueldo) {
		this.totalSueldo = totalSueldo;
	}

	public double getTotalHExtras() {
		return totalHExtras;
	}

	public void setTotalHExtras(double totalHExtras) {
		this.totalHExtras = totalHExtras;
	}

	public double getTotalSueldoMes() {
		return totalSueldoMes;
	}

	public void setTotalSueldoMes(double totalSueldoMes) {
		this.totalSueldoMes = totalSueldoMes;
	}
	
	
	
	
}
