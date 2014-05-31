/*
 * $filename: ImageLoadingPageGridActivity.java,v $
 * $Date: 2014-5-3  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.NoTitle;
import org.androidannotations.annotations.ViewById;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2014-5-3  Nanjing,njupt,Chink
 */
@NoTitle
@EActivity(R.layout.image_page_grid_activity)
public class ImageLoadingPageGridActivity extends FragmentActivity{

	@ViewById
	ViewPager pager;
	
	@ViewById
	PagerTabStrip pts;
	
	PageAdapter adapter;
	
	@AfterViews
	void afterViews(){
		pts.setTabIndicatorColorResource(R.color.green_complete);
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
	}
}
