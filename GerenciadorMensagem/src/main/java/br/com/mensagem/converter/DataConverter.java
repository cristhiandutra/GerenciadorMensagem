package br.com.mensagem.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="br.com.mensagem.DataConverter")
public class DataConverter implements Converter{
	
	private final String PADRAO_DATA = "dd/MM/yyyy";

	@Override
	public Object getAsObject(FacesContext contexto, UIComponent componente, String valor) {
		Calendar data = null;
		SimpleDateFormat sdf = new SimpleDateFormat(PADRAO_DATA);
		
		try {
			if (null != valor && !"".equals(valor.trim())) {
				data = Calendar.getInstance();
				data.setTime(sdf.parse(valor));
			}
		} catch (ParseException e) {
			FacesMessage mensagem = new FacesMessage("Erro ao converter a data: "+valor);
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ConverterException(mensagem);
		}
		
		return data;
	}

	@Override
	public String getAsString(FacesContext contexto, UIComponent componente, Object valor) {
		String dataComMascara = null;
		Calendar data = null;
		SimpleDateFormat sdf = new SimpleDateFormat(PADRAO_DATA);
		
		if (null != valor && valor instanceof Calendar) {
			data = (Calendar) valor;
			dataComMascara = sdf.format(data.getTime());
		}
		
		return dataComMascara;
	}

}
