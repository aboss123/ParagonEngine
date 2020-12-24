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

package GameKit.API;

/**
 * This is the matrix 2D utilities class that will be useful
 * for any complex function regarding the matrix within a two
 * dimensional plane.
 *
 * @author Ashish Bailkeri
 */

public class Matrix2D {

    int[][] matrix;

    public Matrix2D(int[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * Reverses the row of a given specific array.
     *
     * @param array The array to reverse
     */

    public static void reverseArray(int[] array) {
        int mid = array.length / 2;
        for (int i = 0; i < mid; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1];
            array[array.length - 1] = temp;
        }
    }

    /**
     * This will reverse every row in a given matrix.
     */

    public void reverseAllRows() {
        for(int[] i : matrix) {
            reverseArray(i);
        }
    }

    /**
     * This will completely reverse the matrix and switch all
     * the matching positions.
     *
     */

    public void reverseMatrix() {
        reverseAllRows();
        int mid = matrix.length / 2;
        for (int i = 0; i < mid ; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[matrix.length - i - 1];
            matrix[matrix.length - i - 1] = temp;
        }
    }

    /**
     * Gets the element from the matrix.
     *
     * @param row The row in the matrix
     * @param col The col in the matrix
     * @return The element
     */

    public int getElement(int row, int col) {
        return matrix[row][col];
    }
    /**
     * This returns a boolean on whether a certain element is within an array.
     *
     * @param n The number to check within the matrix
     * @return Whether the given element is in the matrix or not
     */

    private boolean isInMatrix(int n) {
        for (int[] position : matrix) {
            for (int i = 0; i < matrix[0].length ; i++) {
                if(position[i] == n)
                    return true;
            }
        }
        return false;
    }

}
