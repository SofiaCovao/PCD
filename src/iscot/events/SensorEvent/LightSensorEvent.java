package iscot.events.SensorEvent;

import iscot.enums.Areas;
import iscot.enums.Type;

public class LightSensorEvent extends SensorEvent {
private final double light;
	public LightSensorEvent(Areas area, Type type, double light) {
		super(area, type);
		this.light=light;
		
	}
public double getLight() {
	return light;
}
}
