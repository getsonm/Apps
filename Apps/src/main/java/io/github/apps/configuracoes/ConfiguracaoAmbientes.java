package io.github.apps.configuracoes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.apps.interfaces.ExibirAmbiente;

@Configuration
public class ConfiguracaoAmbientes {

	@Bean(name = "Cdt")
	ExibirAmbiente cdt() {
		return new ExibirAmbiente() {
			@Override
			public void exibir() {
				System.out.println(" ██████╗██████╗ ████████╗");
				System.out.println("██╔════╝██╔══██╗╚══██╔══╝");
				System.out.println("██║     ██║  ██║   ██║   ");
				System.out.println("██║     ██║  ██║   ██║   ");
				System.out.println("╚██████╗██████╔╝   ██║   ");
				System.out.println(" ╚═════╝╚═════╝    ╚═╝   ");
			}
		};
	}
	
	 @Bean(name = "Qa")
	 ExibirAmbiente qa() {
		return new ExibirAmbiente() {
			@Override
			public void exibir() {
				System.out.println(" ██████╗  █████╗ ");
				System.out.println("██╔═══██╗██╔══██╗");
				System.out.println("██║   ██║███████║");
				System.out.println("██║▄▄ ██║██╔══██║");
				System.out.println("╚██████╔╝██║  ██║");
				System.out.println(" ╚══▀▀═╝ ╚═╝  ╚═╝");
			}
		};
	}

	 @Bean(name = "Prod")
	 ExibirAmbiente prod() {
		return new ExibirAmbiente() {
			@Override
			public void exibir() {
				System.out.println("██████╗ ██████╗  ██████╗ ██████╗ ");
				System.out.println("██╔══██╗██╔══██╗██╔═══██╗██╔══██╗");
				System.out.println("██████╔╝██████╔╝██║   ██║██║  ██║");
				System.out.println("██╔═══╝ ██╔══██╗██║   ██║██║  ██║");
				System.out.println("██║     ██║  ██║╚██████╔╝██████╔╝");
				System.out.println("╚═╝     ╚═╝  ╚═╝ ╚═════╝ ╚═════╝ ");
			}
		};
	}
}
