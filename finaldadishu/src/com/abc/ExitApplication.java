package com.abc;

import java.util.ArrayList;  
import java.util.List;  
  
import android.app.Activity;  
import android.app.Application;  
import android.content.Context;  
import android.view.View.OnClickListener;
  
public class ExitApplication extends Application {  
  
    private List<Activity> list = new ArrayList<Activity>();  
  
    private static ExitApplication ea;  
  
    private ExitApplication() {  
  
    }  
  
    public static ExitApplication getInstance() {  
        if (null == ea) {  
            ea = new ExitApplication();  
        }  
        return ea;  
    }  
  
    public void addActivity(Activity activity) {  
        list.add(activity);  
    }  
  
    public void exit(OnClickListener onClickListener) {  
        for (Activity activity : list) {  
            activity.finish();  
        }  
        System.exit(0);  
    }  
}