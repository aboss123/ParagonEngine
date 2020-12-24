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
 * This class creates regions within the {@link Map} to be able to
 * spawn entities and other useful things that can be used with this
 * class properly in order to add things to the Scene.
 */

public class MapRegion {

    int x, y, width, height;
    private int scale, scaleX, scaleY, scaleWidth, scaleHeight;

    /**
     * This creates a new MapRegion that uses the given world and
     * scale to create it and assign properties.
     *
     * @param world The {@link World} to use
     * @param scale The scale to create the region
     */

    public MapRegion(World world, int scale) {
        this.scale = scale;
        x = world.getSpawnX() + scale;
        y = world.getSpawnY() + scale;
        width = world.getWidth() / scale;
        height = world.getHeight() / scale;
    }

    /**
     * Creates a MapRegion with more scalability properties to make the
     * region more specific.
     *
     * @param world The {@link World} that is used for scaling
     * @param scaleX The value to scale the X value
     * @param scaleY The value to scale the Y value
     * @param scaleWidth The value to scale the width
     * @param scaleHeight The value to scale the height
     */

    public MapRegion(World world, int scaleX, int scaleY, int scaleWidth, int scaleHeight) {
        this.scaleX = scaleX;
        this.scaleY = scaleY;
        this.scaleWidth = scaleWidth;
        this.scaleHeight = scaleHeight;
        x = world.getSpawnX() + scaleX;
        y = world.getSpawnY() + scaleY;
        width = world.getWidth() / scaleWidth;
        height = world.getHeight() / scaleHeight;
    }

    /**
     * This directly sets the values of the MapRegion.
     *
     * @param x The value to assign X to
     * @param y The value to assign Y to
     * @param width The value to assign the width
     * @param height The value to assign the height
     */


    public MapRegion(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }


    /** @return The width of the MapRegion */

    public int getWidth() {
        return width;
    }

    /** Sets the width */

    public void setWidth(int width) {
        this.width = width;
    }

    /** @return The height of the MapRegion*/

    public int getHeight() {
        return height;
    }

    /** Sets the height */

    public void setHeight(int height) {
        this.height = height;
    }

    /** Gets the X of the MapRegion */

    public int getX() {
        return x;
    }

    /** Sets the X */

    public void setX(int x) {
        this.x = x;
    }

    /** @return The Y of the MapRegion*/

    public int getY() {
        return y;
    }

    /** Sets the Y*/

    public void setY(int y) {
        this.y = y;
    }
}
