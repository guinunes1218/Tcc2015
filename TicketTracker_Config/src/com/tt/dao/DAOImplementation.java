package com.tt.dao;

import java.util.List;
import java.sql.CallableStatement;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import com.tt.dominio.Catalogo;
import com.tt.dominio.Servico;
import com.tt.dominio.SLA;
import com.tt.dominio.Tipo;





public class DAOImplementation implements InterfaceDAO {
	private static EntityManagerFactory ef;
	
	
	public DAOImplementation(){
		if (ef == null){
			ef = Persistence.createEntityManagerFactory("local");
		}
	}

	public String adicionarCatalogo(Catalogo c) {
		EntityManager em = ef.createEntityManager();
//		em.getTransaction().begin();
//		if(em.contains(c)){
//			em.persist(c);
//		}
//		else{
//			em.merge(c);
//		}
//		em.getTransaction().commit();
//		em.close();
//			
		em.getTransaction().begin();
		StoredProcedureQuery qry = em.createStoredProcedureQuery("TESTE", Catalogo.class);
		
		if(em.contains(c)){
		qry.execute();
		} else{
			em.merge(c);
		}
		em.getTransaction().commit();
		em.close();
		return "Catalogo adicionado com sucesso!";
	}


	public String adicionarServico(Servico s) {
		EntityManager em = ef.createEntityManager();
		em.getTransaction().begin();
		if(em.contains(s)){
			em.persist(s);
		}
		else{
			em.merge(s);
		}
		em.getTransaction().commit();
		em.close();
			
		
		return "";
	}
	
	public String adicionarSLA (SLA s){
		EntityManager em = ef.createEntityManager();
		em.getTransaction().begin();
		if(em.contains(s)){
			em.persist(s);
		}
		else{
			em.merge(s);
		}
		em.getTransaction().commit();
		em.close();
			
		
		return "";
	}
	
	public String adicionarTipo (Tipo t){
		EntityManager em = ef.createEntityManager();
		em.getTransaction().begin();
		if(em.contains(t)){
			em.persist(t);
		}
		else{
			em.merge(t);
		}
		em.getTransaction().commit();
		em.close();
			
		
		return "";
	}
	
	@Override
	public List<Catalogo> pesquisarCatalogo() throws SQLException{
		EntityManager em = ef.createEntityManager();
		
		
		TypedQuery<Catalogo> qry = em.createQuery("select a from Catalogo a", Catalogo.class);
		
		List<Catalogo> catalogos = qry.getResultList();
		em.close();
		
		return catalogos;
	}
	
	
	@Override
	public List<Servico> pesquisarServico() throws SQLException{
		EntityManager em = ef.createEntityManager();
		
		TypedQuery<Servico> qry = em.createQuery("select a from Servico a", Servico.class);
		
		List<Servico> servicos = qry.getResultList();
		em.close();
		
		return servicos;
	}
	
	
	@Override
	public List<SLA> pesquisarSLA() throws SQLException{
		EntityManager em = ef.createEntityManager();
		
		TypedQuery<SLA> qry = em.createQuery("select a from SLA a", SLA.class);
		
		List<SLA> slas = qry.getResultList();
		em.close();
		
		return slas;
		
	}
	
	
	@Override
	public List<Tipo> pesquisarTipo() throws SQLException{
		EntityManager em = ef.createEntityManager();
		
		TypedQuery<Tipo> qry = em.createQuery("select a from Tipo a", Tipo.class);
		
		List<Tipo> tipos = qry.getResultList();
		em.close();
		
		return tipos;
	}
	
	
	
	@Override
	public Catalogo removerCatalogo() throws SQLException {
		Catalogo c = new Catalogo();
		EntityManager em = ef.createEntityManager();
		TypedQuery<Catalogo> qry = em.createQuery("DELETE c FROM Catalogo c where u.id", Catalogo.class);
		
		qry.setParameter("id", c.getId());
		c = qry.getSingleResult();
		em.close();
		
		return c;
	}	
	
	
	@Override
	public void removerServico(Servico s) throws SQLException {
		EntityManager em = ef.createEntityManager();
		Servico s2 = em.getReference(Servico.class, s.getId());
		em.getTransaction().begin();
		em.remove( s2 );
		em.getTransaction().commit();
		em.close();		
	}	
	
	
	@Override
	public void removerSLA(SLA sl) throws SQLException {
		EntityManager em = ef.createEntityManager();
		SLA sl2 = em.getReference(SLA.class, sl.getId());
		em.getTransaction().begin();
		em.remove( sl2 );
		em.getTransaction().commit();
		em.close();		
	}	
	
	
	@Override
	public void removerTipo(Tipo t) throws SQLException {
		EntityManager em = ef.createEntityManager();
		Tipo t2 = em.getReference(Tipo.class, t.getId());
		em.getTransaction().begin();
		em.remove( t2 );
		em.getTransaction().commit();
		em.close();		
	}	
	
	
}
