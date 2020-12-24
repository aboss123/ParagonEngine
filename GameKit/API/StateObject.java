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

import java.util.ArrayList;

public abstract class StateObject extends GKObject {
	/**
	 * The state in which the game is on its menu.
	 */
	protected static final int MENU = 0;

	/**
	 * This state is when the game is being played.
	 */

	protected static final int PLAY = 1;

	/**
	 * This state is when the game is being paused.
	 */

	protected static final int PAUSED = 2;

	/**
	 * This state is when the game is being resumed.
	 */

	protected static final int RESUME = 3;

	/**
	 * This state is when the game is loading.
	 */

	protected static final int LOADING = 4;

	/**
	 * This state is when the game is saving.
	 */

	protected static final int SAVING = 5;

	/**
	 * This is the situation of when a certain state is finished or not to be able
	 * to move on to the next state.
	 */

	protected static boolean isFinished = false;

	/**
	 * This represents the Current State that the game is in.
	 */

	private static StateObject currentState = null;

	/**
	 * This is the special ArrayList that contains all the states.
	 */

	private static ArrayList<StateObject> states = new ArrayList<>();


	public StateObject() {}

	/**
	 * Sets the current state to the given state.
	 * 
	 * @param state The state to set
	 */

	public static void setState(StateObject state) {
		currentState = state;
		camera = new GameCamera(0, 0);
		Content.print("Paragon | Switched State");
	}

	/**
	 * Add a state to the array list.
	 * 
	 * @param state The state to add
	 */

	public void addState(StateObject state) {
		states.add(state);
	}

	/**
	 * Get the list of all the states added to the array list.
	 * 
	 * @return The list of states
	 */

	public static ArrayList<StateObject> getStates() {
		return states;
	}

	/**
	 * Get a state from the array list of states.
	 * 
	 * @param index The index of the state object
	 * @return The state from the given index
	 */

	public static StateObject getState(int index) {
		return states.get(index);
	}

	/**
	 * Get the current state.
	 * 
	 * @return currentState The current state
	 */

	public static StateObject getCurrentState() {
		return currentState;
	}

	/**
	 * Load a set of entities that are given. Renders the set of entities.
	 * 
	 * @param renderer Graphics Parameter
	 * @param e Entity[] Parameter
	 */

	public void loadEntities(Frost2D renderer, Entity... e) {
		for (int i = 0; i < e.length; i++) {
			e[i].render(renderer);
		}
	}

	/**
	 * Loads a set of Maps that are needed for the game.
	 * 
	 * @param renderer Graphics Parameter
	 * @param m Map[] Parameter
	 */

	public void loadMap(Frost2D renderer, Map... m) {
		for (int i = 0; i < m.length; i++) {
			m[i].render(renderer);
		}
	}

	/**
	 * Creatively update an infinite number of entities.
	 * 
	 * @param e Entity[] Parameter
	 */

	public void updateEntities(Entity... e) {
		for (int i = 0; i < e.length; i++) {
			e[i].update();
		}
	}

	/**
	 * Update all activities with a(n) Map(s)
	 * 
	 * @param m Map[] Parameter
	 */

	public void updateMap(Map... m) {
		for (int i = 0; i < m.length; i++) {
			m[i].update();
		}
	}

	/**
	 * Abstracts
	 */
	public abstract void render(Frost2D renderer);
}
