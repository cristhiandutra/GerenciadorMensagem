package br.com.faeterj.servicomensagensejb.dao.implementacao;

import br.com.faeterj.servicomensagensejb.dao.interfaces.PessoaDAO;
import br.com.faeterj.servicomensagensejb.daofabrica.crud.CRUDGenerico;
import br.com.faeterj.servicomensagensejb.entidades.Pessoa;


public class PessoaCRUD extends CRUDGenerico<Pessoa, Long> implements PessoaDAO{

}
