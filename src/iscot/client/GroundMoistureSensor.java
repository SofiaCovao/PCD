
package iscot.client;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import iscot.client.gui.SensorControl;
import iscot.enums.Areas;
import iscot.enums.Type;
import iscot.events.SensorEvent.GroundMoistureSensorEvent;

public class GroundMoistureSensor {

    public static void main(String[] args) throws InterruptedException {

        if (args.length != 3) {
            System.err.println("Invalid arguments!");
        } else {

            // TODO connect to the server
            // TODO register with the server

            Areas area = Areas.valueOf(args[2]);

            JFrame janela = new JFrame("Humidade do solo em " + area);
            janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            // Criar os componentes gráficos
            JPanel painel = new JPanel();
            painel.setLayout(new BorderLayout());

            SensorControl sensorControl = new SensorControl(
                "🌱",
                "Humidade do solo - " + area,
                "%",
                0, 100, 1, 50,
                valor -> {

                    GroundMoistureSensorEvent evento =
                        new GroundMoistureSensorEvent(area, Type.SENSOR, valor);

                    System.out.println("Área: " + evento.getArea());
                    System.out.println("Tipo: " + evento.getType());
                    System.out.println("Humidade do solo: " +
                                       evento.getGroundMoisture());
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
