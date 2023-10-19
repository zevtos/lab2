package lab2.pokemons;

import lab2.moves.special.*;
import lab2.moves.status.*;
import ru.ifmo.se.pokemon.*;

public class Breloom extends Pokemon {
    public Breloom(String name, int level) {
        super(name, level);
        setStats(60, 130, 80, 60, 60, 70);
        setType(Type.GRASS, Type.FIGHTING);
        setMove(
                new ThunderShockAttack(),
                new IceBeamAttack(),
                new EruptionAttack(),
                new LightScreenAttack()
        );
    }
}
