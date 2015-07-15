package br.com.mensagem.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("br.com.mensagem.CPFConverter")
public class CPFConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext contexto, UIComponent componente, String valor) {
		Long cpf = null;
		String cpfSemMascara = null;
		
		if (null != valor && !"".equals(valor.trim())) {
			cpfSemMascara = valor.trim().replace("-", "");
			cpf = new Long(cpfSemMascara);
		}
		
		return cpf;
	}

	@Override
	public String getAsString(FacesContext contexto, UIComponent componente, Object valor) {
		String cpfSemMascara = null;
		Long cpf = null;
		
		if (null != valor && valor instanceof Long) {
			cpf = (Long) valor;
			cpfSemMascara = cpf.toString();
		}
		
		return cpfSemMascara;
	}

}
