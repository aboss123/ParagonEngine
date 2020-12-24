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

/**
 * This allows the user to be able to create a menu for their game and allows
 * for menu headings.
 * 
 * @author Ashish Bailkeri
 *
 */
public abstract class Menu extends AbstractGame {

	/**
	 * This integer will represent the state that the user is selecting the menu
	 * choice.
	 */

	protected int menuChoice = 0;

	/**
	 * This will be the title of the menu that is specified.
	 */

	private String menuTitle;

	/**
	 * The options of the menu.
	 */

	public String[] headings;

	/**
	 * This is the font that the user wants the title of their menu to be.
	 */

	private Font font;

	/**
	 * The background color of the menu.
	 */

	private Color background;

	/**
	 * The color that the title specified is.
	 */

	private Color titleColor;


	public Menu(Font font, String menuTitle, Color titleColor, Color background) {
		this.font = font;
		this.menuTitle = menuTitle;
		this.titleColor = titleColor;
		this.background  = background;
	}

	/**
	 * Draws the title and the background color of the menu.
	 * 
	 * @param renderer The graphics component
	 * @param yDifference The difference between Y from the center
	 */

	public void drawMain(Frost2D renderer, int yDifference) {

		renderer.fillRect(0, 0, getWindow().getWidth(), getWindow().getHeight(), Color.TRANSLUCENT);

		// Draw the title
		renderer.setFont(font, titleColor);
		renderer.drawString(menuTitle, yDifference);

	}

	/**
	 * Draws the string based on the array of headings.
	 * 
	 * @param renderer The graphics component
	 * @param index The index of the string in the array
	 * @param yDifference The difference in Y from the center
	 */

	public void drawHeadings(Frost2D renderer, int index, int yDifference) {
		
		renderer.setFont(font, null);

		if(index == menuChoice) {
			renderer.setColor(Color.RED);
		}
		else {
			renderer.setColor(titleColor);
		}

		renderer.drawString(headings[index], yDifference);
	}

	/**
	 * This is the proper input for the game menu.
	 */

	public void getMenuInput() {
		if(keys.space) {
			optionSelect();
		}
		if(keys.u) {
			menuChoice--;
			if(menuChoice == -1) {
				menuChoice = headings.length -1;
			}
		}
		if(keys.d) {
			menuChoice++;
			if(menuChoice == headings.length)
				menuChoice = 0;
		}
	}

	/**
	 * This method is what happens when an option is selected in the menu. This
	 * method should be overridden.
	 */

	public abstract void optionSelect();
}
