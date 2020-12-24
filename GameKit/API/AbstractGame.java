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

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.lang.annotation.Annotation;

/**
 * This the main class that contains all the main functions in order to run this
 * framework.
 * 
 * @author Ashish Bailkeri
 *
 */

public abstract strictfp class AbstractGame implements Runnable {

	/**
	 * This variable represents whether the main thread is running. It is set to
	 * false automatically to be initialized.
	 */
	private boolean running = false;

	/**
	 * This is the variable for the thread. It is stated using the keyword volatile
	 * because only one thread should access this thread variable.
	 */

	private volatile Thread thread = null;

	/**
	 * This is the variable for the window representation to be used for
	 * initializing the @GameWindow annotation variables.
	 */

	public static GFWindow window;

	/**
	 * This is the variable that is initialized that is the handler for the J2D part
	 * of the JavaGameKit.
	 */

	public static final App2D app2D = new App2D();

	/**
	 * This is the graphics variable that represents Graphics2D.
	 */

	protected Graphics2D j;

    /**
     * This is the graphics variable that is Frost2D which is a form of Graphics2D.
     */

	protected Frost2D renderer;

	/**
	 * This represents the BufferStrategy for the advanced drawing function.
	 */

	protected BufferStrategy bs;

	/**
	 * This variable represents the access to keys and the inputs of the player.
	 */

	public static KeyHandler keys = new KeyHandler();

    /**
     * This represents width of the window.
     */

    public static int width;

    /**
     * This represents the height of the window.
     */

    public static int height;

	/**
	 * This represents an instance of the game camera.
	 */

	public static GameCamera camera;


	public static World world;


	/**
	 * This the constructor of the JavaGameKit which takes in the parameters of to
	 * create a new game.
	 * 
	 * @param gameDeveloper The name of the game developer
	 * @param gameVersion   The game version that is being pushed through the JGK
	 */

	public AbstractGame(String gameDeveloper, float gameVersion) {
		Content.print("[Paragon] Developer: " + gameDeveloper + " Version: " + gameVersion);
	}

	/**
	 * Default constructor.
	 */
	public AbstractGame() {
	}

	/**
	 * Initialize the J2D through the thread to be overridden.
	 */

	protected synchronized void init2D() {

	}

	/**
	 * Initialize the J3D through the thread to be overridden.
	 */

	protected synchronized void init3D() {

	}

	/**
	 * Update 2D through the thread to be overridden.
	 */

	private synchronized void update2D() {

        // Update the keys
        keys.update();

        // States
        if(StateObject.getCurrentState() != null)
            StateObject.getCurrentState().update();
	}

	/**
	 * Update the J3D through the thread to be overridden.
	 */

	protected synchronized void update3D() {

	}

	/**
	 * Render the J2D through the thread to be overridden.
	 */

	private synchronized void render2D() {
        bs = AbstractGame.getWindow().getCanvas().getBufferStrategy();
        if (bs == null) {
            AbstractGame.getWindow().getCanvas().createBufferStrategy(3);
            return;
        }

        j = (Graphics2D) bs.getDrawGraphics();
        renderer = new RenderAPI(j);

        // Clear Screen
        renderer.fillRect(0, 0, 100000, 100000);

        renderer.translateCamera(camera);

        j.drawImage(AbstractGame.getWindow().getImage(),
                0, 0, AbstractGame.getWindow().getCanvas().getWidth(),
                AbstractGame.getWindow().getCanvas().getHeight() + 16, null);

        // States
        if(StateObject.getCurrentState() != null)
            StateObject.getCurrentState().render(renderer);

        renderer.translateCamera(-camera.getXTransfer(), -camera.getYTransfer());

        // End Drawing!
        bs.show();
        renderer.destroy();
	}

	/**
	 * Render 3D through the thread to be overridden.
	 */

	protected synchronized void render3D() {

	}

	/**
	 * Get the game window.
	 * 
	 * @return The game window.
	 */

	public static GFWindow getWindow() {
		return window;
	}

    /**
     * Gets the game camera.
     *
     * @return The game camera
     */

	public static GameCamera getCamera() {
	    return camera;
    }

    /**
     * Gets the world.
     *
     * @return The world
     */

    public static World getWorld() {
	    return world;
    }

    /**
     * Sets the world.
     *
     * @param world Sets the world
     */

    public static void setWorld(World world) {
        AbstractGame.world = world;
    }

	/**
	 * Draw one static image to the screen.
	 * 
	 * @param x      The X of the drawn image
	 * @param y      The Y of the drawn image
	 * @param width  The width of the drawn image
	 * @param height The height of the drawn image
	 * @param img    This is the BufferedImage that represent what will be drawn.
	 */

	public void draw(int x, int y, int width, int height, BufferedImage img) {
		bs = AbstractGame.getWindow().getCanvas().getBufferStrategy();
		if (bs == null) {
			AbstractGame.getWindow().getCanvas().createBufferStrategy(3);
			return;
		}
		j = (Graphics2D) bs.getDrawGraphics();

		// Clear Screen
		j.clearRect(0, 0, 1000, 1000);

		// Draw
		j.drawImage(img, x, y, width, height, null);

		// End Drawing!
		bs.show();
		j.dispose();
	}


	/**
	 * This is the overridden function that will initialize the framework and all
	 * the other sub-frameworks such as J2D and J3D.
	 */

	@Override
	public void run() {

		// Initialize Framework
		initEngine();

        // Initialize 2D
        AbstractGame.getWindow().getFrame().addKeyListener(keys);

		// init2D
		init2D();

		// Initialize 3D
		init3D();

		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {

				// Update J2D
				update2D();
				render2D();

				// Update J3D
				update3D();
				render3D();
				ticks++;
				delta--;
			}

			// Print the frames
			if (timer >= 1000000000) {
				Content.print("Paragon | Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		stop();
	}

	/**
	 * This is the default serial id for any game created using this framework and
	 * there are a lot of parts to it.
	 */

	private static final transient long gameSerialID = 234342394L;

	/**
	 * This represents the developer name of the JGK (Java Game Kit).
	 */

	private static final transient String developer = "Ashish Bailkeri";

	/**
	 * This represents the constant version update that will be occurring when new
	 * updates are pushed to the framework.
	 */

	private static final transient float version = 0.04f;

	
	/**
	 * Use for authority purposes for the engine. It is utilized to show who created
	 * the engine and list it's version to those who are currently using it.
	 */

	private synchronized void initEngine() {
		System.out.println("Paragon- Light Weight Java Game Framework");
		System.out.println("Developer: " + developer);
		System.out.println("ID: " + gameSerialID);
		System.out.println("Version: " + version);
	}

	/**
	 * This initializes the Game annotation.
	 * 
	 * @param o (Object input that is needed in the specified class)
	 */

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static synchronized void initAnnotation(Object... o) {
		try {
			for (int i = 0; i < o.length; i++) {
				Class c = o[i].getClass();

				Annotation a = c.getAnnotation(GameWindow.class);
				GameWindow g2 = (GameWindow) a;

				width = g2.width();
				height = g2.height();
				window = new GFWindow(g2.title(), g2.width(), g2.height());
			}
		} catch (NullPointerException e) {
			Content.print("FILES LISTED DO NOT HAVE ANNOTATION | PASS");
		}
	}

	/**
	 * This starts the thread with variable running.
	 */

	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	/**
	 * This ends the thread using the variable running.
	 */

	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
