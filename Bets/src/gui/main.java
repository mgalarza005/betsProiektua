package gui;

import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import configuration.ConfigXML;
import domain.Event;

public class main {

	public static void main(String[] args) throws MalformedURLException {
				
		ConfigXML c=ConfigXML.getInstance();
		boolean isLocal= c.isBusinessLogicLocal();
		BLFacade appFacadeInterface;
		LocalFactory f = new LocalFactory(isLocal);
		appFacadeInterface = f.createImplementation();
				
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date;
		try {date = sdf.parse("17/12/2020");  //17 del mes que viene
		ExtendedIterator<Event> i = appFacadeInterface.getEventsIter(date);
		Event e;
		System.out.println("_____________________");System.out.println("ATZETIK AURRERAKA");
		i.goLast();//Azkenekoelementuankokatu
		while (i.hasPrevious()) {
			e = i.previous();
			System.out.println(e.toString());
		}
		System.out.println();System.out.println("_____________________");System.out.println("AURRETIK ATZERAKA");
				i.goFirst(); // Lehenelem. kokatu
		while (i.hasNext()) {
			e = i.next();
			System.out.println(e.toString());
		}
		} catch (ParseException e1) {
			System.out.println("Problemswith date?? " + "17/12/2020");
		}
	}
}
