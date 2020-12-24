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
import GameKit.API.GKObject.Direction;


/**
 * This class is for all physics related gravity purposes.
 * @author Ashish Bailkeri
 */

public class Gravity {

    private static final float gravity = 9.8f;

    /**
     * This applies gravity to the given entity.
     *
     * @param e This is the entity to apply gravity to
     */

    private static void applyGravity(Entity e) {
        GKPhysics.accelerateEntity(e, gravity, Direction.DOWN);
    }

    /**
     * This applies conditional gravity if the entity is moving
     * and is facing upwards.
     *
     * @param e This is the entity to apply gravity to
     */

    private static void appliedGravity(Entity e) {
        if(e.isFalling()) {
            applyGravity(e);
        }
     }

    /**
     * This type of Gravity case allows if an {@link Entity} is accelerating
     * upwards it checks if it is done moving to {@link #appliedGravity(Entity)}.
     *
     * @param e The {@link Entity} to apply Gravity to
     */

     public static void advancedGravity(Entity e) {
        if(GKPhysics.UP && !e.isMoving) {
            if(e.isMoving) {
                appliedGravity(e);
            }
        }
        else {
            appliedGravity(e);
        }
     }

}
