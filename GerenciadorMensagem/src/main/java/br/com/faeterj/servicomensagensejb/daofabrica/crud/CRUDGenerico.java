package br.com.faeterj.servicomensagensejb.daofabrica.crud;

import java.io.Serializable;
import java.text.Normalizer;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.stat.Statistics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.faeterj.servicomensagensejb.daofabrica.dao.DAOGenerico;
import br.com.faeterj.servicomensagensejb.daofabrica.excecoes.ExcecaoGenerica;

public abstract class CRUDGenerico<T, ID extends Serializable> implements
		DAOGenerico<T, ID> {
	protected Logger logger = LoggerFactory.getLogger(CRUDGenerico.class);
	private EntityManager entityManager;
	private Class<T> classePersistente;

	public void destacar(T entity) throws ExcecaoGenerica {
		((Session) getEntityManager().getDelegate()).evict(entity);
	}

	public CRUDGenerico() {
		this.classePersistente = ((Class) ((java.lang.reflect.ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0]);
	}

	public Class<T> getClassePersistente() {
		return this.classePersistente;
	}

	public void setClassePersistente(Class<T> classePersistente) {
		this.classePersistente = classePersistente;
	}

	public T salvar(T entity) throws ExcecaoGenerica {
		this.logger.info("::::Acionou o metodo salvar em GenericCRUD::::");
		try {
			((Session) getEntityManager().getDelegate()).save(entity);
		} catch (HibernateException e) {
			this.logger.info(e.getMessage());
			throw new ExcecaoGenerica(e);
		}
		return entity;
	}

	public T salvarOuAlterar(T entity) throws ExcecaoGenerica {
		this.logger
				.info("::::Acionou o metodo salvarOuAlterar em GenericCRUD::::");
		try {
			((Session) getEntityManager().getDelegate()).saveOrUpdate(entity);
		} catch (HibernateException e) {
			this.logger.info(e.getMessage());
			throw new ExcecaoGenerica(e);
		}
		return entity;
	}

	public void excluir(T entity) throws ExcecaoGenerica {
		this.logger.info("::::Acionou o metodo excluir em GenericCRUD::::");
		try {
			((Session) getEntityManager().getDelegate()).delete(entity);
		} catch (HibernateException e) {
			this.logger.info(e.getMessage());
			throw new ExcecaoGenerica(e);
		}
	}

	public List<T> listar() throws ExcecaoGenerica {
		this.logger.info("::::Acionou o metodo listar em GenericCRUD::::");

		List<T> lista = null;
		try {
			lista = buscarPorCriteria(new Criterion[0]);
		} catch (HibernateException e) {
			this.logger.info(e.getMessage());
			throw new ExcecaoGenerica(e);
		}
		return lista;
	}

	public List<T> buscarPorCriteria(Criterion... criterions)
			throws ExcecaoGenerica {
		this.logger
				.info("::::Acionou o metodo buscarPorCriteria em GenericCRUD::::");

		Criteria criteria = null;
		try {
			criteria = ((Session) getEntityManager().getDelegate())
					.createCriteria(getClassePersistente());
			for (Criterion criterion : criterions) {
				criteria.add(criterion);
			}
		} catch (Exception e) {
			this.logger.info(e.getMessage());
			throw new ExcecaoGenerica(e);
		}
		return criteria.list();
	}

	public T buscarPorId(ID id) throws ExcecaoGenerica {
		this.logger.info("::::Acionou o metodo buscarPorId em GenericCRUD::::");

		T entidade = null;
		try {
			entidade = getEntityManager().find(getClassePersistente(), id);
		} catch (HibernateException e) {
			this.logger.info(e.getMessage());
			throw new ExcecaoGenerica(e);
		}
		return entidade;
	}

	public T alterar(T entidade) throws ExcecaoGenerica {
		this.logger.info("::::Acionou o metodo alterar em GenericCRUD::::");
		try {
			((Session) getEntityManager().getDelegate()).update(entidade);
		} catch (HibernateException e) {
			this.logger.info(e.getMessage());
			throw new ExcecaoGenerica(e);
		}
		return entidade;
	}

	public T mesclar(T entidade) throws ExcecaoGenerica {
		this.logger.info("::::Acionou o metodo mesclar em GenericCRUD::::");
		try {
			return (T) getEntityManager().merge(entidade);
		} catch (HibernateException e) {
			this.logger.info(e.getMessage());
			throw new ExcecaoGenerica(e);
		}
	}

	public Long retornarMaxId() throws ExcecaoGenerica {
		Session sessao = (Session) getEntityManager().getDelegate();
		Criteria criteria = sessao.createCriteria(getClassePersistente());

		criteria.setProjection(Projections.projectionList().add(
				Projections.max("id")));

		Long idMaximo = (Long) criteria.uniqueResult();
		if (idMaximo == null) {
			idMaximo = new Long(1L);
		}
		return idMaximo;
	}

	public List<T> buscarPorCriteria(String ordemAscCampo, boolean ordemAsc,
			Criterion... criterions) throws ExcecaoGenerica {
		this.logger
				.info("::::Acionou o método buscarPorCriteria em GenericCRUD::::");

		Criteria criteria = null;
		Session session = null;
		try {
			criteria = ((Session) getEntityManager().getDelegate())
					.createCriteria(getClassePersistente());
			for (Criterion criterion : criterions) {
				criteria.add(criterion);
			}
			if (ordemAsc) {
				criteria.addOrder(Order.asc(ordemAscCampo));
			} else {
				criteria.addOrder(Order.desc(ordemAscCampo));
			}
			return criteria.list();
		} catch (Exception e) {
			this.logger.info(e.getMessage());
			throw new ExcecaoGenerica(e);
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}
	}

	public List<T> listarAscOuDesc(String ordemAscCampo, boolean buscarAsc)
			throws ExcecaoGenerica {
		this.logger
				.info("::::Acionou o método listarAscOuDesc em GenericCRUD::::");

		List<T> lista = null;
		try {
			lista = buscarPorCriteria(ordemAscCampo, buscarAsc,
					new Criterion[0]);
		} catch (HibernateException e) {
			this.logger.info(e.getMessage());
			throw new ExcecaoGenerica(e);
		}
		return lista;
	}

	public Statistics getEstatisticas() {
		return ((Session) getEntityManager().getDelegate()).getSessionFactory()
				.getStatistics();
	}

	public org.hibernate.Query criarQuery(String query) {
		return ((Session) getEntityManager().getDelegate()).createQuery(query);
	}

	public Criteria criarCriteria() {
		return ((Session) getEntityManager().getDelegate())
				.createCriteria(getClassePersistente());
	}

	public int contar() throws ExcecaoGenerica {
		Long quantidade = Long.valueOf(0L);
		try {
			StringBuilder queryString = new StringBuilder();
			queryString.append("select count (*) from "
					+ getClassePersistente().getName());

			javax.persistence.Query query = getEntityManager().createQuery(
					queryString.toString());

			quantidade = (Long) query.getSingleResult();
		} catch (Exception e) {
			this.logger.info(e.getMessage());
			throw new ExcecaoGenerica(e);
		}
		return quantidade.intValue();
	}

	public void excluir(ID id) throws ExcecaoGenerica {
		excluir(buscarPorId(id));
	}

	public static String normalizer(String s) {
		return Normalizer.normalize(s, Normalizer.Form.NFD)
				.replaceAll("[^\\p{ASCII}]", "").toLowerCase();
	}

	public String replacer(String param) {
		String t1 = "���������������";
		String t2 = "aaaceeeeuuuooii";
		String s = param;
		for (int i = 0; i < t1.length(); i++) {
			s = "replace(" + s + ",'" + t1.charAt(i) + "','" + t2.charAt(i)
					+ "')";
		}
		return s;
	}

	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
