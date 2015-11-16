package com.example.test2.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class RTimer {
	public long remainTime;
	public int status;
	public final static int STATUS_RUNNING = 0;
	public final static int STATUS_PAUSED = 1;
	public final static int STATUS_STOPED = 2;

	private final static DateFormat df = new SimpleDateFormat("HH:mm:ss");

	public RTimer(long time) {
		this.remainTime = time;
		this.status = 0;
		df.setTimeZone(TimeZone.getTimeZone("UTC"));
	}

	public String toString() {
		return df.format(remainTime * 1000);
	}
}
