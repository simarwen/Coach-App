# Coach App - Calculateur d'Indice de Masse Grasse (IMG)

## Description

Coach App est une application Android simple et intuitive conçue pour vous aider à calculer votre Indice de Masse Grasse (IMG). 
L'application permet de suivre facilement votre progression en enregistrant vos données et vos résultats.

**Fonctionnalités principales :**

*   **Calcul de l'IMG :**
    *   Saisie facile des données nécessaires : poids, taille, âge et genre.
    *   Calcul instantané de l'IMG basé sur les informations fournies.
    *   Affichage clair et précis du résultat de l'IMG.
*   **Sauvegarde et Récupération des Données :**
    *   **Sérialisation :** Les informations saisies et les résultats de l'IMG sont enregistrés à l'aide de la sérialisation, permettant de conserver les données entre les sessions de l'application.
    *   **SQLite :** Les données sont également stockées dans une base de données SQLite pour une gestion structurée et persistante. Cela permet de conserver un historique des calculs effectués.



## Technologies Utilisées

*   **Langage de programmation :** Java 
*   **Framework :** Android SDK
*   **Stockage des Données :**
    *   Sérialisation  Serializable
    *   Base de données SQLite

## Comment Utiliser l'Application

1.  Lancez l'application Coach App sur votre appareil Android.
2.  Sur l'écran de calcul de l'IMG, entrez votre poids, votre taille, votre âge et sélectionnez votre genre.
3.  Appuyez sur le bouton de calcul.
4.  Votre IMG sera affiché.
5.  Les données et résultats seront automatiquement enregistrés pour une utilisation ultérieure (grâce à la sérialisation et à SQLite).

## Instructions d'Installation

*   **Depuis le code source (développement) :**
    1.  Clonez le dépôt GitHub : `git clone https://github.com/simarwen/Coach-App.git`
    2.  Ouvrez le projet dans Android Studio.
    3.  Compilez et exécutez l'application sur un émulateur ou un appareil Android.



