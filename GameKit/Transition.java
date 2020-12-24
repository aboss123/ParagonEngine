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

package GameKit;

import GameKit.API.AbstractGame;
import GameKit.API.Content;
import GameKit.API.Frost2D;
import GameKit.API.StateObject;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * This is the embodiment of all transitions that can be used
 * through the game.
 * @author Ashish Bailkeri
 *
 */

public interface Transition {
	
	void update();
	void render(Frost2D renderer);
	
	// Fading Transition Class	
	class FadingTransition implements Transition {
		
		private int length;
		private int fadeIn;
		private int fadeOut;
		
		private int alpha;
		private int ticks;
		
		private BufferedImage image;
		private StateObject state;
		
		public FadingTransition(BufferedImage image, int length, int fadeIn, int fadeOut, StateObject state) {
			
			this.length = length;
			this.fadeIn = fadeIn;
			this.fadeOut = fadeOut;
			this.image = image;
			this.state = state;
			
		}

		@Override
		public void update() {
			ticks++;
			if(ticks < fadeIn) {
				alpha = (int) (255 - 255 * (1.0 * ticks / fadeIn));
				if(alpha < 0) alpha = 0;
			}
			if(ticks > fadeIn + length) {
				alpha = (int) (255 * (1.0 * ticks - fadeIn - length) / fadeOut);
				if(alpha > 255) alpha = 255;
			}
			if(ticks > fadeIn + length + fadeOut) {
				StateObject.setState(state);
			}
			
		}


		public FadingTransition(BufferedImage image, int length, int fadeIn, int fadeOut) {

			this.length = length;
			this.fadeIn = fadeIn;
			this.fadeOut = fadeOut;
			this.image = image;
		}

		public void update2() {
			ticks++;
			if(ticks < fadeIn) {
				alpha = (int) (255 - 255 * (1.0 * ticks / fadeIn));
				if(alpha < 0) alpha = 0;
			}
			if(ticks > fadeIn + length) {
				alpha = (int) (255 * (1.0 * ticks - fadeIn - length) / fadeOut);
				if(alpha > 255) alpha = 255;
			}
			if(ticks > fadeIn + length + fadeOut) {
                Content.print("DONE!");
			}

		}


		@Override
		public void render(Frost2D renderer) {
            renderer.fillRect(0, 0, AbstractGame.getWindow().getWidth(), AbstractGame.getWindow().getHeight() + 16);
            renderer.draw(image, 0, 0, AbstractGame.getWindow().getWidth(), AbstractGame.getWindow().getWidth() + 16);
            renderer.setColor(new Color(0, 0, 0, alpha));
            renderer.fillRect(0, 0, AbstractGame.getWindow().getWidth(), AbstractGame.getWindow().getHeight());
        }
		
	}

}
