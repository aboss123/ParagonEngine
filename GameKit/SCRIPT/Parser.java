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

import GameKit.API.Content;

public class Parser {

    private String fileContents;
    private static int count = 0;

    private Parser(String fileContents) throws ForbiddenCharacterException {
        this.fileContents = fileContents;
        String fileToParse = Content.loadFileAsString(fileContents);
        compile(fileToParse);
    }

    public static void compile(String file) throws ForbiddenCharacterException {

//            String test = "";

            for(String line : file.split("\n")) {
                line = line.trim();
                Lexer lexer = new Lexer(line);
                count++;

                for (int i = 0; i < line.length() ; i++) {
                    Token t = lexer.nextToken();
                    Properties.checkScriptEstablishments(lexer, t, file);
                }
            }

//            String window = "Window(\"@start\", 400, 400)";
//
//            Lexer lexer = new Lexer(file);
//
//            while(lexer.hasTheNextToken()) {
//                Token t = lexer.nextToken();
//                System.out.println(t.getType() + " " + t.getToken());
//            }

        }

    public static int getLineCount() {
        return count;
    }

    public static void main(String[] args) throws ForbiddenCharacterException {
        long startTime = System.currentTimeMillis();
        new Parser("/Users/kelsa/Desktop/JavaPrograms/ParagonEngine/src/GameKit/SCRIPT/cool.gs");
        long endTime = System.currentTimeMillis();
        System.out.println("Took "+(endTime - startTime) + " ms");
    }

}
