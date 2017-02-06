package com.xiaohei.takeout.view.activity;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;

/**
 * Created by fman on 2017/1/22.
 */

public class BaseActivity extends AppCompatActivity {

    public void initStatusBar(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //支持高版本5.0 先把状态栏 设置成透明
            Window window = getWindow();
            WindowManager.LayoutParams param=window.getAttributes();
            //修改状态 要求透明
            param.flags |= WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            window.setAttributes(param);
        }
        //着色管理者
        SystemBarTintManager manger=new SystemBarTintManager(this);
        //支持着色
        manger.setStatusBarTintEnabled(true);
        //设置颜色
        manger.setStatusBarTintColor(color);
    }
}
