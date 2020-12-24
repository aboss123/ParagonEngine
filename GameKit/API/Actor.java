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
 * Represents entities that can be represented as actors with motion 
 * and rendering.
 * @author Ashish Bailkeri
 *
 */

public abstract class Actor extends Entity {

    /**
     * An instance of the {@link PlayerID} because of player specific Actor
     * actions and commands.
     */

	private PlayerID pID;

	/**
	 * This constructor creates a new Actor.
	 *
	 * @param x The X position to spawn the Actor
	 * @param y The Y position to spawn the Actor
	 * @param pID The PlayerID that represents the Actor (PlayerID.NULL) is
	 * for Actors that are not players
	 */
	
	public Actor(float x, float y, PlayerID pID) {
		super(x, y, GENERAL_WIDTH, GENERAL_HEIGHT, GameID.PLAYER, pID);

		this.pID = pID;
		this.x = x;
		this.y = y;
	}

	/**
	 * This renders the actor with the constructors given height and with
	 * that is specified.
	 * 
	 * @param renderer The graphics component
	 */
	
	protected void renderActor(Frost2D renderer) {
		renderer.renderEntity(getCurrentAnimationFrame(), this);
	}
	
	/**
	 * This renders the actor with scalability by giving the width and height 
	 * of the character specifically.
	 * 
	 * @param renderer The graphics component
	 * @param w The width to scale
	 * @param h The height to scale
	 */

	public void renderActor(Frost2D renderer, int w, int h) {
		renderer.draw(getCurrentAnimationFrame(), (int) x, (int) y, w, h);
	}

    /**
     * This renders the animations that are retrieved from the array list of animations.
     *
     * @param renderer The graphics component
     * @param animations The {@link Animation} array list to render
     */

	public void renderActor(Frost2D renderer, ArrayList<Animation> animations) {
	    if(xMove < 0)
	        renderer.playAnimation(animations.get(animations.size() - (animations.size() - 1)), this);
	    else if(xMove > 0)
	        renderer.playAnimation(animations.get(animations.size() - (animations.size() - 2)), this);
	    else if(yMove < 0)
	        renderer.playAnimation(animations.get(animations.size() - (animations.size() - 3)), this);
	    else if(yMove > 0)
	        renderer.playAnimation(animations.get(animations.size() - (animations.size() - 4)), this);
	    else
	        renderer.playAnimation(animations.get(animations.size() - (animations.size() - 5)), this);
    }

    /**
     * This animates the player completely but is highly specific to the details
     * listed below:
     *      1. For RPG the order for animations MUST be:
     *          a. Left
     *          b. Right
     *          c. Up
     *          d. Down
     *          e. Idle
     *      2. For PLATFORMER the order for animations MUST be:
     *          a. Left
     *          b. Right
     *          c. Idle
     *      3. The DEFAULT is the same as the RPG setup
     *
     * @param renderer The graphics component
     * @param animations The {@link Animation}'s that will be played
     */

	protected void renderActor(Frost2D renderer, Animation ... animations) {

	    if(animations.length > 5) {
	        Content.print("[ANIMATION] Cannot animate with correct direction with greater than 5 animation order");
        }

	    switch(pID) {

	        default:
                if(xMove < 0) {
                    renderer.playAnimation(animations[0], this);
                    break;
                }
                else if(xMove > 0) {
                    renderer.playAnimation(animations[1], this);
                    break;
                }
                else if(yMove < 0) {
                    renderer.playAnimation(animations[2], this);
                    break;
                }
                else if(yMove > 0) {
                    renderer.playAnimation(animations[3], this);
                    break;
                }
                else {
                    renderer.playAnimation(animations[4], this);
                    break;
                }
            case PLATFORMER:
                if(xMove < 0) {
                    renderer.playAnimation(animations[0], this);
                    break;
                }
                else if(xMove > 0) {
                    renderer.playAnimation(animations[1], this);
                    break;
                }
                else {
                    renderer.playAnimation(animations[2], this);
                    break;
                }
            case RPG:
                if(xMove < 0) {
                    renderer.playAnimation(animations[0], this);
                    break;
                }
                else if(xMove > 0) {
                    renderer.playAnimation(animations[1], this);
                    break;
                }
                else if(yMove < 0) {
                    renderer.playAnimation(animations[2], this);
                    break;
                }
                else if(yMove > 0) {
                    renderer.playAnimation(animations[3], this);
                    break;
                }
                else {
                    renderer.playAnimation(animations[4], this);
                    break;
                }
            case NULL:
                break;
        }

    }


	/**
	 * This method is specifically made for player input
	 * in a given direction. This method can be overridden.
	 */
	
	private void getPlayerInput() {
		xMove = 0;
		yMove = 0;

		switch(pID) {

            default:
                break;
            case RPG:
                if (AbstractGame.keys.up) {
                    GKPhysics.accelerateEntity(this, speed, Direction.UP);
                    break;
                }
                if (AbstractGame.keys.down) {
                    GKPhysics.accelerateEntity(this, speed, Direction.DOWN);
                    break;
                }
                if (AbstractGame.keys.left) {
                    GKPhysics.accelerateEntity(this, speed, Direction.LEFT);
                    break;
                }
                if (AbstractGame.keys.right) {
                    GKPhysics.accelerateEntity(this, speed, Direction.RIGHT);
                    break;
                }
            case SHOOTER:
                if (AbstractGame.keys.up) {
                    GKPhysics.accelerateEntity(this, speed, Direction.UP);
                    break;
                }
                if (AbstractGame.keys.down) {
                    GKPhysics.accelerateEntity(this, speed, Direction.DOWN);
                    break;
                }
                if (AbstractGame.keys.left) {
                    GKPhysics.accelerateEntity(this, speed, Direction.LEFT);
                    break;
                }
                if (AbstractGame.keys.right) {
                    GKPhysics.accelerateEntity(this, speed, Direction.RIGHT);
                    break;
                }
            case PLATFORMER:
                if (AbstractGame.keys.left) {
                    GKPhysics.accelerateEntity(this, speed, Direction.LEFT);
                    break;
                }
                if (AbstractGame.keys.right) {
                    GKPhysics.accelerateEntity(this, speed, Direction.RIGHT);
                    break;
                }
            case NULL:
                break;
        }
	}

	/**
	 * Updates everything for the player.
	 */
	
	public void update(Actor actor) {
		updateAnimations();
		getPlayerInput();
		move();
		AbstractGame.getCamera().centerOnPlayer(actor);
	}


	/**
	 * This method will be used to update the animations of the
	 * specified actor.
	 */
	
	protected void updateAnimations() {}

	/**
	 * This method will be used to determine the current animation frame
	 * of the actor in its position.
	 * 
	 * @return The BufferedImage that represents the current animation that they are executing
	 */
	
	protected BufferedImage getCurrentAnimationFrame() {
		return null;
	}

}
