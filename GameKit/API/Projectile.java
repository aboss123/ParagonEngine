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

public class Projectile extends Entity {

    protected Texture texture;
    protected float speed;
    protected Direction dir;


    public Projectile(Texture texture, float x, float y, float speed, Direction dir) {

        this.texture = texture;
        this.speed = speed;
        this.dir = dir;
    }

    @Override
    public Entity render(Frost2D renderer) {
        renderer.draw(texture, (int) x, (int) y);
        return this;
    }

    @Override
    public void update() {
        switch(dir) {
            default:
                break;
            case UP:
                GKPhysics.accelerateEntity(this, speed, dir);
                break;
            case DOWN:
                GKPhysics.accelerateEntity(this, speed, dir);
                break;
            case LEFT:
                GKPhysics.accelerateEntity(this, speed, dir);
                break;
            case D_UP:
                GKPhysics.accelerateEntity(this, speed, Direction.UP);
                GKPhysics.accelerateEntity(this, speed, Direction.RIGHT);
                break;
            case D_DOWN:
                GKPhysics.accelerateEntity(this, speed, Direction.LEFT);
                GKPhysics.accelerateEntity(this, speed, Direction.DOWN);
                break;
            case D_RIGHT:
                GKPhysics.accelerateEntity(this, speed, Direction.DOWN);
                GKPhysics.accelerateEntity(this, speed, Direction.RIGHT);
                break;
            case D_LEFT:
                GKPhysics.accelerateEntity(this, speed, Direction.UP);
                GKPhysics.accelerateEntity(this, speed, Direction.LEFT);
                break;
        }
    }


}
