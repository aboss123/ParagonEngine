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

import GameKit.SCRIPT.Script;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


/**
 * This is a utilities class that will take care of most of
 * the normal utilities needs that will be needed throughout
 * this framework as well as when making the games.
 * @author Ashish Bailkeri
 *
 */

public class Content {

	public Content() {}


	/**
	 * Normally prints out a new line.
	 */

	public static void print() {
		System.out.println();
	}


	/**
	 * Print out a String.
	 * 
	 * @param s The String
	 */

	public static void print(String s) {
		System.out.println(s);
	}

	/**
	 * Print out a Boolean.
	 * 
	 * @param s The Boolean
	 */

	public static void print(boolean s) {
		System.out.println(s);
	}

	/**
	 * Print out a Character.
	 * 
	 * @param s The Character
	 */

	public static void print(char s) {
		System.out.println(s);
	}

	/**
	 * Print out a Integer.
	 * 
	 * @param s The Integer
	 */

	public static void print(int s) {
		System.out.println(s);
	}

	/**
	 * Print out a Double.
	 * 
	 * @param s The Double
	 */

	public static void print(double s) {
		System.out.println(s);
	}

	/**
	 * Print out a Long.
	 * 
	 * @param s The Long
	 */

	public static void print(long s) {
		System.out.println(s);
	}

	/**
	 * Print out a Float.
	 * 
	 * @param s The Float
	 */

	public static void print(float s) {
		System.out.println(s);
	}

	/**
	 * Print out an Object.
	 * 
	 * @param s The Object
	 */

	public static void print(Object s) {
		System.out.println(s);
	}

	/**
	 * Load any file as a string to process later.
	 * 
	 * @param path The image to parsed to a String
	 * @return The file as a string
	 */

	public static String loadFileAsString(String path) {
		StringBuilder builder = new StringBuilder();

		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while ((line = br.readLine()) != null)
				builder.append(line + "\n");
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return builder.toString();
	}

	/**
	 * Parse integers within a file.
	 * 
	 * @param number The number to parse
	 * @return The parsed integer
	 */

	public static int parseInt(String number) {
		try {
			return Integer.parseInt(number);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.err.print("Could not parse int!");
			return 0;
		}
	}

    /**
     * Number of times an element is inside a string.
     *
     * @param s The String to retrieve the element
     * @param element The element to retrieve
     * @return The number of times the given element is in the string
     */

	public static int getElement(String s, String element) {
        int count = 0;
        for (int i = 0; i < s.split("\\s").length; i++) {
            if(s.split(" ")[i].equals(element)) count++;
        }
        return count;
    }

	/**
	 * Loads in an image with the given path.
	 * 
	 * @param path The file path to load the image
	 * @return The image
	 */

	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Could not load file!");
			System.exit(1);
		}
		return null;
	}

	/**
	 * Loads a resource with the given path.
	 *
	 * @param path The file path to load the resource
	 * @return The resource
	 */

	public BufferedImage loadResource(String path) {
		try {
			return ImageIO.read(getClass().getResourceAsStream(path));
		}
		catch(IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Generates a random number.
	 * 
	 * @param min The minimum for the range
	 * @param max The maximum for the range
	 * @return The random number
	 */

	public static double random(int min, int max) {
		int range = (max - min) + 1;

		return (Math.random() * range) + min;
	}

    /**
     * Generates a random number.
     *
     * @param min The minimum for the range
     * @param max The maximum for the range
     * @return The random number
     */

    public static double random(double min, double max) {
        double range = (max - min) + 1;

        return (Math.random() * range) + min;
    }

    /**
     * Generates a random number.
     *
     * @param min The minimum for the range
     * @param max The maximum for the range
     * @return The random number
     */

    public static double random(float min, float max) {
        double range = (max - min) + 1;

        return (Math.random() * range) + min;
    }

    /**
     * Generates a random number.
     *
     * @param min The minimum for the range
     * @param max The maximum for the range
     * @return The random number
     */

    public static double random(long min, long max) {
        double range = (max - min) + 1;

        return (Math.random() * range) + min;
    }

    /**
     * Generates a random number.
     *
     * @param min The minimum for the range
     * @param max The maximum for the range
     * @return The random number
     */

    public static double random(byte min, byte max) {
        double range = (max - min) + 1;

        return (Math.random() * range) + min;
    }

    /**
     * Parse a given expression in a string.
     *
     * @param equation The equation to parse
     * @return the result of the expression
     */

    public static double parseExpression(String equation) {
    	return Script.eval(equation);
	}

	
	/**
	 * An enhanced version of drawing a string to the screen. It
	 * draws the string to the center and requires a difference
	 * in Y to position it correctly.
	 * 
	 * @param g The graphics component
	 * @param s The string
	 * @param yDifference The difference in Y for positioning
	 */
	
	public static void drawString(Graphics2D g, String s, int yDifference) {
		
		int sX = getCenterX(g, s);
		int sY = getCenterY(g, s);
		
		g.drawString(s, sX, (sY - yDifference));	
	}

	/**
	 * An enhanced version of drawing a string to the screen. It
	 * draws the string to the center and requires a difference
	 * in Y to position it correctly. This version adds a font
     * to the string.
	 *
	 * @param g The graphics component
	 * @param s The string
	 * @param font The font of the string
	 * @param yDifference The difference in Y for positioning
	 */

	public static void drawString(Graphics2D g, String s, Font font, int yDifference) {

		int sX = getCenterX(g, s);
		int sY = getCenterY(g, s);

		g.setFont(font);
		g.drawString(s, sX, (sY - yDifference));
	}

    /**
     * An enhanced version of drawing a string to the screen. It draws
     * the string to the center and requires a difference in Y to
     * position it properly. This version adds a color to the font
     * that is giver.
     *
     * @param g The graphics component
     * @param s The string to draw
     * @param font The {@link Font} to apply to the string
     * @param c The {@link Color} to apply to the font
     * @param yDifference The difference in Y for positioning
     */

	public static void drawString(Graphics2D g, String s, Font font, Color c, int yDifference) {

	    int sX = getCenterX(g, s);
	    int sY = getCenterY(g, s);

        RenderAPI renderer = new RenderAPI(g);
        renderer.setFont(font, c);
        g.drawString(s, sX, (sY - yDifference));
    }
	
	/**
	 * Gets the center X of a string
	 * 
	 * @param g The graphics component
	 * @param s The string
	 * @return The center X
	 */
	
	private static int getCenterX(Graphics2D g, String s) {
		FontMetrics f = g.getFontMetrics();
		
		int width = AbstractGame.getWindow().getWidth();
		
		int x = (width - f.stringWidth(s)) / 2;
		
		return x;
	}
	
	/**
	 * Gets the center Y of a string
	 * 
	 * @param g The graphics component
	 * @param s The string
	 * @return The center Y
	 */
	
	private static int getCenterY(Graphics2D g, String s) {
		FontMetrics f = g.getFontMetrics();
		
		int height = AbstractGame.getWindow().getHeight();
		
		int y = (f.getAscent() + (height - f.getAscent() + f.getDescent())) / 2;
		
		return y;
	}

}

