package com.bridges.model;

import java.util.Vector;
/**
 * Função de risco
 * 
 * @author y0qd
 *
 */
public class RiskFunction {
	private String functionID;
	private Vector<Action> actions;
	private Vector<Authorization> authorizations;
	private String descripton;
	
	/**
	 * Retorna o ID da função
	 * 
	 * @return
	 */
	public String getFunctionID() {
		return functionID;
	}
	
	/**
	 * 
	 * @param functionID
	 */
	public void setFunctionID(String functionID) {
		this.functionID = functionID;
	}
	
	/**
	 * 
	 * @param functionID
	 */
	public RiskFunction(String functionID) {
		super();
		this.functionID = functionID;
		this.actions = new Vector<Action>();
		this.authorizations = new Vector<Authorization>();
	}
	
	/**
	 * 
	 * @param a
	 */
	public void addAction(Action a){
		this.actions.add(a);
	}
	
	/**
	 * 
	 * @param a
	 */
	public void addAuthorization(Authorization a){
		this.authorizations.add(a);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDescripton() {
		return descripton;
	}
	public void setDescripton(String descripton) {
		this.descripton = descripton;
	}
	
	/**
	 * retorna true caso a transação esteja presente na tabela Action
	 * @param actionID
	 * @return
	 */
	public boolean hasAction (String actionID){
		return false;
	}
	
}
