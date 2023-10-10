package Controllers;

import Models.TipoEmpleado;
import Storage.MyData;

public class TipoEmpleadoController {

	
	public static void agregarTipoEmpleado(TipoEmpleado tipoEmpleado) {
		MyData.addTipoEmpleado(tipoEmpleado);
			
	}
	public static TipoEmpleado obtenerPorId(int id){
		return MyData.obtenerTipoEMpleadoPorId(id);
		
	}
}
