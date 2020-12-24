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

import java.util.regex.Pattern;

public class EventMethod {

    public static boolean main = false;
    public static boolean event = false;
    public static boolean invoked = false;

    private static String name;
    private static int eventCount = 0;
    private static int eCount = 0;
    private static int eventNameCount = 0;

    public EventMethod(Lexer l, String name, String file) throws ForbiddenCharacterException{
        this.name = name;

        if (name.equals("@start") || name.equals("@end") | name.equals("Window") || name.equals("write") || name.equals("global") || name.equals("let")
        || name.equals("event")) {
            throw new ForbiddenCharacterException("A keyword CANNOT be the name of a method");
        }
        else if(name.equals("main")) {
            main = true;
        }

        l.getDatas().add(new TokenData(Pattern.compile(name), Type.IDENTIFIER));

        int nameCheck = 0;

        event = true;
        for(String line : file.split("\n")) {
            line = line.trim();
            Lexer lexer = new Lexer(line);

            for (int i = 0; i < line.length() ; i++) {
                Token t = lexer.nextToken();
                if(t.getToken().equals("event")) {
                    eventCount++;
                    t = lexer.nextToken();
                    if(t.getToken().equals("")) {
                        throw new ForbiddenCharacterException("An event must have a name!");
                    }
                }
                if(t.getToken().equals(name)) {
                    nameCheck++;
                }
            }
        }

        for(String line : file.split("\n")) {
            line = line.trim();
            Lexer lx = new Lexer(line);

            for (int i = 0; i < line.length() ; i++) {
                Token tx = lx.nextToken();
                if(tx.getToken().equals("//")) {
                    tx = lx.nextToken();
                    if(tx.getToken().equals("event")) {
                        eventCount--;
                    }
                }
            }
        }

        Token tx = l.nextToken();
        tx = l.nextToken();
//        System.out.println(!(tx.getToken().equals("=>")));
//        if(!(tx.getToken().equals("=>"))) {
//            throw new ForbiddenCharacterException("Missing lambda function operator!");
//        }

        eventNameCount++;

        int x = eventCount / 2;

        try {
            if(nameCheck > 1 && !PrintCommand.getName().equals(name)) {
                throw new ForbiddenCharacterException("Cannot Overload Methods! | Line Number: " + Parser.getLineCount());
            }

        } catch(Exception e) {}


        if(eventCount == 1) {
            eCount = 1;
        }
        else {
            eCount = eventCount / x;
        }
    }

    public static void invoke(String name, String file) throws ForbiddenCharacterException {

        Properties.setMainDone(false);
        Lexer lexer = new Lexer(file);


        for (int i = 0; i < file.length() ; i++) {
            while(lexer.hasTheNextToken()) {
                Token t = lexer.nextToken();
                System.out.println(t.getToken());
                if(t.getToken().contains(name)) {
                    for (int j = 0; j < 3; j++) {
                        t = lexer.nextToken();
                    }
                    while(t.getToken().equals("write")) {
                        Properties.checkPrint(lexer, t);
                        Content.print();
                        t = lexer.nextToken();
                    }
                    while(t.getToken().equals("Window")) {
                        Properties.checkWindow(lexer, t);
                        t = lexer.nextToken();
                        while(t.getToken().equals("write")) {
                            Properties.checkPrint(lexer, t);
                            t = lexer.nextToken();
                        }
                        while(t.getToken().equals("close")) {
                            Properties.checkExit(lexer, t);
                            t = lexer.nextToken();
                        }
                        while(t.getToken().equals("eval")) {
                            Properties.checkEval(lexer, t);
                            t = lexer.nextToken();
                        }
                    }
                    while(t.getToken().equals("eval")) {
                        Properties.checkEval(lexer, t);
                        t = lexer.nextToken();
                        while(t.getToken().equals("write")) {
                            Properties.checkPrint(lexer, t);
                            t = lexer.nextToken();
                        }
                        while(t.getToken().equals("close")) {
                            Properties.checkExit(lexer, t);
                            t = lexer.nextToken();
                        }
                        while(t.getToken().equals("Window")) {
                            Properties.checkWindow(lexer, t);
                            t = lexer.nextToken();
                        }
                    }
                    while(t.getToken().equals("close")) {
                        Properties.checkExit(lexer, t);
                        t = lexer.nextToken();
                    }
                }
            }
        }
    }

    public static void setEventCount(int eventCount) {
        EventMethod.eventCount = eventCount;
    }

    public static int getEventCount() {
        return eventCount;
    }

    public static int geteCount() {
        return eCount;
    }

    public static String getName() {
        return name;
    }

    public static int getEventNameCount() {
        return eventNameCount;
    }
}
