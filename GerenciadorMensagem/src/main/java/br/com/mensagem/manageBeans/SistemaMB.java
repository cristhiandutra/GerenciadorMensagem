package br.com.mensagem.manageBeans;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.mensagem.vo.MenuVO;

@ViewScoped
@ManagedBean
public class SistemaMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private MenuVO menuVO;
	
	public void configurarMenuAtivo(String nome) {
		System.out.println(nome);
	}

	public MenuVO getMenuVO() {
		return menuVO;
	}

	public void setMenuVO(MenuVO menuVO) {
		this.menuVO = menuVO;
	}
	
	public MenuVO[] getMenusVO() {
        return MenuVO.values();
    }
}
