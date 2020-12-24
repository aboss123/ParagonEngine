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

import GameKit.ICamera;
import GameKit.Transition;
import GameKit.Transition.FadingTransition;

/**
 * This camera will work together with the other classes in the main
 * game engine packages such as {@link Entity} to be able to create
 * good character movement for the {@link Actor} that is the player.
 * It will provide features such as zoom in and zoom out as well as utilize
 * the transitions in {@link FadingTransition} for movement through out multiple
 * states that will occur.
 */

public strictfp class GameCamera implements ICamera {

    private float xTransfer, yTransfer;

    public GameCamera(float xTransfer, float yTransfer) {
        this.xTransfer = xTransfer;
        this.yTransfer = yTransfer;
    }


    @Override
    public void zoomIn(float scale) {

    }

    @Override
    public void zoomOut(float scale) {

    }

    @Override
    public void zoom(float x, float y) {

    }

    @Override
    public void translate(float x, float y) {

    }

    @Override
    public void centerOnPlayer(Actor a) {
        xTransfer = -a.getX() + (AbstractGame.getWindow().getWidth() / 2);
        yTransfer = -a.getY() + (AbstractGame.getWindow().getHeight() / 2);
    }

    @Override
    public void centerOnEntity(Entity e) {
        xTransfer = -e.getX() + (AbstractGame.getWindow().getWidth() / 2);
        yTransfer = -e.getY() + (AbstractGame.getWindow().getHeight() / 2);
    }

    @Override
    public void moveRight(int scale) {
        xTransfer -= scale;
    }

    @Override
    public void moveLeft(int scale) {
        xTransfer += scale;
    }

    @Override
    public void moveDown(int scale) {
        yTransfer += scale;
    }

    @Override
    public void moveUp(int scale) {
        yTransfer -= scale;
    }

    @Override
    public void pause() {

    }

    @Override
    public void applyTransition(Transition transition) {

    }

    public float getXTransfer() {
        return xTransfer;
    }

    public float getYTransfer() {
        return yTransfer;
    }

    public void setXTransfer(float xTransfer) {
        this.xTransfer = xTransfer;
    }

    public void setYTransfer(float yTransfer) {
        this.yTransfer = yTransfer;
    }
}
