package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {

  private SpriteBatch batch;
  private AnimationGame animationGame;

  @Override
  public void create() {
    batch = new SpriteBatch();
    animationGame = new AnimationGame("skeleton.png", 9, 4);
  }

  @Override
  public void render() {
    ScreenUtils.clear(1, 1, 1, 1);
    animationGame.setTime(Gdx.graphics.getDeltaTime());
    float x = Gdx.input.getX() - animationGame.getFrame().getRegionWidth() / 2;
    float y= Gdx.graphics.getHeight()-Gdx.input.getY()-animationGame.getFrame().getRegionHeight()/2;
    if(!animationGame.getFrame().isFlipX()){animationGame.getFrame().flip(true,false);}
    batch.begin();
    batch.draw(animationGame.getFrame(), 5, 5);
    batch.draw(animationGame.getFrame(), 150, 150);
    batch.end();
  }

  @Override
  public void dispose() {
    batch.dispose();
    animationGame.dispose();
  }
}
