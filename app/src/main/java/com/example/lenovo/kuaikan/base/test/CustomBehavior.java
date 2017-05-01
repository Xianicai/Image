package com.example.lenovo.kuaikan.base.test;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Zhanglibin on 2017/4/26.
 */

public class CustomBehavior extends CoordinatorLayout.Behavior<TextView> {

    /**
     * 运行时通过这个构造函数获取Behavior对象
     * @param context
     * @param attrs
     */
    public CustomBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 依赖条件，true表示绑定关系成立
     * @param parent
     * @param child
     * @param dependency
     * @return
     */
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
        return dependency instanceof TextView;
    }

    /**
     * 属性依赖逻辑，返回true表示要执行
     * @param parent
     * @param child
     * @param dependency
     * @return
     */
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {
        int offset = dependency.getTop() - child.getTop();
        ViewCompat.offsetTopAndBottom(child,offset);//纵向移动
        return true;
    }
}
