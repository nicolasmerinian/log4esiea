# Log4Esiea - Projet de Design Objet - NGUYEN, MERINIAN, OZADANIR
Framework de Logging

Dans le dossier /src, on trouve un fichier config.properties dans lequel on peut paramétrer différentes fonctionnalités.
Par exemple, pour obtenir des fichiers logs, il faut paramétrer comme ceci:
appender.file=TRUE (ligne 4 du fichier config.properties).

A l'exécution du programme, dès lors que l'on passe par un niveau de log (par exemple logger.debug, logger.warn, logger.error etc.), le fichier log est mis à jour.
On trouve également les foncitonnalités appender.console et appender.database qui foncitonnent de la même manière, respectivement avec la console et le système de gestion de base de données MySQL.

On peut configurer le niveau de logging (ALL/TRACE/DEBUG/INFO/WARN/ERROR/FATAL/OFF) en changeant la valeur de la variable "level" (ligne 10 du fichier config.properties), par défaut, il accepte tous les niveaux de logging.

Enfin, la date et l'heure sont au format dd/MM/yyyy hh:mm:ss, que l'on peut changer à la ligne 26 du fichier config.properties.
