package lab2.moves.status;

import ru.ifmo.se.pokemon.*;

public class LightScreenAttack extends StatusMove {

    public LightScreenAttack() {
        super(Type.PSYCHIC, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        super.applySelfEffects(p);

        Effect e = new Effect().stat(Stat.SPECIAL_ATTACK, (int) (p.getStat(Stat.SPECIAL_ATTACK) * 0.5)).turns(5);
        p.addEffect(e);

    }

    @Override
    protected String describe() {
        return "создает защитный световой экран Light Screen!";
    }
}
