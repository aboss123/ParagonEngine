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

package net.paragonengine.core;

import net.paragonengine.api.frameworks2D.physics.PhysicsEngine;
import net.paragonengine.api.frameworks2D.render.RenderEngine;
import GameKit.API.GameGraph;
import GameKit.API.UI;
import GameKit.Resources;

/**
 * Configures everything for the engine in order for the main windows and execution
 * are all done correctly so that the GameKit can invoke and use it for what the user
 * will be able to see completely. {@link PhysicsEngine} wil be used for visually
 * seeing things happen in the editor after the {@link GameGraph} is properly run through the
 * editor. The {@link RenderEngine} is used for rendering all types of things properly and
 * will most likely be run on a different thread still using the main AbstractGame file in order to
 * execute things in a timely manner. It would be used to render everything in the {@link Resources}
 * for the main {@link UI} and everything else.
 *
 * @author Ashish Bailkeri
 * @version 0.0.4
 */

public class Config {

    /**
     * Initializes all the other engines within the AbstractGame Main Engine
     * and will execute all other necessary things that will be needed
     * to initialize other aspects of the engine that necessary to the
     * development of the GameKit for map editing.
     */

    public static void init() {
        PhysicsEngine.init();
        RenderEngine.init();
    }

}
