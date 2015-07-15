package br.com.mensagem.uteis;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class Uteis {

	public static Calendar xmlGregorianCalendarToCalendar(
			XMLGregorianCalendar dataHoraIncl) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(dataHoraIncl.toGregorianCalendar()
				.getTimeInMillis());
		return calendar;
	}

	public static XMLGregorianCalendar calendarToXmlGregorianCalendar(
			Calendar dataHoraIncl) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTimeInMillis(dataHoraIncl.getTimeInMillis());
		XMLGregorianCalendar xc = null;
		try {
			xc = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		return xc;
	}

}
