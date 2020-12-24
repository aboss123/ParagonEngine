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

import java.util.ArrayList;

public class GameObject<T extends GameObject> {

    private ArrayList<GameObject> objects = new ArrayList<GameObject>();
    private int x;
    private int y;
    private int dx;
    private int dy;

    public GameObject(T t) {
        objects.add(t);
    }

    public GameObject() {}

    public void add(T value) {
        objects.add(value);
    }

    public void remove(T value) {
        for (int i = 0; i < objects.size() ; i++) {
            if(objects.get(i).equals(value)) {
                objects.remove(i);
                i--;
            }
        }
    }

    public int getX() { return x; }

    public int getY() { return y; }

    public int getDx() { return dx; }

    public int getDy() { return dy; }


    public boolean equals(Object object) {
        if(object == this) return true;
        if(!(object instanceof GameObject)) return false;
        return false;
    }

}
