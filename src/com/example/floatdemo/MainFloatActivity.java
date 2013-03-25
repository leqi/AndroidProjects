package com.example.floatdemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

@SuppressLint("NewApi")
public class MainFloatActivity extends Activity {

	private WindowManager wm=null;
	private WindowManager.LayoutParams wmParams=null;
	 private FloatFrame myFV = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_float);
        createFloatCiew();
        this.finish();
    }

	private void createFloatCiew() {
		Point windowSize= new Point();
		this.getWindowManager().getDefaultDisplay().getSize(windowSize); 
		myFV=new FloatFrame(getApplicationContext());
		// ��ȡWindowManager  
        wm = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);  
        // ����LayoutParams(ȫ�ֱ�������ز���  
        wmParams = ((FloatApplication) getApplication()).getWmParams();  
  
        /** 
         * ���¶���WindowManager.LayoutParams��������� ������;�ɲο�SDK�ĵ� 
         */  
        wmParams.type =  2003;//LayoutParams.TYPE_PHONE; // ����window type  
        wmParams.format = PixelFormat.RGBA_8888; // ����ͼƬ��ʽ��Ч��Ϊ����͸��  
  
        // ����Window flag  
        wmParams.flags = LayoutParams.FLAG_NOT_TOUCH_MODAL  
                | LayoutParams.FLAG_NOT_FOCUSABLE;  
  
        /* 
         * �����flags���Ե�Ч����ͬ���������� ���������ɴ������������κ��¼�,ͬʱ��Ӱ�������¼���Ӧ�� 
         * wmParams.flags=LayoutParams.FLAG_NOT_TOUCH_MODAL | 
         * LayoutParams.FLAG_NOT_FOCUSABLE | LayoutParams.FLAG_NOT_TOUCHABLE; 
         */  
  
        wmParams.gravity = Gravity.LEFT | Gravity.TOP; // �����������������Ͻ�  
//      wmParams.gravity = Gravity.CENTER_VERTICAL | Gravity.RIGHT; // �����������������Ͻ�  
        //����Ĭ����ʾλ��  
//      wmParams.x = 0;<span style="font-family: Arial, Helvetica, sans-serif;">// ����Ļ���Ͻ�Ϊԭ�㣬����x��y��ʼֵ</span>  
//      wmParams.y = 0;  
        wmParams.x = windowSize.x;
        //<span style="font-family: Arial, Helvetica, sans-serif;"> </span> 
        
        wmParams.y = windowSize.y / 2;  
  
        // �����������ڳ�������  
        wmParams.width =android.view.ViewGroup.LayoutParams.WRAP_CONTENT;// 40;  
        wmParams.height = android.view.ViewGroup.LayoutParams.WRAP_CONTENT;// 40;  
  
        // ��ʾmyFloatViewͼ��  
        wm.addView(myFV, wmParams);  
  
  
    }  
  
}  