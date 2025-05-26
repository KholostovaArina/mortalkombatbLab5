package fighter.bosses;

import fighter.Enemy;

public abstract class Boss extends Enemy {

    public Boss() {
        super();
        this.damage = 75;
        this.maxHp = 300;
        this.type = "Босс";
        this.numberType = this.getBehaviorType(this.type);
        calculateInfo(this.level);
    }

    private void calculateInfo(int level) {
        switch (level) {
            case 0 ->  {
                this.damage = 75;
                this.maxHp = 300;
            }
            case 1 ->  {
                this.damage = 100;
                this.maxHp = 225;
            }
            case 2 ->  {
                this.damage = 115;
                this.maxHp = 250;
            }
            case 3 ->  {
                this.damage = 130;
                this.maxHp = 275;
            }
            case 4 ->  {
                this.damage = 145;
                this.maxHp = 300;
            }
            case 5 ->  {
                this.damage = 160;
                this.maxHp = 325;
            }
            default -> throw new IllegalArgumentException("Некорректный уровень: " + level);
        }
        this.currentHp = this.maxHp;
    }

    @Override
    public void setLevel(int level) {
        super.setLevel(level);
        calculateInfo(level);
    }
}

