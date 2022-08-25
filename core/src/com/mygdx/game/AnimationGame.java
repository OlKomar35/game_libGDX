package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationGame {

  private Texture img;
  private Animation<TextureRegion> animation;
  private float time;
  TextureRegion[] textureRegion1;
  TextureRegion[] textureGo;

  public AnimationGame(String name, int col, int row) {
    img = new Texture(name);
    TextureRegion textureRegion0 = new TextureRegion(img);
    TextureRegion[][] textureRegions0 = textureRegion0.split(textureRegion0.getRegionWidth() / col,
        textureRegion0.getRegionHeight() / row);
    textureRegion1 = new TextureRegion[textureRegions0.length * textureRegions0[0].length];
    int cnt = 0;
    for (int i = 0; i < textureRegions0.length; i++) {
      for (int j = 0; j < textureRegions0[0].length; j++) {
        textureRegion1[cnt++] = textureRegions0[i][j];
      }
    }
    textureGo = new TextureRegion[col];
    for (int j = 0; j < col; j++) {
      textureGo[j]=textureRegions0[3][j];
    }
    animation = new Animation<>(1/30.0f, textureGo);

    animation.setPlayMode(PlayMode.LOOP_PINGPONG);
    time += Gdx.graphics.getDeltaTime();
  }

  public TextureRegion getFrame() {
    return animation.getKeyFrame(time,true);
  }

  public void setTime(float time) {
    this.time = time;
  }

  public boolean isAnimationOver() {
    return animation.isAnimationFinished(time);
  }

  public void dispose() {
    img.dispose();
  }

}
