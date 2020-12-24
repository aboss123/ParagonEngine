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

package GameKit;

import GameKit.API.*;
import GameKit.API.CollisionType;

import java.awt.Rectangle;


/**
 * This is interface is to be used for {@link net.paragonengine.api.frameworks2D.physics.PhysicsEngine} for all
 * physics needs and purposes in terms of collision handling and other properties. This interface gives out
 * default properties that are needed for the PhysicsEngine and properties that will be used in the {@link GameGraph}
 * when creating different scenes for game play.
 *
 * @author Ashish Bailkeri
 */

public interface IPhysicsEngine {

    /**
     * This applies complete gravity that takes into account an entity's
     * direction and not a forceful pull down of an entity.
     *
     * @param e The {@link Entity} to apply gravity to
     */

    void applyTotalGravity(Entity e);

    /**
     * This forces a collision on an entity directly. This may be used in order
     * to apply lower stats to the entity for the level that is being created and
     * will apply a collision as a means to reduce damage heavily.
     *
     * @param type The {@link CollisionType} to be applied
     * @param e The {@link Entity} to apply the collision to
     */

    void forceCollision(World world, CollisionType type, Entity e, int[][] map, int row, int col);

    /**
     * This sets the bounding box.
     *
     * @param rectangle The Rectangle that represents the box
     */

    void setBoundingBox(Rectangle rectangle);

    /**
     * This spawns a certain number of entities to a specified {@link MapRegion}
     * and renders them directly there.
     *
     * @param entities The infinite number of entities that can be spawned
     */

    void spawnEntities(MapRegion region, Entity... entities);

    /**
     * This sets up a path finding sequence in the {@link AI} class to
     * be able to find the specific {@link Actor} and do a certain
     * action.
     *
     * @param actor The {@link Actor} to find
     */

    void aiPathFind(Actor actor);

    /**
     * Applies a {@link LightMap} to a specific {@link MapRegion}
     * and renders it directly.
     *
     * @param region The {@link MapRegion} region
     * @param lightMap The {@link LightMap} map
     */

    void applyLightMap(MapRegion region, LightMap lightMap);

    /**
     * Enables whether the {@link AI} should be enabled or not when
     * taking account physics properties.
     *
     * @param enable The boolean to check if the {@link AI} is enabled
     * @return Whether the {@link AI} is enabled or not
     */

    boolean enableAI(boolean enable);

    /**
     * Enables a {@link LightMap} to be taken account for when calculating
     * certain physics properties.
     *
     * @param enable The boolean to check if the {@link LightMap} is enabled or not
     * @return Whether the {@link LightMap} is enabled or not
     */

    boolean enableLightMap(boolean enable);

}
