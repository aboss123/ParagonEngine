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
 * This is the enum that can represent the identification of a player when it is
 * being created.
 * 
 * @author Ashish Bailkeri
 *
 */

public enum PlayerID {
	/**
	 * (ROLE PLAYING GAME) Interactive fun game.
	 */

	RPG,

	/**
	 * Platformer is a game in which the player moves around on platforms and
	 * versus's enemies through levels.
	 */

	PLATFORMER,

	/**
	 * Scary 2D game.
	 */

	HORROR,

	/**
	 * Has a backstory to the game and many plot events.
	 */

	STORYLINE,

	/**
	 * A type of game which is every man for themselves with around 50-100 people
	 * playing per game.
	 */

	BATTLE_ROYALE,

	/**
	 * A game in which its maim objective is to shoot other objects or entities.
	 */

	SHOOTER,

	/**
	 * This is for entities that do not identify as a player.
	 */

	NULL;
}
