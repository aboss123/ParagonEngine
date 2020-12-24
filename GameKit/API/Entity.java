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

import java.awt.Rectangle;

/**
 * This class represents abstract entities that use the JObject directly and
 * this class will be used when creating new entities or other entity support
 * classes.
 * 
 * @author Ashish Bailkeri
 *
 */
public abstract class Entity extends GKObject {


    /**
     * Checks whether the entity is moving or not.
     */

	public boolean isMoving = false;

	/**
	 * This constructor is the construct for an entity and what properties an entity
	 * has.
	 *
	 * @param x      This is the X of where the entity will be spawned
	 * @param y      This is the Y of where the entity will be spawned
	 * @param width  This is the width of the entity
	 * @param height The is is the height of the entity
	 * @param id     The GameID property of the entity
	 * @param pID    The PlayedID property of the entity
	 */

	public Entity(float x, float y, int width, int height, GameID id, PlayerID pID) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.id = id;

		xMove = 0;
		yMove = 0;

		// Case for every entity
		switch (id) {
		case PLAYER:
			alive = true;
			break;
		case PARTICLE:
			alive = false;
			canDie = false;
			break;
		case TRAIL:
			alive = false;
			canDie = false;
			break;
		case ENEMY:
			alive = true;
			useSword = true;
			attacking = true;
			break;
		case WALL:
			alive = false;
			canDie = false;
			break;
		case OBSTACLE:
			alive = false;
			canDie = false;
			break;
		case UniversalObj:
			alive = false;
			canDie = false;
		case WEAPON:
			alive = false;
			canDie = false;
		case NPC:
			alive = false;
			if (npcType == 1)
				spellCaster = true;
			if (npcType == 2)
				useSword = true;
			if (npcType == 3)
				undead = true;
			alive = false;
			canDie = false;
			canDie = true;
			break;
		case POWERUP:
			alive = false;
			canDie = false;
			break;
		case BLOCK:
			alive = false;
			canDie = false;
			break;
		case NULL:
			alive = false;
			canDie = false;
			break;
		case PROJECTILE:
			alive = false;
			canDie = false;
			break;
		case BOSS:
			health = 1000;
			MP = 1000;
			speed = 1.0f;
			alive = true;
			canDie = true;
			break;
		case FINALBOSS:
			health = 10000;
			MP = 1000;
			speed = 0.5f;
			alive = true;
			canDie = true;
			break;
		case OVERLORD:
			alive = true;
			canDie = false;
			admin = true;
			spellCaster = true;
			overlord = true;
			break;
		default:
			break;

		}
		bounds = new Rectangle(0, 0, width, height);
	}

	/**
	 * Checks what direction the entity is facing.
	 *
	 * @param dir The direction to check that they are facing
	 * @return Whether the entity is facing in that direction
	 */

	public boolean isFacing(Direction dir) {
		if(dir == Direction.UP) {
			if(GKPhysics.UP) {
			    isMoving = true;
                return true;
            }
		}
		else if(dir == Direction.DOWN) {
			if(GKPhysics.DOWN) {
			    isMoving = true;
                return true;
            }
		}
		else if(dir == Direction.LEFT) {
			if(GKPhysics.LEFT) {
			    isMoving = true;
                return true;
            }
		}
		else if(dir == Direction.RIGHT) {
			if(GKPhysics.RIGHT) {
			    isMoving = true;
                return true;
            }
		}
		else {
			return false;
		}

		return false;
	}


    /**
     * Checks for a collision with a tile.
     *
     * @param x The coordinate of X
     * @param y The coordinate of Y
     * @return The boolean whether the tile is solid
     */

    public boolean collisionWithTile(int x, int y) {
        return AbstractGame.getWorld().getTile(x, y).isSolid();
    }

//
//    public void move(){
//        x += xMove;
//        y += yMove;
//    }

	/**
	 * Rotations for moving X.
	 */

	// e.getPosition().

	public void moveX() {
		// Moves Right

		if (xMove > 0) {
			int tx = (int) (x + xMove + bounds.x + bounds.width) / TILEWIDTH;

			if (!collisionWithTile(tx, (int) (y + bounds.y) / TILEHEIGHT)
					&& !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / TILEHEIGHT)) {
				x += xMove;
			} else {
				x = tx * TILEHEIGHT - bounds.x - bounds.width - 1;
			}
		}

		// Moving right

		else if (xMove < 0) {
			int tx = (int) (x + xMove + bounds.x) / TILEWIDTH;

			if (!collisionWithTile(tx, (int) (y + bounds.y) / TILEHEIGHT)
					&& !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / TILEHEIGHT)) {
				x += xMove;
			} else {
				x = tx * TILEWIDTH + TILEWIDTH - bounds.x;
			}
		}
	}

	/**
	 * Rotations for moving Y.
	 */

	public void moveY() {
		// Moving Up

		if (yMove < 0) {
			int ty = (int) (y + yMove + bounds.y) / TILEHEIGHT;

			if (!collisionWithTile((int) (x + bounds.x) / TILEWIDTH, ty)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width) / TILEWIDTH, ty)) {
				y += yMove;
			} else {
				y = ty * TILEHEIGHT + TILEHEIGHT - bounds.y;
			}
		}

		// Moving down

		else if (yMove > 0) {
			int ty = (int) (y + yMove + bounds.y + bounds.height) / TILEHEIGHT;

			if (!collisionWithTile((int) (x + bounds.x) / TILEWIDTH, ty)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width) / TILEWIDTH, ty)) {
				y += yMove;
			} else {
				y = ty * TILEHEIGHT - bounds.y - bounds.height - 1;
			}
		}
	}

	/**
	 * Moving on both axis'.
	 */

	protected void move() {
		moveX();
		moveY();
	}

	/**
	 * Default Entity constructor.
	 */
	public Entity() {
	}

	/**
	 * Renders the entity to the screen.
	 * 
	 * @param renderer The graphics component
	 * @return
	 */

	public abstract Entity render(Frost2D renderer);

}
