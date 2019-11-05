package rules;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Francisco Raimundo
 *
 *Objeto para ser passado tudo de uma s� vez, contendo ent�o
 *uma lista de todas as m�tricas, limites associados a essa m�trica
 *e tamb�m o sinal escolhido pelo utilizador (<,>)
 *E tamb�m temos a lista com os operadores l�gicos todos escolhidos pelo 
 *utilizador (pela ordem escolhida) .
 */
public class ObjectRuleVO implements Serializable{

	ArrayList<ObjectVO> listObjectsVO;
	ArrayList<LogicOperator> listOperators;
	
	/**
	 * @return lista de ObjectVO
	 */
	public ArrayList<ObjectVO> getListObjectsVO() {
		return listObjectsVO;
	}
	/**
	 * @param lista de ObjectVO
	 */
	public void setListObjectsVO(ArrayList<ObjectVO> listObjectsVO) {
		this.listObjectsVO = listObjectsVO;
	}
	/**
	 * @return lista com os operadores l�gicos
	 */
	public ArrayList<LogicOperator> getListLogicOperators() {
		return listOperators;
	}
	/**
	 * @param lista de operadores l�gicos
	 */
	public void setListOperators(ArrayList<LogicOperator> listOperators) {
		this.listOperators = listOperators;
	}	
}

