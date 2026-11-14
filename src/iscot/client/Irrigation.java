
package iscot.client;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import iscot.client.gui.IrrigationIcon;
import iscot.enums.Areas;
import iscot.enums.Type;
import iscot.events.HighLevelOrderEvent.AreaIrrigationOrderEvent;

public class Irrigation {

    public static void main(String[] args) throws InterruptedException {

        if (args.length != 3) {
            System.err.println("Invalid arguments!");
        } else {

            // TODO Conectar com o servidor
            // TODO Registar com o servidor

            Areas area = Areas.valueOf(args[2]);

            JFrame janela = new JFrame("Rega em " + area);
            janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JPanel painel = new JPanel();
            painel.setLayout(new BorderLayout());

            IrrigationIcon irrigation = new IrrigationIcon();

            painel.add(irrigation, BorderLayout.CENTER);

            janela.setContentPane(painel);
            janela.setLocation(600, 400);
            janela.pack();
            janela.setVisible(true);

        
            AreaIrrigationOrderEvent eventoLigar =
                new AreaIrrigationOrderEvent(area, Type.DECIDER, true);

            irrigation.setAtiva(eventoLigar.getState());

            Thread.sleep(2000);

           
            AreaIrrigationOrderEvent eventoDesligar =
                new AreaIrrigationOrderEvent(area, Type.DECIDER, false);

            irrigation.setAtiva(eventoDesligar.getState());
        }
    }
}
