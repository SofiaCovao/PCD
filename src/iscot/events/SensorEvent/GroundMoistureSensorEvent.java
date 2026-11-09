package iscot.events.SensorEvent;

import iscot.enums.Areas;
import iscot.enums.Type;

public class GroundMoistureSensorEvent extends SensorEvent {
	private final double groundMoisture;

	public GroundMoistureSensorEvent(Areas area, Type type, double groundMoisture) {
		super(area, type);
		this.groundMoisture=groundMoisture;
		
	}

	public double getGroundMiosture() {
		return groundMoisture;
	}
}
