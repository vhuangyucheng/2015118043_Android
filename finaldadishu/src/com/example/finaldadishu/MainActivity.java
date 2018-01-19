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
	 private OutputStream os;//文件输出流
	 private InputStream is;//文件输入流
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      
        setContentView(R.layout.activity_main);
        
        ExitApplication.getInstance().addActivity(this);//记录activity
        
        ed_password=(EditText) findViewById(R.id.ed_password);
        
        btn1_shezhi=(Button) findViewById(R.id.btn_shezhi);
        btn1_xiugai=(Button) findViewById(R.id.btn_xiugai);
        
        imgbtnlogin=(ImageButton) findViewById(R.id.imgbtnlogin);
        
        //****************设置密码******************
        btn1_shezhi.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				AlertDialog.Builder customizeDialogfirst=new AlertDialog.Builder(MainActivity.this);
		    	final View dialogView=LayoutInflater.from(MainActivity.this).inflate(R.layout.inlayout, null);
		    	
		    	customizeDialogfirst.setTitle("设置密码");
		    	customizeDialogfirst.setView(dialogView);
		    	customizeDialogfirst.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					
		    		EditText Edfirstpassword=(EditText) dialogView.findViewById(R.id.Ed_first_password);
		    		EditText Edsecondpassword=(EditText) dialogView.findViewById(R.id.Ed_second_password);
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
					   if(Edfirstpassword.getText().length()!=0){
						   //判断两次输入是否一致
					      	if(Edfirstpassword.getText().toString().equals(Edsecondpassword.getText().toString())){
							    text_input=Edsecondpassword.getText().toString();
							     saveFile();//存储数据到文件
							     Toast.makeText(MainActivity.this,"密码设置成功" , Toast.LENGTH_SHORT).show();
						      }
						     else{
							     Toast.makeText(MainActivity.this,"密码设置失败！" , Toast.LENGTH_SHORT).show();
						     }
					     }
					   
					   else{
						   Toast.makeText(MainActivity.this,"未输入密码" , Toast.LENGTH_SHORT).show();
						   
					   }
					}
				});
		    	customizeDialogfirst.show();	
				
			}
		});
       
       //****************修改密码******************
        btn1_xiugai.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				AlertDialog.Builder customizeDialogsecond=new AlertDialog.Builder(MainActivity.this);
		    	final View dialogView1=LayoutInflater.from(MainActivity.this).inflate(R.layout.gailayout, null);
		    	
		    	customizeDialogsecond.setTitle("密码修改");
		    	customizeDialogsecond.setView(dialogView1);
		    	customizeDialogsecond.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					
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
								 Toast.makeText(MainActivity.this,"修改成功" , Toast.LENGTH_SHORT).show();								 
							 }
							 else{
								 Toast.makeText(MainActivity.this,"修改失败" , Toast.LENGTH_SHORT).show();
							 }
							
						}else{
							Toast.makeText(MainActivity.this,"原密码输入错误" , Toast.LENGTH_SHORT).show();
							
						}
						
						
					}
				});
		    	customizeDialogsecond.show();	
				
				
			}
		});
 
        //***************登录*****************************
        
        imgbtnlogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent myintent=new Intent();
				myintent.setClass(MainActivity.this, PatternActivity.class);
				if(!(ed_password.getText().toString().isEmpty())){
				     openFile();
				     if(ed_password.getText().toString().trim().equals(text_output.trim())){
					        startActivity(myintent);
					
					       Toast.makeText(MainActivity.this,"进入游戏" , Toast.LENGTH_SHORT).show();
				     }else{
					
					       Toast.makeText(MainActivity.this,"密码输入错误", Toast.LENGTH_SHORT).show();
				     }
				}
				else{
					
					Toast.makeText(MainActivity.this,"未输入密码", Toast.LENGTH_SHORT).show();
				}
				
			}
		});
        
        
        
        
        
	    }
    //*************保存数据到文件*********
    private void saveFile(){
    	
    	try{
    		os=this.openFileOutput("mytxt", MODE_PRIVATE);
    		os.write(text_input.getBytes());
    	}
    	 catch (FileNotFoundException e) {
			NoteDebug("文件未找到：" + e.getMessage());// 文件未找到，异常
		} catch (IOException e) {
			NoteDebug("文件读取错误：" + e.getMessage());// 文件读取错误，异常
		} finally {

			try {
				os.flush();// 关闭文件输出流
				// 为了提高文件系统的性能，一般调用write()函数时，
				// 如果写入的数据量较小，系统会把数据保存在数据缓冲区中，等数据量累积到一定程度时再一次性的写入文件中。
				// 因此在调用close()函数关闭文件前要调用flush()函数将缓冲区内所有的数据写入文件。
				os.close();
			} catch (IOException e) {
				NoteDebug("文件关闭失败" + e.getMessage());
			}
		}
    		
    	}
	   private void NoteDebug(String msg) {
		     Toast.makeText(this, "异常：" + msg, Toast.LENGTH_SHORT).show();
		
	}
    
	   //*****************读取数据************************
	   private void openFile() {
			try {
				/* 读取文件流InputStream is,打开文件名称：mytxt */
				is = this.openFileInput("mytxt");
			
				
				byte[] b = new byte[1024];
				is.read(b);
				text_output=new String(b);
			
				
			} catch (FileNotFoundException e) {
				NoteDebug("文件未找到：" + e.getMessage());// 文件未找到，异常
			} catch (IOException e) {
				NoteDebug("文件读取错误：" + e.getMessage());// 文件读取错误，异常
			} finally {
				try {
					is.close();// 关闭文件输入流
				} catch (Exception e) {
					NoteDebug("文件关闭失败：" + e.getMessage());
				}
			}
			// Log.d("run", "测试6");
		}
	}

