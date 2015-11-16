package com.example.test2.common;

import java.util.List;

import com.example.test2.R;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TimeTaskAdapter extends CommonBaseAdapter<RTimer> implements OnClickListener {

	public TimeTaskAdapter(Context context, List<RTimer> datas, int layoutId) {
		super(context, datas, layoutId);
	}

	@Override
	public void convert(ViewHolder holder, RTimer t) {
		holder.setText(R.id.time,t.toString());
		Button button = holder.getView(R.id.go);
		button.setOnClickListener(this);
		button.setTag(t);
		if (t.status == RTimer.STATUS_PAUSED) {
			button.setText("Æô¶¯");
		} else if (t.status == RTimer.STATUS_RUNNING) {
			button.setText("ÔÝÍ£");
		} else {
			button.setText("ÒÑÍ£Ö¹");
		}
	}

	@Override
	public void OnUpData() {
		this.notifyDataSetChanged();
	}

	@Override
	public void onClick(View v) {
		Button button = (Button) v;
		Object data = v.getTag();
		if (data != null && data instanceof RTimer) {
			RTimer t = ((RTimer) data);
			if (t.remainTime <= 0) {
				t.status = RTimer.STATUS_STOPED;
				button.setText("ÒÑÍ£Ö¹");
				t.remainTime = 0;
			} else {
				if (t.status == RTimer.STATUS_PAUSED) {
					t.status = RTimer.STATUS_RUNNING;
					button.setText("ÔÝÍ£");
				} else if (t.status == RTimer.STATUS_RUNNING) {
					t.status = RTimer.STATUS_PAUSED;
					button.setText("Æô¶¯");
				}
			}
		}
	}
}
