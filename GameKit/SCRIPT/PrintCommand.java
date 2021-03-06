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

import java.util.regex.Pattern;

public class PrintCommand {

    private static String name;
    private Type oType;

    public PrintCommand(String name, Lexer lexer) {
        this.name = name;

        try {

            System.out.println(name);

            if (name.equals("@start") || name.equals("@end") || name.equals("write") || name.equals("Window") || name.equals("let")
            || name.equals("global") || name.equals("=>") || name.equals("event") || name.equals("class")) {
                toString(lexer, name);
                System.out.println(name);
                revert(lexer, name);
            }
            else {
                throw new ForbiddenCharacterException();
            }
        }
        catch(Exception e) {}

    }

    public static String getName() {
        return name;
    }

    private Type getOType() {
        return oType;
    }

    private void toString(Lexer lexer, String s) {
        int position = lexer.getDatas().lastIndexOf(s);
        oType = lexer.getDatas().get(position).getType();
        lexer.getDatas().set(position, new TokenData(Pattern.compile(s), Type.STRING));
    }

    private void revert(Lexer lexer, String s) {
        int position = lexer.getDatas().lastIndexOf(s);
        lexer.getDatas().set(position, new TokenData(Pattern.compile(s), getOType()));
    }
}
