# Guide de Contribution

Merci de votre intérêt pour contribuer à **Minecraft Core Plugin**! 🎮

## Code de Conduite

Soyez respectueux, constructif et inclusif. Les contributions doivent maintenir une qualité de code élevée.

## Comment Contribuer

### 1. Fork du Repository

```bash
git clone https://github.com/YOUR_USERNAME/minecraft-core-plugin.git
cd minecraft-core-plugin
```

### 2. Créer une Branche

```bash
git checkout -b feature/ma-fonctionnalite
# ou pour un bug fix
git checkout -b bugfix/description-du-bug
```

### 3. Développer et Tester

- Suivez les conventions de code Java standard
- Assurez-vous que votre code compile: `mvn clean package`
- Testez vos changements sur un serveur de test
- Documentez votre code avec des commentaires clairs

### 4. Commiter vos Changements

```bash
git add .
git commit -m "feat: Description claire de votre changement"
```

**Format des messages de commit:**
- `feat:` pour une nouvelle fonctionnalité
- `fix:` pour un correctif de bug
- `docs:` pour les changements de documentation
- `refactor:` pour du refactoring de code
- `test:` pour ajouter ou modifier des tests

### 5. Pousser et Créer une Pull Request

```bash
git push origin feature/ma-fonctionnalite
```

Allez sur GitHub et créez une Pull Request avec:
- Une description claire de vos changements
- Les raisons de ces changements
- Toute information pertinente pour les tests

## Directives de Code

### Styles et Conventions

- **Nommage:** camelCase pour les variables/méthodes, PascalCase pour les classes
- **Indentation:** 4 espaces
- **Longueur des lignes:** Maximum 120 caractères
- **JavaDoc:** Documentez les méthodes publiques

### Exemple:

```java
/**
 * Récupère le solde d'un joueur.
 * 
 * @param player le joueur dont on veut le solde
 * @return le solde du joueur
 */
public double getPlayerBalance(Player player) {
    return playerBalances.getOrDefault(player.getUniqueId(), 1000.0);
}
```

## Structures à Respecter

Le plugin suit une architecture modulaire:

```
src/main/java/fr/toxitagyo/plugin/
├── economy/          # Module Économie
│   ├── EconomyManager.java
│   ├── commands/
│   └── listeners/
├── social/           # Module Social
├── survival/         # Module Survie
├── utility/          # Module Utilitaires
└── displays/         # Module Affichage
```

Si vous ajoutez une nouvelle fonctionnalité:
1. Créez le dossier dans le bon module
2. Créez une classe Manager si nécessaire
3. Ajoutez les commandes et listeners
4. Créez/mettez à jour la configuration

## Tests

Avant de soumettre une PR:

1. Compilez sans erreurs: `mvn clean package`
2. Testez sur un serveur local
3. Vérifiez qu'aucune régression n'est introduite
4. Documentez les changements comportementaux

## Signalement de Bugs

Si vous trouvez un bug:

1. Allez à [Issues](https://github.com/toxitagyo/minecraft-core-plugin/issues)
2. Cherchez si le bug est déjà rapporté
3. Si non, créez une nouvelle issue avec:
   - Un titre clair et descriptif
   - Une description détaillée du problème
   - Les étapes pour reproduire
   - Votre version de Minecraft/Spigot
   - Les logs d'erreur pertinents

## Licences

En contribuant, vous acceptez que vos changements soient sous la même licence que le projet.

## Questions?

N'hésitez pas à ouvrir une discussion ou une issue pour clarifier quoi que ce soit.

Merci de contribuer! 💪
