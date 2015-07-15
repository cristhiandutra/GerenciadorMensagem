package br.com.mensagem.vo;

public enum MenuVO {
	
	HOME("Home", "/home.xhtml"), 
	USUARIO("Usuário", "/usuario/lista.xhtml"), 
	CONTATO("Contato", "/contato/lista.xhtml"), 
	MENSAGEM("Mensagem", "/mensagem/lista.xhtml");
	
	private String nome;
	private String url;
	
	private MenuVO(String nome, String url) {
		this.nome = nome;
		this.url =  url;
	}

	public String getNome() {
		return nome;
	}

	public String getUrl() {
		return url;
	}
}
