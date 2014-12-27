/*
 * $filename: ImageLoadingPageGridActivity.java,v $
 * $Date: 2014-5-3  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import edu.njupt.zhb.view.PagerSlidingTabStrip;
/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2014-5-3  Nanjing,njupt,Chink
 */
@EActivity(R.layout.image_page_grid_activity)
public class ImageLoadingPageGridActivity extends FragmentActivity{

	@ViewById
	ViewPager pager;
	@ViewById
	PagerSlidingTabStrip tabs;
	
	PageAdapter adapter;
	
	@AfterViews
	void afterViews(){
		adapter = new PageAdapter(getSupportFragmentManager(),ImageLoadingPageGridActivity.this);
		pager.setAdapter(adapter);
//		pager.setPageTransformer(true,new CubeOutTransformer()); //Yes
//		pager.setPageTransformer(true,new AccordionTransformer()); //Yes
//		pager.setPageTransformer(true,new FlipHorizontalTransformer());//No
//		pager.setPageTransformer(true,new RotateUpTransformer());//Yes
//		pager.setPageTransformer(true,new ZoomOutTranformer());//No 
//		pager.setPageTransformer(true,new ZoomOutSlideTransformer());//Yes
//		pager.setPageTransformer(true,new TabletTransformer());//Yes
		pager.setOffscreenPageLimit(2);
		tabs.setViewPager(pager);
		
		setTabsValue();
	}
	
	/**
	 * 对PagerSlidingTabStrip的各项属性进行赋值。
	 */
	private void setTabsValue() {
		DisplayMetrics dm = getResources().getDisplayMetrics();
		// 设置Tab是自动填充满屏幕的
		tabs.setShouldExpand(true);
		// 设置Tab的分割线是透明的
		tabs.setDividerColor(Color.TRANSPARENT);
		// 设置Tab底部线的高度
		tabs.setUnderlineHeight((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 1, dm));
		// 设置Tab Indicator的高度
		tabs.setIndicatorHeight((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 4, dm));
		// 设置Tab标题文字的大小
		tabs.setTextSize((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_SP, 16, dm));
		// 设置Tab Indicator的颜色
		tabs.setIndicatorColor(Color.parseColor("#45c01a"));
		// 设置选中Tab文字的颜色 (这是我自定义的一个方法)
		tabs.setSelectedTextColor(Color.parseColor("#45c01a"));
		// 取消点击Tab时的背景色
		tabs.setTabBackground(0);
	}
}
