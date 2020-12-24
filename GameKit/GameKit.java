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

public abstract class GameKit {

    private Frost2D renderer;
    private Grid grid;
    private GUI gui;
    private UI ui;
    private LightMap lightMap;
    private MapGenerator mapGenerator;
    private MapRegion mapRegion;
    private Mouse mouse;
    private SavedSpriteSheet savedSpriteSheet;
    private UIManager uiManager;
    private UIObject uiObject;


    public MapRegion getMapRegion() {
        return mapRegion;
    }

    public Grid getGrid() {
        return grid;
    }

    public GUI getGui() {
        return gui;
    }

    public LightMap getLightMap() {
        return lightMap;
    }

    public MapGenerator getMapGenerator() {
        return mapGenerator;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public Frost2D getRenderer() {
        return renderer;
    }

    public SavedSpriteSheet getSavedSpriteSheet() {
        return savedSpriteSheet;
    }

    public UI getUi() {
        return ui;
    }

    public UIManager getUiManager() {
        return uiManager;
    }

    public UIObject getUiObject() {
        return uiObject;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public void setGui(GUI gui) {
        this.gui = gui;
    }

    public void setLightMap(LightMap lightMap) {
        this.lightMap = lightMap;
    }

    public void setMapGenerator(MapGenerator mapGenerator) {
        this.mapGenerator = mapGenerator;
    }

    public void setMapRegion(MapRegion mapRegion) {
        this.mapRegion = mapRegion;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public void setRenderer(Frost2D renderer) {
        this.renderer = renderer;
    }

    public void setSavedSpriteSheet(SavedSpriteSheet savedSpriteSheet) {
        this.savedSpriteSheet = savedSpriteSheet;
    }

    public void setUi(UI ui) {
        this.ui = ui;
    }

    public void setUiManager(UIManager uiManager) {
        this.uiManager = uiManager;
    }

    public void setUiObject(UIObject uiObject) {
        this.uiObject = uiObject;
    }
}
