package lab2.moves.special;

import ru.ifmo.se.pokemon.*;

public class EruptionAttack extends SpecialMove {
    public EruptionAttack() {
        super(Type.FIRE, 150, 100);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        Pokemon copy = p;
        copy.restore();
        p.addEffect(new Effect().stat(Stat.ATTACK, (int) (150 * p.getHP() / copy.getHP())));
    }

    @Override
    protected String describe() {
        return "создает мощное извержение огня Eruption!";
    }
}