package com.study.eventlistener;

import java.util.EventListener;

public interface DoorListener extends EventListener{
	public void doorEvent(DoorEvent event);
}
