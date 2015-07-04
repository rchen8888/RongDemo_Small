package com.example.rongfragmentdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
/**
 * 此为静态加载的方式 集成简单只需要把 fragment 的布局文件放到你对应类的 布局文件中 对应的类 可以是 Activity 但是需要
 * 提示的是继承 FragmentActivity  对应的类也可以为 Fragment 只需要在 Fragment 的布局文件中 嵌入
 * android:name="io.rong.imkit.fragment.ConversationListFragment" 即可 详见下面代码 和 布局文件
 * @author AM
 *
 */
public class LoadConversationListFragment1 extends FragmentActivity{
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.load_fragment1);
	}

}
