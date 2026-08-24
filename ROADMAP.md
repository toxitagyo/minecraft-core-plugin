# Roadmap - Minecraft Core Plugin

## Vision 🎯

Créer un plugin Minecraft complet et modulaire qui enrichit l'expérience de jeu avec des systèmes d'économie, social, survie et utilitaires, tout en restant hautement configurable et extensible.

## Phase 1: Foundation (✅ Complétée)

### v1.0.0 - Core Release
- [x] Structure modulaire de base
- [x] Manager pour chaque module
- [x] Système de configuration YAML
- [x] 5 modules principaux implémentés
- [x] 30+ commandes de base
- [x] Documentation complète
- [x] Setup d'installation

## Phase 2: Enhancement (En Cours)

### v1.1.0 - Advanced Features
- [ ] **Système de Permissions**
  - Intégration avec PermissionsEx
  - Permissions par commande et module
  - Rôles de joueurs customisés

- [ ] **Persistance des Données**
  - Support MySQL
  - Support SQLite
  - Migration de YAML vers DB
  - Sauvegarde cloud (optionnelle)

- [ ] **Quêtes Avancées**
  - Système de quête complet
  - Quêtes de groupe avec objectifs
  - Système de récompenses
  - Progression et statistiques

- [ ] **Hologrammes Améliorés**
  - Hologrammes animés
  - Effets visuels dynamiques
  - Textes interactifs
  - Classements en temps réel

### v1.2.0 - Quality of Life
- [ ] **Interfaces Graphiques**
  - GUI pour /shop
  - GUI pour /bank
  - GUI pour /party
  - Interface de configuration en jeu

- [ ] **Événements Dynamiques**
  - Blood Moon amélioré
  - Tempêtes rares
  - Raids d'équipe
  - Compétitions saisonnières

- [ ] **Économie Approfondie**
  - Système d'impôts
  - Marché joueur à joueur
  - Investissements
  - Salaires automatiques

- [ ] **Statistiques & Analytics**
  - Dashboard de statistiques
  - Graphiques de performance
  - Palmarès historiques
  - Exports de données

## Phase 3: Integration (Planifiée)

### v1.3.0 - Ecosystem
- [ ] **Intégration Externe**
  - Discord Webhook
  - Site web de statistiques
  - Mobile app companion
  - Discord bot intégré

- [ ] **World Guard Integration**
  - Zones protégées
  - Flags personnalisés
  - Permissions par région
  - Événements régionaux

- [ ] **Asynchrone Complète**
  - Chargement async des données
  - Base de données async
  - Opérations non-bloquantes
  - Performances optimisées

## Phase 4: Extensibilité (Horizon)

### v2.0.0 - API & Plugins
- [ ] **API Publique**
  - Événements personnalisés
  - Hooks de développeur
  - Documentation API
  - Exemples et tutoriels

- [ ] **Système de Plugins**
  - Charger des sous-modules
  - Module store officiel
  - Système de dépendances
  - Versioning

- [ ] **Scripting**
  - Support de scripts Lua
  - Console d'administration
  - Automation workflows
  - Event triggers

- [ ] **Performance Optimization**
  - Caching avancé
  - Compilation runtime
  - Memory optimization
  - Profiling tools

## Priorités Court Terme (3 mois)

1. **Database Integration** - MySQL et SQLite
2. **Advanced Quests** - Système complet de quêtes
3. **GUI Implementation** - Interfaces pour les commandes principales
4. **Performance Optimization** - Profiling et optimisation
5. **Documentation Enhancement** - Tutoriels vidéo et guides avancés

## Priorités Long Terme (6-12 mois)

1. **API Complète** - Permettre l'extension par tiers
2. **Intégrations Multiples** - Discord, Web, Mobile
3. **Système d'Événements** - PvE/PvP dynamiques
4. **Analytics Avancées** - Dashboards et rapports
5. **Version 2.0** - Refactoring majeur

## Feedback & Contributions 💬

- Les priorités peuvent changer selon le feedback de la communauté
- Les PRs sont toujours bienvenues!
- Consultez [CONTRIBUTING.md](../CONTRIBUTING.md) pour contribuer
- Ouvrez des [issues](https://github.com/toxitagyo/minecraft-core-plugin/issues) pour les suggestions

## Status des Modules

| Module | Status | Priorité | Prochaine Mise à Jour |
|--------|--------|----------|---------------------|
| Economy | ✅ Stable | Moyenne | v1.2.0 |
| Social | ✅ Stable | Haute | v1.1.0 |
| Survival | ✅ Stable | Moyenne | v1.2.0 |
| Utility | ✅ Stable | Basse | v1.3.0 |
| Displays | ✅ Stable | Moyenne | v1.1.0 |

---

**Dernière mise à jour:** 2026-08-24
