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
    private int num=3;//����
    private int flag=0;//��ť״̬
    private int count=0;//���м���
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
        //**************�ѶȲ���**********
        String Datac=getIntent().getStringExtra("Datac");  
        timec=Integer.parseInt(Datac);         
        timec1=timec;
        //************��textview��������*******
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
        
        //*************��ʼ��ť����ʼ��Ϸ********
        btnstart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if(flag==0){
					for (TextView text : texts) {
			            text.setOnClickListener(new MyClickListener());
			        }
			        
				handler.postDelayed(runnable, 1);
				txtsheng.setText("��Ϸ��ʼ�������");
				
				txtout.setText("���˶���ֻ����"+count+" "+"ֻ");//��ʾ�������
				flag=1;
				btnstart.setText("��ͣ");
				
				}
				else{
					for (TextView text : texts) {
			            text.setOnClickListener(null);
			        }
					 for (int i = 0; i <9; i++) {
		        		 texts.get(i).setBackgroundResource(R.drawable.dong1);
						}
					handler.removeCallbacks(runnable);  
					btnstart.setText("��ʼ");
					//txtzhuangtai.setText("��ͣ��...");
					flag=0;
				}
				
				
				}
		});
        //*********************************
        
        //****************������ť**************
        
        btnover.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			//	ExitApplication.getInstance().exit(this);
				finish();
			}
		});
        //************************************
        
  
   	 
      
   	  
   	  
   	  
    }
     
     //***************����TextView����е���******
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
		   		  txtsheng.setText("ʣ���������"+num);
		   	  }
		   	  else if(num==2){
		   		txtsheng.setText("ʣ���������"+num);
		   	  }
		   	  else if(num==1){
		    		txtsheng.setText("ʣ���������"+num);
		    	  }  
		   	  else if(num==0){
				 handler.removeCallbacks(runnable); 
				 txtsheng.setText("��Ϸ����");
				 
				AlertDialog.Builder gameoverDialog =new AlertDialog.Builder(classicgameActivity.this);
				gameoverDialog.setTitle("��Ϸ����");//���öԻ������    
			    gameoverDialog.setMessage("������Ϸ�����"+count+"�Σ�"+"����һ����Ϸ��");//������ʾ������  
                gameoverDialog.setCancelable(false);//���ܵ����Ļȡ��
			    gameoverDialog.setPositiveButton("ȷ��",new DialogInterface.OnClickListener() {//���ȷ����ť  
			         @Override    
			         public void onClick(DialogInterface dialog, int which) {//ȷ����ť����Ӧ�¼�  
			        	    for (TextView text : texts) {
					            text.setOnClickListener(null);
					          }
			        	        btnstart.setText("��ʼ");
			        	      //  txtzhuangtai.setText("");
			        	        count=0;  //���д�������
			        	        flag=0;   //��ť״̬��ʼ
			              		num=3;    //ʣ������ʼ
			              		timec=timec1;  //����ʱ���ʼ
			                    for (int i = 0; i < arrays.length; i++) {
			                    	texts.get(i).setBackgroundResource(R.drawable.dong1);
			                    }
			                   txtout.setText("�밴����ʼ����ť��ʼ��Ϸ");
			         }  
			  
			     });
                gameoverDialog.setNegativeButton("ȡ��",new DialogInterface.OnClickListener() {//��ӷ��ذ�ť  
			  
			          
			  
			         @Override  
			  
			         public void onClick(DialogInterface dialog, int which) {//��Ӧ�¼�  
			        	 
			        	 for (TextView text : texts) {
					            text.setOnClickListener(null);//���ʱ��ر�
					          }
			        	 for (int i = 0; i <9; i++) {
			        		 texts.get(i).setBackgroundResource(R.drawable.dong1);
							}
			        	 txtout.setText("һ������У�"+count+" ��");
			        	    count=0;
		        	        flag=0;
		              		num=3;
		              	    btnstart.setText("��ʼ");
		              	  
			         }  
			  
			     }).show();//�ڰ�����Ӧ�¼�����ʾ�˶Ի���  
			  
			      
			  
			   
				 
		   	 }
			 txtout.setText("���˶���ֻ����"+count+" "+"ֻ");
			 
		}
    	  
      }
     
     
     
     
   //*****************�߳�,��ʱÿ���೤ʱ�䷢��һ������***
      
     Runnable runnable=new Runnable() {  
         @Override  
         public void run() {  
             // TODO Auto-generated method stub  
        	 number = (int) (Math.random() * 9); //�������9����
            // System.out.println(number);
             for (int i = 0; i < arrays.length; i++) {
                 if (i == number) {
                	 
                	 //���������������Ӧ��textview���õ���ͼ
                     texts.get(i).setBackgroundResource(R.drawable.dishu1);
                 } else {
                	 texts.get(i).setBackgroundResource(R.drawable.dong1);
             
                 }
             }
             //����ʱ�����
             if(timec>250){
            	 timec=timec-5;
             }
             handler.postDelayed(this, timec); //���ö�ʱʱ�� ��λ����  
         }  
     };  
}
