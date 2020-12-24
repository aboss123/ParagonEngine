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

public class World implements Map {

    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;

    public World(String path) {
        loadWorld(path);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Frost2D renderer) {
        int xRenderStart = (int) Math.max(0, AbstractGame.getCamera().getXTransfer() / 32);
        int xRenderEnd = (int) Math.min(width, (AbstractGame.getCamera().getXTransfer() + AbstractGame.getWindow().getWidth()) / 32 + 1);
        int yRenderStart = (int) Math.max(0, AbstractGame.getCamera().getYTransfer() / 32);
        int yRenderEnd = (int) Math.min(height, (AbstractGame.getCamera().getYTransfer() + AbstractGame.getWindow().getHeight()) / 32+ 1);

        for(int y = yRenderStart; y < yRenderEnd; y++){
            for(int x = xRenderStart; x < xRenderEnd; x++){
                getTile(x, y).render(renderer, (int) (x * 32 - AbstractGame.getCamera().getXTransfer()),
                        (int) (y * 32 - AbstractGame.getCamera().getYTransfer()));
            }
        }
    }

    public Tile getTile(int x, int y)
    {
        if(x < 0 || y < 0 || x >= width || y >= height)
            return TileManager.defaultTile;
        Tile t = Tile.gF2DTiles[tiles[x][y]];
        if(t == null)
            return TileManager.defaultTile;

        return t;
    }

    // Load World through text
    private void loadWorld(String path) {
        String file = Content.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Content.parseInt(tokens[0]);
        height = Content.parseInt(tokens[1]);
        spawnX = Content.parseInt(tokens[2]);
        spawnY = Content.parseInt(tokens[3]);

        tiles = new int[width][height];
        for(int y = 0;y < height;y++){
            for(int x = 0;x < width;x++){
                tiles[x][y] = Content.parseInt(tokens[(x + y * width) + 4]);
            }
        }
    }

    public int[][] getMap() {
        return tiles;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getSpawnX() {
        return spawnX;
    }

    public int getSpawnY() {
        return spawnY;
    }
}
