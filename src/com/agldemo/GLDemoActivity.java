/**
 * Copyright (C) 2010 Wenhao Li. All Rights Reserved.
 * 
 */
package com.agldemo;

import com.agldemo.GLView.Renderer;
import com.agldemo.lessons.*;

import android.app.ListActivity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class GLDemoActivity extends ListActivity {
	private GLViewStage mStage;

	private Renderer lesson02 = new Lesson02();

	private Renderer lesson03 = new Lesson03();

	private Renderer lesson04 = new Lesson04();

	private Renderer lesson05 = new Lesson05();

	private Lesson06 lesson06 = new Lesson06();

	private Lesson07 lesson07 = new Lesson07();

	private Lesson08 lesson08 = new Lesson08();

	private Lesson09 lesson09 = new Lesson09();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mStage = new GLViewStage(getWindow());

		setListAdapter(new LessonsAdapter(this));
		getListView().setScrollingCacheEnabled(false);

		lesson06.setBitmap(BitmapFactory.decodeResource(getResources(),
				R.drawable.robot));
		lesson07.setBitmap(BitmapFactory.decodeResource(getResources(),
				R.drawable.crate));
		lesson08.setBitmap(BitmapFactory.decodeResource(getResources(),
				R.drawable.glass));
		lesson09.setBitmap(BitmapFactory.decodeResource(getResources(),
				R.drawable.star));

	}

	/**
	 * A sample ListAdapter that presents content from arrays of speeches and
	 * text.
	 */
	private class LessonsAdapter extends BaseAdapter {
		public LessonsAdapter(Context context) {
			mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		public int getCount() {
			return mTitles.length;
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
			GLView glview = (GLView) convertView
					.findViewById(R.id.gl_list_item_glview);
			glview.setRenderer(getRenderer(position));

			// title
			TextView title = (TextView) convertView
					.findViewById(R.id.gl_list_item_title);
			title.setText(mTitles[position]);

			// detail
			TextView detail = (TextView) convertView
					.findViewById(R.id.gl_list_item_detail);
			detail.setText(mDetails[position]);

			return convertView;
		}

		private Renderer getRenderer(int pos) {
			switch (pos) {
			case 0:
				return lesson02;
			case 1:
				return lesson03;
			case 2:
				return lesson04;
			case 3:
				return lesson05;
			case 4:
				return lesson06;
			case 5:
				return lesson07;
			case 6:
				return lesson08;
			case 7:
				return lesson09;
			default:
				return lesson05;
			}
		}

		private LayoutInflater mInflater;

		private String[] mTitles = { "Lesson 02", "Lesson 03", "Lesson 04",
				"Lesson 05", "Lesson 06", "Lesson 07", "Lesson 08", "Lesson 09" };

		private String[] mDetails = { "Your First Polygon", "Adding Color",
				"Rotation", "3D Shapes", "Texture Mapping",
				"Texture Filters, Lighting & Keyboard Control", "Blending",
				"Moving Bitmaps In 3D Space" };
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
