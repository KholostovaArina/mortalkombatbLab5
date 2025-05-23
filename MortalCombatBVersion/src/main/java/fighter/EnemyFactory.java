package fighter;

import fighter.bosses.ShaoKahn;
import fighter.fighters.SubZero;
import fighter.soldiers.Kitana;
import fighter.tanks.Baraka;
import fighter.tanks.SonyaBlade;
import fighter.wizards.LiuKang;

public class EnemyFactory {

    public Enemy createEnemy(int number) {
        switch(number) {
            case 1 -> {
                return new Baraka();
            }
            case 2 -> {
                return new SonyaBlade();
            }
            case 3 -> {
                return new SubZero();
            }
            case 4 -> {
                return new LiuKang();
            }
            case 5 -> {
                return new Kitana();
            }
            case 6 -> {
                return new ShaoKahn();
            }
            default -> throw new IllegalArgumentException("Неизвестный тип врага");
        }
    }
}
