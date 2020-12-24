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

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {

    private ArrayList<TokenData> tDatas;

    private String tokens;

    private Token lastToken;
    private boolean toPush;

    public Lexer(String tokens) {
        this.tDatas = new ArrayList<>();
        this.tokens = tokens;

        // Basic categories
        tDatas.add(new TokenData(Pattern.compile("^([a-zA-Z][a-zA-Z0-9]*)"), Type.IDENTIFIER));
        tDatas.add(new TokenData(Pattern.compile("^((-)?[0-9]+)"), Type.INTEGER));
        tDatas.add(new TokenData(Pattern.compile("^(\".*\")"), Type.STRING));

        tDatas.add(new TokenData(Pattern.compile(";"), Type.NULL));


        tDatas.add(new TokenData(Pattern.compile("@start"), Type.KEYWORD));
        tDatas.add(new TokenData(Pattern.compile("@end"), Type.KEYWORD));
        tDatas.add(new TokenData(Pattern.compile("=>"), Type.KEYWORD));



        tDatas.add(new TokenData(Pattern.compile("//"), Type.COMMENT));


        for (String t : new String[] { "=", "\\(", "\\)", "\\.", "\\,", "print"}) {
            tDatas.add(new TokenData(Pattern.compile("^(" + t + ")"), Type.TOKEN));
        }

    }

    public Token nextToken() throws ForbiddenCharacterException {
        tokens = tokens.trim();

        if(toPush) {
            toPush = false;
            return lastToken;
        }

        if(tokens.isEmpty()) {
            return (lastToken = new Token("", Type.BLANK));
        }


        for (TokenData data : tDatas) {
            Matcher matcher = data.getPattern().matcher(tokens);

            if (matcher.find()) {
                String token = matcher.group().trim();
                tokens = matcher.replaceFirst("");

                if(data.getType() == Type.STRING) {
                    return (lastToken = new Token(token.substring(1, token.length() - 1), Type.STRING));
                }

                else {
                    return (lastToken = new Token(token, data.getType()));
                }

            }
        }
            throw new ForbiddenCharacterException("The characters could not be parsed: " + "'" + tokens + "'");
    }

    public boolean hasTheNextToken() {
        return !tokens.isEmpty();
    }

    public ArrayList<TokenData> getDatas() {
        return tDatas;
    }

}
