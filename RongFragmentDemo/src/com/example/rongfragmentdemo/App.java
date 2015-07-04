package com.example.rongfragmentdemo;

import io.rong.imkit.RongIM;
import android.app.Application;
/**
 * 在此之前如果 运行崩溃 请先解决环境问题 注意 manifest 的配置 appkey token 您换成自己的 后续还有更新
 * 静态加载 会话列表 item 不出来的原因是 LoadConversationListFragment1 的 intent fiter 没有配置 因为动态的已经配置了 避免重复配置
 * @author AM
 *
 */
public class App extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		RongIM.init(this);
	}
}
