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

public class Event {

	/**
	 * This constructor will register a new event that will be able to do the
	 * multiple functions under this constructor.
	 * 
	 * @param type This is the the type of event that will be created when the
	 *             constructor is completed.
	 */

	public Event(EventType type) {
		switch (type) {
		case GAME_EVENT:
			Content.print("[EVENT] Game Event Registered");
			break;
		case OBJECT_EVENT:
			Content.print("[EVENT] New Object Event");
			break;
		case ENTITY_EVENT:
			Content.print("[EVENT] New Entity Event");
			break;
		case CUSTOM_EVENT:
			Content.print("[EVENT] Custom Event Registered");
			break;
		default:
			break;
		}
	}

	/**
	 * Default constructor
	 */
	public Event() {
	}

	/**
	 * This will run the current event that uses this method and this method should
	 * be overridden.
	 */

	public void runEvent() {

	}

	/**
	 * This will push the event through the EventPusher and have the event get
	 * executed later on. This method should also be overridden.
	 */

	public void pushEvent() {

	}

	/**
	 * This will draw the event (this method is only needed for those type of
	 * events) and display the event to the screen. This method should be overridden
	 * and used when needed.
	 */

	public void drawEvent(Graphics2D g) {

	}
}
