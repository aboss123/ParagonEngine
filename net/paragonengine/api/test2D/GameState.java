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

package net.paragonengine.api.test2D;

import GameKit.API.*;

public class GameState extends StateObject {

    private Player player;
    private World world;

    public GameState() {
        player = new Player(200, 200);
        world = new World(
                "/Users/kelsa/Desktop/JavaPrograms/ParagonEngine/src/net/paragonengine/api/test2D/map.txt");
        AbstractGame.setWorld(world);
    }

    @Override
    public void update() {
        updateMap(world);
        updateEntities(player);

        // Escape to the menu
        if(keys.escape) {
            StateObject.setState(new MenuState());
        }

    }

    @Override
    public void render(Frost2D renderer) {
        loadMap(renderer, world);
        loadEntities(renderer, player);
    }


}
