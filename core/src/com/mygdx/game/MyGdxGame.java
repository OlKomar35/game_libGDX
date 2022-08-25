package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {

  private SpriteBatch batch;
  private AnimationGame animationGame;
  private float time;
  private int animPositionX = 0;
  private boolean lookRight = true;

  @Override
  public void create() {
    batch = new SpriteBatch();
    animationGame = new AnimationGame("skeleton.png", 9, 4);
    time = 0f;

  }

  @Override
  public void render() {
    ScreenUtils.clear(1, 1, 1, 1);
    time += Gdx.graphics.getDeltaTime();
    animationGame.setTime(time);
    float x = animationGame.getFrame().getRegionX() + animationGame.getFrame().getRegionWidth() / 2f;

    if (animPositionX + 128 >= Gdx.graphics.getWidth()) {
      lookRight = false;
    }
    if (animPositionX <= 0) {
      lookRight = true;
    }
    if (!animationGame.getFrame().isFlipX() && !lookRight) {
      animationGame.getFrame().flip(true, false);
    }
    if (animationGame.getFrame().isFlipX() && lookRight) {
      animationGame.getFrame().flip(true, false);
    }
    if (lookRight) {
      animPositionX += 5;
    } else {
      animPositionX -= 5;
    }

    batch.begin();
    batch.draw(animationGame.getFrame(), animPositionX, 5);
    batch.end();
  }

  @Override
  public void dispose() {
    batch.dispose();
    animationGame.dispose();
  }
}
