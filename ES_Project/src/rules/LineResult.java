package rules;

/**
 * @author Francisco Raimundo
 * 
 * Objeto final, com o ID e o resultado desse ID
 *
 */
public class LineResult{

	int methodID;
	boolean result;
	
	
	public LineResult(int methodID, boolean result) {
		super();
		this.methodID = methodID;
		this.result = result;
	}


	/**
	 * @return ID
	 * 
	 * Retorna o m�todo ID
	 */
	public int getMethodID() {
		return methodID;
	}


	/**
	 * @param ID
	 * 
	 * Colocamos o m�todo ID passado no paramtro
	 */
	public void setMethodID(int methodID) {
		this.methodID = methodID;
	}


	/**
	 * @return resultado
	 * 
	 * Retornamos um booleano
	 */
	public boolean isResult() {
		return result;
	}


	/**
	 * @param resultado
	 * 
	 * Fazemos set  ao resultado que � booleano
	 */
	
	public void setResult(boolean result) {
		this.result = result;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(result)
			return "TRUE";
		else
			return "FALSE";
	}
	
}
