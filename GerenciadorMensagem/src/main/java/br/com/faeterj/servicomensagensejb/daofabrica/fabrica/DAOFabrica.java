package br.com.faeterj.servicomensagensejb.daofabrica.fabrica;

import br.com.faeterj.servicomensagensejb.daofabrica.crud.CRUDGenerico;
import br.com.faeterj.servicomensagensejb.daofabrica.excecoes.ExcecaoGenerica;

public abstract interface DAOFabrica
{
  public abstract CRUDGenerico<?, ?> getDAO(Class<?> paramClass)
    throws ExcecaoGenerica;
}
