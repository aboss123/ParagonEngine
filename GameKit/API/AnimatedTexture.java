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

/**
 * Same structure as the {@link Animation} class and it does the
 * same thing for textures that can be animated.
 * @author Ashish Bailkeri
 *
 */

public class AnimatedTexture {
	
	/**
	 * The texture array of frames that represent what
	 * will be animating.
	 */
	
	protected Texture[] frames;
	
	/**
	 * The integer representing an individual frame of the
	 * animation.
	 */
	
	protected int frame;
	
	/**
	 * The set of looping through the animation.
	 */
	
	protected long startTime, delay, elapsed;
	
	/**
	 * To check whether the animation has been played or not.
	 */
	
	protected boolean played;
	
	public AnimatedTexture() {}
	
	
	/**
	 * This creates a new AnimatedTexture.
	 * 
	 * @param frames The texture array of frames.
	 */
	
	public AnimatedTexture(Texture[] frames) {
		this.frames = frames;
		delay = -1;
		startTime = System.nanoTime();
		played = false;
		
		frame = 0;
	}
	
	/**
	 * Retrieves the frames of the texture.
	 * 
	 * @return The Texture[] of frames
	 */
	
	public Texture[] getFrames() {
		return frames;
	}
	
	/**
	 * Sets the frames of the texture.
	 * 
	 * @param frames The Texture[] of frames
	 */
	
	public void setFrames(Texture[] frames) {
		this.frames = frames;
		delay = -1;
		startTime = System.nanoTime();
		played = false;
	}
	
	/**
	 * Updates the animation like normal.
	 */
	
	public void update() {
		if (delay == -1)
			return;

		long elapsed = (System.nanoTime() - startTime) / 1000000;
		if (elapsed > delay) {
			frame++;
			startTime = System.nanoTime();
		}
		if (frame == frames.length) {
			frame = 0;
			played = true;
		}
	}
	
	/**
	 * Retrieves the current animated texture.
	 * 
	 * @return The current animated texture
	 */
	
	public Texture getAnimatedTexture() {
		return frames[frame];
	}

}
