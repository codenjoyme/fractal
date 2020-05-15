package apofig.fractals;

import io.nayuki.bmpio.BmpImage;
import io.nayuki.bmpio.BmpWriter;
import io.nayuki.bmpio.Rgb888Image;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public final class PaletteTest {

    public static void main(String[] args) throws IOException {
        BmpImage bmp = new BmpImage();
        RandomPalette palette = new RandomPalette(512);
        Rgb888Image image = new PaletteImage(palette);
        bmp.image = image;
        File file = new File(palette.getClass().getSimpleName() + ".bmp");
        FileOutputStream out = new FileOutputStream(file);
        BmpWriter.write(out, bmp);
        out.close();
    }

}
