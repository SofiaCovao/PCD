package iscot.client;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import iscot.client.gui.ACIcon;
import iscot.enums.AirConditioningMode;
import iscot.enums.Areas;
import iscot.enums.Type;
import iscot.events.HighLevelOrderEvent.AreaTemperatureOrderEvent;

public class AC {

	public static void main (String[] args) throws InterruptedException {
		
		if(args.length != 3) {
			System.err.print("Invalid Arguments!");
		} else {
			// Conectar com o servidor
			// Registar com o servidor
					
			Areas area = Areas.valueOf(args[2]);
						
			JFrame janela = new JFrame("AC em" + area);
			janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			JPanel painel = new JPanel();
			painel.setLayout(new BorderLayout());
			
			ACIcon AC = new ACIcon();
			painel.add(AC,BorderLayout.CENTER);
			
			janela.setContentPane(painel);
			janela.setLocation(600,400);
			janela.setMinimumSize(janela.getSize());
			janela.pack();
			janela.setVisible(true);
			
			AreaTemperatureOrderEvent eventoOn =
				    new AreaTemperatureOrderEvent(
				        area, Type.DECIDER, true
				    );


				if (eventoOn.getState()) {
				    AC.setModo(AirConditioningMode.Frio);
				}

				Thread.sleep(2000);

				// Criar uma ordem para desligar o ar condicionado
				AreaTemperatureOrderEvent eventoOff =
				    new AreaTemperatureOrderEvent(
				        area, Type.DECIDER, false
				    );

				// Processar o evento
				if (!eventoOff.getState()) {
				    AC.setModo(AirConditioningMode.Desligado);
				}
		}
	}
}
