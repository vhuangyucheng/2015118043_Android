package com.example.finaldadishu;

import com.abc.ExitApplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class PatternActivity extends Activity{
	Button btnclassic,btnordinary,btnback,btnquit;
	RadioGroup Rgc,Rgo;
	RadioButton rbtnhard,rbtneasy,rbtncommon,rbtn10s,rbtn15s;
	ImageButton imgbtnexit,imgbtnback;
	
	private int timec=1000,timeo=11000;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pattern);
		ExitApplication.getInstance().addActivity(this);//记录activity
		
		btnclassic=(Button) findViewById(R.id.Btn_classic);
		btnordinary=(Button) findViewById(R.id.Btn_ordinary);
		
		Rgc=(RadioGroup) findViewById(R.id.Rg_classic);
		Rgo=(RadioGroup) findViewById(R.id.Rg_ordinary);
		rbtneasy=(RadioButton) findViewById(R.id.Rbtn_easy);
		rbtncommon=(RadioButton) findViewById(R.id.Rbtn_common);
		rbtnhard=(RadioButton) findViewById(R.id.Rbtn_hard);
		rbtn10s=(RadioButton) findViewById(R.id.Rbtn_10s);
		rbtn15s=(RadioButton) findViewById(R.id.Rbtn_15s);
		
		imgbtnback=(ImageButton) findViewById(R.id.imgbtn_back);
		imgbtnexit=(ImageButton) findViewById(R.id.imgbtn_exit);

		//****************创建intent**********
		
		
		
		
		//******经典模式***
		Rgc.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				int timec1 = 0;
				if(R.id.Rbtn_easy==arg1){
					timec1=1000;
				}
				else if(R.id.Rbtn_common==arg1){
					timec1=800;
				}
				else if(R.id.Rbtn_hard==arg1){
					timec1=580;
				}
				timec=timec1;
			}
		});
		//******普通模式*****
		Rgo.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg2) {
				if(R.id.Rbtn_10s==arg2){
					timeo=10100;
				}
				else if(R.id.Rbtn_15s==arg2){
					timeo=15100;
				}
				
			}
		});
		//*************button classic********
		btnclassic.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
			
				
				
				Intent classicintent=new Intent();
				classicintent.setClass(PatternActivity.this, classicgameActivity.class);
				classicintent.putExtra("Datac", timec+"");//安卓不支持传int类型
				startActivity(classicintent);
				
			}
		});
		
		btnordinary.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent ordinaryintent=new Intent();
				ordinaryintent.setClass(PatternActivity.this, ordinarygameActivity.class);
				ordinaryintent.putExtra("Datao", timeo+"");
				startActivity(ordinaryintent);
				
			}
		});

		imgbtnback.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			 finish();
				
			}
		});
		
		imgbtnexit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				ExitApplication.getInstance().exit(this);
				
			}
		});
	}
 

}
