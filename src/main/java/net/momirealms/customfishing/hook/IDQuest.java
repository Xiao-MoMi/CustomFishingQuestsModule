package net.momirealms.customfishing.hook;

import me.blackvein.quests.CustomObjective;
import me.blackvein.quests.Quest;
import me.blackvein.quests.Quests;
import net.momirealms.customfishing.api.event.FishingResultEvent;
import net.momirealms.customfishing.api.mechanic.loot.Loot;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.Map;

public class IDQuest extends CustomObjective implements Listener {

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
            Map<String, Object> map = getDataForPlayer(event.getPlayer(), this, quest);
            if (map == null) {
                continue;
            }
            Loot loot = event.getLoot();
            String userInput = (String) map.get("Loot ID");
            if (userInput.equals(loot.getID())) {
                incrementObjective(event.getPlayer(), this, event.getAmount(), quest);
            }
        }
    }
}