package lab2.moves.special;

import lab2.MyPokemon;
import ru.ifmo.se.pokemon.*;

public class BlizzardAttack extends SpecialMove {
    public BlizzardAttack() {
        super(Type.ICE, 110, 70);
    }


    @Override
    protected void applyOppEffects(Pokemon p) {
        boolean targetImmune = p.hasType(Type.ICE);

        Effect e = new Effect().condition(Status.FREEZE).chance(0.1);
        if (!targetImmune)
            p.addEffect(e);
    }


    @Override
    protected String describe() {
        return "использует Blizzard!";
    }
}