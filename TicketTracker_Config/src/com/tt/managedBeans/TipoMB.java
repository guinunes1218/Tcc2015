package com.tt.managedBeans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.tt.dao.DAOImplementation;
import com.tt.dao.InterfaceDAO;
import com.tt.dominio.SLA;
import com.tt.dominio.Tipo;

@ManagedBean
@SessionScoped
public class TipoMB {

	private Tipo t;
	private List<Tipo> tipos;
	
	public TipoMB() {
		t = new Tipo();
	}

	public Tipo getT() {
		return t;
	}

	public void setT(Tipo t) {
		this.t = t;
	}

	public Tipo getNome() {
		return t;
	}

	public void setNome(Tipo t) {
		this.t = t;
	}

	public String adicionarTipo() {
		DAOImplementation dao = new DAOImplementation();
		dao.adicionarTipo(t);
		return "";
	}
	
	public ArrayList<Tipo> pesquisarTipo(){
		DAOImplementation dao = new DAOImplementation();
		
			try {
				tipos = dao.pesquisarTipo();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return (ArrayList<Tipo>) tipos;
			
		}
	public String removeTipo(Tipo t) { 
		InterfaceDAO tipoDAO = new DAOImplementation();
		try {
			tipoDAO.removerTipo(t);
			tipoDAO = (InterfaceDAO) tipoDAO.pesquisarTipo();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
}
