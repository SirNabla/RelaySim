package com.relay.sim;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;

public class Navigation implements InputProcessor {
    public final Camera camera;
    private Vector2 viewPortSize;

    public Navigation(){
        Gdx.input.setInputProcessor(this);
        viewPortSize = new Vector2(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera = new OrthographicCamera(viewPortSize.x, viewPortSize.y);
    }

    public Matrix4 cameraProjection(){
        return camera.combined;
    }

    public void cameraUpdate(){
        Vector2 newViewPortSize = new Vector2(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        if(!viewPortSize.equals(newViewPortSize)){
            viewPortSize = newViewPortSize;
            camera.viewportWidth = viewPortSize.x;
            camera.viewportHeight = viewPortSize.y;
        }
        camera.update();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        if(Gdx.input.isButtonPressed(Input.Buttons.MIDDLE))
            camera.position.add( -Gdx.input.getDeltaX(),  Gdx.input.getDeltaY(), 0);
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
