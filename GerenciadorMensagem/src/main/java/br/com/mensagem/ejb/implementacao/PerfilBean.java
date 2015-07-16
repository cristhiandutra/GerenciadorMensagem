package br.com.mensagem.ejb.implementacao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import br.com.mensagem.ejb.interfaces.PerfilLocal;
import br.com.mensagem.entidades.Perfil;

@Stateless
public class PerfilBean implements PerfilLocal {

	@Override
	public List<Perfil> listar() {
		List<Perfil> perfilList = new ArrayList<Perfil>();
		
		Perfil a = new Perfil(1l, "Administrador", "Perfil de administrador do sistema.");
		Perfil b = new Perfil(2l, "Funcionário", "Perfil que pode enviar mensagems no sistema.");
		
		perfilList.add(a);
		perfilList.add(b);

		return perfilList;
	}


}
