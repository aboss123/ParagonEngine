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

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TileManager {

    public static ArrayList<Tile> tiles = new ArrayList<>();

    private static SpriteSheet sheet = new SpriteSheet("/tiles/sky.png");
    private static BufferedImage defTile = sheet.cut(0, 0, 32, 32);

    public static Texture daTile = new Texture(defTile);
	public static Tile defaultTile = new Tile(daTile, 0, false);


    /**
     * Gets a {@link Tile} at a specific position in the array list
     *
     * @param position The position that contains the tile
     * @return The {@link Tile} that is is the specified position in the array list
     */

	public static Tile getTile(int position) {
	    return tiles.get(position);
    }


    /**
     * Adds a {@link Tile} to the array list of tiles.
     *
     * @param tile The {@link Tile} to add
     */

	public static void addTile(Tile tile) {
	    tiles.add(tile);
    }


    /**
     * Sets a {@link Tile} to a position in the array list.
     *
     * @param tile The {@link Tile} to set
     * @param position The position to set the tile in the array list
     */

    public static void setTile(Tile tile, int position) {
	    tiles.set(position, tile);
    }

}
