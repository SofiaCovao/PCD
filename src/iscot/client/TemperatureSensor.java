
package iscot.client;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import iscot.client.gui.SensorControl;
import iscot.enums.Areas;
import iscot.enums.Type;
import iscot.events.SensorEvent.TemperatureSensorEvent;

public class TemperatureSensor {

    public static void main(String[] args) throws InterruptedException {

        if (args.length != 3) {
            System.err.println("Invalid arguments!");
        } else {

            // TODO connect to the server
            // TODO register with the server

            Areas area = Areas.valueOf(args[2]);

            JFrame janela = new JFrame("Temperatura em " + area);
            janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JPanel painel = new JPanel();
            painel.setLayout(new BorderLayout());

            SensorControl sensorControl = new SensorControl(
                "🌡",
                "Temperatura - " + area,
                "°C",
                -10, 50, 1, 22,
                valor -> {

                    TemperatureSensorEvent evento =
                        new TemperatureSensorEvent(area, Type.SENSOR, valor);

                    System.out.println("Área: " + evento.getArea());
                    System.out.println("Tipo: " + evento.getType());
                    System.out.println("Temperatura: " +
                                       evento.getTemperature() + " °C");
                }
            );

            painel.add(sensorControl, BorderLayout.CENTER);

            janela.setContentPane(painel);
            janela.setLocation(600, 400);
            janela.pack();
            janela.setVisible(true);
        }
    }
}
