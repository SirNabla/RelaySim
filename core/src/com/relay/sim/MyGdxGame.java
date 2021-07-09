package com.relay.sim;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter{
	SpriteBatch batch;
	Texture img;
	Navigation navigation;
	float x = 1, y;
	Sprite sprite;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		navigation = new Navigation();
		sprite = new Sprite(img);
	}

	@Override
	public void render () {
		navigation.cameraUpdate();

		ScreenUtils.clear(0, 0, 0, 1);
		batch.setProjectionMatrix(navigation.cameraProjection());
		batch.begin();
		sprite.draw(batch);
		batch.end();

		System.out.println("resolution = " + Gdx.graphics.getWidth() + "x " +  Gdx.graphics.getHeight());

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
