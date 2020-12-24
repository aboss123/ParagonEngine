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

public enum GameID {
	/**
	 * ID for player information and other useful information.
	 */
	PLAYER,

	/**
	 * Any type of effect that can occur in the world created by the user.
	 */
	PARTICLE,

	/**
	 * Trail of particles (most of the time)
	 */
	TRAIL,

	/**
	 * Any opposing entity to the main character of the game.
	 */
	ENEMY,

	/**
	 * Usually a(n) tile(s) that are an obstruction to more than one entity.
	 */
	WALL,

	/**
	 * Something that blocks any entity from doing something within the game
	 */
	OBSTACLE,

	/**
	 * Type of abilities that can be used throughout the users choosing of their
	 * player(s).
	 */
	UniversalObj,

	/**
	 * Any being that is in the game.
	 */
	ENTITY,

	/**
	 * Any type of tool used to harm others.
	 */
	WEAPON,

	/**
	 * Non-Playing-Character who is there for story-line purposes or by other means.
	 */
	NPC,

	/**
	 * Used to upgrade a current status of an entity.
	 */
	POWERUP,

	/**
	 * Commonly known as a tile but makes up the map of a game.
	 */
	BLOCK,

	/**
	 * Something that is not determined.
	 */
	NULL,

	/**
	 * Used to navigate the game in its perspective.
	 */
	CAMERA,

	/**
	 * Level area with terrain in a game
	 */

	MAP,

	/**
	 * An object sent our by enemies or the player in order to hurt other from a
	 * weapon.
	 */

	PROJECTILE,

	/**
	 * Usually a powerful entity within an RPG story-line.
	 */
	BOSS,

	/**
	 * The final entity in an RPG game in which the main player has to to defeat.
	 */
	FINALBOSS,

	/**
	 * The supreme being entity in which the player can become.
	 */

	OVERLORD,

	/**
	 * The result of using the map creation tool.
	 */

	LEVEL
}
