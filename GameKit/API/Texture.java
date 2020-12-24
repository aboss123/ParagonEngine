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

import java.awt.image.BufferedImage;

public class Texture {
	
	/**
	 * The image specified will help create the the texture.
	 */
	
	protected BufferedImage texture;
	
	/**
	 * This is the image's width.
	 */
	
	protected int imageWidth;
	
	/**
	 * This is the image's height.
	 */
	
	protected int imageHeight;
	
	/**
	 * This represents the animation for the image
	 * if needed.
	 */
	
	protected Animation animation;
	
	/**
	 * This is the constructor for creating a texture
	 * and it will be used for drawing many things to the
	 * screen and for other uses.
	 * 
	 * @param texture The BufferedImage that represents the texture
	 */
	
	public Texture(BufferedImage texture) {
		this.texture = texture;
		
		this.imageWidth = texture.getWidth();
		this.imageHeight = texture.getHeight();
	}
	
//	/**
//	 * Default constructor.
//	 */
//
//	public Texture() {}


    /**
     * Draws a specified tile texture given.
     *
     * @param renderer The graphics component
     * @param x The X location
     * @param y The Y location
     */

	public void drawTileTexture(Frost2D renderer, int x, int y) {
		renderer.drawPixels(texture, x, y);
	}

    /**
     * Draws the texture specified in the constructor
     * to the screen.
     *
     * @param renderer The graphics component
     * @param x The X location
     * @param y The Y location
     * @param width The width of the texture (SCALE)
     * @param height The height of the texture (SCALE)
     */

	public void drawTexture(Frost2D renderer, int x, int y, int width, int height) {
		renderer.drawPixels(texture, x, y, width, height);
	}


	/**
	 * Applies a new texture to a texture that already as a skin.
	 * 
	 * @param t1 The first texture
	 * @param t2 The texture to replace the previous one
	 */
	
	public void applyNewTexture(Texture t1, BufferedImage t2) {
		t1 = new Texture(t2);
	}


	public int getWidth() {
	    return imageWidth;
    }

    public int getHeight() {
	    return imageHeight;
    }

	
}
