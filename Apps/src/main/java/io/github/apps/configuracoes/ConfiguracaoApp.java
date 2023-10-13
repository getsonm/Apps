package io.github.apps.configuracoes;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracaoApp {

	@Value("${aplicacao.ambiente}")
	String appAmbiente;
	
	@Bean(name = "appNome")
	String appNome() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String d1 = dateFormat.format(date);
		return  "<H1 style=\"background-color:Lime;\"> Programa em execução no ambiente..: " + appAmbiente + " - " + d1 + "</H1>";
	}
	
}
