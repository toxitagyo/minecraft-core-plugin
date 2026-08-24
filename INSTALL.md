# Guide d'Installation - Minecraft Core Plugin

## Prérequis

- **Java 11+** installé sur votre système
- **Maven 3.6+** ou **Gradle 7.0+** pour compiler
- **Serveur Minecraft Spigot/Bukkit** version 1.20.1 ou compatible
- 100MB d'espace disque minimum

## Étapes d'Installation

### 1. Cloner le Repository

```bash
git clone https://github.com/toxitagyo/minecraft-core-plugin.git
cd minecraft-core-plugin
```

### 2. Compiler le Plugin

**Avec Maven:**
```bash
mvn clean package
```

**Avec Gradle:**
```bash
./gradlew build
```

Le fichier JAR compilé sera disponible dans:
- Maven: `target/minecraft-core-plugin-1.0.0.jar`
- Gradle: `build/libs/minecraft-core-plugin-1.0.0.jar`

### 3. Installation sur le Serveur

```bash
cp target/minecraft-core-plugin-1.0.0.jar /chemin/vers/serveur/plugins/
```

### 4. Redémarrer le Serveur

```bash
# Arrêter le serveur
# Puis redémarrer
java -Xmx1024M -Xms1024M -jar spigot-1.20.1.jar nogui
```

### 5. Vérifier l'Installation

Consultez les logs du serveur:
```bash
tail -f logs/latest.log | grep "MinecraftCore"
```

Vous devez voir:
```
[INFO] Minecraft Core Plugin en cours de chargement...
[INFO] Module Économie chargé
[INFO] Module Social chargé
[INFO] Module Survie chargé
[INFO] Module Utilitaires chargé
[INFO] Module Affichage chargé
[INFO] ✓ Minecraft Core Plugin activé avec succès!
```

## Configuration Post-Installation

Après le premier lancement, les fichiers de configuration sont créés dans:
```
/plugins/MinecraftCorePlugin/
├── economy.yml
├── social.yml
├── survival.yml
├── utility.yml
└── displays.yml
```

Modifiez ces fichiers selon vos besoins, puis relancez le serveur.

## Dépannage

### Le plugin ne se charge pas
- Vérifiez que Java 11+ est installé: `java -version`
- Vérifiez les permissions du fichier JAR: `chmod +x minecraft-core-plugin-1.0.0.jar`
- Consultez les logs pour les erreurs spécifiques

### Erreur "Plugin failed to load"
- Assurez-vous que la version de Spigot est compatible (1.20.1+)
- Vérifiez que le fichier n'est pas corrompu
- Récompillez le plugin: `mvn clean package`

### Les commandes ne fonctionnent pas
- Rechargez le plugin: `/reload confirm` (optionnel)
- Vérifiez les permissions: `/perms <joueur> <commande>`
- Consultez le fichier `plugin.yml` pour les commandes disponibles

## Support

Pour toute question ou problème:
1. Consultez la [documentation](./docs/)
2. Vérifiez les [issues existantes](https://github.com/toxitagyo/minecraft-core-plugin/issues)
3. Créez une nouvelle issue si nécessaire
