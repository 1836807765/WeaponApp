package com.weapon.joker;

import android.app.Application;

import com.umeng.analytics.MobclickAgent;

import net.wequick.small.Small;

import cn.jpush.android.api.JPushInterface;

/**
 * BaseApplication 程序入口，做初始化工作，并对整个应用提供上下文环境
 * author:张冠之
 * time: 2017/9/9 下午3:13
 * e-mail: guanzhi.zhang@sojex.cn
 */

public class WeaponApplication extends Application{
    //单例模式
    private static WeaponApplication sApplication = null;

    public WeaponApplication(){
        //初始化 Small
        Small.preSetUp(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
        JPushInterface.setDebugMode(true); 	// 设置开启日志,发布时请关闭日志
        JPushInterface.init(this);     		// 初始化 JPush

        // 设置友盟统计场景为 普通统计场景类型
        MobclickAgent.setScenarioType(getApplicationContext(), MobclickAgent.EScenarioType.E_UM_NORMAL);
        MobclickAgent.setDebugMode(true);  // 设置友盟 debug 模式，发布时请关闭
    }

    public static WeaponApplication getInstance(){
        return sApplication;
    }
}
