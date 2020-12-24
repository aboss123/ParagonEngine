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

public interface ICamera {

    /**
     * Zooms the camera in at the current position that it
     * is at.
     *
     * @param scale The scale to zoom in
     */

    void zoomIn(float scale);

    /**
     * Zooms the camera out at the current position that it
     * is at.
     *
     * @param scale The scale to zoom out
     */

    void zoomOut(float scale);

    /**
     * Zoom the camera at a certain coordinate point.
     *
     * @param x The X point to zoom
     * @param y The Y point to zoom
     */

    void zoom(float x, float y);

    /**
     * Moves the camera to a certain position.
     *
     * @param x The X point to move
     * @param y The Y point to move
     */

    void translate(float x, float y);

    /**
     * Centers the camera on the {@link Actor} that is
     * the player.
     *
     * @param a The Player
     */

    void centerOnPlayer(Actor a);

    /**
     * Centers the camera on the {@link Entity}. This may be
     * used when it comes for cut-scenes that occur.
     *
     * @param e The {@link Entity} to center the camera on
     */

    void centerOnEntity(Entity e);

    /**
     * Moves the camera to the right.
     *
     * @param scale The scale to move the camera
     */

    void moveRight(int scale);

    /**
     * Moves the camera to the left
     *
     * @param scale The scale to move the camera
     */

    void moveLeft(int scale);

    /**
     * Moves the camera upwards.
     *
     * @param scale The scale to move the camera
     */

    void moveUp(int scale);

    /**
     * Moves the camera downwards.
     *
     * @param scale The scale to move the camera
     */

    void moveDown(int scale);

    /**
     * Pauses the camera.
     */

    void pause();

    /**
     * Applies a special transition to the camera. This could be switching scenes
     * but still allowing the camera to be present.
     *
     * @param transition The {@link Transition} to apply
     */

    void applyTransition(Transition transition);

}
