/*
 * Copyright (c) 2019, Ashish Bailkeri. All rights reserved.
 *
 * 1. Redistribution in source and in binary forms is NOT permitted
 * in any way shape or form unless given permission by the license holder.
 *
 * 2. Any person(s) who have access to this code by the license holder need this
 * license to be present in their code.
 *
 * 3. The name of the license holder may not be used to endorse or promote products derived
 * from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

package GameKit.API;

import GameKit.Destroyable;
import net.paragonengine.api.frameworks2D.render.RenderEngine;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 * The Frost2D render manager is a custom graphics component that is used instead of the standard {@link Graphics2D}
 * graphics component. This component contains other custom functions that utilize the
 * <code>Graphics2D</code> component to create enhanced and advanced graphics and rendering
 * functions that are applicable to what the engine needs and what would be needed in a normal
 * graphics component. This specific one ties in with the {@link RenderEngine} and will be used in all the
 * functions for the class which will be managed and used in the LGF (LEGEND GAME FRAMEWORK) for the rendering
 * that is needed on demand. This custom graphics component will be used as a light weight version of
 * built in Java Graphics components. The reason for this is efficiency and it takes less work for the
 * computer to use a component that doesn't require that as many methods.
 * @author Ashish Bailkeri
 */

public abstract class Frost2D implements Destroyable {

    /**
     * The variable that represents the Graphics2D component needed
     * to initialize this graphics component.
     */

    private Graphics2D g;


    /**
     * This variable represents the pixels on a screen.
     */

    private int[] p = ((DataBufferInt) AbstractGame.getWindow().getImage().getRaster().getDataBuffer()).getData();

    /**
     * This represents the pixel height.
     */

    private int pH = AbstractGame.getWindow().getHeight();

    /**
     * This variable represents the pixel width.
     */

    private int pW = AbstractGame.getWindow().getWidth();



    /**
     * Basic Frost2D constructor used to initialize the Graphics2D in order
     * to be able to draw anything onto the screen.
     */

    public Frost2D(Graphics2D g) {
        this.g = g;
    }

    /**
     * Default constructor
     */
    public Frost2D() {}



    /**
     * Generates pixels for the screen with the given value and coordinates.
     *
     * @param x The X coordinate
     * @param y The Y coordinate
     * @param value The value
     */

    public void generatePixels(int x, int y, int value) {

        if((x < 0 || x >= pW || y < 0 || y >= pH) || value == 0xffff00ff) {
            return;
        }

        p[x + y * pW] = value;

    }

    /**
     * Draws an {@link BufferedImage} to the screen with what offset it starts
     * on the screen.
     *
     * @param i The {@link BufferedImage} to draw
     * @param xOffset The X offset to draw
     * @param yOffset The Y offset to draw
     */

    public void drawPixels(BufferedImage i, int xOffset, int yOffset) {

        int[] p = i.getRGB(0, 0, i.getWidth(), i.getHeight(), null, 0, i.getWidth());

        for(int y = 0; y < i.getHeight(); y++) {
            for(int x = 0; x < i.getWidth(); x++) {
                generatePixels((x + xOffset),
                        (y + yOffset), p[x + y * i.getWidth()]);
            }
        }

    }

    /**
     * Draws an {@link BufferedImage} to the screen with what offset it starts
     * on the screen.
     *
     * @param i The {@link BufferedImage} to draw
     * @param xOffset The X offset to draw
     * @param yOffset The Y offset to draw
     * @param width The width of the {@link BufferedImage}
     * @param height The height of the {@link BufferedImage}
     */

    public void drawPixels(BufferedImage i, float xOffset, float yOffset, int width, int height) {

        int[] p = i.getRGB(0, 0, width, height, null, 0, width);

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                generatePixels((int) (x + xOffset),
                        (int) (y + yOffset), p[x + y * width]);
            }
        }

    }

    /**
     * Instance of the {@link Graphics2D} draw image that MUST be used in
     * certain rendering cases.
     *
     * @param i The {@link BufferedImage} to draw
     * @param x The X location of the image
     * @param y The Y location of the image
     * @param width The width of the image (SCALE)
     * @param height The height of the image (SCALE)
     */

    public void drawImage(BufferedImage i, int x, int y, int width, int height) {
        g.drawImage(i, x, y, width, height, null);
    }


    /**
     * Fills a rectangle completely. This method may be used with
     * transition that involve boxes of rectangles.
     *
     * @param xOffset The X location of the rectangle
     * @param yOffset The Y location of the rectangle
     * @param width The width of the rectangle
     * @param height The height of the rectangle
     * @param color The {@link Color} to fill the rectangle with
     */

    public void fillRect(int xOffset, int yOffset, int width, int height, Color color) {
        for(int y = 0; y <= height; y++) {
            for(int x = 0; x <= width; x++) {
                generatePixels((x + xOffset), (y + yOffset), color.getRGB());
            }
        }
    }

    /**
     * Fills a rectangle completely. This method may be used with
     * transition that involve boxes of rectangles.
     *
     * @param xOffset The X location of the rectangle
     * @param yOffset The Y location of the rectangle
     * @param width The width of the rectangle
     * @param height The height of the rectangle
     * @param color The {@link Color} to fill the rectangle with
     */

    public void fillRect(int xOffset, int yOffset, int width, int height, int color) {
        for(int y = 0; y <= height; y++) {
            for(int x = 0; x <= width; x++) {
                generatePixels((x + xOffset), (y + yOffset), color);
            }
        }
    }

    /**
     * Draws a rectangle with the X and Y offset, width and height
     * that is given with the color to draw the outline.
     *
     * @param xOffset The X offset to draw the rectangle
     * @param yOffset The Y offset to draw the rectangle
     * @param width The width of the rectangle to draw
     * @param height The height of the rectangle to draw
     * @param color The {@link Color} to draw the rectangle
     */

    public void drawRect(int xOffset, int yOffset, int width, int height, Color color) {
        for (int y = 0;  y <= height; y++) {
            generatePixels(yOffset, y + yOffset, color.getRGB());
            generatePixels(xOffset + width, y + yOffset, color.getRGB());
        }
        for (int x = 0; x <= width; x++) {
            generatePixels(x + xOffset, yOffset, color.getRGB());
            generatePixels(x + xOffset, yOffset + height, color.getRGB());
        }
    }


    /**
     * Creates a rectangle.
     *
     * @param x The X of the rectangle
     * @param y The Y of the rectangle
     * @param w The width of the rectangle
     * @param h The height of the rectangle
     * @param color The color that rectangle will be
     */

	public void createRect(int x, int y, int w, int h, Color color) {
		fillRect(x, y, w, h, color);
		drawRect(x, y, w, h, color);
	}

    /**
     * Draws an {@link BufferedImage} to the screen.
     *
     * @param i The {@link BufferedImage} image
     * @param x The X location
     * @param y The Y location
     */

	public void draw(BufferedImage i, int x, int y) {
		drawPixels(i, x, y);
	}

    /**
     * Draws a {@link Texture} to the screen.
     *
     * @param texture The {@link Texture} texture
     * @param x The X location of the texture
     * @param y The Y location of the texture
     */

	public void draw(Texture texture, int x, int y) {
	    texture.drawTexture(this, x, y, texture.getWidth(), texture.getHeight());
    }

    /**
     * Draws a {@link Tile} to the screen.
     *
     * @param texture The {@link Texture} for the tile
     * @param x The X location to spawn it
     * @param y The Y location to spawn it
     */

    public void drawTile(Texture texture, float x, float y) {
	    texture.drawTileTexture(this, (int) x, (int) y);
    }


    /**
     * Draws a {@link Texture} to the screen.
     *
     * @param texture The {@link Texture} texture
     * @param x The X location of the texture
     * @param y The Y location of the texture
     * @param width The width of the texture (SCALE)
     * @param height The height of the texture (SCALE)
     */

    public void draw(Texture texture, int x, int y, int width, int height) {
	    texture.drawTexture(this, x, y, width, height);
    }

    /**
     * Draws an image to the screen.
     *
     * @param i The {@link BufferedImage} image
     * @param x The X location
     * @param y The Y location
     * @param width The width of the image (SCALE)
     * @param height The height of the image (SCALE)
     */

    public void draw(BufferedImage i, int x, int y, int width, int height) {
        drawImage(i, x, y, width, height);
    }

    /**
     * Tests whether a {@link Texture} can be drawn to the screen.
     *
     * @param texture The {@link Texture} texture
     */

    public void debugDraw(Texture texture) {
	    texture.drawTexture(this, (int) Content.random(5, AbstractGame.getWindow().getWidth()),
                (int) Content.random(5, AbstractGame.getWindow().getHeight()),
                texture.getWidth(),
                texture.getHeight());
    }


    /**
     * Draws {@link BufferedImage} image to the screen at a random
     * point on it. It gets the width and height of the screen to do
     * this.
     *
     * @param img The {@link BufferedImage} image
     */

	public void randomDraw(BufferedImage img) {
		draw(img, (int) Content.random(5, AbstractGame.getWindow().getWidth()),
                (int) Content.random(5, AbstractGame.getWindow().getHeight()));
	}

    /**
     * Enhanced method of setting fonts. Uses the {@link Color} class
     * to bind in with {@link Font} to create a direct font with color
     * which can be set to NULL if it needs to be changed in the future.
     *
     * @param font The {@link Font} font
     * @param c The {@link Color} color
     */

	public void setFont(Font font, Color c) {
	    setColor(c);
	    g.setFont(font);
    }

    /**
     * Uses an instance from the {@link Content#drawString(Graphics2D, String, int)}
     * and reduces the fact to add the graphics component completely and adds it in as
     * a Frost2D graphics component. This method draws a string to the center of the screen
     * if the difference is 0.
     *
     * @param s The string to draw
     * @param yDifference The positive integer for where to subtract the Y (MOVES STRING UP)
     * and if the integer is negative (MOVES STRING DOWN) from the center
     */

    public void drawString(String s, int yDifference) {
	    Content.drawString(g, s, yDifference);
    }

    /**
     * Uses an instance from the {@link Content#drawString(Graphics2D, String, Font, int)}
     * and reduces the graphics component for more efficient drawing and it adds it to the
     * Frost2D graphics component. This method draws a string to the center of the screen when
     * the difference is 0.
     *
     * @param s The string to draw
     * @param font The {@link Font} to apply to the string
     * @param yDifference The positive integer for where to subtract the Y (MOVES STRING UP)
     * and if the integer is negative (MOVES STRING DOWN) from the center
     */


    public void drawString(String s, Font font, int yDifference) {
        Content.drawString(g, s, font, yDifference);
    }

    /**
     * Uses an instance from the {@link Content#drawString(Graphics2D, String, Font, Color, int)}
     * and reduces the graphics component for more efficient drawing and adds it to the Frost2D
     * graphics component. This method draws a string to the center of the screen when the difference
     * is 0.
     *
     * @param s The string to draw
     * @param font The {@link Font} to apply to the string
     * @param c The {@link Color} color to apply to the font
     * @param yDifference The positive integer for where to subtract the Y (MOVES STRING UP)
     * and if the integer is negative (MOVES STRING DOWN) from the center
     */

    public void drawString(String s, Font font, Color c, int yDifference) {
        Content.drawString(g, s, font, c, yDifference);
    }

    /**
     * Instance of the {@link Graphics2D} draw string method
     * for general usages when necessary.
     *
     * @param s The string to draw
     * @param x The X location for the string
     * @param y The Y location for the string
     */

    public void drawString(String s, int x, int y) {
        g.drawString(s, x, y);
    }

    /**
     * Renders a {@link Animation} that is being applied to an <code>Entity</code>'
     * and renders that specific animation for that entity.
     *
     * @param animation The {@link Animation} that is being applied
     * @param e The {@link Entity} that is being rendered for a specific animation
     */

    public void playAnimation(Animation animation, Entity e) {
        drawImage(animation.getSetAnimation(), (int) e.getX(), (int) e.getY(), e.getWidth(), e.getHeight());
    }

    /**
     * Plays a set of {@link BufferedImage}s in a row that are a part of an
     * array of BufferedImages and plays them one after another.
     *
     * @param frames The {@link BufferedImage}s that make up the animation
     * @param x The X location to render
     * @param y The Y location to render
     */

    public void playAnimation(BufferedImage[] frames, int x, int y) {
        for (int i = 0; i < frames.length ; i++) {
            draw(frames[i], x, y, frames[i].getWidth(),frames[i].getHeight());
        }
    }

    /**
     * Renders a {@link Animation} that is applied to an <code>Entity</code>
     * and renders the given integer that represents the animation.
     *
     * @param i The integer that represents the animation in frame
     * @param e The {@link Entity} that is being rendered for a specific animation
     */

    public void playAnimation(int i, Entity e) {
        Animation.setAnimation(i, e);
    }

    /**
     * Renders a {@link Entity} to a given {@link BufferedImage} and
     * automatically retrieves the width and height and X and Y positions
     * for the <code>Entity</code>
     *
     * @param i The {@link BufferedImage} image
     * @param e The {@link Entity} entity to apply the image to
     */

    public void renderEntity(BufferedImage i, Entity e) {
        draw(i, (int) e.getX(), (int) e.getY(), e.getWidth(), e.getHeight());
    }

    /**
     * Moves the {@link GameCamera} properly.
     *
     * @param camera The {@link GameCamera} camera
     */

    public void translateCamera(GameCamera camera) {
        g.translate(camera.getXTransfer(), camera.getYTransfer());
    }

    /**
     * Moves the screen depending the coordinates given.
     *
     * @param x The X move of the coordinate
     * @param y The Y move of the coordinate
     */

    public void translateCamera(float x, float y) {
        g.translate(x, y);
    }

    /**
     * This sets a {@link Color} to a component for use.
     *
     * @param c The {@link Color} color.
     */

    public void setColor(Color c) {
	    g.setColor(c);
    }

    /**
     * Fills a rectangle default.
     *
     * @param x The X location to draw
     * @param y The Y location to draw
     * @param width The width of the rectangle
     * @param height The height of the rectangle
     */

    public void fillRect(int x, int y, int width, int height) {
        g.fillRect(x, y, width, height);
    }

    /**
     * Clears a rectangle (Clearing screen)
     *
     * @param x The X location to clear
     * @param y The Y location to clear
     * @param width The width of the screen to clear
     * @param height The height of the screen to clear
     */

    public void clearRect(int x, int y, int width, int height) {
        g.clearRect(x, y, width, height);
    }

    /**
     * Destroys the drawing completely.
     */

    @Override
    public void destroy() {
	    g.dispose();
    }
}