/**
 * Copyright (C) 2013 Wenhao Li. All Rights Reserved.
 */
package com.agldemo;

import android.content.Context;

/**
 * base class for lesson
 */
public abstract class Lesson extends BaseRenderer {
	private Context context;
	private String title;
	private String details;

	/**
	 * Create a lesson.
	 * @param title title of the lesson.
	 * @param details detail description of the lesson.
	 */
	public Lesson(Context context, String title, String details) {
		this.context = context;
		this.title = title;
		this.details = details;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Context getContext() {
		return context;
	}
}
