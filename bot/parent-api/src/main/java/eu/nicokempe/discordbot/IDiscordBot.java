package eu.nicokempe.discordbot;

import com.google.gson.*;
import eu.nicokempe.discordbot.command.handler.ICommandManager;
import eu.nicokempe.discordbot.config.JsonConfig;
import eu.nicokempe.discordbot.module.IModuleLoader;
import eu.nicokempe.discordbot.update.UpdateTask;
import eu.nicokempe.discordbot.user.IDiscordUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import okhttp3.RequestBody;

import java.util.List;

public interface IDiscordBot {

    Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    void enable();

    void disable();

    void loadModules();

    long getGuildId();

    void setGuild(Guild guild);

    IModuleLoader getModuleLoader();

    Guild getGuild();

    JDA getJda();

    List<IDiscordUser> getUsers();

    IDiscordUser getUser(long id);

    ICommandManager getCommandManager();

    AuthKey getAuthKey();

    JsonConfig getConfig();

    UpdateTask getUpdateTask();

    static String generateString(int length) {
        StringBuilder result = new StringBuilder();
        while (result.length() < length)
            result.append(getChar());
        return result.toString();
    }

    private static char getChar() {
        int s = getInt("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".length());
        return "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(s - 1);
    }

    private static int getInt(int max) {
        return (int) Math.ceil(Math.random() * max);
    }

    @AllArgsConstructor
    @Getter
    class AuthKey {
        private final String key;
        private final long timestamp;
    }

}
