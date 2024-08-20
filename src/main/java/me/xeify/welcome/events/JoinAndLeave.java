 /* @author Xeify (Discord: Xeify)
  * 8/19/2024
  * me.xeify.welcome.events
  */
 package me.xeify.welcome.events;

 import me.xeify.welcome.Welcome;
 import me.xeify.welcome.utils.GeneralUtils;
 import org.bukkit.entity.Player;
 import org.bukkit.event.EventHandler;
 import org.bukkit.event.Listener;
 import org.bukkit.event.player.PlayerJoinEvent;

 import java.util.List;

 public class JoinAndLeave implements Listener {

   @EventHandler
  public void onPlayerJoin(PlayerJoinEvent e) {
    List<String> message = Welcome.INSTANCE.getConfig().getStringList("welcome-message");
    GeneralUtils.msg(e.getPlayer(), message);
   }

 }
