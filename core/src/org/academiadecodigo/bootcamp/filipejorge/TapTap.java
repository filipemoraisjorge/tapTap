package org.academiadecodigo.bootcamp.filipejorge;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

public class TapTap extends ApplicationAdapter {

    private final float WIDTH = 800;
    private final float HEIGHT = 480;
    private OrthographicCamera camera;
    private SpriteBatch batch;


    private Circle markPlayer1;
    private Circle markPlayer2;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, WIDTH, HEIGHT);

        markPlayer1.radius = 60;
        markPlayer2.radius = 60;

        Rectangle line = new Rectangle(WIDTH / 2, HEIGHT, HEIGHT, 5);

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.graphics.setContinuousRendering(false);
        Gdx.graphics.requestRendering();
        camera.update();
    }
}
