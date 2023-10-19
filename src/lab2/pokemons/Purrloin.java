package lab2.pokemons;

import lab2.moves.special.*;
import ru.ifmo.se.pokemon.*;

public class Purrloin extends Pokemon {
    public Purrloin(String name, int level) {
        super(name, level);
        setStats(41, 50, 37, 50, 37, 66);
        setType(Type.DARK);
        setMove(
                new ThunderShockAttack(),
                new IceBeamAttack(),
                new EruptionAttack()
        );
    }
}
