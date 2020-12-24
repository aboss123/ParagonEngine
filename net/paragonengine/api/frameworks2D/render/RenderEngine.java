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

package net.paragonengine.api.frameworks2D.render;

import GameKit.API.*;
import GameKit.IRenderEngine;
import GameKit.RenderObject;

/**
 * Handles everything that is needed for rendering and will be
 * able to render everything for the engine and the LGF (LEGEND GAME FRAMEWORK).
 * All the classes in this package will be used to create universal rendering for all things
 * that are related to 2D Objects.
 */

public class RenderEngine implements IRenderEngine {

    public static void init() {

    }

    @Override
    public void renderObject(Frost2D renderer, RenderObject obj) {

    }


    @Override
    public void renderObject(Frost2D renderer, UIObject obj) {

    }

    @Override
    public void renderEntity(Frost2D renderer, Entity e) {

    }

    @Override
    public void renderMap(Frost2D renderer, Map map) {

    }

    @Override
    public void renderUI(Frost2D renderer, UI ui) {

    }

    @Override
    public void renderGUI(Frost2D renderer, GUI gui) {

    }

    @Override
    public void renderButton(Frost2D renderer, Button button) {

    }

    @Override
    public void renderGrid(Frost2D renderer, Grid grid) {

    }

    @Override
    public void renderScene(Frost2D renderer, GameGraph scene) {

    }
}
