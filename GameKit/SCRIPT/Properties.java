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
import GameKit.Transition;

import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Properties {

    private static boolean foundMethodToken;

    public static boolean print = false;
    public static boolean window = false;
    public static boolean mainDone = false;

    public static void setMainDone(boolean change) {
        mainDone = change;
    }

    private static void checkComments(Lexer l, Token t, String file) throws ForbiddenCharacterException {
        if(t.getType() == Type.COMMENT && t.getToken().equals("//")) {
            l.nextToken();
        }
    }

    private static void checkClass(Lexer lexer, Token t, String file) throws ForbiddenCharacterException {

        if(t.getType() == Type.IDENTIFIER && t.getToken().equals("construct")) {
            t = lexer.nextToken();
            new PClass(lexer, t.getToken());
        }


//        checkNestedEventMethods(lexer, t, file);
//        checkExit(lexer, t);
        checkPrint(lexer, t);
//        checkMethodInvoked(lexer, t, file);
//        checkEval(lexer, t);
//        checkWindow(lexer, t);
    }

    public static void checkExit(Lexer lexer, Token t) throws ForbiddenCharacterException {

        if(mainDone)
            return;

        if(t.getToken().equals("close")) {
            t = lexer.nextToken();
            if(t.getToken().equals("(")) {
                t = lexer.nextToken();
                if(t.getToken().equals(")")) {
                    System.exit(1);
                }
            }
        }
    }

    private static void checkParenthesis(Lexer lexer, String keyword, Type[] type, String method, int numParameters, Class c) throws ForbiddenCharacterException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        boolean P;
        ArrayList<Object> parameters = new ArrayList<>(); // Window("D", 100, 100, 100 100)
        int count = 0;
        while(lexer.hasTheNextToken()) {
            Token t = lexer.nextToken();
            if(t.getToken().equals(keyword)) {
                t = lexer.nextToken();
                if(t.getType() == Type.TOKEN && t.getToken().equals("("))
                    P = true;
                else
                    throw new ForbiddenCharacterException("Missing Parenthesis! Token: " + t.getToken() + " | Line Number: " + Parser.getLineCount());
                t = lexer.nextToken();
                for (int i = 0; i < numParameters + (numParameters - 1); i++) {
                    if(t.getType() == type[i]) {
                        parameters.add(t.getToken());
                        if(t.getToken().equals(","))
                            count++;
                    }
                    t = lexer.nextToken();
                }
                if(numParameters != parameters.size() - count)
                    throw new ForbiddenCharacterException("Missing ',' between parameters");
                for (int i = 0; i < numParameters + count ; i++) {
                    if(parameters.get(i).equals(",")) {
                        parameters.remove(i);
                        i--;
                    }
                }
                t = lexer.nextToken();
                if (t.getType() == Type.TOKEN && t.getToken().equals(")")) {
                    c.getMethod(method).invoke(parameters);
                }
            }
        }
    }

    private static void checkParenthesis(Lexer lexer, String keyword, Type[] type, String method, ArrayList<Object> params, int numParameters, Class c) throws ForbiddenCharacterException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        boolean P;
        ArrayList<Object> parameters = new ArrayList<>(); // Window("D", 100, 100, 100 100)
        int count = 0;
        while(lexer.hasTheNextToken()) {
            Token t = lexer.nextToken();
            if(t.getToken().equals(keyword)) {
                t = lexer.nextToken();
                if(t.getType() == Type.TOKEN && t.getToken().equals("("))
                    P = true;
                else
                    throw new ForbiddenCharacterException("Missing Parenthesis! Token: " + t.getToken() + " | Line Number: " + Parser.getLineCount());
                t = lexer.nextToken();
                for (int i = 0; i < numParameters + (numParameters - 1); i++) {
                    if(t.getType() == type[i]) {
                        parameters.add(t.getToken());
                        if(t.getToken().equals(","))
                            count++;
                    }
                    t = lexer.nextToken();
                }
                if(numParameters != parameters.size() - count)
                    throw new ForbiddenCharacterException("Missing ',' between parameters");
                for (int i = 0; i < numParameters + count ; i++) {
                    if(parameters.get(i).equals(",")) {
                        parameters.remove(i);
                        i--;
                    }
                }
                t = lexer.nextToken();
                if (t.getType() == Type.TOKEN && t.getToken().equals(")")) {
                    for (int i = 0; i < params.size(); i++) {
                        c.getMethod(method).invoke(params.get(i));
                    }
                }
            }
        }
    }

//    public static void checkLoops(String file) throws ForbiddenCharacterException {
//        if(mainDone)
//            return;
//
//        new LoopFunction(file);
//    }

    private static void checkMethodInvoked(Lexer lexer, Token t, String file) throws ForbiddenCharacterException {

        boolean P;
        String method = "";

        if(t.getType() == Type.IDENTIFIER && t.getToken().equals("invoke")) {
            t = lexer.nextToken();
            if(t.getType() == Type.TOKEN && t.getToken().equals("(")) {
                P = true;
            }
            else {
                throw new ForbiddenCharacterException("Missing Parenthesis! Token: " + t.getToken() + " | Line Number: " + Parser.getLineCount());
            }
            t = lexer.nextToken();
            if(P && t.getType() == Type.IDENTIFIER) {
                method = t.getToken();
            }
            if (t.getToken().equals(")")) {
                invoke(method, file);
            }


        }
    }

    public static void invoke(String name, String file) throws ForbiddenCharacterException {

        mainDone = true;
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

    public static void checkPrint(Lexer lexer, Token t) throws ForbiddenCharacterException {

        if(mainDone)
            return;

        boolean P;
        ArrayList<String> messages = new ArrayList<>();
        String[] b = new String[256];

        if(t.getType() == Type.IDENTIFIER && t.getToken().equals("write")) {
            foundMethodToken = true;
            t = lexer.nextToken();
            if(t.getType() == Type.TOKEN && t.getToken().equals("(")) {
                P = true;
            }
            else {
                throw new ForbiddenCharacterException("Missing Parenthesis! Token: " + t.getToken() + " | Line Number: " + Parser.getLineCount());
            }
            t = lexer.nextToken();
            if(P && t.getType() == Type.STRING) {
                messages.add(t.getToken());
                b[0] = t.getToken();
            }
            t = lexer.nextToken();
            if (t.getType() == Type.TOKEN && t.getToken().equals(")")) {
                for (int i = 0; i < messages.size(); i++) {
                    String[] q = b[0].split("\"");
                    String[] check = new String[q.length];
                    String output = "";
                    int count = Content.getElement(b[0], "\\+");
                    int qCount = Content.getElement(b[0], "\"");
                    for (int j = 0; j < check.length ; j++) {
                        check[j] = q[j];
                        for (int k = 0; k < Constants.characters.length ; k++) {
                            if(check[j].contains("+")) {
                                if(check[j].contains(Constants.characters[k])) {
                                    throw new ForbiddenCharacterException("Unexpected Tokens in Expression! | Line Number: " + Parser.getLineCount());
                                }
                            }
                        }
                    }

                    if((double) (q.length - 1) / (double) count != 2.0 && qCount > 1)
                        throw new ForbiddenCharacterException("Missing '+' token when combining strings! | Line Number: " + Parser.getLineCount());


                    for (int j = 0; j < q.length ; j++) {
                        if(q[j].contains("+"))
                            q[j] = "";
                        if(q[j].contains("\\n")) {
                            String s = q[j].replace("\\n", "\n");
                            q[j] = s;
                        }
                        if(q[j].contains("\\\"")) {
                            String s = q[j].replace("\\\"", "\"");
                            q[j] = s;
                        }
                        if(q[j].contains("\\\\")) {
                            String s = q[j].replace("\\\\", "\\");
                            q[j] = s;
                        }
                        if(q[j].contains("\\t")) {
                            String s = q[j].replace("\\t", "\t");
                            q[j] = s;
                        }
                        output += q[j];
                    }
                    new PrintCommand(output, lexer);
                }
            } else {
                throw new ForbiddenCharacterException("Missing Parenthesis! Token: " + t.getToken() + " | Line Number: " + Parser.getLineCount());
            }
        }
    }

    public static void checkEval(Lexer lexer, Token t) throws ForbiddenCharacterException {

        if(mainDone)
            return;

        boolean P;
        ArrayList<String> result = new ArrayList<>();

        if(t.getToken().equals("eval")) {
            t = lexer.nextToken();
            if(t.getType() == Type.TOKEN && t.getToken().equals("(")) {
                P = true;
            }
            else {
                throw new ForbiddenCharacterException("Missing Parenthesis! Token: " + t.getToken() + " | Line Number: " + Parser.getLineCount());
            }
            t = lexer.nextToken();
            if(P && t.getType() == Type.STRING) {
                result.add(t.getToken());
            }
            t = lexer.nextToken();
            if (t.getType() == Type.TOKEN && t.getToken().equals(")")) {
                for(String equation : result) {
                    Content.print(Script.eval(equation));
                }
            } else {
                throw new ForbiddenCharacterException("Missing Parenthesis! Token: " + t.getToken() + " | Line Number: " + Parser.getLineCount());
            }
        }
    }


    public static void checkWindow(Lexer lexer, Token t) throws ForbiddenCharacterException {

        if(mainDone)
            return;

        boolean P;
        window = true;

        String p1 = "";
        int p2 = 0;
        int p3 = 0;

        if(t.getType() == Type.IDENTIFIER && t.getToken().equals("Window")) {
            foundMethodToken = true;
            t = lexer.nextToken();
            if(t.getType() == Type.TOKEN && t.getToken().equals("(")) {
                P = true;
            }
            else {

                throw new ForbiddenCharacterException("Missing Parenthesis! \nToken: " + t.getToken() + " \nLine Number: " + Parser.getLineCount());
            }
            t = lexer.nextToken();
            if(P && t.getType() == Type.STRING) {
                p1 = t.getToken();
            }
            else {
                throw new ForbiddenCharacterException("The first parameter must be a string! \nToken: " + t.getToken() + " \n Line Number: " + Parser.getLineCount());
            }
            t = lexer.nextToken();
            if(t.getType() == Type.TOKEN && t.getToken().equals(",")) {
                Content.print("");
            }
            else {
                throw new ForbiddenCharacterException("There must be a transition token between more than one parameter! Token: \n" + t.getToken() + " \nLine Number: " + Parser.getLineCount());
            }
            t = lexer.nextToken();
            if(t.getType() == Type.INTEGER) {
                p2 = Content.parseInt(t.getToken());
            }
            else {
                throw new ForbiddenCharacterException("This parameter must be an integer! \nToken: " + t.getToken() + " \nLine Number: " + Parser.getLineCount());
            }
            t = lexer.nextToken();
            if(t.getType() == Type.TOKEN && t.getToken().equals(",")) {
                Content.print("");
            }
            else {
                throw new ForbiddenCharacterException("There must be a transition token between more than one parameter");
            }
            t = lexer.nextToken();
            if (t.getType() == Type.INTEGER) {
                p3 = Content.parseInt(t.getToken());
            } else {
                throw new ForbiddenCharacterException("This parameter must be an integer");
            }
            t = lexer.nextToken();
            if(t.getType() == Type.TOKEN && t.getToken().equals(")"))       {
                new WindowCommand(lexer, p1, p2, p3);
                window = false;
            }
            else {
                throw new ForbiddenCharacterException("Missing Parenthesis! Token: " + t.getToken() + " | Line Number: " + Parser.getLineCount());

            }
        }
    }

    private static void checkLinearLogo(Lexer lexer, Token t) throws  ForbiddenCharacterException {

        boolean P;

        if(t.getType() == Type.IDENTIFIER && t.getToken().equals("logo")) {
            foundMethodToken = true;
            t = lexer.nextToken();
            if(t.getType() == Type.TOKEN && t.getToken().equals("(")) {
                P = true;
            }
            else {
                throw new ForbiddenCharacterException("Missing Parenthesis! Token: " + t.getToken() + " | Line Number: " + Parser.getLineCount());
            }
            t = lexer.nextToken();
            if(P && t.getType() == Type.STRING) {
                BufferedImage image = Content.loadImage(t.getToken());
                Transition.FadingTransition transition = new Transition.FadingTransition(image, 60, 60, 60);
                for (int i = 0; i < 15 ; i++) {
                    transition.update();
                }
            }
            t = lexer.nextToken();
            if(t.getType() == Type.TOKEN && t.getToken().equals(")"))       {
                Content.print("");
            }
            else {
                throw new ForbiddenCharacterException("Missing Parenthesis! Token: " + t.getToken() + " | Line Number: " + Parser.getLineCount());
            }
        }

    }

    private static void checkEventMethods(Lexer lexer, Token t, String file) throws ForbiddenCharacterException {
        for(String line : file.split("\n")) {

        }

        String[] test = file.split("\n");
        for (int i = 0; i < test.length ; i++) {
            if(test[i].contains("node")) {
                for(String line : test[i].split("=> (" + "" +")")[0].split("\n")) {
                    if(line.contains("node")) {
                        for (int j = 0; j < line.length() ; j++) {
                            new EventMethod(lexer, line.replace("node ", ""), file);
                            checkEndOfFunction(lexer, file);
                        }
                    }
                }
            }
        }


//        try {
//            for (String line : file.split("\n")) {
//                for (int i = 0; i < line.length(); i++) {
//                    if (line.contains("node")) {
//                        t = lexer.nextToken();
//                        String[] tokens = t.getToken().split(";");
//                        for (int j = 0; j < tokens.length; j++) {
//                            if (tokens[i].equals("=>") || tokens[i].equals(")") || tokens[i].equals("(")) {
//                                tokens[i] = "";
//                            }
//                            new EventMethod(lexer, "hitesh", file);
//                            checkEndOfFunction(lexer, file);
//                        }
//                    }
//                }
//            }
//        } catch(Exception e) {}
    }

    private static void checkNestedEventMethods(Lexer lexer, Token t, String file) throws ForbiddenCharacterException {

        if(lexer.hasTheNextToken()) {
            checkEventMethods(lexer, t, file);
//            if(EventMethod.event) {
//                if(EventMethod.getEventCount() > 1) {
//                    throw new ForbiddenCharacterException("You CANNOT have nested Event Methods!");
//                }
//            }
        }
    }

    private static void checkEndOfFunction(Lexer lexer, String file) throws ForbiddenCharacterException {
        Token t = lexer.nextToken();
        new EndEvent(t.getToken(), file);
    }

    private static void checkRandomTokens(Token t, String file) throws ForbiddenCharacterException {
        for(String line : file.split("\n")) {
            line = line.trim();
            Lexer lexer = new Lexer(line);

            for (int i = 0; i < line.length() ; i++) {
                Token tx = lexer.nextToken();
                if (tx.getType() == Type.IDENTIFIER) {
                    Content.print(t.getToken());
                }
            }
        }
    }


    public static void checkScriptEstablishments(Lexer lexer, Token t, String file) throws  ForbiddenCharacterException {

        String[] tokens = file.split(":");
        String[] tx = file.split("\n");
        boolean T = false;
        boolean E = false;


        if (!tokens[0].startsWith("@start") || tokens[0].lastIndexOf("@start") < 0) {
            if(tokens[0].lastIndexOf("@start") < 0)
                throw new ForbiddenCharacterException("You must start the file with" +
                        "a '@start' keyword notation");
            else if(!tokens[0].startsWith("//"))
                throw new ForbiddenCharacterException("You must start the file with" +
                        "a '@start' keyword notation");
        }
        else {
            T = true;
        }

        if(tx[0].contains("//@start")) {
            throw new ForbiddenCharacterException("You must start the file with" +
                    "a '@start' keyword notation");
        }

        String test = "";
        while(!tx[0].contains("//" + test + "@start") && !T) {
            test = test + " ";
            if(tx[0].contains("//" + test + "@start")) {
                throw new ForbiddenCharacterException("You must start the file with" +
                        "a '@start' keyword notation");
            }
        }

        if (!tokens[tokens.length - 1].contains("@end") ||
                tokens[tokens.length - 1].lastIndexOf("") - tokens[tokens.length - 1].lastIndexOf("@end") - 1 > 5) {
            throw new ForbiddenCharacterException("You must end the file with a '@end' keyword notation");
        }

        if(tokens[tokens.length - 1].startsWith("//") && tokens[tokens.length - 1].indexOf("@end") > tokens[tokens.length - 1].lastIndexOf("//")) {
            throw new ForbiddenCharacterException("You must end the file with a '@end' keyword notation");
        }

        if (tokens[0].lastIndexOf("construct") > 0) {
            if ((tokens[0].lastIndexOf("construct") > tokens[0].lastIndexOf("write") && tokens[0].lastIndexOf("write") > 0)
                    || (tokens[0].lastIndexOf("construct") > tokens[0].lastIndexOf("Window") && tokens[0].lastIndexOf("Window") > 0)) {
                throw new ForbiddenCharacterException("All statements must be made after class declaration!");
            }
            if (tokens[0].lastIndexOf("construct") > tokens[0].lastIndexOf("global event main => ()") && tokens[0].lastIndexOf("global event main => ()") < 0) {
                throw new ForbiddenCharacterException("The main method must be declared after the class method");
            }
        } else {
            throw new ForbiddenCharacterException("There must be a tree declaration!");
        }

        for(String line: file.split("\n")) {
            line = line.trim();
            Lexer lx = new Lexer(line);

            for (int i = 0; i < line.length() ; i++) {
                Token tv = lx.nextToken();
                if(tv.getToken().equals("//")) {
                    tv = lx.nextToken();
                    if(tv.getToken().equals("global")) {
                        throw new ForbiddenCharacterException("The main method must be declared after the class method");
                    }
                }
            }

            if(tokens[0].indexOf("done") < 0) {
                throw new ForbiddenCharacterException("A 'done' token must be matched with an event! | Line Number: " + Parser.getLineCount());
            }
        }

        checkComments(lexer, t, file);
        checkClass(lexer, t, file);
//            checkRandomTokens(t, file);
    }
}

