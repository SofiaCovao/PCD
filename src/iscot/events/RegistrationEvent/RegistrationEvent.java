package iscot.events.RegistrationEvent;

import iscot.enums.Areas;
import iscot.enums.Type;
import iscot.events.Event;

public class RegistrationEvent extends Event {

	public RegistrationEvent(Areas area, Type type) {
		super(area, type);
		
	}

}
