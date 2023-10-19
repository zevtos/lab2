package lab2.pokemons;

import lab2.moves.special.*;
import lab2.moves.status.*;
import ru.ifmo.se.pokemon.*;

public class Hoppip extends Pokemon {
    public Hoppip(String name, int level) {
        super(name, level);
        setStats(35, 35, 40, 35, 55, 50);
        setType(Type.GRASS, Type.FLYING);
        setMove(
                new BlizzardAttack(),
                new ThunderboltAttack(),
                new TrickAttack(),
                new PsybeamAttack()
        );
    }
}
