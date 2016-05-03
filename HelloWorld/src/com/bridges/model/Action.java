package com.bridges.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Pattern;

public class Action {
	private String transactionCode;
	private String riskFunctionID;
	private boolean status;
	public String getTransactionCode() {
		return transactionCode;
	}
	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}
	public String getRiskFunctionID() {
		return riskFunctionID;
	}
	public void setRiskFunctionID(String riskFunctionID) {
		this.riskFunctionID = riskFunctionID;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Action(String transactionCode, String riskFunctionID, boolean status) {
		super();
		this.transactionCode = transactionCode;
		this.riskFunctionID = riskFunctionID;
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((riskFunctionID == null) ? 0 : riskFunctionID.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result
				+ ((transactionCode == null) ? 0 : transactionCode.hashCode());
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
		Action other = (Action) obj;
		if (riskFunctionID == null) {
			if (other.riskFunctionID != null)
				return false;
		} else if (!riskFunctionID.equals(other.riskFunctionID))
			return false;
		if (status != other.status)
			return false;
		if (transactionCode == null) {
			if (other.transactionCode != null)
				return false;
		} else if (!transactionCode.equals(other.transactionCode))
			return false;
		return true;
	}
	public static Vector<Action> parseActions(File f){
		Vector<Action> actions = new Vector<Action>();
		File tableFile = new File(f.getAbsolutePath()+"//4.txt");
		//TODO implementar parser
		Scanner fileScanner = null;
		try {
			fileScanner = new Scanner(tableFile,"UTF-8");
			while(fileScanner.hasNextLine()){
				String linha = fileScanner.nextLine();
				if("".equals(linha.trim())){//ignorando linhas em branco
					continue;
				}
				Scanner lineScanner = new Scanner(linha);
				lineScanner.useDelimiter(Pattern.compile("\t"));
				String riskFunctionID = lineScanner.next();
				String transactionId = lineScanner.next();
				int status = lineScanner.nextInt();
				Action currentAction = new Action(transactionId, riskFunctionID, status ==0);
				actions.add(currentAction);
				lineScanner.close();
			}
		} catch (FileNotFoundException e) {
			System.err.println("arquivo não encontrado");
			e.printStackTrace();
		}
		finally{
			fileScanner.close();
		}
		return actions;
		
	}
	
	public String toString(){
		return "function="+this.getRiskFunctionID() + " action=" + this.getTransactionCode();
	}
}
