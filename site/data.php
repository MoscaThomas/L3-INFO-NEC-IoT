<?php
// Informations d'identification pour la base de données
$hostname = "mysql";  // Nom d'hôte du serveur MySQL
$username = "root";  // Nom d'utilisateur MySQL
$password = "root";  // Mot de passe

// Nom de la base de données à laquelle se connecter
$database = "IOT";

// Connexion à la base de données avec l'interface PDO
$pdo = new PDO("mysql:host=$hostname;dbname=$database", $username, $password);

// Requête SQL pour récupérer les dernières données
$query = "SELECT * FROM fluctuation ORDER BY id DESC LIMIT 1";
$stmt = $pdo->prepare($query);
$stmt->execute();

// Récupération des données et envoi en format JSON
$data = $stmt->fetch(PDO::FETCH_ASSOC);
echo json_encode($data);

