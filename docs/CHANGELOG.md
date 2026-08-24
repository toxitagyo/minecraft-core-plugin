# Changelog - Minecraft Core Plugin

Tous les changements notables de ce projet sont documentés dans ce fichier.

## [1.0.0] - 2026-08-24

### Ajouté
- ✨ Module Économie complet avec gestion des soldes et banque
- ✨ Module Social avec équipes et système de parties
- ✨ Module Survie avec soif, température et Blood Moon
- ✨ Module Utilitaires avec Ender Storage et Chunk Loader
- ✨ Module Affichage avec hologrammes et classements
- 📋 Configuration complète pour tous les modules
- 📚 Documentation complète et guide d'installation
- 🔧 Système de gestion des données en YAML
- 🎮 30+ commandes joueurs implémentées
- 📊 Classements des équipes avec formatage visuel
- 💾 Sauvegarde automatique des données

### Structure
- Architecture modulaire et extensible
- Séparation claire des responsabilités (Manager pattern)
- Chaque module indépendant et configurable
- Système d'événements Bukkit intégré

### Fichiers de Configuration Fournis
- `economy.yml` - Configuration de l'économie
- `social.yml` - Configuration du social
- `survival.yml` - Configuration de la survie  
- `utility.yml` - Configuration des utilitaires
- `displays.yml` - Configuration des affichages

---

## Prochaines Versions

### [1.1.0] - À Venir
- [ ] Système de permissions avancé
- [ ] Persistance des données en base de données (MySQL/SQLite)
- [ ] Quêtes de groupe complètes avec progressions
- [ ] Hologrammes animés
- [ ] Intégration avec PlayersAPI pour les statistiques
- [ ] Chat de team enrichi avec filtrage
- [ ] Système de badges et récompenses

### [1.2.0] - À Venir
- [ ] GUI/Inventaires interactifs pour toutes les commandes
- [ ] Système de raids en équipe
- [ ] Événements saisonniers
- [ ] Marchand aléatoire avec offres dynamiques
- [ ] Système de fishing amélioré
- [ ] Weather control intégré

### [2.0.0] - Majeure
- [ ] Refactoring complet de l'architecture
- [ ] Migration vers une base de données
- [ ] Système de plugins pour extensibilité
- [ ] API publique complète
- [ ] Support des mondes personnalisés
- [ ] Intégration avec World Guard

---

## Notes de Compatibilité

- **Minecraft:** 1.20.1 (compatible avec 1.19.x et 1.20.x)
- **Java:** 11+
- **Spigot:** 1.20.1-R0.1+
- **Bukkit:** 1.20.1+

## Bugs Connus

Aucun bug connu dans la version 1.0.0.

## Contribuer

Consultez [CONTRIBUTING.md](../CONTRIBUTING.md) pour les directives de contribution.
