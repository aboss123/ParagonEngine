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

public class Tile extends GKObject {
	
	/**
	 * This represents a tile array of tiles that can be used.
	 */
	
	public static Tile[] gF2DTiles = new Tile[256];

	/**
	 * Default constructor.
	 */
	
	public Tile() {}

    /**
     * Checks if a tile is solid or not.
     */

	private boolean isSolid = false;


	/**
	 * This constructor applies texture to a tile and then
	 * gives it a tileID that will be used to identify the tile
	 * later on.
	 *
	 * @param tileTexture The texture of the tile
	 * @param tileID The identification of the tile
	 */

	public Tile(Texture tileTexture, int tileID, boolean isSolid) {
		this.tileTexture = tileTexture;
		this.tileID = tileID;
		this.isSolid = isSolid;

		gF2DTiles[tileID] = this;
	}


	/**
	 * Renders the tile to the screen.
	 * 
	 * @param renderer The graphics component
	 * @param x The X location of the tile
	 * @param y The Y location of the tile
	 */
	
	public void render(Frost2D renderer, int x, int y) {
        renderer.drawTile(tileTexture, x, y);
	}

	/**
	 * Checks if a tile is solid.
	 *
	 * @return
	 */

	protected boolean isSolid() {
		return isSolid;
	}


	/**
	 * This is the update method that stems from the JObject class
	 * but can overridden if needed to.
	 */
	
	public void update() {
		
	}

}
