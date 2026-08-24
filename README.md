# Minecraft Core Plugin

Un plugin Minecraft complet et modulaire offrant une expérience de jeu enrichie avec économie, social, survie et utilitaires avancés.

## 📋 Structure du Plugin

Le plugin est organisé en 5 modules principaux :

### 1. **Module Économie & Échanges** (`/economy`)
- Gestion des soldes individuels et d'équipe
- Comptes bancaires sécurisés
- Interface de boutique (achat/vente d'items)
- Commandes : `/money`, `/bank`, `/shop`

### 2. **Module Social & Communauté** (`/social`)
- Gestion des équipes inter-joueurs
- Chat d'équipe
- Objectifs de groupe coopératifs (Party Quests)
- Commandes : `/team`, `/party`, `/quest`

### 3. **Module Survie & Immersion** (`/survival`)
- Système de soif (Thirst)
- Gestion de la température
- Difficulté adaptative (Dynamic Difficulty)
- Événements rares (Blood Moon)

### 4. **Module Confort & Utilitaires** (`/utility`)
- Ender Storage avec codes couleurs
- Chunk Loader pour maintenir les fermes
- Système de sommeil amélioré
- Système de réanimation des joueurs

### 5. **Module Visuel** (`/displays`)
- Hologrammes flottants dynamiques
- Classements et infos de boutique
- Affichage des règles

## 🚀 Installation

1. Clonez ce repository
2. Buildez le plugin avec Maven ou Gradle
3. Placez le JAR dans le dossier `plugins/` de votre serveur
4. Redémarrez le serveur

## ⚙️ Configuration

Chaque module dispose d'un fichier `config.yml` dédié dans le dossier `config/`.

- `config/economy.yml` : Configuration de l'économie
- `config/social.yml` : Configuration des équipes et parties
- `config/survival.yml` : Configuration de la survie
- `config/utility.yml` : Configuration des utilitaires
- `config/displays.yml` : Configuration des hologrammes

## 📝 Commandes Principales

| Commande | Description |
|----------|-------------|
| `/money` | Affiche votre solde |
| `/bank` | Gère vos comptes bancaires |
| `/shop` | Ouvre la boutique |
| `/team <joueur>` | Affiche l'équipe d'un joueur |
| `/party create` | Crée une partie |
| `/quest accept <quête>` | Accepte une quête de groupe |

## 🔧 Dépendances Externes

Pour une meilleure expérience, les plugins suivants sont recommandés :
- **Simple Voice Chat** : Système vocal premium
- **Waystones** : Téléportation par portails

## 📄 Licence

Ce plugin est disponible gratuitement pour usage personnel et serveurs.

---

Pour toute question ou contribution, consultez la documentation complète dans le dossier `/docs`.