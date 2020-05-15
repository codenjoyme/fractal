package apofig.fractals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import p79068.bmpio.BmpImage;
import p79068.bmpio.BmpWriter;


public final class FractalDemo {
	
	public static void main(String[] args) throws IOException {
        draw(new Mandelbrot());
        draw(new Julia());
	}

    private static void draw(Fractal fractal) throws IOException {
        BmpImage bmp = new BmpImage();
        Palette palette = new RandomPalette(512);
        Progress image = new Progress(new FractalImage(1920, 1080, fractal, palette));
        bmp.image = image;
        File file = new File(image.getFractalName() + ".bmp");
        FileOutputStream out = new FileOutputStream(file);
        BmpWriter.write(out, bmp);
        out.close();
    }

}
