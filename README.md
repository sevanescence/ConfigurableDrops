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

- [x] Start the project
- [x] Complete get[datatype]Variables methods
  - [x] Numbers
  - [x] Booleans
  - [x] Strings
  - [x] String-Lists
- [x] Complete Variables formatting
- [ ] Complete getItemMetaTemplates method
- [ ] Complete getItemTemplates method
- [ ] Complete getMobDrops method
- [ ] Ampersand color code support (all methods and lists)
  - replace all & with §
- [ ] check if text is only a variable OR contains variable(s)
- [ ] non-existent variable casts should return NullException, but plain text.
  - if string-list, create a list with only the defined string.
- [ ] if string-list is defined in a single-string line, join entire list with |.
- [ ] if string is defined in numerical or boolean input, return 0 or false.
- [ ] if number is defined in boolean input, return true (1) or false (0)
- [ ] if boolean is defined in numerical input, return 1 (true) or 0 (false)

### Lists (subject to change)

- HashMap<String, Double> Numbers
- HashMap<String, Boolean> Booleans
- HashMap<String, String> Strings
- HashMap<String, ArrayList<String>> StringLists
- HashMap<String, ItemMeta> ItemMetaTemplates
- HashMap<String, ItemStack> ItemTemplates
- HashMap<String, MobDrop> MobDrops

### List load order

- Numbers
- Booleans
- Strings
- StringLists
- ItemMetaTemplates
- ItemTemplates
- MobDrops (itemstack, experience)

### Possible Future Features

- Mob drop parameters
- Custom block drops
- Block drop parameters

### Variable casting

###### All variables are called in %placeholders%

  ###### config:
    variables:
      strings:
        example-string: Hello!
        
    toPrint: %(string)example-string%
    
    output: "Hello!"
