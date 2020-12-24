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

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends Actor {

    private float xOffset, yOffset;
    private Animation animUp, animDown, animLeft, animRight, standing;
    private BufferedImage[] Idle = new BufferedImage[3];
    SpriteSheet sheet = new SpriteSheet(Content.loadImage("/Users/kelsa/Desktop/JavaPrograms/2DGame/res/textures/charcacter.png"));


//    private int[] nSprites = {
//            3, 3, 3, 3
//    };
//
//    private int[] sWidths = {
//        96, 96, 96, 96
//    };

    private Direction[] directions = {
        Direction.DOWN, Direction.LEFT, Direction.RIGHT, Direction.UP, Direction.NULL
    };

    public Player(float x, float y) {
        super(x, y, PlayerID.RPG);

        bounds.x = 16;
        bounds.y = 16;
        bounds.width = 64;
        bounds.height = 64;

        width = 96;
        height = 96;

//        Animation.animate(sheet, nSprites, sWidths, sWidths);

        standing = myAnimation().get(4);
        animDown = myAnimation().get(0);
        animLeft = myAnimation().get(1);
        animRight = myAnimation().get(2);
        animUp = myAnimation().get(3);


//       standing = new Animation(Idle);
//       animDown = new Animation(Animation.getAnimation(0));
//       animLeft = new Animation(Animation.getAnimation(1));
//       animRight = new Animation(Animation.getAnimation(2));
//       animUp = new Animation(Animation.getAnimation(3));


    }

    public ArrayList<Animation> myAnimation() {
        return Animation.animate(sheet,4, directions, animDown, animLeft, animRight, animUp);
    }

    @Override
    public void update() {
        super.update(this);
    }

    /**
     * {@link Actor#renderActor(Frost2D)}
     * This is one method of rendering, not as efficient. This method
     * requires one method to be executed.
     *
     * {@link Actor#renderActor(Frost2D, Animation...)}
     * This is a very efficient method that only requires the animation
     * component in a specific order for the type of player that is being
     * created.
     */

    @Override
    public Entity render(Frost2D renderer) {

        // One and done line, this line doesn't require any extra methods and does
        // highly specific rendering.
        super.renderActor(renderer, animLeft, animRight, animUp, animDown, standing);
        return this;
    }

    @Override
    public void updateAnimations() {
        standing.setDelay(500);
        standing.update();
        animRight.setDelay(500);
        animRight.update();
        animLeft.setDelay(500);
        animLeft.update();
        animDown.setDelay(500);
        animDown.update();
        animUp.setDelay(500);
        animUp.update();
    }


//    // Less efficient way of handling
    public BufferedImage getCurrentAnimationFrame() {
        if(xMove < 0)
            return animLeft.getSetAnimation();
        else if(xMove > 0)
            return animRight.getSetAnimation();
        else if(yMove < 0)
            return animUp.getSetAnimation();
        else if(yMove > 0)
            return animDown.getSetAnimation();
        else
            return standing.getSetAnimation();
    }

}
