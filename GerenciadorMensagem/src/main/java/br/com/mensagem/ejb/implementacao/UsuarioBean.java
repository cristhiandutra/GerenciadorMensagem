package br.com.mensagem.ejb.implementacao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import br.com.mensagem.ejb.interfaces.UsuarioLocal;
import br.com.mensagem.entidades.Pessoa;

@Stateless
public class UsuarioBean implements UsuarioLocal {

	private Map<Long, Pessoa> usuarios = new HashMap<Long, Pessoa>();

	@Override
	public List<Pessoa> listar() {
		List<Pessoa> usuariosList = new ArrayList<Pessoa>();
		
		for (Map.Entry<Long, Pessoa> entry : usuarios.entrySet()) {
			usuariosList.add(entry.getValue());
		}

		return usuariosList;
	}

	@Override
	public void salvar(Pessoa usuario) {
		Long contadorId = usuarios.size() + 1l;
		usuario.setId(contadorId);
		usuarios.put(contadorId, usuario);
	}

	@Override
	public void excluir(Long idUsuario) {
		usuarios.remove(idUsuario);
	}

	@Override
	public Pessoa buscar(Long idUsuario) {
		return usuarios.get(idUsuario);
	}

}
