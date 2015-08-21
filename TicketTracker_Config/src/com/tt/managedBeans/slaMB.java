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
import com.tt.dominio.Servico;



@ManagedBean
@SessionScoped
public class slaMB {
	private SLA s;
	private List<SLA> slas;
	
	public slaMB() {
		s = new SLA();
	}

	public SLA getS() {
		return s;
	}

	public void setS(SLA s) {
		this.s = s;
	}

	public String adicionarSLA() {
		DAOImplementation dao = new DAOImplementation();
		dao.adicionarSLA(s);
		return "";
	}
	
	public ArrayList<SLA> pesquisarSLA(){
		DAOImplementation dao = new DAOImplementation();
		
			try {
				slas = dao.pesquisarSLA();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return (ArrayList<SLA>) slas;
			
		}
	
	public String removerSLA(SLA sl) { 
		InterfaceDAO slaDAO = new DAOImplementation();
		try {
			slaDAO.removerSLA(sl);
			slaDAO = (InterfaceDAO) slaDAO.pesquisarSLA();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
}
