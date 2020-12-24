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

public class PClass {

    private static String name;
    private static boolean v;

    public PClass(Lexer lexer, String name) throws ForbiddenCharacterException {
        this.name = name;

        if(name.equals("@start") || name.equals("Window") || name.equals("@end") || name.equals("write")) {
            throw new ForbiddenCharacterException("A Keyword CANNOT be a class name!");
        }
        else if(name.startsWith("\"") || name.endsWith("\"") || name.equals("\n")) {
            throw new ForbiddenCharacterException("Class names CANNOT be random tokens!");
        }
        else if(name.equals("")) {
            throw new ForbiddenCharacterException("You must have a class name!");
        }

        lexer.getDatas().add(new TokenData(Pattern.compile(name), Type.IDENTIFIER));
        v = true;

    }

    public static String getName() {
        return name;
    }

    public static boolean getV() {
        return v;
    }
}
