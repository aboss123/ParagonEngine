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

package net.paragonengine.api.frameworks2D.render;

import GameKit.API.Frost2D;
import GameKit.API.StateObject;
import GameKit.API.Texture;
import GameKit.Transition.FadingTransition;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * This class manages proper transitions as well as other useful processes that
 * need to be done that display things graphically.
 * 
 * @author Ashish Bailkeri
 *
 */

public class TweenHandler {
	
	/**
	 * This adds a dialogue box to the screen.
	 *
     * @param renderer The graphics component
	 * @param box  The {@link Texture} for the box
	 * @param text The text to be displayed
     * @param font The font of the text to be drawn
     * @param color The {@link Color} that the font will be applied to the font
	 * @param x    The X point for where the box is
	 * @param y    The Y point for where the box is
	 */

	public static void addDialogueBox(Frost2D renderer, Texture box, String text,
                                      Font font, Color color, int x, int y) {
	    // Draw the box
	    renderer.draw(box, x, y);

	    // Setup text
        renderer.setFont(font, color);
        renderer.drawString(text, x + 10, y - 10);
	}
	
	/**
	 * Applies a fading transition.
	 *
	 * @param renderer The graphics component
	 * @param image The BufferedImage
	 * @param length The length of the transition
	 * @param fadeIn The length of fading in
	 * @param fadeOut The length of fading out
	 * @param state The state to set after transition
	 */
	
	public static void applyFadeTransition(Frost2D renderer, BufferedImage image, int length, int fadeIn,
                                           int fadeOut, StateObject state) {
		FadingTransition fade = new FadingTransition(image, fadeOut, fadeOut, fadeOut, state);
		fade.update();
		fade.render(renderer);
	}
	
	
}
