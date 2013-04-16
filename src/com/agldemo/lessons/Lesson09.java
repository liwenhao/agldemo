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
 * Lesson 09
 */
public class Lesson09 extends BaseRenderer {

	FloatBuffer quad = makeFloatBuffer(new float[] {
			//
			-1.0f, -1.0f, 1.0f,
			//
			1.0f, -1.0f, 1.0f,
			//
			1.0f, 1.0f, 1.0f,
			//
			-1.0f, 1.0f, 1.0f, });

	FloatBuffer qtex = makeFloatBuffer(new float[] {
			//
			0.0f, 1.0f,
			//
			1.0f, 1.0f,
			//
			1.0f, 0.0f,
			//
			0.0f, 0.0f, });

	float zoom = -15.0f;
	float tilt = 90.0f;
	float spin = 0.0f;

	private Bitmap mBitmap;

	int texture = -1;

	private class Star {
		public float r, g, b;
		public float dist;
		public float angle;
	};

	private Star stars[] = new Star[25];

	/**
     * 
     */
	public Lesson09() {
		for (int i = 0; i < stars.length; i++) {
			stars[i] = new Star();
			stars[i].angle = 0.0f;
			stars[i].dist = ((float) i / stars.length) * 5.0f;
			stars[i].r = (float) Math.random();
			stars[i].g = (float) Math.random();
			stars[i].b = (float) Math.random();
		}
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

		// blend
		gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE);
		gl.glEnable(GL10.GL_BLEND);

		// draw
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();

		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);

		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, quad);
		gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, qtex);

		for (int i = 0; i < stars.length; i++) {
			gl.glLoadIdentity();
			gl.glTranslatef(0.0f, 0.0f, zoom);

			gl.glRotatef(tilt, 1.0f, 0.0f, 0.0f);
			gl.glRotatef(stars[i].angle, 0.0f, 1.0f, 0.0f);

			gl.glTranslatef(stars[i].dist, 0.0f, 0.0f);

			gl.glRotatef(-stars[i].angle, 0.0f, 1.0f, 0.0f);
			gl.glRotatef(-tilt, 1.0f, 0.0f, 0.0f);
			gl.glRotatef(spin, 0.0f, 0.0f, 1.0f);

			gl.glColor4f(stars[i].r, stars[i].g, stars[i].b, 1.0f);

			gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 0, 4);

			spin += 0.01f;
			stars[i].angle += (float) i / stars.length;
			stars[i].dist -= 0.01f;

			if (stars[i].dist < 0.0f) {
				stars[i].dist += 5.0f;
				stars[i].r = (float) Math.random();
				stars[i].g = (float) Math.random();
				stars[i].b = (float) Math.random();
			}
		}

		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);

		// clean up
		gl.glDisable(GL10.GL_TEXTURE_2D);
		gl.glDisable(GL10.GL_BLEND);
		gl.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
	}
}
