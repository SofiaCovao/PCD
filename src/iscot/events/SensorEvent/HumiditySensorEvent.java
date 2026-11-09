package iscot.events.SensorEvent;

import iscot.enums.Areas;
import iscot.enums.Type;

public class HumiditySensorEvent extends SensorEvent {
	private final double humidity;

	public HumiditySensorEvent(Areas area, Type type, double humidity) {
		super(area, type);
		this.humidity=humidity; 
		
	}

	public double getHumidity() {
		return humidity;
	}
	
}
