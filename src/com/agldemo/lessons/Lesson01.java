/**
 * Copyright (C) 2013 Wenhao Li. All Rights Reserved.
 */
package com.agldemo.lessons;

import javax.microedition.khronos.opengles.GL10;

import android.content.Context;

import com.agldemo.Lesson;

/**
 * Lesson 01
 */
public class Lesson01 extends Lesson {

	public Lesson01(Context context) {
		super(context, "Lesson 01", "Setting Up");
	}

	@Override
	public void onDrawFrame(GL10 gl, int width, int height) {
		// nothing to do. background color already cleared in GLViewStage.
	}
}
