package iscot.events.HighLevelOrderEvent;

import iscot.enums.Areas;
import iscot.enums.Type;


public class AreaTemperatureOrderEvent extends HighLevelOrderEvent {

	private final boolean state;
	
	public AreaTemperatureOrderEvent(Areas area, Type type, boolean state) {
		super(area, type);
		this.state=state;
		
	}
	
	public boolean getState() {
		return state;
	}
}
