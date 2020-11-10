package gui;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import configuration.ConfigXML;

public class LocalFactory {
	private boolean isLocal; 
	
	
	public LocalFactory(boolean isLocal) {
		super();
		this.isLocal = isLocal;
	}


	public void createImplementation() throws MalformedURLException {
		ConfigXML c=ConfigXML.getInstance();
		BLFacade appFacadeInterface;
		if(this.isLocal) {
			appFacadeInterface =new BLFacadeImplementation();
			
		}else {
			//String serviceName="http://localhost:9999/ws/ruralHouses?wsdl";
			String serviceName= "http://"+c.getBusinessLogicNode() +":"+ c.getBusinessLogicPort()+"/ws/"+c.getBusinessLogicName()+"?wsdl";

			//URL url = new URL("http://localhost:9999/ws/ruralHouses?wsdl");
			URL url = new URL(serviceName);


			//1st argument refers to wsdl document above
			//2nd argument is service name, refer to wsdl document above
			QName qname = new QName("http://businessLogic/", "BLFacadeImplementationService");

			Service service = Service.create(url, qname);

			appFacadeInterface = service.getPort(BLFacade.class);
			
			//Singleton patroia
			MainGUI.setBussinessLogic(appFacadeInterface);
		}
		if (c.getDataBaseOpenMode().equals("initialize")) 
			appFacadeInterface.initializeBD();
		 
		//Singleton patroia
		MainGUI.setBussinessLogic(appFacadeInterface);
	}
}