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
 * Lesson 05
 */
public class Lesson05 extends BaseRenderer {

	FloatBuffer triangle = makeFloatBuffer(new float[] {
			// Top Of Triangle (Front)
			0.0f, 1.0f, 0.0f,
			// Left Of Triangle (Front)
			-1.0f, -1.0f, 1.0f,
			// Right Of Triangle (Front)
			1.0f, -1.0f, 1.0f,
			// Top Of Triangle (Right)
			0.0f, 1.0f, 0.0f,
			// Left Of Triangle (Right)
			1.0f, -1.0f, 1.0f,
			// Right Of Triangle (Right)
			1.0f, -1.0f, -1.0f,
			// Top Of Triangle (Back)
			0.0f, 1.0f, 0.0f,
			// Left Of Triangle (Back)
			1.0f, -1.0f, -1.0f,
			// Right Of Triangle (Back)
			-1.0f, -1.0f, -1.0f,
			// Top Of Triangle (Left)
			0.0f, 1.0f, 0.0f,
			// Left Of Triangle (Left)
			-1.0f, -1.0f, -1.0f,
			// Right Of Triangle (Left)
			-1.0f, -1.0f, 1.0f, });

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

	FloatBuffer tcolor = makeFloatBuffer(new float[] {
			// Red
			1.0f, 0.0f, 0.0f, 1.0f,
			// Green
			0.0f, 1.0f, 0.0f, 1.0f,
			// Blue
			0.0f, 0.0f, 1.0f, 1.0f,
			// Red
			1.0f, 0.0f, 0.0f, 1.0f,
			// Green
			0.0f, 1.0f, 0.0f, 1.0f,
			// Blue
			0.0f, 0.0f, 1.0f, 1.0f,
			// Red
			1.0f, 0.0f, 0.0f, 1.0f,
			// Green
			0.0f, 1.0f, 0.0f, 1.0f,
			// Blue
			0.0f, 0.0f, 1.0f, 1.0f,
			// Red
			1.0f, 0.0f, 0.0f, 1.0f,
			// Green
			0.0f, 1.0f, 0.0f, 1.0f,
			// Blue
			0.0f, 0.0f, 1.0f, 1.0f, });

	FloatBuffer qcolor = makeFloatBuffer(new float[] {
			// Green
			0.0f, 1.0f, 0.0f, 1.0f,
			//
			0.0f, 1.0f, 0.0f, 1.0f,
			//
			0.0f, 1.0f, 0.0f, 1.0f,
			//
			0.0f, 1.0f, 0.0f, 1.0f,

			// Orange
			1.0f, 0.5f, 0.0f, 1.0f,
			//
			1.0f, 0.5f, 0.0f, 1.0f,
			//
			1.0f, 0.5f, 0.0f, 1.0f,
			//
			1.0f, 0.5f, 0.0f, 1.0f,

			// Red
			1.0f, 0.0f, 0.0f, 1.0f,
			//
			1.0f, 0.0f, 0.0f, 1.0f,
			//
			1.0f, 0.0f, 0.0f, 1.0f,
			//
			1.0f, 0.0f, 0.0f, 1.0f,

			// Yellow
			1.0f, 1.0f, 0.0f, 1.0f,
			//
			1.0f, 1.0f, 0.0f, 1.0f,
			//
			1.0f, 1.0f, 0.0f, 1.0f,
			//
			1.0f, 1.0f, 0.0f, 1.0f,

			// Blue
			0.0f, 0.0f, 1.0f, 1.0f,
			//
			0.0f, 0.0f, 1.0f, 1.0f,
			//
			0.0f, 0.0f, 1.0f, 1.0f,
			//
			0.0f, 0.0f, 1.0f, 1.0f,

			// Violet
			1.0f, 0.0f, 1.0f, 1.0f,
			//
			1.0f, 0.0f, 1.0f, 1.0f,
			//
			1.0f, 0.0f, 1.0f, 1.0f,
			//
			1.0f, 0.0f, 1.0f, 1.0f, });

	float rtri = 0.0f;

	float rquad = 0.0f;

	/**
     * 
     */
	public Lesson05() {
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
		gl.glRotatef(rtri, 0.0f, 1.0f, 0.0f);

		gl.glColorPointer(4, GL10.GL_FLOAT, 0, tcolor);
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, triangle);

		gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 12);

		// quad
		gl.glLoadIdentity();
		gl.glTranslatef(1.5f, 0.0f, -6.0f);
		gl.glRotatef(rquad, 1.0f, 0.0f, 0.0f);

		gl.glColorPointer(4, GL10.GL_FLOAT, 0, qcolor);
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, quad);

		gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 0, 4);
		gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 4, 4);
		gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 8, 4);
		gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 12, 4);
		gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 16, 4);
		gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 20, 4);

		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glDisableClientState(GL10.GL_COLOR_ARRAY);

		// change rotation
		rtri += 2.0f;
		rquad -= 1.5f;
	}

}
