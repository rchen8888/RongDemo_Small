package com.example.rongfragmentdemo;

import io.rong.imkit.fragment.ConversationListFragment;
import io.rong.imlib.model.Conversation;

import java.util.ArrayList;
import java.util.List;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Window;
/**
 * ViewPgaer + Fragment 是我们开发 APP 时候常用的方式 下面的这个例子 就给大家演示了
 * 怎么样通过代码动态集成 Fragment 这样的好处是你可以更好的控制会话列表的 聚合  聚合的概念大家可以参 官网
 * @author AM
 *
 */
public class LoadConversationListFragment2 extends FragmentActivity {

	private ViewPager mViewPager;
	
	/**
	 * Fragment的数据适配器
	 */
	private FragmentPagerAdapter mFragmentPagerAdapter;
	/**
	 * ViewPager中的数据
	 */
	private List<Fragment> mFragmentList;
	
	private Fragment mConversationListFragment;//会话列表的fragment 的声明

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.load_fragment2);
		
		mConversationListFragment = initConversationListFragment();
		initView();
	}


	private void initView() {
		mViewPager = (ViewPager) findViewById(R.id.rc_viewpager);
		mFragmentList = new ArrayList<Fragment>();
		mFragmentList.add(new OtherFragment());
		mFragmentList.add(mConversationListFragment);
		
		mFragmentPagerAdapter = new FragmentPagerAdapter(
				getSupportFragmentManager()) {
			@Override
			public Fragment getItem(int i) {
				return mFragmentList.get(i);
			}

			@Override
			public int getCount() {
				return mFragmentList.size();
			}
		};
		mViewPager.setAdapter(mFragmentPagerAdapter);
	}
	
	/**
	 * 封装的代码加载融云的会话列表的 fragment
	 * @return
	 */
	private Fragment initConversationListFragment() {
		ConversationListFragment fragment = new ConversationListFragment();
	    Uri uri = Uri.parse("rong://" + getApplicationInfo().packageName).buildUpon()
	            .appendPath("conversationlist")
	            .appendQueryParameter(Conversation.ConversationType.PRIVATE.getName(), "false") //设置私聊会话是否聚合显示
	            .appendQueryParameter(Conversation.ConversationType.GROUP.getName(), "true")
	            .appendQueryParameter(Conversation.ConversationType.DISCUSSION.getName(), "false")
	            .appendQueryParameter(Conversation.ConversationType.SYSTEM.getName(), "true")
	            .build();
	    fragment.setUri(uri);
		return fragment;		
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		mFragmentList = null;
		mViewPager = null;
		mFragmentPagerAdapter = null;
	}
}
