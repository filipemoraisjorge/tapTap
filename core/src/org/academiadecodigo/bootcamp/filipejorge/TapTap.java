package org.academiadecodigo.bootcamp.filipejorge;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class TapTap extends ApplicationAdapter {

    private final float WIDTH = 800;
    private final float HEIGHT = 480;
    private OrthographicCamera camera;
    private SpriteBatch batch;


    private Circle markPlayer1;
    private Circle markPlayer2;

    private ShapeRenderer shapeRenderer;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, WIDTH, HEIGHT);
        markPlayer1 = new Circle();
        markPlayer2 = new Circle();
        markPlayer1.radius = 30;
        markPlayer2.radius = 30;

        shapeRenderer = new ShapeRenderer();

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.0f, 0.1f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(0, 1, 0.5f, 1);
        shapeRenderer.line(WIDTH / 2, HEIGHT, WIDTH / 2, 0);
        shapeRenderer.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(0, 0.7f, 1, 1);
        shapeRenderer.circle(100, 100, markPlayer1.radius);
        shapeRenderer.circle(WIDTH - 100, HEIGHT - 100, markPlayer2.radius);
        shapeRenderer.end();

       /* Gdx.graphics.setContinuousRendering(false);
        Gdx.graphics.requestRendering();*/

        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            markPlayer1.y = touchPos.y - WIDTH / 2;
            System.out.println("--------t---------");
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            System.out.println("#####L#####");
            markPlayer1.y -= 20 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            markPlayer1.y += 20 * Gdx.graphics.getDeltaTime();
            System.out.println("*******R******");
        }

        if (markPlayer1.x < 0) markPlayer1.x = 0;
        if (markPlayer1.x > WIDTH - 64) markPlayer1.x = WIDTH - 64;

        /*Gdx.graphics.requestRendering();*/
    }
}
