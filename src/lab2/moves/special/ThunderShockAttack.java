package lab2.moves.special;

import lab2.MyPokemon;
import ru.ifmo.se.pokemon.*;

public class ThunderShockAttack extends SpecialMove {

    public ThunderShockAttack() {
        super(Type.ELECTRIC, 40, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        boolean targetImmune = p.hasType(Type.ELECTRIC);
        Effect e = new Effect().condition(Status.PARALYZE).chance(0.1);
        if (!targetImmune) p.addEffect(e);
    }

    @Override
    protected String describe() {
        return "запускает маленькую электрическую атаку Thunder Shock!";
    }
}