package com.example.finaldadishu;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.abc.ExitApplication;


public class MainActivity extends Activity {
     ImageButton imgbtnlogin;
     Button btn1_shezhi,btn1_xiugai;
     EditText ed_password;
     private String text_input;
	 private String text_output;
	 private OutputStream os;//�ļ������
	 private InputStream is;//�ļ�������
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      
        setContentView(R.layout.activity_main);
        
        ExitApplication.getInstance().addActivity(this);//��¼activity
        
        ed_password=(EditText) findViewById(R.id.ed_password);
        
        btn1_shezhi=(Button) findViewById(R.id.btn_shezhi);
        btn1_xiugai=(Button) findViewById(R.id.btn_xiugai);
        
        imgbtnlogin=(ImageButton) findViewById(R.id.imgbtnlogin);
        
        //****************��������******************
        btn1_shezhi.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				AlertDialog.Builder customizeDialogfirst=new AlertDialog.Builder(MainActivity.this);
		    	final View dialogView=LayoutInflater.from(MainActivity.this).inflate(R.layout.inlayout, null);
		    	
		    	customizeDialogfirst.setTitle("��������");
		    	customizeDialogfirst.setView(dialogView);
		    	customizeDialogfirst.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
					
		    		EditText Edfirstpassword=(EditText) dialogView.findViewById(R.id.Ed_first_password);
		    		EditText Edsecondpassword=(EditText) dialogView.findViewById(R.id.Ed_second_password);
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
					   if(Edfirstpassword.getText().length()!=0){
						   //�ж����������Ƿ�һ��
					      	if(Edfirstpassword.getText().toString().equals(Edsecondpassword.getText().toString())){
							    text_input=Edsecondpassword.getText().toString();
							     saveFile();//�洢���ݵ��ļ�
							     Toast.makeText(MainActivity.this,"�������óɹ�" , Toast.LENGTH_SHORT).show();
						      }
						     else{
							     Toast.makeText(MainActivity.this,"��������ʧ�ܣ�" , Toast.LENGTH_SHORT).show();
						     }
					     }
					   
					   else{
						   Toast.makeText(MainActivity.this,"δ��������" , Toast.LENGTH_SHORT).show();
						   
					   }
					}
				});
		    	customizeDialogfirst.show();	
				
			}
		});
       
       //****************�޸�����******************
        btn1_xiugai.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				AlertDialog.Builder customizeDialogsecond=new AlertDialog.Builder(MainActivity.this);
		    	final View dialogView1=LayoutInflater.from(MainActivity.this).inflate(R.layout.gailayout, null);
		    	
		    	customizeDialogsecond.setTitle("�����޸�");
		    	customizeDialogsecond.setView(dialogView1);
		    	customizeDialogsecond.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
					
		    		EditText Edoldpassword=(EditText) dialogView1.findViewById(R.id.EdOld_password);
		    		EditText Ednewpassword=(EditText) dialogView1.findViewById(R.id.EdNew_password);
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						openFile();
						
						//*************
					
						if(Edoldpassword.getText().toString().equals(text_output.trim())){
							 if(Ednewpassword.getText().length()!=0){
								 text_input=Ednewpassword.getText().toString();
								 saveFile();
								 Toast.makeText(MainActivity.this,"�޸ĳɹ�" , Toast.LENGTH_SHORT).show();								 
							 }
							 else{
								 Toast.makeText(MainActivity.this,"�޸�ʧ��" , Toast.LENGTH_SHORT).show();
							 }
							
						}else{
							Toast.makeText(MainActivity.this,"ԭ�����������" , Toast.LENGTH_SHORT).show();
							
						}
						
						
					}
				});
		    	customizeDialogsecond.show();	
				
				
			}
		});
 
        //***************��¼*****************************
        
        imgbtnlogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent myintent=new Intent();
				myintent.setClass(MainActivity.this, PatternActivity.class);
				if(!(ed_password.getText().toString().isEmpty())){
				     openFile();
				     if(ed_password.getText().toString().trim().equals(text_output.trim())){
					        startActivity(myintent);
					
					       Toast.makeText(MainActivity.this,"������Ϸ" , Toast.LENGTH_SHORT).show();
				     }else{
					
					       Toast.makeText(MainActivity.this,"�����������", Toast.LENGTH_SHORT).show();
				     }
				}
				else{
					
					Toast.makeText(MainActivity.this,"δ��������", Toast.LENGTH_SHORT).show();
				}
				
			}
		});
        
        
        
        
        
	    }
    //*************�������ݵ��ļ�*********
    private void saveFile(){
    	
    	try{
    		os=this.openFileOutput("mytxt", MODE_PRIVATE);
    		os.write(text_input.getBytes());
    	}
    	 catch (FileNotFoundException e) {
			NoteDebug("�ļ�δ�ҵ���" + e.getMessage());// �ļ�δ�ҵ����쳣
		} catch (IOException e) {
			NoteDebug("�ļ���ȡ����" + e.getMessage());// �ļ���ȡ�����쳣
		} finally {

			try {
				os.flush();// �ر��ļ������
				// Ϊ������ļ�ϵͳ�����ܣ�һ�����write()����ʱ��
				// ���д�����������С��ϵͳ������ݱ��������ݻ������У����������ۻ���һ���̶�ʱ��һ���Ե�д���ļ��С�
				// ����ڵ���close()�����ر��ļ�ǰҪ����flush()�����������������е�����д���ļ���
				os.close();
			} catch (IOException e) {
				NoteDebug("�ļ��ر�ʧ��" + e.getMessage());
			}
		}
    		
    	}
	   private void NoteDebug(String msg) {
		     Toast.makeText(this, "�쳣��" + msg, Toast.LENGTH_SHORT).show();
		
	}
    
	   //*****************��ȡ����************************
	   private void openFile() {
			try {
				/* ��ȡ�ļ���InputStream is,���ļ����ƣ�mytxt */
				is = this.openFileInput("mytxt");
			
				
				byte[] b = new byte[1024];
				is.read(b);
				text_output=new String(b);
			
				
			} catch (FileNotFoundException e) {
				NoteDebug("�ļ�δ�ҵ���" + e.getMessage());// �ļ�δ�ҵ����쳣
			} catch (IOException e) {
				NoteDebug("�ļ���ȡ����" + e.getMessage());// �ļ���ȡ�����쳣
			} finally {
				try {
					is.close();// �ر��ļ�������
				} catch (Exception e) {
					NoteDebug("�ļ��ر�ʧ�ܣ�" + e.getMessage());
				}
			}
			// Log.d("run", "����6");
		}
	}

