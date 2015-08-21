package com.tt.managedBeans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.tt.dao.DAOImplementation;
import com.tt.dao.InterfaceDAO;
import com.tt.dominio.Catalogo;
import com.tt.dominio.Servico;

@ManagedBean
@SessionScoped
public class ServicoMB {
	private Servico serv;
	private List<Servico> servicos;
	public Servico getServ() {
		return serv;
	}

	public void setServ(Servico serv) {
		this.serv = serv;
	}

	public ServicoMB() {
		serv = new Servico();
	}

	public String adicionarServico() {
		DAOImplementation dao = new DAOImplementation();
		dao.adicionarServico(serv);
		return "";
	}
	
	
	public ArrayList<Servico> pesquisarServico(){
		DAOImplementation dao = new DAOImplementation();
		
			try {
				servicos = dao.pesquisarServico();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return (ArrayList<Servico>) servicos;
			
		}
	
	public String removerServico(Servico s) { 
		InterfaceDAO servicoDAO = new DAOImplementation();
		try {
			servicoDAO.removerServico(s);
			servicoDAO = (InterfaceDAO) servicoDAO.pesquisarServico();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
}
