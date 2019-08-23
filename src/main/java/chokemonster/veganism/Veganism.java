package chokemonster.veganism;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Reference.MODID)
public class Veganism {

    public static final Logger OUTSIDEVANILLALOGGER = LogManager.getLogger();

    public static void sendHiVisInfo(String message) {
        OUTSIDEVANILLALOGGER.info("\n\n" + message + "\n");
    }

    public static void sendHiVisDebug(String message) {
        OUTSIDEVANILLALOGGER.debug("\n\n" + message + "\n");
    }
}