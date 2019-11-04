package es.unileon.prg1.date;

public class MainDate {
	
	public static void main (String[] args) {
		
		Date today;
		boolean checkDay;
		int rest;
		String name,season,meses;
		
		
		try {
			today= new Date(24,10,2019);
			name = today.nameOfMonth(today.getMonth());
			checkDay = today.isDayRight();
			season = today.seasonOfMonth();
			rest = today.monthsLeft();
			meses = today.sameDaysOfMonth();
			
			
			
			System.out.println("Fecha:"+today.toString());
			System.out.print(name+"\n");
			System.out.println(checkDay+"\n");
			System.out.println(season+ "\n");
			System.out.println("Faltan "+rest+" meses para terminar el año\n");
			System.out.println("Fechas para final de mes: "+today.dateLeft()+"\n" );
			System.out.println("Meses con los mismos dias: "+meses+"\n");
			System.out.println("Días hasta la fecha: "+today.dayCounter()+"\n");
		}catch (DateException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}