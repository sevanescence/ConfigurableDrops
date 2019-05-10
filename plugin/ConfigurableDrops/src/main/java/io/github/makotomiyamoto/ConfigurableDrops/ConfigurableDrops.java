package io.github.makotomiyamoto.ConfigurableDrops;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;

public class ConfigurableDrops extends JavaPlugin {

    private HashMap<String, Number> Numbers;
    private HashMap<String, Boolean> Booleans;
    private HashMap<String, String> Strings;
    private HashMap<String, ArrayList<String>> StringLists;

    @Override
    public void onEnable() {

        this.saveDefaultConfig();

        Numbers = getNumbers();

        Booleans = getBooleans();

        Strings = getStrings();

        StringLists = getStringLists();

    }

    private void debug(String string) {
        if (this.getConfig().getBoolean("debug-mode")) {
            System.out.println("[ConfigurableDrops] debug: " + string);
        }
    }

    private void error(String string) {
        System.out.println("[ConfigurableDrops] ERROR: " + string);
    }

    private HashMap<String, Number> getNumbers() {

        ConfigurationSection numbers = this.getConfig().getConfigurationSection("variables.numbers");

        if (numbers == null) {

            debug("variables.numbers is undefined.");

            return new HashMap<String, Number>();

        }

        debug("variables.numbers exists!");

        HashMap<String, Number> numberHashMap = new HashMap<String, Number>();

        debug("scanning numbers...");

        for (String key : numbers.getKeys(false)) {

            debug("key item: variables.numbers." + key);

            if (numbers.get(key) == null) {

                error(key + " in " + numbers.getCurrentPath() + " is undefined.");

                continue;

            }

            debug(key + " from " + numbers.getCurrentPath() + " added to numberHashMap!");

            numberHashMap.put("(number)" + key, numbers.getDouble(key));

        }

        return numberHashMap;

    }

    private HashMap<String, Boolean> getBooleans() {

        ConfigurationSection booleans = this.getConfig().getConfigurationSection("variables.booleans");

        if (booleans == null) {

            debug("variables.booleans is undefined.");

            return new HashMap<String, Boolean>();

        }

        debug("variables.booleans exists!");

        HashMap<String, Boolean> booleanHashMap = new HashMap<String, Boolean>();

        debug("scanning booleans...");

        for (String key : booleans.getKeys(false)) {

            debug("on item variables.booleans." + key);

            if (booleans.get(key) == null) {

                error(key + " in " + booleans.getCurrentPath() + " is undefined.");

                continue;

            }

            debug(key + " from " + booleans.getCurrentPath() + " added to booleanHashMap!");

            booleanHashMap.put("(boolean)" + key, booleans.getBoolean(key));

        }

        return booleanHashMap;

    }

    private HashMap<String, String> getStrings() {

        ConfigurationSection strings = this.getConfig().getConfigurationSection("variables.strings");

        if (strings == null) {

            debug("variables.strings is undefined.");

            return new HashMap<String, String>();

        }

        debug("variables.strings exists!");

        HashMap<String, String> stringHashMap = new HashMap<String, String>();

        debug("scanning variables.strings...");

        for (String key : strings.getKeys(false)) {

            debug("on item variables.strings." + key);

            if (strings.get(key) == null) {

                error(key + " in " + strings.getCurrentPath() + " is undefined.");

                continue;

            }

            String string = strings.getString(key);

            if (string != null && string.contains("&")) {

                string = string.replaceAll("&", "§");

            }

            debug(key + " from " + strings.getCurrentPath() + " added to stringHashMap!");

            stringHashMap.put("(string)" + key, string);

        }

        return stringHashMap;

    }

    private HashMap<String, ArrayList<String>> getStringLists() {

        ConfigurationSection stringLists = this.getConfig().getConfigurationSection("variables.string-lists");

        if (stringLists == null) {

            debug("variables.string-lists is undefined.");

            return new HashMap<String, ArrayList<String>>();

        }

        debug("variables.string-lists exists!");

        HashMap<String, ArrayList<String>> listHashMap = new HashMap<String, ArrayList<String>>();

        debug("scanning variables.string-lists...");

        for (String key : stringLists.getKeys(false)) {

            if (stringLists.getList(key) == null) {

                error(key + " in " + stringLists.getCurrentPath() + " is undefined.");

                continue;

            }

            ArrayList<String> arrayList = new ArrayList<String>(stringLists.getStringList(key));

            for (int loopIndex = 0; loopIndex < arrayList.size(); loopIndex++) {

                if (arrayList.get(loopIndex).contains("&")) {

                    arrayList.set(loopIndex, arrayList.get(loopIndex).replaceAll("&", "§"));

                }

            }

            listHashMap.put("(string-list)" + key, arrayList);

        }

        return listHashMap;

    }

}
