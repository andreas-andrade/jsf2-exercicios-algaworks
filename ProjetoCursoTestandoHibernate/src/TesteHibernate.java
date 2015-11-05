import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.algaworks.cursojsf2.financeiro.model.Pessoa;
import com.algaworks.cursojsf2.financeiro.util.HibernateUtil;


public class TesteHibernate {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		
		List<Pessoa> pessoaList = session.createCriteria(Pessoa.class)
				.add(Restrictions.gt("codigo", 2))
				.list();
		
		for (Pessoa pessoa : pessoaList) {
			System.out.println(pessoa.getCodigo() + " - " + pessoa.getNome()  + " - " + pessoa.getRamoDeAtividade().getDescricao() + " - " + pessoa.getTipo());
		}
		session.close();
	}
}
