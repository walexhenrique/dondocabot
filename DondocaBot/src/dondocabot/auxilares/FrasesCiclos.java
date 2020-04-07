package dondocabot.auxilares;

import java.util.Random;

public class FrasesCiclos {
	private static String[] frasesManha = {"Porque reclamas da vida se você é um fracassado? Bom dia", "O dia mal começou e eu sei que você vai fazer merda, Bom dia.", "Avisa o caminhão de lixo que essa carniça chegou, Bom dia.", "O caminho é longo mas a derrota é certa, Bom dia.", "Bom dia, vamos falar de coisas boas?"};
	private static String[] frasesTarde = {"Boa tarde", "Boa tarde estou de bom humor hoje!", "Oque há de bom?"};
	private static String[] frasesNoite = {"Boa noite", "Ei, procure saber se algo antes é impossivel, porque dai você nem precisa tentar, Boa noite.", "Boa noite durma logo, você já me deu muito trabalho hoje!"};
	
	public static String educar(String turno) {
		Random num = new Random();
		if(turno.equalsIgnoreCase("dia")) {
			return frasesManha[num.nextInt(frasesManha.length)];
		}else if(turno.equalsIgnoreCase("tarde")) {
			return frasesTarde[num.nextInt(frasesTarde.length)];
		}else if(turno.equalsIgnoreCase("noite")) {
			return frasesNoite[num.nextInt(frasesNoite.length)];
		}
		return null;
	}
}
