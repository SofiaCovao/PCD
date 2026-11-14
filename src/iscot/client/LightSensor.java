package iscot.client;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import iscot.client.gui.LightIcon;
import iscot.client.gui.SensorControl;
import iscot.enums.Areas;
import iscot.enums.Type;
import iscot.events.SensorEvent.LightSensorEvent;


public class LightSensor {
	public static void main(String[] args) throws NumberFormatException, InterruptedException {
		if(args.length!=3) {
			System.err.println("Invalid arguments!");
		}
		else {
			// TODO connect to the server

			// TODO register with the server
			Areas area=Areas.valueOf(args[2]);
			

			JFrame janela = new JFrame("Luminosidade em "+area);
			janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			
			// Criar os componentes gráficos
			JPanel painel=new JPanel();
			painel.setLayout(new BorderLayout());
			SensorControl sensorControl= new SensorControl( "💡", "Luminosidade - "+area, "lux",
				    0, 1000, 1, 50,
				    valor -> {
				    	LightSensorEvent evento = new LightSensorEvent(area, Type.SENSOR, valor);
				    	
				    	System.out.println("Área: " + evento.getArea());
				    	System.out.println("Tipo: " + evento.getType());
				    	System.out.println("Luminosidade: " + evento.getLight());
				    	
				    	
				    });
			painel.add(sensorControl,BorderLayout.CENTER);
			janela.setContentPane(painel);
			janela.setLocation(600, 400);
			janela.setMinimumSize(janela.getSize());
			janela.pack();
			janela.setVisible(true);
			
		}
	}

} 


