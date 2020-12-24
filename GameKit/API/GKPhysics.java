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

import net.paragonengine.api.ParagonException;

/**
 * Handles all the Physics components of a 2D Game and includes useful commands
 * dealing with entities and other things.
 * 
 * @author Ashish Bailkeri
 *
 */

public strictfp class GKPhysics extends App2D {
	
	// These are the main boolean directions for Actors.
	public static boolean UP;
	public static boolean DOWN;
	public static boolean LEFT;
	public static boolean RIGHT;
	
	/**
	 * Default constructor
	 */

	public GKPhysics() {}


    /**
     * Apply the collision to a given entity
     *
     * @param type The Collision type
     * @param e The entity to give the collision to
     */

	public void applyCollision(CollisionType type, Entity e) {
		if(type.equals(CollisionType.REST_TO_MOTION))
		    hurt(5, e);
        if(type.equals(CollisionType.EXPLOSIVE))
            hurt(25, e);
        if(type.equals(CollisionType.HEAD_ON))
            hurt(15, e);
        if(type.equals(CollisionType.DOMINO))
            hurt(50, e);
        if(type.equals(CollisionType.SAME_FORCE))
            hurt(10, e);
	}

	/**
	 * Find the change in velocity for an object.
	 * 
	 * @param v0 The initial velocity
	 * @param vF The final velocity
	 * @return The change in velocity
	 */

	public static double getChangeInVelocity(float v0, float vF) {
		return vF - v0;
	}

	/**
	 * Find the acceleration of an object.
	 * 
	 * @param deltaV Change in Velocity
	 * @param time   The time
	 * @return The acceleration
	 */

	public static double getAcceleration(double deltaV, float time) {
		double a = deltaV / time;

		if (deltaV == 0 || time == 0) {
			try {
				throw new ParagonException("The values cannot be 0!");
			} catch (ParagonException e) {
				e.printStackTrace();
			}
		}

		return a;
	}

	/**
	 * This is accelerates the given entity in a specific direction.
	 * 
	 * @param e     The Entity
	 * @param speed The speed to move the entity
	 * @param d     The direction to move the entity
	 */

	public static void accelerateEntity(Entity e, float speed, Direction d) {
		switch (d) {
		case UP:
			e.setYMove(-speed);
			UP = true;
			break;
		case DOWN:
			e.setYMove(speed);
			DOWN = true;
			break;
		case LEFT:
			e.setXMove(-speed);
			LEFT = true;
			break;
		case RIGHT:
			e.setXMove(speed);
			RIGHT = true;
			break;
		}
	}

	/**
	 * Gets the momentum of an object.
	 * 
	 * @param mass     The mass of the object
	 * @param velocity The speed of the object
	 * @return p The calculated momentum
	 */

	public static double getMomentum(double mass, float velocity) throws ParagonException {
		double p = mass * velocity;

		if (mass == 0 || velocity == 0) {
			throw new ParagonException("The values cannot be 0!");
		}

		return p;
	}

}
