package com.praneeth.flappybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FlappyBird extends ApplicationAdapter {
    SpriteBatch batch;
    Texture background;
    Texture[] birds;
    int flap_state = 0;
    float birdY = 0;
    float velocity = 0;
    int game_state = 0;
    float gravity = 2;

    @Override
    public void create() {
        batch = new SpriteBatch();
        background = new Texture("bg.png");
        birds = new Texture[2];
        birds[0] = new Texture("bird.png");
        birds[1] = new Texture("bird2.png");
        birdY = Gdx.graphics.getHeight() / 2 - (birds[0].getHeight() / 2);

    }

    @Override
    public void render() {
        if (Gdx.input.justTouched()){
            game_state = 1;
        }
        if (game_state == 1) {

            if (Gdx.input.justTouched()){
                velocity = -30;
            }
            velocity += gravity;
            birdY = birdY - velocity;
            if (flap_state == 0) {
                flap_state = 1;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flap_state = 0;
            }
        }
            batch.begin();
            batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            batch.draw(birds[flap_state], Gdx.graphics.getWidth() / 2 - (birds[flap_state].getWidth() / 2),
                    birdY);
            batch.end();

        }
    }

