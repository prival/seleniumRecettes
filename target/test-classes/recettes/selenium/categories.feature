Feature: Teste la gestion des catégories

Background: Aller sur l'écran d'admin et se connecter en admin
Given l'utilisateur va sur l'application
And il va sur l'admin
And il se connecte en admin

# TODO : pas la peine d'avoir le background pour cette tâche
Scenario: Supprime toutes les catégories directement en db
Given toutes les categories supprimées

Scenario Outline: l'admin ajoute une catégorie
Given l'admin va sur la gestion des catégories
    When il créé la catégorie <libelle>
    Then la catégorie <libelle> est enregistrée en base avec comme ordre <ordre>
    And la categorie <libelle> est affichée dans la liste des résultats

Examples:
|   libelle|ordre|
|   Entrées|    1|
|     Plats|    2|
|  Desserts|    3|

Scenario Outline: l'admin modifie une catégorie
Given l'admin va sur la gestion des catégories
    When il modifie la categorie <ancien_libelle> en <nouveau_libelle>
    Then la categorie <old_libelle> est supprimée en base
    And la catégorie <nouveau_libelle> est enregistrée en base avec comme ordre <ordre>
    And la categorie <nouveau_libelle> est affichée dans la liste des résultats
    And la categorie <nouveau_libelle> est la première affichée dans le menu

Examples:
|ancien_libelle|nouveau_libelle|ordre|
|       Entrées|       Fromages|    1|

Scenario Outline: l'admin supprime une catégorie
Given l'admin va sur la gestion des catégories
    When il supprime la catégorie <libelle>
    Then la categorie <libelle> est supprimée en base
    And la catégorie <libelle> n'est plus affichée dans le menu

Examples:
|   libelle|
|  Fromages|
