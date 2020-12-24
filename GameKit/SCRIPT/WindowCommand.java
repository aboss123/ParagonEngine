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

package GameKit.SCRIPT;

import GameKit.API.GFWindow;

import java.util.regex.Pattern;

public class WindowCommand {

    private Type oType;

    public WindowCommand(Lexer lexer, String name, int width, int height) {

        try {

            new GFWindow(name, width, height);

            if (name.equals("@start") || name.equals("@end") || name.equals("write") || name.equals("Window")) {
                toString(lexer, name);
                new GFWindow(name, width, height);
                revert(lexer, name);
            }
            else {
                throw new ForbiddenCharacterException();
            }
        }
        catch(Exception e) {}

    }

    private Type getOType() {
        return oType;
    }


    public void toString(Lexer lexer, String s) {
        int position = lexer.getDatas().lastIndexOf(s);
        oType = lexer.getDatas().get(position).getType();
        lexer.getDatas().set(position, new TokenData(Pattern.compile(s), Type.STRING));
    }

    public void revert(Lexer lexer, String s) {
        int position = lexer.getDatas().lastIndexOf(s);
        lexer.getDatas().set(position, new TokenData(Pattern.compile(s), getOType()));
    }

}
