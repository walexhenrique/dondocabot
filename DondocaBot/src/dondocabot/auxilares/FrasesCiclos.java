package dondocabot.auxilares;

import java.util.Random;

public class FrasesCiclos {
	private static String[] frasesManha = {"Porque reclamas da vida se voc� � um fracassado? Bom dia", "O dia mal come�ou e eu sei que voc� vai fazer merda, Bom dia.", "Avisa o caminh�o de lixo que essa carni�a chegou, Bom dia.", "O caminho � longo mas a derrota � certa, Bom dia.", "Bom dia, vamos falar de coisas boas?"};
	private static String[] frasesTarde = {"Boa tarde", "Boa tarde estou de bom humor hoje!", "Oque h� de bom?"};
	private static String[] frasesNoite = {"Boa noite", "Ei, procure saber se algo antes � impossivel, porque dai voc� nem precisa tentar, Boa noite.", "Boa noite durma logo, voc� j� me deu muito trabalho hoje!"};
	
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
