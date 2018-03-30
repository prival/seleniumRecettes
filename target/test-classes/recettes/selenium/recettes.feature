Feature: Teste la gestion des recettes

Background: Aller sur l'écran d'admin et se connecter en admin
Given l'utilisateur va sur l'application
And il va sur l'admin
And il se connecte en admin

# TODO : pas la peine d'avoir le background pour cette tâche
Scenario: Supprime toutes les recettes directement en db
Given toutes les recettes supprimées

Scenario Outline: ajoute une recette
    When l'admin choisit la categorie <categorie>
    And l'admin ajoute le titre de recette <titre>
    And l'admin ajoute l'ingredient <ingredient 1>
    And l'admin ajoute l'étape <etape 1>
    And l'admin enregistre la recette
    Then la recette <titre> est enregistrée en base avec comme ordre <ordre recette>
    And l'ingrédient <ingredient 1> est enregistré en base avec comme ordre <ordre ingredient>
    And l'étape <etape 1> est enregistrée en base avec comme ordre <ordre etape>
    And la recette <titre> apparait dans le menu sous la categorie <categorie>

Examples:
|categorie|titre|ingredient 1|     etape 1|ordre recette|ordre ingredient|ordre etape|
|    Plats|  Riz|         riz|Cuire le riz|            1|               1|          1|

#Scenario: modifie une recette
#Given l'admin consulte la recette <ancien titre>
#And il va sur l'édition de la recette <ancien titre>
#    When il modifie le titre <ancien titre> en <nouveau titre>
#    And il modifie l'ingrédient <ancien ingredient 1> en <nouvel ingredient 1>
#    And il ajoute l'ingrédient <ingredient 2>
#    And il ajoute l'étape <etape 2>
#    Then la recette <nouveau titre> est modifiée en base
#    And l'ingrédient <nouvel ingredient 1> est modifié en base
#    And l'ingrédient <ingredient 2> est enregistré en base
#    And l'étape <etape 2> est enregistrée en base
#    And la recette <nouveau titre> apparait dans le menu sous la categorie <categorie> avec le même ordre


#Examples:
#|categorie|ancien titre|nouveau titre|ancien ingredient 1|nouvel ingredient 1|ingredient 2|        etape 2|
#|    Plats|         Riz|  Riz au soja|                riz|        riz basmati|        soja|Ajouter le soja|
