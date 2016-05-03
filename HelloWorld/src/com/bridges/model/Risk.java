package com.bridges.model;

import java.util.HashMap;
/**
 * Esta classe modela uma linha da tabela de riscos da exportação da matriz de riscos do GRC.
 * algumas informações do risco como descrição e conjunto de regras vêm de arquivos diferentes e devem ser modeldos em uma subclasse de Risk
 * 
 * @author y0qd
 *
 */
public class Risk {
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((functionA == null) ? 0 : functionA.hashCode());
		result = prime * result
				+ ((functionB == null) ? 0 : functionB.hashCode());
		result = prime * result
				+ ((functionC == null) ? 0 : functionC.hashCode());
		result = prime * result
				+ ((functionD == null) ? 0 : functionD.hashCode());
		result = prime * result
				+ ((processID == null) ? 0 : processID.hashCode());
		result = prime * result + ((riskID == null) ? 0 : riskID.hashCode());
		result = prime * result + riskLvl;
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result + type;
		return result;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Risk other = (Risk) obj;
		if (functionA == null) {
			if (other.functionA != null)
				return false;
		} else if (!functionA.equals(other.functionA))
			return false;
		if (functionB == null) {
			if (other.functionB != null)
				return false;
		} else if (!functionB.equals(other.functionB))
			return false;
		if (functionC == null) {
			if (other.functionC != null)
				return false;
		} else if (!functionC.equals(other.functionC))
			return false;
		if (functionD == null) {
			if (other.functionD != null)
				return false;
		} else if (!functionD.equals(other.functionD))
			return false;
		if (processID == null) {
			if (other.processID != null)
				return false;
		} else if (!processID.equals(other.processID))
			return false;
		if (riskID == null) {
			if (other.riskID != null)
				return false;
		} else if (!riskID.equals(other.riskID))
			return false;
		if (riskLvl != other.riskLvl)
			return false;
		if (status != other.status)
			return false;
		if (type != other.type)
			return false;
		return true;
	}



	//tipos de risco
	public static final int SOD = 1;
	public static final int CriticalAccess = 2;
	//níveis de risco
	public static final int low =2;//this doesnt make any sense!!!!
	public static final int medium=0;//this doesnt make any sense!!!!
	public static final int high= 1;//this doesnt make any sense!!!!
	
	private int type;// sod or CriticalAccess
	private String riskID;
	private String functionA;//yes, I know, bad pactice!!!
	private String functionB;
	private String functionC;
	private String functionD;
	private String processID;
	private int riskLvl;//
	private boolean status;//true == active 
	
	
	
	/**
	 * @param riskID
	 * @param functionA
	 * @param functionB
	 * @param functionC
	 * @param functionD
	 * @param processID
	 * @param riskLvl
	 * @param status
	 * @param type
	 */
	public Risk(String riskID, String functionA, String functionB,
			String functionC, String functionD, String processID, int riskLvl,
			boolean status, int type) {
		super();
		this.riskID = riskID;
		this.functionA = functionA;
		this.functionB = functionB;
		this.functionC = functionC;
		this.functionD = functionD;
		this.processID = processID;
		this.riskLvl = riskLvl;
		this.status = status;
		this.type = type;
	}



	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}



	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}



	/**
	 * @return the riskID
	 */
	public String getRiskID() {
		return riskID;
	}



	/**
	 * @param riskID the riskID to set
	 */
	public void setRiskID(String riskID) {
		this.riskID = riskID;
	}



	/**
	 * @return the functionA
	 */
	public String getFunctionA() {
		return functionA;
	}



	/**
	 * @param functionA the functionA to set
	 */
	public void setFunctionA(String functionA) {
		this.functionA = functionA;
	}



	/**
	 * @return the functionB
	 */
	public String getFunctionB() {
		return functionB;
	}



	/**
	 * @param functionB the functionB to set
	 */
	public void setFunctionB(String functionB) {
		this.functionB = functionB;
	}



	/**
	 * @return the functionC
	 */
	public String getFunctionC() {
		return functionC;
	}



	/**
	 * @param functionC the functionC to set
	 */
	public void setFunctionC(String functionC) {
		this.functionC = functionC;
	}



	/**
	 * @return the functionD
	 */
	public String getFunctionD() {
		return functionD;
	}



	/**
	 * @param functionD the functionD to set
	 */
	public void setFunctionD(String functionD) {
		this.functionD = functionD;
	}



	/**
	 * @return the processID
	 */
	public String getProcessID() {
		return processID;
	}



	/**
	 * @param processID the processID to set
	 */
	public void setProcessID(String processID) {
		this.processID = processID;
	}



	/**
	 * @return the riskLvl
	 */
	public int getRiskLvl() {
		return riskLvl;
	}



	/**
	 * @param riskLvl the riskLvl to set
	 */
	public void setRiskLvl(int riskLvl) {
		this.riskLvl = riskLvl;
	}



	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}



	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}



	/**
	 * retorna verdadeiro caso a função faça parte deste risco
	 *  
	 * @param riskFuncrionId
	 * @return true if the function is part of this risk
	 */
	public boolean hasFunction(String riskFuncrionId){
		if (riskFuncrionId == null)
				return false;
		if (riskFuncrionId.equals(this.functionA)||riskFuncrionId.equals(this.functionB)||riskFuncrionId.equals(this.functionC)||riskFuncrionId.equals(this.functionD)){
			return true;
		}
		else{
			return false;
		}
		//sim, eu sei que dá para colocar isso em uma linha, mas eu gosto de ser capaz de ler o meu próprio código uma semana depois!!!
	}
	
}
