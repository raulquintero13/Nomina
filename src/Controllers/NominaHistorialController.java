package Controllers;

import java.util.Comparator;
import java.util.List;

import Models.Nomina;
import Storage.MyData;

public class NominaHistorialController {

	

	public static List<Nomina> porMeses() {
		List <Nomina> nominaHistorial = MyData.getNominaHistorial();
		nominaHistorial.sort(new Comparator < Nomina > () {
            @Override
            public int compare(Nomina n1, Nomina n2) {
                return n1.getTotalSueldoMes() > n2.getTotalSueldoMes() ? -1 : 1;
            }
        });
		return nominaHistorial;
	}

	public static List<Nomina> porTotalAsc() {
		List <Nomina> nominaHistorial = MyData.getNominaHistorial();

		nominaHistorial.sort(new Comparator < Nomina > () {
            @Override
            public int compare(Nomina n1, Nomina n2) {
                return n1.getTotalSueldoMes() > n2.getTotalSueldoMes() ? 1 : -1;
            }
        });		
		return nominaHistorial;
	}
	public static List<Nomina> porTotalDesc() {
		List <Nomina> nominaHistorial = MyData.getNominaHistorial();

		nominaHistorial.sort(new Comparator < Nomina > () {
            @Override
            public int compare(Nomina n1, Nomina n2) {
                return n1.getTotalSueldoMes() > n2.getTotalSueldoMes() ? -1 : 1;
            }
        });		
		return nominaHistorial;
	}
}
