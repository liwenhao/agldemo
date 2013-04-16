/**
 * Copyright (C) 2010 Wenhao Li. All Rights Reserved.
 * 
 */
package com.agldemo;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.ViewGroup.LayoutParams;

/**
 * A OpenGL view stage maintain a surface, several OpenGL view can draw on it.
 */
public class GLViewStage {
	
	private GLSurfaceView mGLSurfaceView;
	private Window mWindow;
	private float mBgRed;
	private float mBgGreen;
	private float mBgBlue;

	final int[] mLocation = new int[2];

	/**
	 * 
	 */
	public GLViewStage(Window w) {
		init(w);
	}

	private void init(Window w) {
		mWindow = w;

		mGLSurfaceView = new GLSurfaceView(w.getContext());
		mGLSurfaceView.setRenderer(mRenderer);

		LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);

		ViewGroup decor = (ViewGroup) w.getDecorView();
		decor.addView(mGLSurfaceView, 0, lp);
		
		
		TypedArray array = w.getContext().getTheme().obtainStyledAttributes(new int[] {
				android.R.attr.colorBackground
				}); 
		int c = array.getColor(0, 0xFFFFFF); 
		array.recycle();

		mBgRed = Color.red(c)/255f;
		mBgGreen = Color.green(c)/255f;
		mBgBlue = Color.blue(c)/255f;
	}

	public void onPause() {
		mGLSurfaceView.onPause();
	}

	protected void onResume() {
		mGLSurfaceView.onResume();
	}

	private void drawGLView(GL10 gl, View v) {
		if (v instanceof GLView) {
			GLView gv = (GLView) v;

			if (gv.getVisibility() != View.VISIBLE)
				return;

			int w, h;
			w = v.getWidth();
			h = v.getHeight();

			gv.getLocationOnScreen(mLocation);
			mLocation[1] = mGLSurfaceView.getHeight() - mLocation[1] - h;

			gl.glViewport(mLocation[0], mLocation[1], w, h);
			gl.glEnable(GL10.GL_SCISSOR_TEST);
			gl.glScissor(mLocation[0], mLocation[1], w, h);
			gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
			gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
			
			gv.drawGL(gl);
			
			gl.glDisable(GL10.GL_SCISSOR_TEST);

			return;
		}

		if (v instanceof ViewGroup) {
			ViewGroup vg = (ViewGroup) v;
			for (int i = 0; i < vg.getChildCount(); i++) {
				drawGLView(gl, vg.getChildAt(i));
			}

			return;
		}
	}

	private Renderer mRenderer = new GLSurfaceView.Renderer() {

		public void onDrawFrame(GL10 gl) {
			gl.glClearColor(mBgRed, mBgGreen, mBgBlue, 1.0f);
			gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
			drawGLView(gl, mWindow.getDecorView());
		}

		public void onSurfaceChanged(GL10 gl, int width, int height) {
		}

		public void onSurfaceCreated(GL10 gl, EGLConfig config) {
			gl.glEnable(GL10.GL_DITHER);
			gl.glEnable(GL10.GL_DEPTH_TEST);
			gl.glDepthFunc(GL10.GL_LEQUAL);
		}
	};

}
