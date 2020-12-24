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
import java.util.ArrayList;

/**
 * This class will animate any BufferedImage array of sprites that it
 * contains to be able to animate. This class allows for animating multiple
 * animations at one time in a specified character sprite sheet.
 * @author Ashish Bailkeri
 *
 */

public class Animation {
	
	/**
	 * Frames in the animation.
	 */	
	protected BufferedImage[] frames;
	
	/**
	 * An individual integer representing a frame number
	 * within the animation.
	 */
	
	protected int frame;
	
	/**
	 * This is the starting time for the animation.
	 */
	
	protected long startTime;
	
	/**
	 * The delay of the current animation.
	 */
	
	protected long delay;
	
	/**
	 * The total elapsed time to be played.
	 */
	
	protected long elapsed;
	
	/**
	 * This value is there to be able to check if animation 
	 * has been played or not played.
	 */
	
	protected boolean played;

    /**
     * Representing a custom array list of sprite animations in the
     * advanced animate functions.
     */

	public static ArrayList<BufferedImage[]> spriteAnimations;

    /**
     * Integer array of the number of sprites in each row of a
     * character sheet.
     */

	private static int[] nSprites;

    /**
     * The widths of the sprites in the character sheet.
     */

	private static int[] sWidth;

    /**
     * The heights og the sprites in the character sheet.
     */

	private static int[] sHeight;

    /**
     * {@link GKPhysics} object to determine the physics of an animation.
     */

	private GKObject.Direction direction;

	/**
	 * This is the main constructor of the animation.
	 * 
	 * @param frames The frames of the images
	 */
	

	public Animation(BufferedImage[] frames) {
		this.frames = frames;
		delay = -1;
		startTime = System.nanoTime();
		played = false;

		frame = 0;
	}

	public Animation() { frame = 0; }

	/**
	 * Returns frames of the animation.
	 * 
	 * @return The frames of the BufferedImage
	 */

	public BufferedImage[] getFrames() {
		return frames;
	}

    /**
     * Sets the animation's {@link GameKit.API.GKObject.Direction}.
     *
     * @param direction The {@link GameKit.API.GKObject.Direction} of the animation
     */

	public void setDirection(GKObject.Direction direction) {
	    this.direction = direction;
    }

    /**
     * Retrieves the {@link GameKit.API.GKObject.Direction} of the animation.
     *
     * @return The {@link GameKit.API.GKObject.Direction} of the animation
     */

	public GKObject.Direction getDirection() {
	    return direction;
    }

    /**
     * Gets the {@link GameKit.API.GKObject.Direction} of the specified animation.
     *
     * @param animation The {@link Animation} to get the Direction from
     * @return The {@link GameKit.API.GKObject.Direction} of the animation
     */

    public static GKObject.Direction getDirection(Animation animation) {
	   return animation.getDirection();
    }

	/**
	 * Set the current frames for an animation can be set through this method.
	 * 
	 * @param frames The BufferedImage frames
	 */

	public void setFrames(BufferedImage[] frames) {
		this.frames = frames;
		delay = -1;
		startTime = System.nanoTime();
		played = false;
	}

	/**
	 * Updates the current animation that you define.
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
	 * Get the current image the frame is currently at.
	 * 
	 * @return The individual set of frames of a certain set
	 * of animation
	 */

	public BufferedImage getSetAnimation() {
		return frames[frame];
	}

	/**
	 * Animates one row of the given SpriteSheet.
	 * 
	 * @param sheet     The SpriteSheet that contains the sprites
	 * @param width     The width of each sprite
	 * @param height    The height of each sprite
	 * @param sprites   The number of sprites in the row
	 * @param row       The row in which the sprite is being animated
	 * @param animation The animation that represents the cropped sheet
	 * 
	 * @return A single animation created from the specific row animated
	 */

	public static Animation animateRow(SpriteSheet sheet, int width, int height, int sprites, int row,
                                             Animation animation) {
		BufferedImage[] newSheet = new BufferedImage[sprites - 1];

		for (int i = 0; i < 1;) {
			newSheet[i] = sheet.cut(i * width, row * height, width, height);
			animation = new Animation(newSheet);
			return animation;
		}

		return animation;
	}

    /**
     * (ADVANCED) This method of animation will work on any set done properly even when the widths
     * and heights are disproportional. You must the number of sprites that are in each row of the
     * character sheet that you are animating. Then you must tell the width of each sprite in each row and
     * the same with the height.
     *
     * @param sheet The {@link SpriteSheet}
     * @param numSprites The number of sprites per row
     * @param spriteWidth The widths of the sprites per row
     * @param spriteHeight The height of the sprites per row
     */


	public static void animate(SpriteSheet sheet, int[] numSprites, int[] spriteWidth, int[] spriteHeight) {
	    nSprites = numSprites;
	    sWidth = spriteWidth;
	    sHeight = spriteHeight;
	    int count = 0;
	    spriteAnimations = new ArrayList<>();
        for (int i = 0; i <  numSprites.length; i++) {
            BufferedImage[] animations = new BufferedImage[numSprites[i]];
            for (int j = 0; j < numSprites[i] ; j++) {
                animations[j] = sheet.cut(j * spriteWidth[i], count, spriteWidth[i], spriteHeight[i]);
            }
            spriteAnimations.add(animations);
            count += spriteHeight[i];
        }
    }

    /**
     * Return the {@link BufferedImage} array of sprites of the animation.
     *
     * @param position The position the animations are located
     * @return The animation at that position
     */

    public static BufferedImage[] getAnimation(int position) {
	    return spriteAnimations.get(position);
    }

    /**
     * Clears all the animations to retrieve.
     */

    public static void clearAnimations() {
        spriteAnimations.clear();
    }


    /**
     * Sets the specific {@link Entity} to an animation and scales the
     * width and height depending on the animation.
     *
     * @param i The integer that represents the position of the animation in the array
     * @param e The {@link Entity} to apply the animation to
     */

    public static void setAnimation(int i, Entity e) {
	    Animation animation = new Animation();
	    animation.setFrames(spriteAnimations.get(i));
	    e.width = sWidth[i];
	    e.height = sHeight[i];
    }


	/**
	 * (PROPORTIONAL) Animate any image and specify parameters to crop out parts of
	 * the image in order to animate the image. Animations will only work when the
	 * sprites are proportional in width and height.
	 * 
	 * @param sheet     The {@link SpriteSheet} that contains the sprites
	 * @param sprites   The number of sprites in the row (not counting like an array list)
	 * @param animations The {@link Animation}s that will represent the values in the array
	 *                  list of animations
	 *                  
	 * @return The ArrayList of all the animations
	 */

	public static ArrayList<Animation> animate(SpriteSheet sheet, int sprites, GKObject.Direction[] directions, Animation... animations) {

	    int width = sheet.getWidth() / (sprites - 1);
	    int height = width;

		BufferedImage[] a = new BufferedImage[sprites - 1];
		BufferedImage[] b = new BufferedImage[sprites - 1];
		BufferedImage[] c = new BufferedImage[sprites - 1];
		BufferedImage[] d = new BufferedImage[sprites - 1];
		BufferedImage[] e = new BufferedImage[sprites - 1];

		e[0] = sheet.cut(0, 0, width, height);
        e[1] = sheet.cut(0, 0, width, height);
        e[2] = sheet.cut(0, 0, width, height);

        Animation IDLE = new Animation(e);

		ArrayList<Animation> anim = new ArrayList<>();

		for (int i = 0; i < (sprites - 1); i++) {
			if (animations.length > 4) {
				return null;
			}
			if (animations.length == 1) {
				a[i] = sheet.cut(i * width, 0, width, height);

				animations[0] = new Animation(a);
				animations[0].setDirection(directions[0]);
                IDLE.setDirection(directions[4]);
				anim.add(animations[0]);
				anim.add(IDLE);
			}
			if (animations.length == 2) {
				a[i] = sheet.cut(i * width, 0, width, height);
				b[i] = sheet.cut(i * width, height, width, height);

				animations[0] = new Animation(a);
				animations[1] = new Animation(b);
                animations[0].setDirection(directions[0]);
                animations[1].setDirection(directions[1]);
                IDLE.setDirection(directions[4]);

				anim.add(animations[0]);
				anim.add(animations[1]);
                anim.add(IDLE);
			}
			if (animations.length == 3) {
				a[i] = sheet.cut(i * width, 0, width, height);
				b[i] = sheet.cut(i * width,  height, width, height);
				c[i] = sheet.cut(i * width, 2 * height, width, height);

				animations[0] = new Animation(a);
				animations[1] = new Animation(b);
				animations[2] = new Animation(c);
                animations[0].setDirection(directions[0]);
                animations[1].setDirection(directions[1]);
                animations[2].setDirection(directions[2]);
                IDLE.setDirection(directions[4]);

				anim.add(animations[0]);
				anim.add(animations[1]);
				anim.add(animations[2]);

                anim.add(IDLE);
			}
			if (animations.length == 4) {
				a[i] = sheet.cut(i * width, 0, width, height);
				b[i] = sheet.cut(i * width, height, width, height);
				c[i] = sheet.cut(i * width, 2 * height, width, height);
				d[i] = sheet.cut(i * width, 3 * height, width, height);

				animations[0] = new Animation(a);
				animations[1] = new Animation(b);
				animations[2] = new Animation(c);
				animations[3] = new Animation(d);
                animations[0].setDirection(directions[0]);
                animations[1].setDirection(directions[1]);
                animations[2].setDirection(directions[2]);
                animations[3].setDirection(directions[3]);
                IDLE.setDirection(directions[4]);

				anim.add(animations[0]);
				anim.add(animations[1]);
				anim.add(animations[2]);
				anim.add(animations[3]);
                anim.add(IDLE);
			}
		}

		if (animations == null) {
			Content.print("[ANIMATION] Animation is NULL!");
			Content.print("[ANIMATION] Entity has no animation capability.");
		}
		return anim;
	}

	// Getters and Setters
	public int getFrame() {
		return frame;
	}

	public void setFrame(int frame) {
		this.frame = frame;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getDelay() {
		return delay;
	}

	public void setDelay(long delay) {
		this.delay = delay;
	}

	public long getElapsed() {
		return elapsed;
	}

	public void setElapsed(long elapsed) {
		this.elapsed = elapsed;
	}

	public boolean isPlayed() {
		return played;
	}

	public void setPlayed(boolean played) {
		this.played = played;
	}

}
