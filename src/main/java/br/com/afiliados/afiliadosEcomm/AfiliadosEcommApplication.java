package br.com.afiliados.afiliadosEcomm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SpringBootApplication
@EnableWebMvc
public class AfiliadosEcommApplication {

	public static void main(String[] args) {
		SpringApplication.run(AfiliadosEcommApplication.class, args);

	}
}
