package jp.ac.uryukyu.ie.tnal;

public class Enemy extends LivingThing {
    public Enemy (String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
    }

    @Override
    public void wounded(int damage){
        //被弾処理だが、privateにしている変数群が拒否反応を起こした。なぜ。
        //こいつもgetter/setter化するのか...
        int hitPoint = getHitPoint();
        hitPoint -= damage;
        setHitPoint(hitPoint);

        if( hitPoint < 0 ) {
            setDead(true);
            System.out.printf("モンスター%sは倒れた。\n", super.getName());
        }
    }

}
