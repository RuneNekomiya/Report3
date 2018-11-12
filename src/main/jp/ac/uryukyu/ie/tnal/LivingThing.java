package jp.ac.uryukyu.ie.tnal;

public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    public LivingThing (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, hitPoint, attack);
    }

    public String getName(){ return name; }
    public int getHitPoint(){  return hitPoint; }
    public void setHitPoint(int hitPoint){ this.hitPoint = hitPoint; }
    public boolean isDead() { return dead; }
    public void setDead(boolean dead){ this.dead = dead; }

    public void attack(LivingThing opponent){ //opponentは敵方のクラスとして参照
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
