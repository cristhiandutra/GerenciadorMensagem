package br.com.faeterj.servicomensagensejb.daofabrica.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.criterion.Criterion;

import br.com.faeterj.servicomensagensejb.daofabrica.excecoes.ExcecaoGenerica;

public abstract interface DAOGenerico<T, ID extends Serializable>
{
  public abstract EntityManager getEntityManager();
  
  public abstract void setEntityManager(EntityManager paramEntityManager);
  
  public abstract List<T> buscarPorCriteria(Criterion... paramVarArgs)
    throws ExcecaoGenerica;
  
  public abstract void excluir(T paramT)
    throws ExcecaoGenerica;
  
  public abstract List<T> listar()
    throws ExcecaoGenerica;
  
  public abstract T buscarPorId(ID paramID)
    throws ExcecaoGenerica;
  
  public abstract T salvar(T paramT)
    throws ExcecaoGenerica;
  
  public abstract T alterar(T paramT)
    throws ExcecaoGenerica;
  
  public abstract T mesclar(T paramT)
    throws ExcecaoGenerica;
  
  public abstract T salvarOuAlterar(T paramT)
    throws ExcecaoGenerica;
  
  public abstract void destacar(T paramT)
    throws ExcecaoGenerica;
  
  public abstract Long retornarMaxId()
    throws ExcecaoGenerica;
  
  public abstract List<T> listarAscOuDesc(String paramString, boolean paramBoolean)
    throws ExcecaoGenerica;
  
  public abstract int contar()
    throws ExcecaoGenerica;
  
  public abstract void excluir(ID paramID)
    throws ExcecaoGenerica;
}
