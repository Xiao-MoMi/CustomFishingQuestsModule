package net.momirealms.customfishing.quests;

import me.pikamug.quests.Quests;
import me.pikamug.quests.module.BukkitCustomObjective;
import me.pikamug.quests.quests.Quest;
import net.momirealms.customfishing.api.event.FishingResultEvent;
import net.momirealms.customfishing.api.mechanic.loot.Loot;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.Map;

public class IDQuest extends BukkitCustomObjective implements Listener {

    Quests qp = (Quests) Bukkit.getServer().getPluginManager().getPlugin("Quests");

    public IDQuest() {
        this.setName("CustomFishing Loot Objective");
        this.setAuthor("XiaoMoMi");
        this.setItem("COD", (short) 0);
        this.setShowCount(true);
        this.setCountPrompt("Set the amount of loots");
        this.setDisplay("%Obj Name%: %count%");
        this.addStringPrompt("Loot ID", "Enter the id of the loot", "rubbish");
    }

    @EventHandler
    public void onFish(FishingResultEvent event) {
        if (event.isCancelled() || event.getResult() == FishingResultEvent.Result.FAILURE)
            return;
        for (Quest quest : qp.getQuester(event.getPlayer().getUniqueId()).getCurrentQuests().keySet()) {
            Map<String, Object> map = getDataForPlayer(event.getPlayer().getUniqueId(), this, quest);
            if (map == null) {
                continue;
            }
            if (event.getAmount() > 0) {
                Loot loot = event.getLoot();
                String userInput = (String) map.get("Loot ID");
                if (userInput.equals(loot.id())) {
                    incrementObjective(event.getPlayer().getUniqueId(), this, quest, event.getAmount());
                }
            }
        }
    }
}