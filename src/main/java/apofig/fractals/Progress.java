package apofig.fractals;

import io.nayuki.bmpio.Rgb888Image;

/**
 * User: oleksandr.baglai
 * Date: 1/21/13
 * Time: 4:39 AM
 */
public class Progress implements Rgb888Image {

    private long square;
    private long count;
    private long iteration;
    private long next;
    private FractalImage image;

    public Progress(FractalImage image) {
        this.image = image;
        this.square = getWidth()*getHeight();
        this.next = square/100;
    }

    public int getWidth() {
        return image.getWidth();
    }

    public int getHeight() {
        return image.getHeight();
    }

    public int getRgb888Pixel(int x, int y) {
        calculateProgress();

        return image.getRgb888Pixel(x, y);
    }

    private void calculateProgress() {
        iteration++;
        if (iteration == next) {
            count = count + iteration;
            iteration = 0;
            int progress = (int) ((double)count*100 / square);
            System.out.println(progress + "%");
        }
    }

    public String getFractalName() {
        return image.getFractalName();
    }
}
