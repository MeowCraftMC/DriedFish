package al.yn.driedfish;

import al.yn.driedfish.api.IFishAPI;
import al.yn.driedfish.timer.FishTimer;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.plugin.*;
import org.bukkit.plugin.java.annotation.plugin.author.Author;

@Plugin(name = "DriedFish", version = "1.0.0")
@Description("Cats love dried fish.")
@Author("qyl27")
@LogPrefix("DriedFish")
@Website("https://github.com/MeowCraftMC/DriedFish")
@ApiVersion(ApiVersion.Target.v1_18)
public final class DriedFish extends JavaPlugin implements IFishAPI {
    private static DriedFish INSTANCE;

    private static final boolean isDev = Boolean.parseBoolean(System.getenv().getOrDefault("fish.dev", "false"));

    private FishTimer timer;

    public DriedFish() {
        INSTANCE = this;

        timer = new FishTimer();
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Meow~");

        timer.run();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        timer.stop();
    }

    public static DriedFish getInstance() {
        return INSTANCE;
    }

    @Override
    public FishTimer getTimer() {
        return timer;
    }
}
