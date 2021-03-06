package jp.ac.uryukyu.ie.tnal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//ここはどこを参照しているのでしょうね？

class EnemyTest {

    @Test
    public void attack() {
        System.out.println("テストするぞい(^^)");

        int heroHP = 0;
        Hero hero = new Hero("テスト勇者", heroHP, 5);
        Enemy enemy = new Enemy("テストスライム", 6, 3);
        enemy.setDead(true);
        for(int i=0; i<10; i++) {
            enemy.attack(hero); //乱数で0ダメージとなることもあるため、複数回実行してみる。
        }
        assertEquals(heroHP, hero.getHitPoint());
    }

}