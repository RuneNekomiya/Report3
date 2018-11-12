package jp.ac.uryukyu.ie.tnal;

public class Hero extends LivingThing {
    public Hero (String name, int maximumHP, int attack) {
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
            System.out.printf("勇者%sは道半ばで力尽きてしまった。\n", super.getName());
        }
    }

}
