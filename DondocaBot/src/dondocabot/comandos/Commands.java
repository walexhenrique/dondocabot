package dondocabot.comandos;

import dondocabot.auxilares.FrasesCiclos;
import dondocabot.principal.Bot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter{
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent evento) {
		String[] args = evento.getMessage().getContentRaw().split("\\s+");
		
		//Tela de informações
		if(args[0].equalsIgnoreCase(Bot.prefixo + "info") || args[0].equalsIgnoreCase(Bot.prefixo + "help") || args[0].equalsIgnoreCase(Bot.prefixo + "ajuda")) {
			EmbedBuilder info = new EmbedBuilder();
			info.setTitle("Informações");
			info.setDescription("O Bot Dondoca é uma forma de testar conhecimento, desenvolvida em Java de código aberto."
					+ " Feito de forma simples, possui poucas funcionalidades porém com o tempo vai estar evoluindo ainda mais!");
			info.addField("Criadores", "Xipito e TwGoblin", false);
			info.setColor(0x7077C0);
			
			info.addField("Comandos", "~Calc\n~Bom dia\n~Boa noite\n~Boa tarde\n~Info\n~Muuh", false);

			evento.getChannel().sendMessage(info.build()).queue();
			evento.getChannel().sendTyping().queue();
			
			info.clear();
		}
		
		/*Mensagens de bom dia, boa tarde, boa noite*/
		if(args[0].equalsIgnoreCase(Bot.prefixo + "bom") || args[0].equalsIgnoreCase(Bot.prefixo + "boa")  && !args[1].equalsIgnoreCase(null)) {
			String frase = FrasesCiclos.educar(args[1]);
			if(frase != null) {
				
				evento.getChannel().sendMessage(frase).queue();
				evento.getChannel().sendTyping().queue();
			}
		}
		
		//mensagem muuh do bot
		if(args[0].equalsIgnoreCase(Bot.prefixo + "muuh")) {
			evento.getChannel().sendTyping().queue();
			evento.getChannel().sendMessage("Muuuuuuh").queue();
		}
		
		
	}
}
