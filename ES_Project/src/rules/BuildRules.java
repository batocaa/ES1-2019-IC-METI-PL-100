package francisco;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Francisco Raimundo
 *
 */

public class BuildRules {

	String auxFeature = "";
	double auxLimit = 0.0d;
	String auxOperator;
	ArrayList<ObjectVO> arrayObjectsVO;
	ArrayList<LogicOperator> arrayLogicOperators;
	ArrayList<Boolean> arrayIntermedio = new ArrayList<>();
	ArrayList<Boolean> arrayFinal = new ArrayList<>();
	ArrayList<Linha> arrayLinhas;

	public static void main(String[] args) {

		BuildRules buildRules = new BuildRules();

		Linha linha = new Linha();
		linha.setLOC(5);
		linha.setCYCLO(5);
		linha.setATFD(5);
		linha.setLAA(5);
		ArrayList<Linha> arrayLinhas = new ArrayList<>();
		arrayLinhas.add(linha);

		ObjectVO objectVO = new ObjectVO();
		objectVO.setMetric("LOC");
		objectVO.setLimit(6);
		objectVO.setOperator("<");

		ObjectVO objectVOO = new ObjectVO();
		objectVOO.setMetric("ATFD");
		objectVOO.setLimit(6);
		objectVOO.setOperator(">");

		ObjectVO objectVOOO = new ObjectVO();
		objectVOOO.setMetric("LAA");
		objectVOOO.setLimit(6);
		objectVOOO.setOperator("<");

		ArrayList<ObjectVO> arrayObjects = new ArrayList<>();
		arrayObjects.add(objectVO);
		arrayObjects.add(objectVOO);
		arrayObjects.add(objectVOOO);

		ObjectRuleVO objectRuleVO = new ObjectRuleVO();
		objectRuleVO.setListObjectsVO(arrayObjects);

		ArrayList<LogicOperator> arrayLogicsOperator = new ArrayList<>();
		arrayLogicsOperator.add(LogicOperator.AND);
		arrayLogicsOperator.add(LogicOperator.OR);

		objectRuleVO.setListOperators(arrayLogicsOperator);

		buildRules.getAndSetBoolean(objectRuleVO, arrayLinhas);

	}

	public void getAndSetBoolean(ObjectRuleVO objectRuleVO, ArrayList<Linha> linha) {
		// for() {//percorre as linhas do array do batoca (excel)

		for(Linha l : linha) {

			arrayObjectsVO = objectRuleVO.getListObjectsVO();
			arrayLogicOperators = objectRuleVO.getListLogicOperators();

			for (ObjectVO a : arrayObjectsVO) {
				colocaNoArrayBooleans(l, a);
			}
			l.setDepoisDasRegras(contasComOperadoresLogicos(arrayLogicOperators));

			arrayFinal.clear();
			arrayIntermedio.clear();
		}

	}

	private boolean contasComOperadoresLogicos(ArrayList<LogicOperator> arrayLogicOperators) {

		boolean auxBooleanIntermedio=false;
		boolean auxBoolean=false;

		for(int a=1; a != arrayLogicOperators.size()+1; a=a+1) {
			if(arrayLogicOperators.size()==0) {
				auxBoolean=arrayIntermedio.get(a);
			}
			auxBooleanIntermedio=arrayIntermedio.get(a);
			auxBoolean=CalculaBoolean(auxBooleanIntermedio, arrayIntermedio.get(a), arrayLogicOperators.get(a-1));
			auxBooleanIntermedio=auxBoolean;
		}
		return auxBoolean;
	}

	private boolean CalculaBoolean(Boolean boolean1, Boolean boolean2, LogicOperator logicOperator) {
		boolean auxBoolean=false;
		if(logicOperator.equals(LogicOperator.AND)) {
			if(boolean1.equals(true) && boolean2.equals(true)) {
				System.out.println(boolean1);
				System.out.println(boolean2);
				auxBoolean=true;
			} else {
				auxBoolean=false;
			}
		} else {
			if(boolean1.equals(false) && boolean2.equals(false)) {
				auxBoolean=false;
			}
			else {
				auxBoolean=true;
			}
		}
		return auxBoolean;
	}


	public void colocaNoArrayBooleans(Linha linha, ObjectVO a) {

		double limiteNaLinha = getLimiteDaLinha(linha, a);
		
			if (a.getOperator().equals("<")) {
				if (limiteNaLinha < a.getLimit()) {
					arrayIntermedio.add(true);
				} else {
					arrayIntermedio.add(false);
				}
			} else {
				if(limiteNaLinha > a.getLimit()) {
					arrayIntermedio.add(true);
				} else {
					arrayIntermedio.add(false);
				}
			}
			
	}

	private double getLimiteDaLinha(Linha l, ObjectVO a) {
		Double auxDouble = 0.0;
		try {
			switch(a.getFeature()) {
			case"LOC":
				auxDouble = l.getLOC();
			case"CYCLO":
				auxDouble = l.getCYCLO();
			case"ATFD":
				auxDouble = l.getATFD();
			case"LAA":
				auxDouble = l.getLAA();
		}
			
		} catch (Exception e) {
			e.getMessage();
		} 
		return auxDouble;
	}

}