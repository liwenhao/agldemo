/**
 * Copyright (C) 2010 Wenhao Li. All Rights Reserved.
 * 
 */
package com.agldemo.lessons;

import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;
import android.content.Context;
import android.opengl.GLU;

import com.agldemo.Lesson;


/**
 * Lesson 02
 */
public class Lesson02 extends Lesson {

	FloatBuffer triangle = makeFloatBuffer(new float[] {
			// Top Of Triangle
			0.0f, 1.0f, 0.0f,
			// Left Of Triangle
			-1.0f, -1.0f, 0.0f,
			// Right Of Triangle
			1.0f, -1.0f, 0.0f });

	FloatBuffer quad = makeFloatBuffer(new float[] {
			// Top Right Of The Quad
			1.0f, 1.0f, 0.0f,
			// Top Left Of The Quad
			-1.0f, 1.0f, 0.0f,
			// Bottom Left Of The Quad
			1.0f, -1.0f, 0.0f,
			// Bottom Right Of The Quad
			-1.0f, -1.0f, 0.0f });

	public Lesson02(Context c) {
		super(c, "Lesson 02", "Your First Polygon");
	}

	public void onDrawFrame(GL10 gl, int width, int height) {
		float ratio = (float) width / height;
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		GLU.gluPerspective(gl, 45.0f, ratio, 0.1f, 100.0f);

		gl.glMatrixMode(GL10.GL_MODELVIEW);

		gl.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

		// triangle
		gl.glLoadIdentity();
		gl.glTranslatef(-1.5f, 0.0f, -6.0f);
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, triangle);
		gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);

		// quad
		gl.glLoadIdentity();
		gl.glTranslatef(1.5f, 0.0f, -6.0f);

		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, quad);

		gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);

		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
	}

}
