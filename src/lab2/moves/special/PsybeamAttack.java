package lab2.moves.special;

import ru.ifmo.se.pokemon.*;
import lab2.MyPokemon;

public class PsybeamAttack extends SpecialMove {

    public PsybeamAttack() {
        super(Type.PSYCHIC, 65, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        super.applyOppEffects(p);
        Effect e = new Effect().chance(0.1);
        p.addEffect(e);

    }

    @Override
    protected String describe() {
        return "выпускает мощный психический луч и атакует врагов Psybeam!";
    }
}