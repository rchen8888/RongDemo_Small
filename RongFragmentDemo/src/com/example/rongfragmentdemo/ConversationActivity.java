package com.example.rongfragmentdemo;

import io.rong.imkit.RongContext;
import io.rong.imkit.RongIM;
import io.rong.imkit.widget.provider.VoiceInputProvider;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.widget.TextView;

public class ConversationActivity extends FragmentActivity {
	
	private TextView mTextView;
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.conversation_activity);
		mTextView = (TextView) findViewById(R.id.title);
		mTextView.setText(getIntent().getData().getQueryParameter("title"));
		
		RongIM.setPrimaryInputProvider(new VoiceInputProvider(RongContext.getInstance())); 
	}
}
