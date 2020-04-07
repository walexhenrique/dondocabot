package dondocabot.comandos;

import dondocabot.principal.Bot;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
/*Classe que realiza os calculos do comando ~calc*/
public class Calculadora extends ListenerAdapter {
	
	public static double valor1;
	public static double valor2;
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent evento) {
		String[] args = evento.getMessage().getContentRaw().split("\\s+");
		
		if(args[0].equalsIgnoreCase(Bot.prefixo + "calc")) {
			try {
				
				valor1 = Double.parseDouble(args[1]);
				valor2 = Double.parseDouble(args[3]);
				
				if(valor1 >= Double.MAX_VALUE || valor2 >= Double.MAX_VALUE) {
					evento.getChannel().sendMessage("Que que isso? querendo colocar um número tão alto, não aceito isso.").queue();
					evento.getChannel().sendTyping().queue();
					return;
				}
				
				switch (args[2]) {
				case "+":
					
					evento.getChannel().sendMessage("Resultado: " + (valor1 + valor2)).queue();
					evento.getChannel().sendTyping().queue();
					break;
					
				case "-":
					
					evento.getChannel().sendMessage("Resultado: " +  (valor1 - valor2)).queue();
					evento.getChannel().sendTyping().queue();
					break;
				case "*":
					
					evento.getChannel().sendMessage("Resultado: " + (valor1 * valor2)).queue();
					evento.getChannel().sendTyping().queue();
					break;
				case "/":	
										
					if(valor2 != 0) {
					
						evento.getChannel().sendMessage("Resultado: " + (valor1 / valor2)).queue();
						evento.getChannel().sendTyping().queue();
					}else {
						evento.getChannel().sendMessage("Você é burro ou não sabe que é impossível dividir qualquer número por 0? Muuuh").queue();
						evento.getChannel().sendTyping().queue();
					}
					
					break;
				default:
					/*Caso o simbolo não corresponda*/
					evento.getChannel().sendMessage("Oque diabo de simbolo é esse?").queue();
					evento.getChannel().sendTyping().queue();
					break;
				}
			}catch (Exception e) {
				evento.getChannel().sendMessage("Meu amigo, eu só calculo 2 números, exemplo: ~calc num1 + num2.").queue();
				evento.getChannel().sendTyping().queue();
			}
		}
	}
}
