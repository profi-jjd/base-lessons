package com.profi.jjd.lesson7;

//import com.profi.jjd.lesson7.utils.Randoms;

// статический импорт
// import static com.profi.jjd.lesson7.Settings.GOLD_COUNT;

import static com.profi.jjd.lesson7.utils.Randoms.*;
import static com.profi.jjd.lesson7.Settings.*;
import static com.profi.jjd.lesson7.utils.Randoms.getRandomInt;

final public class King extends Unit{
    private int gold = GOLD_COUNT; // Settings.GOLD_COUNT;
    private BattleUnit[] army;

    public King() {
        super(KING_HEALTH);
        generateArmy();
    }

    private void generateArmy(){  // стоимость армии 200
        army = new BattleUnit[ARMY_COUNT];
        if (gold < ARMY_PRICE) return;
        for (int a = 0; a < army.length; a++) {
            army[a] = BattleUnit.getBattleUnit();
        }
        minusGold(ARMY_PRICE);
    }
    // стоимость каждого юнита 20
    public void addUnits(){
        for (int i = 0; i < army.length; i++) {
            if (army[i].isAlive()) continue;
            if ((gold - UNIT_PRICE) < 0) return;
            army[i] = BattleUnit.getBattleUnit();
            minusGold(UNIT_PRICE);
        }
    }

    public void startBattle(King enemy){
        for (int i = 0; i < army.length; i++) {
            int thisIndex = getRandomInt(army.length);
            int enemyIndex = getRandomInt(army.length);
            if (!army[thisIndex].isAlive() ||
                    !enemy.army[enemyIndex].isAlive()) continue;
            army[thisIndex].attack(enemy.army[enemyIndex]);
            army[thisIndex].rest();
            if (!enemy.army[enemyIndex].isAlive()) continue;
            enemy.army[enemyIndex].attack(army[thisIndex]);
            enemy.army[enemyIndex].rest();
        }
    }

    public int getBattleResult(){
        int count = 0;
        for (BattleUnit battleUnit : army) {
            if (battleUnit.isAlive()) count++;
        }
        return count;
    }

    private boolean hasGold(){
        return gold > 0;
    }

    private void plusGold(int count) {
        gold += count;
    }

    private void minusGold(int count) {
        if (!hasGold()) return;
        gold -= count;
    }

    @Override
    public void rest() {
        minusGold(50);
        plusHealth(10);
    }

}
