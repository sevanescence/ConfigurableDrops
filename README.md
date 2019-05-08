# ConfigurableDrops

### About ConfigurableDrops

ConfigurableDrops gives the user a way to set custom item and experience drops from any specified mob that is supported by their client version. The user will be able to set a custom experience drop but keep the same vanilla item drops, and vise versa.

### Structure

src
- java
  - io.github.makotomiyamoto.ConfigurableDrops
    - ConfigurableDrops.java
    - MobDrop.java (Object)
    - EntityDeathEvent.java
    - EntityKilledEvent.java
- resources
  - plugin.yml
  - config.yml
  - aliases.yml
  
### To Do List

- [ ] Start the project
- [ ] Complete get[datatype]Variables methods
  - [ ] Numbers
  - [ ] Booleans
  - [ ] Strings
  - [ ] String-Lists
- [ ] Complete Variables formatting
- [ ] Complete getItemMetaTemplates method
- [ ] Complete getItemTemplates method
- [ ] Complete getMobDrops method

### Lists (subject to change)

- HashMap<String, Double> Numbers
- HashMap<String, Boolean> Booleans
- HashMap<String, String> Strings
- HashMap<String, ArrayList<String>> StringLists
- HashMap<String, ItemMeta> ItemMetaTemplates
- HashMap<String, ItemStack> ItemTemplates
- HashMap<String, MobDrop> MobDrops

### Possible Future Features

- Custom block drops
