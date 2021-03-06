package io.nayuki.bmpio;

/**
 * Copyright © 2011 Nayuki Minase
 *
 * @site https://github.com/nayuki/BMP-IO
 *
 * (MIT License)
 *
 * Permission  is  hereby  granted, free  of charge, to  any  person  obtaining
 * a copy of this software and associated documentation files (the "Software"),
 * to deal in  the Software  without restriction,  including without limitation
 * the rights to use, copy, modify,  merge,  publish,  distribute,  sublicense,
 * and/or sell  copies of the Software, and  to  permit  persons  to  whom  the
 * Software is furnished  to  do  so,  subject  to  the  following  conditions:
 *
 * The above copyright notice  and this permission  notice  shall  be  included
 * in all copies or substantial portions of the Software.
 *
 * The Software is  provided "as is",  without warranty  of any  kind,  express
 * or implied, including  but not limited to the warranties of merchantability,
 * fitness for a particular  purpose and noninfringement. In no event shall the
 * authors  or  copyright  holders be  liable for any  claim, damages or  other
 * liability,  whether in an  action of  contract, tort  or otherwise,  arising
 * from, out of or in connection with the Software or the use or other dealings
 * in the Software.
 */

public final class BufferedRgb888Image implements Rgb888Image {
	
	private int width;
	
	private int height;
	
	private int[] pixels;
	
	
	
	public BufferedRgb888Image(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}
	
	
	
	public int getWidth() {
		return width;
	}
	
	
	public int getHeight() {
		return height;
	}
	
	
	public int getRgb888Pixel(int x, int y) {
		if (x < 0 || x >= width || y < 0 || y >= height)
			throw new IndexOutOfBoundsException();
		return pixels[y * width + x];
	}
	
	
	public void setRgb888Pixel(int x, int y, int color) {
		if (x < 0 || x >= width || y < 0 || y >= height)
			throw new IndexOutOfBoundsException();
		pixels[y * width + x] = color;
	}
	
}
