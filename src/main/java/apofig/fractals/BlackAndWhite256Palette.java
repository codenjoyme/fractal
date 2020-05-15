package apofig.fractals;

/**
 * User: oleksandr.baglai
 * Date: 1/21/13
 * Time: 7:26 PM
 */
public class BlackAndWhite256Palette implements Palette {

    @Override
    public int getColor(int r) {
        return (r) | (r << 8) | (r << 16);
    }

    @Override
    public int getSize() {
        return 256;
    }

}
