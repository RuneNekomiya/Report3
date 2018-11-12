package jp.ac.uryukyu.ie.tnal;

public class LivingThing {
    String name;
    int hitPoint;
    int attack;
    boolean dead;

    public LivingThing (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, hitPoint, attack);
    }

    public String getName(){ return name; }
    public boolean isDead() { return dead; }

    public void attack(LivingThing opponent){ //opponentは敵方のクラスとして参照
        //『Enemyクラスではheroを攻撃、Heroクラスではenemyを攻撃するようにしていたが、共通クラスとして作成している本クラスを対象に攻撃するように変更しよう。』
        //この一文を読んだ時に「相手を殴る処理から、相手に殴られる処理に変えるの？！」と戸惑い果てて３時間
        //殴られる処理に変えたらenemy.wounded()、hero.wounded()、EnemyTest、全方位でバグが多発したので「殴る処理じゃんやっぱり！」と結論が出ました
        //仕様変更したらバグが多発して大変だという良い経験になったと思っておきます...orz
        if(!dead){
            int damage = (int)(Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name , opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    public void wounded(int damage){
        //woundedはダメージ処理だけ
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }

}
