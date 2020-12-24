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

public class EndEvent {

    private static int count;
    private static int count2;
    private static int count3;

    public EndEvent(String name, String file) throws ForbiddenCharacterException {

        String[] tokens = file.split(":");


        if(tokens[0].lastIndexOf("done") > tokens[0].lastIndexOf("node") && tokens[0].lastIndexOf("done") > 0
                && tokens[0].lastIndexOf("node") > 0) {
            count++;
//            checkEndCount = tokens[0].lastIndexOf("done");
//            Content.print(tokens[0].lastIndexOf("done") > tokens[0].lastIndexOf("event") && tokens[0].lastIndexOf("done") < 0 && tokens[0].lastIndexOf("event") < 0);
        }
        else {
            throw new ForbiddenCharacterException("Token 'done' must be matched with node branch!");
        }
        for(String line : file.split("\n")) {
            line = line.trim();
            Lexer lexer = new Lexer(line);

            for (int i = 0; i < line.length() ; i++) {
                Token t = lexer.nextToken();
                if(t.getToken().equals("done")) {
                    count2++;
                }
            }
        }

        for(String line: file.split("\n")) {
            line = line.trim();
            Lexer lx = new Lexer(line);

            for (int i = 0; i < line.length() ; i++) {
                Token tx = lx.nextToken();
                if(tx.getToken().equals("//")) {
                    tx = lx.nextToken();
                    if(tx.getToken().equals("done")) {
                        count2--;
                    }
                }
            }
        }

        if(count == 0 && count2 == 0 && count3 == 0)
            throw new ForbiddenCharacterException("Token 'done' must be matched with node branch!");

        if(count2 != EventMethod.getEventCount())
            throw new ForbiddenCharacterException("Token 'done' must be matched with node branch!");

        if(EventMethod.getEventCount() == 1) {
            count3 = count2;
        } else {
            count3 = count2 / (EventMethod.getEventCount() / 2);
        }



        if(count2 % EventMethod.getEventCount() != 0 || count3 > EventMethod.geteCount()) {
            throw new ForbiddenCharacterException("Unexpected 'done' token!");
        }

    }

    public static int getCount() {
        return count;
    }

    public static int getCount2() {
        return count2;
    }

    public static int getCount3() {
        return count3;
    }

    public static void setCount2(int count2) {
        EndEvent.count2 = count2;
    }

    public static void setCount3(int count3) {
        EndEvent.count3 = count3;
    }
}
