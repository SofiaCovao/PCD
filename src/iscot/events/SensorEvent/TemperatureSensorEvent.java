package iscot.events.SensorEvent;

import iscot.enums.Areas;
import iscot.enums.Type;

public class TemperatureSensorEvent extends SensorEvent{
	private final double temperature;

	public TemperatureSensorEvent(Areas area, Type type, double temperature) {
		super(area, type);
		this.temperature=temperature;
		
	}
	public double getTemperature() {
		return temperature;
	}

}
