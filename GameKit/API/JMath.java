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
 * The class that has many useful math functions.
 * @author Ashish Bailkeri
 *
 */

public final strictfp class JMath {

	/**
	 * Ratio of the the circumference of a circle to its diameter
	 */
	public static final double PI = 3.14159265358979323846D;

	/**
	 * The natural law value of base algorithms.
	 */

	public static final double E = 2.7182818284590452354D;

	public JMath() {}

	/**
	 * Finds the side of a triangle. O / H
	 * 
	 * @param angle The angle to find the sin of
	 * @return The sin of the angle
	 */

	public static double sin(float angle) {
		return Math.sin(angle);
	}

	/**
	 * Finds the side of a triangle. A / H
	 * 
	 * @param angle The angle to find cos
	 * @return The cos of the angle
	 */

	public static double cos(float angle) {
		return Math.cos(angle);
	}

	/**
	 * Finds the side of a triangle. O / A
	 * 
	 * @param angle The angle to find tangent for
	 * @return The tangent of the angle
	 */

	public static double tan(float angle) {
		return Math.tan(angle);
	}

	/**
	 * Gets the square root of the given number.
	 * 
	 * @param num The number to get the square root of
	 * @return The square root of the number
	 */

	public static double sqrt(double num) {
		double x;
		double sqrt = num;

		do {
			x = sqrt;
			sqrt = (x + (num / x)) / 2;
		} while ((x - sqrt) != 0);

		return sqrt;
	}

	/**
	 * Raises the given number to an exponential power.
	 * 
	 * @param a The base
	 * @param b The exponential power
	 * @return The result of the power
	 */

	public static double pow(double a, int b) {
		return Math.pow(a, b);
	}

	/**
	 * Finds the area of a circle with the given radius.
	 * 
	 * @param radius The radius of the circle
	 * @return The area of the circle
	 */

	public static double areaOfCircle(float radius) {
		return pow(radius, 2) * PI;
	}

	/**
	 * Gets the circumference of the circle.
	 * 
	 * @param radius The radius of the circle
	 * @return The circumference of the circle
	 */

	public static double circumOfCircle(float radius) {
		return 2 * PI * radius;
	}

	/**
	 * Get the third side of a triangle with given two sides.
	 * 
	 * @param a The first side of the triangle
	 * @param b The second side of the triangle
	 * @return The hypotenuse of the triangle
	 */

	public static double solveForCSquared(float a, float b) {
		double cSquared = pow(a, 2) + pow(b, 2);

		return sqrt(cSquared);
	}

	/**
	 * Solve for the missing side given the hypotenuse.
	 * 
	 * @param s1 The first side of the triangle
	 * @param c  The hypotenuse of the triangle
	 * @return The missing side of the triangle
	 */

	public static double inverseCSquared(float s1, float c) {
		double s2Squared = pow(c, 2) - pow(s1, 2);

		return sqrt(s2Squared);
	}


    /**
     * This gives the solution to a quadratic equation.
     *
     * @param a The a coefficient
     * @param b The b coefficient
     * @param c The c coefficient
     * @return The solutions of the quadratic equation
     */

	public static double[] quadratic(double a, double b, double c) {

	    double[] v = new double[1];
	    v[0] = 0;

		if((discriminant(a , b, c) / -1) > discriminant(a, b, c)) {
		    v = new double[1];
		    v[0] = 0;
		    return v;
        }
        if(discriminant(a, b, c) == 0) {
            v = new double[1];
            v[0] = (-1 * b) / (2 * a);
            return v;
        }
        if(discriminant(a, b, c) > 0) {
            double solution1 = (-1 * b) + sqrt(discriminant(a, b, c)) / (2 * a);
            double solution2 = (-1 * b) - sqrt(discriminant(a, b, c)) / (2 * a);
            v = new double[2];
            v[0] = solution1;
            v[1] = solution2;

            return v;
        }

        return v;
	}

	public static int min(int[] arr) {
	    int min = Integer.MAX_VALUE;
        for (int number : arr) {
            if(number < min)
                min = number;
        }
        return min;
    }

    public static float min(float[] arr) {
        float min = Float.MAX_VALUE;
        for (float number : arr) {
            if(number < min)
                min = number;
        }
        return min;
    }

    public static long min(long[] arr) {
        long min = Long.MAX_VALUE;
        for (long number : arr) {
            if(number < min)
                min = number;
        }
        return min;
    }

    public static short min(short[] arr) {
        short min = Short.MAX_VALUE;
        for (short number : arr) {
            if(number < min)
                min = number;
        }
        return min;
    }

    public static byte min(byte[] arr) {
        byte min = Byte.MAX_VALUE;
        for (byte number : arr) {
            if(number < min)
                min = number;
        }
        return min;
    }

    public static int min(int[][] mat) {
	    int min = Integer.MAX_VALUE;
	    for(int[] number : mat) {
	        if(min(number) < min)
	            min = min(number);
        }
        return min;
    }

    public static float min(float[][] mat) {
        float min = Float.MAX_VALUE;
        for(float[] number : mat) {
            if(min(number) < min)
                min = min(number);
        }
        return min;
    }

    public static double min(double[][] mat) {
        double min = Double.MAX_VALUE;
        for(double[] number : mat) {
            if(min(number) < min)
                min = min(number);
        }
        return min;
    }

    public static long min(long[][] mat) {
        long min = Long.MAX_VALUE;
        for(long[] number : mat) {
            if(min(number) < min)
                min = min(number);
        }
        return min;
    }
    public static short min(short[][] mat) {
        short min = Short.MAX_VALUE;
        for(short[] number : mat) {
            if(min(number) < min)
                min = min(number);
        }
        return min;
    }

    public static byte min(byte[][] mat) {
        byte min = Byte.MAX_VALUE;
        for(byte[] number : mat) {
            if(min(number) < min)
                min = min(number);
        }
        return min;
    }

    public static int max(int[][] mat) {
        int max = Integer.MIN_VALUE;
        for(int[] number : mat) {
            if(max(number) > max)
                max = max(number);
        }
        return max;
    }
    public static float max(float[][] mat) {
        float max = Float.MIN_VALUE;
        for(float[] number : mat) {
            if(max(number) > max)
                max = max(number);
        }
        return max;
    }

    public static double max(double[][] mat) {
        double max = Double.MIN_VALUE;
        for(double[] number : mat) {
            if(max(number) > max)
                max = max(number);
        }
        return max;
    }
    public static long max(long[][] mat) {
        long max = Long.MIN_VALUE;
        for(long[] number : mat) {
            if(max(number) > max)
                max = max(number);
        }
        return max;
    }

    public static short max(short[][] mat) {
        short max = Short.MIN_VALUE;
        for(short[] number : mat) {
            if(max(number) > max)
                max = max(number);
        }
        return max;
    }

    public static byte max(byte[][] mat) {
        byte max = Byte.MIN_VALUE;
        for(byte[] number : mat) {
            if(max(number) > max)
                max = max(number);
        }
        return max;
    }


    public static double min(double[] arr) {
        double min = Double.MAX_VALUE;
        for (double number : arr) {
            if(number < min)
                min = number;
        }
        return min;
    }

    public static int max(int[] arr) {
	    int max = Integer.MIN_VALUE;
	    for(int number : arr) {
	        if(number > max)
	            max = number;
        }
        return max;
    }

    public static double max(double[] arr) {
        double max = Double.MIN_VALUE;
        for(double number : arr) {
            if(number > max)
                max = number;
        }
        return max;
    }

    public static float max(float[] arr) {
        float max = Integer.MIN_VALUE;
        for(float number : arr) {
            if(number > max)
                max = number;
        }
        return max;
    }

    public static long max(long[] arr) {
        long max = Long.MIN_VALUE;
        for(long number : arr) {
            if(number > max)
                max = number;
        }
        return max;
    }

    public static short max(short[] arr) {
        short max = Short.MIN_VALUE;
        for(short number : arr) {
            if(number > max)
                max = number;
        }
        return max;
    }

    public static byte max(byte[] arr) {
        byte max = Byte.MIN_VALUE;
        for(byte number : arr) {
            if(number > max)
                max = number;
        }
        return max;
    }



    /**
     * This gets the discriminant given the coefficients
     * of the quadratic equation.
     *
     * @param a The a coefficient
     * @param b The b coefficient
     * @param c The c coefficient
     * @return The discriminant
     */

	public static double discriminant(double a, double b, double c) {
	    return pow(b, 2) - (4 * a * c);
    }

}

