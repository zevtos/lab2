package lab2.moves.special;

import lab2.MyPokemon;
import ru.ifmo.se.pokemon.*;

public class ThunderboltAttack extends SpecialMove {

    public ThunderboltAttack() {
        super(Type.ELECTRIC, 90, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        super.applyOppEffects(p);
        boolean targetImmune = p.hasType(Type.ELECTRIC);
        Effect e = new Effect().chance(0.1).condition(Status.PARALYZE);
        if (!targetImmune) p.addEffect(e);
    }

    @Override
    protected String describe() {
        return "использует Thunderbolt!";
    }
}