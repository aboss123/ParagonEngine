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

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet {
	private BufferedImage sheet;

	/**
	 * Loads in the sprite sheet.
	 * 
	 * @param sheet The image that is loaded in
	 */

	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}

	public SpriteSheet(String path) {
		try {
			this.sheet = ImageIO.read(getClass().getResourceAsStream(path));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Crops out a specific part of an image.
	 * 
	 * @param x      The x part that needs to be cut
	 * @param y      The y part that needs to be cut
	 * @param width  The width of the image
	 * @param height The height of the image
	 * @return The image that was cut
	 */

	public BufferedImage cut(int x, int y, int width, int height) {
		return sheet.getSubimage(x, y, width, height);
	}

	public int getWidth() {
		return sheet.getWidth();
	}

	public int getHeight() {
		return sheet.getHeight();
	}
}
