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

public class EventQueue {
	/**
	 * This is the variable that events in the queue will be added to and removed
	 * according to when they are executed and if they need to be run for a certain
	 * amount of time.
	 */

	public static ArrayList<Event> events = new ArrayList<Event>();


	/**
	 * This initializes the EventQueue. This class needs to be initialized in order
	 * to push events and to not push events.
	 * 
	 * @param enable This variable determines whether this queue is enabled or not
	 *               enabled. If this is not enabled, event pushing and anything
	 *               related to any game events will not work.
	 */

	public static void init(boolean enable) {
		if (enable)
			Content.print("[EVENT] EventQueue Enabled!");
		else
			Content.print("[EVENT] EventQueue Disabled!");

		// TODO: Add other important initializing things
	}

	/**
	 * This method will queue an event to the array list of events that need to be
	 * executed and they will be added and removed accordingly.
	 * 
	 * @param e This is the event that is given to be queued by the EventQueuer.
	 */

	public static void queueEvent(Event e) {
		events.add(e);
	}

	/**
	 * This method will remove an event from the array list of events that have been
	 * queued up. This will happen when the event has been executed or the actions
	 * for the event have been done.
	 * 
	 * @param e This is the event that will be removed from the queue to allow other
	 *          events execute.
	 */

	public static void removeEventFromQueue(Event e) {
		events.remove(e);
	}

}
