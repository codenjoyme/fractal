package apofig.fractals;

import io.nayuki.bmpio.Rgb888Image;

/**
 * User: oleksandr.baglai
 * Date: 1/21/13
 * Time: 8:28 PM
 */
public class PaletteImage implements Rgb888Image {

    private Palette palette;

    public PaletteImage(Palette palette) {
        this.palette = palette;
    }

    @Override
    public int getWidth() {
        return palette.getSize();
    }

    @Override
    public int getHeight() {
        return 50;
    }

    @Override
    public int getRgb888Pixel(int x, int y) {
        return palette.getColor(x);
    }
}
