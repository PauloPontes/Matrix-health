package com.bridges.model;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Vector;

public class RiskMatrix {
	private HashMap<String,Risk> risks;
	private HashMap<String,RiskFunction> riskFunctions;
	
	//todos os array com prefixo "raw" s�o 
	private Risk[] rawRisk;
	private Action[] rawAction;
	private Authorization[] rawAuthorization;
	
	
	/**
	 * Creates a new risk kMatrix based on the numbered files in the directory f
	 * @param f
	 */
	public RiskMatrix(){
	}

	/**
	 * Alimenta todas as autoriza��es do vetor auths no HashMap interno de fun��esRisco
	 * 
	 * @param auths
	 */
	private void addAuthorizations(Vector<Authorization> auths){
		Iterator<Authorization> iter = auths.iterator();
		while(iter.hasNext()){
			
			Authorization a = iter.next();
			RiskFunction function = this.riskFunctions.get(a.getRiskFunctionID());
			//se a fun��o de risco ainda n�o existe na matriz, crio a fun��o de risco
			if(function == null){
				function = new RiskFunction(a.getRiskFunctionID());
				function.addAuthorization(a);
				this.riskFunctions.put(a.getRiskFunctionID(), function);
			}
			else{
				function.addAuthorization(a);
			}
					
		}
	}
	
	private void addActions(Vector<Action> actions){
		Iterator<Action> iterator= actions.iterator();
		while (iterator.hasNext()){
			Action currentAction = iterator.next();
			RiskFunction rf = this.riskFunctions.get(currentAction.getRiskFunctionID());
			if (rf== null){
				rf = new RiskFunction(currentAction.getRiskFunctionID());
				rf.addAction(currentAction);
			}
			else{
				rf.addAction(currentAction);
			}
		}
	}
	
	public boolean checkConsistency(){
		//checar fun��es �rf�s
		for(Entry<String, RiskFunction> e: riskFunctions.entrySet()){
			
		}
		//checar riscos cujas fun��es est�o indefinidas
		//
		return false;
	}

}
