/*
 * $filename: PageAdapter.java,v $
 * $Date: 2014-5-3  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.ViewGroup;

/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2014-5-3  Nanjing,njupt,China
 */
public class PageAdapter extends FragmentStatePagerAdapter {

	private static String[] topics = { "dog", "cat", "bird", "panda", "horse",
			"elephant", "bear", "butterfly", "monkey", "fish", "tiger",
			"chicken", "pig" };

	Context context;

	public PageAdapter(FragmentManager fm, Context context) {
		super(fm);
		this.context = context;
	}

	@Override
	public Fragment getItem(int pos) {

		Log.d("primary", topics[pos]);

		Bundle args = new Bundle();

		args.putString("topic", topics[pos]);

		ImageGridFragment fragment = (ImageGridFragment) Fragment.instantiate(
				context, ImageGridFragment.class.getName(), args);

		return fragment;
	}

	@Override
	public int getCount() {
		return topics.length;
	}

	@Override
	public CharSequence getPageTitle(int pos) {
		SpannableStringBuilder ssb = new SpannableStringBuilder(" "
				+ topics[pos]); // space added before text for
		Drawable myDrawable = context.getResources().getDrawable(
				R.drawable.card_visited_like);
		myDrawable.setBounds(0, 0, myDrawable.getIntrinsicWidth(),
				myDrawable.getIntrinsicHeight());
		ImageSpan span = new ImageSpan(myDrawable, ImageSpan.ALIGN_BASELINE);
		ssb.setSpan(span, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		return ssb;
	}

	@Override
	public void setPrimaryItem(ViewGroup container, int position, Object object) {

		Log.d("primary", topics[position]);

		ImageGridFragment fragment = (ImageGridFragment) object;
		fragment.init();

	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		Log.d("destroyItem", topics[position]);
	}

}
