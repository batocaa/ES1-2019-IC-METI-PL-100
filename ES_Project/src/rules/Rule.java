package rules;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import userinterface.Defect;

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
	private Defect ruleType;
	
	public Rule(List<RulePart> listObjectsVO, List<LogicOperator> listOperators, String ruleName,
			Defect ruleType) {
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
	
	public Defect getDefect() {
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s = "Name: " + getRuleName() + " Defect: " + getDefect()+  " Condition: " + listObjectsVO.get(0).toString();
		
			for(int i = 0; i < listOperators.size(); i++)
				s += " " + listOperators.get(i).name() + " " + listObjectsVO.get(i+1).toString();
		return s;
	}
	
}
