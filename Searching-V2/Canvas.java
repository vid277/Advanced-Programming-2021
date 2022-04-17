//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D.Double;
import java.awt.image.ImageObserver;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Canvas {
    private JFrame frame;
    private Canvas.CanvasPane canvas;
    private Graphics2D graphic;
    private Color backgroundColor;
    private Image canvasImage;

    public Canvas(String title) {
        this(title, 500, 500, Color.white);
    }

    public Canvas(String title, int width, int height) {
        this(title, width, height, Color.white);
    }

    public Canvas(String title, int width, int height, Color bgColor) {
        this.frame = new JFrame();
        this.canvas = new Canvas.CanvasPane();
        this.frame.setContentPane(this.canvas);
        this.frame.setTitle(title);
        this.canvas.setPreferredSize(new Dimension(width, height));
        this.backgroundColor = bgColor;
        this.frame.pack();
        this.setVisible(true);
    }

    public Canvas() {}

    public void setVisible(boolean visible) {
        if (this.graphic == null) {
            Dimension size = this.canvas.getSize();
            this.canvasImage = this.canvas.createImage(size.width, size.height);
            this.graphic = (Graphics2D)this.canvasImage.getGraphics();
            this.graphic.setColor(this.backgroundColor);
            this.graphic.fillRect(0, 0, size.width, size.height);
            this.graphic.setColor(Color.black);
        }

        this.frame.setVisible(true);
    }

    public boolean isVisible() {
        return this.frame.isVisible();
    }

    public void draw(Shape shape) {
        this.graphic.draw(shape);
        this.canvas.repaint();
    }

    public void fill(Shape shape) {
        this.graphic.fill(shape);
        this.canvas.repaint();
    }

    public void fillCircle(int xPos, int yPos, int diameter) {
        Double circle = new Double((double)xPos, (double)yPos, (double)diameter, (double)diameter);
        this.fill(circle);
    }

    public void fillRectangle(int xPos, int yPos, int width, int height) {
        this.fill(new Rectangle(xPos, yPos, width, height));
    }

    public void erase() {
        Color original = this.graphic.getColor();
        this.graphic.setColor(this.backgroundColor);
        Dimension size = this.canvas.getSize();
        this.graphic.fill(new Rectangle(0, 0, size.width, size.height));
        this.graphic.setColor(original);
        this.canvas.repaint();
    }

    public void eraseCircle(int xPos, int yPos, int diameter) {
        Double circle = new Double((double)xPos, (double)yPos, (double)diameter, (double)diameter);
        this.erase(circle);
    }

    public void eraseRectangle(int xPos, int yPos, int width, int height) {
        this.erase(new Rectangle(xPos, yPos, width, height));
    }

    public void erase(Shape shape) {
        Color original = this.graphic.getColor();
        this.graphic.setColor(this.backgroundColor);
        this.graphic.fill(shape);
        this.graphic.setColor(original);
        this.canvas.repaint();
    }

    public void eraseOutline(Shape shape) {
        Color original = this.graphic.getColor();
        this.graphic.setColor(this.backgroundColor);
        this.graphic.draw(shape);
        this.graphic.setColor(original);
        this.canvas.repaint();
    }

    public boolean drawImage(Image image, int x, int y) {
        boolean result = this.graphic.drawImage(image, x, y, (ImageObserver)null);
        this.canvas.repaint();
        return result;
    }

    public void drawString(String text, int x, int y) {
        this.graphic.drawString(text, x, y);
        this.canvas.repaint();
    }

    public void eraseString(String text, int x, int y) {
        Color original = this.graphic.getColor();
        this.graphic.setColor(this.backgroundColor);
        this.graphic.drawString(text, x, y);
        this.graphic.setColor(original);
        this.canvas.repaint();
    }

    public void drawLine(int x1, int y1, int x2, int y2) {
        this.graphic.drawLine(x1, y1, x2, y2);
        this.canvas.repaint();
    }

    public void setForegroundColor(Color newColor) {
        this.graphic.setColor(newColor);
    }

    public Color getForegroundColor() {
        return this.graphic.getColor();
    }

    public void setBackgroundColor(Color newColor) {
        this.backgroundColor = newColor;
        this.graphic.setBackground(newColor);
    }

    public Color getBackgroundColor() {
        return this.backgroundColor;
    }

    public void setFont(Font newFont) {
        this.graphic.setFont(newFont);
    }

    public Font getFont() {
        return this.graphic.getFont();
    }

    public void setSize(int width, int height) {
        this.canvas.setPreferredSize(new Dimension(width, height));
        Image oldImage = this.canvasImage;
        this.canvasImage = this.canvas.createImage(width, height);
        this.graphic = (Graphics2D)this.canvasImage.getGraphics();
        this.graphic.setColor(this.backgroundColor);
        this.graphic.fillRect(0, 0, width, height);
        this.graphic.drawImage(oldImage, 0, 0, (ImageObserver)null);
        this.frame.pack();
    }

    public Dimension getSize() {
        return this.canvas.getSize();
    }

    public void wait(int milliseconds) {
        try {
            Thread.sleep((long)milliseconds);
        } catch (InterruptedException var3) {
        }

    }

    private class CanvasPane extends JPanel {
        private CanvasPane() {
        }

        public void paint(Graphics g) {
            g.drawImage(Canvas.this.canvasImage, 0, 0, (ImageObserver)null);
        }
    }
}
