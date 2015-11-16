package com.example.test2.common;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

import android.R.integer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.TextView;

public class Timer2 extends CountDownTimer  {

	private TextView view;
	private Button button;
	private Handler handler;
	
	private int i;
	private int j=0;
	SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
	public Timer2(long millisInFuture, long countDownInterval,TextView view,Button button,Handler handler,int i) {
		super(millisInFuture, countDownInterval);
		// TODO 鑷姩鐢熸垚鐨勬瀯閫犲嚱鏁板瓨鏍�
		df.setTimeZone(TimeZone.getTimeZone("UTC"));
		this.view=view;
		this.button=button;
		view.setText(df.format(millisInFuture));
		this.handler=handler;
		this.i=i;
	}

	
	@Override
	public void onTick(long millisUntilFinished) {
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
		view.setText(df.format(millisUntilFinished));
		j++;
		Message message =new Message();
		message.what=100;
		message.arg1=i;
		message.arg2=j;
		handler.sendMessage(message);
	}

	@Override
	public void onFinish() {
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
		view.setText("00:00:00");
		button.setText("已停止");
		button.setEnabled(false);
	}
	
	
}
