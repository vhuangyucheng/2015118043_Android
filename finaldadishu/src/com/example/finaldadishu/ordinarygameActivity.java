package com.example.finaldadishu;

import java.util.ArrayList;

import com.abc.ExitApplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
public class ordinarygameActivity extends Activity {
	private TextView txt2_1,txt2_2,txt2_3,txt2_4,txt2_5,txt2_6,txt2_7,txt2_8,txt2_9,txt2out,txt2time,txt2zhuangtai;
    Button btn2start,btn2over;
    ArrayList<TextView> texts;
    private int number;
    private int count=0;//打中计数
    private Handler handler;  
    private int i=1;  //按钮状态
    private int timeo;
   
   private MyCount mc;
   private CountDownTimer countDownTimer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	
		 setContentView(R.layout.ordinarygame);
	        
	        txt2_1=(TextView) findViewById(R.id.txt2_1);
	        txt2_2=(TextView) findViewById(R.id.txt2_2);
	        txt2_3=(TextView) findViewById(R.id.txt2_3);
	        txt2_4=(TextView) findViewById(R.id.txt2_4);
	        txt2_5=(TextView) findViewById(R.id.txt2_5);
	        txt2_6=(TextView) findViewById(R.id.txt2_6);
	        txt2_7=(TextView) findViewById(R.id.txt2_7);
	        txt2_8=(TextView) findViewById(R.id.txt2_8);
	        txt2_9=(TextView) findViewById(R.id.txt2_9);
	        
	        txt2out=(TextView) findViewById(R.id.txt2_out);
	        txt2time=(TextView) findViewById(R.id.txt2_time);
	
	     
	        btn2start=(Button) findViewById(R.id.btn2_start);
	        btn2over=(Button) findViewById(R.id.btn2_over);
	        //*****获取上个界面传来的时间参数****************
	       
	        String Datao=getIntent().getStringExtra("Datao");  
	        timeo=Integer.parseInt(Datao);         
	        
	        //************************
	        
	        
	        mc = new MyCount(timeo, 1000);  //设置倒计时Mycount(倒计时时间,ontick);
	        handler=new Handler();
	        
	       
	        texts = new ArrayList<TextView>();
	        for (int i = 0; i < 9; i++) {
	            texts.add(txt2_1);
	            texts.add(txt2_2);
	            texts.add(txt2_3);
	            texts.add(txt2_4);
	            texts.add(txt2_5);
	            texts.add(txt2_6);
	            texts.add(txt2_7);
	            texts.add(txt2_8);
	            texts.add(txt2_9);

	        }
	        
	       btn2start.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					
					
					if(i==1){
						mc.start();  //开启计时
						for (TextView text : texts) {
				            text.setOnClickListener(new MyClickListener());
				        }
				        
						handler.postDelayed(runnable, 10);//开启线程
						
						i=0;
					   btn2start.setText("停止");
					   txt2out.setText("游戏开始");
					}
					else{
						for (int i = 0; i <9; i++) {
							texts.get(i).setBackgroundResource(R.drawable.dong1);
						}
						 btn2start.setText("重新开始");
						handler.removeCallbacks(runnable);//关闭线程
						mc.cancel();   //关闭计时
						count=0;   //打中次数清零
						i=1;
						txt2out.setText("游戏停止");
						
					}
				}
			});
	       
	       btn2over.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 //ExitApplication.getInstance().exit(this);
				finish();
			}
		});
	        
	    }
	  
	    /*定义一个倒计时的内部类*/  
	    class MyCount extends CountDownTimer {     
	        public MyCount(long millisInFuture, long countDownInterval) {     
	            super(millisInFuture, countDownInterval);     
	        }     
	        @Override     
	        public void onFinish() {  //计时结束   
	          txt2time.setText("时间到！游戏结束！");
	          txt2out.setText("一共点击中："+count+" "+"次");
	          handler.removeCallbacks(runnable);
	      	   for (TextView text : texts) {
	            text.setOnClickListener(null);
	             }
	            count=0;
	            btn2start.setText("重新开始");
	            i=1;
	            
	            for (int i = 0; i <9; i++) {
	            	texts.get(i).setBackgroundResource(R.drawable.dong1);
              }
	            
	        }     
	        @Override     
	        public void onTick(long millisUntilFinished) {     
	        	//ti= (int) millisUntilFinished/1000;
	            txt2time.setText("倒计时   " + millisUntilFinished / 1000 + "  秒"); 
	              //每隔一秒更新一次倒计时数 
	        }    
	    }   
	    

      //*****textview监听点击事件************
	 private   class MyClickListener implements OnClickListener{
	    	
			@Override
			public void onClick(View v) {
								
			  switch (v.getId()) {
			      case R.id.txt2_1:
			           if (number == 0) {
			            	
	                         count++;
			            }
			      
			            break;
			
			
			       case R.id.txt2_2:
		                 if (number == 1) {
		                	 
		                	  count++;
		                 }
		           
		                 break;
			
			       case R.id.txt2_3:
				          if (number == 2) {
				        	  
				        	  count++;
				           }
				      
				           break;
				
				
				   case R.id.txt2_4:
			                 if (number == 3) {
			                	  count++;
			                  }			             
			                 break;
			                 
				   case R.id.txt2_5:
					          if (number == 4) {					        	 
					        	  count++;
					           }					    
					           break;
					
					
				   case R.id.txt2_6:
				                  if (number == 5) {				                	  
				                	  count++;
				                  }				               
				               break;
				               
				   case R.id.txt2_7:
						         if (number == 6) {						        	 
						        	  count++;
						           }						        
						           break;
						
				
				   case R.id.txt2_8:
					              if (number == 7) {					            	  
					            	  count++;
					                }					             
					                break;
					                
					case R.id.txt2_9:
							        if (number == 8) {							          
							            count++;
							         }							 
							         break;
							            
					  default:
						             break;

					
				 }
				 txt2out.setText("点击中的次数："+count+" "+"次");
			}
	 }
	    //**********线程************
	    Runnable runnable=new Runnable() {  
	        int t=350;
	    	@Override  
	        public void run() {  	          
	       	 number = (int) (Math.random() * 9); //随机产生9个数	           
	            for (int i = 0; i < 9; i++) {
	                if (i == number) {
                          //给产生的随机数对应的textview设置地鼠图
	                    texts.get(i).setBackgroundResource(R.drawable.dishu1);
	                } else {
	                	texts.get(i).setBackgroundResource(R.drawable.dong1);
	            
	                }
	            }
	            if(t>200){
	            	t=t-5;
	            }
	            handler.postDelayed(this, t); //设置定时时间 单位毫秒  
	        }  
	    };  
	    
	    
	    
	}  
