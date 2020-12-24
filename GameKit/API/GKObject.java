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

import java.awt.*;

public strictfp abstract class GKObject extends AbstractGame {
	
	// Useful Variables
	protected GameID id;
	protected double v0;
	protected double vF;
	protected Direction lastDir;
	protected double deltaV;
	protected float time;
	protected double mass;
	protected float velocity;


	// Entity
	protected Entity e;

	// Game Properties
	protected boolean alive = true;
	protected boolean jumping = false;
	protected boolean falling = false;
	protected boolean standing = false;
	protected boolean ducking = false;
	protected boolean attacking = false;
	protected boolean hurt = false;

	// RPG
	protected boolean usingSpell = false;
	protected boolean spellCaster = false;
	protected boolean useSword = false;
	protected boolean canDie = true;
	protected boolean overlord = false;
	protected boolean admin = false;
	protected boolean NPC = false;
	protected boolean hasUsedClassBypass = false;
	protected boolean undead = false;
	protected boolean hasDied = false;

	protected int npcType = 1;

	// Default
	protected final static int GENERAL_WIDTH = 64;
	protected final static int GENERAL_HEIGHT = 64;

	// Player Properties
	protected long health = 100;
	protected int MP = 100;
	protected float speed = 5.0F;
	protected long level = 1;
	protected long death = 0L;
	protected float xMove;
	protected float yMove;

	// Tile Properties
	protected static final int TILEWIDTH = 32, TILEHEIGHT = 32;
	protected int tileID;
	protected Texture tileTexture;

	// Handling Properties
	protected float x, y;
	protected int width, height;
	protected Rectangle bounds;

	protected GKObject() {
	}

	public enum Direction {
		UP, DOWN, LEFT, RIGHT, D_UP, D_DOWN, D_LEFT, D_RIGHT, NULL
	}

	/**
	 * All abstract voids here are for use when this class is extended.
	 */
	public abstract void update();

	/**
	 * Hurt a set number of entities with given damage.
	 * 
	 * @param dmg The number to hurt the entity
	 * @param entities The number of entities to hurt
	 */

	protected void hurt(int dmg, Entity... entities) {
		for (int i = 0; i < entities.length; i++) {
			health = entities[i].getHealth();
			health -= dmg;
		}
	}

	/**
	 * Checks if an object is equal to this object.
	 * 
	 * @param obj The object
	 * @return Whether object is equal to this one
	 */
	
	protected boolean equals(GKObject obj) {
		return (this == obj);
	}



	// Getters and Setters
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getVIntial() {
		return v0;
	}

	public void setVIntial(double v0) {
		this.v0 = v0;
	}

	public double getVFinal() {
		return vF;
	}

	public void setVFinal(double vF) {
		this.vF = vF;
	}

	public float getVelocity() {
		return velocity;
	}

	public void setVelocity(float velocity) {
		this.velocity = velocity;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	public float getTime() {
		return time;
	}

	public void setTime(float time) {
		this.time = time;
	}

	public double getChangeInVelocity() {
		return deltaV;
	}

	public void setChangeInVelocity(double deltaV) {
		this.deltaV = deltaV;
	}

	public float getXMove() {
		return xMove;
	}

	public void setXMove(float xMove) {
		this.xMove = xMove;
	}

	public float getYMove() {
		return yMove;
	}


	public void setYMove(float yMove) {
		this.yMove = yMove;
	}

	public GameID getID() {
		return id;
	}

	public void setID(GameID id) {
		this.id = id;
	}

	public boolean alive() {
		return alive;
	}

	public void alive(boolean alive) {
		this.alive = alive;
	}

	public long getDeath() {
		return death;
	}

	public void setDeath(long death) {
		this.death = death;
	}

	public long getHealth() {
		return health;
	}

	public void setHealth(long health) {
		this.health = health;
	}

	public boolean isJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

	public boolean isFalling() {
		return falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	public boolean isStanding() {
		return standing;
	}

	public void setStanding(boolean standing) {
		this.standing = standing;
	}

	public boolean isHurt() {
		return hurt;
	}

	public void setHurt(boolean hurt) {
		this.hurt = hurt;
	}

	public int getMP() {
		return MP;
	}

	public void setMP(int MP) {
		this.MP = MP;
	}

	public long getLevel() {
		return level;
	}

	public void setLevel(long level) {
		this.level = level;
	}

	public boolean isUsingSpell() {
		return usingSpell;
	}

	public void setUsingSpell(boolean usingSpell) {
		this.usingSpell = usingSpell;
	}

	public boolean isUsingSword() {
		return useSword;
	}

	public void setUsingSword(boolean useSword) {
		this.useSword = useSword;
	}

	public boolean canDie() {
		return canDie;
	}

	public void setCanDie(boolean canDie) {
		this.canDie = canDie;
	}

	public boolean isOverlord() {
		return overlord;
	}

	public void setOverlord(boolean overlord) {
		this.overlord = overlord;
	}

	public boolean isNPC() {
		return NPC;
	}

	public void setNPC(boolean NPC) {
		this.NPC = NPC;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isUndead() {
		return undead;
	}

	public void setUndead(boolean undead) {
		this.undead = undead;
	}

	public int getTileID() {
		return tileID;
	}

	public void setTileID(int tileID) {
		this.tileID = tileID;
	}

	public Texture getTileTexture() {
		return tileTexture;
	}

	public void setTileTexture(Texture tileTexture) {
		this.tileTexture = tileTexture;
	}

	public Entity getEntity() {
		return e;
	}

	public void setEntity(Entity e) {
        this.e = e;
    }
	
	public Rectangle getBounds() {
		bounds = new Rectangle((int) x, (int) y, width, height);
		return bounds;
	}

	public Rectangle getLeftBounds() {
		return new Rectangle((int) x, (int) y, 1, height);
	}

	public Rectangle getRightBounds() {
		return new Rectangle((int) x + width, (int) y, 1, height);
	}

	public Rectangle getTopBounds() {
		return new Rectangle((int) x, (int) y, width, 3);
	}

	public Rectangle getBottomBounds() {
		return new Rectangle((int) x, (int) y + height, width, 1);
	}

}