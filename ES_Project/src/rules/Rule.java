package rules;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Francisco Raimundo
 *
 *Objeto para ser passado tudo de uma s� vez, contendo ent�o
 *uma lista de todas as m�tricas, limites associados a essa m�trica
 *e tamb�m o sinal escolhido pelo utilizador (<,>)
 *E tamb�m temos a lista com os operadores l�gicos todos escolhidos pelo 
 *utilizador (pela ordem escolhida) .
 */
public class Rule implements Serializable{
	//A concatena��o de todas as regras para dizer se � verdadeiro ou falso; ie if(LOC <10 && CYCLO <20)

	private List<RulePart> listObjectsVO;
	private List<LogicOperator> listOperators;
	private String ruleName;
	private String ruleType;
	
	public Rule(List<RulePart> listObjectsVO, List<LogicOperator> listOperators, String ruleName,
			String ruleType) {
		super();
		this.listObjectsVO = listObjectsVO;
		this.listOperators = listOperators;
		this.ruleName = ruleName;
		this.ruleType = ruleType;
	}
	
	/**
	 * @return Lista de RulePart
	 */
	public List<RulePart> getRulePart() {
		return listObjectsVO;
	}
	
	/**
	 * @param lista de RulePart
	 */
	public void setRulePart(ArrayList<RulePart> listObjectsVO) {
		this.listObjectsVO = listObjectsVO;
	}
	
	/**
	 * @return nome da regra
	 */
	public String getRuleName() {
		return ruleName;
	}
	
	public String getRuleType() {
		return ruleType;
	}

	/**
	 * @return array com os operadores l�gicos
	 */
	public List<LogicOperator> getListLogicOperators() {
		return listOperators;
	}
	
	/**
	 * @param array com os operadores l�gicos
	 */
	public void setListOperators(ArrayList<LogicOperator> listOperators) {
		this.listOperators = listOperators;
	}
	
	
	
}
