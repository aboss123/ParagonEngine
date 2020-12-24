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

public class LoopFunction {

    // loop(10)
    //      write("hi")
    // done

    private int times = 0;
    public LoopFunction(String file) throws ForbiddenCharacterException {
        boolean P;

        Lexer lexer = new Lexer(file);
        Token t = lexer.nextToken();
        if (t.getToken().contains("loop")) {
            t = lexer.nextToken();
            if (t.getType() == Type.TOKEN && t.getToken().equals("(")) {
                P = true;
            } else {
                throw new ForbiddenCharacterException("Missing Parenthesis! Token: " + t.getToken() + " | Line Number: " + Parser.getLineCount());
            }
            t = lexer.nextToken();
            if (P && t.getType() == Type.INTEGER) {
                times = Integer.parseInt(t.getToken());
            }
            t = lexer.nextToken();
            if (t.getType() == Type.TOKEN && t.getToken().equals(")")) {
                while(lexer.hasTheNextToken()) {
                    t = lexer.nextToken();
                    while(t.getToken().equals("write")) {
                        for (int i = 0; i < times ; i++) {
                            Properties.checkPrint(lexer, t);
                            Content.print();
                        }
                        t = lexer.nextToken();
                    }
                    while(t.getToken().equals("Window")) {
                        Properties.checkWindow(lexer, t);
                        t = lexer.nextToken();
                        while(t.getToken().equals("write")) {
                            for (int i = 0; i < times; i++)
                                Properties.checkPrint(lexer, t);
                            t = lexer.nextToken();
                        }
                        while(t.getToken().equals("close")) {
                            for (int i = 0; i < times; i++)
                                Properties.checkExit(lexer, t);
                            t = lexer.nextToken();
                        }
                        while(t.getToken().equals("eval")) {
                            for (int i = 0; i < times ; i++)
                                Properties.checkEval(lexer, t);
                            t = lexer.nextToken();
                        }
                    }
                    while(t.getToken().equals("eval")) {
                        Properties.checkEval(lexer, t);
                        t = lexer.nextToken();
                        while(t.getToken().equals("write")) {
                            for (int i = 0; i < times; i++)
                                Properties.checkPrint(lexer, t);
                            t = lexer.nextToken();
                        }
                        while(t.getToken().equals("close")) {
                            for (int i = 0; i < times; i++)
                                Properties.checkExit(lexer, t);
                            t = lexer.nextToken();
                        }
                        while(t.getToken().equals("Window")) {
                            for (int i = 0; i < times ; i++)
                                Properties.checkWindow(lexer, t);
                            t = lexer.nextToken();
                        }
                    }
                    while(t.getToken().equals("close")) {
                        Properties.checkExit(lexer, t);
                        t = lexer.nextToken();
                    }
                }
                if(!t.getToken().equals("done")) {
                    System.out.println("TESTING");
                }
            }
        }
    }


}
