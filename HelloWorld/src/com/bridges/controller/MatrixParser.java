package com.bridges.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Pattern;

import com.bridges.model.Action;
import com.bridges.model.Authorization;
import com.bridges.model.Risk;

/**
 * Esta classe centraliza todos os parsers. O parsing será feito uma única vez colocando a informação em arrays
 * 
 * @author y0qd
 *
 */
public class MatrixParser {
	private File diretorioDeTrabalho;
	private Action[] rawActions = new Action[0];//lista de todas as actions do arquivo 4.txt
	private Authorization[] rawAuthorizations = new Authorization[0];
	private Risk[] rawRisk = new Risk[0];
	
	/**
	 * Construtor,
	 * Realiza o parsing de todos os arquivos e coloca o conteúdo completo nos arrays de prefixo "raw". A matriz será montada a partir destes arrays
	 * 
	 * @param dir
	 * @throws FileNotFoundException
	 */
	public MatrixParser(String dir) throws FileNotFoundException{
		File f = new File(dir);
		if (!f.isDirectory()) {
			System.out.println("o diretório especificado não existe "+ dir);
			throw new FileNotFoundException("o diretório especificado não existe "+ dir);
		}
		//todo chamar todos os parsers
		this.rawActions =  this.parseActions(f).toArray(this.rawActions);
		System.out.println("parsed "+ this.rawActions.length + " Actions");
		this.rawAuthorizations = this.parseAuthorizations(f).toArray(this.rawAuthorizations);
		System.out.println("parsed "+ this.rawAuthorizations.length + " authorizations");
		this.rawRisk = this.parseRisks(f).toArray(this.rawRisk);
		System.out.println("parsed "+ this.rawRisk.length + "  risks");

	}
	
	/**
	 * Realiza o parsing do arquivo de ações 
	 * 
	 * @param f diretório onde o arquivo está localizado.
	 * @return Vector de objetos do tipo Action
	 */
	private Vector<Action> parseActions(File f){
		Vector<Action> actions = new Vector<Action>();
		File tableFile = new File(f.getAbsolutePath()+"//4.txt");
		Scanner fileScanner = null;
		try {
			fileScanner = new Scanner(tableFile,"UTF-8");
			while(fileScanner.hasNextLine()){
				String linha = fileScanner.nextLine();
				if("".equals(linha.trim())){//ignorando linhas em branco
					continue;
				}
				Scanner lineScanner = new Scanner(linha);
				lineScanner.useDelimiter(Pattern.compile("\t"));//definindo o delimitador de campos como o tab
				String riskFunctionID = lineScanner.next();
				String transactionId = lineScanner.next();
				int status = lineScanner.nextInt();
				Action currentAction = new Action(transactionId, riskFunctionID, status ==0);
				actions.add(currentAction);
				lineScanner.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally{
			fileScanner.close();
		}
		return actions;
		
	}
	
	/**
	 * Realiza o parsing das autorizações
	 * 
	 * @param f
	 * @return
	 */
	private Vector<Authorization> parseAuthorizations(File f){
		Vector<Authorization> authorizations = new Vector<Authorization>();
		File tableFile = new File(f.getAbsolutePath()+"//5.txt");
		Scanner fileScanner = null;
		try {
			fileScanner = new Scanner(tableFile,"UTF-8");
			while(fileScanner.hasNextLine()){
				String linha = fileScanner.nextLine();
				if("".equals(linha.trim())){//ignorando linhas em branco
					continue;
				}
				Scanner lineScanner = new Scanner(linha);
				lineScanner.useDelimiter(Pattern.compile("\t"));//definindo o delimitador de campos como o tab
				String riskFunctionID = lineScanner.next();
				String transactionId = lineScanner.next();
				String objectId = lineScanner.next();
				String fieldId = lineScanner.next();
				String valueFrom = lineScanner.next();
				String valueTo = lineScanner.next();
				String operator = lineScanner.next();
				int status = lineScanner.nextInt();
				
				Authorization currentAuthorization = new Authorization(riskFunctionID,transactionId, objectId, fieldId, valueFrom,valueTo, operator, status == 0);
				
				authorizations.add(currentAuthorization);
				lineScanner.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally{
			fileScanner.close();
		}
		return authorizations;
	}


	/**
	 * Realiza o parsing dos riscos do arquivo 7.txt
	 * 
	 * Atenção, o mesmo risco pode aparecer mais de uma vez em línguas diferentes.
	 * 
	 * @param f
	 * @return
	 */
	private Vector<Risk> parseRisks(File f){
		Vector<Risk> risks = new Vector<Risk>();
		File tableFile = new File(f.getAbsolutePath()+"//7.txt");
		Scanner fileScanner = null;
		try {
			fileScanner = new Scanner(tableFile,"UTF-8");
			while(fileScanner.hasNextLine()){
				String linha = fileScanner.nextLine();
				if("".equals(linha.trim())){//ignorando linhas em branco
					continue;
				}
				Scanner lineScanner = new Scanner(linha);
				lineScanner.useDelimiter(Pattern.compile("\t"));//definindo o delimitador de campos como o tab
				String riskId = lineScanner.next();
				//String language = lineScanner.next();
				String funcA = lineScanner.next();
				String funcB = lineScanner.next();
				String funcC = lineScanner.next();
				String funcD = lineScanner.next();
				String unknown1 = lineScanner.next();
				String process = lineScanner.next();
				int riskLvl = lineScanner.nextInt();//0 = Médio, 1 = alto, 2 =baixo
				int status = lineScanner.nextInt();//0= ativo, 1=inativo
				int riskType = lineScanner.nextInt();//1=SoD, 2= critical access
				Risk currentRisk = new Risk(riskId,funcA,funcB,funcC,funcD,unknown1,riskLvl,status == 0,riskType);
				risks.add(currentRisk);
				lineScanner.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally{
			fileScanner.close();
		}
		return risks;
	}

	/**
	 * gera um relatório de diferenças de ações
	 * 
	 * @param matrizAntiga
	 */
	public void compareActions(MatrixParser matrizAntiga){
		//TODO mudar de void para um tipo padronizado de relatótio
		int nomatch =0;
		for (Action current: this.rawActions){
			boolean contem = false;
			for (Action antigo : matrizAntiga.rawActions ){
				if(current.equals(antigo)){
				contem = true;
				break;
				}
			}
			if (!contem){
				System.out.println(current.toString() +" foi adicionada na nova matriz");
				nomatch++;
			}
		}
		System.out.println("adicionadas "+nomatch+" linhas");

		//descobrindo as linhas removidas
		 nomatch =0;
		for (Action matriz_antiga: matrizAntiga.rawActions ){
			//TODO tem bug aqui!
			boolean contem = false;
			for (Action matriz_nova : this.rawActions ){
				if(matriz_antiga.equals(matriz_nova)){
				contem = true;
				break;
				}
			}
			if (!contem){
				System.out.println(matriz_antiga.toString() +" foi removida na nova matriz");
				nomatch++;
			}
		}
		System.out.println("removidas "+nomatch+" linhas");
	}
	
}
