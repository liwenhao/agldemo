/**
 * Copyright (C) 2010 Wenhao Li. All Rights Reserved.
 * 
 */
package com.agldemo;

import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * OpenGL view.
 */
public class GLView extends View {
	/**
	 * A generic renderer interface.
	 * 
	 * @see #setRenderer(Renderer)
	 */
	public interface Renderer {
		/**
		 * Called to draw the current frame.
		 * 
		 * @param width
		 *            the width of current view port
		 * @param height
		 *            the height of current view port
		 */
		void onDrawFrame(GL10 gl, int width, int height);
	}

	/**
	 * The OpenGL renderer.
	 */
	private Renderer mRenderer;

	/**
	 * @param context
	 */
	public GLView(Context context) {
		super(context);
	}

	/**
	 * @param context
	 * @param attrs
	 */
	public GLView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	/**
	 * @param context
	 * @param attrs
	 * @param defStyle
	 */
	public GLView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	/**
	 * Set the renderer associated with this view.
	 * 
	 * @param renderer
	 *            the renderer to set
	 */
	public void setRenderer(Renderer renderer) {
		mRenderer = renderer;

	}

	/**
	 * Draw OpenGL things on the given OpenGL handle.
	 * 
	 * @param gl
	 *            the OpenGL handle to draw on
	 */
	public void drawGL(GL10 gl) {
		if (mRenderer == null)
			return;
		mRenderer.onDrawFrame(gl, getWidth(), getHeight());
	}

	final int[] mLocation = new int[2];
}
