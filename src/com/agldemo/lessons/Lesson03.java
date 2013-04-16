/**
 * Copyright (C) 2010 Wenhao Li. All Rights Reserved.
 * 
 */
package com.agldemo.lessons;

import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

import com.agldemo.BaseRenderer;

import android.opengl.GLU;

/**
 * Lesson 02
 */
public class Lesson03 extends BaseRenderer {
	FloatBuffer triangle = makeFloatBuffer(new float[] {
			// Top Of Triangle
			0.0f, 1.0f, 0.0f,
			// Left Of Triangle
			-1.0f, -1.0f, 0.0f,
			// Right Of Triangle
			1.0f, -1.0f, 0.0f });

	FloatBuffer tcolor = makeFloatBuffer(new float[] {
			// Red
			1.0f, 0.0f, 0.0f, 1.0f,
			// Green
			0.0f, 1.0f, 0.0f, 1.0f,
			// Blue
			0.0f, 0.0f, 1.0f, 1.0f });

	FloatBuffer quad = makeFloatBuffer(new float[] {
			// Top Right Of The Quad
			1.0f, 1.0f, 0.0f,
			// Top Left Of The Quad
			-1.0f, 1.0f, 0.0f,
			// Bottom Left Of The Quad
			1.0f, -1.0f, 0.0f,
			// Bottom Right Of The Quad
			-1.0f, -1.0f, 0.0f });

	/**
     * 
     */
	public Lesson03() {

	}

	public void onDrawFrame(GL10 gl, int width, int height) {
		float ratio = (float) width / height;
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		GLU.gluPerspective(gl, 45.0f, ratio, 0.1f, 100.0f);

		gl.glMatrixMode(GL10.GL_MODELVIEW);

		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

		// triangle
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);

		gl.glLoadIdentity();
		gl.glTranslatef(-1.5f, 0.0f, -6.0f);

		gl.glColorPointer(4, GL10.GL_FLOAT, 0, tcolor);
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, triangle);

		gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);

		gl.glDisableClientState(GL10.GL_COLOR_ARRAY);

		// quad
		gl.glLoadIdentity();
		gl.glTranslatef(1.5f, 0.0f, -6.0f);

		gl.glColor4f(0.5f, 0.5f, 1.0f, 1.0f);

		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, quad);

		gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);

		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

		// clean up
		gl.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
	}

}
