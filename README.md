# Survival-Boardgame

***Projet de JAVA - JEU DE SOCIÉTÉ SUR LA PRÉSERVATION DE L’ENVIRONNEMENT***

**Introduction**

Pour répondre aux attendus du thème : la préservation de notre environnement, nous avons
développé un jeu de société inspiré des jeux Monopoly et Risk.

L’idée ici est de sensibiliser le joueur à l’utilisation d’énergies renouvelables aux dépens des énergies
fossiles dont les quantités sont limitées. En effet, depuis la révolution industrielle, l’énergie fossile
représente une importante part de l’énergie totale consommée (elle atteint 80% de nos jours). La
surconsommation de ces énergies inquiète. Beaucoup de scientifiques s’accordent à dire que cette
surconsommation a des conséquences dramatiques sur le dérèglement climatique que nous sommes
actuellement en train de vivre et qui continue, malheureusement, avec le temps à s’empirer car peu
d’actions durables sont mises en place. Éduquer la population est donc un atout nécessaire pour
préserver notre Terre.

**Le jeu**

Ainsi, le but de ce jeu est d’utiliser durant trois tours successifs uniquement des énergies renouvelables
et d’atteindre un taux de pollution global inférieur à 10.

Le nombre de participants est d’au moins 2 joueurs. Pour une partie de 30 minutes environ, comptez
plutôt entre 2 et 6 joueurs.

Le déroulement du jeu suit le schéma suivant :

Chaque joueur doit s’occuper de cinq zones qui lui sont attribuées de manière aléatoire en début de partie. Une zone a des caractéristiques qui lui sont propres et peut-être un désert, une ville, un littoral ou alors une montagne.

À chaque tour, un menu est proposé au joueur :

- Produire de la nourriture pour subvenir aux besoins de sa population, pour cela il doit
produire de l’énergie. L’enjeu est de produire suffisamment d’énergie pour nourrir sa population tout
en veillant à maintenir un taux de pollution bas. Ainsi, le joueur est tenté d’utiliser les énergies
renouvelables. Pour débloquer l’utilisation de ses énergies renouvelables, le quotient intellectuel de sa
population doit atteindre 120. Pour cela, il faut qu’il gagne en expérience (points xp). L’expérience
s’acquiert en produisant de l’énergie qui est dans un premier temps fossile. Le challenge du joueur est
donc de savoir gérer correctement sa production d’énergie sans pour autant augmenter son taux de
pollution globale jusqu’au seuil de 80 points.
- Échanger avec un autre joueur ses ressources
- Pour chaque zone, le taux de pollution est vérifié. On fait appel aux fonctions qui régénèrent
l’argent du joueur, sa matière première (celle qui servira à produire nourriture et celle qui servira à la
construction les éoliennes, turbines et panneaux solaires).
- Un tirage aléatoire de catastrophes naturelles et politiques qui peuvent survenir dans une des
zones du joueur est effectué.

À la fin de chaque tour, l’ordinateur vérifie si le joueur est toujours en course ou s’il a éventuellement
gagné.

*Le gagnant doit :*

- Utiliser pendant trois tours successifs des énergies renouvelables
- Taux de pollution global inférieur à 10

*Le joueur perd s’il remplit une de ces deux conditions :*

- Taux de pollution global supérieur à 80 dans une de ses zones
- Une zone n’ayant aucun habitant

**UML:**

![alt text](https://github.com/AOZakari/Survival-Boardgame/blob/master/UML%20Project.gif)
