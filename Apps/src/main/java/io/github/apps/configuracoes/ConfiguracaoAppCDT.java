package io.github.apps.configuracoes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import io.github.apps.configuracoes.ambientes.Cdt;
import io.github.apps.interfaces.ExibirAmbiente;

@Configuration
@Profile("cdt")
public class ConfiguracaoAppCDT {

	@Cdt
	ExibirAmbiente exibirAmbiente;
	
	@Value("${aplicacao.ambiente}")
	String appAmbiente;
	
	@Bean
	CommandLineRunner executarCDT() {
		return args -> {
			this.exibirAmbiente.exibir();
		};
	}
	
}
