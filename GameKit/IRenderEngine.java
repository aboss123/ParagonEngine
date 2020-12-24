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


/**
 * This is the interface that is used for {@link net.paragonengine.api.frameworks2D.render.RenderEngine} class
 * to be able to execute functions later on. This class requires multiple different ways of rendering and proper
 * rendering use to be executed. The RenderEngine is very important for the editor because of the many important
 * things that it brings to help render objects and entities on demand to the screen as fast as possible for
 * better use.
 *
 * @author Ashish Bailkeri
 */

public interface IRenderEngine {

    /**
     * Renders an object that is a representative type of {@link RenderObject} that is
     * specific type that only requires rendering. An object of that type will be directly
     * linked to that type and will be able to rendered from anywhere with creating an instance of it.
     *
     * @param renderer The graphics component
     * @param obj The {@link RenderObject} that will be rendered
     */

    void renderObject(Frost2D renderer, RenderObject obj);

    /**
     * Renders an object that is a representative type of {@link UIObject} and
     * it will be used when any part of a specific UI {@link GUI} is being rendered
     * and it would be a specific UIObject that is managed from the {@link UIManager}
     *
     * @param renderer The graphics component
     * @param obj The {@link UIObject} that will be rendered
     */

    void renderObject(Frost2D renderer, UIObject obj);


    /**
     * Renders a specific {@link Entity} to the screen (BROAD) and will
     * be used for all other entities except static entities to be rendered to
     * the screen.
     *
     * @param renderer The graphics component
     * @param e The {@link Entity} that will be rendered
     */

    void renderEntity(Frost2D renderer, Entity e);

    /**
     * Renders a specific {@link Map} to the screen and will be used
     * for generating and creating maps on the {@link GameGraph} to be able
     * to be quickly rendered.
     *
     * @param renderer The graphics component
     * @param map The {@link Map} that will be rendered
     */

    void renderMap(Frost2D renderer, Map map);

    /**
     * Renders a specific {@link UI} to the screen and will be used broadly
     * for all non specific UI's to be rendered that are not apart of the
     * {@link GUI} class.
     *
     * @param renderer The graphics component
     * @param ui The {@link UI} that will be rendered
     */

    void renderUI(Frost2D renderer, UI ui);

    /**
     * Renders a specific {@link GUI} to the screen and will be used
     * for all UI's that are specific and graphical that require advanced
     * rendering.
     *
     * @param renderer The graphics component
     * @param gui The {@link GUI} that will be rendered
     */

    void renderGUI(Frost2D renderer, GUI gui);

    /**
     * Renders a specific {@link Button} to the screen and will be apart of the
     * main editor's {@link GUI} and it will be an easier way to render buttons
     * to the editor directly and goes through the pain of making a better button
     * class.
     *
     * @param renderer The graphics component
     * @param button The {@link Button} that will be rendered
     */

    void renderButton(Frost2D renderer, Button button);

    /**
     * Renders the {@link Grid} to the screen as a grid map that will be used for
     * placing down tiles to create a {@link Map} when it is finally completed.
     *
     * @param renderer The graphics component
     * @param grid The {@link Grid} that will be rendered
     */

    void renderGrid(Frost2D renderer, Grid grid);

    /**
     * Renders the {@link GameGraph} to the screen as being apart of the
     * {@link GUI} by using multiple {@link UI} components to make up the
     * game. This is how games will be made using the {@link GameGraph} because
     * it will be where most of the rendering and other processes go on.
     *
     * @param renderer The graphics component
     * @param scene The {@link GameGraph} that will be rendered
     */

    void renderScene(Frost2D renderer, GameGraph scene);


}
