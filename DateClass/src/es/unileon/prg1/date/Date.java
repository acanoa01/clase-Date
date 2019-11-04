package es.unileon.prg1.date;

/**
*	Clase que representa una fecha
*
*	@author Alberto Cano Alvarez
*	@version 1.0
*/

public class Date {
	
	/**
	 * Valor del dia
	 * 
	 * Valor del mes
	 * 
	 * Valor del año
	 */
	
	private int day;
	private int month;
	private int year;
	
	 /////////////////////////////
	//Constructores de la clase//
   /////////////////////////////	
	
	/**
	 * Constructor de la clase. Construye un objeto de tipo Date
	 * 
	 * @param day
	 * 	Valor del dia
	 * 
	 * @param month
	 * 	Valor del mes
	 * 
	 * @param year
	 * 	Valor del año
	 * 
	 */
	public Date (int day, int month, int year) throws DateException {
		if(month<0 || month>12) {
			throw new DateException("Mes introducido no válido: "+month+", valores entre 1 y 12");
		}else if( day>this.daysOfMonth(month)) {
			throw new DateException ("Dia introducido no válido: "+day+",valores entre 1 y 31");
		}else {
			this.day = day;
			this.month = month;
			this.year = year;
		}
	}
	/**
	 * 
	 */
	public Date() {
		this.day = 1;
		this .month = 1;
		this.year = 2019;
	}
	/**
	 * Constructor que devuele un objeto que es una copia del objeto de tipo Date
	 * @param other
	 */
	public Date(Date other) {
		this.day=other.getDay();
		this.month=other.getMonth();
		this.month=other.getYear();
	}
	/**
	 * 
	 * @return
	 */
	
	 /////////////////////
	//Métodos Set y Get//
   /////////////////////
	
	/**
	 * Método getDay. 
	 * 
	 * @return
	 * 	Devuelve el dia
	 *  
	 */
	public int getDay() {
		return this.day;
	}
	
	/**
	 * Metodo setDay
	 * @param day
	 */
	
	public void setDay(int day) {
		this.day= day;
	}
	/**
	 * Método getMonth
	 * @return
	 */
	public int getMonth() {
		return this.month;
	}
	
	/**
	 * 
	 * @param month
	 */
	public void setMonth(int month) {
		this.month=month;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getYear() {
		return this.year;
	}
	/**
	 * 
	 * @param year
	 */
	public void setYear( int year ) {
		this.year= year;
	}
	
	 //////////////////
	//Métodos isSame//
   //////////////////
	
	/**
	 * 
	 * @param año
	 * @return
	 
	public boolean isSameYear( Date año) {
		boolean equal;
			if(this.year==año.getYear()) {
				equal=true;
			}else {
					equal=false;
				}
		return equal;	
	}
	*/
	public boolean isSameYear(Date mismaFecha) {
		String year1 = String.valueOf(year);
		String year2 = String.valueOf(mismaFecha.getYear() );
		return year1.equals(year2);
	}
	/**
	 * 
	 * @param month
	 * @return
	 
	public boolean isSameMonth( Date month) {
		boolean equal;
			if(this.month==month.getMonth()) {
				equal = true;
			}else {
				equal = false;
			}
			return equal;
	}
	*/
	public boolean isSameMonth(Date mismaFecha) {
		String month1 = String.valueOf(month);
		String month2 = String.valueOf(mismaFecha.getMonth() );
		return month1.equals(month2);
	}
	/**
	 * 
	 * @param day
	 * @return
	 
	public boolean isSameDay(Date day) {
		boolean equal;
		if(this.day==day.getDay()) {
			equal=true;
		}else {
			equal = false;
		}
		return equal;
	}
	*/
	public boolean isSameDay(Date mismaFecha) {
		String day1 = String.valueOf(day);
		String day2 = String.valueOf(mismaFecha.getDay() );
		return day1.contentEquals(day2);
	}
	/**
	 * 
	 * @param mismaFecha
	 * @return
	 */
	public boolean isSame(Date mismaFecha) {
		return (this.isSameDay(mismaFecha) && this.isSameMonth(mismaFecha) && this.isSameYear(mismaFecha));
	}
	/**
	 * 	
	 * 	Método nameOfMonth de tipo String
	 * @param month
	 * @return name
	 * 	Devuelve el nombre del mes introducido
	 */
	public String nameOfMonth(int month) {
		
		String name;
			switch (month) {
			case 1:
				name = "Enero";
				break;
			case 2:
				name="Febrero";
				break;
			case 3:
				name="Marzo";
				break;
			case 4:
				name="Abril";
				break;
			case 5: 
				name="Mayo";
				break;
			case 6:
				name="Junio";
				break;
			case 7:
				name="Julio";
				break;
			case 8:
				name="Agosto";
				break;
			case 9: 
				name="Septiembre";
				break;
			case 10:
				name="Octubre";
				break;
			case 11:
				name="Noviembre";
				break;
			case 12:
				name="Diciembre";
				break;
			default:
				name=null;
			}
			return name;	
	}
			
	/**
	 * 
	 * @return
	 */
	boolean isDayRight() {
		
		boolean right = false;
		
		switch(month) {
		case 1:	//next
		case 3:	//next
		case 5:	//next
		case 7:	//next
		case 8:	//next
		case 10:	//next
		case 12:
			if( (this.day<=31) || (this.day>0)) 
				right = true;
			break;
		case 2:	//next
			if( (this.day<=28) || (this.day>0)) 
				right = true;
			break;
		
		case 4:	//next	
		case 6:	//next
		case 9://next
		case 11: 
			if( (this.day<=30) || (this.day>0)) 
				right = true;
		default:
			right = false;
		}
		return right;
	}
	public boolean isDayRight(int day) {
		return (day>0 && day<=this.daysOfMonth(month));
	}
	/**
	 * 
	 * @return
	 */
	public int daysOfMonth(int month) {
		int day;
		
			switch(month) {
			case 1:	//next
			case 3:	//next
			case 5:	//next
			case 7:	//next
			case 8:	//next
			case 10:	//next
			case 12:
				day = 31;
				break;
			case 2:	//next
				day = 28;
				break;
			
			case 4:	//next	
			case 6:	//next
			case 9://next
			case 11: 
				day=30;
			default:
				day = 0;
			}
			return day;
	}
	/**
	 * 
	 * @return
	 */
	public int daysOfMonth() {
		return this.daysOfMonth(this.month);
	}
	/**
	 * 	
	 * @return
	 */
	public String seasonOfMonth() {
		String season = null;
		switch (this.month) {
			case 1:	//next
			case 2:	
				season = "Invierno";
				break;
			case 3:
				if(this.day<=21) {
					season = "Invierno";
				}else {
					season = "Primavera";
				}
			case 4:	
			case 5:	
				season = "Primvavera";
			case 6:	
				if(this.day<=21) {
					season = "Primavera";
				}else {
					season = "Verano";
				}
			case 7:
			case 8:	
				season = "Verano";
				break;
			case 9:	
				if(this.day<=21) {
					season = "Verano";
				}else {
					season = "Otoño";
				}
			case 10:	
			case 11:
				season = "Otoño";
			case 12: 
				if(this.day<=21) {
					season = "Otoño";
				}else {
					season = "Invierno";
				}
			default:
				season = null;
		}
		return season;
	}
	/**
	 * 
	 * @return
	 */
	public int monthsLeft() {
		int contador =0;
		for(int i=this.month+1; i<=12;i++) {
			contador++;
		}
		return contador;
	}
	/**
	 * 
	 * @return
	 */
public Date nextDay() throws DateException {
		Date nextDay = null;
		int day,month,year;
		day = this.day;
		month = this.month;
		year = this.year;
			
			day++;
			if(day>this.daysOfMonth(month)) {
				day = 1;
				month++;
				if(month>12) {
					month = 1;
					year++;
				}
			}
		nextDay = new Date(day,month,year);
		return nextDay;
	}
/**
 * 
 * @return
 */
	public String dateLeft() throws DateException{
		Date next = nextDay();
		StringBuffer dayLeft = new StringBuffer();
		for(int i= next.getDay();isDayRight(i);i++) {
			next.setDay(i);
			dayLeft.append(next.toString()+" ");
		}
		return dayLeft.toString();
	}
	/**
	 * 
	 * @return
	 */
	public String sameDaysOfMonth(){
		Date same = new Date(this);
		StringBuffer igual = new StringBuffer();
		for(int i=1;i<=12;i++) {
			same.setMonth(i);
			if(same.daysOfMonth()==this.daysOfMonth() ) {
				igual.append(same.getMonth()+" ");
			}
		}
		return igual.toString();
	}
	/**
	 * 
	 * @return
	 * @throws DateException
	 */
	public int dayCounter() throws DateException{
		int counter;
		counter = 0;
		Date aux = new Date(1,1,this.year);
		for(int i=1;i<=this.month;i++) {
			counter+=aux.daysOfMonth(i);
			aux.setMonth(i+1);
		}
		return (counter + this.day-1);
	}
	/**
	 * 
	 * @param day
	 * @return
	 */
	public String nameDaysWeek(int day) {
		String name = " ";
		switch(day) {
		case 1:
			name = "Lunes";
			break;
		case 2:
			name = "Martes";
			break;
		case 3:
			name = "Miercoles";
			break;
		case 4:
			name = "Jueves";
			break;
		case 5:
			name = "Viernes";
			break;
		case 6:
			name = "Sabado";
			break;
		case 7:
			name = "Domingo";
			break;
		}
		return name;
	}
	/**
	 * 
	 * @return
	 * @throws DateException
	 */
	public int attempsCounterV1() throws DateException{
	int intentos,day,month,year;
	intentos =0;
		do {
			month = (int)(Math.random()*12)+1;
			day = (int)(Math.random()*this.daysOfMonth(month))+1;
			year = this.year;
			intentos++;
		}while(!this.isSame(new Date(day,month,year)));
		return intentos;
	}
	/**
	 * 
	 * @return
	 * @throws DateException
	 */
	public int attempsCounterV2() throws DateException {
		int intentos,day,month,year;
		Date date = null;
		intentos =0;
			
				month = (int)(Math.random()*12)+1;
				day = (int)(Math.random()*this.daysOfMonth(month))+1;
				year = this.year;
				date = new Date(day,month,year);
				intentos++;
					while(!this.isSame(date)) {
					month = (int)(Math.random()*12)+1;
					day = (int)(Math.random()*this.daysOfMonth(month))+1;
					year = this.year;
					date = new Date(day,month,year);
					intentos++;
					}
			return intentos;
	}
	/**
	 * 
	 * @param day1
	 * @return
	 * @throws DateException
	 */
	public String guessName(int day1) throws DateException{
		int numeroDia;
		numeroDia = (dayCounter()% 7 +day1)%7;
		return nameDaysWeek(numeroDia);
	}
	/**
	 * Método ToString
	 * 
	 * @return
	 * 	Devuelve la fecha completa	
	 */
	public String toString() {
		StringBuffer salida  = new StringBuffer();
		salida.append(this.day+"/");
		salida.append(this.month+"/");
		salida.append(this.year);
		
		return salida.toString();
		
	}
	
}