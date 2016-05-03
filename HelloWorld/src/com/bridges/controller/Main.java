package com.bridges.controller;

import java.io.File;
import java.io.FileNotFoundException;

import com.bridges.model.RiskMatrix;

public class Main {

	public static void main(String[] args) {
		
		//carregar a matriz em uma variável matriz produção
		try {
			MatrixParser matrizAntiga = new MatrixParser("X:\\TIC\\TIC_CPIE_TSI_CGIA\\NP-1\\04 - Backups de matriz\\GAP 20160106\\PB_LOG_MOR");
			MatrixParser matrizNova = new MatrixParser("X:\\TIC\\TIC_CPIE_TSI_CGIA\\NP-1\\04 - Backups de matriz\\GAP 20160225\\PB_LOG_MOR");
			matrizNova.compareActions(matrizAntiga);
			//matrizAntiga.compareActions(matrizNova);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
