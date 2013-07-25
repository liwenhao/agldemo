/**
 * Copyright (C) 2010 Wenhao Li. All Rights Reserved.
 * 
 */
package com.agldemo;

import java.util.ArrayList;

import com.agldemo.lessons.*;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class GLDemoActivity extends ListActivity {
	private GLViewStage mStage;
	private ArrayList<Lesson> mLessons = new ArrayList<Lesson>();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mStage = new GLViewStage(getWindow());

		mLessons.add(new Lesson01(this));
		mLessons.add(new Lesson02(this));
		mLessons.add(new Lesson03(this));
		mLessons.add(new Lesson04(this));
		mLessons.add(new Lesson05(this));
		mLessons.add(new Lesson06(this));
		mLessons.add(new Lesson07(this));
		mLessons.add(new Lesson08(this));
		mLessons.add(new Lesson09(this));

		setListAdapter(new LessonsAdapter(this));
		getListView().setScrollingCacheEnabled(false);
	}

	private class LessonsAdapter extends BaseAdapter {
		public LessonsAdapter(Context context) {
			mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		public int getCount() {
			return mLessons.size();
		}

		public Object getItem(int position) {
			return position;
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = mInflater.inflate(R.layout.gl_list_item, null);
			}

			// renderer
			Lesson lesson = mLessons.get(position);
			GLView glview = (GLView) convertView
					.findViewById(R.id.gl_list_item_glview);
			glview.setRenderer(lesson);

			// title
			TextView title = (TextView) convertView
					.findViewById(R.id.gl_list_item_title);
			title.setText(lesson.getTitle());

			// detail
			TextView detail = (TextView) convertView
					.findViewById(R.id.gl_list_item_detail);
			detail.setText(lesson.getDetails());

			return convertView;
		}

		private LayoutInflater mInflater;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onPause()
	 */
	@Override
	protected void onPause() {
		super.onPause();
		mStage.onPause();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onResume() {
		super.onResume();
		mStage.onResume();
	}

}
