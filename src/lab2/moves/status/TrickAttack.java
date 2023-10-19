package lab2.moves.status;

import ru.ifmo.se.pokemon.*;

public class TrickAttack extends StatusMove {
    public TrickAttack() {
        super(Type.PSYCHIC, 0, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon opponent) {
        opponent.setMod(Stat.ATTACK, -1); // *Должен меняться предметами с целью
    }

    @Override
    protected String describe() {
        return "использует Trick!";
    }
}
