package com.tt.dao;





import java.sql.SQLException;
import java.util.List;

import com.tt.dominio.Catalogo;
import com.tt.dominio.Servico;
import com.tt.dominio.SLA;
import com.tt.dominio.Tipo;

public interface InterfaceDAO {
		
	public String adicionarCatalogo(Catalogo c);
	public String adicionarServico(Servico s);
	public String adicionarSLA (SLA s);
	public String adicionarTipo (Tipo t);
	
	public List<Catalogo> pesquisarCatalogo() throws SQLException; 
	public List<Servico> pesquisarServico() throws SQLException;
	public List<SLA> pesquisarSLA() throws SQLException;
	public List<Tipo> pesquisarTipo() throws SQLException;
	
	
	public Catalogo removerCatalogo() throws SQLException;
	public void removerServico(Servico s) throws SQLException;
	public void removerSLA(SLA sl) throws SQLException;
	public void removerTipo(Tipo t) throws SQLException;
	
}
