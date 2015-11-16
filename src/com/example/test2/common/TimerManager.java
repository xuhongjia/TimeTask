package com.example.test2.common;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.os.Handler;
import android.os.Message;
import android.widget.BaseAdapter;


public class TimerManager {
	private static TimerManager _manager = new TimerManager();

	private Timer timer = new Timer("timerTask", true);
	private final List<RTimer> mTimers = new LinkedList<RTimer>();
	private CommonBaseAdapter<?> adapter = null;
	private static int i =0;
	private Handler mHandler = new Handler(){
		public void handleMessage(Message msg)
		{
			if(msg.what==10000)
				adapter.OnUpData();
		}
	};

	private TimerManager() {
		timer.schedule(task, 0, 100);
	}

	public static TimerManager getInstance() {
		return _manager;
	}

	private TimerTask task = new TimerTask() {
		@Override
		public void run() {
			i++;
			if(i%10==0){
				for (RTimer timer : mTimers) {
					if (timer.remainTime <= 0) {
						timer.status = RTimer.STATUS_STOPED;
					} else if (timer.status == RTimer.STATUS_RUNNING) {
						timer.remainTime--;
					}
				}
				if (adapter != null) {
					mHandler.sendEmptyMessage(10000);
				}
				i=0;
			}
		}
	};

	//	private final Runnable runnable = new Runnable() {
	//		@Override
	//		public void run() {
	//			adapter.notifyDataSetChanged();
	//		}
	//	};

	public final void setAdapter(CommonBaseAdapter<?> adapter) {
		this.adapter = adapter;
	}

	public final List<RTimer> getTimers() {
		return mTimers;
	}

	public final void addTimer(RTimer timer) {
		mTimers.add(0, timer);
		if (adapter != null) {
			adapter.notifyDataSetChanged();
		}
	}

	public final void addTimer(long time) {
		mTimers.add(0, new RTimer(time));
		if (adapter != null) {
			adapter.notifyDataSetChanged();
		}
	}
}
