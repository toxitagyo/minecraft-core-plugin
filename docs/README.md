# Documentation - Minecraft Core Plugin

Bienvenue dans la documentation complète du **Minecraft Core Plugin**.

## 📚 Sommaire

1. [Installation](../INSTALL.md)
2. [Guide d'Utilisation](#guide-dutilisation)
3. [Modules](#modules)
4. [Configuration](#configuration)
5. [API pour Développeurs](#api-pour-développeurs)
6. [FAQ](#faq)

## Guide d'Utilisation

### Commandes Principales

#### Module Économie
```
/money                          - Affiche votre solde
/bank balance                   - Affiche votre solde bancaire
/bank deposit <montant>         - Dépôt d'argent
/bank withdraw <montant>        - Retrait d'argent
/shop                           - Ouvre la boutique
/teambalance                    - Affiche le solde des équipes
/showranking                    - Affiche le classement des équipes
```

#### Module Social
```
/team <joueur>                  - Affiche l'équipe d'un joueur
/party create                   - Crée une nouvelle partie
/party invite <joueur>          - Invite un joueur
/party leave                    - Quitter la partie
/party list                     - Lister les membres de la partie
/quest accept <quête>           - Accepter une quête
/quest list                     - Lister les quêtes disponibles
/quest complete <quête>         - Compléter une quête
```

#### Module Survie
```
/thirst                         - Affiche votre niveau de soif
/temperature                    - Affiche votre température
```

#### Module Utilitaires
```
/enderstorage                   - Ouvre votre Ender Storage
/chunkloader place              - Place un chunk loader
/chunkloader remove             - Supprime un chunk loader
/chunkloader list               - Liste vos chunk loaders
/revive <joueur>                - Réanime un joueur
```

#### Module Affichage
```
/updateholograms                - Met à jour les hologrammes
```

## Modules

### 1. Module Économie (`/economy`)

**Fonctionnalités:**
- Gestion des soldes des joueurs
- Comptes bancaires avec dépôts/retraits
- Système de boutique avec achat/vente d'items
- Calcul des intérêts bancaires
- Frais de transaction optionnels

**Configuration:** `config/economy.yml`

**Fichiers clés:**
- `EconomyManager.java` - Gestion centrale de l'économie
- `MoneyCommand.java` - Commande /money
- `BankCommand.java` - Commande /bank
- `ShopCommand.java` - Commande /shop
- `EconomyListener.java` - Événements économiques

### 2. Module Social (`/social`)

**Fonctionnalités:**
- Gestion des équipes et groupes de joueurs
- Parties coopératives (Party)
- Quêtes de groupe avec récompenses partagées
- Chat d'équipe privé
- Système d'invitations

**Configuration:** `config/social.yml`

**Fichiers clés:**
- `SocialManager.java` - Gestion centrale du social
- `TeamCommand.java` - Gestion des équipes
- `PartyCommand.java` - Gestion des parties
- `SocialListener.java` - Événements sociaux

### 3. Module Survie (`/survival`)

**Fonctionnalités:**
- Système de soif avec jauge dynamique
- Gestion de la température (chaud/froid)
- Difficulté adaptative progressive
- Nuit de Sang rare avec multiplicateurs de monstres
- Impact environnemental sur les joueurs

**Configuration:** `config/survival.yml`

**Fichiers clés:**
- `SurvivalManager.java` - Gestion centrale de la survie
- `ThirstCommand.java` - Gestion de la soif
- `TemperatureCommand.java` - Gestion de la température

### 4. Module Utilitaires (`/utility`)

**Fonctionnalités:**
- Ender Storage avec codes couleurs 3-bandes
- Chunk Loader pour maintenir les fermes actives
- Système de sommeil amélioré
- Réanimation des joueurs avec items de soin
- Portages des ender pouches

**Configuration:** `config/utility.yml`

**Fichiers clés:**
- `UtilityManager.java` - Gestion centrale des utilitaires
- `EnderStorageCommand.java` - Gestion du stockage Ender
- `ChunkLoaderCommand.java` - Gestion des chunk loaders
- `ReviveCommand.java` - Réanimation des joueurs

### 5. Module Affichage (`/displays`)

**Fonctionnalités:**
- Hologrammes flottants dynamiques
- Classements visuels des équipes
- Affichage des infos de boutique
- Textes flottants persistants

**Configuration:** `config/displays.yml`

**Fichiers clés:**
- `DisplayManager.java` - Gestion centrale des affichages
- `UpdateHologramsCommand.java` - Mise à jour des hologrammes

## Configuration

### Fichiers de Configuration

Tous les fichiers se trouvent dans `/plugins/MinecraftCorePlugin/`:

- **economy.yml** - Soldes, intérêts, boutique
- **social.yml** - Équipes, parties, quêtes
- **survival.yml** - Soif, température, Blood Moon
- **utility.yml** - Ender Storage, Chunk Loader, Revive
- **displays.yml** - Hologrammes, classements

### Exemple de Modification

Pour augmenter le solde initial:

```yaml
# config/economy.yml
starting-balance: 2000.0  # Au lieu de 1000.0
```

Puis rechargez le serveur: `/reload confirm` (si supporté)

## API pour Développeurs

### Accéder aux Managers

```java
import fr.toxitagyo.plugin.MinecraftCorePlugin;

// Obtenir l'instance du plugin
MinecraftCorePlugin plugin = MinecraftCorePlugin.getInstance();

// Accéder aux managers
EconomyManager economy = plugin.getEconomyManager();
SocialManager social = plugin.getSocialManager();
SurvivalManager survival = plugin.getSurvivalManager();
UtilityManager utility = plugin.getUtilityManager();
DisplayManager display = plugin.getDisplayManager();
```

### Utiliser l'API Économie

```java
Player player = Bukkit.getPlayer("NomJoueur");

// Récupérer le solde
double balance = economy.getPlayerBalance(player);

// Ajouter de l'argent
economy.addBalance(player, 100.0);

// Retirer de l'argent
economy.removeBalance(player, 50.0);

// Définir un solde exact
economy.setPlayerBalance(player, 500.0);
```

### Utiliser l'API Social

```java
// Obtenir l'équipe d'un joueur
String team = social.getPlayerTeam(player.getUniqueId());

// Définir l'équipe d'un joueur
social.setPlayerTeam(player.getUniqueId(), "Red");
```

## FAQ

### Q: Peut-on utiliser le plugin sur une version autre que 1.20.1?
**R:** Le plugin est développé pour 1.20.1, mais peut fonctionner avec des versions proches (1.19.x, 1.20.x). Testez d'abord sur un serveur de test.

### Q: Comment ajouter de nouveaux items à la boutique?
**R:** Modifiez `config/economy.yml` et ajoutez des entrées dans la section `shop.items`.

### Q: Comment créer une nouvelle quête de groupe?
**R:** Utilisez `/quest create` (en développement). Pour l'instant, les quêtes doivent être codées manuellement.

### Q: Les données sont-elles sauvegardées automatiquement?
**R:** Oui, à chaque redémarrage du serveur et tous les 30 minutes.

### Q: Comment désactiver un module?
**R:** Dans le fichier de config du module, réglez `enabled: false`.

### Q: Puis-je utiliser ce plugin sur un serveur multi-monde?
**R:** Oui, certains modules supportent les mondes multiples. Vérifiez la configuration `forbidden-worlds`.

---

**Besoin d'aide?** Consultez les [issues du projet](https://github.com/toxitagyo/minecraft-core-plugin/issues) ou créez une nouvelle question!
