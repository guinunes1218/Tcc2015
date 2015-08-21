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
import com.tt.dominio.Catalogo;


@ManagedBean
@SessionScoped
public class CatalogoMB {
	private Catalogo cat;
	public List<Catalogo> catalogos;
	
	public CatalogoMB() {
		cat = new Catalogo();
	}

	public Catalogo getCat() {
		return cat;
	}

	public void setCat(Catalogo cat) {
		this.cat = cat;
	}

	public String adicionarCatalogo() {
		DAOImplementation dao = new DAOImplementation();
		dao.adicionarCatalogo(cat);
		return "";

	}
	
	public ArrayList<Catalogo> pesquisarCatalogo(){
		DAOImplementation dao = new DAOImplementation();
		
			try {
				catalogos = dao.pesquisarCatalogo();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return (ArrayList<Catalogo>) catalogos;
			
		}
	
	
	public String removerCatalogo() { 
		InterfaceDAO catalogoDAO = new DAOImplementation();
		
		try {
			catalogoDAO.removerCatalogo();
			catalogoDAO = (InterfaceDAO) catalogoDAO.pesquisarCatalogo();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
}
