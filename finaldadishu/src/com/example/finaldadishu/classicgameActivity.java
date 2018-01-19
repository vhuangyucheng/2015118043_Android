package com.example.finaldadishu;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import com.abc.ExitApplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class classicgameActivity extends Activity{
	private TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txtout,txtsheng,txtzhuangtai;
    Button btnstart,btnover;
    private int[] arrays = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    ArrayList<TextView> texts;
    private int number;
    private int num=3;//机会
    private int flag=0;//按钮状态
    private int count=0;//打中计数
    private int timec,timec1;
    private Handler handler;  
    

	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
 
        setContentView(R.layout.classicgame);
        
        
        txt1=(TextView) findViewById(R.id.txt1);
        txt2=(TextView) findViewById(R.id.txt2);
        txt3=(TextView) findViewById(R.id.txt3);
        txt4=(TextView) findViewById(R.id.txt4);
        txt5=(TextView) findViewById(R.id.txt5);
        txt6=(TextView) findViewById(R.id.txt6);
        txt7=(TextView) findViewById(R.id.txt7);
        txt8=(TextView) findViewById(R.id.txt8);
        txt9=(TextView) findViewById(R.id.txt9);
        
        txtout=(TextView) findViewById(R.id.txtout);
        txtsheng=(TextView) findViewById(R.id.txtshengyu);
        //txtzhuangtai=(TextView) findViewById(R.id.txtzhuangtai);
        
        btnstart=(Button) findViewById(R.id.btn_start);
        btnover=(Button) findViewById(R.id.btn_over);
        //**************难度参数**********
        String Datac=getIntent().getStringExtra("Datac");  
        timec=Integer.parseInt(Datac);         
        timec1=timec;
        //************将textview放入数组*******
        texts = new ArrayList<TextView>();
        for (int i = 0; i < arrays.length; i++) {
            texts.add(txt1);
            texts.add(txt2);
            texts.add(txt3);
            texts.add(txt4);
            texts.add(txt5);
            texts.add(txt6);
            texts.add(txt7);
            texts.add(txt8);
            texts.add(txt9);

        }
    
      
        
        
        
        handler=new Handler();
        
        //*************开始按钮，开始游戏********
        btnstart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if(flag==0){
					for (TextView text : texts) {
			            text.setOnClickListener(new MyClickListener());
			        }
			        
				handler.postDelayed(runnable, 1);
				txtsheng.setText("游戏开始！请加油");
				
				txtout.setText("打了多少只地鼠："+count+" "+"只");//显示击打次数
				flag=1;
				btnstart.setText("暂停");
				
				}
				else{
					for (TextView text : texts) {
			            text.setOnClickListener(null);
			        }
					 for (int i = 0; i <9; i++) {
		        		 texts.get(i).setBackgroundResource(R.drawable.dong1);
						}
					handler.removeCallbacks(runnable);  
					btnstart.setText("开始");
					//txtzhuangtai.setText("暂停中...");
					flag=0;
				}
				
				
				}
		});
        //*********************************
        
        //****************结束按钮**************
        
        btnover.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			//	ExitApplication.getInstance().exit(this);
				finish();
			}
		});
        //************************************
        
  
   	 
      
   	  
   	  
   	  
    }
     
     //***************监听TextView点击中地鼠******
   private   class MyClickListener implements OnClickListener{
    	
		@Override
		public void onClick(View v) {
			
			
			
	
			
			 switch (v.getId()) {
		        case R.id.txt1:
		            if (number == 0) {
		            	
                         count++;
		            }
		            else { 
		           
		                num--;
		            }
		            break;
		
		
		         case R.id.txt2:
	                 if (number == 1) {
	                	 
	                	  count++;
	                 }
	                 else { 
			            	
			            	num--;
			            }
	                 break;
		
		          case R.id.txt3:
			          if (number == 2) {
			        	  
			        	  count++;
			           }
			          else { 
			            	
			            	num--;
			            }
			           break;
			
			
			      case R.id.txt4:
		                 if (number == 3) {
		                	
		                	  count++;
		                  }
		                 else { 
				            
				            	num--;
				            }
		                 break;
		                 
			      case R.id.txt5:
				          if (number == 4) {
				        	 
				        	  count++;
				           }
				          else { 
				            
				            	num--;
				            }
				           break;
				
				
				   case R.id.txt6:
			                  if (number == 5) {
			                	  
			                	  count++;
			                  }
			                  else { 
					            	
					            	num--;
					            }
			               break;
			               
				    case R.id.txt7:
					         if (number == 6) {
					        	 
					        	  count++;
					           }
					         else { 
					            	
					            	num--;
					            }
					           break;
					
			
			        case R.id.txt8:
				              if (number == 7) {
				            	  
				            	  count++;
				                }
				              else { 
					            	
					            	num--;
					            }
				                break;
				                
					 case R.id.txt9:
						        if (number == 8) {
						          
						            count++;
						         }
						        else { 
					            	
					            	num--;
					            }
						         break;
						            
					    default:
					                break;

		

				
			 }
			 if(num==3){
		   		  txtsheng.setText("剩余机会数："+num);
		   	  }
		   	  else if(num==2){
		   		txtsheng.setText("剩余机会数："+num);
		   	  }
		   	  else if(num==1){
		    		txtsheng.setText("剩余机会数："+num);
		    	  }  
		   	  else if(num==0){
				 handler.removeCallbacks(runnable); 
				 txtsheng.setText("游戏结束");
				 
				AlertDialog.Builder gameoverDialog =new AlertDialog.Builder(classicgameActivity.this);
				gameoverDialog.setTitle("游戏结束");//设置对话框标题    
			    gameoverDialog.setMessage("本次游戏点击中"+count+"次，"+"再玩一次游戏？");//设置显示的内容  
                gameoverDialog.setCancelable(false);//不能点击屏幕取消
			    gameoverDialog.setPositiveButton("确定",new DialogInterface.OnClickListener() {//添加确定按钮  
			         @Override    
			         public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件  
			        	    for (TextView text : texts) {
					            text.setOnClickListener(null);
					          }
			        	        btnstart.setText("开始");
			        	      //  txtzhuangtai.setText("");
			        	        count=0;  //点中次数清零
			        	        flag=0;   //按钮状态初始
			              		num=3;    //剩余机会初始
			              		timec=timec1;  //更新时间初始
			                    for (int i = 0; i < arrays.length; i++) {
			                    	texts.get(i).setBackgroundResource(R.drawable.dong1);
			                    }
			                   txtout.setText("请按“开始”按钮开始游戏");
			         }  
			  
			     });
                gameoverDialog.setNegativeButton("取消",new DialogInterface.OnClickListener() {//添加返回按钮  
			  
			          
			  
			         @Override  
			  
			         public void onClick(DialogInterface dialog, int which) {//响应事件  
			        	 
			        	 for (TextView text : texts) {
					            text.setOnClickListener(null);//点击时间关闭
					          }
			        	 for (int i = 0; i <9; i++) {
			        		 texts.get(i).setBackgroundResource(R.drawable.dong1);
							}
			        	 txtout.setText("一共点击中："+count+" 次");
			        	    count=0;
		        	        flag=0;
		              		num=3;
		              	    btnstart.setText("开始");
		              	  
			         }  
			  
			     }).show();//在按键响应事件中显示此对话框  
			  
			      
			  
			   
				 
		   	 }
			 txtout.setText("打了多少只地鼠："+count+" "+"只");
			 
		}
    	  
      }
     
     
     
     
   //*****************线程,定时每隔多长时间发送一次数据***
      
     Runnable runnable=new Runnable() {  
         @Override  
         public void run() {  
             // TODO Auto-generated method stub  
        	 number = (int) (Math.random() * 9); //随机产生9个数
            // System.out.println(number);
             for (int i = 0; i < arrays.length; i++) {
                 if (i == number) {
                	 
                	 //给产生的随机数对应的textview设置地鼠图
                     texts.get(i).setBackgroundResource(R.drawable.dishu1);
                 } else {
                	 texts.get(i).setBackgroundResource(R.drawable.dong1);
             
                 }
             }
             //更新时间减少
             if(timec>250){
            	 timec=timec-5;
             }
             handler.postDelayed(this, timec); //设置定时时间 单位毫秒  
         }  
     };  
}
