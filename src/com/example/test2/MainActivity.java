package com.example.test2;

import java.util.List;

import com.example.test2.common.CommonBaseAdapter;
import com.example.test2.common.RTimer;
import com.example.test2.common.TimeTaskAdapter;
import com.example.test2.common.TimerManager;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends Activity implements OnClickListener {
	public static List<RTimer> data=TimerManager.getInstance().getTimers();
	private TextView text;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		text=(TextView) findViewById(R.id.text);
		init();
	}
	private void init(){
		ListView list = (ListView) findViewById(R.id.list_view);
		findViewById(R.id.add).setOnClickListener(this);
		CommonBaseAdapter<RTimer> adapter = new TimeTaskAdapter(this,data,R.layout.list_item);
		TimerManager.getInstance().setAdapter(adapter);
		list.setAdapter(adapter);
	}
	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		switch (v.getId()) {
		case R.id.add:{
			String timer = text.getText().toString();
			if (timer.length() > 0) {
				TimerManager.getInstance().addTimer(Long.parseLong(timer));
			} else {
				Toast.makeText(this, "时间不能为空", Toast.LENGTH_SHORT).show();
			}
		}
		
		break;

		default:
			break;
		}
	}
}
