package apofig.fractals;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * User: oleksandr.baglai
 * Date: 1/21/13
 * Time: 7:26 PM
 */
public class RandomPalette implements Palette {

    class Marker {
        int x;
        int color;

        public Marker(int x, int color) {
            this.x = x;
            this.color = color;
        }
    }

    private static final int MW = 8; // ширина маркера
    private static final int[] colorArray = new int[]{
            0xFFFF00, 0xFF00FF, 0xFFFFFF, 0xFF00FF, 0xF00000F, 0xFF7FFF, 0xFA8072,
            0xFFFFC0, 0xC0C0FF, 0xFFC0C0, 0xC0FFC0, 0xC000FF};

    private List<Marker> markers = new LinkedList<Marker>();
    private int[] palette;

    public RandomPalette(int size) {
        palette = new int[size];

        int color = getRandomColor();
        markers.add(new Marker(0, color));
        markers.add(new Marker(size, color));

        int count = random(size / (MW * 3)) + 3;
        double r = size / (count + 1);

        addBlackMarker(MW + 1);
        for (int i = 1; i <= count; i++) {
            int j = (int) (i * r);
            if (yesOrNo()) {
                addBlackMarker(j - MW - 1);
            }
            addMarker(j, getRandomColor());
            if (yesOrNo()) {
                addBlackMarker(j + MW + 1);
            }
        }
        addBlackMarker(size - MW - 1);

        calculatePalette();
    }

    private int getRandomColor() {
        return colorArray[random(colorArray.length)];
    }

    private boolean yesOrNo() {
        return random(2) == 1;
    }

    private void addBlackMarker(int x) {
        addMarker(x, 0);
    }

    private void calculatePalette() {
        int x = markers.get(0).x;
        for (int i = 0; i < markers.size() - 1; i++) {
            int length = markers.get(i + 1).x - markers.get(i).x;
            for (int dx = 0; dx < length; dx++) {
                palette[x + dx] = colorChange(markers.get(i).color, markers.get(i + 1).color, length, dx);
            }
            x = x + length;
        }
        palette[0] = 0;
    }

    private int colorChange(int from, int to, double len, double x) {
        double red = change(getR(from), getR(to), len, x);
        double green = change(getG(from), getG(to), len, x);
        double blue = change(getB(from), getB(to), len, x);

        return rgb((int) red, (int) green, (int) blue);
    }

    private double change(double from, double to, double len, double x) {
        if (from == to) {
            return from;
        }

        double delta = Math.abs(from - to) * x / len;

        if (from < to) {
            return from + delta;
        } else {
            return from - delta;
        }
    }

    private int getR(int col) {
        return (col & 0x0000FF);
    }

    private int getG(int col) {
        return (col & 0x00FF00) >>> 8;
    }

    private int getB(int col) {
        return (col & 0xFF0000) >>> 16;
    }

    private int rgb(int r, int g, int b) {
        return (r) | (g << 8) | (b << 16);
    }

    private void addMarker(int x, int color) {
        // определяем после которого маркера будет создаваемый
        int index;
        for (index = 0; index < markers.size(); index++) {
            if ((markers.get(index).x < x) && (x < markers.get(index + 1).x)) {
                break;
            }
        }

        // если после последнего то выходим
        if (index == markers.size()) {
            return;
        }

        // если маркер некуда втиснуть между двумя ближайшими то выходим
        if (markers.get(index + 1).x - markers.get(index).x < MW + 2) {
            return;
        }

        // очень близко ставить маркер возле соседнего нельзя
        if ((markers.get(index).x + MW + 1 > x) || (markers.get(index + 1).x - MW - 1 < x)) {
            return;
        }

        markers.add(index + 1, new Marker(x, color));
    }

    private int random(int n) {
        return new Random().nextInt(n);
    }

    @Override
    public int getColor(int r) {
        return palette[r];
    }

    @Override
    public int getSize() {
        return palette.length;
    }

}
