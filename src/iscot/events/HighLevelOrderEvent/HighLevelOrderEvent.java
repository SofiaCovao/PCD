package iscot.events.HighLevelOrderEvent;

import iscot.enums.Areas;
import iscot.enums.Type;
import iscot.events.Event;

public class HighLevelOrderEvent extends Event  {

	public HighLevelOrderEvent(Areas area, Type type) {
		super(area, type);
		
	}

}
