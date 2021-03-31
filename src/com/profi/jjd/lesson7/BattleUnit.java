package com.profi.jjd.lesson7;

import com.profi.jjd.lesson7.utils.Randoms;

abstract public class BattleUnit
        extends Unit implements AttackAble{
    private int attackScore;

    public BattleUnit(int healthScore, int attackScore){
        super(healthScore); // вызов конструктора родителя
        this.attackScore = attackScore;
    }

    public int getAttackScore() {
        return attackScore;
    }

    public static BattleUnit getBattleUnit(){
        String[] types = {"knight", "infantry"};
        BattleUnit unit = null;
        switch (types[Randoms.getRandomInt(types.length)]) {
            case "knight":
                unit = new Knight(
                        Randoms.getRandomInt(10, 30),
                        Randoms.getRandomInt(10, 50));
                break;
            case "infantry":
                unit = new Infantry(
                        Randoms.getRandomInt(10, 60),
                        Randoms.getRandomInt(10, 40));
                break;
        }
        return unit;
    }
}
