package iscot.client;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import iscot.client.gui.LightIcon;
import iscot.enums.Areas;
import iscot.enums.Type;
import iscot.events.HighLevelOrderEvent.AreaLightingOrderEvent;

public class Light {

	public static void main (String [] args) throws InterruptedException {
		if (args.length != 3) {
			System.err.println ("Invalid Arguments");
		}
		else {
			// Conectar com o servidor
			// Registar com o servidor
		
			Areas area = Areas.valueOf(args[2]);
			
			//Parte Gráfica
			JFrame janela = new JFrame ("lâmpada em" + area);
			janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Quando clicamos em X para fechar a janela
			
			JPanel painel = new JPanel();
			painel.setLayout(new BorderLayout()); // Define a organização dos eventos dentro do painel
			
			LightIcon light = new LightIcon();
			painel.add(light, BorderLayout.CENTER);
			
			janela.setContentPane(painel);
			janela.setLocation(600,400);
			janela.setMinimumSize(janela.getSize());
			janela.pack();
			janela.setVisible(true);
			
			//Simulação de uma ordem para ligar a lâmpada
			Thread.sleep(2000);
			
			AreaLightingOrderEvent eventoOn = new AreaLightingOrderEvent(area, Type.DECIDER, true);
			light.setLigada(eventoOn.getState());
			
			//Simulação de uma ordem para desligar a lâmpada
			Thread.sleep(2000);
			
			AreaLightingOrderEvent eventoOff = new AreaLightingOrderEvent(area, Type.DECIDER, false);
			light.setLigada(eventoOff.getState());
		}
	}
}
