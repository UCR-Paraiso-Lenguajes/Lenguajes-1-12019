package cr.ac.ucr.ie.lenguajes.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cr.ac.ucr.ie.lenguajes.data.EditorialData;
import cr.ac.ucr.ie.lenguajes.domain.Editorial;

@Service
public class EditorialBusiness {
	@Autowired
	private EditorialData editorialData = new EditorialData();
	
	public List<Editorial> ListarEditoriales(int inicio,int _final){
		if((_final -inicio)<5) {
			return editorialData.listarEditoriales(inicio, _final);
		}
		throw new RuntimeException("No se pueden mostrar mas de 5 editoriales a la vez");
	}
}
