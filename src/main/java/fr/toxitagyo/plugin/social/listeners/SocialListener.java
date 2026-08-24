package fr.toxitagyo.plugin.social.listeners;

import fr.toxitagyo.plugin.social.SocialManager;
import org.bukkit.event.Listener;

public class SocialListener implements Listener {
    private SocialManager socialManager;

    public SocialListener(SocialManager socialManager) {
        this.socialManager = socialManager;
    }
}
