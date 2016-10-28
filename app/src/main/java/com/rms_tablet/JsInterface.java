package com.rms_tablet;

import android.content.Context;

/**
 * Created by 朱晓林 on 2016/9/19 0019 下午 1:20.
 * qq1300061321
 */
//  ┏┓　　　┏┓
//┏┛┻━━━┛┻┓
//┃　　　　　　　┃
//┃　　　━　　　┃
//┃　┳┛　┗┳　┃
//┃　　　　　　　┃
//┃　　　┻　　　┃
//┃　　　　　　　┃
//┗━┓　　　┏━┛
//   ┃　　　┃   神兽保佑
//   ┃　　　┃   代码无BUG！
//   ┃　　　┗━━━┓
//   ┃　　　　　　　┣┓
//   ┃　　　　　　　┏┛
//   ┗┓┓┏━┳┓┏┛
//     ┃┫┫　┃┫┫
//     ┗┻┛　┗┻┛
public class JsInterface {
    private Context context;
    public JsInterface(Context context) {
        this.context = context;
    }
    @org.xwalk.core.JavascriptInterface
    public  void check_update(){

        UpdateManager manager = new UpdateManager(context);
        // 检查软件更新
        manager.checkUpdate();
    }
}
