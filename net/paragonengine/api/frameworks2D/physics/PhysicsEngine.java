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

package net.paragonengine.api.frameworks2D.physics;

import GameKit.API.*;
import GameKit.IPhysicsEngine;

import java.awt.Rectangle;

/**
 * This class handles all Physics problems and needs. It utilizes classes
 * such as the {@link GKPhysics} class to handle Actor and entity movement properly
 * and will use {@link Projectile} for handling static entity collision. It combines everything
 * within this package in order to create usage within the engine.
 */

public class PhysicsEngine implements IPhysicsEngine {

    public static void init() {

    }

    @Override
    public void applyTotalGravity(Entity e) {
        Gravity.advancedGravity(e);
    }

    @Override
    public void forceCollision(World world, CollisionType type, Entity e, int[][] map, int row, int col) {
        e.setX((float) row);
        e.setY((float) col);
        GKPhysics physics = new GKPhysics();
        physics.applyCollision(type, e);
    }

    @Override
    public void setBoundingBox(Rectangle rectangle) {

    }

    @Override
    public void spawnEntities(MapRegion region, Entity... entities) {

    }

    @Override
    public void aiPathFind(Actor actor) {

    }


    @Override
    public void applyLightMap(MapRegion region, LightMap lightMap) {

    }

    @Override
    public boolean enableAI(boolean enable) {
        return false;
    }

    @Override
    public boolean enableLightMap(boolean enable) {
        return false;
    }
}
