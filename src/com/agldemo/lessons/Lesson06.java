/**
 * Copyright (C) 2010 Wenhao Li. All Rights Reserved.
 * 
 */
package com.agldemo.lessons;

import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

import com.agldemo.BaseRenderer;

import android.graphics.Bitmap;
import android.opengl.GLU;

/**
 * Lesson 06
 */
public class Lesson06 extends BaseRenderer {

	FloatBuffer quad = makeFloatBuffer(new float[] {
			// FRONT
			-1.0f, -1.0f, 1.0f,
			//
			1.0f, -1.0f, 1.0f,
			//
			1.0f, 1.0f, 1.0f,
			//
			-1.0f, 1.0f, 1.0f,

			// BACK
			-1.0f, -1.0f, -1.0f,
			//
			1.0f, -1.0f, -1.0f,
			//
			1.0f, 1.0f, -1.0f,
			//
			-1.0f, 1.0f, -1.0f,

			// LEFT
			-1.0f, -1.0f, -1.0f,
			//
			-1.0f, 1.0f, -1.0f,
			//
			-1.0f, 1.0f, 1.0f,
			//
			-1.0f, -1.0f, 1.0f,

			// RIGHT
			1.0f, -1.0f, -1.0f,
			//
			1.0f, 1.0f, -1.0f,
			//
			1.0f, 1.0f, 1.0f,
			//
			1.0f, -1.0f, 1.0f,

			// TOP
			-1.0f, 1.0f, -1.0f,
			//
			1.0f, 1.0f, -1.0f,
			//
			1.0f, 1.0f, 1.0f,
			//
			-1.0f, 1.0f, 1.0f,

			// BOTTOM
			-1.0f, -1.0f, -1.0f,
			//
			1.0f, -1.0f, -1.0f,
			//
			1.0f, -1.0f, 1.0f,
			//
			-1.0f, -1.0f, 1.0f, });

	FloatBuffer qtex = makeFloatBuffer(new float[] {
			// FRONT
			0.0f, 1.0f,
			//
			1.0f, 1.0f,
			//
			1.0f, 0.0f,
			//
			0.0f, 0.0f,

			// BACK
			0.0f, 1.0f,
			//
			1.0f, 1.0f,
			//
			1.0f, 0.0f,
			//
			0.0f, 0.0f,

			// LEFT
			0.0f, 1.0f,
			//
			1.0f, 1.0f,
			//
			1.0f, 0.0f,
			//
			0.0f, 0.0f,

			// RIGHT
			0.0f, 1.0f,
			//
			1.0f, 1.0f,
			//
			1.0f, 0.0f,
			//
			0.0f, 0.0f,

			// TOP
			0.0f, 0.0f,
			//
			1.0f, 0.0f,
			//
			1.0f, 1.0f,
			//
			0.0f, 1.0f,

			// BOTTOM
			0.0f, 0.0f,
			//
			1.0f, 0.0f,
			//
			1.0f, 1.0f,
			//
			0.0f, 1.0f, });

	float xrot = 0.0f;

	float yrot = 0.0f;

	float zrot = 0.0f;

	private Bitmap mBitmap;

	int texture = -1;

	/**
     * 
     */
	public Lesson06() {
	}

	public Bitmap getBitmap() {
		return mBitmap;
	}

	public void setBitmap(Bitmap bitmap) {
		mBitmap = bitmap;
	}

	public void onDrawFrame(GL10 gl, int width, int height) {
		float ratio = (float) width / height;
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		GLU.gluPerspective(gl, 45.0f, ratio, 0.1f, 100.0f);

		// texture
		if (texture == -1) {
			texture = loadTexture(gl, mBitmap);
		}
		gl.glBindTexture(GL10.GL_TEXTURE_2D, texture);
		gl.glEnable(GL10.GL_TEXTURE_2D);

		// draw
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();

		gl.glTranslatef(0.0f, 0.0f, -5.0f);

		gl.glRotatef(xrot, 1.0f, 0.0f, 0.0f);
		gl.glRotatef(yrot, 0.0f, 1.0f, 0.0f);
		gl.glRotatef(zrot, 0.0f, 0.0f, 1.0f);

		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);

		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, quad);
		gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, qtex);

		gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 0, 4);
		gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 4, 4);
		gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 8, 4);
		gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 12, 4);
		gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 16, 4);
		gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 20, 4);

		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);

		// clean up
		gl.glDisable(GL10.GL_TEXTURE_2D);

		xrot += 0.6f;
		yrot += 0.4f;
		zrot += 0.8f;
	}

}
