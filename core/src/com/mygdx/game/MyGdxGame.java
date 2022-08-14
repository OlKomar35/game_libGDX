package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {

  SpriteBatch batch;
  Texture img;
  float x;
  float y;

  @Override
  public void create() {
    batch = new SpriteBatch();
    img = new Texture("games_hero.png");
    }

  @Override
  public void render() {
    ScreenUtils.clear(1, 1, 1, 1);

    x = Gdx.input.getX() - img.getWidth() / 2;
    y = Gdx.graphics.getHeight() - Gdx.input.getY() - img.getHeight() / 2;

    batch.begin();
    batch.draw(img, x, y);
    batch.end();
  }

  @Override
  public void dispose() {
    batch.dispose();
    img.dispose();
  }
}
