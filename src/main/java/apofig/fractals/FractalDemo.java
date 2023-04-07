package apofig.fractals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import io.nayuki.bmpio.BmpImage;
import io.nayuki.bmpio.BmpWriter;


public class FractalDemo {


	public static void main(String[] args) throws IOException {
        FractalDemo fractalDemo = new FractalDemo();
        fractalDemo.draw(new Mandelbrot());
        fractalDemo.draw(new Julia());
        fractalDemo.draw(new MandelbrotNew());


	}
    public void writeTo(BmpImage bmp, Progress image) throws IOException {
        File file = new File(image.getFractalName() + ".bmp");
        FileOutputStream out = new FileOutputStream(file);
        BmpWriter.write(out, bmp);
        out.close();
    }
    public void draw(Fractal fractal) throws IOException {
        BmpImage bmp = new BmpImage();
        Palette palette = new RandomPalette(512);
        Progress image = new Progress(new FractalImage(1920, 1080, fractal, palette));
        bmp.image = image;
        writeTo(bmp,image);
    }
}
