package dondocabot.principal;

import javax.security.auth.login.LoginException;

import dondocabot.comandos.Calculadora;
import dondocabot.comandos.Commands;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class Bot {
	
	public static JDA jda;
	public static String prefixo = "~";
	public static final String token = "Njk2NDQ5NTUxNTE4NzkzODA4.XopjpQ.O5RIxkYd7MACumt7YUR8T-kML3o";
	
	public static void main(String[] args) {
		try {
			jda = JDABuilder.createDefault(token).build();
			//jda = new JDABuilder(AccountType.BOT).setToken("Njk2NDQ5NTUxNTE4NzkzODA4.XopjpQ.O5RIxkYd7MACumt7YUR8T-kML3o").build();
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jda.getPresence().setActivity(Activity.playing("GTA VI"));		
		jda.getPresence().setStatus(OnlineStatus.ONLINE); //status online
		
		jda.addEventListener(new Commands());//comandos genéricos
		jda.addEventListener(new Calculadora());//comando calculadora
		

	}

}
